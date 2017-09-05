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
public class DaifaWaitSendSimple implements Serializable{
    @Transient
    private static final long serialVersionUID = -2685689810091540070L;
    @Column("daifa_wait_send.dws_id")
    private String dswId;//代发id
    @Column("daifa_wait_send.df_trade_id")
    private String orderId;//订单id
    @Column("daifa_wait_send.send_status")
    private Integer tradeState;//交易状态1未发货2已发货
    @Column("daifa_wait_send.create_time")
    private String tradeTime;//交易时间
    @Column("daifa_wait_send.buyer_ww")
    private String imWw;//分销商ww
    @Column("daifa_wait_send.receiver_name")
    private String receiverName;//收货人姓名
    @Column("daifa_wait_send.receiver_phone")
    private String receiverPhone;//收货人电话
    @Column("daifa_wait_send.buyer_remark")
    private String buyerRemark;//分销商留言
    @Column("daifa_wait_send.money")
    private String totalFee;//总费用
    @Column("daifa_wait_send.express_fee")
    private String expressFee;//快递费用
    @Column("daifa_wait_send.express_name")
    private String expressName;//快递名
    @Column("daifa_wait_send.express_code")
    private String expressCode;//快递单号
    @Column("daifa_wait_send.trade_discount_fee")
    private String discountFee;//减免费用
    @Column("daifa_wait_send.services_fee")
    private String serversFee;//服务费用

    private List<DaifaWaitSendOrderSimple> childOrders;//子单数据

    public static long getSerialVersionUID() {
        return serialVersionUID;
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



    public List<DaifaWaitSendOrderSimple> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<DaifaWaitSendOrderSimple> childOrders) {
        this.childOrders = childOrders;
    }

    public String getDswId() {
        return dswId;
    }

    public void setDswId(String dswId) {
        this.dswId = dswId;
    }
}
