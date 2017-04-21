package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 收藏的商品信息
 * Created by zhaohongbo on 17/3/2.
 */
public class ItemCollect implements Serializable{
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 店铺ID
     */
    private Long storeId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
