package com.shigu.phone.apps.actions;

import com.openJar.requests.app.AboutMeRequest;
import com.openJar.requests.app.BindUserRequest;
import com.openJar.requests.app.ChangePasswordRequest;
import com.openJar.requests.app.RegistRequest;
import com.shigu.phone.services.PhoneUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 类名：AppUserAction
 * 类路径：com.shigu.phone.apps.actions.AppUserAction
 * 创建者：王浩翔
 * 创建时间：2017-08-31 16:56
 * 项目：main-pom
 * 描述：app端用户
 */
@Controller
@RequestMapping("app/")
public class AppUserAction {

    @Autowired
    private PhoneUserService phoneUserService;

    @RequestMapping("aboutMe")
    @ResponseBody
    public JSONObject aboutMe(@Valid AboutMeRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.aboutMe(request));
    }


    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject appChangePassword(@Valid ChangePasswordRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.changePassword(request));
    }

    @RequestMapping("regist")
    @ResponseBody
    public JSONObject appRegist(@Valid RegistRequest request,BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.regist(request));
    }

    @RequestMapping("bindUser")
    @ResponseBody
    public JSONObject appBindUser(@Valid BindUserRequest request,BindingResult bindingResult) {
        return null;
    }


}
