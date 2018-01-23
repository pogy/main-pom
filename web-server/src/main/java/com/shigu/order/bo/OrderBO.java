package com.shigu.order.bo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/17.
 */
public class OrderBO implements Serializable{
    //订单条件
    /**
     * 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    //private MainOrderStatusEnum status;

    private Integer status;
    /**
     * 开始时间 yyyy-MM-dd 格式传入
     */
    private String  st;
    /**
     * 结束时间 yyyy-MM-dd 格式传入
     */
    private String  et;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 搜索订单类型 1:淘宝
     */
    private Integer orderType;
    //子单条件
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 缺货数量
     */
    private Integer stockoutNum;
    //物流条件
    /**
     * 收件人
     */
    private String receiver;
    /**
     * 收件人号码
     */
    private String telePhone;
    /**
     * 页长
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer page;
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

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
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

    /**
     * 缺货数量
     */
    public Integer getStockoutNum() { return stockoutNum; }

    public void setStockoutNum(Integer stockoutNum) { this.stockoutNum = stockoutNum; }

    /**
     * 获取 搜索订单类型 1:淘宝
     */
    public Integer getOrderType() {
        return this.orderType;
    }

    /**
     * 设置 搜索订单类型 1:淘宝
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
