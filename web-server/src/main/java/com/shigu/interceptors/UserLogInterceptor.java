package com.shigu.interceptors;

import com.opentae.data.mana.beans.UserAction;
import com.opentae.data.mana.interfaces.UserActionMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserLogInterceptor extends DensityInterceptor {

    @Autowired
    UserActionMapper userActionMapper;

    @Value("${interceptor.list}")
    String urlList;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String[] urls = urlList.split(",");
        List<String> list = Arrays.asList(urls);
        String url = request.getRequestURI().toString();
        if (list.contains(url)) {
            HandlerMethod h = (HandlerMethod) handler;
            PersonalSession ps = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps != null) {
                UserAction userAction = new UserAction.Builder().setTime(0).setUserId(ps.getUserId()).
                        setAction(h.getMethod().getName()).setIp(getIpAddr(request)).setUrl(request.getRequestURI()).
                        setParams(getParamString(request.getParameterMap())).setType(1).create();
                int i = userActionMapper.insert(userAction);
                if (i < 0) {
                    throw new Main4Exception("操作记录保存失败");
                }
            } else {
                String queryString = request.getQueryString();
                response.sendRedirect("http://www.571xz.com/login.htm?backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                        (queryString == null ? "" : ("?" + queryString)), "utf-8"));
            }
        }
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        return ip;
    }
}
