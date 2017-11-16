package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：StatisGoodsVO
 * @文件路径：com.shigu.admin.vo.StatisGoodsVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/7 15:04
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class StatisGoodsVO implements Serializable{

    /**市场ID*/
    private Long marketId;
    /**市场名*/
    private String marketName;
    /**楼层名*/
    private String floorName;
    /**店铺ID*/
    private Long storeId;
    /**档口号*/
    private String storeNum;
    /**商品ID*/
    private Long goodsId;
    /**货号*/
    private String goodsCode;
    /**标题*/
    private String title;
    /**商家编码*/
    private String storeGoodsCode;
    /**需要的货数量*/
    private Integer goodsNum;
    /**单件拿货价*/
    private String singlePiPrice;

    public Long getMarketId () {
        return marketId;
    }

    public void setMarketId (Long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName () {
        return marketName;
    }

    public void setMarketName (String marketName) {
        this.marketName = marketName;
    }

    public String getFloorName () {
        return floorName;
    }

    public void setFloorName (String floorName) {
        this.floorName = floorName;
    }

    public Long getStoreId () {
        return storeId;
    }

    public void setStoreId (Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreNum () {
        return storeNum;
    }

    public void setStoreNum (String storeNum) {
        this.storeNum = storeNum;
    }

    public Long getGoodsId () {
        return goodsId;
    }

    public void setGoodsId (Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode () {
        return goodsCode;
    }

    public void setGoodsCode (String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getStoreGoodsCode () {
        return storeGoodsCode;
    }

    public void setStoreGoodsCode (String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public Integer getGoodsNum () {
        return goodsNum;
    }

    public void setGoodsNum (Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getSinglePiPrice () {
        return singlePiPrice;
    }

    public void setSinglePiPrice (String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }
}
