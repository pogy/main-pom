package com.shigu.mq.beans;

public class ReturnOrChangeBean {
    private Long refundId;
    private Long oid;
    private Integer type;
    private String hopeMoney;
    private Long soid;
    private Integer num;
    private String reason;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHopeMoney() {
        return this.hopeMoney;
    }

    public void setHopeMoney(String hopeMoney) {
        this.hopeMoney = hopeMoney;
    }

    public Long getSoid() {
        return this.soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
