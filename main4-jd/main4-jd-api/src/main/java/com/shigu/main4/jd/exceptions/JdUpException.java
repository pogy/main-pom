package com.shigu.main4.jd.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created By admin on 2017/12/11/16:48
 */
public class JdUpException extends Main4Exception {
    private String errorCode;
    private String errorMsg;

    public JdUpException() {
    }

    public JdUpException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public JdUpException(String errorCode, String errorMsg) {
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
