package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemCidWeight implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cwId;

    /**
     * 叶子ID
     */
	private Long cid;

    /**
     * 重量，单位为g
     */
	private Long weight;

	public void setCwId(Long cwId) {
		this.cwId = cwId;
	}

	public Long getCwId() {
		return this.cwId;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getWeight() {
		return this.weight;
	}

}