package com.shigu.phone.waps.actions;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.phone.waps.service.WapPhoneUserService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
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
import java.util.Map;

/**
 * Created by Admin on 2017/10/13.
 */
@Controller
@RequestMapping("datas/")
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
            return JsonResponseUtil.error("账号或密码错误").element("success",false);
        }
    }

    /**
     * 短信验证码登录
     * @param request
     * @param telephone
     * @param msgCode
     * @return
     */
    @RequestMapping("msgCodeLogin")
    @ResponseBody
    public JSONObject msgCodeLogin(HttpServletRequest request,String telephone ,String msgCode) {
        try {
            wapPhoneUserService.msgCodeLogin(telephone, msgCode, request.getRemoteAddr());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
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
                                    .element("success",false);
        }

    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("userRegist")
    @ResponseBody
    public JSONObject userRegist(HttpServletRequest request, String telephone,String msgCode,String pwd){
        try {
            wapPhoneUserService.regist(telephone, msgCode, pwd);
            accountLogin(request,telephone,pwd);//登录
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false);
        }
    }


    @RequestMapping("changePassword")
    @ResponseBody
    public JSONObject ChangePassword(HttpSession session,String newPwd,String oldPwd) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("参数错误").element("success",false);
        }
        try {
            wapPhoneUserService.changePassword(oldPwd,newPwd,ps.getUserId());
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg()).element("success",false);
        }
    }




    @RequestMapping("forgetPassword")
    @ResponseBody
    public JSONObject ForgetPassword(String msgCode,String newPwd,String telephone) {
        try {
            wapPhoneUserService.forgetPassword(telephone,msgCode,newPwd);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getErrMsg())
                    .element("success",false);
        }
    }

    @RequestMapping("needBindTelephone")
    @ResponseBody
    public JSONObject needBindTelephone(HttpSession session ) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        boolean needBindTelephone = false;
        needBindTelephone = wapPhoneUserService.needBindTelephone(ps.getUserId());
        return JsonResponseUtil.success().element("success",true)
                .element("type",needBindTelephone?0:1);
    }

    @RequestMapping("bindTelephone")
    @ResponseBody
    public JSONObject bindTelephone(HttpSession session,Long telephone) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        try {
            wapPhoneUserService.bindTelephone(ps.getUserId(),telephone);
            return JsonResponseUtil.success().element("success",true);
        } catch (OpenException e) {
            return JsonResponseUtil.error(e.getMessage()).element("success",false);
        }

    }

    @RequestMapping("getUserLoginState")
    @ResponseBody
    public JSONObject getUserLoginState(HttpSession session) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getUserId() == null) {
                return JsonResponseUtil.error("用户未登录").element("success",false);
            }
            //是否是商户
            Subject subject = SecurityUtils.getSubject();
            boolean isStore = subject.hasRole(RoleEnum.STORE.getValue()) || subject.hasRole(RoleEnum.MORE_STORE.getValue());
            return JsonResponseUtil.success().element("success",true)
                                             .element("userId",ps.getUserId())
                                             .element("userType",isStore?2:1);
        } catch (Exception e) {
            return JsonResponseUtil.error("查询失败").element("success",false);
        }
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public JSONObject loginOut(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JsonResponseUtil.success().element("success",true);
    }

    @RequestMapping("getUserData")
    @ResponseBody
    public JSONObject getUserData(HttpSession session,String userId) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        Map<String, Object> otherPlatform = ps.getOtherPlatform();
        String bingdTelephone = null;
        if (otherPlatform != null) {
            bingdTelephone = (String) otherPlatform.get("__bindPhone__");
        }
        return JsonResponseUtil.success().element("success",true)
                                         .element("headUrl",ps.getHeadUrl())
                                         .element("userNick",ps.getUserNick())
                                         .element("phoneBind",bingdTelephone);
    }

    /**
     * 修改用户头像
     * @return
     */
    @RequestMapping("updateHeardImg")
    @ResponseBody
    public JSONObject imgUpload(HttpSession session,HttpServletRequest request){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null || ps.getUserId() == null) {
            return JsonResponseUtil.error("用户未登录").element("success",false);
        }
        return null;

//        return JSONObject.fromObject(wapPhoneUserService.imgUpload(ps.getUserId(),fileName));
    }

}
