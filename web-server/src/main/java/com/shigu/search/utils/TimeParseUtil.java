package com.shigu.search.utils;

import java.util.Date;

public class TimeParseUtil {
    /**
     * 时间转化
     * @param t
     * @return
     */
    public static String timeParse(Date t){
        Long time=System.currentTimeMillis();
        Long tt=t.getTime();
        long jiange=300000;//5分钟
        long cha=(time-tt)/jiange;//多少个5分钟
        if(cha==0){
            return "刚刚";
        }
        if(cha>=12){
            return cha/12+"小时前";
        }else{
            return cha*5+"分钟前";
        }
    }
}
