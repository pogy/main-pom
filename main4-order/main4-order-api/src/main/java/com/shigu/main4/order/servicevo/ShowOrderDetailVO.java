package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.MainOrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zf on 2017/7/27.
 */
public class ShowOrderDetailVO implements Serializable{
    private Long orderId;
    /**
     * 订单创建时间 日期型
     */
    private Date orderCreateTimed;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 发货时间
     */
    private Date sendTime;
    /**
     * 订单完成时间
     */
    private Date finishTimed;
    /**
     * 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    private MainOrderStatusEnum mainState;
    /**
     * 订单总金额
     */
    private Long orderPrice;
    /**
     * 快递费
     */
    private Long postPrice;
    /**
     * 服务费
     */
    private Long serverPrice;

    /**
     * 是否淘宝订单
     */
    private Boolean isTbOrder;

    public Boolean getIsTbOrder() {
        return isTbOrder;
    }

    public void setIsTbOrder(Boolean tbOrder) {
        isTbOrder = tbOrder;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 订单创建时间 日期型
     */
    public Date getOrderCreateTimed() {
        return this.orderCreateTimed;
    }

    /**
     * 设置 订单创建时间 日期型
     */
    public void setOrderCreateTimed(Date orderCreateTimed) {
        this.orderCreateTimed = orderCreateTimed;
    }

    /**
     * 获取 支付时间
     */
    public Date getPayTime() {
        return this.payTime;
    }

    /**
     * 设置 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取 发货时间
     */
    public Date getSendTime() {
        return this.sendTime;
    }

    /**
     * 设置 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取 订单完成时间
     */
    public Date getFinishTimed() {
        return this.finishTimed;
    }

    /**
     * 设置 订单完成时间
     */
    public void setFinishTimed(Date finishTimed) {
        this.finishTimed = finishTimed;
    }

    /**
     * 获取 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public MainOrderStatusEnum getMainState() {
        return this.mainState;
    }

    /**
     * 设置 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public void setMainState(MainOrderStatusEnum mainState) {
        this.mainState = mainState;
    }

    /**
     * 获取 订单总金额
     */
    public Long getOrderPrice() {
        return this.orderPrice;
    }

    /**
     * 设置 订单总金额
     */
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取 快递费
     */
    public Long getPostPrice() {
        return this.postPrice;
    }

    /**
     * 设置 快递费
     */
    public void setPostPrice(Long postPrice) {
        this.postPrice = postPrice;
    }

    /**
     * 获取 服务费
     */
    public Long getServerPrice() {
        return this.serverPrice;
    }

    /**
     * 设置 服务费
     */
    public void setServerPrice(Long serverPrice) {
        this.serverPrice = serverPrice;
    }
}
