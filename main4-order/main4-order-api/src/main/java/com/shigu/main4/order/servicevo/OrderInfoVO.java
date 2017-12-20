package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.MainOrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhaohongbo on 17/7/14.
 */
public class OrderInfoVO implements Serializable{
    /**
     * 主单ID
     */
    private Long orderId;
    /**
     * 成交时间
     */
    private Date orderDealTime;
    /**
     * 商品金额
     */
    private String orderPrice;
    /**
     * 快递费
     */
    private String expressPrice;
    /**
     * 服务费
     */
    private String servicePrice;
    /**
     * 订单总价
     */
    private String totalPrice;
    /**
     * 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    private MainOrderStatusEnum orderState;
    /**
     * 发货方式
     */
    private String orderPostType;

    /**
     * 结束时间(订单自动关闭时间?)
     */
    private Date endTime;
    /**
     * 系统时间
     */
    private Date nowTime;

    /**
     * 获取 主单ID
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 主单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 成交时间
     */
    public Date getOrderDealTime() {
        return this.orderDealTime;
    }

    /**
     * 设置 成交时间
     */
    public void setOrderDealTime(Date orderDealTime) {
        this.orderDealTime = orderDealTime;
    }

    /**
     * 获取 商品金额
     */
    public String getOrderPrice() {
        return this.orderPrice;
    }

    /**
     * 设置 商品金额
     */
    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取 快递费
     */
    public String getExpressPrice() {
        return this.expressPrice;
    }

    /**
     * 设置 快递费
     */
    public void setExpressPrice(String expressPrice) {
        this.expressPrice = expressPrice;
    }

    /**
     * 获取 服务费
     */
    public String getServicePrice() {
        return this.servicePrice;
    }

    /**
     * 设置 服务费
     */
    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    /**
     * 获取 订单总价
     */
    public String getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * 设置 订单总价
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取 发货方式
     */
    public String getOrderPostType() {
        return this.orderPostType;
    }

    /**
     * 设置 发货方式
     */
    public void setOrderPostType(String orderPostType) {
        this.orderPostType = orderPostType;
    }



    /**
     * 获取 结束时间(订单自动关闭时间?)
     */
    public Date getEndTime() {
        return this.endTime;
    }

    /**
     * 设置 结束时间(订单自动关闭时间?)
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 系统时间
     */
    public Date getNowTime() {
        return this.nowTime;
    }

    /**
     * 设置 系统时间
     */
    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    /**
     * 获取 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public MainOrderStatusEnum getOrderState() {
        return this.orderState;
    }

    /**
     * 设置 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    public void setOrderState(MainOrderStatusEnum orderState) {
        this.orderState = orderState;
    }


    @Override
    public String toString() {
        return "OrderInfoVO{" +
                "orderId=" + orderId +
                ", orderDealTime=" + orderDealTime +
                ", orderPrice='" + orderPrice + '\'' +
                ", expressPrice='" + expressPrice + '\'' +
                ", servicePrice='" + servicePrice + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", orderState=" + orderState +
                ", orderPostType='" + orderPostType + '\'' +

                ", endTime=" + endTime +
                ", nowTime=" + nowTime +
                '}';
    }
}
