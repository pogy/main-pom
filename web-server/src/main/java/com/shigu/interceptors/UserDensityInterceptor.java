package com.shigu.interceptors;

import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户密度过滤器
 * 如果用户信息不存在,直接放过
 * Created by zhaohongbo on 17/4/17.
 */
public class UserDensityInterceptor extends DensityInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PersonalSession ps= (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null) {//没用户不拦截
            return false;
        }
        primaryKey="userId_"+ps.getUserId();
        return super.preHandle(request, response, handler);
    }
}
