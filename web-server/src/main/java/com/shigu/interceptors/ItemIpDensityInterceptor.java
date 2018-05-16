package com.shigu.interceptors;

import com.shigu.tools.HttpRequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 路径: com.shigu.interceptors.ItemIpDensityInterceptor
 * 工程: main-pom
 * 时间: 18-5-15 下午3:45
 * 创建人: wanghaoxiang
 * 描述:
 */
public class ItemIpDensityInterceptor extends DensityInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = HttpRequestUtil.getIpAddr(request);
        primaryKey = "item_added_ip_" + ip;
        return super.preHandle(request, response, handler);
    }
}
