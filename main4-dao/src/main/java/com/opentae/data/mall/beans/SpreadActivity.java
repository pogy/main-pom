package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 活动投放
 * Created by zhaohongbo on 17/5/4.
 */
public class SpreadActivity {
    /**
     * 活动ID
     */
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long activityId;
    /**
     * 期次ID
     */
    private Long termId;
    /**
     * 描述
     */
    private String description;
    /**
     * 公示开始时间
     */
    private Date pubFromTime;
    /**
     * 公示结束时间
     */
    private Date pubToTime;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 0卖广告服务，1LED服务
     */
    private Integer type;
    /**
     * 内容
     */
    private String context;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
