package com.shigu.phone.baseservices;

import com.openJar.beans.app.*;
import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguStoreCollect;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguStoreCollectMapper;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.ShopCat;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.basevo.OneShopVO;
import com.shigu.phone.basevo.ShopCatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-08-29.
 * app 店铺 service
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class BaseStoreService {

    private StoreRelationService storeRelationService;
    @Autowired
    public void setStoreRelationService(StoreRelationService storeRelationService) {
        this.storeRelationService = storeRelationService;
    }
    private ShopForCdnService shopForCdnService;
    @Autowired
    public void setShopForCdnService(ShopForCdnService shopForCdnService) {
        this.shopForCdnService = shopForCdnService;
    }
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    public void setShiguGoodsTinyMapper(ShiguGoodsTinyMapper shiguGoodsTinyMapper) {
        this.shiguGoodsTinyMapper = shiguGoodsTinyMapper;
    }
    private MarketListService marketListService;
    @Autowired
    public void setMarketListService(MarketListService marketListService) {
        this.marketListService = marketListService;
    }
    private CdnService cdnService;
    @Autowired
    public void setCdnService(CdnService cdnService) {
        this.cdnService = cdnService;
    }
    public ShiguStoreCollectMapper shiguStoreCollectMapper;
    @Autowired
    public void setShiguStoreCollectMapper(ShiguStoreCollectMapper shiguStoreCollectMapper) {
        this.shiguStoreCollectMapper = shiguStoreCollectMapper;
    }


    public OneShopVO selOneShopInfo(Long shopId,String webSite,Long userId) throws OpenException {
        //店铺基本信息
        StoreRelation storeRelation = storeRelationService.selRelationById(shopId);
        if(storeRelation == null){
            OpenException openException = new OpenException();
            openException.setErrMsg("店铺不存在");
            throw openException;
        }

        //商品数量
        Long itemsNum = shopForCdnService.selItemNumberById(shopId, webSite);
        //查询星星数
        Long starNum = shopForCdnService.selShopStarById(shopId);

        //今日上新数
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria()
                .andStoreIdEqualTo(shopId)
                .andGoodsStatusEqualTo(0)
                .andLoadDateGreaterThanOrEqualTo(DateUtil.getStartTime());
        int todayAdd = shiguGoodsTinyMapper.countByExample(tinyExample);
        OneShopVO vo = new OneShopVO();
        vo.setItemNum(itemsNum.intValue());
        vo.setMarket(storeRelation.getMarketName());
        vo.setShopId(shopId);
        vo.setShopNum(storeRelation.getStoreNum());
        vo.setStarNum(starNum.intValue());
        vo.setTelephone(storeRelation.getTelephone());
        vo.setTodayAdd(todayAdd);
        vo.setShopHeadUrl(ImgUtils.headUrl(storeRelation.getImWw()));
        //店铺是否已收藏
        if (userId == null) {
            vo.setCollectId(-1L);
        }else {
            ShiguStoreCollect shiguStoreCollect = new ShiguStoreCollect();
            shiguStoreCollect.setUserId(userId);
            shiguStoreCollect.setStoreId(shopId);
            shiguStoreCollect.setWebSite(webSite);
            shiguStoreCollect = shiguStoreCollectMapper.selectOne(shiguStoreCollect);
            if (shiguStoreCollect == null) {
                vo.setCollectId(-1L);
            }else{
                vo.setCollectId(shiguStoreCollect.getStoreCollectId());
            }
        }
        return vo;
    }

    public AppMarket selMarketData(Long mid,String webSite) throws OpenException {
        if(mid == null){
         switch (webSite){
             case "hz":{
                mid = 1L;
                break;
             }
             case "cs":{
                mid = 43L;
                break;
             }
             case "jx":{
                mid = 33L;
                break;
             }
             case "ss":{
                mid = 61L;
                break;
             }
             case "kx":{
                 mid = 68L;
                 break;
             }
             default:{
                 break;
             }
         }

        }
        MarketVO marketVO = marketListService.selMarketData(mid, null);
        if (marketVO == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("未查询到市场信息");
            throw openException;
        }
        AppMarket appMarket = new AppMarket();
        appMarket.setMarketName(marketVO.getMarketName());
        appMarket.setWebSite(marketVO.getWebSite());
        List<MarketTagVO> marketTagVOS =  marketVO.getMarketTags();
        if (marketTagVOS != null) {
            List<AppMarketTag> appMarketTags = new ArrayList<>();
            for (MarketTagVO item : marketTagVOS){
                AppMarketTag itemTag = new AppMarketTag();
                itemTag.setMid(item.getId());
                itemTag.setName(item.getName());
                appMarketTags.add(itemTag);
            }
            appMarket.setMarketTags(appMarketTags);
        }

        List<FloorVO> floorVOs = marketVO.getFloorVOs();
        List<AppFloor> appFloors = new ArrayList<>();
        floorVOs.stream().filter(item->item!=null).forEach(item->{
            AppFloor appFloor = new AppFloor();
            List<AppShopInFloor> appShopInFloors = new ArrayList<>();
            List<ShopInFloorVO> shopInFloorVOS =  item.getStores();
            shopInFloorVOS.stream().filter(shopInFloorVO->shopInFloorVO!=null).forEach(shopInFloorVO->{
                AppShopInFloor appShopInFloor = new AppShopInFloor();
                appShopInFloor.setStoreId(shopInFloorVO.getId());
                appShopInFloor.setCate(shopInFloorVO.getCate());
                appShopInFloor.setIsNew(shopInFloorVO.getIsNew());
                appShopInFloor.setNum(shopInFloorVO.getNum());
                appShopInFloor.setTags(shopInFloorVO.getTags());

                appShopInFloors.add(appShopInFloor);
            });
            appFloor.setTitle(item.getTitle());
            appFloor.setStores(appShopInFloors);

            appFloors.add(appFloor);
        });
        appMarket.setFloors(appFloors);
        return appMarket;
    }

    public ShopCatVO selShopCat(Long shopId) throws OpenException {

        OpenException openException = new OpenException();
        StoreRelation storeRelation = storeRelationService.selRelationById(shopId);
        if(storeRelation==null){
            openException.setErrMsg("未查询到档口");
            throw openException;
        }
        List<ShopCat> cats=shopForCdnService.selShopCatsById(shopId);
        List<AppShopCat> appShopCats = new ArrayList<>();

        ShiguPager<ItemShowBlock> items = shopForCdnService.searchItemOnsale(null, shopId, storeRelation.getWebSite(), "time_down", 1, 30);
        ShopCatVO vo = new ShopCatVO();
        vo.setTotalItemNum(new Long(items.getTotalCount()));

        for(ShopCat cat : cats){
            items = shopForCdnService.searchItemOnsale(null, shopId, storeRelation.getWebSite(),null,cat.getCid(),"time_down",null,null, 1, 30);
            AppShopCat appShopCat1 = new AppShopCat();
            appShopCat1.setItemNum(new Long(items.getTotalCount()));
            appShopCat1.setCatName(cat.getName());
            appShopCat1.setScid(cat.getCid());
            List<AppShopCatSub> catAlls = new ArrayList<>();
            for(ShopCat subCat:cat.getSubCats()){
                AppShopCatSub appShopCatSub = new AppShopCatSub();
                appShopCatSub.setScid(subCat.getCid());
                appShopCatSub.setCatName(subCat.getName());
                catAlls.add(appShopCatSub);
            }
            appShopCat1.setSubCats(catAlls);
            appShopCats.add(appShopCat1);
        }
        vo.setCats(appShopCats);
        return vo;
    }

}
