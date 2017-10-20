package com.shigu.phone.waps.actions;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.phone.waps.service.WapPhoneUserService;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.RedomUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/wap/datas/")
public class WapUserAction {
    @Autowired
    private WapPhoneUserService wapPhoneUserService;

    /**
     * 账号密码登录
     * @param pwd
     * @return
     */
    @RequestMapping("accountLogin")
    @ResponseBody
    public JSONObject accountLogin(HttpServletRequest request,String user ,String pwd) {
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                user, pwd, false, request.getRemoteAddr(), "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.XZ);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
            return JsonResponseUtil.success().element("success",true);
        } catch (AuthenticationException e) {
            //登陆失败
            token.clear();
            return JsonResponseUtil.success().element("success",false).element("msg","账号或密码错误");
        }
    }

    /**
     * 账号密码登录
     * @param pwd
     * @return
     */
    @RequestMapping("msgCodeLogin")
    @ResponseBody
    public JSONObject msgCodeLogin(HttpServletRequest request,String user ,String pwd) {
        try {
            wapPhoneUserService.msgCodeLogin(user, pwd, request.getRemoteAddr());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.success().element("success",false).element("msg",e.getErrMsg());
        }
    }

    /**
     * 获取手机验证码
     * @return
     */
    @RequestMapping("getPhoneMsgCode")
    @ResponseBody
    public JSONObject getPhoneMsgCode(Long telephone,Integer type) {
        try {
            wapPhoneUserService.getPhoneMsg(String.valueOf(telephone),type);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                                    .element("success",false)
                                    .element("msg",e.getErrMsg());
        }

    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("userRegist")
    @ResponseBody
    public JSONObject userRegist( String telephone,String msgCode,String pwd){
        try {
            wapPhoneUserService.regist(telephone,msgCode,pwd);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false)
                    .element("msg",e.getErrMsg());
        }
    }

    @RequestMapping("aboutMe")
    @ResponseBody
    public JSONObject aboutMe(HttpSession session) {
        AboutMeRequest request = new AboutMeRequest();
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        request.setUserId(ps.getUserId());
        return null;
    }

    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject ChangePassword(HttpSession session,String newPwd,String oldPwd) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId si null");
        }
        try {
            wapPhoneUserService.changePassword(oldPwd,newPwd,ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg",e.getErrMsg());
        }
    }


    @RequestMapping("ortherLogin")
    @ResponseBody
    public JSONObject ortherLogin(String key,String nick,Integer type) {
       return null;
    }

    @RequestMapping("forgetPassword")
    @ResponseBody
    public JSONObject ForgetPassword(String msgCode,String newPwd,String telephone) {
        try {
            wapPhoneUserService.forgetPassword(telephone,msgCode,newPwd);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false)
                    .element("msg",e.getErrMsg());
        }
    }

    @RequestMapping("needBindTelephone")
    @ResponseBody
    public JSONObject needBindTelephone(HttpSession session ) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId si null");
        }
        boolean needBindTelephone = wapPhoneUserService.needBindTelephone(ps.getUserId());
        return JsonResponseUtil.success().element("success",true)
                                         .element("type",needBindTelephone?1:0);
    }

    @RequestMapping("bindTelephone")
    @ResponseBody
    public JSONObject bindTelephone(Long telephone) {
        return getPhoneMsgCode(telephone,4);
    }

    @RequestMapping("getUserLoginState")
    @ResponseBody
    public JSONObject getUserLoginState(HttpSession session,Long telephone) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps.getUserId() == null) {
                return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId si null");
            }
            //是否是商户
            Subject subject = SecurityUtils.getSubject();
            boolean isStore = subject.hasRole(RoleEnum.STORE.getValue()) || subject.hasRole(RoleEnum.MORE_STORE.getValue());
            return JsonResponseUtil.success().element("success",true)
                                             .element("userId",ps.getUserId())
                                             .element("userType",isStore?2:1);
        } catch (Exception e) {
            return JsonResponseUtil.success().element("success",false)
                    .element("msg","查询失败");
        }
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public JSONObject loginOut(HttpSession session,String userId) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId si null");
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JsonResponseUtil.success().element("success",true);
    }

    @RequestMapping("getUserData")
    @ResponseBody
    public JSONObject getUserData(HttpSession session,String userId) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps.getUserId() == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userId is null");
        }
        UserInfo userInfo = wapPhoneUserService.selUserInfo(ps.getUserId());
        if (userInfo == null) {
            return JsonResponseUtil.error("userId si null").element("success",false).element("msg","userInfo is null");
        }
        return JsonResponseUtil.success().element("success",true)
                                         .element("headUrl",userInfo.getHeadUrl())
                                         .element("userNick",userInfo.getUserNick())
                                         .element("phoneBind",userInfo.getTelephone());
    }

    @RequestMapping("index")
    public String index() {
       return "waps/index";
    }



}
