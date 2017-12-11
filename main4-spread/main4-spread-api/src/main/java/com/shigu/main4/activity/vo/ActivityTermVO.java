package com.shigu.main4.activity.vo;

import com.shigu.main4.activity.enums.ActivityType;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告期值对象
 *
 * Created by zhaohongbo on 17/5/4.
 */
public class ActivityTermVO implements Serializable{
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 期次号
     */
    private Long termId;
    /**
     * 活动类型
     */
    private ActivityType activityType;
    /**
     * 简单要内容,用于描述期内有什么
     */
    private String content;
    /**
     * 男装广告：man  女装广告：woman  全站广告放在男装广告中
     */
    private String manOrWoman;

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

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getManOrWoman() {
        return manOrWoman;
    }

    public void setManOrWoman(String manOrWoman) {
        this.manOrWoman = manOrWoman;
    }
}
