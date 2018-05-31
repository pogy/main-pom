package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguGysCategoryGoods implements Serializable {
    /**
     * 店铺自定义类目商品关联id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long gcgId;

    /**
     * 店铺自定义类目id
     */
	private Long gcId;

    /**
     * 商品id
     */
	private Long goodsId;

    /**
     * 店铺id
     */
	private Long sId;

    /**
     * 店铺自定义类目商品关联状态-1：删除，1：正常
     */
	private Integer gcgStatus;

	public void setGcgId(Long gcgId) {
		this.gcgId = gcgId;
	}

	public Long getGcgId() {
		return this.gcgId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Long getGcId() {
		return this.gcId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setSId(Long sId) {
		this.sId = sId;
	}

	public Long getSId() {
		return this.sId;
	}

	public void setGcgStatus(Integer gcgStatus) {
		this.gcgStatus = gcgStatus;
	}

	public Integer getGcgStatus() {
		return this.gcgStatus;
	}

}