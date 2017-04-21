package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 搜索到的档口数据
 * Created by zhaohongbo on 17/4/5.
 */
public class SearchShop implements Serializable{
    private static final long serialVersionUID = -932028873075713612L;
    /**
     * id
     */
    private Long shopId;
    /**
     * 市场
     */
    private String market;
    /**
     * 高亮市场
     */
    private String highLightMarket;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 高亮档口号
     */
    private String highLightShopNum;
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

    public String getHighLightMarket() {
        return highLightMarket;
    }

    public void setHighLightMarket(String highLightMarket) {
        this.highLightMarket = highLightMarket;
    }

    public String getHighLightShopNum() {
        return highLightShopNum;
    }

    public void setHighLightShopNum(String highLightShopNum) {
        this.highLightShopNum = highLightShopNum;
    }
}
