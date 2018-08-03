package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class MemberInvite implements Serializable {
    /**
     * 邀请表主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long inviteId;

    /**
     * 受邀请注册用户id
     */
	private Long userId;

    /**
     * 邀请人用户id
     */
	private Long inviteUserId;

    /**
     * 受邀请注册时间
     */
	private Date inviteCreateTime;

    /**
     * 是否有效 0：有效，1：无效
     */
	private Integer valid;

	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

	public Long getInviteId() {
		return this.inviteId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public Long getInviteUserId() {
		return this.inviteUserId;
	}

	public void setInviteCreateTime(Date inviteCreateTime) {
		this.inviteCreateTime = inviteCreateTime;
	}

	public Date getInviteCreateTime() {
		return this.inviteCreateTime;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return this.valid;
	}

}