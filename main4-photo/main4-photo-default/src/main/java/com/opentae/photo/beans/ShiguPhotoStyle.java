package com.opentae.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoStyle implements Serializable {
    /**
     * 风格ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long styleId;

    /**
     * 风格名
     */
	private String styleName;

    /**
     * 
     */
	private Long userId;

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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

}