package com.shigu.exceptions;

import com.openJar.exceptions.OpenException;

/**
 * Created By admin on 2017/12/25/14:27
 */
public class XzUidToTokenException extends OpenException{

    public XzUidToTokenException() {
    }

    public XzUidToTokenException(String errMsg) {
        super.setErrMsg(errMsg);
    }

    public XzUidToTokenException(String code, String errMsg) {
        super.setCode(code);
        super.setErrMsg(errMsg);
    }
}
