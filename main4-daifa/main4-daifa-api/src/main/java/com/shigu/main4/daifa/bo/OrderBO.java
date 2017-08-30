package com.shigu.main4.daifa.bo;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 订单
 * Created by zhaohongbo on 17/8/8.
 */
public class OrderBO implements Serializable {
    private Long oid;//    订单ID
    private Integer type;//   类别
    private String mark;//  备注
    private Integer aggrement;// 协议1有货先发，2缺货不发
    private Long senderId;// 代发机构ID
    private BuyerBO buyer;//卖家信息
    private String buyRemark;//卖家留言
    private List<SubOrderBO> subOrders;//   子订单
    private List<ServiceBO> services;//    服务
    private  List<PackageBO> packages;//   包材
    private List<LogisticsBO> logistics;//   物流
    public BuyerBO getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerBO buyer) {
        this.buyer = buyer;
    }
    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getAggrement() {
        return aggrement;
    }

    public void setAggrement(Integer aggrement) {
        this.aggrement = aggrement;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public List<SubOrderBO> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SubOrderBO> subOrders) {
        this.subOrders = subOrders;
    }

    public List<ServiceBO> getServices() {
        return services;
    }

    public void setServices(List<ServiceBO> services) {
        this.services = services;
    }

    public List<PackageBO> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageBO> packages) {
        this.packages = packages;
    }

    public List<LogisticsBO> getLogistics() {
        return logistics;
    }

    public String getBuyRemark () {
        return buyRemark;
    }

    public void setBuyRemark (String buyRemark) {
        this.buyRemark = buyRemark;
    }

    public void setLogistics(List<LogisticsBO> logistics) {
        this.logistics = logistics;
    }

}
