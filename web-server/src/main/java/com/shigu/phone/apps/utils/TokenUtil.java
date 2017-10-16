package com.shigu.phone.apps.utils;

import com.utils.publics.Opt3Des;

import java.util.Date;

public class TokenUtil {
    public static String parse(String token){
        token=token.replace(" ", "+");
        return Opt3Des.decryptPlainData(token);
    }

    public static String format(Long userId){
        Long time=new Date().getTime();
        String str=time+","+userId;
        return Opt3Des.encryptPlainData(str);
    }
}
