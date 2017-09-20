package com.shigu.mq.beans;

public class ReturnExpress {
    private Long refundId;
    private String courier;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getCourier() {
        return this.courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
}
