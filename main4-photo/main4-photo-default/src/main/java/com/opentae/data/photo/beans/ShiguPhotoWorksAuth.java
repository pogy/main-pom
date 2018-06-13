package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoWorksAuth implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long worksAuthId;

    /**
     * 
     */
	private Long worksId;

    /**
     * 
     */
	private String picUrl;

    /**
     * 
     */
	private String images;

    /**
     * 
     */
	private Integer authStatus;

    /**
     * 理由
     */
	private String msg;

	public void setWorksAuthId(Long worksAuthId) {
		this.worksAuthId = worksAuthId;
	}

	public Long getWorksAuthId() {
		return this.worksAuthId;
	}

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}

	public Long getWorksId() {
		return this.worksId;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImages() {
		return this.images;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public Integer getAuthStatus() {
		return this.authStatus;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}