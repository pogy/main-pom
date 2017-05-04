package com.shigu.main4.activity.vo;

import com.shigu.main4.activity.enums.ActivityType;

import java.util.Date;

/**
 * 广告期值对象
 *
 * Created by zhaohongbo on 17/5/4.
 */
public class ActivityTermVO {
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
    private ActivityType type;

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

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }
}
