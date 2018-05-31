package com.shigu.main4.item.processes;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguStorecatExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.exceptions.TbApiException;
import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.exceptions.TbTmcException;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.utils.TaobaoItemFetchService;
import com.shigu.main4.item.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.taobao.api.*;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.shigu.main4.item.exceptions.TbItemSynException.TbItemSynExceptionEnum.SHOP_DOES_NOT_EXIST;

@Service("taobaoItemSynProcess")
public class TaobaoItemSynProcessImpl implements TaobaoItemSynProcess {

    private static final Logger logger = LoggerFactory.getLogger(TaobaoItemSynProcessImpl.class);

    private static final Long SYN_ONE_SHOP_SIZE = 150L;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private TaobaoItemFetchService taobaoItemFetchService;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;

    @Autowired
    private ItemAddOrUpdateService itemAddOrUpdateService;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private TaobaoAuthProcess taobaoAuthProcess;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private ShiguStorecatMapper shiguStorecatMapper;

    final String field="taobao_item_ItemAdd,taobao_item_ItemUpshelf,taobao_item_ItemDownshelf,taobao_item_ItemDelete,taobao_item_ItemUpdate";

    @Override
    public void synOneItem(Long shopId, Long numIid, String nick) throws TbItemSynException {
        ShiguShop shop;
        if (shopId == null || (shop = shiguShopMapper.selectByPrimaryKey(shopId)) == null) {
            throw new TbItemSynException(SHOP_DOES_NOT_EXIST);
        }

        SynItem synItem = taobaoItemFetchService.fetchItem(shop, numIid, nick);

        // 下架检测
        ShiguGoodsSoldout soldout = new ShiguGoodsSoldout();
        soldout.setNumIid(numIid);
        soldout.setWebSite(synItem.getWebSite());
        soldout.setStoreId(shopId);
        soldout = shiguGoodsSoldoutMapper.selectOne(soldout);
        boolean hasItem;
        if (hasItem = soldout != null) {
            // 是否用户下架
            ShiguGoodsModified modified = new ShiguGoodsModified();
            modified.setItemId(soldout.getGoodsId());
            modified = shiguGoodsModifiedMapper.selectOne(modified);
            if (modified != null && modified.getHasModInstock() != null && modified.getHasModInstock() == 1) {
                // 用户下架的抛出异常
                throw new TbItemSynException("该商品已被用户下架。");
            }
            // 先上架
            try {
                itemAddOrUpdateService.systemUpItem(soldout.getGoodsId());
            } catch (ItemModifyException e) {
                throw new TbItemSynException(e.getMessage());
            }
            synItem.setGoodsId(soldout.getGoodsId());
        } else {
            // 上架检测
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setWebSite(synItem.getWebSite());
            tiny.setStoreId(shopId);
            tiny.setNumIid(numIid);
            tiny = shiguGoodsTinyMapper.selectOne(tiny);
            if (hasItem = tiny != null) {
                synItem.setGoodsId(tiny.getGoodsId());
            }
        }
        try {
            if (hasItem) {
                itemAddOrUpdateService.systemUpdateItem(synItem);
            } else {
                itemAddOrUpdateService.systemAddItem(synItem);
            }
        } catch (ItemModifyException e) {
            throw new TbItemSynException(e.getMessage());
        }
    }

    @Override
    public void synOneShop(Long shopId, String nick) throws TbItemSynException {
        ShiguShop shop;
        if (shopId == null || (shop = shiguShopMapper.selectByPrimaryKey(shopId)) == null)
            throw new TbItemSynException(SHOP_DOES_NOT_EXIST);

        // 统计数据
        SynOneShopState state = new SynOneShopState(shopId);

        // 提取本地商品ID， numIid
        Map<Long, ShiguGoodsTiny> tinyMap = Collections.emptyMap();
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(shop.getWebSite());
        tinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsExcelImpEqualTo(ItemFrom.TAOBAO.ordinal());
        List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, FieldUtil.codeFields("goods_id,num_iid,modified"));
        List<Long> localNumIids = Collections.emptyList();
        try {
            tinyMap = BeanMapper.list2Map(shiguGoodsTinies, "goodsId", Long.class);
            localNumIids = BeanMapper.getFieldList(shiguGoodsTinies, "numIid", Long.class);
        } catch (Exception ignored) {
        }

        // 本地架上商品修改情况
        Map<Long, ShiguGoodsModified> modifiedMap = Collections.emptyMap();
        if (!tinyMap.isEmpty()) {
            modifiedMap = getModified(new ArrayList<Long>(tinyMap.keySet()));
        }

