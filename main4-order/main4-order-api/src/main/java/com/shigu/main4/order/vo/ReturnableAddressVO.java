package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/17.
 */
public class ReturnableAddressVO implements Serializable {
    /**
     * 退换货收件人
     */
    private String receiverName;
    /**
     * 退换货收件人号码
     */
    private String receiverPhone;
    /**
     * 退换货地址
     */
    private String receiverAddress;

    /**
     * 获取 退换货收件人
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置 退换货收件人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取 退换货收件人号码
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置 退换货收件人号码
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取 退换货地址
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置 退换货地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
}
