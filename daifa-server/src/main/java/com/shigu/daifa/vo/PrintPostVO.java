package com.shigu.daifa.vo;

import java.io.Serializable;
import java.util.List;

public class PrintPostVO implements Serializable {
    private String receiverName;//收件人姓名
    private String recieverAddress;//收件人地址
    private String recieverZip;//收件人邮编
    private String postCode;//快递单号
    private String dfTradeId;//订单号
    private List<String> goodsMs;//商品信息
    private String senderName;//发货人姓名
    private String senderPhone;//发货人手机
    private String senderAddress;//发货人地址
    private String receiverMobile;//收件人手机
    private Integer sendNum;//发货数量
    private String specialStr;//特殊标注符
    private String postName;
    private String markDestination;//三段码
    private String packageName;//集包地
    private String packageCode;//集包地编码

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getRecieverAddress() {
        return recieverAddress;
    }

    public void setRecieverAddress(String recieverAddress) {
        this.recieverAddress = recieverAddress;
    }

    public String getRecieverZip() {
        return recieverZip;
    }

    public void setRecieverZip(String recieverZip) {
        this.recieverZip = recieverZip;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(String dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public List<String> getGoodsMs() {
        return goodsMs;
    }

    public void setGoodsMs(List<String> goodsMs) {
        this.goodsMs = goodsMs;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public String getSpecialStr() {
        return specialStr;
    }

    public void setSpecialStr(String specialStr) {
        this.specialStr = specialStr;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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

    public String getPackageCode () {
        return packageCode;
    }

    public void setPackageCode (String packageCode) {
        this.packageCode = packageCode;
    }
}
