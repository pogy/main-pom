package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoWorksStyle implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long linkId;

    /**
     * 作品ID
     */
	private Long worksId;

    /**
     * 风格ID
     */
	private Long styleId;

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public Long getLinkId() {
		return this.linkId;
	}

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}

	public Long getWorksId() {
		return this.worksId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

}