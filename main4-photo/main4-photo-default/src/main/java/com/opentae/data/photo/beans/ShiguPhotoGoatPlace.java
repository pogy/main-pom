package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoGoatPlace implements Serializable {
    /**
     * 广告ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long goatId;

    /**
     * 作品ID
     */
	private Long worksId;

    /**
     * 位置编号
     */
	private Integer place;

	public void setGoatId(Long goatId) {
		this.goatId = goatId;
	}

	public Long getGoatId() {
		return this.goatId;
	}

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}

	public Long getWorksId() {
		return this.worksId;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Integer getPlace() {
		return this.place;
	}

}