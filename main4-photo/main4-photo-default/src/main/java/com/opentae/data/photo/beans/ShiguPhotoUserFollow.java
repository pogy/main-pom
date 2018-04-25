package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoUserFollow implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long followId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 作者ID
     */
	private Long followUserId;

    /**
     * 
     */
	private Integer status;

	public void setFollowId(Long followId) {
		this.followId = followId;
	}

	public Long getFollowId() {
		return this.followId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setFollowUserId(Long followUserId) {
		this.followUserId = followUserId;
	}

	public Long getFollowUserId() {
		return this.followUserId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}