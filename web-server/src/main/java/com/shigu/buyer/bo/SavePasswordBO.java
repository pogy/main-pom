package com.shigu.buyer.bo;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;

/**
 * 修改密码
 * Created by zhaohongbo on 17/3/14.
 */
public class SavePasswordBO implements Serializable{
    /**
     * 老密码
     */
    @NotEmpty(message = "请输入老密码")
    @SafeHtml(message = "oldPwd包含非法页面标签")
    private String oldPwd;
    /**
     * 新密码
     */
    @NotEmpty(message = "请输入新密码")
    @SafeHtml(message = "newPwd包含非法页面标签")
    private String newPwd;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
