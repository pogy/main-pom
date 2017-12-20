package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/26.
 * 售后主单简要数据
 */
public class AfterSaleSimpleOrderVO implements Serializable{
    /**
     * 订单号
     */
    private Long orderId;
    /**
     * 成交时间
     */
    private String endDate;
    /**
     * 商品价格
     */
    private Long orderPrice;
    /**
     * 快递费
     */
    private Long expressPrice;
    /**
     * 服务费
     */
    private Long servicePrice;
    /**
     * 订单总价
     */
    private Long totalPrice;

    /**
     * 获取 订单号
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单号
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 成交时间
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * 设置 成交时间
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取 商品价格
     */
    public Long getOrderPrice() {
        return this.orderPrice;
    }

    /**
     * 设置 商品价格
     */
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取 快递费
     */
    public Long getExpressPrice() {
        return this.expressPrice;
    }

    /**
     * 设置 快递费
     */
    public void setExpressPrice(Long expressPrice) {
        this.expressPrice = expressPrice;
    }

    /**
     * 获取 服务费
     */
    public Long getServicePrice() {
        return this.servicePrice;
    }

    /**
     * 设置 服务费
     */
    public void setServicePrice(Long servicePrice) {
        this.servicePrice = servicePrice;
    }

    /**
     * 获取 订单总价
     */
    public Long getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * 设置 订单总价
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
