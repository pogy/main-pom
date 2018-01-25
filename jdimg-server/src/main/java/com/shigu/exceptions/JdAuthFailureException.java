package com.shigu.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * Created By admin on 2017/12/11/16:48
 * 授权失效异常
 */
public class JdAuthFailureException extends OpenException {

    public JdAuthFailureException() {
    }

    public JdAuthFailureException(String errorMsg) {
        super.setErrMsg(errorMsg);
    }

    public JdAuthFailureException(String errorCode, String errorMsg) {
        super.setCode(errorCode);
        super.setErrMsg(errorMsg);
    }


}
