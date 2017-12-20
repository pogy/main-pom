package com.shigu.order.vo;

public class MoreErrorAddressVO {
    private String tid;
    private String address;

    public MoreErrorAddressVO(String tid, String address) {
        this.tid = tid;
        this.address = address;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
