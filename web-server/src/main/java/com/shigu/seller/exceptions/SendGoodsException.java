package com.shigu.seller.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 发布宝贝异常
 * Created by zhaohongbo on 17/3/4.
 */
public class SendGoodsException extends Main4Exception{

    public SendGoodsException() {
    }

    public SendGoodsException(String message) {
        super(message);
    }
}
