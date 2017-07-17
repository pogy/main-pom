package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.RefundStateEnum;
import com.shigu.main4.order.enums.RetrunbleStatusEnum;
import com.shigu.main4.order.enums.ReturnGoodsStatusEnum;

import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class ReturnGoodsInfoVO {
    /**
     * 退款编号
     */
    private String refundCode;
    /**
     * 退款金额
     */
    private String refundPrice;
    /**
     * 退款进度，为0,1,2; 0买家申请退款, 1等待处理退款申请 2买家退货 3退货退款完成
     */
    private ReturnGoodsStatusEnum retrunGoodsStatus;
    /**
     * 买家退货状态，退货进度为2的时候存在，为0,1,2;
     * 0平台同意申请，买家填写物流信息， 1退货物流信息提交， 2货物收到，等待处理
     */
    private RetrunbleStatusEnum retrunbleStatus;
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
     * 获取 退款进度，为0,1,2; 0买家申请退款, 1等待处理退款申请 2买家退货 3退货退款完成
     */
    public ReturnGoodsStatusEnum getRetrunGoodsStatus() {
        return this.retrunGoodsStatus;
    }

    /**
     * 设置 退款进度，为0,1,2; 0买家申请退款, 1等待处理退款申请 2买家退货 3退货退款完成
     */
    public void setRetrunGoodsStatus(ReturnGoodsStatusEnum retrunGoodsStatus) {
        this.retrunGoodsStatus = retrunGoodsStatus;
    }

    /**
     * 买家退货状态，退货进度为2的时候存在，为0,1,2;
     * 0平台同意申请，买家填写物流信息， 1退货物流信息提交， 2货物收到，等待处理
     */
    public RetrunbleStatusEnum getRetrunbleStatus() {
        return this.retrunbleStatus;
    }

    /**
     * 买家退货状态，退货进度为2的时候存在，为0,1,2;
     * 0平台同意申请，买家填写物流信息， 1退货物流信息提交， 2货物收到，等待处理
     */
    public void setRetrunbleStatus(RetrunbleStatusEnum retrunbleStatus) {
        this.retrunbleStatus = retrunbleStatus;
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
}
