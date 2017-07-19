package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.enums.MainOrderStatusEnum;
import com.shigu.main4.order.enums.OrderType;

import java.io.Serializable;
import java.util.Date;

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

    private String title;

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
     * 站点
     */
    private String webSire;
    /**
     * 子单数据
     */
    private SubOrderInfoVO childOrders;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
     * 获取 站点
     */
    public String getWebSire() {
        return this.webSire;
    }

    /**
     * 设置 站点
     */
    public void setWebSire(String webSire) {
        this.webSire = webSire;
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

    /**
     * 获取 子单数据
     */
    public SubOrderInfoVO getChildOrders() {
        return this.childOrders;
    }

    /**
     * 设置 子单数据
     */
    public void setChildOrders(SubOrderInfoVO childOrders) {
        this.childOrders = childOrders;
    }
}
