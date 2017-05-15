package com.shigu.main4.activity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shigu.main4.common.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * LED活动数据体
 * -Date givePicTime
 -Date endGivePicTime
 * Created by zhaohongbo on 17/5/4.
 */
public class LedActivityVO extends ActivityVO implements Serializable{

    /**
     * 生效开始时间,如果是led表示上广告时间,如果卖广告,表示广告挂到网站的时间
     */
    private Date pubFromTime;
    /**
     * 生效结束时间
     */
    private Date pubToTime;
    /**
     * 给图时间
     */
    private Date givePicTime;
    /**
     * 给图到期时间
     */
    private Date endGivePicTime;

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

    public Date getGivePicTime() {
        return givePicTime;
    }

    public void setGivePicTime(Date givePicTime) {
        this.givePicTime = givePicTime;
    }

    public Date getEndGivePicTime() {
        return endGivePicTime;
    }

    public void setEndGivePicTime(Date endGivePicTime) {
        this.endGivePicTime = endGivePicTime;
    }

    @Override
    public String toString() {
        return DateUtil.dateToString(pubFromTime,"yyyy-MM-dd HH:mm:ss")+"~"+DateUtil.dateToString(pubToTime,"yyyy-MM-dd HH:mm:ss");
    }
}
