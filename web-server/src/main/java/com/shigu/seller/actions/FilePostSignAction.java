package com.shigu.seller.actions;

import com.shigu.main4.tools.OssIO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 文件直传 返回签名
 * Created by Administrator on 2017/7/25.
 */
@Controller
public class FilePostSignAction {
    @Autowired
    private OssIO ossIO;

    @RequestMapping("file/getSignInfo")
    public String getPostSign( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long userId = getUserId(request.getSession());
        Map<String, String> infoMap = ossIO.createPostSignInfo(userId);
        JSONObject jsonInfo = JSONObject.fromObject(infoMap);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");

        String callbackFunName = request.getParameter("callback");
        if (callbackFunName==null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(jsonInfo.toString());
        else
            response.getWriter().println(callbackFunName + "( "+jsonInfo.toString()+" )");
        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
        return null;
    }

    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    private Long getUserId(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getUserId();
    }

}
