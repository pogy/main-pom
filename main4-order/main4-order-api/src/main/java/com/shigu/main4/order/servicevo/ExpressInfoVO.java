package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zhaohongbo on 17/7/14.
 */
public class ExpressInfoVO implements Serializable{
    /**
     * 物流当前状态,为0,1,2,3； 0待揽件, 1运输, 2派送, 3签收
     * TODO:物流平台返回状态为2-在途中,3-签收,4-问题件
     */
    private Integer expressCurrentState;
    /**
     * 快递公司名称
     */
    private String expressName;
    /**
     * 快递单号
     */
    private String expressId;
    /**
     * 收货人
     */
    private String receiverName;
    /**
     * 收货人联系
     */
    private String receiverPhone;
    /**
     * 收货地址
     */
    private String receiverAddress;


    /**
     * 获取 物流当前状态,为0,1,2,3； 0待揽件, 1运输, 2派送, 3签收
     */
    public Integer getExpressCurrentState() {
        return this.expressCurrentState;
    }

    /**
     * 设置 物流当前状态,为0,1,2,3； 0待揽件, 1运输, 2派送, 3签收
     */
    public void setExpressCurrentState(Integer expressCurrentState) {
        this.expressCurrentState = expressCurrentState;
    }

    /**
     * 获取 快递公司名称
     */
    public String getExpressName() {
        return this.expressName;
    }

    /**
     * 设置 快递公司名称
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * 获取 快递单号
     */
    public String getExpressId() {
        return this.expressId;
    }

    /**
     * 设置 快递单号
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    /**
     * 获取 收货人
     */
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置 收货人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取 收货人联系
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置 收货人联系
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取 收货地址
     */
    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    /**
     * 设置 收货地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
}
