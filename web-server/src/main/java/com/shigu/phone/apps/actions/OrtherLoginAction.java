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
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
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
    private static final Logger logger = Logger.getLogger(OrtherLoginAction.class);
    @Autowired
    private PhoneUserService phoneUserService;
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private RedisIO redisIO;
    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;
    /*//第三方登录,淘宝授权成功跳转
    @RequestMapping("phoneOrtherLogin")
    public String passwordLogin(String nick, String key,Integer type,String sign,Integer flag){
        try {//为什么decode来decode去,不知道,返回照做
            String name= URLDecoder.decode(URLDecoder.decode(nick,"utf-8"),"utf-8");
            String userNick= URLEncoder.encode(URLEncoder.encode(name, "utf-8"), "utf-8");
            String url="alidao://sjxz/taobao/author?userNick="+userNick;
            return "redirect:"+url;
        } catch (UnsupportedEncodingException e1) {
            logger.error("用户名转义出错",e1);
        }
        return "";
    }*/
    //第三方登录,淘宝授权成功跳转
    @RequestMapping("phoneOrtherLogin")
    public String passwordLogin( @Valid AppLoginBackBO bo,BindingResult result, HttpServletRequest request) throws Main4Exception, UnsupportedEncodingException {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        if(bo.getFlag()==0){
            //未定阅星座网服务
            return "redirect:"+"alidao://sjxz/taobao/author?type=null&token=null&userNick=null&tempId=null&flag=0";
        }
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
        if(MD5Attestation.signParamString(map).equals(bo.getSign())){//去登陆
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    usernamezhong, null, false, request.getRemoteAddr(), "", UserType.MEMBER);
            //选择登陆方式
            LoginFromType loginFromType;
            if(bo.getType()==1){
                loginFromType=LoginFromType.TAOBAO;
            }else if(bo.getType()==2){
                loginFromType=LoginFromType.WX;
            }else{
                throw new Main4Exception("登陆方式传入有错");
            }
            token.setLoginFromType(loginFromType);
            token.setRememberMe(true);
            token.setSubKey(bo.getKey());
            try {
                currentUser.login(token);
                //返回需要数据
                PersonalSession personalSession = userBaseService.selUserForSessionByUserName(usernamezhong, LoginFromType.TAOBAO);
                Long userId = personalSession.getUserId();
                //token
                String uuid=phoneUserService.createToken(personalSession.getUserId(),"phone_login_token");

                return "redirect:"+"alidao://sjxz/taobao/author?type=1&token="+uuid+"&userNick=null&tempId=null&flag=1";
            }catch (LoginAuthException e) {
                TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
                taobaoSessionMapExample.createCriteria().andNickEqualTo(bo.getNick());
                List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
                String userId = taobaoSessionMaps.get(0).getUserId()+"";
                return "redirect:"+"alidao://sjxz/taobao/author?type=0&token=null&userNick="+bo.getNick()+"&tempId="+userId+"&flag=1";
            }

        }
        return "redirect:error&nick="+bo.getNick()+"&type="+bo.getType()+"&key="+bo.getKey()+"flag="+bo.getFlag()+"&sign="+bo.getSign();
    }
}