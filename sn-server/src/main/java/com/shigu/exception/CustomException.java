package com.shigu.exception;


public class CustomException extends Exception{
    public CustomException(String msg){
        super(msg,null,false,false);
    }
}
