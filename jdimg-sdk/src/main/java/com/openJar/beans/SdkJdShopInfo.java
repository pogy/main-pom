package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.util.Date;

public class SdkJdShopInfo extends OpenBean{

    /**
     * 用户京东账号ID
     */
    private Long jdUid;

    /**
     * 店铺编号
     */
    private Long shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * logo地址
     */
    private String logoUrl;
    /**
     * 主营类目编号
     */
    private Long categoryMain;
    /**
     * 主营类目名称
     */
    private String categoryMainName;
    /**
     * 商家编号
     */
    private Long venderId;
    /**
     * 店铺简介
     */
    private String brief;

    /**
     * 开店时间
     */
    private Date openTime;

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCategoryMainName() {
        return categoryMainName;
    }

    public void setCategoryMainName(String categoryMainName) {
        this.categoryMainName = categoryMainName;
    }

    public Long getCategoryMain() {
        return categoryMain;
    }

    public void setCategoryMain(Long categoryMain) {
        this.categoryMain = categoryMain;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getJdUid() {
        return jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }
}
