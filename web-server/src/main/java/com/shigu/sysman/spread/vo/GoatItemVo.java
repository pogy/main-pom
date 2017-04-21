package com.shigu.sysman.spread.vo;


import java.util.Date;

/**
 *
 *
 */
public class GoatItemVo {

    private Long goatId;
    /**
     * 广告位置ID
     */
    private Long localId;
    /**
     * 广告开始时间
     */
    private Date startTime;
    /**
     * 广告结束时间
     */
    private Date endTime;
    /**
     * 是否不可用
     */
    private Boolean disEnabled;
    /**
     * 排序
     */
    private Integer sort;

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getDisEnabled() {
        return disEnabled;
    }

    public void setDisEnabled(Boolean disEnabled) {
        this.disEnabled = disEnabled;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
