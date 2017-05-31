package com.shigu.main4.storeservices;

/**
 * 店铺加入到ES服务
 * Created by zhaohongbo on 17/5/27.
 */
public interface ShopToEsService {

    /**
     * 添加数据到Es
     * @param shopId
     */
    void addToEs(Long shopId);

}
