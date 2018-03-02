package com.shigu.resolver;

import com.openJar.requests.Request;
import com.openJar.responses.Response;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 只有功能性错误才会把错误返回给子集
 * @author zhaohongbo
 *
 */
public class HtmlException extends Exception{
	private String errorPackage;
	private String type;//system-exception  (系统错误，访问不到，或者类参数异常) 或者 function-exception（功能性错误）
	private String code;
	private String errMsg;
	private String errCodeMsg;
	private String paramstr;//发出的参数
	/**
	 * 用户自定义方法
	 * @param res
	 */
	public void userDefine(Response res){
		
	}
	/**
	 * 自动计算传入参数
	 * @param res
	 */
	public void toParamStr(Request req){
		 Class<?> c=req.getClass();
		 Field[] fs=c.getDeclaredFields();
		 paramstr=c.getCanonicalName()+"^_^";
		 for(Field f:fs){
			 if("signOpenApi".equals(f.getName())){
					continue;
				}
				if(f.getModifiers()==2){//只匹配 private
					Method m;
					try {
						m = (Method) c.getMethod("get"+methodName(f.getName()));
						Object val = m.invoke(req);// 调用getter方法获取属性值
						if(val!=null){
							paramstr+=f.getName()+":"+val.toString()+",";
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
		 }
	}
	
	/**
	 * 计算取属性的方法名
	 * @param fieldName
	 * @return
	 */
	private String methodName(String fieldName){
		if(fieldName==null||"".equals(fieldName)){
			return fieldName;
		}
		if(fieldName.length()==1){
			return fieldName.toUpperCase();
		}
		return fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	}
	
	public String getErrorPackage() {
		return errorPackage;
	}
	public void setErrorPackage(String errorPackage) {
		this.errorPackage = errorPackage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrCodeMsg() {
		return errCodeMsg;
	}
	public void setErrCodeMsg(String errCodeMsg) {
		this.errCodeMsg = errCodeMsg;
	}
	public String getParamstr() {
		return paramstr;
	}
	public void setParamstr(String paramstr) {
		this.paramstr = paramstr;
	}
	
}
