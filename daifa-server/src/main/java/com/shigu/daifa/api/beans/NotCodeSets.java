package com.shigu.daifa.api.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zf on 2017/6/2.
 */
public class NotCodeSets implements Serializable {
    private List<Long> orderIds;
    /**
     * 1-9:1-9天后有货,10:下架,20:价格不符
     */
    private Integer day;

    public List<Long> getOrderIds() {
        return this.orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    /**
     * 获取 1-9:1-9天后有货,10:下架,20:价格不符
     */
    public Integer getDay() {
        return this.day;
    }

    /**
     * 设置 1-9:1-9天后有货,10:下架,20:价格不符
     */
    public void setDay(Integer day) {
        this.day = day;
    }
}
