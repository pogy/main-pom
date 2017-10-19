package com.shigu.phone.apps.actions;

import com.shigu.buyer.actions.UserLoginAction;
import com.shigu.phone.apps.services.PhoneUserService;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 类名：OrtherLoginAction
 * 类路径：com.shigu.phone.apps.actions.OrtherLoginAction
 * 创建者：任真飞
 * 创建时间：2017-10-16 17:05
 * 项目：main-pom
 * 描述：第三方淘宝登录
 */
@Controller
public class OrtherLoginAction {
    private static final Logger logger = Logger.getLogger(OrtherLoginAction.class);
    @Autowired
    private PhoneUserService phoneUserService;
    //第三方登录
    @RequestMapping("phoneOrtherLogin")
    public String passwordLogin(String nick, String key,Integer type){
        try {//为什么decode来decode去,不知道,返回照做
            String name= URLDecoder.decode(URLDecoder.decode(nick,"utf-8"),"utf-8");
            String userNick= URLEncoder.encode(URLEncoder.encode(name, "utf-8"), "utf-8");
            String url="alidao://sjxz/taobao/author?userNick="+userNick;
            return "redirect:"+url;
        } catch (UnsupportedEncodingException e1) {
            logger.error("用户名转义出错",e1);
        }
        return "";
    }
}