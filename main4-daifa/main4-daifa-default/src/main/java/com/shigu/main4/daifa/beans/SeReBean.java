package com.shigu.main4.daifa.beans;

import java.io.Serializable;

public class SeReBean implements Serializable {

	private String Name;//姓名
	private String Tel;//电话
	private String ProvinceName;//省份
	private String CityName;//城市
	private String Address;//地址
	private String ExpAreaName;//区域名
    private String postCode;//邮编

	public String getExpAreaName() {
		return ExpAreaName;
	}

	public void setExpAreaName(String expAreaName) {
		ExpAreaName = expAreaName;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getProvinceName() {
		return ProvinceName;
	}
	public void setProvinceName(String provinceName) {
		ProvinceName = provinceName;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
