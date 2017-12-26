package com.shigu.goodsup.jd.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 显示类异常
 * Created by zhaohongbo on 17/3/2.
 */
public class JdNotBindException extends Main4Exception{
    public JdNotBindException() {
    }

    public JdNotBindException(String message) {
        super(message);
    }
}
