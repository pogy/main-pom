package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class SearchCategory implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long categoryId;

    /**
     * 种类，1、淘宝类目，2、市场，3、风格，4、元素
     */
	private Integer type;

    /**
     * 分类名称
     */
	private String cateName;

    /**
     * 分类值
     */
	private String cateValue;

    /**
     * 
     */
	private Integer sort;

    /**
     * 站点
     */
	private String webSite;

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setCateValue(String cateValue) {
		this.cateValue = cateValue;
	}

	public String getCateValue() {
		return this.cateValue;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

}