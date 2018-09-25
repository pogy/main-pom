package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayXzb implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long xzbId;

    /**
     * 支付系统账户ID
     */
	private Long accountId;

    /**
     * 拥有的钱数
     */
	private Long money;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 最后更新时间
     */
	private Date lastModifyTime;

    /**
     * 冻结金额
     */
	private Long blockMoney;

    /**
     * 总额
     */
	private Long totalMoney;

	public void setXzbId(Long xzbId) {
		this.xzbId = xzbId;
	}

	public Long getXzbId() {
		return this.xzbId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
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

	public void setBlockMoney(Long blockMoney) {
		this.blockMoney = blockMoney;
	}

	public Long getBlockMoney() {
		return this.blockMoney;
	}

	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getTotalMoney() {
		return this.totalMoney;
	}

}