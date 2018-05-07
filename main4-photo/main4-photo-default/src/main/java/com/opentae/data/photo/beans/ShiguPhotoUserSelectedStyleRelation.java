package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class ShiguPhotoUserSelectedStyleRelation implements Serializable {
    /**
     * 用户认证时选定风格对应关系
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long authStyleRelaId;

    /**
     * 作者id
     */
	private Long authId;

    /**
     * 用户选定系统风格id
     */
	private Long styleId;

    /**
     * 是否已经生效，0否 1是 当用户认证申请时已经生成，认证通过时生效
     */
	private Integer effected;

	public void setAuthStyleRelaId(Long authStyleRelaId) {
		this.authStyleRelaId = authStyleRelaId;
	}

	public Long getAuthStyleRelaId() {
		return this.authStyleRelaId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Long getAuthId() {
		return this.authId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

	public void setEffected(Integer effected) {
		this.effected = effected;
	}

	public Integer getEffected() {
		return this.effected;
	}

}