package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 支付流程异常
 * Created by bugzy on 2017/6/14 0014.
 */
public class PayerException extends Main4Exception {
    public PayerException() {
    }

    public PayerException(String message) {
        super(message);
    }
}
