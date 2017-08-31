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
public class AfterSaleData implements Serializable{
    @Transient
    private static final long serialVersionUID = -5227521944795611053L;
    @Column("daifa_after_sale.after_sale_id")
    private Long afterSaleId;
    @Column("daifa_after_sale.df_trade_id")
    private Long orderId;
    @Column("daifa_after_sale.receiver_name")
    private String receiverName;
    @Column("daifa_after_sale.receiver_mobile")
    private String receiverPhone;
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
    @Column("daifa_trade.send_time")
    private Date sendTime;
    @Column("daifa_trade.create_time")
    private Date createTime;

    private List<AfterSaleSubData> childOrders;

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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<AfterSaleSubData> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<AfterSaleSubData> childOrders) {
        this.childOrders = childOrders;
    }

    public Long getAfterSaleId() {
        return afterSaleId;
    }

    public void setAfterSaleId(Long afterSaleId) {
        this.afterSaleId = afterSaleId;
    }
}
