package com.shigu.component.shiro.filters;

import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 店铺用户过滤器
 * Created by zhaohongbo on 17/2/25.
 */
public class ShopFilter extends MemberFilter implements Filter {
    /**
     * 未登陆时跳的地址
     */
    private String unauthorizedUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!hasLogin((HttpServletRequest)servletRequest,(HttpServletResponse)servletResponse)) {
            return;
        }
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.hasRole(RoleEnum.STORE.getValue())){
            HttpServletResponse response= (HttpServletResponse) servletResponse;
            response.sendRedirect(unauthorizedUrl);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }
}
