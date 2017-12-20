package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 订单服务信息
 * Created by zhaohongbo on 17/7/26.
 */
public class OrderServiceVO implements Serializable{
    /**
     * 付总金额
     */
    private Long money;

    private Long serviceId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 订单ID
     */
    private Long oid;
    private Long soid;
    /**
     * 服务名
     */
    private String name;
    /**
     * 退金额,如果有退的话
     */
    private Long refundMoney;

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Long refundMoney) {
        this.refundMoney = refundMoney;
    }
}
