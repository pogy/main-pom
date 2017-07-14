package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 进货车异常
 * Created by bugzy on 2017/7/14 0014.
 */
public class CartException extends Main4Exception {
    public CartException() {
    }

    public CartException(String message) {
        super(message);
    }
}
