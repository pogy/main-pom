package com.shigu.main4.daifa.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 快递信息
 * Created by zhaohongbo on 17/8/9.
 */
public class DeliveryBO implements Serializable {

    private List<Long> dfOrderIds;

    //
    private Long sendID;
    /**交易Id*/
    private Long dfTradeId;
    /**代发ID不能为空*/
    private Long sellerId;
    /**已发编码@按天的已发编码:fh{日期},日期格式为yyyyMMdd*/
    private String daifaSendCode;
    /**发货状态@0未发货2已经出库发货*/
    private Integer sendStatus;
    /**创建日期@ YYYYMMDD*/
    private String createDate;
    /**创建时间*/
    private java.util.Date createTime;
    /**发货日期@ YYYYMMDD*/
    private String sendDate;
    /**发货时间*/
    private java.util.Date sendTime;
    /**总钱数@单位元*/
    private String money;
    /**买家ID*/
    private Long buyerId;
    /**快递ID*/
    private Long expressId;
    /**快递名*/
    private String expressName;
    /**快递单号*/
    private String expressCode;
    /**快递费*/
    private String expressFee;
    /**收件人省*/
    private String receiverState;
    /**收件人详细地址*/
    private String receiverAddress;
    /**收件人姓名*/
    private String receiverName;
    /**收件人邮编*/
    private String receiverZip;
    /**收件人手机号*/
    private String receiverPhone;
    /**买家留言*/
    private String buyerRemark;
    /**打印状态@0未打印1已打印*/
    private Integer printStatus;
    /**三段码*/
    private String markDestination;
    /**集包地*/
    private String packageName;
    /**备用1*/
    private String remark1;
    /**备用2*/
    private String remark2;
    /**淘宝账户的昵称*/
    private String taobaoUserNick;
    /**淘宝订单号tid*/
    private Long taobaoTid;
    /**买家姓名*/
    private String buyerName;
    /**买家电话*/
    private String buyerTelephone;
    /**买家QQ*/
    private String buyerQq;
    /**买家旺旺*/
    private String buyerWw;

    private Long manual;

    //tag  1 扫描发货入口  2 手动发货入口
    private Integer tag;

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Long getManual() {
        return manual;
    }

    public void setManual(Long manual) {
        this.manual = manual;
    }

    public Long getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getDaifaSendCode() {
        return daifaSendCode;
    }

    public void setDaifaSendCode(String daifaSendCode) {
        this.daifaSendCode = daifaSendCode;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getExpressId() {
        return expressId;
    }

    public void setExpressId(Long expressId) {
        this.expressId = expressId;
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

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
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

    public Integer getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Integer printStatus) {
        this.printStatus = printStatus;
    }

    public String getMarkDestination() {
        return markDestination;
    }

    public void setMarkDestination(String markDestination) {
        this.markDestination = markDestination;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getTaobaoUserNick() {
        return taobaoUserNick;
    }

    public void setTaobaoUserNick(String taobaoUserNick) {
        this.taobaoUserNick = taobaoUserNick;
    }

    public Long getTaobaoTid() {
        return taobaoTid;
    }

    public void setTaobaoTid(Long taobaoTid) {
        this.taobaoTid = taobaoTid;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }

    public String getBuyerQq() {
        return buyerQq;
    }

    public void setBuyerQq(String buyerQq) {
        this.buyerQq = buyerQq;
    }

    public String getBuyerWw() {
        return buyerWw;
    }

    public void setBuyerWw(String buyerWw) {

        this.buyerWw = buyerWw;
    }
    public List<Long> getDfOrderIds() {
        return dfOrderIds;
    }

    public void setDfOrderIds(List<Long> dfOrderIds) {

        this.dfOrderIds = dfOrderIds;
    }
    public Long getSendID() {
        return sendID;
    }

    public void setSendID(Long sendID) {
        this.sendID = sendID;
    }
}
