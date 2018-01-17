package com.shigu.exceptions;


public class CustomException extends Exception{
    public CustomException(String msg){
        super(msg,null,false,false);
    }
}
