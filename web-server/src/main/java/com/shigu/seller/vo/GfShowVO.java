package com.shigu.seller.vo;

/**
 *   港风活动页面商品数据
 * Created by bugzy on 2017/7/2 0002.
 */
public class GfShowVO {

    private Long goodsId;
    private String imgSrc;
    private String title;
    private String piPriceString;
    private String marketName;
    private String shopNum;
    private Long shopId;
    private int shStatus;
    private Long goodsStyleId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
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

    public int getShStatus() {
        return shStatus;
    }

    public void setShStatus(int shStatus) {
        this.shStatus = shStatus;
    }

    public Long getGoodsStyleId() {
        return goodsStyleId;
    }

    public void setGoodsStyleId( Long goodsStyleId ) {
        this.goodsStyleId = goodsStyleId;
    }
}
