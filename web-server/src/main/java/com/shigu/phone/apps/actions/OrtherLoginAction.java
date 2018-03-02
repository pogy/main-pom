package com.shigu.phone.apps.actions;

import com.openJar.beans.app.AppLoginBackBO;
import com.openJar.commons.MD5Attestation;
import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.shigu.buyer.actions.UserLoginAction;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.phone.apps.services.PhoneUserService;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static Logger logger = LoggerFactory.getLogger(OrtherLoginAction.class);
    @Autowired
    private PhoneUserService phoneUserService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private RedisIO redisIO;
    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;
    //第三方登录,淘宝授权成功跳转
    @RequestMapping("phoneOrtherLogin")
    public String passwordLogin(AppLoginBackBO bo,BindingResult result, HttpServletRequest request) throws Main4Exception, UnsupportedEncodingException {
        logger.info("phoneOrtherLogin----login");
        if(bo.getFlag()==0){
            //未定阅星座网服务
            return "redirect:"+"alidao://sjxz/taobao/author?type=null&token=null&userNick=null&tempId=null&flag=0";
        }
        //shiro框架-----得到验证用户
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = getToken(bo, result, request);

        try {
            currentUser.login(token);
            //返回需要数据
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(URLDecoder.decode(URLDecoder.decode(bo.getNick(),"utf-8"),"utf-8"), LoginFromType.TAOBAO);
//            Long userId = personalSession.getUserId();
            //token
            String uuid=phoneUserService.createToken(personalSession.getUserId(),"phone_login_token");
            uuid = TokenUtil.str2HexStr(uuid);
            return "redirect:"+"alidao://sjxz/taobao/author?type=1&token="+uuid+"&userNick=null&tempId=null&flag=1";
        }catch (LoginAuthException e) {
            return "redirect:"+"alidao://sjxz/taobao/author?type=0&token=null&userNick="+bo.getNick()+"&tempId="+bo.getKey()+"&flag=1";
        }
    }
    //淘宝登录h5
    @RequestMapping("otherLoginH5")
    public String otherLoginH5( AppLoginBackBO bo, BindingResult result, HttpServletRequest request) throws Main4Exception, UnsupportedEncodingException {
        //shiro框架-----得到验证用户
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = getToken(bo, result, request);
        try {
            //绑定过星座网
            currentUser.login(token);
            return "redirect:/waps/index.htm#/bindTelephone?type=1";
        }catch (LoginAuthException e){
            //未绑定星座网
            //信息暂存，绑定用户时使用
            Map<String,Object> otherPlatform = new HashMap<>();
            otherPlatform.put("userNick",bo.getNick());
            otherPlatform.put("tempId",bo.getKey());
            otherPlatform.put("flag",bo.getFlag());
            otherPlatform.put("type","TAOBAO");
            redisIO.putFixedTemp("otherLogin_info"+bo.getKey(),otherPlatform,1800);
            return "redirect:/waps/index.htm#/bindTelephone?type=0&tempId="+bo.getKey();
        }
    }

    //得到shiro验证的token
    public CaptchaUsernamePasswordToken getToken(@Valid AppLoginBackBO bo, BindingResult result, HttpServletRequest request) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        CaptchaUsernamePasswordToken token=null;
        //这里用了老的代码
        String usernamezhong = bo.getNick();
        Map<String,String> map=new HashMap<String, String>();
        try {//为什么decode来decode去,不知道,返回照做
            usernamezhong= URLDecoder.decode(URLDecoder.decode(bo.getNick(),"utf-8"),"utf-8");
            bo.setNick(URLEncoder.encode(URLEncoder.encode(usernamezhong, "utf-8"), "utf-8"));
        } catch (UnsupportedEncodingException e1) {
            logger.error("用户名转义出错",e1);
        }
        map.put("nick", bo.getNick());
        map.put("key", bo.getKey());
        map.put("type", bo.getType()+"");
        map.put("flag",bo.getFlag()+"");
        if(MD5Attestation.signParamString(map).equals(bo.getSign())) {//去登陆
            token = new CaptchaUsernamePasswordToken(
                    usernamezhong, null, false, request.getRemoteAddr(), "", UserType.MEMBER);
            //选择登陆方式
            LoginFromType loginFromType;
            if (bo.getType() == 1) {
                loginFromType = LoginFromType.TAOBAO;
            } else if (bo.getType() == 2) {
                loginFromType = LoginFromType.WX;
            } else {
                throw new Main4Exception("登陆方式传入有错");
            }
            token.setLoginFromType(loginFromType);
            token.setRememberMe(true);
            token.setSubKey(bo.getKey());
            return token;
        }
        return token;
    }
}