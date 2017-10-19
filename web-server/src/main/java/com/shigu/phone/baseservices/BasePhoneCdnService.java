package com.shigu.phone.baseservices;

import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.services.ItemSearchService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 查询收藏的商品
     * @param userId
     * @return
     */
    public BaseCollectItemVO selItemCollect(Long userId, Integer index, Integer pageSize) throws OpenException {
        List<ItemCollectInfoVO> itemCollectInfoVOS = userCollectService.selItemCollection(userId,null,null,null,null);
        Map<Long,List<ItemCollectInfoVO>> itemCollectInfoGroup = BeanMapper.groupBy(itemCollectInfoVOS,"goodsId",Long.class);
        List<Long> goodsIds = BeanMapper.getFieldList(itemCollectInfoVOS,"goodsId",Long.class);

        if (goodsIds == null || goodsIds.isEmpty()) {
           return null;
        }
        UserInfo userInfo = userBaseService.selUserInfo(userId);
        if (userInfo == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("该用户不存在");
            throw openException;
        }
        ShiguPager<SearchItem> searchItem = itemSearchService.searchItemByIds(goodsIds, "hz", index, pageSize);
        searchItem.calPages(searchItem.getTotalCount(),pageSize);
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

                List<ItemCollectInfoVO> itemCollectInfoVOS1 = itemCollectInfoGroup.get(item.getItemId());
                ItemCollectInfoVO itemCollectInfoVO = null;
                if (itemCollectInfoVOS1 != null && !itemCollectInfoVOS1.isEmpty()) {
                    itemCollectInfoVO = itemCollectInfoVOS1.get(0);
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
                if (itemCollectInfoVO != null) {
                    appGoodsBlock.setCollectId(itemCollectInfoVO.getGoodsCollectId()+"");
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

        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        ItemCollectInfoVO itemCollectInfoVO = userCollectService.selItemCollectionInfo(userId, goodsId, webSite);
        if (itemCollectInfoVO == null) {//从未收藏过，添加收藏记录
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
            collectId.add(itemCollectInfoVO.getGoodsCollectId());
            delItemCollect(userId,collectId);
        }
        return true;
    }

    /**
     * 收藏商品
     * @param userId
     * @return
     */
    public ItemCollectInfoVO collectItem(Long userId,Long storeId,Long goodsId,String webSite) throws OpenException {

        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        ItemCollectInfoVO itemCollectInfoVO = userCollectService.selItemCollectionInfo(userId, goodsId, webSite);
        if (itemCollectInfoVO == null) {//从未收藏过，添加收藏记录
            itemCollect.setItemId(goodsId);
            itemCollect.setStoreId(storeId);
            itemCollect.setWebsite(webSite);
            try {
                userCollectService.addItemCollection(itemCollect);
                return userCollectService.selItemCollectionInfo(userId, goodsId, webSite);
            } catch (ItemCollectionException e) {
                OpenException openException = new OpenException();
                openException.setErrMsg("查询失败 ["+e.getMessage()+"]");
                throw openException;
            }
        }else{
            return itemCollectInfoVO;
        }
    }

    public void delItemCollect(Long userId, List<Long> collectIds){
        userCollectService.delItemCollection(userId,collectIds);
    }

}
