package com.openJar.beans;

import com.openJar.utils.OpenBean;

import java.io.Serializable;
import java.util.Date;

public class SnShopCategory extends OpenBean implements Serializable {
	private Long id;

    /**
     * 苏宁用户名
     */
	private String username;

    /**
     * 
     */
	private String categoryName;

    /**
     * 
     */
	private String categoryCode;

    /**
     * 
     */
	private String categoryImg;

    /**
     * 
     */
	private Integer categorySort;

    /**
     * 
     */
	private Integer categorySet;

    /**
     * 
     */
	private Integer isFirst;

    /**
     * 
     */
	private Long firstId;

    /**
     * 
     */
	private Date gmtCreat;

    /**
     * 
     */
	private Date gmtModif;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}

	public String getCategoryImg() {
		return this.categoryImg;
	}

	public void setCategorySort(Integer categorySort) {
		this.categorySort = categorySort;
	}

	public Integer getCategorySort() {
		return this.categorySort;
	}

	public void setCategorySet(Integer categorySet) {
		this.categorySet = categorySet;
	}

	public Integer getCategorySet() {
		return this.categorySet;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public Integer getIsFirst() {
		return this.isFirst;
	}

	public Long getFirstId() {
		return firstId;
	}

	public void setFirstId(Long firstId) {
		this.firstId = firstId;
	}

	public void setGmtCreat(Date gmtCreat) {
		this.gmtCreat = gmtCreat;
	}

	public Date getGmtCreat() {
		return this.gmtCreat;
	}

	public void setGmtModif(Date gmtModif) {
		this.gmtModif = gmtModif;
	}

	public Date getGmtModif() {
		return this.gmtModif;
	}

}