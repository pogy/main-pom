package com.shigu.main4.order.bo;

import com.shigu.main4.order.enums.OrderStatus;

import java.io.Serializable;
import java.util.List;

/**
 * 订单BO
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderBO implements Serializable{

    private Long oid;

    private Long userId;

    private Long senderId;

    private String title;

    private String webSite;

    private OrderStatus status;

    private String mark;

    private List<SubItemOrderBO> subOrders;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
