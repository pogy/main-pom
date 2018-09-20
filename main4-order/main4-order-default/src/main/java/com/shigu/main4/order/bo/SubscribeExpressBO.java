package com.shigu.main4.order.bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class SubscribeExpressBO implements Serializable {
    /**
     * 快递公司编码
     */
    @JSONField(name = "ShipperCode")
    private String shipperCode;
    /**
     * 快递单号
     */
    @JSONField(name = "LogisticCode")
    private String logisticCode;

    @JSONField(name = "Receiver")
    private SubscribeAddressBO receiver;

    @JSONField(name = "Sender")
    private SubscribeAddressBO sender;

    @JSONField(name = "Callback")
    private String callback;

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public SubscribeAddressBO getReceiver() {
        return receiver;
    }

    public void setReceiver(SubscribeAddressBO receiver) {
        this.receiver = receiver;
    }

    public SubscribeAddressBO getSender() {
        return sender;
    }

    public void setSender(SubscribeAddressBO sender) {
        this.sender = sender;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
