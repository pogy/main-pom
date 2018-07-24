package com.shigu.main4.item.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 商品不存在
 */
public class ItemNotFundException extends Main4Exception{
    public ItemNotFundException(String message) {
        super(message);
    }
}
