package com.shigu.component.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author ThinkPad
 *
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {


    private static final Logger log = LoggerFactory
            .getLogger(CaptchaFormAuthenticationFilter.class);


    /**
     * 所有请求都会经过的方法。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        if (!"XMLHttpRequest"
                .equalsIgnoreCase(((HttpServletRequest) request)
                        .getHeader("X-Requested-With"))) {// 不是ajax请求
            saveRequestAndRedirectToLogin(request, response);
        } else {
            response.setCharacterEncoding("UTF-8");
           //ajax请求
        }
        return false;
    }
}