        // 分页拉取淘宝出售中商品
        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
        request.setFields("approve_status,num_iid,title,nick,type,cid,pic_url,num,props,valid_thru,list_time,price,has_discount,has_invoice,has_warranty,has_showcase,modified,delist_time,postage_id,seller_cids,outer_id,sold_quantity");
        request.setPageSize(SYN_ONE_SHOP_SIZE);
        long pageNo = 1;
        ItemsOnsaleGetResponse response;
        List<Long> allTbInstock = new ArrayList<Long>();
        while (true) {
            request.setPageNo(pageNo++);
            try {
                response = executeTaobaoRequest(request, nick);
            } catch (Exception e) {
                state.setSessionInvalid();
                logger.error(shopId + "店铺session失效.");
                break;
            }
            if (response.getItems() == null)
                break;
            List<Item> items = response.getItems();


            try {
                // 每次重新生成一下本地商品的淘宝ID列表

                Map<Long, Item> itemMap = BeanMapper.list2Map(items, "numIid", Long.class);
                // 要处理的【淘宝商品ID表】
                List<Long> numIids = new LinkedList<Long>(itemMap.keySet());
                allTbInstock.addAll(numIids);

                // 1, 处理淘宝出售中但本地下架的商品， 如果被用户修改，忽略该商品，否则将本地商品上架。
                checkSoldoutItem(numIids, shopId, shop.getWebSite(), state);

                // 2, 淘宝出售中存在且本地架上存在, 如果淘宝最后修改时间不一致-->更新
                List<Long> instock = new ArrayList<Long>(localNumIids);
                instock.retainAll(numIids);
                for (Map.Entry<Long, ShiguGoodsTiny> entry : tinyMap.entrySet()) {
                    ShiguGoodsTiny tiny = entry.getValue();
                    Long numIid = tiny.getNumIid();
                    Item item = itemMap.get(numIid);
                    if (instock.contains(numIid)) {
                        if (!tiny.getModified().equals(item.getModified())) {
                            try {
                                SynItem synItem = taobaoItemFetchService.fetchItem(shop, numIid, nick);
                                synItem.setGoodsId(tiny.getGoodsId());
                                itemAddOrUpdateService.systemUpdateItem(synItem);
                                state.addUpdated();
                            } catch (Exception me) {
//                                logger.error("更新商品错误：", me);
                                state.addErrorReason(numIid, me.getMessage());
                            }
                        } else {
                            state.addUnchanged();
                        }
                    }
                }

                // 3, 淘宝出售中存在但本地不存在-->创建
                numIids.removeAll(instock);
                for (Long numIid : numIids) {
                    try {
                        itemAddOrUpdateService.systemAddItem(taobaoItemFetchService.fetchItem(shop, numIid, nick));
                        state.addCreated();
                    } catch (ItemModifyException me) {
                        logger.error("上架错误：", me);
                        state.addErrorReason(numIid, me.getMessage());
                    }
                }
            } catch (Exception e) {
                logger.error("同步全店发生错误：", e);
            }
        }

