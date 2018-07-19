package com.shigu.exception;

import com.shigu.main4.common.exceptions.Main4Exception;

public class SnAuthfailExceptin extends Main4Exception{
    public SnAuthfailExceptin(){

    }

    public SnAuthfailExceptin(String errmsg){
        super(errmsg);
    }
}
