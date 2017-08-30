package com.shigu.component.core;

import com.opentae.common.beans.LogUtil;
import com.shigu.config.DaifaSessionConfig;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Repository;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @类编号
 * @类名称：DaifaAdminRegularFilter
 * @文件路径：com.shigu.component.core.DaifaAdminRegularFilter
 * @内容摘要：代发后台里的都走这里规则
 * @编码作者：zf
 * @创建日期：16/9/30 11:37
 * @commonents:
 */
@Repository("tae_daifaAdminRegularFilter")
public class DaifaAdminRegularFilter implements Filter {
	private static final Logger logger = LogUtil
			.getLog(DaifaAdminRegularFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取项目绝对路径，保证项目路径一致性
		HttpServletRequest req = (HttpServletRequest) request;
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = req.getServerPort();
		String path = req.getContextPath();
		String basePath = scheme + "://" + serverName + ":" + port + path;

		Session session = SecurityUtils.getSubject().getSession();
		Object object = session.getAttribute(DaifaSessionConfig.DAIFA_SESSION);
		if (object == null) {

				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect(basePath + "/init/login.htm");
				return ;
		}else{
			chain.doFilter(request, response);
			return;
		}

	}

	public void destroy() {

	}
}
