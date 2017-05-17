package com.shigu.main4.monitor.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 缓存流量
 * Created by zhaohongbo on 17/5/17.
 */
public class ItemBrowerFlowVO implements Serializable{
    /**
     * 版本
     */
    private int version;
    /**
     * 流量
     */
    private long number;
    /**
     * 最后一次make的时间
     */
    private Date makeTime;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }
}
