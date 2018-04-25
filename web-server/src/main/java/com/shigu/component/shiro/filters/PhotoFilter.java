package com.shigu.component.shiro.filters;

import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 路径: com.shigu.component.shiro.filters.PhotoFilter
 * 工程: main-pom
 * 时间: 18-4-25 上午10:21
 * 创建人: wanghaoxiang
 * 描述: 摄影基地权限过滤
 */
public class PhotoFilter extends MemberFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 先进行登陆拦截
        super.doFilter(servletRequest, servletResponse, filterChain);

    }

    public Integer hasPhotoAuth(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        Integer photoAuthType = null;
        HttpSession session = request.getSession();
        //来到这里的都是进行过登陆判断的，所以实际session不会为空
        if (session != null) {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
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
}
