package com.shigu.main4.common.util;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author zjb
 *
 */
@SuppressWarnings({"rawtypes","static-access","unchecked"})
public class DateUtil {

    public static final SimpleDateFormat DF_YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @param yyyy-MM-dd
     * @return
     */
    public static final String patternA = "yyyy-MM-dd";
    /**
     * @param yyyyMMdd
     * @return
     */
    public static final String patternB = "yyyyMMdd";
    /**
     * @param yyyy-MM-dd HH-mm-ss
     * @return
     */
    public static final String patternC = "yyyy-MM-dd HH-mm-ss";
    /**
     * @param yyyy:MM:dd HH:mm:ss
     * @return
     */
    public static final String patternD = "yyyy-MM-dd HH:mm:ss";
    /**
     * @param yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static final String patternE = "yyyy-MM-dd HH:mm";

    /**
     * @param yyyyMMddHHmmss
     * @return
     */
    public static final String patternF = "yyyyMMddHHmmss";

    /**
     * yyyy
     */
    public static final String patternY="yyyy";
    /**
     * yyyy年MM月dd日 下午hh:mm:ss
     */
    public static final String patternCH= "yyyy年MM月dd日 ahh:mm:ss";

    /**
     * @param yyyy-MM-dd HH:mm:ss
     */
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static int WEEK_RULE_CHINA = 1;

    public static int WEEK_RULE_FOREIGN = 2;

    private static Calendar calendar = Calendar.getInstance();

    /**
     * 格式化日期为yyyy-MM-dd
     * @param date
     * @return
     */
    public static String formateDate(Date date){
        return dateToString(date,patternA);
    }

    /**
     * 时间转换成格式化的字符串
     * Timestamp对象 转换成 指定的格式
     * @param date Timestamp
     * @param format String
     * @return String
     */
    public static String dateToString(Timestamp date, String format) {
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        Date utilDate = null;
        if (date == null) {
            //如果传入的对象为null,则使用当前的时间
            utilDate = new Date();
        }
        else {
            utilDate = new Date(date.getTime());
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(utilDate);
    }

    /**
     * 日期转化成字符串,格式化的
     * @param date Date
     * @param format String
     * @return String
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 日期转化成字符串,格式化的 ,扩展的能使用备用时间对象的
     * @param date Date
     * @param format String
     * @param defaultDate Date  备用Date对象
     * @return String
     */
    public static String dateToString(Date date, String format, Date defaultDate) {
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        if (date == null) {
            //如果备用Date对象为空,则使用当前时间,否则使用备用时间
            if (defaultDate == null) {
                date = new Date();
            }
            else {
                date = defaultDate;
            }
        }
        //format 有 yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 根据默认格式将字符串转换成时间对象(java.util.Dates)
     * @param str String
     * @return Date
     */
    public static Date stringToDate(String str) {
        if (str == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(
                DEFAULT_DATE_FORMAT);
        try {
            return sdf.parse(str);
        }
        catch (ParseException ex) {
            return null;
        }
    }

    /**
     * 根据参数格式将字符串转换成时间对象(java.util.Dates)
     * @param str String
     * @param format String(为空默认为 yyyy-MM-dd HH:mm:ss)
     * @return Date
     */
    public static Date stringToDate(String str, String format) {
        if (str == null) {
            return stringToDate(str);
        }
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(str);
        }
        catch (ParseException ex) {
//      log.error("Date stringToDate(" + str + ") 转换日志失败 " + ex.getMessage());
            return null;
        }

    }

    /**
     * 生成当天的年,月,日,时,分,秒的时间字符串
     * 格式为 20060511101925
     * @param format String
     * @return String
     */
    public static String getCurrentDate(String format) {
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        Date utilDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(utilDate);
    }

    /**
     * 获取几天前的日期,返回相符的格式
     * @param days int
     * @param format String
     * @return String
     */
    public static String getOldDateStr(int days, String format) {
        if (format == null) {
            format = DEFAULT_DATE_FORMAT;
        }
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_MONTH);
        //该对象变成n天前的日期对象
        cal.set(Calendar.DAY_OF_MONTH, today + days);
        return dateToString(cal.getTime(), format);
    }

    /**
     * 获取星期的列表
     * @param year int
     * @param month int
     * @return ArrayList
     */



    public static ArrayList getWeekListByMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();

        ArrayList list = new ArrayList();
        month--; //减一后是指定的月
        cal.set(year, month, 1, 0, 0); //指定某月1号

        //取出当天所在的星期
        int weekInt = cal.get(cal.DAY_OF_WEEK);
        if (weekInt == 1) {
            weekInt = 7;
        }
        weekInt--;
        //根据当天退后N天,一直退到星期一的那一天,从这一天开始计算星期
        cal.set(cal.DAY_OF_MONTH, cal.get(cal.DAY_OF_MONTH) - (weekInt - 1));
        String dateString = "";
        for (int i = 0; i < 5; i++) {
            dateString = getDay_Of_Week(cal); //取星期的第一天
            dateString += "~" + getLastDay_Of_Week(cal); //取星期的最后一天
            list.add(dateString);
            //下一天
            cal.set(cal.DAY_OF_MONTH, cal.get(cal.DAY_OF_MONTH) + 1);
        }
        return list;
    }

