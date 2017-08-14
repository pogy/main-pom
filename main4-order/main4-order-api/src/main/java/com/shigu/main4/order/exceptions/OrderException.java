package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 订单异常
 * Created by bugzy on 2017/7/14 0014.
 */
public class OrderException extends Main4Exception {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
