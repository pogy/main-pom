package com.shigu.main4.ucenter.webvo;

import java.io.Serializable;

/**
 * 类名：ShopInfo
 * 类路径：com.shigu.main4.ucenter.webvo.ShopInfo
 * 创建者：王浩翔
 * 创建时间：2017-10-16 15:45
 * 项目：main-pom
 * 描述：店铺信息
 */
public class ShopInfo implements Serializable {

    //档口id
    private Long shopId;
    //市场名
    private String marketName;
    //档口号
    private String shopNum;
    //档口图标
    private String shopImgSrc;
    //店铺旺旺
    private String imWw;
    //店铺qq
    private String imQq;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getShopImgSrc() {
        return shopImgSrc;
    }

    public void setShopImgSrc(String shopImgSrc) {
        this.shopImgSrc = shopImgSrc;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }
}
