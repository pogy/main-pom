package com.shigu.activity.tempvo;

/**
 * 类名：PopularGoodsVO
 * 类路径：com.shigu.activity.tempvo.PopularGoodsVO
 * 创建者：王浩翔
 * 创建时间：2017-08-11 12:12
 * 项目：main-pom
 * 描述：秋装新品发布会0811临时使用
 */
public class PopularGoodsVO {
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品图片
     */
    private String imgSrc;
    /**
     * 商品档口所属市场
     */
    private String marketName;
    /**
     * 商品档口id
     */
    private Long shopId;
    /**
     * 商品档口号
     */
    private String shopNum;
    /**
     * 商品价格
     */
    private String piPriceString;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 售后状态 0不可退不可换 1可退 2可换 3可退可换
     * todo
     */
    private Integer shStatus;

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

    public Integer getShStatus() {
        return shStatus;
    }

    public void setShStatus(Integer shStatus) {
        this.shStatus = shStatus;
    }
}
