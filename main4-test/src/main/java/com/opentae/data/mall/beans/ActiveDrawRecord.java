package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ActiveDrawRecord implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 奖
     */
	private String ward;

    /**
     * 期次ID
     */
	private Long pemId;

    /**
     * 是否领取
     */
	private Boolean receivesYes;

    /**
     * 中奖码
     */
	private String drawCode;

    /**
     * 中奖状态 1 等待中奖 2未中奖 3中奖
     */
	private Integer drawStatus;

    /**
     * 
     */
	private Date refeTime;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date modifyTime;

    /**
     * 数据有效性
     */
	private Boolean enabled;

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

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getWard() {
		return this.ward;
	}

	public void setPemId(Long pemId) {
		this.pemId = pemId;
	}

	public Long getPemId() {
		return this.pemId;
	}

	public void setReceivesYes(Boolean receivesYes) {
		this.receivesYes = receivesYes;
	}

	public Boolean getReceivesYes() {
		return this.receivesYes;
	}

	public void setDrawCode(String drawCode) {
		this.drawCode = drawCode;
	}

	public String getDrawCode() {
		return this.drawCode;
	}

	public void setDrawStatus(Integer drawStatus) {
		this.drawStatus = drawStatus;
	}

	public Integer getDrawStatus() {
		return this.drawStatus;
	}

	public void setRefeTime(Date refeTime) {
		this.refeTime = refeTime;
	}

	public Date getRefeTime() {
		return this.refeTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

}