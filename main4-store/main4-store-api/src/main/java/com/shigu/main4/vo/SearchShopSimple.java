package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 搜索到的档口数据
 * Created by zhaohongbo on 17/4/5.
 */
public class SearchShopSimple implements Serializable{
    private static final long serialVersionUID = -619132778125105099L;
    /**
     * id
     */
    private Long shopId;
    /**
     * 市场ID
     */
    private Long marketId;
    /**
     * 市场
     */
    private String market;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 星星数
     */
    private String starNum;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 旺旺
     */
    private String imAliww;
    /**
     * QQ号
     */
    private String imQq;

    /**
     * 主营类目
     */
    private String mainCase;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getMainCase() {
        return mainCase;
    }

    public void setMainCase(String mainCase) {
        this.mainCase = mainCase;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    @Override
    public String toString() {
        return "SearchShopSimple{" +
                "marketId=" + marketId +
                '}';
    }
}
