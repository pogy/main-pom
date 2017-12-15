package com.shigu.main4.jd.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created By admin on 2017/12/11/16:48
 */
public class JdUpException extends Main4Exception {
    private String errorCode;
    public JdUpException() {
    }

    public JdUpException(String message) {
        super(message);
    }

    public JdUpException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
