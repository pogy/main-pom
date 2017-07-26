package com.shigu.main4.order.bo;

import com.shigu.main4.order.zfenums.MainOrderStatusEnum;

import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class OrderBO {
    /**
     * 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    private MainOrderStatusEnum status;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 开始时间
     */
    private Date st;
    /**
     * 结束时间
     */
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

    /**
     * 获取 开始时间
     */
    public Date getSt() {
        return this.st;
    }

    /**
     * 设置 开始时间
     */
    public void setSt(Date st) {
        this.st = st;
    }

    /**
     * 获取 结束时间
     */
    public Date getEt() {
        return this.et;
    }

    /**
     * 设置 结束时间
     */
    public void setEt(Date et) {
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

    /**
     * 获取 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    public MainOrderStatusEnum getStatus() {
        return this.status;
    }

    /**
     * 设置 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    public void setStatus(MainOrderStatusEnum status) {
        this.status = status;
    }
}
