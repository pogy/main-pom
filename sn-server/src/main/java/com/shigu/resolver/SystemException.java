package com.shigu.resolver;

import com.openJar.exceptions.OpenException;

public class SystemException extends OpenException{
	
	private static final long serialVersionUID = 6086310317589930448L;

	private String code;
	private String msg;

	public SystemException() {
	}

	public SystemException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public SystemException(String msg) {
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
