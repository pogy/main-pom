package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppMarket;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.MarketsRequest;
import com.openJar.requests.app.OneShopRequest;
import com.openJar.requests.app.ShopCatRequest;
import com.openJar.responses.app.MarketsResponse;
import com.openJar.responses.app.OneShopResponse;
import com.openJar.responses.app.ShopCatResponse;
import com.shigu.phone.baseservices.BaseStoreService;
import com.shigu.phone.basevo.OneShopVO;
import com.shigu.phone.basevo.ShopCatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            response.setCollectId(oneShopVO.getCollectId());
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
