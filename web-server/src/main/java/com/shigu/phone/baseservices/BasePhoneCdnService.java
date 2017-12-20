package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguGoodsCollectExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguGoodsCollectMapper;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.phone.basevo.BaseCollectItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class BasePhoneCdnService {

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private ItemSearchService itemSearchService;

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguGoodsCollectMapper goodsCollectMapper;

    @Autowired
    private ShowForCdnService showForCdnService;



    /**
     * 查询收藏的商品
     * @param userId
     * @return
     */
    public BaseCollectItemVO selItemCollect(Long userId, Integer index, Integer pageSize,String webSite) throws OpenException {
        ShiguGoodsCollectExample shiguGoodsCollectExample = new ShiguGoodsCollectExample();
        ShiguGoodsCollectExample.Criteria criteria =  shiguGoodsCollectExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (!StringUtil.isNull(webSite)) {
            criteria.andWebsiteEqualTo(webSite);
        }
        List<ShiguGoodsCollect> shiguGoodsCollects = goodsCollectMapper.selectByExample(shiguGoodsCollectExample);

        Map<Long,List<ShiguGoodsCollect>> itemCollectInfoGroup = BeanMapper.groupBy(shiguGoodsCollects,"goodsId",Long.class);
        List<Long> goodsIds = BeanMapper.getFieldList(shiguGoodsCollects,"goodsId",Long.class);

        if (goodsIds == null || goodsIds.isEmpty()) {
            BaseCollectItemVO vo  = new BaseCollectItemVO();
            vo.setHasNext(false);
            vo.setTotal(0);
            vo.setItems(Collections.emptyList());
            return  vo;
        }
        UserInfo userInfo = userBaseService.selUserInfo(userId);
        if (userInfo == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("该用户不存在");
            throw openException;
        }
        ShiguPager<SearchItem> searchItem = itemSearchService.searchItemByIds(goodsIds, webSite, index, pageSize);
        searchItem.calPages(searchItem.getTotalCount(),pageSize);
        searchItem.setNumber(index);//设置当前页
        List<SearchItem> searchItems = searchItem.getContent();
        BaseCollectItemVO vo  = new BaseCollectItemVO();
        vo.setHasNext(searchItem.getNumber()<searchItem.getTotalPages());
        vo.setItems(new ArrayList<>());
        vo.setTotal(searchItem.getTotalCount());
        if(searchItems.size()>0){
            List<Long> storeIds = BeanMapper.getFieldList(searchItems,"storeId",Long.class);

            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andShopIdIn(storeIds);
            List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);
            Map<Long,List<ShiguShop>> shiguShopGroup = BeanMapper.groupBy(shiguShops,"shopId",Long.class);
            List<Long> marketIds = BeanMapper.getFieldList(shiguShops,"marketId",Long.class);

            ShiguMarketExample shiguMarketExample = new ShiguMarketExample();
            shiguMarketExample.createCriteria().andMarketIdIn(marketIds);
            List<ShiguMarket> shiguMarkets = shiguMarketMapper.selectByExample(shiguMarketExample);
            Map<Long,List<ShiguMarket>> shiguMarketGroup = BeanMapper.groupBy(shiguMarkets,"marketId",Long.class);
            List<AppGoodsBlock> appGoodsBlocks=vo.getItems();
            searchItems.stream().filter(item->item!=null).forEach(item->{
                List<ShiguShop> shiguShopList = shiguShopGroup.get(item.getStoreId());
                ShiguShop shiguShop = null;
                if (shiguShopList != null && !shiguShopList.isEmpty()) {
                    shiguShop = shiguShopList.get(0);
                }
                List<ShiguMarket> shiguMarketsList = null;
                ShiguMarket shiguMarket = null;
                if (shiguShop != null) {
                    shiguMarketsList = shiguMarketGroup.get(shiguShop.getMarketId());
                }
                if (shiguMarketsList != null && !shiguMarketsList.isEmpty()) {
                    shiguMarket = shiguMarketsList.get(0);
                }

                List<ShiguGoodsCollect> shiguGoodsCollects1 = itemCollectInfoGroup.get(item.getItemId());
                ShiguGoodsCollect shiguGoodsCollect = null;
                if (shiguGoodsCollects1 != null && !shiguGoodsCollects1.isEmpty()) {
                    shiguGoodsCollect = shiguGoodsCollects1.get(0);
                }

                AppGoodsBlock appGoodsBlock = new AppGoodsBlock();
                appGoodsBlock.setGoodsId(item.getItemId()+"");
                appGoodsBlock.setTitle(item.getTitle());
                appGoodsBlock.setHighLightTitle(item.getHighLightTitle());
                appGoodsBlock.setImgsrc(item.getPicUrl());
                appGoodsBlock.setPiprice(item.getPrice());
                if (shiguShop != null && shiguMarket != null) {
                    appGoodsBlock.setFullStoreName(shiguMarket.getMarketName()+" "+shiguShop.getShopName());//市场档口，空格隔开
                }
                appGoodsBlock.setAliww(userInfo.getImWw());
                appGoodsBlock.setStoreid(item.getStoreId());
                appGoodsBlock.setGoodsNo(item.getGoodsNo());
                appGoodsBlock.setHighLightGoodsNo(item.getHighLightGoodsNo());
                if (shiguGoodsCollect != null) {
                    appGoodsBlock.setCollectId(shiguGoodsCollect.getGoodsCollectId()+"");
                }
                appGoodsBlocks.add(appGoodsBlock);
            });
        }
        return vo;
    }

    /**
     * 收藏/取消收藏商品
     * @param userId
     * @return
     */
    public boolean addItemCollect(Long userId,Long storeId,Long goodsId,String webSite){

        ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
        shiguGoodsCollect.setUserId(userId);
        shiguGoodsCollect.setGoodsId(goodsId);
        shiguGoodsCollect.setStoreId(storeId);
        shiguGoodsCollect.setWebsite(webSite);

        ShiguGoodsCollect shiguGoodsCollect1 = goodsCollectMapper.selectOne(shiguGoodsCollect);

        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        if (shiguGoodsCollect1 == null) {//从未收藏过，添加收藏记录
            itemCollect.setItemId(goodsId);
            itemCollect.setStoreId(storeId);
            itemCollect.setWebsite(webSite);
            try {
                userCollectService.addItemCollection(itemCollect);
            } catch (ItemCollectionException e) {
                return false;
            }
        }else{//已经收藏的取消收藏
            List<Long>  collectId = new ArrayList<>();
            collectId.add(shiguGoodsCollect1.getGoodsCollectId());
            delItemCollect(userId,collectId);
        }
        return true;
    }

    /**
     * 收藏商品
     * @param userId
     * @return
     */
    public ShiguGoodsCollect collectItem(Long userId,Long storeId,Long goodsId,String webSite) throws OpenException {

        ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
        shiguGoodsCollect.setUserId(userId);
        shiguGoodsCollect.setGoodsId(goodsId);
        shiguGoodsCollect.setStoreId(storeId);
        shiguGoodsCollect.setWebsite(webSite);

        ShiguGoodsCollect shiguGoodsCollect1 = goodsCollectMapper.selectOne(shiguGoodsCollect);

        if (shiguGoodsCollect1 == null) {//从未收藏过，添加收藏记录
            if (storeId == null) {
                CdnItem cdnItem = showForCdnService.selItemById(goodsId, webSite);
                storeId = cdnItem.getShopId();
                if (cdnItem == null) {
                    OpenException openException = new OpenException();
                    openException.setErrMsg("收藏失败,为查询到档口信息");
                    throw openException;
                }
            }

            ItemCollect itemCollect=new ItemCollect();
            itemCollect.setUserId(userId);
            itemCollect.setItemId(goodsId);
            itemCollect.setStoreId(storeId);
            itemCollect.setWebsite(webSite);
            try {
                userCollectService.addItemCollection(itemCollect);
                return goodsCollectMapper.selectOne(shiguGoodsCollect);

            } catch (ItemCollectionException e) {
                OpenException openException = new OpenException();
                openException.setErrMsg("收藏失败 ["+e.getMessage()+"]");
                throw openException;
            }
        }else{
            return shiguGoodsCollect1;
        }
    }

    public void delItemCollect(Long userId, List<Long> collectIds){
        userCollectService.delItemCollection(userId,collectIds);
    }

}
