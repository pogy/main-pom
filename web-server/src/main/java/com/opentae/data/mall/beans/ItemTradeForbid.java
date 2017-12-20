package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ItemTradeForbid implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long forbidId;

    /**
     * 1、按市场，2、按店，3、按商品，4、按类目，5、按楼层
     */
	private Integer type;

    /**
     * 目标ID
     */
	private Long targetId;

    /**
     * 发件单位
     */
	private Long senderId;

    /**
     * 0 禁止销售，1 允许销售
     */
	private Integer canSale;

	public void setForbidId(Long forbidId) {
		this.forbidId = forbidId;
	}

	public Long getForbidId() {
		return this.forbidId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Long getTargetId() {
		return this.targetId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getSenderId() {
		return this.senderId;
	}

	public void setCanSale(Integer canSale) {
		this.canSale = canSale;
	}

	public Integer getCanSale() {
		return this.canSale;
	}

}