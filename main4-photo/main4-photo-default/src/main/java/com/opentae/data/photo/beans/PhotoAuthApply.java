package com.opentae.data.photo.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class PhotoAuthApply implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long authApplyId;

    /**
     * 申请用户id
     */
	private Long authId;

    /**
     * 用户名
     */
	private String userName;

    /**
     * 
     */
	private Integer authType;

    /**
     * 认证手机号
     */
	private String authPhone;

    /**
     * 个人展示封面
     */
	private String showImg;

    /**
     * 二维码
     */
	private String codeImg;

    /**
     * 主要风格id
     */
	private Long mainStyleId;

    /**
     * 申请状态:0:未处理 1:通过 2:驳回
     */
	private Integer applyStatus;

    /**
     * 申请时间
     */
	private Date applyTime;

    /**
     * 修改时间
     */
	private Date modifyTime;

    /**
     * 操作日志
     */
	private String modifyLog;

	public void setAuthApplyId(Long authApplyId) {
		this.authApplyId = authApplyId;
	}

	public Long getAuthApplyId() {
		return this.authApplyId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Long getAuthId() {
		return this.authId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public Integer getAuthType() {
		return this.authType;
	}

	public void setAuthPhone(String authPhone) {
		this.authPhone = authPhone;
	}

	public String getAuthPhone() {
		return this.authPhone;
	}

	public void setShowImg(String showImg) {
		this.showImg = showImg;
	}

	public String getShowImg() {
		return this.showImg;
	}

	public void setCodeImg(String codeImg) {
		this.codeImg = codeImg;
	}

	public String getCodeImg() {
		return this.codeImg;
	}

	public void setMainStyleId(Long mainStyleId) {
		this.mainStyleId = mainStyleId;
	}

	public Long getMainStyleId() {
		return this.mainStyleId;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getApplyStatus() {
		return this.applyStatus;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyLog(String modifyLog) {
		this.modifyLog = modifyLog;
	}

	public String getModifyLog() {
		return this.modifyLog;
	}

}