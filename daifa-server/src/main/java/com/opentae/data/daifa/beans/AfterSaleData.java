package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-08-31.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class AfterSaleData implements Serializable {
    @Transient
    private static final long serialVersionUID = -5227521944795611053L;
    @Column("daifa_trade.df_trade_id")
    private Long orderId;
    @Column("daifa_trade.receiver_name")
    private String receiverName;
    @Column("daifa_trade.receiver_phone")
    private String receiverPhone;
    @Column("daifa_trade.receiver_address")
    private String receiverAddress;
    @Column("daifa_trade.buyer_remark")
    private String buyerRemark;
    @Column("daifa_trade.money")
    private String totalFee;
    @Column("daifa_trade.express_fee")
    private String expressFee;
    @Column("daifa_trade.express_name")
    private String expressName;
    @Column("daifa_trade.express_code")
    private String expressCode;
    @Column("daifa_trade.trade_discount_fee")
    private String discountFee;
    @Column("daifa_trade.services_fee")
    private String serversFee;
    @Column("daifa_trade.after_remark")
    private String childRemark;
    @Column("DATE_FORMAT(daifa_trade.send_time,'%Y-%m-%d %H:%i:%s')")
    private String sendTime;
    @Column("DATE_FORMAT(daifa_trade.create_time,'%Y-%m-%d %H:%i:%s')")
    private String tradeTime;
    @Column("daifa_trade.trade_code")
    private String tradeCode;
    @Column("daifa_trade.is_old")
    private Integer oldOrder;
    @Column("daifa_trade.send_status")
    private Integer sendStatus;
    @Column("daifa_trade.buyer_ww")
    private String imWw;
    @Column("daifa_trade.buyer_qq")
    private String imQq;
    @Column("daifa_trade.buyer_telephone")
    private String imTel;
    @Column("daifa_trade.daifa_type=2")
    private Boolean isTbOrder;
    private List<AfterSaleSubData> childOrders;

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getServersFee() {
        return serversFee;
    }

    public void setServersFee(String serversFee) {
        this.serversFee = serversFee;
    }

    public String getChildRemark() {
        return childRemark;
    }

    public void setChildRemark(String childRemark) {
        this.childRemark = childRemark;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public List<AfterSaleSubData> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<AfterSaleSubData> childOrders) {
        this.childOrders = childOrders;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public Integer getOldOrder() {
        return oldOrder;
    }

    public void setOldOrder(Integer oldOrder) {
        this.oldOrder = oldOrder;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getImWw() {
        return this.imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getImQq() {
        return this.imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImTel() {
        return this.imTel;
    }

    public void setImTel(String imTel) {
        this.imTel = imTel;
    }

    public Boolean getIsTbOrder() {
        return this.isTbOrder;
    }

    public void setIsTbOrder(Boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }
}
