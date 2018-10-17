package com.shigu.main4.monitor.bo;

import java.io.Serializable;

/**
 *App用户bug反馈
 */
public class ShiguFeedbackBO implements Serializable{
    /**用户ID*/
    private Long userId;
    /**反馈内容*/
    private String fcontents;

    /**
     * 手机品牌
     */
    private String phoneBrand;

    /**
     * 手机型号
     */
    private String phoneModel;

    /**
     * 操作系统版本号
     */
    private String osVersion;

    /**
     * 请求接口的版本号
     */
    private String openVersion;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFcontents() {
        return fcontents;
    }

    public void setFcontents(String fcontents) {
        this.fcontents = fcontents;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
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
}
