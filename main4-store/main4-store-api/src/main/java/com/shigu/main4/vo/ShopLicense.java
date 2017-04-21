package com.shigu.main4.vo;

import java.io.Serializable;

/**
 * 店铺权益
 * Created by zhaohongbo on 17/2/21.
 */
public class ShopLicense implements Serializable{

    private static final long serialVersionUID = -3793696169974321969L;
    /**
     * 权益ID
     */
    private Long licenseId;
    /**
     * 权益类型
     */
    private Integer licenseType;
    /**
     * 权益内容
     */
    private String context;

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
