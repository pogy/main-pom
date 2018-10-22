package com.shigu.seller.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.opentae.data.mall.multibeans.GoodsStyleInfoBean;
import com.opentae.data.mall.multibeans.ShopStyleGoodsAggrBean;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.IndexShowService;
import com.shigu.main4.cdn.vo.StyleChannelVO;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.newservice.NewItemAddOrUpdateService;
import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.vo.OnsaleItem;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.NewPullSynItemVO;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.seller.bo.GoodsSkuBo;
import com.shigu.seller.vo.*;
import com.shigu.session.main4.ShopSession;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 店内商品修改服务
 * Created by zhaohongbo on 17/3/9.
 */
@Service
public class ShopItemModService {

    private static final Logger logger = Logger.getLogger(ShopItemModService.class);


    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    NewItemAddOrUpdateService newItemAddOrUpdateService;

    @Autowired
    SearchCategorySubMapper searchCategorySubMapper;

    @Autowired
    ShiguGoodsStyleMapper shiguGoodsStyleMappe;

    @Autowired
    ShiguCustomerStyleMapper shiguCustomerStyleMapper;

    @Autowired
    GoodsSendService goodsSendService;
    @Autowired
    GoodsCountForsearchMapper goodsCountForsearchMapper;
    @Autowired
    ItemSearchService itemSearchService;
    @Autowired
    ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;

    @Autowired
    ShiguStyleMapper shiguStyleMapper;

    @Autowired
    ShopsItemService shopsItemService;

    @Autowired
    private IndexShowService indexShowService;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;

    @Autowired
    private NewShowForCdnService newShowForCdnService;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    RedisIO redisIO;

    // 店铺风格处理队列redis标签
    private static final String SHOP_STYLE_HANDLER_QUEUE_INDEX = "shop_style_handler_queue_";

