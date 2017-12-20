package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-08-14.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaAllOrder implements Serializable{
    @Transient
    private static final long serialVersionUID = -2685689810091540070L;
    @Column("daifa_trade.df_trade_id")
    private String orderId;//订单id

    @Column("daifa_trade.trade_code")
    private String tradeCode;//订单编号
    @Column("daifa_trade.send_status")
    private Integer tradeState;//交易状态1未发货2已发货
    @Column("DATE_FORMAT(daifa_trade.create_time,'%Y-%m-%d %H:%i:%s')")
    private String tradeTime;//交易时间
    @Column("daifa_trade.buyer_ww")
    private String imWw;//分销商ww

    @Column("daifa_trade.buyer_telephone")
    private String imTel;
    @Column("daifa_trade.buyer_qq")
    private String imQq;

    @Column("daifa_trade.receiver_name")
    private String receiverName;//收货人姓名
    @Column("daifa_trade.receiver_phone")
    private String receiverPhone;//收货人电话
    @Column("daifa_trade.receiver_address")
    private String receiverAddress;
    @Column("daifa_trade.buyer_remark")
    private String buyerRemark;//分销商留言
    @Column("daifa_trade.money")
    private String totalFee;//总费用
    @Column("daifa_trade.express_fee")
    private String expressFee;//快递费用
    @Column("daifa_trade.express_name")
    private String expressName;//快递名
    @Column("daifa_trade.express_code")
    private String expressCode;//快递单号
    @Column("daifa_trade.trade_discount_fee")
    private String discountFee;//减免费用
    @Column("daifa_trade.services_fee")
    private String serversFee;//服务费用
    @Column("daifa_trade.is_old")
    private Integer isOld;//是否是老订单
    @Column("daifa_trade.daifa_type=2")
    private Boolean isTbOrder;
    private List<DaifaAllSubOrder> childOrders;//子单数据

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getImWw() {
        return imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
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

    public Integer getIsOld() {
        return isOld;
    }

    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    public String getTradeCode () {
        return tradeCode;
    }

    public void setTradeCode (String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public List<DaifaAllSubOrder> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<DaifaAllSubOrder> childOrders) {
        this.childOrders = childOrders;
    }

    public String getImTel() {
        return this.imTel;
    }

    public void setImTel(String imTel) {
        this.imTel = imTel;
    }

    public String getImQq() {
        return this.imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public Boolean getIsTbOrder() {
        return this.isTbOrder;
    }

    public void setIsTbOrder(Boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }
}
