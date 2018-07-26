package com.shigu.core.config;

import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by gtx on 2018/7/25.
 *
 * @author gtx
 * @since
 */
public class GlobalInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisIO redisIO;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        Boolean inviteRebateActive = Boolean.parseBoolean(redisIO.get("activity_order_invite", String.class));
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("inviteRebateActive",inviteRebateActive ? 1 : 0);//邀请有礼活动开关

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
