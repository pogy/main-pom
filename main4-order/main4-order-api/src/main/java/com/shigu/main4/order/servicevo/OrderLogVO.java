package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.MainOrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单日志
 * Created by zhaohongbo on 17/7/14.
 */
public class OrderLogVO implements Serializable{
    /**
     * 订单状态,为1,2,3,4,5; 1待付款，2待配货，3已发货，4交易完成，5取消订单
     */
    private MainOrderStatusEnum orderState;
    /**
     * 进入当前状态的时间
     */
    private Date stateTime;


    /**
     * 获取 进入当前状态的时间
     */
    public Date getStateTime() {
        return this.stateTime;
    }

    /**
     * 设置 进入当前状态的时间
     */
    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    /**
     * 获取 订单状态,为1,2,3,4,5; 1待付款，2待配货，3已发货，4交易完成，5取消订单
     */
    public MainOrderStatusEnum getOrderState() {
        return this.orderState;
    }

    /**
     * 设置 订单状态,为1,2,3,4,5; 1待付款，2待配货，3已发货，4交易完成，5取消订单
     */
    public void setOrderState(MainOrderStatusEnum orderState) {
        this.orderState = orderState;
    }
}
