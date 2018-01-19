package com.shigu.main4.common.tools;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符操作工具类
 * 
 * @author
 * @version 1.0
 */
public class StringUtil {

	public static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	// ~ 静态对象初始化
	// ----------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 */
	public static int suffix = 1;

	/**
	 * DOCUMENT ME!
	 */
	public static int prefix = 2;
	
	/**
	 * 逗号
	 */
	public final static String joinD = ",";
	
	/**
	 * 分号
	 */
	public final static String joinF = ";";

	// ~ 方法
	// ---------------------------------------------------------------------

	/**
	 * 判断字符串是否为空对象或空字符串
	 * 
	 * @author YPS_SA
	 * @param str
	 * @return FALSE 是 TRUE 非
	 */
	public static boolean StringIsNullOrEmpty(String str) {
		if (str == null)
			return true;
		if (str.trim().equals(""))
			return true;
		return false;
	}

	/**
	 * 字符串转换成整型数值,转换失败后返回0
	 */
	public static int parseInt(String str) {
		if ((str == null) || (str.trim().length() == 0)) {
			return 0;
		}

		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			i = 0;
		}

		return i;
	}

	/**
	 * 字符串转换成整型数值,转换失败后返回默认的值
	 */
	public static int parseInt(String str, int defaultValue) {
		if ((str == null) || (str.length() == 0)) {
			return defaultValue;
		}

		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			i = defaultValue;
		}

		return i;
	}

	/**
	 * 字符串转换成浮点型数值,转换失败后返回0
	 */
	public static float parseFloat(String str) {
		if ((str == null) || (str.length() == 0)) {
			return 0;
		}

		float i = 0;
		try {
			i = (new BigDecimal(str)).floatValue();
		} catch (NumberFormatException ex) {
			i = 0;
			throw ex;
		}

		return i;
	}

	/**
	 * 字符串转换成浮点型数值,转换失败后返回默认的值
	 */
	public static float parseFloat(String str, float defaultValue) {
		if ((str == null) || (str.trim().length() == 0)) {
			return defaultValue;
		}

		float i = 0;
		try {
			i = (new BigDecimal(str)).floatValue();
		} catch (NumberFormatException ex) {
			i = defaultValue;
		}

		return i;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static double parseDouble(String str) {
		if ((str == null) || (str.trim().length() == 0)) {
			return 0;
		}

		double i = 0;
		try {
			i = (new BigDecimal(str)).doubleValue();
		} catch (NumberFormatException ex) {
			i = 0;
			throw ex;
		}

		return i;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 * @param defaultValue
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static double parseDouble(String str, float defaultValue) {
		if ((str == null) || (str.trim().length() == 0)) {
			return defaultValue;
		}

		double i = 0;
		try {
			i = (new BigDecimal(str)).doubleValue();
		} catch (NumberFormatException ex) {
			i = defaultValue;
		}

		return i;
	}

	/**
	 * 根据字符splitChar将字符串srcStr分割 splitChar可以是|或.
	 */
	public static String[] split(String srcStr, char splitChar) {
		String[] returnStr = null;

		if (srcStr == null) {
			return null;
		}

		// 如果不存在,原样返回.
		if (srcStr.indexOf(splitChar) == -1) {
			return new String[] { srcStr };
		}

		// 为保证长度,填加自己的字符串
		boolean flag = srcStr.lastIndexOf(splitChar) == (srcStr.length() - 1);

		// 如果最后一位是分割的字符,则添加自己的字符串
		if (flag) {
			srcStr = srcStr + String.valueOf(splitChar - 1);
		}

		String[] temp = null;
		if (splitChar == '|') {
			temp = srcStr.split("\\|");
		} else if (splitChar == '.') {
			temp = srcStr.split("\\.");
		} else {
			temp = srcStr.split(String.valueOf(splitChar));
		}

		if (flag) {
			returnStr = new String[temp.length - 1];
			for (int i = 0; i < (temp.length - 1); i++) {
				returnStr[i] = temp[i];
			}
		} else {
			returnStr = temp;
		}

		return returnStr;
	}
	
	/**
	 * 更换字符串中的分割符
	 * @param src
	 * @param oldSplit
	 * @param split
	 * @return
	 */
	public static String replaceSplitChar(String src, String oldSplit, String split) {
		String result = "";
		if (oldSplit == null || src == null || split == null) {
			return src;
		}
		for (String str : src.split(oldSplit)) {
			if (StringIsNullOrEmpty(str)) {
				continue;
			}
			result += str + split;
		}
		return result.substring(0, result.length()-1);
	}

	/**
	 * 特殊的分隔, 如果一个字符串要变成几行显示,使用这个方法
	 * 
	 * @param src
	 *            "440200,440500,440800,440900,441200,441400,441500"
	 * @param splitChar
	 *            ","
	 * @param numPerRow
	 *            3 (表示 3个为一行)
	 * 
	 * @return
	 */
	public static String split2row(String src, String splitChar, int numPerRow) {
		if ((src == null) || (src.indexOf(splitChar) == -1)) {
			return src;
		}

		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(src, splitChar);
		int j = 1;
		while (st.hasMoreTokens()) {
			if (j > numPerRow) {
				sb.append("<br>");
				j = 0;
			}

			sb.append(st.nextToken());
			sb.append(",");
			j++;
		}

		String s = sb.toString();
		if (s.length() != 0) {
			s = s.substring(0, s.lastIndexOf(","));
		}

		return s;
	}

	/**
	 * 特殊的分隔, 如果一个字符串要变成几行显示,使用这个方法
	 * 
	 * @param src
	 * @param numPerRow
	 *            3 (表示 3个为一行)
	 * 
	 * @return
	 */
	public static String split2row(String src, int numPerRow) {
		// 为空,或长度小于要分割的长度,则直接返回
		if ((src == null) || (src.length() <= numPerRow)) {
			return src;
		}

		StringBuffer sb = new StringBuffer();
		int j = 0;
		String tmpSrc = src;
		String tmp = null;
		boolean flag = true;
		while (flag) {
			tmp = tmpSrc.substring(j, numPerRow);
			sb.append(tmp);
			sb.append("<br>");

			tmpSrc = tmpSrc.substring(numPerRow);

			if (tmpSrc.length() < numPerRow) {
				flag = false;
				sb.append(tmpSrc);
			}
		}

		return sb.toString();
	}

	/**
	 * --在string中查找oldString,然后用nesofttring来替换--(JDK的String.replaceAll(str1,str2
	 * )不能处理特殊字符)
	 */
	public static String Replace(String string, String oldString,
			String nesofttring) {
		if (string == null) {
			return null;
		}
		// If the nesofttring is null or zero length, just return the string
		// since there's nothing
		// to replace.
		if (nesofttring == null) {
			return string;
		}
		int i = 0;
		// Make sure that oldString appears at least once before doing any
		// processing.
		if ((i = string.indexOf(oldString, i)) >= 0) {
			// Use char []'s, as they are more efficient to deal with.
			char[] string2 = string.toCharArray();
			char[] nesofttring2 = nesofttring.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(string2.length);
			buf.append(string2, 0, i).append(nesofttring2);
			i += oLength;
			int j = i;
			// Replace all remaining instances of oldString with nesofttring.
			while ((i = string.indexOf(oldString, i)) > 0) {
				buf.append(string2, j, i - j).append(nesofttring2);
				i += oLength;
				j = i;
			}
			buf.append(string2, j, string2.length - j);
			return buf.toString();
		}
		return string;

	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 * @param byteNum
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public String splitStr(String str, int byteNum) {
		String returnStr = null;

		byte[] bt = str.getBytes();
		System.out.println("Length of this String ===>" + bt.length);
		if (byteNum > 1) {
			if (bt[byteNum] < 0) {
				returnStr = new String(bt, 0, --byteNum);
			} else {
				returnStr = new String(bt, 0, byteNum);
			}
		} else {
			if (byteNum == 1) {
				if (bt[byteNum] < 0) {
					returnStr = new String(bt, 0, ++byteNum);
				} else {
					returnStr = new String(bt, 0, byteNum);
				}
			} else {
				System.out.println("输入错误！！！请输入大于零的整数：");
			}
		}

		return returnStr;
	}

	/**
	 * 根据前缀后缀标识prefixOrsuffix来填充value的左右边,默认填充的值为"0" 如整型值500变成 "000500",
	 */
	public static String getStringByFullLen(int value, int strLen,
			int prefixOrsuffix) {
		String noStr = String.valueOf(value);
		return getStringByFullLen(noStr, strLen, "0", prefixOrsuffix);
	}

	/**
	 * 根据前缀后缀标识prefixOrsuffix来填充value的左右边,defaultstr为填充的字符串
	 * 如"500"变成"aaa500",则参数为 ("500",6,"a",StringUtil.prefix);
	 */
	public static String getStringByFullLen(String value, int strLen,
			String defaultstr, int prefixOrsuffix) {
		// 默认为前缀
		if ((prefixOrsuffix != prefix) && (prefixOrsuffix != suffix)) {
			prefixOrsuffix = prefix;
		}

		// 如果no的长度已经超过最大长度,直接返回
		if (value.length() > strLen) {
			return value;
		}

		// 长度如果不够则头面补0
		while (value.length() < strLen) {
			if (prefixOrsuffix == prefix) {
				value = defaultstr + value;
			} else {
				value = value + defaultstr;
			}
		}

		return value;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param obj
	 *            DOCUMENT ME!
	 * @param strLen
	 *            DOCUMENT ME!
	 * @param defaultstr
	 *            DOCUMENT ME!
	 * @param prefixOrsuffix
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String getStringByFullLen(Object obj, int strLen,
			String defaultstr, int prefixOrsuffix) {
		String value = null;
		if (obj == null) {
			value = "";
		} else {
			value = obj.toString();
		}

		return getStringByFullLen(value, strLen, defaultstr, prefixOrsuffix);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param map
	 *            DOCUMENT ME!
	 * @param key
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static double getBigDecimal(Map map, String key) {
		if (map == null) {
			return 0;
		}

		Object obj = map.get(key);
		if (obj == null) {
			return 0;
		}

		if (obj.toString().equals("")) {
			return 0;
		}

		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).doubleValue();
		} else {
			return StringUtil.parseDouble(obj.toString());
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param doublestr
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static double getBigDecimal(String doublestr) {
		return StringUtil.parseDouble(doublestr);
	}

	/**
	 * 将字符串string中的findChar字符,全部替换成repalceChar 能够分隔|和.
	 */
	public static String replaceAllChar(String srcStr, char findChar,
			char replaceChar) {
		// 字符串不能为null
		if (srcStr == null) {
			return null;
		}

		// 如果字符串不包含findChar,则直接返回
		if (srcStr.indexOf(findChar) == -1) {
			return srcStr;
		}

		// 为保证长度,填加自己的字符串
		boolean flag = srcStr.lastIndexOf(findChar) == (srcStr.length() - 1);

		// 分解字符串,用-来代替|
		StringBuffer sb = new StringBuffer();
		String[] splits = split(srcStr, findChar);
		for (int i = 0; i < splits.length; i++) {
			sb.append(splits[i]);
			if (i == (splits.length - 1)) {
				if (flag) {
					sb.append(String.valueOf(replaceChar));
				}
			} else {
				sb.append(String.valueOf(replaceChar));
			}
		}

		return sb.toString();
	}

	/**
	 * 将以.开头的字符串,前面加"0" 用于将字符串为 .23 的数字转换成 0.23
	 */
	public static String replaceFirstDot(String s) {
		if ((s == null) || s.equals("")) {
			s = "0";
		}

		if (s.startsWith(".", 0)) {
			return "0" + s;
		}

		return s;
	}

	/**
	 * 字符串为空的,转换成长度为0的字符串
	 */
	public static String null2Blank(String str) {
		return null2DefValue(str, "");
	}

	/**
	 * 字符串为空的,转换成长度为0的字符串
	 */
	public static Object null2Blank(Object obj) {
		if (obj == null) {
			return "";
		}

		return obj;
	}

	/**
	 * 字符串为空的,转换成字符0
	 */
	public static String null2Zero(String str) {
		return null2DefValue(str, "0");
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param obj
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String null2Zero(Object obj) {
		return null2DefValue((String) obj, "0");
	}

	/**
	 * 如果str对象为空,则返回"无",否则返回str字符串
	 */
	public static String null2HZwu(String str) {
		return null2DefValue(str, "无");
	}

	/**
	 * 如果字符串为空,则用默认的值替换
	 */
	public static String null2DefValue(String str, String defaultValue) {
		if ((str == null) || (str.trim().length() == 0)) {
			return defaultValue;
		}

		return str;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param obj
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String null2HTMLkg(Object obj) {
		if (obj == null) {
			return null2DefValue("", "&nbsp;");
		} else {
			if (obj.toString().equals("0")) {
				return null2DefValue(null, "&nbsp;");
			} else {
				return null2DefValue(obj.toString(), "&nbsp;");
			}
		}
	}

	/**
	 * 两个字符串,如果哪个不为空,则选择哪个,如果都为空,返回为默认值 如果都不为空,返回str1的值
	 */
	public static String getOneFromTwoStr(String str1, String str2,
			String defaultValue) {
		String temp = null;

		boolean b1 = str1 == null;
		boolean b2 = str2 == null;

		// 如果都为空,返回为null
		if (b1 && b2) {
			temp = defaultValue;

			// str1 为null,str2 不为null
		} else if (b1 && !b2) {
			temp = str2;

			// str1 不为null,str2 为null
		} else if (!b1 && b2) {
			temp = str1;

			// 都不为空
		} else {
			temp = str1;
		}

		if ((temp == null) || temp.trim().equals("")) {
			temp = defaultValue;
		}

		return temp;
	}

	/**
	 * 根据列表,组织成 in 的SQL语句条件
	 */
	public static String makeContCondi(ArrayList cont) {
		StringBuffer sb = new StringBuffer("(");
		for (int i = 0; i < cont.size(); i++) {
			if (i != 0) {
				sb.append(",");
			}

			sb.append("'");
			sb.append((String) cont.get(i));
			sb.append("'");
		}

		sb.append(")");
		return sb.toString();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param cont
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String makeContCondi(Object[] cont) {
		StringBuffer sb = new StringBuffer("(");
		for (int i = 0; i < cont.length; i++) {
			if (i != 0) {
				sb.append(",");
			}

			sb.append("'");
			sb.append(((String) cont[i]).trim());
			sb.append("'");
		}

		sb.append(")");
		return sb.toString();
	}

	/**
	 * 检查字符串的长度,如果字符串的长度大于maxLen,则截取到最大长度的字符串
	 */
	public static String getMaxLenString(String src, int maxLen) {
		byte[] srcBytes = src.getBytes();

		// 如果字符串的长度大于maxlen,则截取
		if (srcBytes.length > maxLen) {
			String tStr = substring(srcBytes, maxLen);

			// 因为复制Byte[]可能得到一个汉字的半个部分,所以需要再判断一次
			// 如果字符串为空,或长度为0,则Byte[]的长度再减去1,这样就去掉了那半个汉字
			if ((tStr == null) || tStr.trim().equals("")) {
				tStr = substring(srcBytes, maxLen - 1);
			}

			return tStr;
		} else {
			return src;
		}
	}

	/**
	 * 只被用于 getMaxLenString 方法
	 */
	private static String substring(byte[] srcBytes, int maxLen) {
		byte[] targetByte = new byte[maxLen];
		for (int i = 0; i < maxLen; i++) {
			targetByte[i] = srcBytes[i];
		}

		return new String(targetByte);
	}

	/**
	 * 以字节方式的substring,从start位置(第一列值为1)开始,一共取totalLen长度
	 */
	public static String substring(byte[] srcBytes, int start, int totalLen) {
		start = start - 1;
		if (srcBytes.length < (start + totalLen)) {
			return "";
		}

		byte[] target = new byte[totalLen];
		System.arraycopy(srcBytes, start, target, 0, totalLen);
		return new String(target).trim();
	}

	/**
	 * 返回转码后的字符串
	 */
	public static String nesofttring(String str, String fromcharse,
			String tocharse) {
		if ((str == null) || str.trim().equals("")) {
			return "";
		}

		try {
			return new String(str.getBytes(fromcharse), tocharse);
		} catch (UnsupportedEncodingException ex) {
			return str;
		}
	}

	/**
	 * 设置prop文件的配置文件,读取配置文件中的map的映射对应关系,保存到infos对象中
	 */
	public static HashMap getPropertiesInfos(File propFile) {

		// 对象为空,对象不存在,直接返回
		if ((propFile == null) || !propFile.exists()) {
			return null;
		}

		Properties prop = new Properties();
		FileInputStream fProp = null;
		try {
			fProp = new FileInputStream(propFile);
			prop.load(fProp);
		} catch (Exception ex) {
//			System.out.println(ex);
			return null;
		}finally {
			if (fProp != null) {
				try {
					fProp.close();
				} catch (IOException e) {
					if (logger.isErrorEnabled()) {
						logger.error("关闭流失败",e);
					}
				}
			}
		}

		HashMap infos = new HashMap();
		Enumeration enumer = prop.propertyNames();
		while (enumer.hasMoreElements()) {
			String name = (String) enumer.nextElement();
			infos.put(name, prop.getProperty(name));
		}

		return infos;
	}

	/**
	 * 根据Pattern判断一个字符串是否符合格式要求
	 */
	public static boolean isPatternTrue(String patternFormat, String value) {
		Pattern p = Pattern.compile(patternFormat);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	/**
	 * 判断参数是否为空,如果为空返回true
	 * 
	 * @param val
	 * 
	 * @return
	 */
	public static boolean isNull(String val) {
		if ((val == null) || (val.trim().length() == 0)) {
			return true;
		}

		return false;
	}

	/**
	 * 转换IP为数字
	 * 
	 * @param ip
	 *            需要转换的ip
	 * 
	 * @return IP数字
	 */
	public static int getIntIP(String ip) {
		int ipaddr;
		StringTokenizer token = new StringTokenizer(ip, ".");
		int[] intToken = new int[4];

		for (int i = 3; i >= 0; i--) {
			if (token.hasMoreTokens()) {
				intToken[i] = Integer.parseInt(token.nextToken());
			}
		}

		try {
			ipaddr = (intToken[0]) | (intToken[1] << 8) | (intToken[2] << 16)
					| (intToken[3] << 24);
		} catch (Exception e) {
			// System.out.println("error");
			// 2005-3-18
			// Env.getLog().debug( Tools.getStackTrace( e ) );
			return -1;
		}

		return ipaddr;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param obj
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static boolean isNull(Object obj) {
		return isNull((String) obj);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param i
	 *            DOCUMENT ME!
	 */
	public static void println(int i) {
		System.out.println(i);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param f
	 *            DOCUMENT ME!
	 */
	public static void println(float f) {
		System.out.println(f);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 */
	public static void println(String str) {
		System.out.println(str);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param strs
	 *            DOCUMENT ME!
	 */
	public static void println(Object[] strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param list
	 *            DOCUMENT ME!
	 */
	public static void println(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param map
	 *            DOCUMENT ME!
	 */
	public static void println(Map map) {
		String[] s = new String[map.size()];
		map.keySet().toArray(s);

		for (int i = 0; i < s.length; i++) {
			Object val = map.get(s[i]);
			if (val instanceof Map) {
				System.out.println();
				StringUtil.println((Map) val);
			} else {
				System.out.println(s[i] + "=" + val);
			}
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param element
	 *            DOCUMENT ME!
	 * @param value
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String getXmlElement(String element, Object value) {
		if (value == null) {
			value = "";
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<").append(element).append(">").append(value.toString())
				.append("</").append(element).append(">");

		return sb.toString();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param element
	 *            DOCUMENT ME!
	 * @param value
	 *            DOCUMENT ME!
	 * @param defaultValue
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String getXmlElement(String element, Object value,
			String defaultValue) {
		if (value == null) {
			value = defaultValue;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<").append(element).append(">").append(value.toString())
				.append("</").append(element).append(">");

		return sb.toString();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param map
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String[] getMapKeys(Map map) {
		if ((map == null) || (map.size() == 0)) {
			return null;
		}

		String[] keys = new String[map.size()];
		map.keySet().toArray(keys);
		for (int i = 0; i < keys.length; i++) {
			keys[i] = keys[i].toLowerCase();
		}

		return keys;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param yjtm
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 */
	public static String getYjtmNum(String yjtm) {
		if (yjtm.length() == 13) {
			return yjtm.substring(2, 11);
		}

		return "";
	}

	/**
	 * 检查字符串是否为有效字符
	 * 
	 * @param str
	 *            要进行判断的字符串
	 * 
	 * @return in为null或""或"null"时返回false
	 */
	public static boolean isValidString(String str) {
		return !((str == null) || str.trim().equals("") || str.trim().equals(
				"null"));
	}

	/**
	 * 将字符串转换为utf8编码
	 * 
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 0) && (c <= 255)) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = String.valueOf(c).getBytes("UTF-8");
				} catch (Exception ex) {
					b = new byte[0];
				}

				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0) {
						k += 256;
					}

					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}

		return sb.toString();
	}

	/**
	 * 转换字符编码(常用)
	 * 
	 * @param src
	 *            unicode字符串
	 * 
	 * @return 本地化字符串
	 */
	public static String unicode2Native(String src) {
		if ((src == null) || (src.length() == 0)) {
			return null;
		}

		char[] buffer = new char[src.length() * 2];
		char c;
		int j = 0;
		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) >= 0x100) {
				c = src.charAt(i);
				byte[] buf = ("" + c).getBytes();
				buffer[j++] = (char) buf[0];
				buffer[j++] = (char) buf[1];
			} else {
				buffer[j++] = src.charAt(i);
			}
		}

		return new String(buffer, 0, j);
	}

	/**
	 * 转换字符编码(iso8859-1)
	 * 
	 * @param src
	 *            输入字符串, encode 转换后的类型,为空默认为 utf-8
	 * 
	 * @return 转换后的字符串
	 */
	public static String convert(String src, String encode) {
		byte[] temp;
		if (encode == null) {
			encode = "utf-8";
		}

		if (src != null) {
			try {
				temp = src.getBytes("GBK");
				src = new String(temp, encode);
				return src;
			} catch (Exception e) {
				return null;
			}
		}

		return null;
	}

	/**
	 * 将字符串转换为 BASE64 编码
	 * 
	 *            输入字符串
	 * 
	 * @return 转换后的字符串
	 */
	public static String getBASE64(String s) {
		if (s == null) {
			return null;
		}

		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	/**
	 * 将 BASE64 编码的字符串解码
	 * 
	 *            输入字符串
	 * 
	 * @return 解码后的字符串
	 */
	public static String getFromBASE64(String s) {
		if (s == null) {
			return null;
		}
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 转换MAP中的所有key的大小写 flag=S 小写 =L 大写
	 */
	public static Map convertMap(Map map, String flag) {

		return convertMap(map, flag, null);
	}

	/**
	 * 转换MAP中的所有key的大小写 flag=S 小写 =L 大写 根据returnField的值返回需要的值
	 */
	public static Map convertMap(Map map, String flag, String returnField) {
		if (map == null)
			return null;
		Map newmap = new HashMap();
		if (flag == null || (!flag.equals("S") && !flag.equals("L")))
			flag = "S";

		Object[] obj = map.keySet().toArray();
		for (int i = 0; i < obj.length; i++) {
			if (flag.equals("L")) {
				if (returnField == null
						|| (returnField != null && returnField.indexOf(","
								+ obj[i].toString().toUpperCase() + ",") >= 0)) {
					newmap.put(obj[i].toString().toUpperCase(), map.get(obj[i]
							.toString()));
				}
			} else {
				if (returnField == null
						|| (returnField != null && returnField.indexOf(","
								+ obj[i].toString().toLowerCase() + ",") >= 0)) {
					newmap.put(obj[i].toString().toLowerCase(), map.get(obj[i]
							.toString()));
				}

			}
		}
		return newmap;
	}

	/**
	 * list里面的对象去重
	 */
	public static List removeDuplicateObject(List list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		return newList;
	}

//	/**
//	 * 获取用户访问Ip
//	 *
//	 * @param  request
//	 * @return
//	 */
//	public static String getIpAddr(HttpServletRequest request) {
//		String ip = request.getHeader("x-forwarded-for");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}

	/**
	 * 将数组集合用param参数连接
	 * 
	 * @param values
	 *            数组
	 * @param param
	 *            连接字符参数
	 * @return
	 */
	public static String join(String[] values, String param) {
		String value = "";
		if (values == null) {
			return value;
		}
		if (values.length == 1) {
			value = values[0];
			return value;
		}
		for (int i = 0; i < values.length; i++) {
			String v = values[i];
			if (v.isEmpty()) {
				continue;
			}
			if (i == values.length - 1) {
				value += v;
			} else {
				value += v + param;
			}
		}
		return value;
	}

	public static String joinList(List<String> strList, String param) {
		String value = "";
		for (int i = 0; i < strList.size(); i++) {
			String v = strList.get(i);
			if (v == null) {
				v = "null";
			} else {
				if (v.trim().equals("")) {
					v = "null";
				}
			}
			if (i != strList.size() - 1) {
				value += v + param;
			} else {
				value += v;
			}
		}
		return value;
	}

	public static String joinObjList(List strList, String param){
		String value = "";
		for (int i = 0; i < strList.size(); i++) {
			String v = strList.get(i)+"";
				if (v.trim().equals("")) {
					v = "null";
				}
			if (i != strList.size() - 1) {
				value += v + param;
			} else {
				value += v;
			}
		}
		return value;
	}
	
	/**
	 * 自定义拼接INT数组为String,
	 * @param ids
	 * @return
	 */
	public static String joinInts(int[] ids) {
		StringBuffer stringBuffer = new StringBuffer();
		if (ids == null) {
			return null;
		}
		for (int i = 0; i < ids.length; i++) {
			stringBuffer.append(ids[i]);
			if (i < ids.length - 1) {
				stringBuffer.append(",");
			}
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 自定义拼接Long数组为String,
	 * @param ids
	 * @return
	 */
	public static String joinLongs(Long[] ids) {
		StringBuffer stringBuffer = new StringBuffer();
		if (ids == null) {
			return null;
		}
		for (int i = 0; i < ids.length; i++) {
			if(ids[i] == null){
				continue;
			}
			stringBuffer.append(ids[i]);
			if (i < ids.length - 1 ) {
				stringBuffer.append(",");
			}
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 字符串数组用“，”拼接成字符串
	 * @param ids 数组
	 * @param joinStr 连接字符串
	 * @return
	 */
	public static String joinStrs(String[] ids,String joinStr) {
		StringBuffer stringBuffer = new StringBuffer();
		if (ids == null) {
			return null;
		}
		for (int i = 0; i < ids.length; i++) {
			if(StringUtils.isEmpty(ids[i])){
				continue;
			}
			stringBuffer.append(ids[i]);
			if (i < ids.length - 1) {
				stringBuffer.append(",");
			}
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 字符串数组用“，”拼接成字符串
	 * @param ids 数组
	 * @return
	 */
	public static String joinStrs(String[] ids) {
		return joinStrs(ids, joinD);
	}
	
	/**
	 * 处理淘宝数据返回
	 * @param json
	 * @return
	 */
	public static String handleFilterTbJson(String json){
		if(StringUtils.isEmpty(json)){
			return null;
		}
		json = URLDecoder.decode(json.replaceAll("_", ""));
		return json;
	}
	
	/**
	 * 判断地址是否是图片文件地址
	 * @param url
	 * @return
	 */
	public static boolean panCheckUrlIsImg(String url) {
		if (StringUtils.isEmpty(url)) {
			return false;
		}
		int startIndex = url.indexOf(".");
		String fileSuffix = url.substring(startIndex, url.length());
		if (StringUtils.equals(fileSuffix, "jpg") || StringUtils.equals(fileSuffix, "png")) {
			return true;
		}
		return false;
	}
	
	public static BigDecimal getPriceTwo(String price){
		if(StringUtils.isEmpty(price)){
			return null;
		}
		String [] prices = price.split("-");
		price = prices[prices.length-1];
		BigDecimal priceDeci = null;
		try {
			priceDeci = new BigDecimal(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(priceDeci == null){
			priceDeci = new BigDecimal("0");
		}
		return priceDeci;
	}
	
	/**
	 * 获取本机IP
	 * @return
	 * @throws SocketException
	 */
	public static String getRealIp() throws SocketException {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP

		Enumeration<NetworkInterface> netInterfaces = NetworkInterface
				.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP
		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& !ip.getHostAddress().contains(":")) {// 外网IP
					netip = ip.getHostAddress();
					finded = true;
					break;
				} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& !ip.getHostAddress().contains(":")) {// 内网IP
					localip = ip.getHostAddress();
				}
			}
		}

		if (netip != null && !"".equals(netip)) {
			return netip;
		} else {
			//return localip;
			return "122.233.67.192";
		}
	}
	
	/**
	 * 10进制转自定义37进制
	 * @return
	 */
	public static String str10To37Str(){
		String[] str37 = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		Random random = new Random();
		int a = random.nextInt(str37.length);
		int b = random.nextInt(str37.length);
		int c = random.nextInt(str37.length);
		int d = random.nextInt(str37.length);
		int e = random.nextInt(str37.length);
		int f = random.nextInt(str37.length);
		int g = random.nextInt(str37.length);
		String createStr = str37[a] + str37[b] + str37[c] + str37[d] + str37[e] + str37[f] + str37[g];
		return createStr;
	}
}
