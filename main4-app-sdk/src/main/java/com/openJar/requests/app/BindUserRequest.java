package com.openJar.requests.app;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.BindUserResponse;

/**
 * 类名：BindUserRequest
 * 类路径：com.openJar.requests.app.BindUserRequest
 * 创建者：王浩翔
 * 创建时间：2017-08-29 13:34
 * 项目：main-pom
 * 描述：app端用户绑定手机请求
 */
public class BindUserRequest extends Request<BindUserResponse>{
    //todo
    //用户绑定手机url
    private final String url = "xxxx.json";
    //临时ID，第三方登陆以后能过链接返回 必须
    private String tempId;
    //手机号 必须
    private String telephone;
    //验证码 必须
    private String code;

    //app端/wap端标志
    private HostEnum host = HostEnum.APP_HOST;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setHost(HostEnum host) {
        this.host = host;
    }

    //todo
    @Override
    public String restApiUrl() {
        return host.getRestUrl() + url;
    }
    //todo
    @Override
    public String testApiUrl() {
        return host.getTestUrl() + url;
    }
}
