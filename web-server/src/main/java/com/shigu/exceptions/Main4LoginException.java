package com.shigu.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 登陆异常
 * Created by zhaohongbo on 17/3/19.
 */
public class Main4LoginException extends Main4Exception{

    public Main4LoginException() {
    }

    public Main4LoginException(String message) {
        super(message);
    }
}
