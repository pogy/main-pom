package com.shigu.main4.goat.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告值
 * -Long localId
 -Long goatId
 * Created by zhaohongbo on 17/5/4.
 */
public class GoatVO implements Serializable{

    private Long localId;

    private Long goatId;

    private Long dataId;

    private Long fromActivityId;

    private Date fromTime;

    private Date toTime;

    private Long userId;

    private String code;

    private String description;

    private Integer sort;

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getFromActivityId() {
        return fromActivityId;
    }

    public void setFromActivityId(Long fromActivityId) {
        this.fromActivityId = fromActivityId;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
