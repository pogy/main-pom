package com.shigu.daifa.vo;

public class DaifaStockRecordVO {
    private Long childOrderId;
    private String goodsNo;
    private String goodsProperty;
    private String piPrice;
    private Integer type;
    private String time;
    private String opeName;
    private String remark;

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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOpeName() {
        return this.opeName;
    }

    public void setOpeName(String opeName) {
        this.opeName = opeName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
