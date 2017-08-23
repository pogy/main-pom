package com.shigu.order.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class OrderBO implements Serializable{
    /**
     * 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    //private MainOrderStatusEnum status;

    private Integer status;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date st;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date et;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 收件人
     */
    private String receiver;
    /**
     * 收件人号码
     */
    private String telePhone;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 页长
     */
    private Integer pageSize;


    /**
     * 获取 货号
     */
    public String getGoodsNo() {
        return this.goodsNo;
    }

    /**
     * 设置 货号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Date getSt () {
        return st;
    }

    public void setSt (Date st) {
        this.st = st;
    }

    public Date getEt () {
        return et;
    }

    public void setEt (Date et) {
        this.et = et;
    }

    /**
     * 获取 订单ID
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 收件人
     */
    public String getReceiver() {
        return this.receiver;
    }

    /**
     * 设置 收件人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取 收件人号码
     */
    public String getTelePhone() {
        return this.telePhone;
    }

    /**
     * 设置 收件人号码
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
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

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }
}