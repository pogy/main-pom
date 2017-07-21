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

    private String expressPrice;//运费总计

    private String servicePrice;//服务费总计

    private String childOrdersPrice;//商品总金额

    private String orderTotalPrice;//订单总金额

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
}
