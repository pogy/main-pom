package com.shigu.daifa.bo;

public class DaifaStockBO {
    private Long childOrderId;//子弹id
    private String startTime;//开始时间
    private String endTime;//结束时间
    private Integer page;//当前页

    public Long getChildOrderId() {
        return this.childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
