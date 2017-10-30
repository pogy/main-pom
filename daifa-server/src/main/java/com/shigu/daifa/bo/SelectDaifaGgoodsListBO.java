package com.shigu.daifa.bo;

import java.io.Serializable;

public class SelectDaifaGgoodsListBO implements Serializable {
    private String orderId;
    private String childOrderId;
    private String startTime;
    private String endTime;
    private Long searchWorkerId;
    private Integer status;
    private Integer page;


    public Long getSearchWorkerId() {
        return searchWorkerId;
    }

    public void setSearchWorkerId(Long searchWorkerId) {
        this.searchWorkerId = searchWorkerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
