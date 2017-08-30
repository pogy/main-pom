package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 退款异常
 * Created by bugzy on 2017/6/16 0016.
 */
public class RefundException extends Main4Exception {
    public RefundException() {
    }

    public RefundException(String message) {
        super(message);
    }
}
