package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：AfterSaleAcceptMessage
 * 类路径：com.shigu.main4.order.mq.msg.AfterSaleAcceptMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-21 11:13
 * 项目：main-pom
 * 描述：受理/拒绝退货请求消息
 */
public class AfterSaleAcceptMessage implements Serializable {
    //退货ID
    private Long refundId;
    //true为同意退货，false为拒绝
    private Boolean canRefund;
    //退拒绝原因
    private String reason;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Boolean getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Boolean canRefund) {
        this.canRefund = canRefund;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
