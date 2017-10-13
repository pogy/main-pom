package com.shigu.mq.beans;

public class HasItemRefund {
    private Long refundId;
    private Long psoid;
    private Long refundPrice;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getPsoid() {
        return this.psoid;
    }

    public void setPsoid(Long psoid) {
        this.psoid = psoid;
    }

    public Long getRefundPrice() {
        return this.refundPrice;
    }

    public void setRefundPrice(Long refundPrice) {
        this.refundPrice = refundPrice;
    }
}
