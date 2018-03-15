package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaSeller implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long dfSellerId;

    /**
     * 
     */
	private String name;

    /**
     * 
     */
	private String imWw;

    /**
     * 
     */
	private String email;

    /**
     * 
     */
	private Date lastLogin;

    /**
     * 
     */
	private String telephone;

    /**
     * 
     */
	private String address;

    /**
     * 0不可用 1可用
     */
	private Integer status;

    /**
     * 
     */
	private String webSite;

    /**
     * 
     */
	private Long buycityId;

    /**
     * 
     */
	private String imQq;

    /**
     * 
     */
	private Date lastDoTime;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private String remark1;

    /**
     * 
     */
	private String remark2;

    /**
     * 支付宝账号
     */
	private String alipayAccount;

    /**
     * 微信账号
     */
	private String weixinAccount;

    /**
     * 自动截单时间间隔
     */
	private Integer endSpeed;

	public void setDfSellerId(Long dfSellerId) {
		this.dfSellerId = dfSellerId;
	}

	public Long getDfSellerId() {
		return this.dfSellerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setImWw(String imWw) {
		this.imWw = imWw;
	}

	public String getImWw() {
		return this.imWw;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setBuycityId(Long buycityId) {
		this.buycityId = buycityId;
	}

	public Long getBuycityId() {
		return this.buycityId;
	}

	public void setImQq(String imQq) {
		this.imQq = imQq;
	}

	public String getImQq() {
		return this.imQq;
	}

	public void setLastDoTime(Date lastDoTime) {
		this.lastDoTime = lastDoTime;
	}

	public Date getLastDoTime() {
		return this.lastDoTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getAlipayAccount() {
		return this.alipayAccount;
	}

	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}

	public String getWeixinAccount() {
		return this.weixinAccount;
	}

	public void setEndSpeed(Integer endSpeed) {
		this.endSpeed = endSpeed;
	}

	public Integer getEndSpeed() {
		return this.endSpeed;
	}

}