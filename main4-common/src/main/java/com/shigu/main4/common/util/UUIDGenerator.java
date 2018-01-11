package com.shigu.main4.common.util;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：UUIDGenerator.java
 *@文件路径：com.gzy.common.tools.UUIDGenerator.java
 *@内容摘要：
 *@编码作者：顾邹阳
 *@完成日期：
 *@Date2014-4-29下午11:48:58
 *@comments:
 *
 *=========================================================
 */
public class UUIDGenerator {
	private static final String CNUMBER_PATTERN = "^[0-9]*$";// 判断数字的正则表达式
	public static String getSysUUID(){
		
		return UUID.randomUUID().toString(); 
	}
	 /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        return getSysUUID().replace("-", "");
    } 
    public static String getOrderNo(Long tradeId){ 
    	String orderNo="";
    	String s = TypeConvert.formatDateyyyyMMdd(new Date()); 
    	String diString= tradeId.toString();
    	int p=0;
    	String nn0="";
    	if(diString.length()<=7){
    		p=7-diString.length();
    		if(p>0){
    			for(int i=0;i<p;i++){
    				nn0+="0";
    				
    			}
    			
    		}
    		orderNo=s+nn0+diString;
    	}else{
    		
    		orderNo=s+diString.substring(diString.length()-7, diString.length());
    	}
        return orderNo; 
    } 
    
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */ 
    public static String[] getUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    } 
    public static void main(String[] args){ 
        String[] ss = getUUID(10); 
        for(int i=0;i<ss.length;i++){ 
            //System.out.println(ss[i]); 
        } 
    } 
    /**
	  * 验证是不是数字(没有小数点)
	  * 
	  * @param number
	  * @return
	  */
	 public static boolean isInteger(String number) {
	  return match(CNUMBER_PATTERN, number);
	 }

	 /**
	  * 执行正则表达式
	  * 
	  * @param pattern 表达式
	  * @param str 待验证字符串
	  * @return 返回 <b>true </b>,否则为 <b>false </b>
	  */
	 private static boolean match(String pattern, String str) {
	  Pattern p = Pattern.compile(pattern);
	  Matcher m = p.matcher(str);
	  return m.find();
	 }
}
