package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.OrderType;

import java.io.Serializable;

/**
 * 订单
 * Created by zhaohongbo on 17/6/1.
 */
public class OrderVO implements Serializable{
    private Long orderId;

    private OrderType type;

    private Long totalFee;

    private Long refundFee;

    private Long payedFee;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
    }

    public Long getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(Long payedFee) {
        this.payedFee = payedFee;
    }
}