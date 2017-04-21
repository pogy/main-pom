package com.shigu.main4.exceptions;

/**
 * 店铺装修操作异常
 * Created by zhaohongbo on 17/2/25.
 */
public class ShopFitmentException extends StoreException{
    private static final long serialVersionUID = -2989055687988136568L;

    public ShopFitmentException() {
    }

    public ShopFitmentException(String message){
        super(message);
    }

}
