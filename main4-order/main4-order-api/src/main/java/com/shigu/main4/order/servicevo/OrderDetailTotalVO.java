package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderDetailTotalVo
 * @文件路径：com.shigu.main4.order.servicevo.OrderDetailTotalVo
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 11:10
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderDetailTotalVO implements Serializable{

    private String expressPrice;//运费总计,前端
    private Long expressPriceLong;//运费总计,接口传出来数据

    private String servicePrice;//服务费总计,前端
    private Long servicePriceLong;//服务费总计,接口传出来数据

    private String childOrdersPrice;//商品总金额,前端
    private Long childOrdersPriceLong;//商品总金额,接口传出来数据

    private String orderTotalPrice;//订单总金额,前端
    private Long orderTotalPriceLong;//订单总金额,接口传出来数据

    public String getExpressPrice () {
        return expressPrice;
    }

    public void setExpressPrice (String expressPrice) {
        this.expressPrice = expressPrice;
    }

    public String getServicePrice () {
        return servicePrice;
    }

    public void setServicePrice (String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getChildOrdersPrice () {
        return childOrdersPrice;
    }

    public void setChildOrdersPrice (String childOrdersPrice) {
        this.childOrdersPrice = childOrdersPrice;
    }

    public String getOrderTotalPrice () {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice (String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Long getExpressPriceLong () {
        return expressPriceLong;
    }

    public void setExpressPriceLong (Long expressPriceLong) {
        this.expressPriceLong = expressPriceLong;
    }

    public Long getServicePriceLong () {
        return servicePriceLong;
    }

    public void setServicePriceLong (Long servicePriceLong) {
        this.servicePriceLong = servicePriceLong;
    }

    public Long getChildOrdersPriceLong () {
        return childOrdersPriceLong;
    }

    public void setChildOrdersPriceLong (Long childOrdersPriceLong) {
        this.childOrdersPriceLong = childOrdersPriceLong;
    }

    public Long getOrderTotalPriceLong () {
        return orderTotalPriceLong;
    }

    public void setOrderTotalPriceLong (Long orderTotalPriceLong) {
        this.orderTotalPriceLong = orderTotalPriceLong;
    }
}
