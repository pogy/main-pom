package com.openJar.beans;

import com.openJar.utils.OpenBean;

/**
 * 类名：AppShopBlock
 * 类路径：com.openJar.beans.AppShopBlock
 * 创建者：王浩翔
 * 创建时间：2017-08-29 12:30
 * 项目：main-pom
 * 描述：app端店铺块信息
 */
public class AppShopBlock extends OpenBean {
    //店铺ID
    private Long shopId;
    //市场
    private String market;
    //高亮的市场
    private String highLightMarket;
    //档口
    private String shopNum;
    //高亮的档口
    private String highLightShopNum;
    //todo:String/Integer
    //星星数
    private String starNum;
    //联系电话
    private String telephone;
    //旺旺
    private String imAliww;
    //QQ号
    private String imQq;
    //主营类目
    private String mainCase;
    //商品数
    private Integer itemNum;
    //店铺头像
    private String shopHeadUrl;

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

    public String getHighLightMarket() {
        return highLightMarket;
    }

    public void setHighLightMarket(String highLightMarket) {
        this.highLightMarket = highLightMarket;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getHighLightShopNum() {
        return highLightShopNum;
    }

    public void setHighLightShopNum(String highLightShopNum) {
        this.highLightShopNum = highLightShopNum;
    }

    public String getStarNum() {
        return starNum;
    }

    public void setStarNum(String starNum) {
        this.starNum = starNum;
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

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getShopHeadUrl() {
        return shopHeadUrl;
    }

    public void setShopHeadUrl(String shopHeadUrl) {
        this.shopHeadUrl = shopHeadUrl;
    }
}
