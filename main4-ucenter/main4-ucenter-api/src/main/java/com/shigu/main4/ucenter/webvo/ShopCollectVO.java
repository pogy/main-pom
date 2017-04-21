package com.shigu.main4.ucenter.webvo;

import java.io.Serializable;

/**
 * 店铺收藏
 * Created by zhaohongbo on 17/3/2.
 */
public class ShopCollectVO implements Serializable{
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 店名
     */
    private String shopName;
    /**
     * 市场名
     */
    private String market;
    /**
     * 主营类目
     */
    private String mainBus;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 实地位置
     */
    private String address;
    /**
     * 分站
     */
    private String website;
    /**
     * 收藏主键
     */
    private Long id;

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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMainBus() {
        return mainBus;
    }

    public void setMainBus(String mainBus) {
        this.mainBus = mainBus;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
