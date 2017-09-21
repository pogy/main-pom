package com.openJar.responses.app;

import com.openJar.responses.Response;

/**
 * 类名：GetPhoneMsgResponse
 * 类路径：com.openJar.responses.app.GetPhoneMsgResponse
 * 创建者：任真飞
 * 创建时间：2017-09-21 15:11
 * 项目：main-pom
 * 描述：手机验证码返回
 */
public class GetPhoneMsgResponse extends Response {
    //手机验证码     必须
    private String msgCode;

    public void setMsgCode( String msgCode ) {
        this.msgCode = msgCode;
    }

    public String getMsgCode() {
        return msgCode;
    }
}