    /**
     * 返回星期的第一天 只被getWeekListByMonth使用
     * @param cal Calendar
     * @return String
     */
    private static String getDay_Of_Week(Calendar cal) {
        int fYear = cal.get(cal.YEAR);
        int fMonth = 1 + cal.get(cal.MONTH);
        int fDay = cal.get(cal.DAY_OF_MONTH);

        String zeroM = "";
        if (fMonth < 10) {
            zeroM = "0";
        }
        String zeroD = "";
        if (fDay < 10) {
            zeroD = "0";
        }

        return fYear + "-" + zeroM + fMonth + "-" + zeroD + fDay;
    }

    /**
     * 返回星期的最后一天 只被getWeekListByMonth使用
     * @param cal Calendar
     * @return String
     */
    private static String getLastDay_Of_Week(Calendar cal) {
        //星期一退后6天就是星期的最后一天
        cal.set(cal.DAY_OF_MONTH, cal.get(cal.DAY_OF_MONTH) + 6);
        return getDay_Of_Week(cal);
    }

    /**
     * 指到下一天
     */
    public static void nextDay() {
        calendar.set(calendar.DAY_OF_MONTH, getDay() + 1);
    }

    /**
     * 指到前一天
     */
    public static void previousDay() {
        calendar.set(calendar.DAY_OF_MONTH, getDay() - 1);
    }

    /**
     * 前进或后退几天
     * @param num int
     */
    public static void changeDay(int num) {
        calendar.set(calendar.DAY_OF_MONTH, getDay() + num);
    }

    /**
     * 获取日期
     * @return String
     */
    public static String getDate() {
        String zeroM = "";
        if (getMonth() < 10) {
            zeroM = "0";
        }
        String zeroD = "";
        if (getDay() < 10) {
            zeroD = "0";
        }
        int fYear = getYear();
        int fMonth = getMonth();
        int fDay = getDay();

        return fYear + "-" + zeroM + fMonth + "-" + zeroD + fDay;
    }

    /**
     * 返回星期的第一天
     * @return String
     */

