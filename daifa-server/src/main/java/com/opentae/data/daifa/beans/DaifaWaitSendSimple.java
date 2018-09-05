package com.opentae.data.daifa.beans;

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
    private Long dwsId;//代发id
    private Long orderId;//订单id
    private Integer tradeState;//交易状态1未发货2已发货
    private String tradeTime;//交易时间
    private String imQq;
    private String imTel;
    private String imWw;//分销商ww
    private String receiverName;//收货人姓名
    private String receiverPhone;//收货人电话
    private String buyerRemark;//分销商留言
    private String totalFee;//总费用
    private String expressFee;//快递费用
    private String expressName;//快递名
    private Long expressId;//快递id
    private String expressCode;//快递单号
    private String discountFee;//减免费用
    private String serversFee;//服务费用
    private String receiverAddress;
    private Boolean isTbOrder;
    private List<DaifaWaitSendOrderSimple> childOrders;//子单数据

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
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

    public Long getDwsId () {
        return dwsId;
    }

    public void setDwsId (Long dwsId) {
        this.dwsId = dwsId;
    }

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
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
