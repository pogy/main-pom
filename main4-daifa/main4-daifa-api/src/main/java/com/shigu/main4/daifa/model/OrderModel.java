package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.exceptions.DaifaException;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
    void send(DeliveryBO delivery) throws DaifaException;

    /**
     * 自动退款处理
     * @param refundId 退单ID
     * @param subOrderIds 退单包含的子单信息
     */
    void autoRefund(Long refundId,List<Long> subOrderIds) throws DaifaException;
}
