package com.shigu.order.vo;

import com.opentae.core.mybatis.config.Column;

import java.util.Date;
import java.util.List;

public class MyOrderVO {
    /**
     * 订单id
     */
    @Column("item_order.oid")
    private Long orderId;
    /**
     * 交易时间(支付时间)
     */
    @Column("item_order.create_time")
    private String tradeTime;
    /**
     * 淘宝订单id
     */
    @Column("item_order.outer_id")
    private String tbOrderId;
    /**
     * 交易总金额
     */
    @Column("convert(item_order.total_fee*0.01,decimal(10,2))")
    private String tradePay;
    /**
     * 快递费
     */
    @Column("convert(item_order_logistics.money*0.01,decimal(10,2))")
    private String postPay;
    /**
     * 服务费
     */
    private String serverPay;
    /**
     * 订单主状态 1待付款，2待配货，3已发货，4交易完成，5交易取消
     */
    @Column("item_order.order_status")
    private Integer mainState;
    /**
     * 是否淘宝订单
     */
    @Column("item_order.type=2")
    private Boolean isTbOrder;
    /**
     * 站点
     */
    @Column("item_order.web_site")
    private String webSite;

    /**
     * 是否已标记淘宝发货
     */
    @Column("item_order.tb_send")
    private Boolean isTbShipments;

    @Column("item_order.pay_time")
    private Date payTime;

    /**
     * 子单数据
     */
    private List<SubMyOrderVO> childOrders;

    /**
     * 获取 订单id
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 交易时间(支付时间)
     */
    public String getTradeTime() {
        return this.tradeTime;
    }

    /**
     * 设置 交易时间(支付时间)
     */
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取 交易总金额
     */
    public String getTradePay() {
        return this.tradePay;
    }

    /**
     * 设置 交易总金额
     */
    public void setTradePay(String tradePay) {
        this.tradePay = tradePay;
    }

    /**
     * 获取 快递费
     */
    public String getPostPay() {
        return this.postPay;
    }

    /**
     * 设置 快递费
     */
    public void setPostPay(String postPay) {
        this.postPay = postPay;
    }

    /**
     * 获取 服务费
     */
    public String getServerPay() {
        return this.serverPay;
    }

    /**
     * 设置 服务费
     */
    public void setServerPay(String serverPay) {
        this.serverPay = serverPay;
    }

    /**
     * 获取 订单主状态 1待付款，2待配货，3已发货，4交易完成，5交易取消
     */
    public Integer getMainState() {
        return this.mainState;
    }

    /**
     * 设置 订单主状态 1待付款，2待配货，3已发货，4交易完成，5交易取消
     */
    public void setMainState(Integer mainState) {
        this.mainState = mainState;
    }

    /**
     * 获取 是否淘宝订单
     */
    public Boolean getIsTbOrder() {
        return this.isTbOrder;
    }

    /**
     * 设置 是否淘宝订单
     */
    public void setIsTbOrder(Boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }

    /**
     * 获取 站点
     */
    public String getWebSite() {
        return this.webSite;
    }

    /**
     * 设置 站点
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * 获取 子单数据
     */
    public List<SubMyOrderVO> getChildOrders() {
        return this.childOrders;
    }

    /**
     * 设置 子单数据
     */
    public void setChildOrders(List<SubMyOrderVO> childOrders) {
        this.childOrders = childOrders;
    }

    /**
     * 获取 是否已标记淘宝发货
     */
    public Boolean getIsTbShipments() {
        return this.isTbShipments;
    }

    /**
     * 设置 是否已标记淘宝发货
     */
    public void setIsTbShipments(Boolean isTbShipments) {
        this.isTbShipments = isTbShipments;
    }

    public String getTbOrderId() {
        return tbOrderId;
    }

    public void setTbOrderId(String tbOrderId) {
        this.tbOrderId = tbOrderId;
    }

    public Boolean getTbOrder() {
        return isTbOrder;
    }

    public void setTbOrder(Boolean tbOrder) {
        isTbOrder = tbOrder;
    }

    public Date getPayTime() {
        return this.payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
