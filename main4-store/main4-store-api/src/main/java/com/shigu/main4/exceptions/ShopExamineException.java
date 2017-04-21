package com.shigu.main4.exceptions;

/**
 * 店铺审核异常
 * Created by Licca on 17/2/21.
 */
public class ShopExamineException extends StoreException{
    public ShopExamineException() {
    }

    public ShopExamineException(String message) {
        super(message);
    }
}
