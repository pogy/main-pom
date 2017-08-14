package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.zfenums.ReturnGoodsStatusEnum;

import java.io.Serializable;

/**
 * Created by zf on 2017/7/26.
 */
public class AfterSaleStatusVO implements Serializable{
    /**
     * 子单ID
     */
    private Long subOrderId;
    /**
     * 售后状态
     */
    private ReturnGoodsStatusEnum afterSaleStatus;
    /**
     * 特殊信息(可空)
     * 状态为拒绝时,该属性为拒绝理由
     */
    private String content;
    //修改后的退款金额
    private Long modifyRefundPrice;

    /**
     * 获取 子单ID
     */
    public Long getSubOrderId() {
        return this.subOrderId;
    }

    /**
     * 设置 子单ID
     */
    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    /**
     * 获取 售后状态
     */
    public ReturnGoodsStatusEnum getAfterSaleStatus() {
        return this.afterSaleStatus;
    }

    /**
     * 设置 售后状态
     */
    public void setAfterSaleStatus(ReturnGoodsStatusEnum afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    /**
     * 特殊信息
     * 状态为拒绝时,该属性为拒绝理由
     * 状态为退款金额已修改时,返回金额(单位元)
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 特殊信息
     * 状态为拒绝时,该属性为拒绝理由
     * 状态为退款金额已修改时,返回金额(单位元)
     */
    public void setContent(String content) {
        this.content = content;
    }

    public Long getModifyRefundPrice() {
        return modifyRefundPrice;
    }

    public void setModifyRefundPrice(Long modifyRefundPrice) {
        this.modifyRefundPrice = modifyRefundPrice;
    }
}
