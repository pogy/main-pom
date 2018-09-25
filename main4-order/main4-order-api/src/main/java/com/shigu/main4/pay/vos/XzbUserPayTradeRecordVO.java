package com.shigu.main4.pay.vos;

import java.io.Serializable;

/**
 * 类名：XzbUserPayTradeRecordVO
 * 类路径： com.shigu.main4.pay.vos.XzbUserPayTradeRecordVO
 * 创建者： whx
 * 创建时间： 8/7/18 4:44 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbUserPayTradeRecordVO implements Serializable {

    /**
     * 支付交易号
     */
    private Long payId;

    /**
     * 交易类型，1充值，2买入，3退款，4提现，5系统扣款，6打拿货款，7打邮费，8打代发费
     */
    private Integer type;

    /**
     * 扣款种类，1支付宝扣款，2星座宝扣款，3微信扣款，4抵价卷扣款，5星座宝卷混合付款，6红包充值，7订单完成返现
     */
    private Integer debitType;

    /**
     * 支付宝交易号
     */
    private String alipayNo;

    /**
     * 微信交易号
     */
    private String wxNo;

    /**
     * 充值记录ID
     */
    private Long rechargeId;

    /**
     * 代扣款账户ID，这里的账户，仅限于星座宝账户
     */
    private Long behalfAccountId;

    /**
     * 付款方账户ID
     */
    private Long fromAccountId;

    /**
     * 收款方账户ID
     */
    private Long toAccountId;

    /**
     * 外部交易订单号
     */
    private String outTradeNo;

    /**
     * 外部交易子订单号
     */
    private String outSubTradeNo;

    /**
     * 交易现金，按分计算
     */
    private Long price;

    /**
     * 交易总值
     */
    private Long totalPrice;

    /**
     * 外部备注
     */
    private String outComments;

    /**
     * 系统备注
     */
    private String comments;

    /**
     * 1拒单、2缺货、3欠货、4清货
     */
    private Integer refundType;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 资金流向
     */
    private String inout;

    /**
     * 手续费
     */
    private String serviceCharge;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDebitType() {
        return debitType;
    }

    public void setDebitType(Integer debitType) {
        this.debitType = debitType;
    }

    public String getAlipayNo() {
        return alipayNo;
    }

    public void setAlipayNo(String alipayNo) {
        this.alipayNo = alipayNo;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public Long getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Long rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Long getBehalfAccountId() {
        return behalfAccountId;
    }

    public void setBehalfAccountId(Long behalfAccountId) {
        this.behalfAccountId = behalfAccountId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutSubTradeNo() {
        return outSubTradeNo;
    }

    public void setOutSubTradeNo(String outSubTradeNo) {
        this.outSubTradeNo = outSubTradeNo;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOutComments() {
        return outComments;
    }

    public void setOutComments(String outComments) {
        this.outComments = outComments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getInout() {
        return inout;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
