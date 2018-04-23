package com.shigu.daifa.vo;

public class RefundedFeeVO {
    private String refundedDate;
    private String orderId;
    private String marketName;
    private String shopNum;
    private String goodsNo;
    private String price;

    public String getRefundedDate() {
        return this.refundedDate;
    }

    public void setRefundedDate(String refundedDate) {
        this.refundedDate = refundedDate;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return this.shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getGoodsNo() {
        return this.goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
