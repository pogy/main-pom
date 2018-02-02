package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguNewActivityUpRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 活动ID
     */
	private Long newActiveId;

    /**
     * 用户ID
     */
	private Long memberId;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 类型：1=出售中，2=仓库中
     */
	private Integer type;

    /**
     * 记录创建时间
     */
	private Date gmtCreate;

    /**
     * 记录最近更新时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setNewActiveId(Long newActiveId) {
		this.newActiveId = newActiveId;
	}

	public Long getNewActiveId() {
		return this.newActiveId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}