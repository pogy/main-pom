package com.shigu.main4.item.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * Created by zhaohongbo on 17/2/6.
 */
public class TimeUtil {
    /**
     * 取当前时间
     * @param formate
     * @return
     */
    public static String getNowTime(String formate){
        SimpleDateFormat sdf=new SimpleDateFormat(formate);
        return sdf.format(new Date());
    }

    /**
     * 按yyyy-MM-dd HH:mm:ss来创建时间
     * 存在 2016-6-10 1:1:1的情况
     * @param time
     * @return
     */
    public static Date createTimeByString(String time){
        return null;
    }
}
