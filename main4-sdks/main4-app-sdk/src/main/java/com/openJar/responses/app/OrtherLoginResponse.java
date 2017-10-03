package com.openJar.responses.app;

import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;

/**
 * 类名：OrtherLoginResponse
 * 类路径：com.openJar.responses.app.OrtherLoginResponse
 * 创建者：任真飞
 * 创建时间：2017-10-01 17:40
 * 项目：main-pom
 * 描述：
 */
public class OrtherLoginResponse  extends Response {
    //已经绑定星座网返回的数据
    private AppUser users;
    //未绑定星座网账号,返回数据唯一键
    private String tempId;
    //0未绑定星座网1绑定星座网
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public AppUser getUsers() {
        return users;
    }

    public void setUsers( AppUser users ) {
        this.users = users;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId( String tempId ) {
        this.tempId = tempId;
    }
}