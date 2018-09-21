package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguMarketActivityGoods implements Serializable {
    /**
     * 市场活动商品id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long magId;

    /**
     * 商品id
     */
	private Long goodsId;

    /**
     * 市场活动id
     */
	private Long maId;

    /**
     * 活动商品状态1：正常 -1：删除
     */
	private Integer magStatus;

    /**
     * 活动商品排序
     */
	private Integer sort;

	public void setMagId(Long magId) {
		this.magId = magId;
	}

	public Long getMagId() {
		return this.magId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setMaId(Long maId) {
		this.maId = maId;
	}

	public Long getMaId() {
		return this.maId;
	}

	public void setMagStatus(Integer magStatus) {
		this.magStatus = magStatus;
	}

	public Integer getMagStatus() {
		return this.magStatus;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

}