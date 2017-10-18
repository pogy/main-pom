package com.shigu.phone.apps.actions;

import com.openJar.requests.app.OrtherLoginRequest;
import com.shigu.phone.apps.services.PhoneUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：OrtherLoginAction
 * 类路径：com.shigu.phone.apps.actions.OrtherLoginAction
 * 创建者：任真飞
 * 创建时间：2017-10-16 17:05
 * 项目：main-pom
 * 描述：第三方登录
 */
@Controller
public class OrtherLoginAction {
    @Autowired
    private PhoneUserService phoneUserService;
    //第三方登录
    @RequestMapping("phoneOrtherLogin")
    public String passwordLogin(String nick,String key,Integer type){
        OrtherLoginRequest request=new OrtherLoginRequest();
        request.setType(type);
        request.setNick(nick);
        request.setKey(key);
        String url=phoneUserService.ortherLogin(request);
        return "redirect:"+url;
    }
}