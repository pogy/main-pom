package com.shigu.component.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.openJar.commons.MD5Attestation;
import com.openJar.commons.ParamUtil;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.core.config.ApiHttpServletRequest;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Repository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by zf on 2017/6/2.
 */
@Repository("tae_daifaAdminRequestFilter")
public class DaifaAdminReguarFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = req.getServerPort();
        String path = req.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;

        Session session = SecurityUtils.getSubject().getSession();
        Object object = session.getAttribute(DaifaSessionConfig.DAIFA_SYS_SESSION);
        if (object == null) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(basePath + "/init/adminLogin.htm");
            return ;
        }else{
            chain.doFilter(request, response);
            return;
        }
    }

    @Override
    public void destroy() {

    }

}
