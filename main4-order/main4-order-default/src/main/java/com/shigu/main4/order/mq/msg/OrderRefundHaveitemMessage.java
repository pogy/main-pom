package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：OrderRefundHaveitemMessage
 * 类路径：com.shigu.main4.order.mq.msg.OrderRefundHaveitemMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-27 10:25
 * 项目：main-pom
 * 描述：确认未发退款
 */
public class OrderRefundHaveitemMessage implements Serializable {
    //退款编号
    private Long refundId;
    //拆单id
    private Long psoid;
    //退款金额
    private Long refundPrice;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getPsoid() {
        return psoid;
    }

    public void setPsoid(Long psoid) {
        this.psoid = psoid;
    }

    public Long getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(Long refundPrice) {
        this.refundPrice = refundPrice;
    }
}
