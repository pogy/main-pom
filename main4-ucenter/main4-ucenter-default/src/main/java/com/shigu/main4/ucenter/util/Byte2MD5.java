package com.shigu.main4.ucenter.util;

import java.security.MessageDigest;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：Byte2MD5.java
 *@文件路径：com.common.utils.Byte2MD5.java
 *@内容摘要：
 *@编码作者：gzy
 *@完成日期：
 *@Date2015-8-19下午2:06:06
 *@comments:
 *
 *=========================================================
 */
public class Byte2MD5 {
	
	public  static String getMD5(byte[] imgbytes ) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		if(imgbytes == null||imgbytes.length<1)
		{
			return null;
		}
		try {
			byte[] strTemp = imgbytes;
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// //System.out.println((int)b);
				// 将没个数(int)b进行双字节加密
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

}
