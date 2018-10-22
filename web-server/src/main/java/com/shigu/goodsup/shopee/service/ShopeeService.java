package com.shigu.goodsup.shopee.service;

import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.bo.ShopeeUserBO;
import com.shigu.main4.ucenter.services.ShopeeUserService;
import com.shigu.upload.shopee.sdk.ShopeeClient;
import com.shigu.upload.shopee.sdk.domain.ShopeeLogistic;
import com.shigu.upload.shopee.sdk.request.ShopeeGetLogisticsRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeGetShopInfoRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetLogisticsResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeGetShopInfoResponse;
import com.taobao.api.domain.DeliveryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    public RedisIO redisIO;

    @Autowired
    public ShopeeUserService shopeeUserService;

    private final String logisticCachePre = "SHOPEE_SHOP_LOGISTICS_CACHE_";

    public String authorUrl(String redirectUrl) {
        return client.authorizationUrl(redirectUrl);
    }

    public ShopeeGetShopInfoResponse shopeeShopInfo(Long shopId) {
        ShopeeGetShopInfoRequest request = new ShopeeGetShopInfoRequest();
        request.setShopId(shopId);
        return client.execute(request);
    }

    public void refreshShopeeUser(ShopeeGetShopInfoResponse shopInfo) {
        if (shopInfo != null && shopInfo.isSuccess() && shopInfo.getShopId() != null) {
            ShopeeUserBO bo = new ShopeeUserBO();
            bo.setShopId(shopInfo.getShopId());
            bo.setShopName(shopInfo.getShopName());
            bo.setCountry(shopInfo.getCountry());
            bo.setShopDescription(shopInfo.getShopDescription());
            bo.setItemLimit(shopInfo.getItemLimit());
            shopeeUserService.refreshShopeeUserInfo(bo);
        }
    }

    public List<DeliveryTemplate> shopLogistics(Long shopId) {
        String cacheKey = logisticCachePre + shopId;
        List<DeliveryTemplate> result = redisIO.getList(cacheKey, DeliveryTemplate.class);
        if (result != null && result.size() > 0) {
            return result;
        }
        result = new ArrayList<>();
        ShopeeGetLogisticsRequest request = new ShopeeGetLogisticsRequest();
        request.setShopId(shopId);
        ShopeeGetLogisticsResponse response = client.execute(request);
        if (response.isSuccess()) {
            List<ShopeeLogistic> logistics = response.getLogistics();
            if (logistics != null && logistics.size() > 0) {
                for (ShopeeLogistic logistic : logistics) {
                    if (logistic.getEnabled()!=null && logistic.getEnabled()) {
                        DeliveryTemplate template = new DeliveryTemplate();
                        template.setTemplateId(logistic.getLogisticId());
                        template.setName(logistic.getLogisticName());
                        result.add(template);
                    }

                }
            }
        }
        // 物流模板缓存20分钟
        redisIO.putTemp(cacheKey, result, 60 * 20);
        return result;
    }
}
