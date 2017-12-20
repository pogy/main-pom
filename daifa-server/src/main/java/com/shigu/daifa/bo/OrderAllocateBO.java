package com.shigu.daifa.bo;

import java.io.Serializable;

/**
 * Created by pc on 2017-08-15.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderAllocateBO implements Serializable {
    private Long orderId;//订单id
    private Long childOrderId;//子弹id
    private String startTime;//开始时间
    private String endTiem;//结束时间
    private String page;//当前页
    private Integer count;//总数

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTiem() {
        return endTiem;
    }

    public void setEndTiem(String endTiem) {
        this.endTiem = endTiem;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
