package com.shigu.main4.daifa.bo;

import java.util.List;

/**
 * @类编号
 * @类名称：OrderExpressBO
 * @文件路径：com.shigu.main4.daifa.bo.OrderExpressBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 16:49
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderExpressBO {
    private Long tid;//代发交易ID
    private String expressName;//快递名

    private String receiverName;//收货人姓名
    private String receiverPhone;//收货人手机号

    private String receiverAddress;//收化人地址

    private String sendName;//发件人
    private String sendPhone;//发件人手机号
    private String sendProv;//发件人省份
    private String sendCity;//发件人城市
    private String sendArea;//发件人区域
    private String sendAddress;//发件人地址

    private List<SubOrderExpressBO> list;//子单BO


    public Long getTid () {
        return tid;
    }

    public void setTid (Long tid) {
        this.tid = tid;
    }

    public String getExpressName () {
        return expressName;
    }

    public void setExpressName (String expressName) {
        this.expressName = expressName;
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


    public String getReceiverAddress () {
        return receiverAddress;
    }

    public void setReceiverAddress (String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSendName () {
        return sendName;
    }

    public void setSendName (String sendName) {
        this.sendName = sendName;
    }

    public String getSendPhone () {
        return sendPhone;
    }

    public void setSendPhone (String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public String getSendProv () {
        return sendProv;
    }

    public void setSendProv (String sendProv) {
        this.sendProv = sendProv;
    }

    public String getSendCity () {
        return sendCity;
    }

    public void setSendCity (String sendCity) {
        this.sendCity = sendCity;
    }

    public String getSendArea () {
        return sendArea;
    }

    public void setSendArea (String sendArea) {
        this.sendArea = sendArea;
    }

    public String getSendAddress () {
        return sendAddress;
    }

    public void setSendAddress (String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public List<SubOrderExpressBO> getList () {
        return list;
    }

    public void setList (List<SubOrderExpressBO> list) {
        this.list = list;
    }
}
