package com.shigu.main4.order.servicevo;


import com.shigu.main4.order.zfenums.ReturnGoodsStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zf on 2017/7/17.
 */
public class ReturnGoodsInfoVO implements Serializable{
    /**
     * 退款编号
     */
    private String refundId;
    /**
     * 退款金额
     */
    private String refundPrice;
    /**
     * 退款进度，为0,1,2,3,4,5;
     * 0买家申请退款,1同意申请2已提交快递3到货4等待售后处理5退货完成
     */
    private ReturnGoodsStatusEnum retrunGoodsStatus;
    /**
     * 退款去向
     */
    private String refundGoto;
    /**
     * 退款完成时间
     */
    private Date refundSuccessTime;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
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
     * 退款进度，为0,1,2,3,4,5;
     * 0买家申请退款,1同意申请2已提交快递3到货4等待售后处理5退货完成
     */
    public ReturnGoodsStatusEnum getRetrunGoodsStatus() {
        return this.retrunGoodsStatus;
    }

    /**
     * 退款进度，为0,1,2,3,4,5;
     * 0买家申请退款,1同意申请2已提交快递3到货4等待售后处理5退货完成
     */
    public void setRetrunGoodsStatus(ReturnGoodsStatusEnum retrunGoodsStatus) {
        this.retrunGoodsStatus = retrunGoodsStatus;
    }
}
