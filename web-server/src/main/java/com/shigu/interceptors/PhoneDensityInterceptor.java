package com.shigu.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 发送手机验证码的拦截器
 * Created by zhaohongbo on 17/4/18.
 */
public class PhoneDensityInterceptor extends DensityInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到手机号
        String phone=request.getParameter("telephone");
        if (phone == null) {//没有手机号,不拦截
            return false;
        }
        primaryKey="phone_"+phone;
        return super.preHandle(request, response, handler);
    }
}
