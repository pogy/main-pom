package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class SearchCategorySub implements Serializable {
    /**
     * 子类目主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long subId;

    /**
     * 
     */
	private Integer type;

    /**
     * 上级类目值
     */
	private String parentCateValue;

    /**
     * 类目名
     */
	private String cateName;

    /**
     * 子类目值
     */
	private String cateValue;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 站点
     */
	private String webSite;

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public Long getSubId() {
		return this.subId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setParentCateValue(String parentCateValue) {
		this.parentCateValue = parentCateValue;
	}

	public String getParentCateValue() {
		return this.parentCateValue;
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