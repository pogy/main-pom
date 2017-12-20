package com.openJar.exception;

import com.openJar.exceptions.OpenException;

/**
 * 自定义接口统一异常
 * @author shigu_zjb
 *
 */
public class SystemInterfaceException extends OpenException {
	
	private static final long serialVersionUID = 6086310317589930448L;
	
	private String code;
	private String msg;

	public SystemInterfaceException() {
		
	}

	public SystemInterfaceException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public SystemInterfaceException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
