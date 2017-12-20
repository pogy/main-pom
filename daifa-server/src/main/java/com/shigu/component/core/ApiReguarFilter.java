package com.shigu.component.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.openJar.commons.MD5Attestation;
import com.openJar.commons.ParamUtil;
import com.shigu.core.config.ApiHttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by zf on 2017/6/2.
 */
@Repository("tae_apiRequestFilter")
public class ApiReguarFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, String[]> m = new HashMap<String, String[]>(request.getParameterMap());
        request = new ApiHttpServletRequest((HttpServletRequest) request, m);
        String request_json_str_ = request.getParameter("request_json_str_");
        if (request_json_str_ == null) {
            response.getWriter().print(signErr().toString());
            return;
        }
        JsonParser parse = new JsonParser();
        JsonObject jobj = (JsonObject) parse.parse(request_json_str_);
        HashMap param = new HashMap();
        try {
            String e = jobj.get("signOpenApi").getAsString();
            jobj.addProperty("signOpenApi", "");
            param.put("request_json_str_", jobj.get("timeOpenApi").getAsString());
            Map param1 = ParamUtil.getMap("", jobj, param);
            boolean sign = MD5Attestation.unsignParamString(param1, e);
            if (!sign) {
                response.getWriter().print(signErr().toString());
                return;
            }
        } catch (Exception e1) {
            response.getWriter().print(signErr().toString());
            return;
        }
        Set<Map.Entry<String, JsonElement>> set = jobj.entrySet();
        Iterator<Map.Entry<String, JsonElement>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, JsonElement> entry = it.next();
            String key = entry.getKey();
            if (entry.getValue().isJsonArray()) {
                JsonArray jarr = (JsonArray) entry.getValue();
                Map<String, String[]> pentry = parseJsonArray(key, jarr);
                m.putAll(pentry);
            } else if (entry.getValue().isJsonNull()) {
                // 空的直接不要了
            } else if (entry.getValue().isJsonObject()) {
                JsonObject obj = (JsonObject) entry.getValue();
                Map<String, String[]> pentry = parseJsonObject(key, obj);
                m.putAll(pentry);
            } else if (entry.getValue().isJsonPrimitive()) {
                String[] params = { entry.getValue().getAsString() };
                m.put(key, params);
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 处理JsonObject对象
     *
     * @param fatherobj
     * @return
     */
    public Map<String, String[]> parseJsonObject(String fatherkey, JsonObject fatherobj) {
        Set<Map.Entry<String, JsonElement>> set = fatherobj.entrySet();
        Iterator<Map.Entry<String, JsonElement>> it = set.iterator();
        Map<String, String[]> allparams = new HashMap<String, String[]>();
        while (it.hasNext()) {
            Map.Entry<String, JsonElement> entry = it.next();
            String key = fatherkey + "." + entry.getKey();
            if (entry.getValue().isJsonArray()) {
                JsonArray jarr = (JsonArray) entry.getValue();
                Map<String, String[]> pentry = parseJsonArray(key, jarr);
                allparams.putAll(pentry);
            } else if (entry.getValue().isJsonNull()) {
                // 空的直接不要了
            } else if (entry.getValue().isJsonObject()) {
                JsonObject obj = (JsonObject) entry.getValue();
                Map<String, String[]> pentry = parseJsonObject(key, obj);
                allparams.putAll(pentry);
            } else if (entry.getValue().isJsonPrimitive()) {
                String[] params = { entry.getValue().getAsString() };
                allparams.put(key, params);
            }
        }
        return allparams;
    }

    /**
     * 处理JsonArray对象
     *
     * @param arr
     * @return
     */
    public Map<String, String[]> parseJsonArray(String key, JsonArray arr) {
        Map<String, String[]> allparams = new HashMap<String, String[]>();
        List<String> arrList = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++) {
            String hereKey = key + "[" + i + "]";
            JsonElement el = arr.get(i);
            if (el.isJsonArray()) {
                JsonArray jarr = (JsonArray) el;
                Map<String, String[]> pentry = parseJsonArray(hereKey, jarr);
                allparams.putAll(pentry);
            } else if (el.isJsonNull()) {
                // 空的直接不要了
            } else if (el.isJsonObject()) {
                JsonObject obj = (JsonObject) el;
                Map<String, String[]> pentry = parseJsonObject(hereKey, obj);
                allparams.putAll(pentry);
            } else if (el.isJsonPrimitive()) {
                String[] params = { el.getAsString() };
                allparams.put(hereKey, params);
            }
        }
        return allparams;
    }

    private JSONObject signErr(){
        JSONObject res=new JSONObject();
        res.put("success",false);
        JSONObject exc=new JSONObject();
        exc.put("msg","验签错误");
        res.put("exception",exc);
        return res;
    }

    public void destroy() {

    }
}
