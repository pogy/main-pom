package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemOrderVoucherRelation implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long voucherOrderRelationId;

    /**
     * 代金券id
     */
	private Long voucherId;

    /**
     * 使用了代金券的订单id
     */
	private Long orderId;

    /**
     * 优惠券状态 0选中 1使用 2取消
     */
	private Integer voucherStatus;

	public void setVoucherOrderRelationId(Long voucherOrderRelationId) {
		this.voucherOrderRelationId = voucherOrderRelationId;
	}

	public Long getVoucherOrderRelationId() {
		return this.voucherOrderRelationId;
	}

	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}

	public Long getVoucherId() {
		return this.voucherId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setVoucherStatus(Integer voucherStatus) {
		this.voucherStatus = voucherStatus;
	}

	public Integer getVoucherStatus() {
		return this.voucherStatus;
	}

}