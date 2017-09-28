package com.shigu.daifa.bo;

public class SaleAfterBO {
    private String orderId;
    private String telephone;
    private String backPostCode;
    private String startTime;
    private String endTime;
    private Integer page;
    private Integer status;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBackPostCode() {
        return this.backPostCode;
    }

    public void setBackPostCode(String backPostCode) {
        this.backPostCode = backPostCode;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
