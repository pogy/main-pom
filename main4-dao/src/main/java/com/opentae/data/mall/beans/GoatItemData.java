package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 广告中的数据
 * Created by zhaohongbo on 17/5/5.
 */
public class GoatItemData {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Long dataId;
    /**
     * 广告ID
     */
    private Long goatId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 来自哪一个报名活动
     */
    private Long fromActivityId;
    /**
     * 广告开始时间
     */
    private Date fromTime;
    /**
     * 广告结束时间
     */
    private Date toTime;
    /**
     * 广告私有数据
     */
    private String context;
    /**
     * 1有效，0无效，2预设
     */
    private Integer status;
    /**
     * 发送定时队列的ID值
     */
    private String messageId;

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
