package com.shigu.daifa.vo;

import java.util.List;

/**
 * Created by pc on 2017-09-05.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DaifaWaitSendVO {
    private Long dwsId;
    private Long orderId;
    private String tradeCode;
    private String receiverName;
    private String receiverPhone;
    private String buyerRemark;
    private String totalFee;
    private String expressFee;
    private String expressName;
    private String expressCode;
    private String discountFee;
    private String serversFee;
    private String childRemark;
    private String sendTime;
    private String tradeTime;
    private Boolean oldOrder;
    private Integer sendStatus;
    private String receiverAddress;
    private String imWw;
    private String imQq;
    private String imTel;
    private Boolean isTbOrder;
    private Integer manual;
    private  boolean enableSendBtn;

    public boolean isEnableSendBtn() {
        return enableSendBtn;
    }

    public void setEnableSendBtn(boolean enableSendBtn) {
        this.enableSendBtn = enableSendBtn;
    }

    private List<WaitSendOrderVO> childOrders;

    public Integer getManual() {
        return manual;
    }

    public void setManual(Integer manual) {
        this.manual = manual;
    }

    public Long getDwsId() {
        return dwsId;
    }

    public void setDwsId(Long dwsId) {
        this.dwsId = dwsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
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

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Boolean getOldOrder() {
        return oldOrder;
    }

    public void setOldOrder(Boolean oldOrder) {
        this.oldOrder = oldOrder;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public List<WaitSendOrderVO> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<WaitSendOrderVO> childOrders) {
        this.childOrders = childOrders;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
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
