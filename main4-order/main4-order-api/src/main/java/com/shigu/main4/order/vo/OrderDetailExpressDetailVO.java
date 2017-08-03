package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @类编号
 * @类名称：OrderDetailExpressVO
 * @文件路径：com.shigu.main4.order.vo.OrderDetailExpressDetailVO
 * @内容摘要：订单详情中的--快递信息详情
 * @编码作者：gzy
 * @创建日期：2017/7/21 10:49
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderDetailExpressDetailVO implements Serializable{
    private Long orderId;//订单编号

    private String id;//快递单号

    private String date;//快递信息日期

    private String week;//周几

    private List<ExpressDetailTimeAndDescVO> detailList;

    //private String time;//快递信息时间
    //
    //private String desc;//快递信息描述

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    //public String getTime () {
    //    return time;
    //}
    //
    //public void setTime (String time) {
    //    this.time = time;
    //}
    //
    //public String getDesc () {
    //    return desc;
    //}
    //
    //public void setDesc (String desc) {
    //    this.desc = desc;
    //}

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<ExpressDetailTimeAndDescVO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<ExpressDetailTimeAndDescVO> detailList) {
        this.detailList = detailList;
    }
}
