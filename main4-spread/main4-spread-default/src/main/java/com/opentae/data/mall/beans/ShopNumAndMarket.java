package com.opentae.data.mall.beans;

/**
 * 档口号和市场
 * Created by zhaohongbo on 17/5/13.
 */
public class ShopNumAndMarket {

    private Long shopId;

    private String shopNum;

    private String market;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
