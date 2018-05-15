package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: OrdersVo
 * @Author: sy
 * @CreateDate: 2018/5/4 0004 16:23
 */
public class OrdersVo implements Serializable{

    private Long orderId;
    private String tradeTime;
    private Date createTime;
    private String tradePay;
    private List<ChildOrdersVo> childOrders;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradePay() {
        return tradePay;
    }

    public void setTradePay(String tradePay) {
        this.tradePay = tradePay;
    }

    public List<ChildOrdersVo> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<ChildOrdersVo> childOrders) {
        this.childOrders = childOrders;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
