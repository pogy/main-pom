package com.shigu.main4.ucenter.webvo;

import java.io.Serializable;

/**
 * 店铺收藏
 * Created by zhaohongbo on 17/3/2.
 */
public class ShopCollectVO implements Serializable{
    //收藏id
    private Long collId;
    //店铺id
    private Long shopId;
    //分站
    private String webSite;
    //市场
    private String marketName;
    //档口号
    private String shopNum;
    //店铺图片
    private String  shopImgSrc;
    //店铺旺旺
    private String imWw;
    //店铺QQ
    private String imQq;

    public Long getCollId() {
        return collId;
    }

    public void setCollId(Long collId) {
        this.collId = collId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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
