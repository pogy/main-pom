package com.shigu.main4.order.servicevo;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/26.
 * 退款信息
 */
public class AfterSaleInfoVO implements Serializable{
    /**
     * 退款ID
     */
    private Long refundId;
    /**
     * 退款金额(申请的金额或实际退款的金额,根据售后状态决定)
     */
    private Long refundPrice;

    /**
     * 获取 退款ID
     */
    public Long getRefundId() {
        return this.refundId;
    }

    /**
     * 设置 退款ID
     */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }


    /**
     * 获取 退款金额(申请的金额或实际退款的金额,根据售后状态决定)
     */
    public Long getRefundPrice() {
        return this.refundPrice;
    }

    /**
     * 设置 退款金额(申请的金额或实际退款的金额,根据售后状态决定)
     */
    public void setRefundPrice(Long refundPrice) {
        this.refundPrice = refundPrice;
    }
}
