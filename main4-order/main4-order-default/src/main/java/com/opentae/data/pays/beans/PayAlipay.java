package com.opentae.data.pays.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PayAlipay implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long paId;

    /**
     * 支付宝用户ID
     */
	private String alipayUserId;

    /**
     * 支付宝用户名
     */
	private String alipayUserName;

    /**
     * 理论余额值
     */
	private Long price;

    /**
     * 0正常，1有问题
     */
	private Integer dangerous;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 最后更新时间
     */
	private Date lastModifyTime;

    /**
     * 昵称
     */
	private String tbNick;

    /**
     * 1表示需要检查授权，0表示不需要检查授权
     */
	private Integer needAuth;

    /**
     * 用户支付宝ID
     */
	private String ownerUserId;

    /**
     * 回款金额，每日终结时变0
     */
	private Long tempPrice;

	public void setPaId(Long paId) {
		this.paId = paId;
	}

	public Long getPaId() {
		return this.paId;
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

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setDangerous(Integer dangerous) {
		this.dangerous = dangerous;
	}

	public Integer getDangerous() {
		return this.dangerous;
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

	public void setTbNick(String tbNick) {
		this.tbNick = tbNick;
	}

	public String getTbNick() {
		return this.tbNick;
	}

	public void setNeedAuth(Integer needAuth) {
		this.needAuth = needAuth;
	}

	public Integer getNeedAuth() {
		return this.needAuth;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getOwnerUserId() {
		return this.ownerUserId;
	}

	public void setTempPrice(Long tempPrice) {
		this.tempPrice = tempPrice;
	}

	public Long getTempPrice() {
		return this.tempPrice;
	}

}