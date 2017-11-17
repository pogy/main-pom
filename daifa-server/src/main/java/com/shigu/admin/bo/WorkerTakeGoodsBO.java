package com.shigu.admin.bo;

public class WorkerTakeGoodsBO {
    private String startTime;
    private Long searchWorkerId;
    private Integer page;

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getSearchWorkerId() {
        return this.searchWorkerId;
    }

    public void setSearchWorkerId(Long searchWorkerId) {
        this.searchWorkerId = searchWorkerId;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
