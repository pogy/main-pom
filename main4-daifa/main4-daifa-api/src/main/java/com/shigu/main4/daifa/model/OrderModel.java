package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.bo.DeliveryBO;

/**
 * 总单
 * 多例,描述了一个总单的所有操作
 * 有直接构建订单与按订单ID构建两种
 * 成员变量:tid   主订单ID
 * Created by zhaohongbo on 17/8/9.
 */
public interface OrderModel {
    /**
     * 创建订单
     */
    void init();

    /**
     * 订单超时
     */
    void timeout();

    /**
     * 发货
     * @param delivery
     */
    void send(DeliveryBO delivery);
}
