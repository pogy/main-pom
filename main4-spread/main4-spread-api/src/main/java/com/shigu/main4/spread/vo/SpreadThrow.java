package com.shigu.main4.spread.vo;

import java.util.Date;

/**
 * 广告投放
 * Created by zhaohongbo on 17/5/3.
 */
public class SpreadThrow {
    /**
     * 广告位置ID
     */
    private Long localId;
    /**
     * 广告编号
     */
    private String code;
    /**
     * 广告开始时间
     */
    private Date fromTime;
    /**
     * 广告结束时间
     */
    private Date toTime;
    /**
     * 投放广告数量
     */
    private Integer number;
    /**
     * 期次ID
     */
    private Long termId;

    /**
     * 报名
     * @param userId
     * @param name
     * @param telephone
     */
    public Long enlist(Long userId,String name,String telephone) {
        return 0L;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }
}
