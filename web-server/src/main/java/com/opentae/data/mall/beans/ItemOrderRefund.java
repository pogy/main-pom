package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ItemOrderRefund implements Serializable {
    /**
     * 退货ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long refundId;

    /**
     * 1退款，2退货，3换货，4截单
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

    /**
     * 
     */
	private Date buyerReturnTime;

    /**
     * 退失败件数
     */
	private Integer failNumber;

    /**
     * 用户是否知晓，0用户未知，1用户已知
     */
	private Boolean userShow;

    /**
     * 0初始，1售后同意，2售后已发货，3档口退货中，4金额改变
     */
	private Integer refundSubInfo;

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

	public void setBuyerReturnTime(Date buyerReturnTime) {
		this.buyerReturnTime = buyerReturnTime;
	}

	public Date getBuyerReturnTime() {
		return this.buyerReturnTime;
	}

	public void setFailNumber(Integer failNumber) {
		this.failNumber = failNumber;
	}

	public Integer getFailNumber() {
		return this.failNumber;
	}

	public void setUserShow(Boolean userShow) {
		this.userShow = userShow;
	}

	public Boolean getUserShow() {
		return this.userShow;
	}

	public void setRefundSubInfo(Integer refundSubInfo) {
		this.refundSubInfo = refundSubInfo;
	}

	public Integer getRefundSubInfo() {
		return this.refundSubInfo;
	}

}