package com.shigu.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转化工具
 * Created by zhaohongbo on 17/3/1.
 */
public class DateParseUtil {

    /**
     * 日期转化
     * @param format 格式
     * @param d 时间
     * @return
     */
    public static String parseDate(String format,Date d){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(d);
    }

    /**
     * 字符转日期
     * @param format
     * @param day
     * @return
     */
    public static Date parseFromString(String format,String day){
        if(day==null){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try {
            return sdf.parse(day);
        } catch (ParseException e) {
            return null;
        }
    }
}
