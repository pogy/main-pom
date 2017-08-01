package com.shigu.main4.item.exceptions;

/**
 * 同款检测异常类
 * Created by zhaohongbo on 16/1/26.
 */
public class SameItemException extends Exception{
    public SameItemException() {
        super();
    }

    public SameItemException(String message) {
        super(message);
    }
}
