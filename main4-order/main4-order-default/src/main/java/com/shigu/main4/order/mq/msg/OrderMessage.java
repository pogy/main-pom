package com.shigu.main4.order.mq.msg;

import com.alipay.api.domain.OrderLogisticsInfo;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.OrderServiceVO;

import java.io.Serializable;
import java.util.List;

/**
 * 订单消息队列消息体
 * Created by bugzy on 2017/8/14 0014.
 */
public class OrderMessage implements Serializable {

    /**
     * 订单id
     */
    private Long oid;

    /**
     * 订单类型
     */
    private Integer type;

    /**
     * 订单备注
     */
    private String mark;

    /**
     * 协议1有货先发，2缺货不发 default 1
     */
    private Integer aggrement;

    /**
     * 发货机构id
     */
    private Long senderId;

    /**
     * 子单信息
     */
    private List<SubOrderInfoVO> subOrders;

    /**
     * 服务信息
     */
    private List<OrderServiceVO> services;

    /**
     * 包材信息
     */
    private List<MetarialVO> packages;

    /**
     * 物流信息
     */
    private List<OrderLogisticsInfo> logistics;

    private Buyer buyer;

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

    public List<SubOrderInfoVO> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SubOrderInfoVO> subOrders) {
        this.subOrders = subOrders;
    }

    public List<OrderServiceVO> getServices() {
        return services;
    }

    public void setServices(List<OrderServiceVO> services) {
        this.services = services;
    }

    public List<MetarialVO> getPackages() {
        return packages;
    }

    public void setPackages(List<MetarialVO> packages) {
        this.packages = packages;
    }

    public List<OrderLogisticsInfo> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<OrderLogisticsInfo> logistics) {
        this.logistics = logistics;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
