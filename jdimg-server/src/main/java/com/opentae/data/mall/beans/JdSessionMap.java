package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class JdSessionMap implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户的京东uid
     */
	private Long jdUid;

    /**
     * 用户京东昵称
     */
	private String jdUserNick;

    /**
     * 授权token
     */
	private String accessToken;

    /**
     * 刷新token
     */
	private String refreshToken;

    /**
     * 授权时间
     */
	private Date authTime;

    /**
     * 
     */
	private Integer expiresIn;

    /**
     * 创建时间
     */
	private Date gmtCreate;

    /**
     * 修改时间
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setJdUid(Long jdUid) {
		this.jdUid = jdUid;
	}

	public Long getJdUid() {
		return this.jdUid;
	}

	public void setJdUserNick(String jdUserNick) {
		this.jdUserNick = jdUserNick;
	}

	public String getJdUserNick() {
		return this.jdUserNick;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}

	public Date getAuthTime() {
		return this.authTime;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Integer getExpiresIn() {
		return this.expiresIn;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}