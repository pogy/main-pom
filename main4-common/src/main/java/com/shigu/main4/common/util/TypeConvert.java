/*
 * Created on 2005-2-5
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.shigu.main4.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;
/**
*import net.sf.rain.util.DateUtils;
*/

/**
 * @author TGP 格式化数字、格式化日期、各种日期等工具 TODO To change the template for this
 *         generated type comment go to Window - Preferences - Java - Code Style -
 *         Code Templates
 */
public class TypeConvert {

    
    /**
     * 格式式数字，小数点位数为2
     * 
     * @param d--要格式化的数字
     * @return
     */
    public static String formatDouble(double d) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(d);
    }

    /**
     * 格式式数字，小数点位数为fractionDigits
     * 
     * @param d--要格式化的数字
     * @param fractionDigits--小数点位数
     * @return
     */
    public static String formatDouble(double d, int fractionDigits) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(fractionDigits);
        return df.format(d);
    }

    /**
     * 格式式数字
     * 
     * @param d--要格式化的数字
     * @param formatPattern--格式化模式(如####.00)
     * @return
     */
    public static String formatDouble(double d, String formatPattern) {
        DecimalFormat df = new DecimalFormat();
        if (formatPattern == null || formatPattern.equals("")) {
            df.applyPattern("0.##");
        } else {
            df.applyPattern(formatPattern);
        }
        return df.format(d);
    }

    /**
     * 格式化数字为百分数，小数点位数为2
     * 
     * @param d--要格式化的数字
     * @return
     */
    public static String formatBecomePercent(double d) {
        String s="";
        try{
            DecimalFormat df = (DecimalFormat)NumberFormat.getPercentInstance(Locale.getDefault());
            String pattern="#.00%";
            df.applyPattern(pattern);
            s = df.format(d);
          }catch(Exception e){
            e.printStackTrace();
          }  
        return s;
    }
    public static Object formatNumberToCurrentcy(double d){
        String currency_format="#,##0.000";
        int currency_scale=2;
        
//        DecimalFormat formater=new DecimalFormat(currency_format);
//        ParsePosition par=new ParsePosition(2);
//        Number number=formater.parse("3.38886",par);
        Currency currency=Currency.getInstance(Locale.CHINA);
        System.out.println(currency.getSymbol());
        try{ 
            DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance();
            nf.applyPattern("$#0.00#");
            String s = "";
            s = nf.format(d);
            System.out.println(s);
          }catch(Exception e){
            e.printStackTrace(); 
          } 
        return currency;
    }
    
    /**
     * 把字符串转换成数字类型（含小数的转换成Double类型，整数的转换成Long类型)
     * @param str
     * @return
     */
    public static Object stringParseNumber(String str){
        NumberFormat nf2 = NumberFormat.getInstance();
        Object obj2 = null; 
        try {
            obj2 = nf2.parse(str);
        }
        catch (ParseException e2) {
            System.err.println(e2);
        }
    	return obj2;
    }
    /**
     * 把字符串转换成Double类型
     * @param value
     * @return
     */
    public static Double stringParseDouble(String value){
        Object qty=stringParseNumber(value);
        if (qty instanceof Double)
            return (Double)qty;
        else { 
            return Double.valueOf(String.valueOf(qty));
        }
    }
    
    /**
     * 把字符串转换成Long类型
     * @param value
     * @return
     */
    public static Long stringParseLong(String value){
        Object qty=stringParseNumber(value);
        if (qty instanceof Long)
            return (Long)qty;
        else {  
            return new Long(Math.round(((Double)qty).doubleValue()));
        }
    }
    /**
     * 格式化日期，日期格式为:yyyy-MM-dd
     * 
     * @param date--要格式化的日期
     * @return
     */
    public static String formatDate(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    /**
     * 格式化时间：格式为：yyyy-MM-dd hh:mm:ss
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateTime(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
    /**
     * 格式化时间：格式为：输入的字符串格式yyyy-MM-dd hh:mm:ss
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateTime(Date date,String filter) {
        DateFormat sdf = new SimpleDateFormat(filter);
        return sdf.format(date);
    }
    /**
     * 格式化时间：格式为：yyyyMMdd
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateyyyyMMdd(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }
    /**
     * 格式化时间：格式为：yyyyMM
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateyyyyMM(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }
    /**
     * 格式化时间：格式为：yyyyMM
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateyyyymm(Date date) {
    	String dateStr="";
        try {
        	dateStr=formatDate(date,"yyyy-MM");
         
        } catch (Exception ex) {          
            ex.printStackTrace();
            return dateStr;
        } 
        return dateStr;
    }
    /**
     * 格式化时间：格式为：yyyyMMddHHmmss
     * @param date--要格式化的时间
     * @return
     */
    public static String formatDateyyyyMMddHHmmss(Date date) {
    	String dateStr="";
        try {
        	dateStr=formatDate(date,"yyyyMMddHHmmss");
         
        } catch (Exception ex) {          
            ex.printStackTrace();
            return dateStr;
        } 
        return dateStr;
    }
    
    /**
     * 格式化时间字符串：格式为：yyyy-MM-dd
     * @param date--要格式化的时间字符
     * @return
     */
    public static String formatDateTimeString(String dateStr) {
        if (dateStr==null || "".equals(dateStr.trim())) return dateStr;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            return sdf.format(date);
        } catch (ParseException ex) {          
            ex.printStackTrace();
            return dateStr;
        }  
    }
    /**
     * 格式化时间字符串：格式为：yyyy-MM-dd HH:mm:ss
     * @param date--要格式化的时间字符
     * @return
     */
    public static String formatDateTimehhmmssString(String dateStr) {
        if (dateStr==null || "".equals(dateStr.trim())) return dateStr;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
            return sdf.format(date);
        } catch (ParseException ex) {          
            ex.printStackTrace();
            return dateStr;
        }  
    }
   
    /**
     * 格式化日期
     * 
     * @param date--要格式化的日期
     * @param datePattern--日期格式化模式
     * @return
     */
    public static String formatDate(Date date, String datePattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        return sdf.format(date);
    }
    /**
     * 在现有日期上加上mm分钟
     * 
     * @param date--当前日期
     * @param days--增加或减少的mm分钟(正数表示增加mm分钟，负数表示减少mm分钟)
     * @return 新的日期
     */
    public static Date dateAddminute(Date date, int mm) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.MINUTE, mm);
        return greDate.getTime();
    }
    /**
     * 在现有日期上加上days天
     * 
     * @param date--当前日期
     * @param days--增加或减少的天数(正数表示增加天数，负数表示减少天数)
     * @return 新的日期
     */
    public static Date dateAddDays(Date date, int days) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.DATE, days);
        return greDate.getTime();
    }

    /**
     * 在现有日期上加上days天,现有日期也随之变化
     * 
     * @param date--当前日期
     * @param days--增加或减少的天数(正数表示增加天数，负数表示减少天数)
     */
    public static void dateAddDay(Date date, int days) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.DATE, days);
        date.setTime(greDate.getTime().getTime());
    }

    /**
     * 在现有日期上加上months个月
     * 
     * @param date--当前日期
     * @param months--增加或减少的月数(正数表示增加月数，负数表示减少月数)
     * @return 新的日期
     */
    public static Date dateAddMonths(Date date, int months) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
       // greDate.add(Calendar.MINUTE, arg1)
        greDate.add(Calendar.MONTH, months);
        return greDate.getTime();
    }

    /**
     * 在现有日期上加上months个月,现有日期也随之变化
     * 
     * @param date--当前日期
     * @param months--增加或减少的月数(正数表示增加月数，负数表示减少月数)
     */
    public static void dateAddMonth(Date date, int months) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.MONTH, months);
        date.setTime(greDate.getTime().getTime());
    }

    /**
     * 在现有日期上加上years年
     * 
     * @param date--当前日期
     * @param years--增加或减少的年数(正数表示增加年数，负数表示减少年数)
     * @return 新的日期
     */
    public static Date dateAddyears(Date date, int years) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.YEAR, years);
        return greDate.getTime();
    }

    /**
     * 在现有日期上加上years年,现有日期也随之变化
     * 
     * @param date--当前日期
     * @param years--增加或减少的年数(正数表示增加年数，负数表示减少年数)
     * @return 新的日期
     */
    public static void dateAddyear(Date date, int years) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        greDate.add(Calendar.YEAR, years);
        date.setTime(greDate.getTime().getTime());
    }

    /**
     * 取得日期的天数值
     * 
     * @param date
     * @return
     */
    public static int getDateOfDay(Date date) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        return greDate.get(Calendar.DATE);
    }

    /**
     * 取得日期的月份
     * 
     * @param date
     * @return
     */
    public static int getDateOfMonth(Date date) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        return greDate.get(Calendar.MONDAY) + 1;
    }

    /**
     * 取得日期的年份
     * 
     * @param date
     * @return
     */
    public static int getDateOfYear(Date date) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        return greDate.get(Calendar.YEAR);
    }

    /**
     * 得到日期是星期几
     * 
     * @param date
     * @return
     */
    public static int getDateOfWeekDay(Date date) {
        Calendar greDate = Calendar.getInstance();
        greDate.setTime(date);
        int weekDay = greDate.get(Calendar.DAY_OF_WEEK);
        weekDay = (weekDay == 1 ? 7 : weekDay - 1);
        return weekDay;
    }

    /**
     * 设置日期
     * 
     * @param year--年
     * @param month--月
     * @param day--日
     * @return 返回日期
     */
    public static Date setDate(int year, int month, int day) {
        Calendar greDate = Calendar.getInstance();
        greDate.set(year, month - 1, day);
        return greDate.getTime();
    }

    /**
     * 取得当前日期所在的年初，年末日期
     * 
     * @param date--当前日期
     * @param yearStartDate--年初
     * @param yearEndDate--年末
     */
    public static void getYearScope(Date date, Date yearStartDate,
            Date yearEndDate) {
        int year = getDateOfYear(date);
        getYearScope(year, yearStartDate, yearEndDate);
    }

    /**
     * 取得当前年份所在的年初，年末日期
     * 
     * @param year--当前年份
     * @param yearStartDate--年初
     * @param yearEndDate--年末
     */
    public static void getYearScope(int year, Date yearStartDate,
            Date yearEndDate) {
        Date date1 = setDate(year, 1, 1);
        yearStartDate.setTime(date1.getTime());
        Date date2 = setDate(year + 1, 1, 1);
        Date date3 = dateAddDays(date2, -1);
        yearEndDate.setTime(date3.getTime());
    }

    /**
     * 取得当前日期所在的月初，月末日期
     * 
     * @param date--当前日期
     * @param monthStartDate--月初
     * @param monthEndDate--月末
     */
    public static void getMonthScope(Date date, Date monthStartDate,
            Date monthEndDate) {
        int year = getDateOfYear(date);
        int month = getDateOfMonth(date);
        getMonthScope(year, month, monthStartDate, monthEndDate);
    }

    /**
     * 给出年、月份，求月初，月末日期
     * 
     * @param year-年
     * @param month-月
     * @param monthStartDate--月初
     * @param monthEndDate--月末
     */
    public static void getMonthScope(int year, int month, Date monthStartDate,
            Date monthEndDate) {
        Date date1 = setDate(year, month, 1);
        monthStartDate.setTime(date1.getTime());
        Date date2 = dateAddMonths(date1, 1);
        Date date3 = dateAddDays(date2, -1);
        monthEndDate.setTime(date3.getTime());
    }

    /**
     * 取得当前日期所在半年度初、半年度末日期
     * 
     * @param date--当前日期
     * @param halfYearStartDate--半年度初
     * @param halfYearEndDate--半年度末
     */
    public static void getHalfYearScope(Date date, Date halfYearStartDate,
            Date halfYearEndDate) {
        int year = getDateOfYear(date);
        int month = getDateOfMonth(date);
        int halfYearKind = 1;
        if (month >= 1 && month <= 6) {
            halfYearKind = 1;
        } else {
            halfYearKind = 2;
        }
        getHalfYearScope(year, halfYearKind, halfYearStartDate, halfYearEndDate);
    }

    /**
     * 根据年份、半年度类型求出所在半年度初、半年度末日期
     * 
     * @param year--年度
     * @param halfYearKind--1表示上半年，2表示下半年
     * @param halfYearStartDate--半年度初
     * @param halfYearEndDate--半年度末
     */
    public static void getHalfYearScope(int year, int halfYearKind,
            Date halfYearStartDate, Date halfYearEndDate) {
        Date date1 = null;
        if (halfYearKind == 1) {
            date1 = setDate(year, 1, 1);
        } else {
            date1 = setDate(year, 7, 1);
        }
        halfYearStartDate.setTime(date1.getTime());
        Date date2 = dateAddMonths(date1, 6);
        Date date3 = dateAddDays(date2, -1);
        halfYearEndDate.setTime(date3.getTime());
    }

    /**
     * 取得当前日期所在季度初、季度末日期
     * 
     * @param date--当前日期
     * @param quarterStartDate--季度初
     * @param quarterEndDate--季度末
     */
    public static void getQuarterScope(Date date, Date quarterStartDate,
            Date quarterEndDate) {
        int year = getDateOfYear(date);
        int month = getDateOfMonth(date);
        int quarter = (int) Math.ceil(month / 3.0);
        getQuarterScope(year, quarter, quarterStartDate, quarterEndDate);
    }

    public static void getQuarterScope(int year, int quarter,
            Date quarterStartDate, Date quarterEndDate) {
        Date date1 = null;
        switch (quarter) {
        case 1:
            date1 = setDate(year, 1, 1);
            break;//第一季度
        case 2:
            date1 = setDate(year, 4, 1);
            break;//第二季度
        case 3:
            date1 = setDate(year, 7, 1);
            break;//第三季度
        default:
            date1 = setDate(year, 10, 1);
            break;//第四季度
        }
        quarterStartDate.setTime(date1.getTime());
        Date date2 = dateAddMonths(date1, 3);
        Date date3 = dateAddDays(date2, -1);
        quarterEndDate.setTime(date3.getTime());
    }
    /**
     * 
     *=========================================================
     *@时间：2014-6-12下午5:39:19
     *@方法名：getDateStratTime
     *@功能： 一天的开始时间
     *@param d
     *@return:Date<br>
     *@since:
     *=========================================================
     */
    public static Date getDateStratTime(Date d){
    	
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(d);
    	cal.set(cal.HOUR_OF_DAY, 0);
    	cal.set(cal.MINUTE, 0);
    	cal.set(cal.SECOND, 0);
    	//cal.set(Calendar.DATE, 1);
    	return cal.getTime();
    }
    /**
     * 
     *=========================================================
     *@时间：2014-6-12下午5:39:34
     *@方法名：getDateEndTime
     *@功能： 一天的结束时间
     *@param d
     *@return:Date<br>
     *@since:
     *=========================================================
     */
    public static Date getDateEndTime(Date d){
    	
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(d);
    	cal.set(cal.HOUR_OF_DAY, 23);
    	cal.set(cal.MINUTE, 59);
    	cal.set(cal.SECOND, 59);
    	//cal.set(Calendar.DATE, 1);
    	return cal.getTime();
    }
    /**
     * 把字符串转化成日期(格式为：yyyy-MM-dd)
     * 
     * @param param--要转换的字符串
     * @return 返回日期
     */
    public static Date parseStringToDate(String param) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(param);
        } catch (ParseException ex) {
        }
        return date;
    }
    /**
     * 把字符串转化成日期(格式为：pattern)
     * @param param--字符串
     * @param pattern--转换格式
     * @return
     */
    public static Date parseStringToDate(String param,String pattern) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(param);
        } catch (ParseException ex) {
        }
        return date;
    }
    /**
     * 两日期相关天数
     * 有错
     * @param startDate
     * @param endDate
     * @return
     */
    public static long twoDateIntervalDays(Date startDate,Date endDate){
        long lg=endDate.getTime()-startDate.getTime();
        return Math.round(lg/(24*60*60*1000));
    }
    
    public static String OtherDataTypeToString(Object obj){
        if (obj==null ) return "";
        if (obj.getClass()==Date.class || obj.getClass()==Timestamp.class){
          //  return DateUtils.format((Date)obj);
            return obj.toString();//要用上面的
        }else if (obj.getClass()==Double.class){
            DecimalFormat dfts=new DecimalFormat("0.###");                   
            return dfts.format(((Double)obj).doubleValue());
        }else {
            return obj.toString();
        }
    }
    /**
	 * 把字符串中某个字符改为大写
	 * @param str
	 * @param charNum
	 * @return
	 */
	public String changeStringOfCharUppCase(String str,int charNum){
	    String fieldIndexName="";
	    if (charNum>0)
	       fieldIndexName=str.substring(0,charNum-1)+str.substring(charNum+1);
	    else
	        fieldIndexName=str.substring(charNum+1);
        String firstChar=str.substring(charNum,charNum+1);
        fieldIndexName=firstChar.toUpperCase()+fieldIndexName;
	    return fieldIndexName;
	}
    public void changePropertyValue(Object obj,String propertyName){
        String fieldIndexName=changeStringOfCharUppCase(propertyName,0);            
        String getFieldIndexName="get"+fieldIndexName;
        Method meth;
        try {
            meth = obj.getClass().getMethod(getFieldIndexName, null);
            Object retobj = meth.invoke(obj, null);  
//            String setFieldIndexName="set"+fieldIndexName;
            Class partypes[] = new Class[1];
            partypes[0] = Integer.class; 
//            Method meth1 =obj.getClass().getMethod(setFieldIndexName, partypes);
            Object arglist[] = new Object[1];
            arglist[0] = new Integer(1); 
            Object retobjTmp = meth.invoke(retobj, arglist); //产生自增号 
        } catch (SecurityException e) {
            // XXX 自动生成 catch 块
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // XXX 自动生成 catch 块
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // XXX 自动生成 catch 块
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // XXX 自动生成 catch 块
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // XXX 自动生成 catch 块
            e.printStackTrace();
        }
        
    }
    
    /**
     * 
     * ==============================
     * @作者: thinkpad
     * @日期: 2014-8-11下午2:21:01
     * @comments:
     * @param length
     * @return
     * ==============================
     */
    public static String getRandomString(int length) {
    	String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
public static String DoubleToString(Double dd){
		
		String dString=dd+"";
		String xiaoshuString="";
		String ds[]=dString.split("\\.");
		if(ds.length>1){
			if(ds[1].length()==1){
				
				xiaoshuString=ds[1]+"0";
			}else{
				xiaoshuString=ds[1]+"";
			}
			dString=ds[0]+"."+xiaoshuString;
		}else{
			dString=dString+".00";
		}
		return dString;
	}
	
	public static String StringToString(String dd){
		
		String dString=dd+"";
		String xiaoshuString="";
		String ds[]=dString.split("\\.");
		if(ds.length>1){
			if(ds[1].length()==1){
				
				xiaoshuString=ds[1]+"0";
			}else{
				xiaoshuString=ds[1]+"";
			}
			dString=ds[0]+"."+xiaoshuString;
		}else{
			dString=dString+".00";
		}
		return dString;
	}
    public static void main(String[] args) {
        System.out.println(TypeConvert.formatDouble(3.4467, 3));
        System.out.println(TypeConvert.formatBecomePercent(3.44676));
        Date date = TypeConvert.setDate(2005, 1, 22);
        TypeConvert.dateAddDay(date, 3);
        System.out.println(TypeConvert.formatDate(date));
        Date date1 = new Date();
        Date date2 = new Date();
        TypeConvert.getYearScope(date, date1, date2);
        System.out.println(TypeConvert.formatDate(date1));
        System.out.println(TypeConvert.formatDate(date2));
        System.out.println("---------------------");
        TypeConvert.getHalfYearScope(date, date1, date2);
        System.out.println(TypeConvert.formatDate(date1));
        System.out.println(TypeConvert.formatDate(date2));
        System.out.println("---------------------");
        TypeConvert.getQuarterScope(date, date1, date2);
        System.out.println(TypeConvert.formatDate(date1));
        System.out.println(TypeConvert.formatDate(date2));
        System.out.println("---------------------");
        TypeConvert.getMonthScope(date, date1, date2);
        System.out.println(TypeConvert.formatDate(date1));
        System.out.println(TypeConvert.formatDate(date2));
        int a = (int) Math.ceil(10 / 3.0);

        System.out.println("---------------------");
        System.out.println(a);
        System.out.println(TypeConvert.formatDate(new Date(),"yyyyMMddHHmmssz"));
        Locale lc=new Locale("en","US");
        System.out.println("country:"+lc.getCountry()+" getLanguage:"+lc.getLanguage());
        NumberFormat df = NumberFormat.getCurrencyInstance(lc);
        ((DecimalFormat) df).applyPattern("#0.000");
       df.setGroupingUsed(true); 
       
        for (int i=0;i<Locale.getAvailableLocales().length;i++){             
            System.out.println("country:"+Locale.getAvailableLocales()[i].getCountry()+
                    " langue:"+Locale.getAvailableLocales()[i].getLanguage()+
                    " countryName:"+Locale.getAvailableLocales()[i].getDisplayCountry());
        }
       
         df.setMaximumFractionDigits(3);
         //df.setCurrency(new Currency());
         double d=33333.56;
         System.out.println("d:"+df.format(d));
         System.out.println(TypeConvert.formatDouble(00.3688,"#0.00##"));
         System.out.println(TypeConvert.formatBecomePercent(0.334866));
         Object qty=TypeConvert.stringParseNumber("-3");
         if (qty instanceof Double){
             Double bigQty=(Double) qty;
             System.out.println("double类型："+bigQty);
         } else if (qty instanceof Long){
             Long bigQty=(Long) qty;
             System.out.println("整形："+bigQty);
         }
         
         System.out.println(TypeConvert.stringParseDouble("3"));
         System.out.println(TypeConvert.stringParseLong("0.334556"));
         System.out.println(TypeConvert.formatNumberToCurrentcy(222)); 
         TypeConvert typeConvert=new TypeConvert();
         System.out.println(typeConvert.getClass().getName());
         String printContext="tgprere=${request.getContextPath()}/wwewe/wewe";
		   if (printContext!=null && printContext.indexOf("${request.getContextPath()}")>0){
		       System.out.println(printContext.indexOf("${request.getContextPath()}"));
		       System.out.println("${request.getContextPath()}".length());
		       System.out.println( printContext.substring(0,3)+
		               printContext.substring(3+"${request.getContextPath()}".length(),printContext.length()));
		   }
		   System.out.println(printContext);
         
    }
}
