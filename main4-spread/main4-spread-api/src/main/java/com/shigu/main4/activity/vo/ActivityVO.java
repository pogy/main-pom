package com.shigu.main4.activity.vo;

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
    private Long activityId;
    /**
     * 期次ID
     */
    private Long termId;
    /**
     * 活动描述
     */
    private String description;
    /**
     * 生效开始时间,如果是led表示上广告时间,如果卖广告,表示广告挂到网站的时间
     */
    private Date pubFromTime;
    /**
     * 生效结束时间
     */
    private Date pubToTime;
    /**
     * 排序,按降序
     */
    private Integer sort;

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

    public Date getPubFromTime() {
        return pubFromTime;
    }

    public void setPubFromTime(Date pubFromTime) {
        this.pubFromTime = pubFromTime;
    }

    public Date getPubToTime() {
        return pubToTime;
    }

    public void setPubToTime(Date pubToTime) {
        this.pubToTime = pubToTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
