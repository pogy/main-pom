package com.shigu.phone.basevo;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-17/16:47
 */
public class OneShopVO implements Serializable{
    //店铺ID	必须
    private Long shopId;
    //市场	必须
    private String market;
    //档口号	必须
    private String shopNum;
    //手机号	必须
    private String telephone;
    //商品数	必须
    private Integer itemNum;
    //今日上新	必须
    private Integer todayAdd;
    //星星数	必须
    private Integer starNum;
    //店铺头像	必须
    private String shopHeadUrl;
    //收藏ID
    private Long collectId;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Integer getTodayAdd() {
        return todayAdd;
    }

    public void setTodayAdd(Integer todayAdd) {
        this.todayAdd = todayAdd;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public String getShopHeadUrl() {
        return shopHeadUrl;
    }

    public void setShopHeadUrl(String shopHeadUrl) {
        this.shopHeadUrl = shopHeadUrl;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }
}
