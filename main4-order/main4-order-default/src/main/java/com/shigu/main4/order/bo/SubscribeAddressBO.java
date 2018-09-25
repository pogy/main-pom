package com.shigu.main4.order.bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by gtx on 2018/9/3 0003.
 *
 * @author gtx
 * @since
 */
public class SubscribeAddressBO implements Serializable {

    @JSONField(name = "Name")
    private String name;

    @JSONField(name = "Mobile")
    private String mobile;

    @JSONField(name = "Tel")
    private String tel;

    @JSONField(name = "ProvinceName")
    private String provinceName;

    @JSONField(name = "CityName")
    private String cityName;

    @JSONField(name = "ExpAreaName")
    private String expAreaName;

    @JSONField(name = "Address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getExpAreaName() {
        return expAreaName;
    }

    public void setExpAreaName(String expAreaName) {
        this.expAreaName = expAreaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
