package com.shigu.main4.daifa.vo;

import java.io.Serializable;

public class ExpressRelevanceSubVO implements Serializable {
    private Long dfOrderId;
    private String imgUrl;
    private String title;
    private String propStr;
    private String storeGoodsCode;
    private Integer goodsNum;
    private String price;
    private String piPrice;
    private String singleServerFee;
    private Integer afterStatus;
    private String postName;
    private String postCode;
    private Integer isScan;

    public Long getDfOrderId() {
        return this.dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPropStr() {
        return this.propStr;
    }

    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }

    public String getStoreGoodsCode() {
        return this.storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPiPrice() {
        return this.piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getSingleServerFee() {
        return this.singleServerFee;
    }

    public void setSingleServerFee(String singleServerFee) {
        this.singleServerFee = singleServerFee;
    }

    public Integer getAfterStatus() {
        return this.afterStatus;
    }

    public void setAfterStatus(Integer afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getPostName() {
        return this.postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getIsScan() {
        return this.isScan;
    }

    public void setIsScan(Integer isScan) {
        this.isScan = isScan;
    }
}
