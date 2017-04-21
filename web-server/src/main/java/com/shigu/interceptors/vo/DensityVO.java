package com.shigu.interceptors.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密度信息
 * Created by zhaohongbo on 17/4/17.
 */
public class DensityVO implements Serializable{
    /**
     * 连续访问次数
     */
    private AtomicInteger number=new AtomicInteger(1);
    /**
     * 最后一次访问时间
     */
    private Date lastTime=new Date();

    public AtomicInteger getNumber() {
        return number;
    }

    public void setNumber(AtomicInteger number) {
        this.number = number;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
