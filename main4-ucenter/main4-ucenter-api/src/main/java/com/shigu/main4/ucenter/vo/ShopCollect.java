package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 店铺收藏信息
 * Created by zhaohongbo on 17/3/2.
 */
public class ShopCollect implements Serializable{
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 分站标识
     */
    private String website;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
