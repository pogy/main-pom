package com.shigu.main4.jd.vo;

import java.io.Serializable;

/**
 * 京东店铺信息
 * Created By admin on 2017/12/14/15:47
 */
public class JdShopInfoVO implements Serializable{

    private static final long serialVersionUID = 2288239808142507050L;

    private String openTime;
    private Long shopId;
    private String categoryMainName;
    private String categoryMain;
    /**
    * 供应商ID
    */
    private Long venderId;
    private String brief;
    private String logoUrl;
    private String shopName;

    public JdShopInfoVO() {
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
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

    public String getCategoryMain() {
        return categoryMain;
    }

    public void setCategoryMain(String categoryMain) {
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
}
