package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayAccount implements Serializable {
    /**
     * 账户ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long accountId;

    /**
     * 星座用户ID对应Member_user_sub
     */
	private Long xzUserId;

    /**
     * 
     */
	private String xzUserName;

    /**
     * 属组ID
     */
	private Long groupId;

    /**
     * 支付宝用户ID
     */
	private String alipayUserId;

    /**
     * 支付宝用户名
     */
	private String alipayUserName;

    /**
     * 微信用户ID
     */
	private String wxUserId;

    /**
     * 微信用户名
     */
	private String wxUserName;

    /**
     * 账户种类，1星座宝，2支付宝，3微信
     */
	private Integer accountType;

    /**
     * 密码
     */
	private String password;

    /**
     * 0不可用，1可用
     */
	private Integer statue;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 1表示代发管理员，2表示代发拿货员，3表示代发仓库，4表示代发拿货主管，5表示代发费虚拟账户，6表示快递费虚拟账户
     */
	private Integer workType;

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setXzUserId(Long xzUserId) {
		this.xzUserId = xzUserId;
	}

	public Long getXzUserId() {
		return this.xzUserId;
	}

	public void setXzUserName(String xzUserName) {
		this.xzUserName = xzUserName;
	}

	public String getXzUserName() {
		return this.xzUserName;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}

	public String getAlipayUserId() {
		return this.alipayUserId;
	}

	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}

	public String getAlipayUserName() {
		return this.alipayUserName;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	public String getWxUserId() {
		return this.wxUserId;
	}

	public void setWxUserName(String wxUserName) {
		this.wxUserName = wxUserName;
	}

	public String getWxUserName() {
		return this.wxUserName;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountType() {
		return this.accountType;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public Integer getStatue() {
		return this.statue;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setWorkType(Integer workType) {
		this.workType = workType;
	}

	public Integer getWorkType() {
		return this.workType;
	}

}