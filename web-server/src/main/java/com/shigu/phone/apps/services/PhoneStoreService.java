package com.shigu.phone.apps.services;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.DoStoreCollectRequest;
import com.openJar.requests.app.ShopSearchRequest;
import com.openJar.requests.app.StoreCollectRequest;
import com.openJar.responses.app.DoStoreCollectResponse;
import com.openJar.responses.app.ShopSearchResponse;
import com.openJar.responses.app.StoreCollectResponse;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.phone.baseservices.BasedPhoneStoreService;
import com.shigu.phone.basevo.ShopSearchVO;
import com.shigu.phone.basevo.StoreCollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：PhoneStoreService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneStoreService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 15:38
 * 项目：main-pom
 * 描述：
 */

@Service
public class PhoneStoreService {

    @Autowired
    private BasedPhoneStoreService basedPhoneStoreService;

    /**
     * 移动端店铺搜索
     *
     * @param request
     * @return
     */
    public ShopSearchResponse shopSearch(ShopSearchRequest request) {
        ShopSearchVO shopSearchVO = basedPhoneStoreService.shopSearch(request.getKeyword(),request.getWebSite(),request.getIndex(),request.getSize());
        ShopSearchResponse resp = new ShopSearchResponse();
        resp.setTotal(shopSearchVO.getTotal());
        resp.setHasNext(shopSearchVO.getHasNext());
        resp.setShops(shopSearchVO.getShops());
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 店铺收藏夹
     *
     * @param request
     * @return
     */
    public StoreCollectResponse storeCollect(StoreCollectRequest request) {
        StoreCollectResponse resp = new StoreCollectResponse();
        StoreCollectVO storeCollectVO = basedPhoneStoreService.storeCollect(request.getUserId(), request.getWebSite(), request.getIndex(), request.getSize());
        resp.setShops(storeCollectVO.getShops());
        resp.setTotal(storeCollectVO.getTotal());
        resp.setHasNext(storeCollectVO.getHasNext());
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 收藏OR取消收藏店铺
     *
     * @param request
     * @return
     */
    public DoStoreCollectResponse doStoreCollect(DoStoreCollectRequest request) {

        DoStoreCollectResponse resp = new DoStoreCollectResponse();
        try {
            basedPhoneStoreService.doStoreCollect(request.getShopId(),request.getYesOrNo(),request.getUserId());
            resp.setSuccess(true);
            return resp;
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
            return resp;
        }

    }

}
