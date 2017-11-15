package com.openJar.responses.app;

import com.openJar.beans.app.AppUser;
import com.openJar.responses.Response;

/**
 * 类名：WxLoginResponse
 * 类路径：com.openJar.responses.app.WxLoginResponse
 * 创建者：任真飞
 * 创建时间：2017-11-15 14:29
 * 项目：main-pom
 * 描述：微信登录
 */
public class WxLoginResponse extends Response {
    //0未绑定星座网用户,1已经绑定星座网
    private Integer type;
    //手机用户AppUser类
    private AppUser users;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public AppUser getUsers() {
        return users;
    }

    public void setUsers(AppUser users) {
        this.users = users;
    }
}