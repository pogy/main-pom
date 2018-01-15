package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.UpToWxResponse;
import com.openJar.responses.app.WxLoginResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名：WxLoginRequest
 * 类路径：com.openJar.requests.app.WxLoginRequest
 * 创建者：任真飞
 * 创建时间：2017-11-15 14:29
 * 项目：main-pom
 * 描述：
 */
public class WxLoginRequest extends Request<WxLoginResponse> {
    //普通用户昵称
    @NotNull(message = "nickname is null")
    private String nickname;
    //用户统一标识
    @NotNull(message = "unionid is null")
    private String unionid;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String testApiUrl(){
        return HostEnum.TEST+"wxLogin.json";
    }

    public String restApiUrl(){
        return HostEnum.REST+"wxLogin.json";
    }
}