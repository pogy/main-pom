package com.shigu.goodsup.shopee.service;

import com.shigu.upload.shopee.sdk.ShopeeClient;
import com.shigu.upload.shopee.sdk.request.ShopeeGetLogisticsRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeGetShopInfoRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetLogisticsResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeGetShopInfoResponse;
import org.springframework.stereotype.Component;

/**
 * 类名：ShopeeService
 * 类路径： com.shigu.goodsup.shopee.service.ShopeeService
 * 创建者： whx
 * 创建时间： 10/21/18 1:45 PM
 * 项目： main-pom
 * 描述：
 */
@Component
public class ShopeeService {

    private ShopeeClient client;

    public String authorUrl(String redirectUrl) {
        return client.authorizationUrl(redirectUrl);
    }

    public ShopeeGetShopInfoResponse shopeeShopInfo(Long shopId) {
        ShopeeGetShopInfoRequest request = new ShopeeGetShopInfoRequest();
        request.setShopId(shopId);
        return client.execute(request);
    }

    public void registerShopeeUser(ShopeeGetShopInfoResponse shopInfo) {

    }

    public void shopLogistics(Long shopId) {
        ShopeeGetLogisticsRequest request = new ShopeeGetLogisticsRequest();
        request.setShopId(shopId);
        ShopeeGetLogisticsResponse response = client.execute(request);
        if (!response.isSuccess()) {

        } else {
            response.getLogistics();
        }
    }
}
