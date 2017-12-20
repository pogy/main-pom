package com.shigu.phone.basevo;

import com.openJar.beans.app.AppUser;

import java.io.Serializable;

/**
 * Created By pc on 2017-10-18/9:07
 */
public class OrtherLoginVO implements Serializable {
    //已经绑定星座网返回的数据
    private AppUser users;
    //未绑定星座网账号,返回数据唯一键
    private String tempId;
    //0未绑定星座网1绑定星座网
    private Integer type;
    //跳转地址	必须
    private String url;

    public AppUser getUsers() {
        return users;
    }

    public void setUsers(AppUser users) {
        this.users = users;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
