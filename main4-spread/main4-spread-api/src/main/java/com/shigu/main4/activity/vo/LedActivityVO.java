package com.shigu.main4.activity.vo;

import java.util.Date;

/**
 * LED活动数据体
 * -Date givePicTime
 -Date endGivePicTime
 * Created by zhaohongbo on 17/5/4.
 */
public class LedActivityVO extends ActivityVO{

    /**
     * 给图时间
     */
    private Date givePicTime;
    /**
     * 给图到期时间
     */
    private Date endGivePicTime;

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
}
