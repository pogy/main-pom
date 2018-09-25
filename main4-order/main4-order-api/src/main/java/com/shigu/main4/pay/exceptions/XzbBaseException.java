package com.shigu.main4.pay.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * 类名：XzbBaseException
 * 类路径： com.shigu.main4.pay.exceptions.XzbBaseException
 * 创建者： whx
 * 创建时间： 8/8/18 3:58 PM
 * 项目： main-pom
 * 描述： 支付统一异常
 */
public class XzbBaseException extends OpenException {
    private static final long serialVersionUID = 6086310317589930448L;

    private String code;
    private String msg;

    public XzbBaseException() {
    }

    public XzbBaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public XzbBaseException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
