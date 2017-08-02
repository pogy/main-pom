package com.shigu.main4.order.servicevo;

/**
 * com.opentae.data.mall.beans.ItemOrderRefund的包装类
 * Created by wanghaoxiang on 2017/8/2 0002.
 */
public class SubOrderRefundBoxingVO {
    /**
     * 退货ID
     */
    private Long refundId;

    /**
     * 1退款，2A类退货，3B类退货
     */
    private Integer type;

    /**
     * 用户回寄单号
     */
    private String buyerCourier;

    /**
     * 0申请中，1卖家受理，2退款完成，3卖家拒绝退请求，4退货失败，5买家已发件，6卖家已收件，7卖家议价，8买家附议，9买家拒绝附议
     */
    private Integer status;

    /**
     * true用户申请，false非用户申请
     */
    private Boolean userApply;

    /**
     * 退失败原因
     */
    private String failMsg;

    /**
     * 已退金额
     */
    private Long refundMoney;

    /**
     * 预期退金额
     */
    private Long hopeMoney;

    /**
     * 退件数
     */
    private Integer number;

    /**
     * 主单ID
     */
    private Long oid;

    /**
     * 子订单号
     */
    private Long soid;

    /**
     * 退单原因
     */
    private String reason;

    /**
     * 卖家建议金额
     */
    private Long sellerProposalMoney;

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getRefundId() {
        return this.refundId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public void setBuyerCourier(String buyerCourier) {
        this.buyerCourier = buyerCourier;
    }

    public String getBuyerCourier() {
        return this.buyerCourier;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setUserApply(Boolean userApply) {
        this.userApply = userApply;
    }

    public Boolean getUserApply() {
        return this.userApply;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public String getFailMsg() {
        return this.failMsg;
    }

    public void setRefundMoney(Long refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Long getRefundMoney() {
        return this.refundMoney;
    }

    public void setHopeMoney(Long hopeMoney) {
        this.hopeMoney = hopeMoney;
    }

    public Long getHopeMoney() {
        return this.hopeMoney;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Long getSoid() {
        return this.soid;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setSellerProposalMoney(Long sellerProposalMoney) {
        this.sellerProposalMoney = sellerProposalMoney;
    }

    public Long getSellerProposalMoney() {
        return this.sellerProposalMoney;
    }
}
