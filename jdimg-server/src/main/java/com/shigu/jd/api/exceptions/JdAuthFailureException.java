package com.shigu.jd.api.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created By admin on 2017/12/11/16:48
 * 授权失效异常
 */
public class JdAuthFailureException extends Main4Exception {

    public JdAuthFailureException() {
    }

    public JdAuthFailureException(String errorMsg) {
        super(errorMsg);
    }


}
