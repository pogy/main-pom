package com.shigu.mq.beans;

public class Reproce {
    private Long refundId;
    private Boolean agree;
    private String storeMoney;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Boolean getAgree() {
        return this.agree;
    }

    public void setAgree(Boolean agree) {
        this.agree = agree;
    }

    public String getStoreMoney() {
        return this.storeMoney;
    }

    public void setStoreMoney(String storeMoney) {
        this.storeMoney = storeMoney;
    }
}
