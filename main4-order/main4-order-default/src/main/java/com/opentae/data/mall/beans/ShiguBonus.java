package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguBonus implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 用户在第三方系统的唯一识别号，如：淘宝NICK、京东NICK
     */
	private String thirdId;

    /**
     * third_id类型：1=淘宝NICK、2=京东NICK
     */
	private Integer type;

    /**
     * 状态：1=正常、2=冻结
     */
	private Integer status;

    /**
     * 红包余额，单位：分
     */
	private Long balance;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 更新时间
     */
	private Date updateTime;

    /**
     * 京东昵称
     */
	private String jdThirdId;

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

	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}

	public String getThirdId() {
		return this.thirdId;
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

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getBalance() {
		return this.balance;
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

	public void setJdThirdId(String jdThirdId) {
		this.jdThirdId = jdThirdId;
	}

	public String getJdThirdId() {
		return this.jdThirdId;
	}

}