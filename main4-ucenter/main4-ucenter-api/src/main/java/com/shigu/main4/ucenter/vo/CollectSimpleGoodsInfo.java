package com.shigu.main4.ucenter.vo;

import java.io.Serializable;

/**
 * 类名：CollectSimpleGoodsInfo
 * 类路径：com.shigu.main4.ucenter.vo.CollectSimpleGoodsInfo
 * 创建者：王浩翔
 * 创建时间：2017-10-17 12:29
 * 项目：main-pom
 * 描述：
 */
public class CollectSimpleGoodsInfo implements Serializable {

    private Long goodsId;
    private String title;
    private String picUrl;
    private String goodsNo;
    private String piPriceString;
    private Long storeId;
    private Boolean onSaleIs;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPriceString() {
        return piPriceString;
    }

    public void setPiPriceString(String piPriceString) {
        this.piPriceString = piPriceString;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Boolean getOnSaleIs() {
        return onSaleIs;
    }

    public void setOnSaleIs(Boolean onSaleIs) {
        this.onSaleIs = onSaleIs;
    }
}
