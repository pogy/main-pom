package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGoodsUnlicense implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long unlicenseId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 
     */
	private String unlicenseContext;

	public void setUnlicenseId(Long unlicenseId) {
		this.unlicenseId = unlicenseId;
	}

	public Long getUnlicenseId() {
		return this.unlicenseId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setUnlicenseContext(String unlicenseContext) {
		this.unlicenseContext = unlicenseContext;
	}

	public String getUnlicenseContext() {
		return this.unlicenseContext;
	}

}