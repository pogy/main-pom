package com.shigu.phone.waps.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.openJar.beans.app.*;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguStoreCollectExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguStoreCollectMapper;
import com.opentae.data.mall.multibeans.AppShopBlockBean;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.main4.vo.CatPolymerization;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.search.bo.StorenumBO;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.vo.StoreInSearch;
import com.shigu.zhb.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.services.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class WapStoreService {


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
        response.setShopHeadUrl(ImgUtils.headUrl(storeRelation.getImWw()));
        //店铺是否已收藏
        if (StringUtil.isNull(request.getUserId())) {
            response.setIsCollect(0);
        }else {
            ShiguStoreCollectExample example = new ShiguStoreCollectExample();
            example.createCriteria().andUserIdEqualTo(request.getUserId()).andStoreIdEqualTo(request.getShopId());
            int count = shiguStoreCollectMapper.countByExample(example);
            response.setIsCollect(count == 0 ? 0 : 1);


        }
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

        List<AppShopCat> appShopCats = new ArrayList<>();
        Long totalItemNum = 0L;//全部商品数目
        List<CatPolymerization> catPolymerizations = cdnService.formatCatPoly(request.getShopId());
        for (CatPolymerization parentItem : catPolymerizations){
            AppShopCat appShopCat = new AppShopCat();
            if (parentItem.getSubPolymerizations() != null && !parentItem.getSubPolymerizations().isEmpty()){//顶级类目

                appShopCat.setScid(String.valueOf(parentItem.getCid()));
                appShopCat.setCatName(parentItem.getName());
                List<CatPolymerization> subPolymerizations = parentItem.getSubPolymerizations();

                List<AppShopCatSub> appShopCatSubs= new ArrayList<>();
                Long itemNum  = 0L;
                for (CatPolymerization item : subPolymerizations){
                    AppShopCatSub catSub = new AppShopCatSub();
                    catSub.setScid(String.valueOf(item.getCid()));
                    catSub.setCatName(item.getName());
                    catSub.setItemNum(item.getNumber()==null?0:item.getNumber());

                    appShopCatSubs.add(catSub);
                    itemNum += item.getNumber();
                }
                appShopCat.setItemNum(itemNum);
                appShopCat.setSubCats(appShopCatSubs);
                totalItemNum += itemNum;
            }
            appShopCats.add(appShopCat);
        }

        response.setTotalItemNum(totalItemNum);
        response.setCats(appShopCats);
        response.setSuccess(true);
        return response;
    }
}
