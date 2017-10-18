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
import com.opentae.data.mall.examples.ShiguStoreCollectExample;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguStoreCollectMapper;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.MarketListService;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.MarketTagVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.newcdn.vo.CdnShopCatVO;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.vo.CatPolymerization;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.phone.baseservices.BaseStoreService;
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
public class AppStoreService {

    @Autowired
    private BaseStoreService baseStoreService;

    public OneShopResponse selOneShopInfo(OneShopRequest request) {
        OneShopResponse response = new OneShopResponse();
        try {
            OneShopVO oneShopVO = baseStoreService.selOneShopInfo(request.getShopId(), request.getWebSite(), request.getUserId());
            response.setIsCollect(oneShopVO.getIsCollect());
            response.setTodayAdd(oneShopVO.getTodayAdd());
            response.setTelephone(oneShopVO.getTelephone());
            response.setStarNum(oneShopVO.getStarNum());
            response.setShopNum(oneShopVO.getShopNum());
            response.setShopId(oneShopVO.getShopId());
            response.setMarket(oneShopVO.getMarket());
            response.setItemNum(oneShopVO.getItemNum());
            response.setShopHeadUrl(oneShopVO.getShopHeadUrl());
            response.setSuccess(true);
        } catch (OpenException e) {
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }
    public MarketsResponse selMarketData(MarketsRequest request){
        MarketsResponse response = new MarketsResponse();
        try {
            AppMarket appMarket = baseStoreService.selMarketData(request.getMid(), request.getWebSite());
            response.setMarket(appMarket);
            response.setSuccess(true);
        } catch (OpenException e) {
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }
    public ShopCatResponse selShopCat(ShopCatRequest request) {
        ShopCatResponse response = null;
        try {
            response = new ShopCatResponse();
            ShopCatVO shopCatVO = baseStoreService.selShopCat(request.getShopId());//webSite 未使用
            response.setTotalItemNum(shopCatVO.getTotalItemNum());
            response.setCats(shopCatVO.getCats());
            response.setSuccess(true);
        } catch (OpenException e) {
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }
}