    @Transactional(rollbackFor = Exception.class)
    public void moreModify(List<NewPushSynItemBO> items) throws ItemModifyException {
        for(NewPushSynItemBO item:items){
            newItemAddOrUpdateService.userUpdateItem(item);
        }
    }
    /**
     * 淘宝来的商品,查numIid
     * @param goodsId
     * @param webSite
     * @return
     */
    public Long selNumiidByGoodsId(Long goodsId,String webSite){
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setWebSite(webSite);
        sgt.setGoodsId(goodsId);
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt,FieldUtil.codeFields("goods_id,num_iid,is_excel_imp"));
        if(sgt==null){
            return null;
        }
        if(0!=sgt.getIsExcelImp()){
            return null;
        }
        return sgt.getNumIid();
    }
    /**
     * 商品上架
     */
    public void upItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,true);
        for(Long id:ids){
            try {
                newItemAddOrUpdateService.userUpItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品上架失败",e);
            }
        }
    }

    /**
     * 商品下架
     * @param shopId
     * @param itemIds
     * @param webSite
     */
    public void downItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,false);
        for(Long id:ids){
            try {
                newItemAddOrUpdateService.userDownItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品下架失败",e);
            }
        }
    }

    /**
     * 删除商品
     * @param shopId
     * @param itemIds
     * @param webSite
     */
    public void delInstockItems(Long shopId,String itemIds,String webSite){
        List<Long> ids=filterItemIds(shopId,itemIds,webSite,true);
        for(Long id:ids){
            try {
                newItemAddOrUpdateService.userDeleteItem(id);
            } catch (ItemModifyException e) {
                logger.error("商品删除失败",e);
            }
        }
    }

    /**
     * 按主键查商品
     * @param goodsId
     * @param webSite
     * @return
     */
    public OnsaleItem selItemByGoodsId(Long goodsId,String webSite){
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(goodsId);
        sgt.setWebSite(webSite);
        sgt=shiguGoodsTinyMapper.selectByPrimaryKey(sgt);
        if(sgt==null){
            return null;
        }
        OnsaleItem oi=new OnsaleItem();
        oi.setWebSite(webSite);
        oi.setCreated(sgt.getCreated());
        oi.setGoodsNo(sgt.getGoodsNo());
        return null;
    }
    /**
     * 把非本店的商品ID过滤掉
     * @param shopId
     * @param itemIds
     * @param webSite
     * @param soldout 是否下架区的
     * @return
     */
    private List<Long> filterItemIds(Long shopId,String itemIds,String webSite,boolean soldout){
        List<Long> ids=new ArrayList<>();
        List<Long> targetIds=new ArrayList<>();
        String[] idarr=itemIds.split(",");
        for(String id:idarr){
            ids.add(Long.valueOf(id));
        }
        if(ids.size()==0){
            return targetIds;
        }
        if(soldout){
            ShiguGoodsSoldoutExample example=new ShiguGoodsSoldoutExample();
            example.createCriteria().andGoodsIdIn(ids).andStoreIdEqualTo(shopId);
            example.setWebSite(webSite);
            List<ShiguGoodsSoldout> list=shiguGoodsSoldoutMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
            if(list.size()==0){
                return targetIds;
            }
            for(ShiguGoodsSoldout sgt:list){
                targetIds.add(sgt.getGoodsId());
            }
        }else{
            ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
            example.createCriteria().andGoodsIdIn(ids).andStoreIdEqualTo(shopId);
            example.setWebSite(webSite);
            List<ShiguGoodsTiny> list=shiguGoodsTinyMapper.selectFieldsByExample(example, FieldUtil.codeFields("goods_id"));
            if(list.size()==0){
                return targetIds;
            }
            for(ShiguGoodsTiny sgt:list){
                targetIds.add(sgt.getGoodsId());
            }
        }

        return targetIds;
    }

    public List<StyleVo> findAllStyle() {
        List<StyleVo> vos = new ArrayList<>();
        SearchCategorySubExample categorySubExample = new SearchCategorySubExample();
        categorySubExample.createCriteria().andParentCateValueEqualTo("30").andTypeEqualTo(3);
        for (SearchCategorySub categorySub : searchCategorySubMapper.selectByExample(categorySubExample)) {
            vos.add(new StyleVo(categorySub.getSubId().toString(), categorySub.getCateName()));
        }
        return vos;
    }

    public Map<Long, StyleVo> findStyleByGoodsIds(List<Long> goodsIds) {
        Map<Long, StyleVo> goodsStyle = new HashMap<>();

        ShiguGoodsStyleExample styleExample = new ShiguGoodsStyleExample();
        styleExample.createCriteria().andGoodsIdIn(goodsIds);
        List<ShiguGoodsStyle> shiguGoodsStyles = shiguGoodsStyleMappe.selectByExample(styleExample);
        if (!shiguGoodsStyles.isEmpty()) {
            Map<Long, ShiguGoodsStyle> goodsStyleMap = BeanMapper.list2Map(shiguGoodsStyles, "goodsId", Long.class);
            List<String> sids = BeanMapper.getFieldList(shiguGoodsStyles, "sids", String.class);
            Set<Long> sidSet = new HashSet<>();
            for (String sid : sids) {
                if (sid != null) {
                    for (String s : sid.split(",")) {
                        try {
                            sidSet.add(Long.valueOf(s));
                        } catch (Exception ignored) {}
                    }
                }
            }

            if (!sidSet.isEmpty()) {
                SearchCategorySubExample subExample = new SearchCategorySubExample();
                subExample.createCriteria().andSubIdIn(new ArrayList<>(sidSet));
                Map<Long, SearchCategorySub> subMap = BeanMapper.list2Map(searchCategorySubMapper.selectByExample(subExample), "subId", Long.class);

                for (Map.Entry<Long, ShiguGoodsStyle> entry : goodsStyleMap.entrySet()) {
                    String sidstr = entry.getValue().getSids();
                    if (StringUtils.isNotEmpty(sidstr)) {
                        try {
                            Long sid = Long.valueOf(sidstr.split(",")[0]);
                            SearchCategorySub categorySub = subMap.get(sid);
                            if (categorySub != null && StringUtils.isNotEmpty(categorySub.getCateName())) {
                                goodsStyle.put(entry.getKey(), new StyleVo(categorySub.getSubId().toString(), categorySub.getCateName()));
                            }
                        } catch (Exception ignored){}
                    }
                }
            }
        }
        return goodsStyle;
    }

    ///**
    // * 获取固定风格
    // * @return
    // * @param webSite
    // */
    //// TODO: 18-1-23 准备撤掉
    //public List<ShiguStyleVo> getFixedStyle(String webSite){
    //    SearchCategorySubExample example = new SearchCategorySubExample();
    //    example.createCriteria().andTypeEqualTo(3).andWebSiteEqualTo(webSite).andParentCateValueEqualTo("30");
    //    List<SearchCategorySub> list = searchCategorySubMapper.selectByExample(example);
    //    ArrayList<ShiguStyleVo> styleVos = new ArrayList<>();
    //    for (SearchCategorySub searchCategorySub:list) {
    //        ShiguStyleVo shiguStyleVo = new ShiguStyleVo();
    //        shiguStyleVo.setStyleName(searchCategorySub.getCateName());
    //        shiguStyleVo.setStyleId(searchCategorySub.getSubId());
    //        styleVos.add(shiguStyleVo);
    //    }
    //    return styleVos;
    //}
    ///**
    // * 获取自定义风格
    // * @return
    // */
    //// TODO: 18-1-23 准备撤掉
    //public List<ShiguStyleVo> getCustomStyle(Long userId){
    //    ShiguCustomerStyleExample example = new ShiguCustomerStyleExample();
    //    example.createCriteria().andUserIdEqualTo(userId);
    //    List<ShiguCustomerStyle> list = shiguCustomerStyleMapper.selectByExample(example);
    //    List<ShiguStyleVo> styleVos = BeanMapper.mapList(list, ShiguStyleVo.class);
    //    return styleVos;
    //}
    //
    ///**
    // * 设置商品风格
    // */
    //// TODO: 18-1-23 准备撤掉
    //public void setStyle(Long goodsId, Integer styleId, String webSite){
    //    itemAddOrUpdateService.setCustomStyle(goodsId,styleId,webSite);
    //}
    ///**
    // *   关联同货号设置风格
    // */
    //// TODO: 18-1-23 准备撤掉
    //public void setSameNumStyle(Long goodsId, Integer styleId, Long shopId, String webSite){
    //    //查找该商品货号
    //    ShiguGoodsTinyExample example1 = new ShiguGoodsTinyExample();
    //    example1.setWebSite(webSite);
    //    example1.createCriteria().andGoodsIdEqualTo(goodsId);
    //    List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(example1);
    //    String goodsNo =  shiguGoodsTinies.get(0).getGoodsNo();
    //    if (goodsNo!=null&&StringUtils.isNotEmpty(goodsNo)){
    //        //店里的商品
    //        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
    //        example.createCriteria().andStoreIdEqualTo(shopId);
    //        example.setWebSite(webSite);
    //        List<ShiguGoodsTiny> list = shiguGoodsTinyMapper.selectByExample(example);
    //        //设置风格
    //        for (ShiguGoodsTiny goods:list) {
    //            if(goods.getGoodsNo()!=null){
    //                if (goods.getGoodsNo().equals(goodsNo)){
    //                    //setStyle(goods.getGoodsId(),styleId,webSite);
    //                }
    //            }
    //        }
    //
    //    }
    //
    //}

    /**
     * 获取所有子级风格
     * @return
     */
    public List<ShiguStyleVo> getSubStyleVO() {
        ShiguStyleExample example = new ShiguStyleExample();
        example.createCriteria().andIsParentEqualTo(0);
        List<ShiguStyle> shiguStyles = shiguStyleMapper.selectByExample(example);
        List<ShiguStyleVo> shiguStyleVos = new ArrayList<>(shiguStyles.size());
        for (ShiguStyle shiguStyle : shiguStyles) {
            ShiguStyleVo vo = new ShiguStyleVo();
            vo.setScid(shiguStyle.getId());
            vo.setScname(shiguStyle.getStyleName());
            shiguStyleVos.add(vo);
        }
        return shiguStyleVos;
    }

    /**
     * 设置商品风格
     * @param goodsIds
     * @param styleId
     * @param shopId
     * @param webSite
     * @param sameGoodsNoSet 是否关联相同货号
     * @return
     */
    public JSONObject setStyle(String goodsIds, Long styleId, Long shopId, String webSite, boolean sameGoodsNoSet) {

        String[] gis = goodsIds.split(",");
        List<Long> goodsIdList = new ArrayList<>();
        for (String goodsId : gis) {
            goodsIdList.add(Long.valueOf(goodsId));
        }

        Set<Long> goodsIdSet = new HashSet<>();

        if (goodsIdList == null || goodsIdList.size() <= 0 || styleId == null || shopId == null || StringUtils.isBlank(webSite)) {
            return JsonResponseUtil.error("非法的请求参数");
        }
        for (Long goodsId : goodsIdList){
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setGoodsId(goodsId);
            tiny.setWebSite(webSite);
            tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
            if (tiny == null) {
                return JsonResponseUtil.error("商品不存在或已下架");
            }
            if (!shopId.equals(tiny.getStoreId())) {
                return JsonResponseUtil.error("只能操作本店鋪的商品");
            }
            goodsIdSet.add(goodsId);
            if (sameGoodsNoSet && StringUtils.isNotBlank(tiny.getGoodsNo())) {
                ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
                example.setWebSite(webSite);
                example.createCriteria().andStoreIdEqualTo(shopId).andGoodsNoEqualTo(tiny.getGoodsNo());
                List<ShiguGoodsTiny> goodsList = shiguGoodsTinyMapper.selectFieldsByExample(example, "goods_id");
                for (ShiguGoodsTiny shiguGoodsTiny : goodsList) {
                    goodsIdSet.add(shiguGoodsTiny.getGoodsId());
                }
            }
        }

        //清除上传搜索数量
        if (goodsIdSet != null && !goodsIdList.isEmpty()) {
            try {
                itemUpRecordService.updateGoodsUpCountForSearchNum(goodsIdSet,0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String result = shopsItemService.setGoodsStyle(goodsIdSet, styleId, webSite);
        if ("success".equals(result)) {
            redisIO.rpush(SHOP_STYLE_HANDLER_QUEUE_INDEX,shopId);
            return JsonResponseUtil.success();
        }
        return JsonResponseUtil.error(result);
    }

    /**
     * 获取用户店内商品风格统计数据
     * @param webSite
     * @param shopId
     * @return
     */
    public List<ShopStyleGoodsAggrVO> selStyleAggrList(String webSite, Long shopId) {
        if (StringUtils.isBlank(webSite) || null == shopId) {
            return Collections.EMPTY_LIST;
        }
        List<StyleChannelVO> parentChannels = indexShowService.selStyleChannelInfo().selObj();
        if (parentChannels.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        Map<Long, ShopStyleGoodsAggrVO> parentStyleInfoMap = parentChannels.stream().collect(Collectors.toMap(StyleChannelVO::getSpid, o -> {
            ShopStyleGoodsAggrVO vo = new ShopStyleGoodsAggrVO();
            vo.setSpid(o.getSpid());
            vo.setSname(o.getSname());
            return vo;
        }));
        if (parentStyleInfoMap.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        Set<Long> psIdset = parentStyleInfoMap.keySet();
        List<ShopStyleGoodsAggrBean> shopStyleGoodsAggrBeans = shiguGoodsTinyMapper.countShopStyleGoods(webSite, shopId, new ArrayList<>(psIdset));
        for (ShopStyleGoodsAggrBean aggr : shopStyleGoodsAggrBeans) {
            parentStyleInfoMap.get(aggr.getParentStyleId()).setGoodsCount(aggr.getStyleGoodsCount());
        }
        return new ArrayList<>(parentStyleInfoMap.values());
    }

    /**
     * 获取商品风格信息
     * @param webSite
     * @param shopId
     * @param parentStyleId
     * @param stateIndex
     * @param endIndex
     * @return
     */
    public List<ShopStyleGoodsInfoVO> selShopStyleGoods(String webSite, Long shopId, Long parentStyleId, int stateIndex, int endIndex) {
        if (StringUtils.isBlank(webSite) || null == shopId || parentStyleId == null) {
            return Collections.EMPTY_LIST;
        }
        List<GoodsStyleInfoBean> list = shiguGoodsTinyMapper.selShopStyleGoods(webSite, shopId, parentStyleId, null, stateIndex, endIndex);
        if (list.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ShiguStyle shiguStyle = new ShiguStyle();
        shiguStyle.setParentStyleId(parentStyleId);
        Map<Long, String> styleIdNameMap = shiguStyleMapper.select(shiguStyle).stream().collect(Collectors.toMap(ShiguStyle::getId, ShiguStyle::getStyleName));
        ArrayList<ShopStyleGoodsInfoVO> vos = new ArrayList<>(list.size());
        for (GoodsStyleInfoBean goodsStyleInfoBean : list) {
            ShopStyleGoodsInfoVO vo = new ShopStyleGoodsInfoVO();
            vo.setGoodsid(goodsStyleInfoBean.getGoodsId());
            vo.setImgsrc(goodsStyleInfoBean.getImgsrc());
            vo.setTitle(goodsStyleInfoBean.getTitle());
            vo.setScid(goodsStyleInfoBean.getStyleId());
            vo.setScname(styleIdNameMap.get(goodsStyleInfoBean.getStyleId()));
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 删除商品风格
     * @param goodsId
     * @param shopId
     * @return
     */
    public JSONObject delGoodsStyle(Long goodsId, Long shopId) {
        if (shopId == null) {
            return JsonResponseUtil.error("只有店铺能操作风格");
        }
        shopsItemService.delGoodsStyle(goodsId, shopId);
        return JsonResponseUtil.success();
    }
    /**
     * 查店内需要编辑的商品的具体内容
     */
    public NewPullSynItemVO getGoodsOffer(Long goodId, ShopSession shopSession){
        NewPullSynItemVO synItem = newItemAddOrUpdateService.selItemByGoodsId(goodId, shopSession.getWebSite());
//        synItem.getInputStr();// 自定义值串   '用户自行输入的子属性名和属性值@所有属性别名加起来不能超过 3999字节。',
//        synItem.getInputPids();//自定义pid串  '用户自行输入的类目属性ID串',
//
//        synItem.getSellPoint();//卖点
//        synItem.getNum();//总量
//
//        synItem.getCid();//淘宝叶子类目ID
//        synItem.getCidAll();//商家编号

        return synItem;
    }

    public List<GoodsSkuVo> selGoodsSku(Long goodsId){
        List<SingleSkuVO> shiguGoodsSingleSkus = newShowForCdnService.selSingleSkus(goodsId);
        List<GoodsSkuVo> voList = new ArrayList<>();
        List<String> colorList = BeanMapper.getFieldList(shiguGoodsSingleSkus, "thisColor", String.class);
        List<String> colors = colorList.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i <colors.size() ; i++) {
            GoodsSkuVo vo = new GoodsSkuVo();
            List<GoodsSizeVo> sizeList = new ArrayList<>();
            vo.setColorText(colors.get(i));
            for (int j = 0; j <shiguGoodsSingleSkus.size() ; j++) {
                if (vo.getColorText().equals(shiguGoodsSingleSkus.get(j).getThisColor())){
                    GoodsSizeVo sizeVo = new GoodsSizeVo();
                    sizeVo.setSkuId(shiguGoodsSingleSkus.get(j).getSkuId());
                    sizeVo.setSizeText(shiguGoodsSingleSkus.get(j).getThisSize());
                    sizeVo.setNum(shiguGoodsSingleSkus.get(j).getStockNum());
                    sizeVo.setSkuPrice(shiguGoodsSingleSkus.get(j).getPriceString());
                    sizeList.add(sizeVo);
                    System.out.println(vo.getColorText()+"   "+sizeVo.getSizeText()+"   "+sizeVo.getSkuId());
                }
            }
            List<GoodsSizeVo> sizes  = new ArrayList<>();
            List<GoodsSizeVo> haveSizes = sizeList.stream().filter(goodsSizeVo -> CdnService.SIZE_SORT.get(goodsSizeVo.getSizeText().toUpperCase()) != null).collect(Collectors.toList());
            haveSizes.sort(Comparator.comparingInt(o -> CdnService.SIZE_SORT.get(o.getSizeText().toUpperCase())));

            List<GoodsSizeVo> noSizes =sizeList.stream().filter(goodsSizeVo -> CdnService.SIZE_SORT.get(goodsSizeVo.getSizeText().toUpperCase()) == null).collect(Collectors.toList());
            noSizes.sort(Comparator.comparing(GoodsSizeVo::getSizeText));

            sizes.addAll(haveSizes);
            sizes.addAll(noSizes);
            vo.setSizes(sizes);
            voList.add(vo);
        }
        return voList;
    }

    public Integer updateSkuPriceStock(List<GoodsSkuBo> boList , String webSite,Long goodsId){
        List<SingleSkuVO> skuList = new ArrayList<>();
        for (GoodsSkuBo bo : boList) {
            SingleSkuVO sku = new SingleSkuVO();
            sku.setSkuId(bo.getSkuId());
            sku.setGoodsId(goodsId);
            sku.setPriceString(bo.getSkuPrice());
            sku.setStockNum(bo.getInventory());
            skuList.add(sku);
        }
        return newShowForCdnService.updateSkuPriceStock(skuList,webSite);
    }

    public Integer updatePiPrice(String piPrice,Long goodsId , String webSite){
        try {
            return newItemAddOrUpdateService.systemUpItemPiPrice(goodsId,piPrice,webSite);
        } catch (ItemModifyException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String selWebSiteByGoodsId(Long goodsId){
        ShiguGoodsIdGenerator goodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        System.out.println(goodsIdGenerator);
        return goodsIdGenerator.getWebSite();
    }
}
