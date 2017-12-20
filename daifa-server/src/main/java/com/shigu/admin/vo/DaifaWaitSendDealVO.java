package com.shigu.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @类编号
 * @类名称：DaifaWaitSendVO
 * @文件路径：com.shigu.admin.vo.DaifaWaitSendVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/16 13:18
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class DaifaWaitSendDealVO implements Serializable{


    private Long dwsId;
    /**待发Id*/
    private Long dfTradeId;
    /**交易编号（订单系统订单ID）*/
    private String tradeCode;
    /**代发机构ID*/
    private Long sellerId;
    /**发货状态@1待发货2已发货3转未发退货*/
    private Integer sendStatus;
    /**创建日期@ YYYYMMDD*/
    private String createDate;
    /**创建时间*/
    private String createTime;
    /**总钱数@单位元*/
    private String money;
    /**买家ID@可为空*/
    private Long buyerId;
    /**快递名*/
    private String expressName;
    /**收件人省*/
    private String receiverState;
    /**收件人详细地址*/
    private String receiverAddress;
    /**收件人姓名*/
    private String receiverName;
    /**收件人手机号*/
    private String receiverPhone;
    /**买家姓名@可为空*/
    private String buyerName;
    /**买家电话@可为空*/
    private String buyerTelephone;
    /**买家QQ@可为空*/
    private String buyerQq;
    /**买家旺旺@可为空*/
    private String buyerWw;
    /**收件人邮编*/
    private String receiverZip;
    /**待发订单是否显示0不显示1显示*/
    private Integer orderDisplay;//

    public Long getDwsId () {
        return dwsId;
    }

    public void setDwsId (Long dwsId) {
        this.dwsId = dwsId;
    }

    public Long getDfTradeId () {
        return dfTradeId;
    }

    public void setDfTradeId (Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getTradeCode () {
        return tradeCode;
    }

    public void setTradeCode (String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public Long getSellerId () {
        return sellerId;
    }

    public void setSellerId (Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCreateDate () {
        return createDate;
    }

    public void setCreateDate (String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public String getMoney () {
        return money;
    }

    public void setMoney (String money) {
        this.money = money;
    }

    public Long getBuyerId () {
        return buyerId;
    }

    public void setBuyerId (Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getExpressName () {
        return expressName;
    }

    public void setExpressName (String expressName) {
        this.expressName = expressName;
    }

    public String getReceiverState () {
        return receiverState;
    }

    public void setReceiverState (String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverAddress () {
        return receiverAddress;
    }

    public void setReceiverAddress (String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName () {
        return receiverName;
    }

    public void setReceiverName (String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone () {
        return receiverPhone;
    }

    public void setReceiverPhone (String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getBuyerName () {
        return buyerName;
    }

    public void setBuyerName (String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTelephone () {
        return buyerTelephone;
    }

    public void setBuyerTelephone (String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }

    public String getBuyerQq () {
        return buyerQq;
    }

    public void setBuyerQq (String buyerQq) {
        this.buyerQq = buyerQq;
    }

    public String getBuyerWw () {
        return buyerWw;
    }

    public void setBuyerWw (String buyerWw) {
        this.buyerWw = buyerWw;
    }

    public String getReceiverZip () {
        return receiverZip;
    }

    public void setReceiverZip (String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public Integer getOrderDisplay () {
        return orderDisplay;
    }

    public void setOrderDisplay (Integer orderDisplay) {
        this.orderDisplay = orderDisplay;
    }
}
