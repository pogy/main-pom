package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.OrderType;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * Created by zhaohongbo on 17/6/1.
 */
public class OrderVO implements Serializable{
    private Long orderId;

    private String title;

    private String webSite;

    private OrderType type;

    private Long totalFee;

    private Long refundFee;

    private Long payedFee;

    private Date createTime;

    private String outerId;

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
    }

    public Long getPayedFee() {
        return payedFee;
    }

    public void setPayedFee(Long payedFee) {
        this.payedFee = payedFee;
    }
}
