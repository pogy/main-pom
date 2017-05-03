package com.shigu.main4.spread.vo;

import com.shigu.main4.spread.enums.SpreadType;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告期
 * Created by zhaohongbo on 17/5/3.
 */
public class SpreadTerm implements Serializable{
    /**
     * 本期开始时间
     */
    private Date startTime;
    /**
     * 期次ID
     */
    private Long termId;
    /**
     * 期结束时间
     */
    private Date endTime;
    /**
     * 广告活动类别
     */
    private SpreadType type;

    /**
     * 投放广告
     * @param localId
     * @param fromTime
     * @param toTime
     * @param number
     * @return
     */
    public Long throwSpread(Long localId, Date fromTime,Date toTime,Integer number) {
        return 0L;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public SpreadType getType() {
        return type;
    }

    public void setType(SpreadType type) {
        this.type = type;
    }
}
