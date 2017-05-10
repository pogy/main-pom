package com.shigu.main4.activity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告活动
 * -Long goatId
 -Date pubFromTime  //公布时间
 -Date pubToTime   //公布结束时间
 * Created by zhaohongbo on 17/5/10.
 */
public class GoatSimpleVO implements Serializable{

    private Long goatId;

    private Date pubFromTime;

    private Date pubToTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoatSimpleVO that = (GoatSimpleVO) o;

        return goatId.equals(that.goatId);

    }

    @Override
    public int hashCode() {
        return goatId.hashCode();
    }

    public Long getGoatId() {
        return goatId;
    }

    public void setGoatId(Long goatId) {
        this.goatId = goatId;
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
}
