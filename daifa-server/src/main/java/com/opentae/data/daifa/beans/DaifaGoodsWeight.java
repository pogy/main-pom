package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaGoodsWeight implements Serializable {
    /**
     * 商品Id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goodsId;

    /**
     * 商品单件重量@单位为克
     */
	private Long goodsWeight;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 代发机构ID
     */
	private Long sellerId;

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsWeight(Long goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public Long getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

}