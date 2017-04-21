package com.shigu.main4.monitor.vo;

import com.shigu.main4.monitor.enums.FlowType;

import java.io.Serializable;

/**
 * 走线图,单点数据
 * Created by zhaohongbo on 17/3/13.
 */
public class DataLineVO implements Serializable{
    /**
     * 日期,MM-dd
     */
    private String datestr;
    /**
     * 流量,数值
     */
    private Integer flow;
    /**
     * 小时,按天算时,统一定为23时
     */
    private Integer hour;
    /**
     * 流量类型,ip或者pv
     */
    private FlowType type;

    public String getDatestr() {
        return datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public FlowType getType() {
        return type;
    }

    public void setType(FlowType type) {
        this.type = type;
    }
}
