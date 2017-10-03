package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.OneShopResponse;
import com.openJar.responses.app.OrtherLoginResponse;

/**
 * 类名：OrtherLoginRequest
 * 类路径：com.openJar.requests.app.OrtherLoginRequest
 * 创建者：任真飞
 * 创建时间：2017-10-01 15:10
 * 项目：main-pom
 * 描述：
 */
public class OrtherLoginRequest extends Request<OrtherLoginResponse> {
    //1:淘宝,2:微信
    private Integer type;
    //淘宝必须传入,授权返回的nick
    private String nick;
    //微信必须传入,授权返回的参数唯一标识
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public String getNick() {
        return nick;
    }

    public void setNick( String nick ) {
        this.nick = nick;
    }

    public String testApiUrl(){
        return HostEnum.TEST+"ortherLogin.json";
    }

    public String restApiUrl(){
        return HostEnum.REST+"ortherLogin.json";
    }
}