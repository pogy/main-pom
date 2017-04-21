package com.shigu.component.common.globality.response;

import com.shigu.component.common.globality.constant.SystemConStant;

/**
 * 统一JSON返回格式
 * @author shigu_zjb
 *
 */
public class ResponseBase {
	
	/**
	 * 返回状态
	 */
	private String status = SystemConStant.RESPONSE_STATUS_FAILED;
	
	/**
	 * 返回数据
	 */
	private Object data;
	
	/**
	 * 返回信息
	 */
	private String msg;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

