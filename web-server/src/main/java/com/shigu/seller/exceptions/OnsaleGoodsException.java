package com.shigu.seller.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 出售中的商品异常
 * Created by zhaohongbo on 17/3/9.
 */
public class OnsaleGoodsException extends Main4Exception{

    public OnsaleGoodsException() {
    }

    public OnsaleGoodsException(String message) {
        super(message);
    }
}
