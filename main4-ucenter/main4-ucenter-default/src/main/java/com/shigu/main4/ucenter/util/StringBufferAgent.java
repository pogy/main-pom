package com.shigu.main4.ucenter.util;

public class StringBufferAgent {

    private StringBuffer buff;
    public StringBufferAgent(){
        buff=new StringBuffer();
    }

    public StringBufferAgent append(Object str){
        if(str==null||"null".equals(str)){
            str="";
        }
        buff.append(str);
        return this;
    }

    @Override
    public String toString(){
        return buff.toString();
    }
}
