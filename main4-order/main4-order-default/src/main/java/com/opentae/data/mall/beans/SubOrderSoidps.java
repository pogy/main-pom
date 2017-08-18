package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class SubOrderSoidps implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long soidpId;

    /**
     * 子订单号
     */
	private Long soid;

	public void setSoidpId(Long soidpId) {
		this.soidpId = soidpId;
	}

	public Long getSoidpId() {
		return this.soidpId;
	}

	public void setSoid(Long soid) {
		this.soid = soid;
	}

	public Long getSoid() {
		return this.soid;
	}

}