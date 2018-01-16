package com.openJar.exceptions.imgs;

import com.openJar.exceptions.OpenException;

import java.io.Serializable;

/**
 * Created By admin on 2017/12/22/14:19
 */
public class JdApiException extends OpenException implements Serializable {
    public JdApiException() {
    }

    public JdApiException(String errMdg) {
        super.setErrMsg(errMdg);
    }

    public JdApiException(String errCode, String errMdg) {
        super.setErrMsg(errMdg);
        super.setCode(errCode);
    }
}
