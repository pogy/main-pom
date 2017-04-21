package com.shigu.tools;

/**
 * 取随机 数
 * Created by Licca on 17/2/28.
 */
public class RedomUtil {

    /**
     * 取N位随机数
     * @param num
     * @return
     */
    public static String redomNumber(int num){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<num;i++){
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }
}
