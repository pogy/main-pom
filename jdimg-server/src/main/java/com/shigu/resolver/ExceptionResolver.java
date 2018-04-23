package com.shigu.resolver;

import com.alibaba.fastjson.JSON;
import com.openJar.exceptions.OpenException;
import com.opentae.common.beans.LogUtil;
import com.shigu.exceptions.JdAuthOverdueException;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异常拦截
 * 
 * @author wxc
 * @date 2016年6月15日 上午11:21:14
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Logger log = LogUtil.getLog(ExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex) {
		// 程序其他异常
		return systemErrorHandle(request, response, arg2, ex);
	}


	public ModelAndView systemErrorHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex) {
		JSONObject obj=new JSONObject();
		if(ex instanceof OpenException){
			OpenException e1=(OpenException)ex;
			JSONObject ex1=JSONObject.fromObject(e1);
			obj.put("exception", ex1);
		}else{
			JSONObject ex1=new JSONObject();
			if(ex instanceof JdAuthOverdueException){
                ex1.put("errMsg", "授权失效");
                ex1.put("code","01");
            }else{
                ex1.put("errMsg", ex.getMessage());
                ex1.put("code","02");
            }
			obj.put("exception", ex1);
		}
		// 判断请求类型
			// Ajax请求
		obj.put("success", false);
		String jsonStr = JSON.toJSONString(obj);
		System.out.println(jsonStr);
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonStr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
