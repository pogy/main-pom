package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.RefundStateEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhaohongbo on 17/7/14.
 */
public class RefundInfoVO implements Serializable{
    /**
     * 退款编号
     */
    private String refundCode;
    /**
     * 退款金额
     */
    private String refundPrice;
    /**
     * 退款进度，为0,1; 0买家申请退款1退款完成
     */
    private RefundStateEnum refundState;
    /**
     * 退款去向
     */
    private String refundGoto;
    /**
     * 退款完成时间
     */
    private Date refundSuccessTime;

    /**
     * 获取 退款编号
     */
    public String getRefundCode() {
        return this.refundCode;
    }

    /**
     * 设置 退款编号
     */
    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    /**
     * 获取 退款金额
     */
    public String getRefundPrice() {
        return this.refundPrice;
    }

    /**
     * 设置 退款金额
     */
    public void setRefundPrice(String refundPrice) {
        this.refundPrice = refundPrice;
    }


    /**
     * 获取 退款去向
     */
    public String getRefundGoto() {
        return this.refundGoto;
    }

    /**
     * 设置 退款去向
     */
    public void setRefundGoto(String refundGoto) {
        this.refundGoto = refundGoto;
    }

    /**
     * 获取 退款完成时间
     */
    public Date getRefundSuccessTime() {
        return this.refundSuccessTime;
    }

    /**
     * 设置 退款完成时间
     */
    public void setRefundSuccessTime(Date refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
    }

    /**
     * 获取 退款进度，为0,1; 0买家申请退款1退款完成
     */
    public RefundStateEnum getRefundState() {
        return this.refundState;
    }

    /**
     * 设置 退款进度，为0,1; 0买家申请退款1退款完成
     */
    public void setRefundState(RefundStateEnum refundState) {
        this.refundState = refundState;
    }
}
