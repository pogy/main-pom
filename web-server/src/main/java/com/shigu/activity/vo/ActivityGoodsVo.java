package com.shigu.activity.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.activity.vo
 * @ClassName: ActivityGoodsVo
 * @Author: sy
 * @CreateDate: 2018/9/20 0020 17:59
 */
public class ActivityGoodsVo implements Serializable{

    private Long goodsId;
    private String imgSrc;
    private String marketName;
    private Long marketId;
    private String shopNum;
    private Long shopId;
    private String piPriceString;
    private String title;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMarketId() {
        return this.marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
}
