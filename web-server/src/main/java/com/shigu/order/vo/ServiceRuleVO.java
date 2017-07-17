package com.shigu.order.vo;

import java.util.List;

/**
 * 确认订单页，订单服务费用信息
 * Created by bugzy on 2017/7/17 0017.
 */
public class ServiceRuleVO {

    private Long senderId;

    private Long orderId;

    private List<ServiceInfoVO> services;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<ServiceInfoVO> getServices() {
        return services;
    }

    public void setServices(List<ServiceInfoVO> services) {
        this.services = services;
    }
}
