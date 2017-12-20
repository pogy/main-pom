package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderPayRelationship implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long rid;

    /**
     * 订单ID
     */
	private Long oid;

    /**
     * 支付ID
     */
	private Long payId;

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getRid() {
		return this.rid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Long getPayId() {
		return this.payId;
	}

}