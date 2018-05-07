package com.shigu.component.shiro.filters;


import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
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
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * 普通会员登陆过滤
 * Created by zhaohongbo on 17/2/9.
 */
public class MemberFilter implements Filter {
    /**
     * 登陆地址
     */
    private String loginUrl;
    /**
     * 登陆成功后的地址
     */
    private String successUrl;

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(checkedLogin(servletRequest,servletResponse,filterChain)){
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    public boolean checkedLogin(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(hasLogin((HttpServletRequest)servletRequest,(HttpServletResponse)servletResponse)){
            //如果是店家,跳店家首页
            String uri=((HttpServletRequest) servletRequest).getRequestURI();
            Subject currentUser = SecurityUtils.getSubject();
            if(currentUser.hasRole(RoleEnum.STORE.getValue())&&uri.startsWith("/member/")&&uri.endsWith(".htm")){
                HttpServletResponse response= (HttpServletResponse) servletResponse;
                response.sendRedirect("/seller/index.htm");
                return false;
            }else if(currentUser.hasRole(RoleEnum.STORE.getValue())&&uri.startsWith("/order/")&&uri.endsWith(".htm")
                    &&!uri.contains("order/alipayByApplyId")){//支付页面除外
                HttpServletResponse response= (HttpServletResponse) servletResponse;
                response.sendRedirect("/seller/index.htm");
                return false;
            }else{
                return true;
            }
        }
        return false;
    }


    /**
     * 登陆判断
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public boolean hasLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Session session = SecurityUtils.getSubject().getSession();
        Object auth=session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(auth==null) {
            String url=request.getRequestURL().toString();
            if(url.endsWith(".json")||url.endsWith(".action")){
                String jsonString = JSONObject.fromObject("{'result':'error','msg':'请先登陆'}").toString();
                response.setCharacterEncoding("UTF-8");
                if (request.getParameter("callback") != null) {
                    response.setContentType("application/x-javascript");//jsonp异常响应处理
                    jsonString = request.getParameter("callback") + "(" + jsonString + ");";
                } else {
                    response.setContentType("application/json");//修复post异常信息未被解析为json
                }
                PrintWriter writer;
                try {
                    writer = response.getWriter();
                    writer.print(jsonString);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                String queryString=request.getQueryString();
                response.sendRedirect(loginUrl + "?backUrl=" + URLEncoder.encode(url+
                        (queryString==null?"":("?"+queryString)), "utf-8"));
            }
            return false;
        }else{
            return true;
        }
    }

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
