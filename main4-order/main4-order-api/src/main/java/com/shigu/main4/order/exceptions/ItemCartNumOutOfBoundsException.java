package com.shigu.main4.order.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by Admin on 2017/6/20.
 */
public class ItemCartNumOutOfBoundsException extends Main4Exception{

    public ItemCartNumOutOfBoundsException(){}

    public ItemCartNumOutOfBoundsException(String message){
        super(message);
    }
}
