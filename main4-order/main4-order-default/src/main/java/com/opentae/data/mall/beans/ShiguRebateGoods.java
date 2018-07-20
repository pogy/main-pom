package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguRebateGoods implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 商品id
     */
	private Long goodsId;

    /**
     * 是否有效 1 生效  0 失效
     */
	private Integer goodsStatus;

    /**
     * 商品所属分类id
     */
	private Long goodsTabId;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtUpdate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public Integer getGoodsStatus() {
		return this.goodsStatus;
	}

	public void setGoodsTabId(Long goodsTabId) {
		this.goodsTabId = goodsTabId;
	}

	public Long getGoodsTabId() {
		return this.goodsTabId;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public Date getGmtUpdate() {
		return this.gmtUpdate;
	}

}