    public static String getFirstDayOfWeek() {
        Calendar fristCal = Calendar.getInstance();
        //取今天是星期几
        int weekInt = fristCal.get(Calendar.DAY_OF_WEEK);
        if (weekInt == 1) {
            weekInt = 7;
        }
        weekInt--;

        //根据星期几来确定向后退几天
        fristCal.set(calendar.DAY_OF_MONTH,
                fristCal.get(Calendar.DAY_OF_MONTH) - (weekInt - 1));

        //取出年月日,
        int fYear = fristCal.get(Calendar.YEAR);
        int fMonth = (1 + fristCal.get(Calendar.MONTH));
        int fDay = fristCal.get(Calendar.DAY_OF_MONTH);

        String zeroM = "";
        if (fMonth < 10) {
            zeroM = "0";
        }
        String zeroD = "";
        if (fDay < 10) {
            zeroD = "0";
        }
        return fYear + "-" + zeroM + fMonth + "-" + zeroD + fDay;

    }

    /**
     * 返回星期的最后一天
     * @return String
     */

    public static String getLastDayOfWeek() {
        Calendar lastCal = Calendar.getInstance();
        //取今天是星期几
        int weekInt = lastCal.get(Calendar.DAY_OF_WEEK);
        if (weekInt == 1) {
            weekInt = 7;
        }
        weekInt--;
        //根据今天是星期几来确定向前进几天
        lastCal.set(calendar.DAY_OF_MONTH,
                lastCal.get(Calendar.DAY_OF_MONTH) + (7 - weekInt));

        int fYear = lastCal.get(Calendar.YEAR);
        int fMonth = (1 + lastCal.get(Calendar.MONTH));
        int fDay = lastCal.get(Calendar.DAY_OF_MONTH);

        String zeroM = "";
        if (fMonth < 10) {
            zeroM = "0";
        }
        String zeroD = "";
        if (fDay < 10) {
            zeroD = "0";
        }

        return fYear + "-" + zeroM + fMonth + "-" + zeroD + fDay;
    }

    /**
     * 按中国的方式取当天是星期几
     * @return int
     */
    public static int getWeekByChina() {
        int x = calendar.get(calendar.DAY_OF_WEEK);
        if (x == 1) {
            x = 7;
        }
        return x - 1;
    }

    /**
     * 按国外的方式取当天是星期几
     * @return int
     */

    public static int getWeekByForeign() {
        int x = calendar.get(calendar.DAY_OF_WEEK);
        return x;
    }

    /**
     * 将星期转换成汉字
     * @param weekInt int
     * @return String
     */
    public static String getWeekInt2Hz(int weekInt, int rule) {
        if (rule != WEEK_RULE_CHINA && rule != WEEK_RULE_FOREIGN) {
            rule = WEEK_RULE_CHINA;
        }
        String hzWeek = null;
        switch (weekInt) {
            case 1:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期一" : "星期日");
                break;
            case 2:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期二" : "星期一");
                break;
            case 3:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期三" : "星期二");
                break;
            case 4:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期四" : "星期三");
                break;
            case 5:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期五" : "星期四");
                break;
            case 6:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期六" : "星期五");
                break;
            case 7:
                hzWeek = (rule == WEEK_RULE_CHINA ? "星期日" : "星期六");
                break;
            default:
                hzWeek = "";
        }
        ;
        return hzWeek;
    }

    /**
     * 取当前天
     * @return int
     */
    public static int getDay() {
        return calendar.get(calendar.DAY_OF_MONTH);
    }

    /**
     * 取当前月
     * @return int
     */
    public static int getMonth() {
        return (1 + calendar.get(calendar.MONTH));
    }

    /**
     * 取当前年
     * @return int
     */
    public static int getYear() {
        return calendar.get(calendar.YEAR);
    }

