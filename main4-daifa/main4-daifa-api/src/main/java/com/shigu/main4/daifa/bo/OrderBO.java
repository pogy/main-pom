package com.shigu.main4.daifa.bo;

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
    private List<SubOrderBO>subOrders;//   子订单

    private List<ServiceBO>services;//    服务

    private  List<PackageBO>packages;//   包材

    private List<LogisticsBO>logistics;//   物流
    private String buyer;//       买家
    private String aliWw;//    旺旺
    private String phone;//    手机号
    private String nickInMarket;//    市场内昵称

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

    public void setLogistics(List<LogisticsBO> logistics) {
        this.logistics = logistics;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAliWw() {
        return aliWw;
    }

    public void setAliWw(String aliWw) {
        this.aliWw = aliWw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickInMarket() {
        return nickInMarket;
    }

    public void setNickInMarket(String nickInMarket) {
        this.nickInMarket = nickInMarket;
    }
}
