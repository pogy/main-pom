package com.shigu.component.common.globality.constant;

/**
 * 系统常量
 * @author xrp_zjb
 * @date 2015/5/26 22:11
 * 
 */
public class SystemConStant {
	
	/************************************** SESSION KEY ******************************************/

	public final static String SESSION_USER_KEY = "SESSION_USER_KEY";// 当前的登录用户会话
	
	
	/************************************** 程序响应状态 ******************************************/
	
	public final static String RESPONSE_STATUS_SUCCESS = "success";// 成功
	public final static String RESPONSE_STATUS_FAILED = "failed";// 失败
	public final static String RESPONSE_STATUS_ERROR = "error";// 系统错误/运行时异常
	public final static String RESPONSE_MSG_ERROR = "系统繁忙";
	
	/************************************** 程序响应前端MSG ******************************************/
	
	public final static String RESPOSNE_NOT_VALID_ERROR = "请求数据有误";
	
	/************************************** 数据有效性 ******************************************/
	
	public final static Boolean DATA_ENABLEDS = true;// 有效(不禁用NO)
	public final static Boolean DATA_DISENABLED = false;// 无效(禁用YES)

}
