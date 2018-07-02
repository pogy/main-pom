package com.shigu.goodsup.pinduoduo.exceptions;

/**
 * Created by gtx on 2018/6/18.
 *
 * @author gtx
 * @since
 */
public class CustomException extends Exception{
    public CustomException(String msg){
        super(msg,null,false,false);
    }
}