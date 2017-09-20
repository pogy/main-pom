package com.shigu.mq.beans;

public class ReturnExpress {
    private Long refundId;
    private String courier;
    private String courierNO;

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

    public String getCourierNO() {
        return courierNO;
    }

    public void setCourierNO(String courierNO) {
        this.courierNO = courierNO;
    }
}
