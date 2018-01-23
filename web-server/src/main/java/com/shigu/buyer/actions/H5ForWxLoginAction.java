package com.shigu.buyer.actions;

import com.shigu.buyer.bo.WxLoginBO;
import com.shigu.buyer.vo.SnsOauth2Access_tokenGet;
import com.shigu.buyer.vo.WebToken;
import com.shigu.component.encryption.MD5;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.tools.RedisIO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sword.wechat4j.api.WechatClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 微信上的h5登陆
 * Created by zhaohongbo on 17/4/14.
 */
@Controller
public class H5ForWxLoginAction {
    private static final Logger logger = LoggerFactory.getLogger(H5ForWxLoginAction.class);


//    private static final String XB_REDIRECT_URL = "http://xb.571xz.com//wxoauth2toLogin.htm?uid={openid}&ki={ki}&sid=";
    private static final String XB_REDIRECT_URL = "?uid={openid}&ki={ki}&sid=";

    private static final String AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri={redirectUrl}&response_type=code&scope=snsapi_userinfo&state={state}#wechat_redirect";

    private static final String XZ_APP_ID = "wx97822e94ad4eee44";
    private static final String XZ_APP_SECRET = "165b38a31cb5c22f2ea51532a4f54df1";

    private static final Integer redisSessionTime=604800;//登陆有效7天

    @Autowired
    RedisIO redisIO;
    /**
     * 微信登陆
     * @return
     */
    @RequestMapping("wx/login")
    public String login(WxLoginBO bo, HttpSession session, HttpServletRequest request, Model model) {
        if (bo.getBackUrl() == null&&bo.getState()!=null) {
            bo.setBackUrl(bo.getState());
        }
        model.addAttribute("bo",bo);
        model.addAttribute("backUrl",bo.getBackUrl());
        if(bo.getCkCode()!=null&&bo.getPhone()!=null&&bo.getOpenIid()!=null){//请求提交
            return loginSubmit(bo,session,request,model);
        }else{//进登陆页面
            String openIid;
            //查一下 redis有没有
            try {
                //取openIid
                openIid=parseOpenIid(bo.getCode(),bo.getBackUrl());
                if(StringUtils.isNotEmpty(openIid) && openIid.startsWith("redirect")){
                    return openIid;
                }
                Long userId=redisIO.get(openIid,Long.class);
                if(userId!=null){
                    return "redirect:"+getBackUrl(bo.getBackUrl(),openIid);
                }
                model.addAttribute("openIid",openIid);
            } catch (IOException e) {
                model.addAttribute("errorTip","换取微信openIid失败");
                logger.error("换取微信openIid失败",e);
                return "waps/appLogin";
            }
        }
        return "waps/appLogin";
    }

    public String loginSubmit(WxLoginBO bo, HttpSession session, HttpServletRequest request, Model model){
        PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_LOGIN_MSG.getValue());
        if(phoneCode==null||!phoneCode.getVerify().equals(bo.getCkCode())
                ||!phoneCode.getPhone().equals(bo.getPhone())){//验证不通过
            model.addAttribute("errorTip","您输入的验证码不正确");
        }else {
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    bo.getPhone(), null, false, request.getRemoteHost(), "", UserType.MEMBER);
            //星座用户登陆
            token.setLoginFromType(LoginFromType.PHONE);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
                redisIO.putTemp(bo.getOpenIid(),ps.getUserId(),redisSessionTime);
                return "redirect:"+getBackUrl(bo.getBackUrl(),bo.getOpenIid());
                //按wx令牌
//                    currentUser.hasRole(RoleEnum.STORE.getValue());
            } catch (LoginAuthException e) {
                //如果手机账号不存在
                if(e.getMsgback().equals(LoginErrorEnum.NO_USER)){//用户不存在
                    model.addAttribute("errorTip","账号["+bo.getPhone()+"]暂未注册!");
                }else if(e.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//手机H5登陆的不需要绑定
                    model.addAttribute("errorTip","星座账号没有绑定手机");
                }
            }
        }
        return "waps/appLogin";
    }

    /**
     * 取得openIid
     * @param code
     * @return
     * @throws IOException
     */
    private String parseOpenIid(String code,String backUrl) throws IOException {
        if("itisok".equals(code)){
            return "itisok";
        }
        if (StringUtils.isEmpty(code)) {
            return "redirect:" + AUTH_URL.replace("{appid}", XZ_APP_ID).replace("{redirectUrl}", URLEncoder.encode("http://wx123.571xz.net/wx/login.htm", "UTF-8")).replace("{state}", backUrl);
        }
        String openIid=redisIO.get(code);
        if(openIid==null){
            try {
                WechatClient client = new WechatClient();
                SnsOauth2Access_tokenGet tokenGet = new SnsOauth2Access_tokenGet();
                tokenGet.setAppid(XZ_APP_ID);
                tokenGet.setSecret(XZ_APP_SECRET);
                tokenGet.setCode(code);
                WebToken webToken = client.execute(tokenGet);
                openIid= webToken.getOpenid();
                redisIO.putTemp(code,openIid,600);
            } catch (Exception e) {
                return "redirect:" + AUTH_URL.replace("{appid}", XZ_APP_ID).replace("{redirectUrl}", URLEncoder.encode("http://wx123.571xz.net/wx/login.htm", "UTF-8")).replace("{state}", backUrl);
            }
        }
        return openIid;
    }

    /**
     * 取得回调地址
     * @param url
     * @param openIid
     * @return
     */
    private String getBackUrl(String url,String openIid){
        long nano = System.nanoTime();
        String ki = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS") + (nano - nano / 10000000 * 10000000);
        return url + (XB_REDIRECT_URL.replace("{openid}", openIid).replace("{ki}", ki)+ MD5.encrypt(openIid+ki));
    }

}