    /**
     * 检测参数年的值是否是闰年
     * @param year int
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        if ( (year % 4 == 0 && year % 400 != 0) || year % 400 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 此年,此月一共有多少天
     * @param year int
     * @param month int
     * @return int
     */
    public static int days(int year, int month) {
        int returndays = 30;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
                month == 10 || month == 12) {
            returndays = 31;
        }
        else {
            if (month == 2) {
                if (isLeapYear(year)) {
                    returndays = 29;
                }
                else {
                    returndays = 28;
                }
            }
        }
        return returndays;
    }

    /**
     * 增加月份
     * @param addMonth
     * @param date 要转化的时间，如果没有，则默认为当前时间．用"yyyy-MMd-dd
     * 调用方法
     * add_months(1)
     * add_months(1,"2006-12-31")
     * "格式的字符串来表示日期
     * @return
     */
    public static String add_months(int addMonth, String... date) {
        String resultDate;
        SimpleDateFormat from_sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();;
        if(date != null && date.length > 0 && date[0]!=null){
            try {
                Date tempDate = from_sdf.parse(date[0]);
                cal.setTime(tempDate);
            } catch (ParseException e) {
            }
        }

        cal.add(Calendar.MONTH, addMonth);
        resultDate = from_sdf.format(cal.getTime());
        return resultDate;
    }

    /**
     * 增加日期天数
     * @param day
     * @return
     */
    public static String add_days(int day, String... date) {
        String resultDate;
        SimpleDateFormat from_sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();;
        if(date != null && date.length > 0 && date[0]!=null){
            try {
                Date tempDate = from_sdf.parse(date[0]);
                cal.setTime(tempDate);
            } catch (ParseException e) {
            }
        }

        cal.add(Calendar.DAY_OF_YEAR, day);
        resultDate = from_sdf.format(cal.getTime());
        return resultDate;
    }

    /**
     * 增加日期分钟
     * @param min
     * @return
     */
    public static String addMin(int min, String date2) {
        String resultDate;
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(DateUtil.getCurrentDate(null));
            if(date2!=null&&date2.length()>0){
                date=format.parse(date2);
            }

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MINUTE, min);

            String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c
                    .getTime());
            return s;
        }catch(ParseException ex){
            ex.printStackTrace();
            //System.out.println("Parse DATE String ERROR!"+ex.getMessage());
        }
        return date2;
    }

    /**
     * 增加日期小时
     * @param hour
     * @return
     */
    public static String addHour(int hour, String date2) {
        String resultDate;
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(DateUtil.getCurrentDate(null));
            if(date2!=null&&date2.length()>0){
                date=format.parse(date2);
            }

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.HOUR_OF_DAY, hour);

            String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c
                    .getTime());
            return s;
        }catch(ParseException ex){
            ex.printStackTrace();
            //System.out.println("Parse DATE String ERROR!"+ex.getMessage());
        }
        return date2;
    }

    /**
     * 比较两个日期大小
     * 日期格式“YYYY-MM-DD hh:mm:ss”
     * @return long 秒级差
     */

    public static  long minusDate(String date1,String date2) {

        if(null==date1 || null==date2 ||date1.length()==0||date2.length()==0)
            return 99999999;
        if(date1.length()==10)date1+=" 00:00:00";
        if(date2.length()==10)date2+=" 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l1 = 0;
        long l2 = 0;
        try{
            l1 = sdf.parse(date1).getTime();
            l2 = sdf.parse(date2).getTime();
        }catch(ParseException ex){
            ex.printStackTrace();
            //System.out.println("Parse DATE String ERROR!"+ex.getMessage());
        }

        return (l2-l1)/1000;
    }

    /**
     * 得到这个月的第几天日期
     * @param day 这个月的第几天,如第一天,则为1
     * @return
     */
    public static String getDayOfMonth(int day, String... date) {
        String resultDate;
        SimpleDateFormat from_sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();;
        if(date != null && date.length > 0 && date[0]!=null){
            try {
                Date tempDate = from_sdf.parse(date[0]);
                cal.setTime(tempDate);
            } catch (ParseException e) {
            }
        }

        cal.set(Calendar.DAY_OF_MONTH, day);
        resultDate = from_sdf.format(cal.getTime());
        return resultDate;
    }

    /**
     * 将日期转换为中文大写 如 2011-12-12转为 二〇一一年一十二月一十二日
     *
     * @return
     */
    public static String getDateForChina( String date) {
        if(date==null||date.length()==0)return "";
        String str="";
        String[] dateStr=new String[]{"〇","一","二","三","四","五","六","七","八","九","十","十一","十二","十三","十四","十五","十六","十七","十八","十九","二十","二十一","二十二","二十三","二十四","二十五","二十六","二十七","二十八","二十九","三十","三十一"};
        String year=date.substring(0,4);
        //转换年份
        year=dateStr[Integer.valueOf(year.substring(0,1))]+dateStr[Integer.valueOf(year.substring(1,2))]+dateStr[Integer.valueOf(year.substring(2,3))]+dateStr[Integer.valueOf(year.substring(3))];
        str=year+"年";
        if(date.length()<=5)return str;

        //转换月份
        String month=date.substring(5,7);
        str+=dateStr[Integer.valueOf(month)]+"月";
        if(date.length()<=8)return str;

        //转换天
        String day=date.substring(8);
        str+=dateStr[Integer.valueOf(day)]+"日";

        return str;
    }


    /**
     * 给date日期添加或者减去 天数
     * @Date 2014年5月12日 下午5:07:30
     * @param date 日期
     * @param day  要添加的天数或者减去的天数
     * @return  修改后的时间
     */
    public static Date addDay(Date date,int day){
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date addMonth(Date date,int month){
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 获取当前Time Long
     * @return
     */
    public static String getNowTimeLong(){
        Date date=new Date();
        Timestamp timeStamp=new Timestamp(date.getTime());
        return String.valueOf(timeStamp.getTime());
    }

    /**
     * 两个时间相比比较相差的天数
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {

//        Calendar aCalendar = Calendar.getInstance();
//
//        aCalendar.setTime(fDate);
//
//        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
//
//        aCalendar.setTime(oDate);
//
//        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
//
//        return day2 - day1;
        return new Long(ChronoUnit.DAYS.between(fDate.toInstant(), oDate.toInstant())).intValue();

    }

    /**
     * 当天0点
     *
     * @return
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 指定日期0点
     *
     * @param theDay
     * @return
     */
    public static Date getIsStartTime(Date theDay) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(theDay);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 当天23:59:59
     *
     * @return
     */
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 指定日期23:59:59
     *
     * @param theDay
     * @return
     */
    public static Date getIsEndTime(Date theDay) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(theDay);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
    /**
     * 获取距离今天i天的时间
     * @param i
     * @return
     */
    public static Date getdate(int i){
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, i);
        return cd.getTime();
    }
    public static Date getdate(Date d,int i){
        Calendar cd = Calendar.getInstance();
        cd.setTime(d);
        cd.add(Calendar.DATE, i);
        return cd.getTime();
    }

    /**
     * 获取当前月的第一天
     * @return
     */
    public static Date getStartMouth(){
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }


    public static Date addYearV1_8(int addYear){
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime localDateTime2;
        if(addYear>0){
            localDateTime2 = ldt.plusYears(addYear);
        }else{
            localDateTime2 = ldt.minusYears(-addYear);
        }
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime z=localDateTime2.atZone(zone);
        return Date.from(z.toInstant());
    }
    public static Date addMonthV1_8(int addMonth){
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime localDateTime2;
        if(addMonth>0){
            localDateTime2 = ldt.plusMonths(addMonth);
        }else{
            localDateTime2 = ldt.minusMonths(-addMonth);
        }
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime  z=localDateTime2.atZone(zone);
        return Date.from(z.toInstant());
    }

    public static Date addDayV1_8(int addDay){
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime localDateTime2;
        if(addDay>0){
            localDateTime2 = ldt.plusDays(addDay);
        }else{
            localDateTime2 = ldt.minusDays(-addDay);
        }
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime  z=localDateTime2.atZone(zone);
        return Date.from(z.toInstant());
    }
}
