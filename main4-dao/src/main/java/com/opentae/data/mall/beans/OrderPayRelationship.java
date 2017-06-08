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
	private String rid;

    /**
     * 订单ID
     */
	private String oid;

    /**
     * 支付ID
     */
	private String payId;

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRid() {
		return this.rid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayId() {
		return this.payId;
	}

}