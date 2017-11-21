package com.shigu.order.vo;

public class ConfirmTbBatchOrderVO {
    private Integer orderNum;
    private Integer goodsNum;
    private String serviceTotalPrice;
    private String goodsTotalPrice;

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getServiceTotalPrice() {
        return this.serviceTotalPrice;
    }

    public void setServiceTotalPrice(String serviceTotalPrice) {
        this.serviceTotalPrice = serviceTotalPrice;
    }

    public String getGoodsTotalPrice() {
        return this.goodsTotalPrice;
    }

    public void setGoodsTotalPrice(String goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }
}
