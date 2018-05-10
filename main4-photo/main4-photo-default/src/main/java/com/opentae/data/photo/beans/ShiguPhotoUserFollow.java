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
     * 作者ID
     */
	private Long authorId;

    /**
     * 作者ID
     */
	private Long followAuthorId;

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

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public void setFollowAuthorId(Long followAuthorId) {
		this.followAuthorId = followAuthorId;
	}

	public Long getFollowAuthorId() {
		return this.followAuthorId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}