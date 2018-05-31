package com.opentae.data.photo.beans;

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
	private Long authorId;

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

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

}