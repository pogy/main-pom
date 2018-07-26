package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class InviteOrderRebateRecord implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer idinviteOrderRebateRecordId;

    /**
     * 被邀请用户id
     */
	private Long userId;

    /**
     * 返现订单id
     */
	private Long orderId;

    /**
     * 邀请人用户id，即返现用户id
     */
	private Long inviteUserId;

    /**
     * 返现金额
     */
	private Long rebateAmount;

    /**
     * 返点状态 1向支付站发起返点申请 2返点成功
     */
	private Integer rebateState;

    /**
     * 返现成功时间
     */
	private Date rebateTime;

	public void setIdinviteOrderRebateRecordId(Integer idinviteOrderRebateRecordId) {
		this.idinviteOrderRebateRecordId = idinviteOrderRebateRecordId;
	}

	public Integer getIdinviteOrderRebateRecordId() {
		return this.idinviteOrderRebateRecordId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public Long getInviteUserId() {
		return this.inviteUserId;
	}

	public void setRebateAmount(Long rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public Long getRebateAmount() {
		return this.rebateAmount;
	}

	public void setRebateState(Integer rebateState) {
		this.rebateState = rebateState;
	}

	public Integer getRebateState() {
		return this.rebateState;
	}

	public void setRebateTime(Date rebateTime) {
		this.rebateTime = rebateTime;
	}

	public Date getRebateTime() {
		return this.rebateTime;
	}

}