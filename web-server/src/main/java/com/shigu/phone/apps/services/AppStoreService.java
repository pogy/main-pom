package com.shigu.phone.apps.services;

import com.openJar.beans.app.*;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.MarketsRequest;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.responses.app.MarketsResponse;
import com.openJar.responses.app.OneShopResponse;
import com.openJar.responses.app.ShopCatResponse;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.newcdn.vo.CdnShopCatVO;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.StoreRelation;
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
public class AppStoreService {

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

    public OneShopResponse selOneShopInfo(OneShopRequest request) {
        OneShopResponse response = new OneShopResponse();
        //店铺基本信息
        StoreRelation storeRelation = storeRelationService.selRelationById(request.getShopId());
        if(storeRelation == null){
            OpenException openException = new OpenException();
            openException.setErrMsg("店铺不存在");
            response.setException(openException);
            response.setSuccess(false);
            return  response;
        }

        //商品数量
        Long itemsNum = shopForCdnService.selItemNumberById(request.getShopId(), request.getWebSite());
        //查询星星数
        Long starNum = shopForCdnService.selShopStarById(request.getShopId());

        //今日上新数
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(request.getWebSite());
        tinyExample.createCriteria()
                .andStoreIdEqualTo(request.getShopId())
                .andGoodsStatusEqualTo(0)
                .andLoadDateGreaterThanOrEqualTo(DateUtil.getStartTime());
        int todayAdd = shiguGoodsTinyMapper.countByExample(tinyExample);
        response.setSuccess(true);
        response.setItemNum(itemsNum.intValue());
        response.setMarket(storeRelation.getMarketName());
        response.setShopId(request.getShopId());
        response.setShopNum(storeRelation.getStoreNum());
        response.setStarNum(starNum.intValue());
        response.setTelephone(storeRelation.getTelephone());
        response.setTodayAdd(todayAdd);
        return response;
    }
    public MarketsResponse selMarketData(MarketsRequest request){
        MarketsResponse response = new MarketsResponse();
        if(request.getMid() == null){
         switch (request.getWebSite()){
             case "hz":{
                request.setMid(1L);
                break;
             }
             case "cs":{
                request.setMid(43L);
                break;
             }
             case "jx":{
                request.setMid(33L);
                break;
             }
             case "ss":{
                request.setMid(61L);
                break;
             }
             case "kx":{
                 request.setMid(68L);
                 break;
             }
             default:{
                 break;
             }
         }

        }
        MarketVO marketVO = marketListService.selMarketData(request.getMid(), null);
        if (marketVO == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("未查询到市场信息");
            response.setException(openException);
            response.setSuccess(false);
            return response;
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
        response.setMarket(appMarket);
        response.setSuccess(true);
        return response;
    }
    public ShopCatResponse selShopCat(ShopCatRequest request){
        ShopCatResponse response = new ShopCatResponse();
        List<CdnShopCatVO> cdnShopCatVOS = cdnService.cdnShopCat(request.getShopId());
        List<AppShopCat> appShopCats = new ArrayList<>();
        ShiguGoodsTinyExample goodsTinyExample = new ShiguGoodsTinyExample();
        for (CdnShopCatVO cdnShopCatVO : cdnShopCatVOS) {
            AppShopCat cat = new AppShopCat();
            cat.setCatName(cdnShopCatVO.getName());
            cat.setScid(cdnShopCatVO.getCid().toString());
            List<AppShopCatSub> appShopCatSubs = new ArrayList<>();
            for (CdnShopCatVO shopCatVO : cdnShopCatVO.getSubCats()) {
                AppShopCatSub catSub = new AppShopCatSub();
                catSub.setCatName(shopCatVO.getName());
                catSub.setScid(shopCatVO.getCid().toString());
                goodsTinyExample.clear();
                goodsTinyExample.createCriteria()
                        .andGoodsStatusEqualTo(0)
                        .andStoreIdEqualTo(request.getShopId())
                        .andCidEqualTo(shopCatVO.getCid());
                int itemNum = shiguGoodsTinyMapper.countByExample(goodsTinyExample);
                catSub.setItemNum(itemNum);
                appShopCatSubs.add(catSub);
            }
            cat.setSubCats(appShopCatSubs);
            appShopCats.add(cat);
        }
        response.setCats(appShopCats);
        response.setSuccess(true);
        return response;
    }
}
