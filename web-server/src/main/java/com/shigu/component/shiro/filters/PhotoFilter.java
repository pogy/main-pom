package com.shigu.component.shiro.filters;

import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * 路径: com.shigu.component.shiro.filters.PhotoFilter
 * 工程: main-pom
 * 时间: 18-4-25 上午10:21
 * 创建人: wanghaoxiang
 * 描述: 摄影基地权限过滤
 */
public class PhotoFilter extends MemberFilter implements Filter {

    //摄影基地用户认证地址
    private String photoAuthenticationUrl;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 先进行登陆拦截
        if(!super.checkedLogin(servletRequest, servletResponse, filterChain)){
            return;
        }
        Integer photoAuth = getPhotoAuth();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        //没有进行摄影基地身份认证
        if (photoAuth == null || photoAuth == 0) {
            if (url.endsWith(".json") || url.endsWith(".action")) {
                String errorJson = JSONObject.fromObject("{'result':'error','msg':'请先进行身份认证'}").toString();
                response.setCharacterEncoding("UTF-8");
                if (request.getParameter("callback") != null) {
                    response.setContentType("application/x-javascript");//jsonp异常响应处理
                    errorJson = request.getParameter("callback") + "(" + errorJson + ");";
                } else {
                    response.setContentType("application/json");//修复post异常信息未被解析为json
                }
                PrintWriter writer;
                try {
                    writer = response.getWriter();
                    writer.print(errorJson);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String queryString = request.getQueryString();
                response.sendRedirect(photoAuthenticationUrl + "?backUrl" + URLEncoder.encode(url + (queryString == null ? "" : ("?" + queryString)), "utf-8"));
            }
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public Integer getPhotoAuth() {
        Integer photoAuthType = null;
        Session session = SecurityUtils.getSubject().getSession();
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //来到这里的都是进行过登陆判断的，所以实际session不会为空
        if (ps != null) {
            photoAuthType = (Integer) ps.getOtherPlatform().get(OtherPlatformEnum.PHOTO_AUTH.getValue());
        }
        return photoAuthType;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    public String getPhotoAuthenticationUrl() {
        return photoAuthenticationUrl;
    }

    public void setPhotoAuthenticationUrl(String photoAuthenticationUrl) {
        this.photoAuthenticationUrl = photoAuthenticationUrl;
    }
}
