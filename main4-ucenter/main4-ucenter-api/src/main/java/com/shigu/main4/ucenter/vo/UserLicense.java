package com.shigu.main4.ucenter.vo;

import com.shigu.main4.ucenter.enums.MemberLicenseType;

import java.io.Serializable;

/**
 * 用户权益
 * Created by zhaohongbo on 17/3/1.
 */
public class UserLicense implements Serializable{

    /**
     * 权益种类
     */
    private MemberLicenseType type;
    /**
     * 权益内容
     */
    private String context;

    public MemberLicenseType getType() {
        return type;
    }

    public void setType(MemberLicenseType type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
