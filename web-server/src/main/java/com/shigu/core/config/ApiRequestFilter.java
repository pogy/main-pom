package com.shigu.core.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.openJar.commons.MD5Attestation;
import com.openJar.commons.ParamUtil;
import com.openJar.commons.ResponseUtil;
import com.openJar.exceptions.SignErrorException;
import com.shigu.api.exceptions.SystemException;
import com.shigu.api.responses.SystemResponse;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.apps.utils.TokenUtil;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhaohongbo on 16/6/13.
 */
@Repository("tae_apiRequestFilter")
public class ApiRequestFilter implements Filter {
    @Autowired
    RedisIO redisIO;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String,String[]> m = new HashMap<String,String[]>(request.getParameterMap());
        request = new ApiHttpServletRequest((HttpServletRequest)request, m);
        String request_json_str_=request.getParameter("request_json_str_");
        if(request_json_str_==null){
//            throw exception;
            writeFalseToResponse(response);
            return;
        }
        JsonParser parse = new JsonParser();
        JsonObject jobj = (JsonObject)parse.parse(request_json_str_);
        HashMap param = new HashMap();
        try {
            String e = jobj.get("signOpenApi").getAsString();
            jobj.addProperty("signOpenApi", "");
            param.put("request_json_str_", jobj.get("timeOpenApi").getAsString());
            Map param1 = ParamUtil.getMap("", jobj, param);
            boolean sign = MD5Attestation.unsignParamString(param1, e);
            if(!sign) {
                writeFalseToResponse(response);
                return;
            }
        } catch (Exception e1) {
            writeFalseToResponse(response);
            return;
        }
        Set<Map.Entry<String,JsonElement>> set=jobj.entrySet();
        Iterator<Map.Entry<String,JsonElement>> it=set.iterator();
        while(it.hasNext()){
            Map.Entry<String,JsonElement> entry=it.next();
            String key=entry.getKey();
            m.putAll(dealObject(key,entry.getValue()));
            if(key.equals("token")){
                try {
                    Long userId=parseUserId(entry.getValue().getAsString());
                    String[] userIds={userId+""};
                    m.put("userId",userIds);
                } catch (SystemException e) {
                    writeFalseToResponse(response,e);
                    return;
                }
            }
        }
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 处理JsonObject对象
     * @param fatherobj
     * @return
     */
    public Map<String,String[]> parseJsonObject(String fatherkey,JsonObject fatherobj){
        Set<Map.Entry<String,JsonElement>> set=fatherobj.entrySet();
        Iterator<Map.Entry<String,JsonElement>> it=set.iterator();
        Map<String,String[]> allparams=new HashMap<String, String[]>();
        while(it.hasNext()){
            Map.Entry<String,JsonElement> entry=it.next();
            String key=fatherkey+"."+entry.getKey();
            allparams.putAll(dealObject(key,entry.getValue()));
        }
        return allparams;
    }

    /**
     * 处理JsonArray对象
     * @param arr
     * @return
     */
    public Map<String,String[]> parseJsonArray(String key,JsonArray arr){
        Map<String,String[]> allparams=new HashMap<String, String[]>();
        for (int i=0;i<arr.size();i++){
            String hereKey=key+"["+i+"]";
            JsonElement el=arr.get(i);
            allparams.putAll(dealObject(hereKey,el));
        }
        return allparams;
    }

    /**
     * 处理一个json元素
     * @param key
     * @param el
     * @return
     */
    private Map<String,String[]> dealObject(String key,JsonElement el){
        Map<String,String[]> allparams=new HashMap<>();
        if(el.isJsonArray()){
            JsonArray jarr= (JsonArray) el;
            Map<String,String[]> pentry=parseJsonArray(key,jarr);
            allparams.putAll(pentry);
        }else if(el.isJsonNull()){
            //空的直接不要了
        }else if(el.isJsonObject()){
            JsonObject obj= (JsonObject) el;
            Map<String,String[]> pentry=parseJsonObject(key,obj);
            allparams.putAll(pentry);
        }else if(el.isJsonPrimitive()){
            String[] params={el.getAsString()};
            allparams.put(key, params);
        }
        return allparams;
    }



    public void destroy() {

    }

    /**
     * 返回错误结果
     * @param response
     * @throws IOException
     */
    private void writeFalseToResponse(ServletResponse response) throws IOException {
        SystemException e= new SystemException();
        e.setErrMsg("验签失败");
        writeFalseToResponse(response,e);
    }
    private void writeFalseToResponse(ServletResponse response,SystemException e) throws IOException {
        SystemResponse rsp = new SystemResponse();
        rsp.setSuccess(false);
        rsp.setException(e);
        response.getWriter().print(JSONObject.fromObject(ResponseUtil.dealResponse(rsp).toString()));
    }


    private Long parseUserId(String token) throws SystemException {
        if(StringUtils.isEmpty(token)){
            SystemException e= new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        String str= TokenUtil.parse(token);
        if(StringUtils.isEmpty(str)){
            SystemException e= new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        Long userId=new Long(str.split(",")[1]);
        String oldToken=redisIO.get("phone_login_token"+userId);
        if(oldToken==null||!token.equals(oldToken)){
            SystemException e= new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        return userId;
    }
}
