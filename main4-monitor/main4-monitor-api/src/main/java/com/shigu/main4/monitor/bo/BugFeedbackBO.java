package com.shigu.main4.monitor.bo;

import java.io.Serializable;

/**
 * Created By admin on 2017/11/28/13:59
 */
public class BugFeedbackBO implements Serializable{
    /**手机品牌*/
    private String brand;
    /**手机型号*/
    private String mobileModel;
    /**操作系统版本号*/
    private String osVersion;
    /**请求版本号*/
    private String openVersion;
    /**具体反馈内容*/
    private String bugs;

    private Long userId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOpenVersion() {
        return openVersion;
    }

    public void setOpenVersion(String openVersion) {
        this.openVersion = openVersion;
    }

    public String getBugs() {
        return bugs;
    }

    public void setBugs(String bugs) {
        this.bugs = bugs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
