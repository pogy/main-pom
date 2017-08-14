package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by whx on 2017/6/20 0020.
 */
public class BuyerAddressException extends Main4Exception {
    public BuyerAddressException() {
    }

    public BuyerAddressException(String message) {
        super(message);
    }
}
