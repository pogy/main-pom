package com.shigu.component.shiro.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 发短信的IP限制
 * Created by zhaohongbo on 17/3/1.
 */
public class MsgLimitFilter implements Filter {
    /**
     * 多少次内
     */
    private int startNum;
    /**
     * 限制的秒数
     */
    private int limitSecond;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
