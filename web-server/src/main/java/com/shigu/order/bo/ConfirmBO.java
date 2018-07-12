package com.shigu.order.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 确认页面的参数
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmBO implements Serializable{
    /**
     * 收货地址ID
     */
    private String addressId;
    /**
     * 快递公司单位ID
     */
    private Long courierId;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public List<ConfirmOrderBO> getOrders() {
        return orders;
    }

    public void setOrders(List<ConfirmOrderBO> orders) {
        this.orders = orders;
    }
}
