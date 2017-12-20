package com.openJar.responses.thirdSupport;

import com.openJar.responses.Response;

/**
 * Created by pc on 2016-03-22.
 */
public class ThirdLoinResponse extends Response {

    private String loginName;
    private Long daifaSellerId;//
    private Long workerId;//
    private String phone;
    private String userName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getDaifaSellerId() {
        return daifaSellerId;
    }

    public void setDaifaSellerId(Long daifaSellerId) {
        this.daifaSellerId = daifaSellerId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}

