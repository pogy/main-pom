package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsupNoreal implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long norealId;

    /**
     * 商品唯一ID
     */
	private Long itemId;

    /**
     * 增量数据
     */
	private Integer addNum;

    /**
     * 临时真值
     */
	private Integer realNum;

    /**
     * 活动批次
     */
	private Integer activeNum;

	public void setNorealId(Long norealId) {
		this.norealId = norealId;
	}

	public Long getNorealId() {
		return this.norealId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setAddNum(Integer addNum) {
		this.addNum = addNum;
	}

	public Integer getAddNum() {
		return this.addNum;
	}

	public void setRealNum(Integer realNum) {
		this.realNum = realNum;
	}

	public Integer getRealNum() {
		return this.realNum;
	}

	public void setActiveNum(Integer activeNum) {
		this.activeNum = activeNum;
	}

	public Integer getActiveNum() {
		return this.activeNum;
	}

}