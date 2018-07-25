package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class MemberAlipayBind implements Serializable {
    /**
     * 用户支付宝绑定id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户id
     */
	private Long userId;

    /**
     * 绑定支付宝账户
     */
	private String alipayId;

    /**
     * 支付宝真实姓名
     */
	private String alipayName;

    /**
     * 是否失效 0 有效 1 失效
     */
	private Boolean isFailure;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}

	public String getAlipayId() {
		return this.alipayId;
	}

	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}

	public String getAlipayName() {
		return this.alipayName;
	}

	public void setIsFailure(Boolean isFailure) {
		this.isFailure = isFailure;
	}

	public Boolean getIsFailure() {
		return this.isFailure;
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