package com.shigu.main4.ucenter.bo;

import java.io.Serializable;

/**
 * 类名：ShopeeUserBO
 * 类路径： com.shigu.main4.ucenter.bo.ShopeeUserBO
 * 创建者： whx
 * 创建时间： 10/22/18 3:22 PM
 * 项目： main-pom
 * 描述：
 */
public class ShopeeUserBO implements Serializable {

    /**
     * 虾皮店铺id
     */
    private Long shopId;

    /**
     * 店铺名
     */
    private String shopName;

    /**
     * 国家、地区码
     */
    private String country;


    private String shopDescription;

    /**
     * 店铺商品限制
     */
    private Long itemLimit;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public Long getItemLimit() {
        return itemLimit;
    }

    public void setItemLimit(Long itemLimit) {
        this.itemLimit = itemLimit;
    }
}
