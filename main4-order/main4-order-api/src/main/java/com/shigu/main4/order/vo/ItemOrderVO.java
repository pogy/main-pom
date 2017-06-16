package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.OrderStatus;

/**
 * 商品类别订单
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderVO extends OrderVO{

    private Long senderId;

    private OrderStatus orderStatus;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
