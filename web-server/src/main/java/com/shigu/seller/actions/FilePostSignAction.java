package com.shigu.seller.actions;

import com.shigu.main4.tools.OssIO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 文件直传 返回签名
 * Created by Administrator on 2017/7/25.
 */
@Controller
public class FilePostSignAction {
    @Autowired
    OssIO ossIO;

    @RequestMapping("file/getSignInfo")
    public String getPostSign( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> infoMap = ossIO.createPostSignInfo();
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

}
