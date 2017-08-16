package com.shigu.resolver;

import com.opentae.common.beans.LogUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
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

		String requestUrl = request.getRequestURI();

		// 接口异常处理

		//html端.json异常处理
		if(requestUrl.endsWith(".json")){
			return htmlJsonErrorHandle(request, response, ex);
		}

		// 程序其他异常
		return systemErrorHandle(request, response, arg2, ex);
	}

	private static boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		return StringUtils.equals(requestedWith, "XMLHttpRequest");
	}

	public ModelAndView systemErrorHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex) {
		logger.error("错误:"+ex,ex);
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "系统异常");
		model.setViewName("500");
		if(ex instanceof DaifaException) {
			model.addObject("msg", ex.getMessage());

		}
		return model;
	}
	public ModelAndView htmlJsonErrorHandle(HttpServletRequest request, HttpServletResponse response,Exception ex){

		ModelAndView view=new ModelAndView();
		logger.error("ajax错误:"+ex,ex);
		JSONObject obj=new JSONObject();


		obj.put("result","error");
		obj.put("msg","系统异常");
		if(ex instanceof DaifaException){
			obj.put("msg",ex.getMessage());
		}
		String jsonString=obj.toString();
		if (request.getParameter("callback") != null) {
			response.setContentType("application/x-javascript");
			response.setCharacterEncoding("UTF-8");
			jsonString = request.getParameter("callback") + "(" + jsonString + ");";
		}
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter writer = response.getWriter();

			writer.print(jsonString);
			writer.flush();
			writer.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
		return view;

	}
}
