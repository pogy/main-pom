package com.shigu.component.common;

import java.io.Serializable;

/**
 * 统一返回JSON
 * @author shigu_zjb
 * @version 1.0
 * @time 2016/7/5 13:20
 *
 */
public class ResponseBase implements Serializable{

	private static final long serialVersionUID = -2655264209045522873L;
	
	/**
	 * 状态
	 */
	private String status = SystemConstant.RESPONSE_STATUS_FAILED;
	
	/**
	 * 信息描述
	 */
	private String msg;
	
	/**
	 * 数据
	 */
	private Object data;

	private String result;
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
