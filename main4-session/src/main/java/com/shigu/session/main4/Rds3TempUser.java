package com.shigu.session.main4;

import com.shigu.session.main4.enums.LoginFromType;

import java.io.Serializable;

/**
 * 第3方登陆成功以后，用户不存在，临时存储
 * Created by Licca on 17/2/20.
 */
public class Rds3TempUser implements Serializable{
    /**
     * 第三方用户名
     */
    private String subUserName;
    /**
     * 第三方唯一标识,当loginFromType为phone时,此处为userId
     */
    private String subUserKey;

    private LoginFromType loginFromType;

    /**
     * 终端来源 参见 com.shigu.main4.ucenter.enums.RegistSourceEnum
     */
    private Integer formResource;

    public LoginFromType getLoginFromType() {
        return loginFromType;
    }

    public void setLoginFromType(LoginFromType loginFromType) {
        this.loginFromType = loginFromType;
    }

    public String getSubUserKey() {
        return subUserKey;
    }

    public void setSubUserKey(String subUserKey) {
        this.subUserKey = subUserKey;
    }

    public String getSubUserName() {
        return subUserName;
    }

    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName;
    }

    public Integer getFormResource() {
        return formResource;
    }

    public void setFormResource(Integer formResource) {
        this.formResource = formResource;
    }
}
