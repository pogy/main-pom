package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguBonusRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 流水号
     */
	private String serialNumber;

    /**
     * 支付方userId，0=系统充值
     */
	private Long fromUserId;

    /**
     * 接收方userId，0=系统回收
     */
	private Long toUserId;

    /**
     * 用户在第三方系统的唯一识别号，如：淘宝NICK、京东NICK
     */
	private String thirdId;

    /**
     * 数量，单位：分
     */
	private Long amount;

    /**
     * 类型：1=系统充值，2=用户使用
     */
	private Integer type;

    /**
     * 状态：1=成功
     */
	private Integer status;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date updateTime;

    /**
     * 8 为 京东充值，3 为淘宝充值
     */
	private Integer tab;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getFromUserId() {
		return this.fromUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public Long getToUserId() {
		return this.toUserId;
	}

	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}

	public String getThirdId() {
		return this.thirdId;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setTab(Integer tab) {
		this.tab = tab;
	}

	public Integer getTab() {
		return this.tab;
	}

}