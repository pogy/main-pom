package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class MemberInviteCode implements Serializable {
    /**
     * 用户邀请码表主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer userInviteCodeId;

    /**
     * 用户id
     */
	private Long userId;

    /**
     * 用户邀请码
     */
	private String userInviteCode;

    /**
     * 
     */
	private Date createTime;

	public void setUserInviteCodeId(Integer userInviteCodeId) {
		this.userInviteCodeId = userInviteCodeId;
	}

	public Integer getUserInviteCodeId() {
		return this.userInviteCodeId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserInviteCode(String userInviteCode) {
		this.userInviteCode = userInviteCode;
	}

	public String getUserInviteCode() {
		return this.userInviteCode;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

}