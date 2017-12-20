package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguActivityCategory implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long cateId;

    /**
     * 类别
     */
	private String title;

    /**
     * 活动id
     */
	private Long activeId;

    /**
     * 
     */
	private String titleImg;

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public Long getCateId() {
		return this.cateId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}

	public Long getActiveId() {
		return this.activeId;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getTitleImg() {
		return this.titleImg;
	}

}