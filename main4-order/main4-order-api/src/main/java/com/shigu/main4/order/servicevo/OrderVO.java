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
    /**交易时间*/
    private Date tradeTime;
    /**交易总金额@以分为单位*/
    private Long tradePayLong;
    /** 交易总金额@以元为单位*/
    private String tradePay;
    /** 快递费*/
    private String postPay;
    /**服务费*/
    private String serverPay;
    /**
     * 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    private MainOrderStatusEnum mainState;
    /** 是否淘宝订单 **/
    private  Boolean isTbOrder;
    /** 站点 */
    private String webSire;


    private OrderType type;

    private Long payedFee;

    private String title;

    private Long refundFee;

    /**
     * 商品金额
     */
    private String orderPrice;




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

    public Date getTradeTime () {
        return tradeTime;
    }

    public void setTradeTime (Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Long getTradePayLong () {
        return tradePayLong;
    }

    public void setTradePayLong (Long tradePayLong) {
        this.tradePayLong = tradePayLong;
    }

    public String getTradePay () {
        return tradePay;
    }

    public void setTradePay (String tradePay) {
        this.tradePay = tradePay;
    }

    public String getPostPay () {
        return postPay;
    }

    public void setPostPay (String postPay) {
        this.postPay = postPay;
    }

    public String getServerPay () {
        return serverPay;
    }

    public void setServerPay (String serverPay) {
        this.serverPay = serverPay;
    }

    public MainOrderStatusEnum getMainState () {
        return mainState;
    }

    public void setMainState (MainOrderStatusEnum mainState) {
        this.mainState = mainState;
    }

    public Boolean getTbOrder () {
        return isTbOrder;
    }

    public void setTbOrder (Boolean istbOrder) {
        this.isTbOrder = istbOrder;
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
