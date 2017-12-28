package com.shigu.main4.jd.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created By admin on 2017/12/11/16:48
 * 授权失效异常
 */
public class JdAuthFailureException extends Main4Exception {
    private String errorCode;
    private String errorMsg;

    public JdAuthFailureException() {
    }

    public JdAuthFailureException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public JdAuthFailureException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
