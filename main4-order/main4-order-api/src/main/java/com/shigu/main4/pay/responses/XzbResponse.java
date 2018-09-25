package com.shigu.main4.pay.responses;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * 类名：XzbResponse
 * 类路径： com.shigu.main4.pay.responses.XzbResponse
 * 创建者： whx
 * 创建时间： 8/7/18 10:55 AM
 * 项目： main-pom
 * 描述：
 */
public class XzbResponse implements Serializable {

    private OpenException exception;

    private String body;

    private boolean success;

    public XzbResponse() {
    }

    public static XzbResponse simpleErrorResponse(Class<?> resC, Class<?> exC, String code, String codeMsg, String errMsg) throws InstantiationException, IllegalAccessException {
        XzbResponse res = (XzbResponse)resC.newInstance();
        OpenException ex = (OpenException)exC.newInstance();
        ex.setCode(code);
        ex.setErrCodeMsg(codeMsg);
        ex.setErrMsg(errMsg);
        res.setException(ex);
        res.setSuccess(false);
        return res;
    }

    public OpenException getException() {
        return exception;
    }

    public void setException(OpenException exception) {
        this.exception = exception;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
