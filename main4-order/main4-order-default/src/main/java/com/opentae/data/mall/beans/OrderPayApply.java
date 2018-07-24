package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class OrderPayApply implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long applyId;

    /**
     * 钱数
     */
	private Long money;

    /**
     * 支付链接
     */
	private String payLink;

    /**
     * 1微信、2支付宝、3星座宝
     */
	private Integer type;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 支付理由，1星座进货，2充值
     */
	private Integer payFor;

    /**
     * 订单ID
     */
	private Long oid;

    /**
     * 用户ID
     */
	private Long userId;

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getApplyId() {
		return this.applyId;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getMoney() {
		return this.money;
	}

	public void setPayLink(String payLink) {
		this.payLink = payLink;
	}

	public String getPayLink() {
		return this.payLink;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setPayFor(Integer payFor) {
		this.payFor = payFor;
	}

	public Integer getPayFor() {
		return this.payFor;
	}

	@Deprecated
	public void setOid(Long oid) {
		this.oid = oid;
	}
	@Deprecated
	public Long getOid() {
		return this.oid;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

}