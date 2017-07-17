package com.shigu.main4.order.bo;

import com.shigu.main4.order.enums.MainOrderStatusEnum;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.SearchOrderEnum;

import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class OrderBO {
    /**
     * 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    private MainOrderStatusEnum orderStatus;
    /**
     * 货号
     */
    private String goodsNo;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 收件人
     */
    private String receiverName;
    /**
     * 收件人号码
     */
    private String receiverPhone;
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
    public String getReceiverName() {
        return this.receiverName;
    }

    /**
     * 设置 收件人
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取 收件人号码
     */
    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    /**
     * 设置 收件人号码
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
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
    public MainOrderStatusEnum getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * 设置 订单状态 null全部订单，1待付款，2已付款，3已发货，4交易完成，5交易取消
     */
    public void setOrderStatus(MainOrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }
}
