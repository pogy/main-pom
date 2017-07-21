package com.shigu.main4.order.vo;

import com.shigu.main4.order.enums.RefundStateEnum;

/**
 * 退单信息
 * Created by zhaohongbo on 17/7/20.
 */
public class RefundVO {
    /**
     * 退单ID
     */
    private Long refundId;
    /**
     * 买家邮寄单号
     */
    private String buyerCourier;
    /**
     * 退状态
     */
    private RefundStateEnum refundState;
    /**
     * 实退金额
     */
    private Long refundMoney;
    /**
     * 买家期望退金额
     */
    private Long hopeMoney;
    /**
     * 卖家议价金额
     */
    private Long sellerProposalMoney;
    /**
     * 退数量
     */
    private Integer number;
    /**
     * 退原因
     */
    private String reason;
    /**
     * 退失败原因
     */
    private String failMsg;
    /**
     * 订单ID
     */
    private Long oid;
    /**
     * 子订单ID
     */
    private Long soid;

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getBuyerCourier() {
        return buyerCourier;
    }

    public void setBuyerCourier(String buyerCourier) {
        this.buyerCourier = buyerCourier;
    }

    public RefundStateEnum getRefundState() {
        return refundState;
    }

    public void setRefundState(RefundStateEnum refundState) {
        this.refundState = refundState;
    }

    public Long getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Long refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Long getHopeMoney() {
        return hopeMoney;
    }

    public void setHopeMoney(Long hopeMoney) {
        this.hopeMoney = hopeMoney;
    }

    public Long getSellerProposalMoney() {
        return sellerProposalMoney;
    }

    public void setSellerProposalMoney(Long sellerProposalMoney) {
        this.sellerProposalMoney = sellerProposalMoney;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }
}
