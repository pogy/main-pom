package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguCustomerStyle implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long styleId;

    /**
     * 风格名
     */
	private String styleName;

    /**
     * 风格类型 1为自定义0为固定风格，暂时用不到
     */
	private Integer styleType;

    /**
     * 产品id 貌似不需要，再goods表的remark9，设置自定义风格
     */
	private Long goodsId;

    /**
     * 自定义设置，固定不设置
     */
	private Long userId;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 类目id
     */
	private Long cId;

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public void setStyleType(Integer styleType) {
		this.styleType = styleType;
	}

	public Integer getStyleType() {
		return this.styleType;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setCId(Long cId) {
		this.cId = cId;
	}

	public Long getCId() {
		return this.cId;
	}

}