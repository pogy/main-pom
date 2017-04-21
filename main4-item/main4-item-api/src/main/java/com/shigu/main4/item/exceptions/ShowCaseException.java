package com.shigu.main4.item.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 查推荐时的异常
 * Created by zhaohongbo on 17/3/9.
 */
public class ShowCaseException extends Main4Exception{
    private static final long serialVersionUID = -5893749523390296111L;

    public ShowCaseException() {
    }

    public ShowCaseException(String message) {
        super(message);
    }
}
