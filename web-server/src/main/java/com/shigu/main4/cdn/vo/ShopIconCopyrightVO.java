package com.shigu.main4.cdn.vo;

/**
 * 店铺知识产权
 */
public class ShopIconCopyrightVO {

    private String imgSrc;//图片链接

    private Long shopId;//店铺ID

    private String shopName;//店铺名，市场加档口

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

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
}
