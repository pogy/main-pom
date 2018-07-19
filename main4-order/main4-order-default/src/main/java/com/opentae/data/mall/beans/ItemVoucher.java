package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ItemVoucher implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long voucherId;

    /**
     * 用户id
     */
	private Long userId;

    /**
     * 代金券状态，1可用，2已用，0失效
     */
	private Integer voucherState;

    /**
     * 代金券获取时间
     */
	private Date createTime;

    /**
     * 代金券过期时间
     */
	private Date expireTime;

    /**
     * 使用时间
     */
	private Date usedTime;

    /**
     * 代金券金额，以分为单位
     */
	private Long voucherAmount;

    /**
     * 代金券识别标记，表示代金券来源并防止代金券重复生成，可以为赠送代金券活动的标记或者代金券号码等
     */
	private String voucherTag;

	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}

	public Long getVoucherId() {
		return this.voucherId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setVoucherState(Integer voucherState) {
		this.voucherState = voucherState;
	}

	public Integer getVoucherState() {
		return this.voucherState;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getExpireTime() {
		return this.expireTime;
	}

	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}

	public Date getUsedTime() {
		return this.usedTime;
	}

	public void setVoucherAmount(Long voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public Long getVoucherAmount() {
		return this.voucherAmount;
	}

	public void setVoucherTag(String voucherTag) {
		this.voucherTag = voucherTag;
	}

	public String getVoucherTag() {
		return this.voucherTag;
	}

}