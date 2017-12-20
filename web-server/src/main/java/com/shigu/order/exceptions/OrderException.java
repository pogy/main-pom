package com.shigu.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 订单类异常
 * Created by zlm on 17/6/30
 */
public class OrderException extends Main4Exception {
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
