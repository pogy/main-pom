package com.shigu.order.bo;

/**
 * Created by zf on 2017/7/21.
 */
public class TaobaoOrderBO {
    private String st;
    private String et;
    private Long orderId;
    private Integer page;

    public String getSt() {
        return this.st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return this.et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
