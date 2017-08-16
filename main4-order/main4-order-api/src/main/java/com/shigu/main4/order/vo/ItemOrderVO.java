package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.OrderStatus;

import java.util.Date;


/**
 * 商品类别订单
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderVO extends OrderVO {

    private Long senderId;

    private Long userId;

    private OrderStatus orderStatus;
    /**
     * 单子创建时间
     */
    private Date createTime;
    /**
     * 单子结束时间,
     * 未结束时为null
     */
    private Date finishTime;


    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
