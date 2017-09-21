package com.shigu.daifa.vo;

import java.util.List;

public class DaifaSaleAfterVO {
    private Long orderId;
    private String sendTime;
    private String afterSaleTime;
    private String imWw;
    private String imTel;
    private String imQq;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String buyerRemark;
    private String totalFee;
    private String expressFee;
    private String expressName;
    private String expressCode;
    private String discountFee;
    private String serversFee;
    private Integer childOrderNum;
    private String allChildRemark;
    private Boolean isTbOrder;
    private List<DaifaSaleAfterRefundVO> afterSales;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getImWw() {
        return this.imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
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

    public String getReceiverName() {
        return this.receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getBuyerRemark() {
        return this.buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public String getTotalFee() {
        return this.totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getExpressFee() {
        return this.expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getExpressName() {
        return this.expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return this.expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getDiscountFee() {
        return this.discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getServersFee() {
        return this.serversFee;
    }

    public void setServersFee(String serversFee) {
        this.serversFee = serversFee;
    }

    public Integer getChildOrderNum() {
        return this.childOrderNum;
    }

    public void setChildOrderNum(Integer childOrderNum) {
        this.childOrderNum = childOrderNum;
    }

    public String getAllChildRemark() {
        return this.allChildRemark;
    }

    public void setAllChildRemark(String allChildRemark) {
        this.allChildRemark = allChildRemark;
    }

    public List<DaifaSaleAfterRefundVO> getAfterSales() {
        return this.afterSales;
    }

    public void setAfterSales(List<DaifaSaleAfterRefundVO> afterSales) {
        this.afterSales = afterSales;
    }

    public String getAfterSaleTime() {
        return this.afterSaleTime;
    }

    public void setAfterSaleTime(String afterSaleTime) {
        this.afterSaleTime = afterSaleTime;
    }

    public Boolean getIsTbOrder() {
        return this.isTbOrder;
    }

    public void setIsTbOrder(Boolean isTbOrder) {
        this.isTbOrder = isTbOrder;
    }
}
