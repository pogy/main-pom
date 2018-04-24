package com.opentae.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoUserPraise implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long praiseId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 作品ID
     */
	private Long worksId;

    /**
     * 
     */
	private Integer status;

	public void setPraiseId(Long praiseId) {
		this.praiseId = praiseId;
	}

	public Long getPraiseId() {
		return this.praiseId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}

	public Long getWorksId() {
		return this.worksId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}