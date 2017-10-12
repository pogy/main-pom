package com.opentae.data.daifa.beans;

import com.opentae.core.mybatis.config.Column;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pc on 2017-08-14.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaSendSimple implements Serializable{
    @Transient
    private static final long serialVersionUID = -2685689810091540070L;
    @Column("daifa_send.send_id")
    private Long sendId;//代发id
    @Column("daifa_send.df_trade_id")
    private Long orderId;//订单id
    @Column("daifa_send.send_status")
    private Integer tradeState;//交易状态1未发货2已发货
    @Column("DATE_FORMAT(daifa_trade.create_time,'%Y-%m-%d %H:%i:%s')")
    private String tradeTime;//交易时间
    @Column("DATE_FORMAT(daifa_send.create_time,'%Y-%m-%d %H:%i:%s')")
    private String sendTime;
    @Column("daifa_send.buyer_ww")
    private String imWw;//分销商ww
    @Column("daifa_send.receiver_name")
    private String receiverName;//收货人姓名
    @Column("daifa_send.receiver_phone")
    private String receiverPhone;//收货人电话
    @Column("daifa_send.buyer_remark")
    private String buyerRemark;//分销商留言
    @Column("daifa_send.money")
    private String totalFee;//总费用
    @Column("daifa_send.express_fee")
    private String expressFee;//快递费用
    @Column("daifa_send.express_name")
    private String expressName;//快递名
    @Column("daifa_send.express_code")
    private String expressCode;//快递单号
    @Column("daifa_trade.trade_discount_fee")
    private String discountFee;//减免费用
    @Column("daifa_trade.services_fee")
    private String serversFee;//服务费用
    @Column("daifa_trade.buyer_qq")
    private String imQq;
    @Column("daifa_trade.buyer_telephone")
    private String imTel;
    @Column("daifa_trade.daifa_type=2")
    private Boolean isTbOrder;
    private List<DaifaSendOrderSimple> childOrders;//子单数据

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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
    public List<DaifaSendOrderSimple> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<DaifaSendOrderSimple> childOrders) {
        this.childOrders = childOrders;
    }

    public Long getSendId() {
        return this.sendId;
    }

    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public String getImTel() {
        return imTel;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
