package com.shigu.daifa.vo;

public class InOutDaifaStockVO {
    private Long childOrderId;//子单id
    private String goodsNo;//	商品货号
    private String goodsProperty;//	商品属性
    private String piPrice;//	商品金额
    private String putInTime;//	入库时间
    private String remark;//	备注

    public Long getChildOrderId() {
        return this.childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsProperty() {
        return this.goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getPiPrice() {
        return this.piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getPutInTime() {
        return this.putInTime;
    }

    public void setPutInTime(String putInTime) {
        this.putInTime = putInTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
