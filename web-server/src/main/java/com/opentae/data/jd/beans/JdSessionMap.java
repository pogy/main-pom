package com.opentae.data.jd.beans;

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
	private Long tokenId;

    /**
     * 
     */
	private Long uid;

    /**
     * 
     */
	private String appKey;

    /**
     * 
     */
	private String userNick;

    /**
     * 
     */
	private Long expiresIn;

    /**
     * 
     */
	private Long authTime;

    /**
     * 
     */
	private String accessToken;

    /**
     * 
     */
	private String refreshToken;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private Date lastModifyTime;

	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}

	public Long getTokenId() {
		return this.tokenId;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppKey() {
		return this.appKey;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserNick() {
		return this.userNick;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getExpiresIn() {
		return this.expiresIn;
	}

	public void setAuthTime(Long authTime) {
		this.authTime = authTime;
	}

	public Long getAuthTime() {
		return this.authTime;
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

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getLastModifyTime() {
		return this.lastModifyTime;
	}

}