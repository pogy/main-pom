package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class StyleChannelCidSearchMap implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 
     */
	private Long styleChannelSearchId;

    /**
     * 淘宝类目cid
     */
	private Long cid;

    /**
     * 搜索用关键字（可能会根据产品设计，使用实际类目，现有实现先保留使用本字段)
     */
	private String searchName;

    /**
     * 搜索类目名
     */
	private String cateName;

    /**
     * 显示排序
     */
	private Integer sort;

    /**
     * 是否显示，0不显示，1显示
     */
	private Integer showCase;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setStyleChannelSearchId(Long styleChannelSearchId) {
		this.styleChannelSearchId = styleChannelSearchId;
	}

	public Long getStyleChannelSearchId() {
		return this.styleChannelSearchId;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchName() {
		return this.searchName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setShowCase(Integer showCase) {
		this.showCase = showCase;
	}

	public Integer getShowCase() {
		return this.showCase;
	}

}