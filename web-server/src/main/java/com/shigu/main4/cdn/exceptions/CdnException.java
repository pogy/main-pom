package com.shigu.main4.cdn.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 显示类异常
 * Created by zhaohongbo on 17/3/2.
 */
public class CdnException extends Main4Exception{
    public CdnException() {
    }

    public CdnException(String message) {
        super(message);
    }
}
