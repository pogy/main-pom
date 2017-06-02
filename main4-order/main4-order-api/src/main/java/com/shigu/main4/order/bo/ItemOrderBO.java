package com.shigu.main4.order.bo;


import java.io.Serializable;
import java.util.List;

/**
 * 订单BO
 * Created by zhaohongbo on 17/6/1.
 */
public class ItemOrderBO implements Serializable{

    private Long userId;

    private Long senderId;

    private String title;

    private String webSite;

    private String mark;

    private LogisticsBO logistics;

    private List<SubItemOrderBO> subOrders;
    /**
     * 服务
     */
    private List<Long> serviceIds;
    /**
     * 包材
     */
    private List<PackageBO> packages;

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public LogisticsBO getLogistics() {
        return logistics;
    }

    public void setLogistics(LogisticsBO logistics) {
        this.logistics = logistics;
    }

    public List<SubItemOrderBO> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SubItemOrderBO> subOrders) {
        this.subOrders = subOrders;
    }

    public List<Long> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Long> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public List<PackageBO> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageBO> packages) {
        this.packages = packages;
    }
}
