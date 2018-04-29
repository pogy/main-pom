package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoGoatNav implements Serializable {
    /**
     * 分类ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long navId;

    /**
     * 分类名
     */
	private String navName;

    /**
     * 父级分类ID
     */
	private Long parentNavId;

    /**
     * 父级分类名
     */
	private String parentNavName;

    /**
     * 是否热度
     */
	private Boolean hot;

    /**
     * 
     */
	private Integer pageGuide;

    /**
     * 
     */
	private Long targetId;

	public void setNavId(Long navId) {
		this.navId = navId;
	}

	public Long getNavId() {
		return this.navId;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getNavName() {
		return this.navName;
	}

	public void setParentNavId(Long parentNavId) {
		this.parentNavId = parentNavId;
	}

	public Long getParentNavId() {
		return this.parentNavId;
	}

	public void setParentNavName(String parentNavName) {
		this.parentNavName = parentNavName;
	}

	public String getParentNavName() {
		return this.parentNavName;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Boolean getHot() {
		return this.hot;
	}

	public void setPageGuide(Integer pageGuide) {
		this.pageGuide = pageGuide;
	}

	public Integer getPageGuide() {
		return this.pageGuide;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Long getTargetId() {
		return this.targetId;
	}

}