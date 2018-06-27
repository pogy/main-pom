package com.opentae.data.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class SnSession implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtModif;

    /**
     * 苏宁用户名
     */
	private String userName;

    /**
     * 访问令牌
     */
	private String accessToken;

    /**
     * 刷新访问令牌
     */
	private String refreshToken;

    /**
     * 
     */
	private String tokenType;

    /**
     * 过期时间
     */
	private Integer expiresIn;

    /**
     * 用户会员编码
     */
	private Long custnum;

    /**
     * 用户类型
     */
	private Integer module;

    /**
     * 商家编码
     */
	private Long vendorCode;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModif(Date gmtModif) {
		this.gmtModif = gmtModif;
	}

	public Date getGmtModif() {
		return this.gmtModif;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
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

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getTokenType() {
		return this.tokenType;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Integer getExpiresIn() {
		return this.expiresIn;
	}

	public void setCustnum(Long custnum) {
		this.custnum = custnum;
	}

	public Long getCustnum() {
		return this.custnum;
	}

	public void setModule(Integer module) {
		this.module = module;
	}

	public Integer getModule() {
		return this.module;
	}

	public void setVendorCode(Long vendorCode) {
		this.vendorCode = vendorCode;
	}

	public Long getVendorCode() {
		return this.vendorCode;
	}

}