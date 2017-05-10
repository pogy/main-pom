package com.shigu.main4.activity.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动数据体
 *
 * -Long activityId  //投放ID
 -Long termId   //期次
 -String description //描述
 -Date pubFromTime  //公布时间
 -Date pubToTime   //公布结束时间
 -Integer sort  //排序
 * Created by zhaohongbo on 17/5/4.
 */
public class ActivityVO implements Serializable{
    /**
     * 活动Id
     */
    @JSONField(serialize=false)
    private Long activityId;
    /**
     * 期次ID
     */
    @JSONField(serialize=false)
    private Long termId;
    /**
     * 活动描述
     */
    @JSONField(serialize=false)
    private String description;
    /**
     * 排序,按降序
     */
    @JSONField(serialize=false)
    private Integer sort;
    /**
     * 活动唯一key
     */
    @JSONField(serialize=false)
    private String activityKey;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
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

    public String getActivityKey() {
        return activityKey;
    }

    public void setActivityKey(String activityKey) {
        this.activityKey = activityKey;
    }
}
