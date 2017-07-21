package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.PayType;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付记录
 * Created by zhaohongbo on 17/7/21.
 */
public class PayedVO implements Serializable{
    /**
     * 支付ID
     */
    private Long payId;
    /**
     * 支付类别
     */
    private PayType payType;
    /**
     * 总付款额
     */
    private Long money;
    /**
     * 已退款额
     */
    private Long refundMoney;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Long refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "PayedVO{" +
                "payId=" + payId +
                ", payType=" + payType +
                ", money=" + money +
                ", refundMoney=" + refundMoney +
                ", createTime=" + createTime +
                '}';
    }
}
