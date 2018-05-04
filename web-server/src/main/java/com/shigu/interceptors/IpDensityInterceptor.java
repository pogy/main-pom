package com.shigu.interceptors;

import com.shigu.tools.HttpRequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * IP密度过滤器
 * Created by zhaohongbo on 17/4/17.
 */
public class IpDensityInterceptor extends DensityInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String ip=request.getRemoteHost();
        String ip = HttpRequestUtil.getIpAddr(request);
        primaryKey = "ip_" + ip;
        return super.preHandle(request, response, handler);
    }

}
