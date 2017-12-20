package com.shigu.order.vo;

public class RefundOrderVO {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 成交时间
     */
    private String orderDealTime;
    /**
     * 商品价格
     */
    private String orderGoodsPrice;
    /**
     * 快递费
     */
    private String orderExpressPrice;
    /**
     * 服务费
     */
    private String orderServicePrice;
    /**
     * 订单总金额
     */
    private String orderTotalPrice;

    /**
     * 获取 订单id
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 成交时间
     */
    public String getOrderDealTime() {
        return this.orderDealTime;
    }

    /**
     * 设置 成交时间
     */
    public void setOrderDealTime(String orderDealTime) {
        this.orderDealTime = orderDealTime;
    }

    /**
     * 获取 商品价格
     */
    public String getOrderGoodsPrice() {
        return this.orderGoodsPrice;
    }

    /**
     * 设置 商品价格
     */
    public void setOrderGoodsPrice(String orderGoodsPrice) {
        this.orderGoodsPrice = orderGoodsPrice;
    }

    /**
     * 获取 快递费
     */
    public String getOrderExpressPrice() {
        return this.orderExpressPrice;
    }

    /**
     * 设置 快递费
     */
    public void setOrderExpressPrice(String orderExpressPrice) {
        this.orderExpressPrice = orderExpressPrice;
    }

    /**
     * 获取 服务费
     */
    public String getOrderServicePrice() {
        return this.orderServicePrice;
    }

    /**
     * 设置 服务费
     */
    public void setOrderServicePrice(String orderServicePrice) {
        this.orderServicePrice = orderServicePrice;
    }

    /**
     * 获取 订单总金额
     */
    public String getOrderTotalPrice() {
        return this.orderTotalPrice;
    }

    /**
     * 设置 订单总金额
     */
    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
