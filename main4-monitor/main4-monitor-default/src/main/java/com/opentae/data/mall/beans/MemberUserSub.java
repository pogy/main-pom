package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class MemberUserSub implements Serializable {
    /**
     * 子账号ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long subUserId;

    /**
     * 用户ID
     */
	private Long userId;

    /**
     * 子账号名@也包括主账号的用户名
     */
	private String subUserName;

    /**
     * 子账号密码@只有主账号用
     */
	private String subUserPassword;

    /**
     * 子账号唯一识别码
     */
	private String subUserKey;

    /**
     * 子账号类型@3淘宝账号4QQ账号5微信6阿里7用户名(主账号)
     */
	private Integer accountType;

    /**
     * 登录次数
     */
	private Integer logins;

    /**
     * 状态@1正常2停用3解绑
     */
	private Integer useStatus;

    /**
     * webSite
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 备用5
     */
	private String remark5;

    /**
     * 备用6
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 备用8
     */
	private String remark8;

    /**
     * 备用9
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

    /**
     * 是否已经开店@0未开店1已开店
     */
	private Integer isOpenStore;

    /**
     * 创建时间
     */
	private Date createTime;

	public void setSubUserId(Long subUserId) {
		this.subUserId = subUserId;
	}

	public Long getSubUserId() {
		return this.subUserId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setSubUserName(String subUserName) {
		this.subUserName = subUserName;
	}

	public String getSubUserName() {
		return this.subUserName;
	}

	public void setSubUserPassword(String subUserPassword) {
		this.subUserPassword = subUserPassword;
	}

	public String getSubUserPassword() {
		return this.subUserPassword;
	}

	public void setSubUserKey(String subUserKey) {
		this.subUserKey = subUserKey;
	}

	public String getSubUserKey() {
		return this.subUserKey;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountType() {
		return this.accountType;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
	}

	public Integer getLogins() {
		return this.logins;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setIsOpenStore(Integer isOpenStore) {
		this.isOpenStore = isOpenStore;
	}

	public Integer getIsOpenStore() {
		return this.isOpenStore;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

}