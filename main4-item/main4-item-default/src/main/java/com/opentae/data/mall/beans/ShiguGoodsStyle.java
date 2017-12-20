package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsStyle implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long gsId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 风格ID
     */
	private String sids;

	public void setGsId(Long gsId) {
		this.gsId = gsId;
	}

	public Long getGsId() {
		return this.gsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public String getSids() {
		return this.sids;
	}

}