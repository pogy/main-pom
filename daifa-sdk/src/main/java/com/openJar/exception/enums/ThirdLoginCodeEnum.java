package com.openJar.exception.enums;

/**
 * 统一接口枚举信息
 * @author zjb
 * @date 2016/6/17 10:21
 *
 */
public enum ThirdLoginCodeEnum {

	NOTEXIST(1, "WORKER_NOT_EXIST", "该工作号不存在~~安拉胡阿克巴");



	// 成员变量
	private int index;
	private String code;
	private String msg;

	// 构造方法
	private ThirdLoginCodeEnum(int index, String code, String msg) {
		this.msg = msg;
		this.index = index;
		this.code = code;
	}

	// 普通方法
	public static String getmsg(int index) {
		for (ThirdLoginCodeEnum c : ThirdLoginCodeEnum.values()) {
			if (c.getIndex() == index) {
				return c.msg;
			}
		}
		return null;
	}

	// get set 方法
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
