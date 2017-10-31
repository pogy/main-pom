package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderPayApplyRelation implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long relationId;

    /**
     * 申请ID
     */
	private Long applyId;

    /**
     * 订单ID
     */
	private Long oid;

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Long getRelationId() {
		return this.relationId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getApplyId() {
		return this.applyId;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getOid() {
		return this.oid;
	}

}