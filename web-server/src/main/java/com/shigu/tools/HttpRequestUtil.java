package com.shigu.tools;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.Version;
import org.apache.commons.lang3.StringUtils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class HttpRequestUtil {
	
	/**
	 * 获取公网IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 浏览器名与操作系统
	 * @param request
	 * @return
	 */
	public static String getKhInfo(HttpServletRequest request) {
		String Agent = request.getHeader("User-Agent");
		// 得到用户的浏览器名
		String userbrowser = null;
		// 得到用户的操作系统名
		String useros = null;
		
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();
		
		if(browser != null){
			userbrowser = browser.getName();
		}
		
		if(os != null){
			useros = os.getName();
		}
		
		if (StringUtils.isEmpty(userbrowser)) {
			userbrowser = "未知";
		}
		if (StringUtils.isEmpty(useros)) {
			useros = "未知";
		}
		return "操作系统:" + useros + " 浏览器:" + userbrowser;
	}

	public static UserAgent getUserAgent(HttpServletRequest request) {
		return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
	}
}
