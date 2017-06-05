package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.PayType;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付申请
 * Created by zhaohongbo on 17/6/1.
 */
public class PayApplyVO implements Serializable{
    /**
     * 支付申请ID
     */
    private Long applyId;
    /**
     * 付款钱数,以分为单位
     */
    private Long money;
    /**
     * 支付链接
     */
    private String payLink;
    /**
     * 支付类别
     */
    private PayType payType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 付款理由,1为进货付款
     */
    private Integer payFor;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getPayLink() {
        return payLink;
    }

    public void setPayLink(String payLink) {
        this.payLink = payLink;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPayFor() {
        return payFor;
    }

    public void setPayFor(Integer payFor) {
        this.payFor = payFor;
    }
}
