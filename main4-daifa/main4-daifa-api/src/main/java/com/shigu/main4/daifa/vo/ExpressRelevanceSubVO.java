package com.shigu.main4.daifa.vo;

import java.io.Serializable;

public class ExpressRelevanceSubVO implements Serializable {
    private Long childOrderId;//子单id
    private String imgSrc;//商品图片
    private String title;//商品标题
    private String goodsProperty;//商品属性 颜色 尺码
    private String goodsNo;//商品货号
    private String piPrice;//商品批发价
    private String payPrice;//商品实际支付价
    private Integer num;//商品数量
    private String storeGoodsCode;//商家编码
    private String childServersFee;
    private Boolean isInCangKu;
    private String childRemark;
    private Integer afterSaleState;
    private String afterSalePostCode;
    private String afterSalePostName;
    private Boolean nowScanPostIs;

    public Long getChildOrderId() {
        return this.childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getImgSrc() {
        return this.imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoodsProperty() {
        return this.goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPiPrice() {
        return this.piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPayPrice() {
        return this.payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStoreGoodsCode() {
        return this.storeGoodsCode;
    }

    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }

    public String getChildServersFee() {
        return this.childServersFee;
    }

    public void setChildServersFee(String childServersFee) {
        this.childServersFee = childServersFee;
    }

    public Boolean getIsInCangKu() {
        return this.isInCangKu;
    }

    public void setIsInCangKu(Boolean isInCangKu) {
        this.isInCangKu = isInCangKu;
    }

    public String getChildRemark() {
        return this.childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public Integer getAfterSaleState() {
        return this.afterSaleState;
    }

    public void setAfterSaleState(Integer afterSaleState) {
        this.afterSaleState = afterSaleState;
    }

    public String getAfterSalePostCode() {
        return this.afterSalePostCode;
    }

    public void setAfterSalePostCode(String afterSalePostCode) {
        this.afterSalePostCode = afterSalePostCode;
    }

    public String getAfterSalePostName() {
        return this.afterSalePostName;
    }

    public void setAfterSalePostName(String afterSalePostName) {
        this.afterSalePostName = afterSalePostName;
    }

    public Boolean getNowScanPostIs() {
        return this.nowScanPostIs;
    }

    public void setNowScanPostIs(Boolean nowScanPostIs) {
        this.nowScanPostIs = nowScanPostIs;
    }
}
