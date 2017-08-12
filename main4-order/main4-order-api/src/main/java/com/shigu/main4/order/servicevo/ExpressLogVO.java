package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zhaohongbo on 17/7/14.
 */
public class ExpressLogVO implements Serializable{

    /**
     * 日期@ yyyy-MM-dd
     */
    private String logDate;
    /**
     * 星期@ 周*
     */
    private String logWeek;
    /**
     * HH:mm:ss
     */
    private String logTime;
    /**
     * 快递信息描述
     */
    private String logDesc;

    /**
     * 获取 日期@ yyyy-MM-dd
     */
    public String getLogDate() {
        return this.logDate;
    }

    /**
     * 设置 日期@ yyyy-MM-dd
     */
    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    /**
     * 获取 星期@ 周*
     */
    public String getLogWeek() {
        return this.logWeek;
    }

    /**
     * 设置 星期@ 周*
     */
    public void setLogWeek(String logWeek) {
        this.logWeek = logWeek;
    }

    /**
     * 获取 HH:mm:ss
     */
    public String getLogTime() {
        return this.logTime;
    }

    /**
     * 设置 HH:mm:ss
     */
    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    /**
     * 获取 快递信息描述
     */
    public String getLogDesc() {
        return this.logDesc;
    }

    /**
     * 设置 快递信息描述
     */
    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }
}
