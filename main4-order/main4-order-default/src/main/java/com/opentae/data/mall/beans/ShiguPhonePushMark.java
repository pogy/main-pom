package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class ShiguPhonePushMark implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long id;

    /**
     * 星座用户标识
     */
	private String xzUserKey;

    /**
     * 手机唯一码
     */
	private String deviceToken;

    /**
     * 第三方推送标识
     */
	private String pushCid;

    /**
     * 手机类型 0 安卓 1 IOS
     */
	private Integer phoneModel;

    /**
     * md5加密后的推送配置的appId
     */
	private String pushAppId;

    /**
     * 
     */
	private Date gmtCreate;

    /**
     * 
     */
	private Date gmtModify;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setXzUserKey(String xzUserKey) {
		this.xzUserKey = xzUserKey;
	}

	public String getXzUserKey() {
		return this.xzUserKey;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken() {
		return this.deviceToken;
	}

	public void setPushCid(String pushCid) {
		this.pushCid = pushCid;
	}

	public String getPushCid() {
		return this.pushCid;
	}

	public void setPhoneModel(Integer phoneModel) {
		this.phoneModel = phoneModel;
	}

	public Integer getPhoneModel() {
		return this.phoneModel;
	}

	public void setPushAppId(String pushAppId) {
		this.pushAppId = pushAppId;
	}

	public String getPushAppId() {
		return this.pushAppId;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

}