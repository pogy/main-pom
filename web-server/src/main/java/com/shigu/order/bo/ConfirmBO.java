package com.shigu.order.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 确认页面的参数
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmBO implements Serializable{
    /**
     * 发件单位ID
     */
    private Long senderId;
    /**
     * 收货地址ID
     */
    private String addressId;
    /**
     * 快递公司单位ID
     */
    private String courierId;
    /**
     * 按店分组的订单
     */
    private List<ConfirmOrderBO> orders;
    /**
     * 结算唯一码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public List<ConfirmOrderBO> getOrders() {
        return orders;
    }

    public void setOrders(List<ConfirmOrderBO> orders) {
        this.orders = orders;
    }
}
