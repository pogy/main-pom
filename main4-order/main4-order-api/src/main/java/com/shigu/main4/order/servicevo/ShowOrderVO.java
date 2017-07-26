package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.enums.OrderType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：ShowOrderVO
 * @文件路径：com.shigu.main4.order.servicevo.ShowOrderVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 13:37
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ShowOrderVO implements Serializable {

    private Long orderId;
    /**交易时间*/
    private Date tradeTimed;
    /**交易总金额@以分为单位*/
    private Long tradePayLong;
    /** 交易总金额@以元为单位*/
    private String tradePay;
    /** 快递费*/
    private String postPay;
    private Long postPayLong;
    /**服务费*/
    private String serverPay;
    private Long serverPayLong;
    /**
     * 订单状态，1，2，3，4,5; 1等待付款, 2等待配货, 3已发货, 4交易完成, 5交易取消
     */
    private Integer mainState;
    /** 是否淘宝订单 **/
    private  boolean isTbOrder;
    /** 站点 */
    private String webSite;


    private OrderType type;

    private String payedFee;

    private Long payedFeeLong;

    private String title;

    private Long refundFeeLong;

    private String refundFee;
    /**
     * 商品金额
     */
    private String orderPrice;

    private String tradeTime;
    /** 订单创建时间  **/
    private String orderCreateTime;
    /** 订单创建时间 日期型 **/
    private Date orderCreateTimed;

    private Date distributionDated;//配货时间

    private String distributionDate;//配货时间

    private Date finishTimed;//完成时间

    private String finishTime;//完成时间

    /**
     * 子单数据
     */
    private List<SubOrderInfoVO> childOrders;


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

    public String getPayedFee () {
        return payedFee;
    }

    public void setPayedFee (String payedFee) {
        this.payedFee = payedFee;
    }

    public Long getPayedFeeLong () {
        return payedFeeLong;
    }

    public void setPayedFeeLong (Long payedFeeLong) {
        this.payedFeeLong = payedFeeLong;
    }

    public Long getRefundFeeLong () {
        return refundFeeLong;
    }

    public void setRefundFeeLong (Long refundFeeLong) {
        this.refundFeeLong = refundFeeLong;
    }

    public String getRefundFee () {
        return refundFee;
    }

    public void setRefundFee (String refundFee) {
        this.refundFee = refundFee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDistributionDated () {
        return distributionDated;
    }

    public void setDistributionDated (Date distributionDated) {
        this.distributionDated = distributionDated;
    }

    public String getDistributionDate () {
        return distributionDate;
    }

    public void setDistributionDate (String distributionDate) {
        this.distributionDate = distributionDate;
    }

    public Date getFinishTimed () {
        return finishTimed;
    }

    public void setFinishTimed (Date finishTimed) {
        this.finishTimed = finishTimed;
    }

    public String getFinishTime () {
        return finishTime;
    }

    public void setFinishTime (String finishTime) {
        this.finishTime = finishTime;
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

    public Long getPostPayLong () {
        return postPayLong;
    }

    public void setPostPayLong (Long postPayLong) {
        this.postPayLong = postPayLong;
    }

    public Long getServerPayLong () {
        return serverPayLong;
    }

    public void setServerPayLong (Long serverPayLong) {
        this.serverPayLong = serverPayLong;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getTradeTimed () {
        return tradeTimed;
    }

    public void setTradeTimed (Date tradeTimed) {
        this.tradeTimed = tradeTimed;
    }

    public String getTradeTime () {
        return tradeTime;
    }

    public void setTradeTime (String tradeTime) {
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

    public Integer getMainState () {
        return mainState;
    }

    public void setMainState (Integer mainState) {
        this.mainState = mainState;
    }

    public boolean getIsTbOrder () {
        return isTbOrder;
    }

    public void setIsTbOrder (boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }

    public List<SubOrderInfoVO> getChildOrders () {
        return childOrders;
    }

    public void setChildOrders (List<SubOrderInfoVO> childOrders) {
        this.childOrders = childOrders;
    }

    public String getOrderCreateTime () {
        return orderCreateTime;
    }

    public void setOrderCreateTime (String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderCreateTimed () {
        return orderCreateTimed;
    }

    public void setOrderCreateTimed (Date orderCreateTimed) {
        this.orderCreateTimed = orderCreateTimed;
    }
}
