package com.shigu.order.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 提交订单
 * Created by zhaohongbo on 17/6/23.
 */
public class ConfirmOrderBO implements Serializable{
    /**
     * 临时订单ID
     */
    private String orderId;
    /**
     * 订单备注
     */
    private String remark;
    /**
     * 按店分的子订单
     */
    private List<ConfirmSubOrderBO> childOrders;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ConfirmSubOrderBO> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<ConfirmSubOrderBO> childOrders) {
        this.childOrders = childOrders;
    }
}
