package com.shigu.phone.waps.actions;

import com.openJar.requests.app.*;
import com.openJar.responses.app.BindUserResponse;
import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.apps.services.PhoneUserService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("/wap")
public class WapUserAction {
    @Autowired
    private PhoneUserService phoneUserService;
    @Autowired
    private RedisIO redisIO;
    /**
     * 登陆
     * @param servletRequest
     * @param userName
     * @param pwd
     * @param type
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(HttpServletRequest servletRequest,String userName ,String pwd,Integer type) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(pwd);
        loginRequest.setType(type);
        loginRequest.setUserName(userName);
        return JSONObject.fromObject(phoneUserService.login(loginRequest,servletRequest));
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("regist")
    @ResponseBody
    public JSONObject regist( String telephone,String code,String pwd) {

        RegistRequest registRequest = new RegistRequest();
        registRequest.setCode(code);
        registRequest.setPassword(pwd);
        registRequest.setTelephone(telephone);
        return JSONObject.fromObject(phoneUserService.regist(registRequest));
    }

    @RequestMapping("aboutMe")
    @ResponseBody
    public JSONObject aboutMe(HttpSession session) {
        AboutMeRequest request = new AboutMeRequest();
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        request.setUserId(ps.getUserId());
        return JSONObject.fromObject(phoneUserService.aboutMe(request));
    }

    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject ChangePassword(HttpSession session,String newPwd,String oldPwd) {
        ChangePasswordRequest request = new ChangePasswordRequest();
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String token = redisIO.get("phone_login_token" + ps.getUserId());
        request.setNewPwd(newPwd);
        request.setOldPwd(oldPwd);
        request.setToken(token);
        request.setUserId(ps.getUserId());
        return JSONObject.fromObject(phoneUserService.changePassword(request));
    }


    @RequestMapping("otherLogin")
    @ResponseBody
    public JSONObject ortherLogin(String key,String nick,Integer type) {
        OtherLoginRequest request = new OtherLoginRequest();
        request.setKey(key);
        request.setNick(nick);
        request.setType(type);
        return JSONObject.fromObject(phoneUserService.otherLogin(request));
    }

    @RequestMapping("forgetPassword")
    @ResponseBody
    public JSONObject ForgetPassword(String msgCode,String password,String telephone) {
        ForgetPasswordRequest request = new ForgetPasswordRequest();
        request.setMsgCode(msgCode);
        request.setNewPassword(password);
        request.setTelephone(telephone);
        return JSONObject.fromObject(phoneUserService.forgetPassword(request));
    }

    @RequestMapping("bindUser")
    @ResponseBody
    public JSONObject appBindUser( HttpServletRequest httpRequest,String code,String telephone,String tempId,String type,String userNick) {
        BindUserRequest request = new BindUserRequest();
        request.setCode(code);
        request.setTelephone(telephone);
        request.setTempId(tempId);
        request.setType(type);
        request.setUserNick(userNick);
        String remoteAddr = httpRequest.getRemoteAddr();
        BindUserResponse bindUserResponse = phoneUserService.bindUser(request, remoteAddr);
        return JSONObject.fromObject(bindUserResponse);
    }

    //得到验证码
    @RequestMapping("getPhoneMsg")
    @ResponseBody
    public JSONObject appGetPhoneMsg(String telephone,Integer type,HttpServletRequest httpRequest) {
        GetPhoneMsgRequest request = new GetPhoneMsgRequest();
        request.setTelephone(telephone);
        request.setType(type);

        return JSONObject.fromObject(phoneUserService.getPhoneMsg(request));
    }

    @RequestMapping("imgUpload")
    @ResponseBody
    public JSONObject upToWx(HttpSession session,String file) {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ImgUploadRequest request = new ImgUploadRequest();
        request.setFile(file);
        request.setUserId(ps.getUserId());
        return JSONObject.fromObject(phoneUserService.imgUpload(request));
    }



}
