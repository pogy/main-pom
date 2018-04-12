package com.shigu.component.shiro.filters;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zf on 2017/6/2.
 */
@Repository("tae_helpRequestFilter")
public class HelpReguarFilter implements Filter {
    @Value("${help.center.session}")
    private String helpCenterSession;
    @Value("${help.center.login}")
    private String helpCenterLogin;
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session session = SecurityUtils.getSubject().getSession();
        Object object = session.getAttribute(helpCenterSession);
        if (object == null) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(helpCenterLogin);
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
