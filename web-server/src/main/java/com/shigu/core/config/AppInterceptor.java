package com.shigu.core.config;

import com.shigu.api.exceptions.SystemException;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.apps.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

public class AppInterceptor implements HandlerInterceptor {
    @Autowired
    RedisIO redisIO;

    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath();
        if (!url.startsWith("/app/")) {
            return true;
        }
        url = url.replace("/app/", "").split("\\.")[0];
        String classPath = "com.openJar.requests.app." + toUpperCase(url) + "Request";
        Class<?> clazz = Class.forName(classPath);
        Map<String, String[]> map = request.getParameterMap();
        if (checkedHasToken(clazz)) {
            Long userId;
            try {
                userId = parseUserId(request.getParameter("token"));
            } catch (SystemException e) {
                if(checkedTokenIsNotNull(clazz)){
                    ApiRequestFilter.writeFalseToResponse(response, e);
                    return false;
                }
                map.remove("userId");
                map.remove("token");
                return true;
            }
            String[] uid = {userId + ""};
            map.put("userId", uid);
        }else{
            map.remove("userId");
        }
        return true;
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


    private Long parseUserId(String token) throws SystemException {
        if (StringUtils.isEmpty(token)) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        String str = TokenUtil.parse(token);
        if (StringUtils.isEmpty(str)) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        Long userId = new Long(str.split(",")[1]);
        String[] oldTokenStrs = redisIO.get("phone_login_token" + userId).split("@@@@@---@@@@@");
        String oldToken=oldTokenStrs[0];
        if (oldToken == null || !token.equals(oldToken)) {
            SystemException e = new SystemException();
            e.setErrMsg("登录过期");
            throw e;
        }
        Long time=new Long(oldTokenStrs[1]);
        Long time2=new Date().getTime();
        if(time2-time>600000L){
            String uuid=oldToken+"@@@@@---@@@@@"+time2;
            Jedis jedis = redisIO.getJedis();
            jedis.setex("phone_login_token" + userId, 1800, uuid);
        }
        return userId;
    }

    private static String toUpperCase(String str) {
        String s1 = (str.charAt(0) + "").toUpperCase();
        return s1 + (str.substring(1, str.length()));
    }

    private static boolean checkedHasToken(Class class1) {
        String fieldname = "token";
        Field[] fields = class1.getDeclaredFields();
        boolean b = false;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(fieldname)) {
                b = true;
                break;
            }
        }
        return b;
    }

    private static boolean checkedTokenIsNotNull(Class class1){
        String fieldname = "token";
        Field[] fields = class1.getDeclaredFields();
        boolean b = false;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(fieldname) && fields[i].getAnnotation(NotNull.class) != null) {
                b = true;
                break;
            }
        }
        return b;
    }
}
