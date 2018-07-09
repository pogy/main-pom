package com.shigu.main4.common.util;

import org.apache.commons.lang3.StringUtils;

public class MiUtil {
    private final static String TMP_CHARS ="0,1,2,3,4,5,6,7,8,9,-, ,+";

    public static boolean isPhone(String phone){
        if(StringUtils.isBlank(phone)){
            return false;
        }
        for(char c:phone.toCharArray()){
            if(!TMP_CHARS .contains(c+"")){
                return false;
            }
        }
        return true;
    }


    public static String toMi(String str){
        if(StringUtils.isBlank(str)){
            return "***";
        }
        if(str.length()>1){
            return str.substring(0,1)+"***"+str.substring(str.length()-1,str.length());
        }else{
            return str.substring(0,1)+"***";
        }
    }
    public static String toPhoneMi(String phone){
        if(phone==null||phone.length()<7){
            return "***";
        }
        if(phone.length()>1){
            return phone.substring(0,3)+"***"+phone.substring(phone.length()-4,phone.length());
        }else{
            return phone.substring(0,3)+"***";
        }
    }
}
