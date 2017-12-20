package com.shigu.resolver;

import com.openJar.exceptions.OpenException;
import com.opentae.common.beans.LogUtil;
import com.shigu.api.responses.SystemResponse;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 异常拦截
 * 
 * @author wxc
 * @date 2016年6月15日 上午11:21:14
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Logger log = LogUtil.getLog(ExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {

	    if(request.getServletPath().contains("/app/")&&request.getServletPath().endsWith(".json")){
            appResolveException(response,ex);
            return null;
        }
        if(request.getServletPath().contains("/waps/")&&request.getServletPath().endsWith(".json")){
            wapResolveException(response,ex);
            return null;
        }
        if(request.getServletPath().contains("/datas/")&&request.getServletPath().endsWith(".json")){
            wapResolveException(response,ex);
            return null;
        }
		if(request.getServletPath().endsWith(".json")){//json类型的问题
			Map<String,Object> otherFields = null;
			if (ex instanceof JsonErrException) {
				otherFields = ((JsonErrException) ex).getErrorMap();
			}
			JSONObject jsonObj=JSONObject.fromObject("{'result':'error'}");
			if(otherFields!=null){
				if(!otherFields.containsKey("msg")){
					jsonObj.element("msg",ex.getMessage());
				}
				jsonObj.accumulateAll(otherFields);
			}else{
				jsonObj.element("msg",ex.getMessage());
			}
			String jsonString = jsonObj.toString();
			response.setCharacterEncoding("UTF-8");
			if (request.getParameter("callback") != null) {
				response.setContentType("application/x-javascript");//jsonp异常响应处理
				jsonString = request.getParameter("callback") + "(" + jsonString + ");";
			} else {
				response.setContentType("application/json");//修复post异常信息未被解析为json
			}
            writer(response,jsonString);
			return null;
		}else if(ex instanceof Main4Exception){//页面已知的错误
			request.setAttribute("errMsg",ex.getMessage());
		}else{//页面未知的错误
			request.setAttribute("errMsg","系统异常");
			ex.printStackTrace();
		}
		//记录异常日志...
		return getModelAndView("500", ex, request);
	}

	private void appResolveException(HttpServletResponse response,Exception ex){
        OpenException exception=new OpenException();
        exception.setErrMsg(ex.getMessage());
        SystemResponse systemResponse=new SystemResponse();
        systemResponse.setSuccess(false);
        systemResponse.setException(exception);
        String jsonString = JSONObject.fromObject(systemResponse).toString();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        writer(response,jsonString);
    }
    private void wapResolveException(HttpServletResponse response,Exception ex){
        SystemResponse systemResponse=new SystemResponse();
        systemResponse.setSuccess(false);
        JSONObject errJson=JSONObject.fromObject(systemResponse);
        errJson.put("msg",ex.getMessage());
        String jsonString = errJson.toString();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        writer(response,jsonString);
    }

    private void writer(HttpServletResponse response,String jsonString){
        try {
            PrintWriter writer = response.getWriter();
            writer.print(jsonString);
            writer.flush();
            writer.close();
        } catch (IOException ignored) {
        }
    }
}
