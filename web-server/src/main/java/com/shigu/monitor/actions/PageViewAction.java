package com.shigu.monitor.actions;

import com.shigu.main4.monitor.bo.PageInfoBO;
import com.shigu.main4.monitor.services.BrowerMonitorService;
import com.shigu.main4.monitor.vo.ClientMsg;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxc on 2017/3/22.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Controller
@RequestMapping("/monitor/")
public class PageViewAction {

    private static final Logger logger = LoggerFactory.getLogger(PageViewAction.class);

    @Autowired
    private BrowerMonitorService browerMonitorService;

    @RequestMapping("in_page")
    public String inPageView(PageInfoBO info, HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("text/javascript");
        String type = "other";
        String url = info.getUrl();
        if (StringUtils.isNotEmpty(url)) {
            String hostUrl = url.replace("http://", "").replace("https://", "");
            String webSite = hostUrl.split("\\.")[0];
            if ("www".equals(webSite)) {
                webSite = "hz";
            }
            info.setWebSite(webSite);
            Map<String, String> params = getParams(hostUrl);
            String id = params.get("id");
            Long idLong = null;
            try {
                idLong = Long.valueOf(id);
            } catch (NumberFormatException ignored) {
            }
            String path = params.get("path");
            if ("/item.htm".equals(path)) {
                type = "item";
                info.setItemId(idLong);
            } else if ("/shop.htm".equals(path)){
                type = "shop";
                info.setShopId(idLong);
            }
        }

        ClientMsg client = new ClientMsg();
        UserAgent agent = HttpRequestUtil.getUserAgent(request);
        Browser browser = agent.getBrowser();
        Version browserVersion = agent.getBrowserVersion();
        if (browserVersion != null) {
            client.setClientBrowerVersion(browserVersion.getVersion());
        }
        if (browser != null) {
            client.setClientBrower(browser.getName());
        }
        client.setClientIp(HttpRequestUtil.getIpAddr(request));
        OperatingSystem operatingSystem = agent.getOperatingSystem();
        if (operatingSystem != null) {
            client.setClientOs(operatingSystem.getName());
        }

        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }

        String idKey = browerMonitorService.inPage(type, userId, info, client);
        model.addAttribute("idKey", idKey);
        logger.debug("pv-type=" + type + ", id=" + idKey);
        return "monitor/pv";
    }

    private Map<String, String> getParams(String url) {
        Map<String, String> params = new HashMap<>();
        String[] path$param = url.split("\\?");
        String path = path$param[0];
        int index = path.indexOf("/");
        if (index >=0){
            path = path.substring(index);
        }
        params.put("path", path);
        if(path$param.length < 2){
            return params;
        }
        String s = path$param[1];
        for (String kvs : s.split("&")) {
            String[] kv = kvs.split("=");
            if (kv.length == 2)
                params.put(kv[0], kv[1]);
        }
        return params;
    }

    @RequestMapping("out_page")
    public void outPage(String idKey, HttpServletResponse response) {
        boolean state = browerMonitorService.outPage(idKey);
        logger.debug(idKey + " close record:" + state);
        response.setStatus(204);
    }
}
