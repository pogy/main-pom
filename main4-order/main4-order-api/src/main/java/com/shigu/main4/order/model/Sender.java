package com.shigu.main4.order.model;

/**
 * 发货单位
 * Created by zhaohongbo on 17/7/18.
 */
public interface Sender {
    /**
     * 发货
     * @param order
     */
    void sendOrder(Order order);//发放订单给代发


}
