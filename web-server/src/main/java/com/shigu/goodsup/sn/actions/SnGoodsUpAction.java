package com.shigu.goodsup.sn.actions;

import com.openJar.beans.SnAuthInfo;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Map;

@Controller
@RequestMapping("sn")
public class SnGoodsUpAction {

    @Autowired
    private MemberFilter memberFilter;

    @Value("${sn.app.key}")
    private String SN_appkey;
    @Value("${sn.app.secret}")
    private String SN_appsecret;
    @Value("${sn.redirect_uri}")
    private String SN_redirect_uri;

    private static final String SN_Outh_URL = "https://open.suning.com/api/oauth/authorize?response_type=code&client_id=SN_appkey&redirect_uri=SN_redirect_uri&itemcode=1";

    /**
     * 上传页面
     */
    @RequestMapping("publish")
    public String publish(Long itemId, HttpServletRequest request, HttpSession session, Map<String, Object> map) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getLoginFromType() != LoginFromType.SN) {
                String queryString = request.getQueryString();
                return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=7&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                        (queryString == null ? "" : ("?" + queryString)), "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errmsg", "该商品暂不支持上传");
            return "suning/uperror";
        }
        return "suning/sn";
    }

    /**
     * 苏宁登入页
     *
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        String url = SN_Outh_URL.replace("SN_appkey", SN_appkey).replace("SN_redirect_uri", SN_redirect_uri);
        if(HttpRequestUtil.checkAgentIsMobile(request)){
            url += "view=wap";
        }
        return "redirect:" + url;
    }

    @RequestMapping("callback")
    public String SnCallback(String code, HttpServletRequest request, HttpSession session){
//        System.out.println(code);
        String backUrl= (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
        session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
        return "redirect:"+loginSuccessUrl(backUrl);
    }

    /**
     * 得到登陆成功链接
     * @param backUrl
     * @return
     */
    private String loginSuccessUrl(String backUrl){
        String toUrl;
        if(backUrl!=null&&!"http://www.571xz.com/".equals(backUrl)){//TODO 首页的,等页面改好,这里再去掉
            toUrl=backUrl;
        }else{
            //如果个人,跳到这个,如果商户跳到seller
            toUrl=memberFilter.getSuccessUrl();
        }
        return toUrl;
    }
}
