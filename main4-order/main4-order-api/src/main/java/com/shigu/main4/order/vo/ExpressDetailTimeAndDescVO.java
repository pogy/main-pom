package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * Created by wanghaoxiang on 2017/8/3 0003.
 */
public class ExpressDetailTimeAndDescVO implements Serializable{
    private String time;//快递信息时间

    private String desc;//快递信息描述

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
