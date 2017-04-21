package com.shigu.component.shiro.filters;

import com.shigu.session.main4.names.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统会员过滤
 * Created by zhaohongbo on 17/2/9.
 */
public class SysFilter implements Filter {
    /**
     * 登陆地址
     */
    private String loginUrl;
    /**
     * 登陆成功后的地址
     */
    private String successUrl;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session session = SecurityUtils.getSubject().getSession();
        Object sysSessionObj = session.getAttribute(SessionEnum.SYS_USER.getValue());
        if(sysSessionObj != null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getRequestURI().contains(loginUrl)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        response.sendRedirect(loginUrl);
    }

    @Override
    public void destroy() {

    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }
}
