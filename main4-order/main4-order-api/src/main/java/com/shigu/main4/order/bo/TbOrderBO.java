package com.shigu.main4.order.bo;

import com.shigu.main4.order.zfenums.TbOrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class TbOrderBO implements Serializable{
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 订单状态
     */
    private TbOrderStatusEnum status;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 页长
     */
    private Integer pageSize;

    /**
     * 获取 开始时间
     */
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * 设置 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取 结束时间
     */
    public Date getEndTime() {
        return this.endTime;
    }

    /**
     * 设置 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 订单状态
     */
    public TbOrderStatusEnum getStatus() {
        return this.status;
    }

    /**
     * 设置 订单状态
     */
    public void setStatus(TbOrderStatusEnum status) {
        this.status = status;
    }

    /**
     * 获取 页码
     */
    public Integer getPage() {
        return this.page;
    }

    /**
     * 设置 页码
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 页长
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 页长
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
