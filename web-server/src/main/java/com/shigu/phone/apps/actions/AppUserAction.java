package com.shigu.phone.apps.actions;

import com.openJar.requests.app.*;
import com.openJar.responses.app.BindUserResponse;
import com.shigu.phone.services.PhoneUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    //修改密码
    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject appChangePassword(@Valid ChangePasswordRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.changePassword(request));
    }
    //登录请求
    @RequestMapping("login")
    @ResponseBody
    public JSONObject appLogin( @Valid LoginRequest request, BindingResult bindingResult,HttpServletRequest servletRequest) {
        return JSONObject.fromObject(phoneUserService.login(request,servletRequest));
    }
    //忘记密码
    @RequestMapping("forgetPassword")
    @ResponseBody
    public JSONObject appForgetPassword( @Valid ForgetPasswordRequest request) {
        return JSONObject.fromObject(phoneUserService.forgetPassword(request));
    }

    @RequestMapping("regist")
    @ResponseBody
    public JSONObject appRegist(@Valid RegistRequest request,BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.regist(request));
    }

    @RequestMapping("bindUser")
    @ResponseBody
    public JSONObject appBindUser(@Valid BindUserRequest request, HttpServletRequest httpRequest,BindingResult bindingResult) {
        String remoteAddr = httpRequest.getRemoteAddr();
        BindUserResponse bindUserResponse = phoneUserService.bindUser(request, remoteAddr);
        return JSONObject.fromObject(bindUserResponse);
    }

    //得到验证码
    @RequestMapping("getPhoneMsg")
    @ResponseBody
    public JSONObject appGetPhoneMsg( @Valid GetPhoneMsgRequest request, HttpServletRequest httpRequest) {
        return JSONObject.fromObject(phoneUserService.getPhoneMsg(request));
    }

    /**
     * 修改用户头像
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping("imgUpload")
    @ResponseBody
    public JSONObject upToWx(@Valid ImgUploadRequest request, BindingResult bindingResult) {
        return JSONObject.fromObject(phoneUserService.imgUpload(request));
    }
}
