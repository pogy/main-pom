package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by whx on 2017/6/20 0020.
 * 当前用户没有淘宝session
 */
public class NotFindSessionException extends Main4Exception {
    public NotFindSessionException() {
    }

    public NotFindSessionException(String message) {
        super(message);
    }
}