        if (!state.isSessionInvalid()) {
            // 4, 本地架上有而淘宝出售中没有的，如果用户没有修改过，则下架，否则忽略
            List<Long> instock = new LinkedList<Long>(localNumIids);
            instock.removeAll(allTbInstock);

            for (Map.Entry<Long, ShiguGoodsTiny> entry : tinyMap.entrySet()) {
                Long numIid = entry.getValue().getNumIid();
                if (instock.contains(numIid)) {
                    Long goodsId = entry.getKey();
                    ShiguGoodsModified modified = modifiedMap.get(goodsId);
                    // 如果用户没有修改该商品（证明是程序同步过来的商品），则下架
                    if (modified == null || (modified.getHasModInstock() != null && modified.getHasModInstock() == 0)) {
                        try {
                            itemAddOrUpdateService.systemDownItem(goodsId);
                            state.addDown();
                        } catch (ItemModifyException me) {
                            logger.error("下架错误：", me);
                            state.addErrorReason(numIid, me.getMessage());
                        }
                    } else {
                        // 淘宝来源的本地商品被用户修改了，并且已经不再淘宝出售中了，不做任何处理
                        state.addUnprocessed(numIid);
                    }
                }
            }
        }
        logger.info(state.toString());
        logger.info("全店同步"+state.toString());
    }

    /**
     * 淘宝接口请求执行器，返回确保成功执行
     * @param nick 昵称
     * @param request 请求
     * @param <E> 响应类型
     * @return 响应
     * @throws TbApiException 异常
     */
    private <E extends TaobaoResponse> E executeTaobaoRequest(BaseTaobaoRequest<E> request, String nick) throws TbApiException {
        SessionVO session = taobaoAuthProcess.getSession(APPKEY, nick);
        if (session == null)
            throw new TbApiException("用户SessionKey不存在");
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL, APPKEY, SECRET);

        E response;
        try {
            response = client.execute(request, session.getSession());
        } catch (ApiException e) {
            throw new TbApiException("淘宝接口调用失败：" + e.getMessage());
        }
        if (response.isSuccess()) {
            return response;
        } else throw new TbApiException("淘宝接口调用失败：" + response.getMsg() + ", " + response.getSubMsg());
    }

    /**
     * 1, 处理淘宝出售中但本地下架的商品， 如果被用户修改，忽略该商品，否则将本地商品上架。
     * @param numIids 淘宝出售中商品
     * @param shopId 店铺ID
     * @param webSite 分站
     * @param state
     * @throws Exception 处理异常
     */
    private void checkSoldoutItem(List<Long> numIids, Long shopId, String webSite, SynOneShopState state) throws Exception {
        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
        soldoutExample.setWebSite(webSite);
        soldoutExample.createCriteria().andStoreIdEqualTo(shopId).andNumIidIn(numIids);
        List<ShiguGoodsSoldout> shiguGoodsSoldouts
                = shiguGoodsSoldoutMapper.selectFieldsByExample(soldoutExample, FieldUtil.codeFields("goods_id,num_iid"));
        if (!shiguGoodsSoldouts.isEmpty()) {
            Map<Long, ShiguGoodsModified> modifiedMap
                    = getModified(BeanMapper.getFieldList(shiguGoodsSoldouts, "goodsId", Long.class));
            for (ShiguGoodsSoldout soldout : shiguGoodsSoldouts) {
                ShiguGoodsModified modified = modifiedMap.get(soldout.getGoodsId());
                if (modified != null && modified.getHasModInstock() != null && modified.getHasModInstock() == 1){
                    numIids.remove(soldout.getNumIid());
                    state.addUnprocessed(soldout.getNumIid());
                } else {
                    try {
                        itemAddOrUpdateService.systemUpItem(soldout.getGoodsId());
                        state.addUp();
                    } catch (ItemModifyException me) {
                        logger.error("上架错误：", me);
                        state.addErrorReason(soldout.getNumIid(), me.getMessage());
                    }
                }
            }
        }
    }

    @Override
    public void synOneShopAsyn(Long shopId, String nick) {
        //先把
        if(shopId==null||nick==null||"".equals(nick)){
            return;
        }
        redisIO.rpush("async_shop_key_inredis",new AsynShopVO(shopId,nick));
    }

    @Override
    public void repairStorecat(Long shopId, String nick) throws TbItemSynException {
        if (shopId == null)
            throw new TbItemSynException(SHOP_DOES_NOT_EXIST);

        SellercatsListGetRequest request = new SellercatsListGetRequest();
        request.setNick(nick);
        request.setFields("cid,parent_cid,name,pic_url,sort_order,type");

        SellercatsListGetResponse response;
        try {
            response = executeTaobaoRequest(request, nick);
        } catch (TbApiException e) {
            throw new TbItemSynException(e.getMessage());
        }

        if (response.getSellerCats() == null)
            return;

        Map<Long, SellerCat> catMap = Collections.EMPTY_MAP;
        try {
            catMap = BeanMapper.list2Map(response.getSellerCats(), "cid", Long.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 现存所有自定类目
        List<Long> scids = new ArrayList<Long>();

        for (Map.Entry<Long, SellerCat> entry : catMap.entrySet()) {
            SellerCat sellerCat = entry.getValue();
            Long scid = sellerCat.getCid() * 1000000 + shopId;
            scids.add(scid);

            // 如果本类目已经是父级类目，则该类目的父类目为0
            Long parentScid = 0L;

            boolean isNew;
            ShiguStorecat storecat = shiguStorecatMapper.selectByPrimaryKey(scid);
            if (isNew = storecat == null) {
                storecat = new ShiguStorecat();
                storecat.setScid(scid);
            }
            storecat.setScName(sellerCat.getName());
            storecat.setStoreId(shopId);
            storecat.setSortOrder(sellerCat.getSortOrder().intValue());
            storecat.setType(sellerCat.getType());
            storecat.setPicUrl(sellerCat.getPicUrl());
            storecat.setLastModifyTime(new Date());
            boolean isParentCat;
            // 不是父级类目的寻找父级类目
            if (!(isParentCat = sellerCat.getParentCid() == 0)) {
                SellerCat parentSellerCat = catMap.get(sellerCat.getParentCid());
                if (parentSellerCat != null) {
                    parentScid = parentSellerCat.getCid() * 1000000 + shopId;
                    storecat.setParentScName(parentSellerCat.getName());
                }
            }
            storecat.setParentScid(parentScid);
            storecat.setIsParent(isParentCat ? 1 : 0);
            if (isNew)
                shiguStorecatMapper.insertSelective(storecat);
            else
                shiguStorecatMapper.updateByPrimaryKeySelective(storecat);
        }

        // 删除所有本店已经不存在的类目
        if (!scids.isEmpty()) {
            ShiguStorecatExample storecatExample = new ShiguStorecatExample();
            storecatExample.createCriteria().andStoreIdEqualTo(shopId).andScidNotIn(scids);
            shiguStorecatMapper.deleteByExample(storecatExample);
        }
    }

    @Override
    public void repairGoodscat(Long shopId, String nick) throws TbItemSynException {
        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
        request.setFields("num_iid,seller_cids");

        ItemsOnsaleGetResponse response;
        try {
            response = executeTaobaoRequest(request, nick);
        } catch (TbApiException e) {
            throw new TbItemSynException(e.getMessage());
        }
        if (response.getItems() != null)
            for (Item item : response.getItems()) {
                SynItem synItem = itemAddOrUpdateService.selItemWithSynItem(item.getNumIid(), shopId);
                if (synItem != null) {
                    synItem.setCidAll(item.getSellerCids());
                    try {
                        itemAddOrUpdateService.systemUpdateItem(synItem);
                    } catch (ItemModifyException e) {
                        throw new TbItemSynException(e.getMessage());
                    }
                }
            }
    }

    @Override
    public void addToTmc(String nick) throws TbTmcException {
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL,
                APPKEY, SECRET);
        TmcUserPermitRequest req = new TmcUserPermitRequest();
        req.setTopics(field);
        TmcUserPermitResponse rsp = null;
        try {
            SessionVO sessionVO=taobaoAuthProcess.getSession(APPKEY,nick);
            if(sessionVO==null)
                throw new TbTmcException("获取session失败");
            rsp = client.execute(req, sessionVO.getSession());
            if(!rsp.isSuccess()){
                throw new TbTmcException(rsp.getBody());
            }
        } catch (ApiException e) {
            throw new TbTmcException(e.getErrMsg());
        }
    }

    @Override
    public void removeTmc(String nick) throws TbTmcException {
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL,
                APPKEY, SECRET);
        TmcUserCancelRequest req = new TmcUserCancelRequest();
        req.setNick(nick);
        req.setUserPlatform("tbUIC");
        TmcUserCancelResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            throw new TbTmcException(rsp.getBody());
        }
    }

    @Override
    public Map<String, TmcUserVO> listTmc(List<String> nicks) {
        Map<String,TmcUserVO> map=new HashMap<String, TmcUserVO>();
        for(String nick:nicks){
            TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL,
                    APPKEY, SECRET);
            TmcUserGetRequest req = new TmcUserGetRequest();
            req.setFields("user_platform,user_nick,user_id,is_valid,created,modified,group_name");
            req.setNick(nick);
            req.setUserPlatform("tbUIC");
            TmcUserGetResponse rsp = null;
            try {
                rsp = client.execute(req);
                map.put(nick, BeanMapper.map(rsp.getTmcUser(),TmcUserVO.class));
            } catch (ApiException e) {
                map.put(nick,null);
            }
        }
        return map;
    }

    private Map<Long, ShiguGoodsModified> getModified(List<Long> goodsIds) {
        if (!goodsIds.isEmpty()) {
            ShiguGoodsModifiedExample goodsModifiedExample = new ShiguGoodsModifiedExample();
            goodsModifiedExample.createCriteria().andItemIdIn(goodsIds);
            try {
                return BeanMapper.list2Map(shiguGoodsModifiedMapper.selectByExample(goodsModifiedExample), "itemId", Long.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.EMPTY_MAP;
    }

    public void downTbGoods(Long numIid, String nick) throws TbItemSynException {
        ItemUpdateDelistingRequest request = new ItemUpdateDelistingRequest();
        request.setNumIid(numIid);
        try {
            executeTaobaoRequest(request, nick);
        } catch (TbApiException e) {
            throw new TbItemSynException(e.getMessage());
        }
    }

}
