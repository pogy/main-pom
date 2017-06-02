package com.shigu.buyer.actions;

import com.openJar.commons.MD5Attestation;
import com.opentae.auth.utils.LoginLinkUtil;
import com.shigu.buyer.bo.*;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.buyer.vo.LoginMsgVO;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.exceptions.Main4LoginException;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.RedomUtil;
import com.shigu.tools.ResultRetUtil;
import com.shigu.tools.XzSdkClient;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登陆
 * Created by zhaohongbo on 17/2/24.
 */
@Controller
public class UserLoginAction {

    private static final Logger logger = Logger.getLogger(UserLoginAction.class);
    @Autowired
    MemberFilter memberFilter;

    @Autowired
    SendMsgService sendMsgService;

    @Autowired
    RegisterAndLoginService registerAndLoginService;

    @Autowired
    UserLicenseService userLicenseService;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    SpreadService spreadService;

    @Autowired
    MemberSimpleService memberSimpleService;

    /**
     * 登陆
     * @param bo 登陆参数
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(LoginBO bo, HttpServletRequest request,HttpSession session, Model model){
        //验证一下,是否已经登陆
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()&&currentUser.hasRole(UserType.MEMBER.getValue())
                &&session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())!=null) {//如果已经登陆，去登陆页面
            return "redirect:"+loginSuccessUrl(bo.getBackUrl());
        }
        //如果是登陆请求
        if(!bo.isEmpty()){//登陆请求
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    bo.getUserName(), bo.getPassword(), false, request.getRemoteAddr(), "", UserType.MEMBER);
            //星座用户登陆
            token.setLoginFromType(LoginFromType.XZ);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                currentUser.hasRole(RoleEnum.STORE.getValue());
                //登陆成功
                return "redirect:"+loginSuccessUrl(bo.getBackUrl());
            } catch (AuthenticationException e) {
                //登陆失败
                if(e instanceof LoginAuthException){
                    LoginAuthException ex= (LoginAuthException) e;
                    if(ex.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//需要绑定手机号
                        return "redirect:userPhoneBind.htm";
                    }
                }
                token.clear();
                String msg="账号或密码错误";
                model.addAttribute("msg",msg);
                model.addAttribute("userName",bo.getUserName());
                model.addAttribute("password",bo.getPassword());
            }
        }
        //把回调放到参数去
        if(bo.getBackUrl()!=null&&!"".equals(bo.getBackUrl())){
            try {
                model.addAttribute("backUrl",URLEncoder.encode(bo.getBackUrl(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error("url 回调地址出错",e);
            }
        }
        //加广告

        ObjFromCache<List<ImgBannerVO>> listObjFromCache = spreadService.selImgBanners(SpreadEnum.LOGIN_GT);
        List<ImgBannerVO> vos = listObjFromCache.selReal();
        if (!vos.isEmpty()) {
            model.addAttribute("index_goat", vos.get(0));
        }
        return "buyer/login";
    }

    /**
     * jsonp登陆
     */
    @RequestMapping("jsonplogin")
    @ResponseBody
    public void jsonplogin(@Valid JsonpLoginBO bo,BindingResult result,HttpServletRequest request
            ,HttpServletResponse response) throws IOException {
        //验证数据
        if(result.hasErrors()){
//            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'"+result.getAllErrors().get(0).getDefaultMessage()+"'}",response);
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'002'}",response);
            return;
        }
        //jsonp登陆
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()&&currentUser.hasRole(UserType.MEMBER.getValue())) {//如果已经登陆，去登陆页面
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':true}",response);
            return;
        }
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                bo.getUserName(), bo.getUserPassword(), false, request.getRemoteAddr(), "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.XZ);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':true}",response);
        } catch (AuthenticationException e) {
            if(e instanceof LoginAuthException){
                LoginAuthException ex= (LoginAuthException) e;
                if(ex.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//需要绑定手机号
//                    ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'需要绑定手机号','bindUrl':'"+xzSdkClient.getMainHost()+"userPhoneBind.htm'}",response);
                    ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'003','bindUrl':'"+xzSdkClient.getMainHost()+"userPhoneBind.htm'}",response);
                    return;
                }
            }
//            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'账号或密码错误'}",response);
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'OK':false,'msg':'001'}",response);
        }
    }


    /**
     * 其它第三方登陆
     * @return
     */
    @RequestMapping("ortherLogin")
    public String ortherLogin(int ortherLoginType,String backUrl,HttpSession session){
        LoginLinkUtil llu = new LoginLinkUtil();
        String url="";
        switch(ortherLoginType) {
            case 1:
                url = llu.callTbUrl().replace("http://www.571xz.net/",xzSdkClient.getYjHost());
                break;
            case 2:
                url = llu.callAliUrl();
                break;
            case 3:
                url = llu.callQqUrl();
                break;
            case 4:
                HashMap e = new HashMap();
                e.put("state", "wx591514a902a6280d__snsapi_userinfo");
                e.put("date", TypeConvert.formatDate(new Date()));
                String sign = MD5Attestation.signParamString(e);
                url = "http://wx.571xz.com/shigu_weixin/wxoauth2toOauth2WzPage.action?state=wx591514a902a6280d__snsapi_userinfo&date="
                        + TypeConvert.formatDate(new Date()) + "&sign=" + sign;
        }
        session.setAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue(),backUrl);
        return "redirect:"+url;
    }

    /**
     * 第三方登陆回调
     * http://127.0.0.1:8080/loginback.htm?userName=de55&key=5745&type=tb
     * @return
     */
    @RequestMapping("loginback")
    public String loginback(@Valid LoginBackBO bo, BindingResult result,HttpServletRequest request,
                            HttpSession session) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        //这里用了老的代码
        String usernamezhong = bo.getUserName();
        Map<String,String> map=new HashMap<String, String>();
        try {//为什么decode来decode去,不知道,返回照做
            usernamezhong= URLDecoder.decode(URLDecoder.decode(bo.getUserName(),"utf-8"),"utf-8");
            bo.setUserName(URLEncoder.encode(URLEncoder.encode(usernamezhong, "utf-8"), "utf-8"));
        } catch (UnsupportedEncodingException e1) {
            logger.error("用户名转义出错",e1);
        }
        map.put("userName", bo.getUserName());
        map.put("key", bo.getKey());
        map.put("type", bo.getType());
        if(MD5Attestation.unsignParamString (map, bo.getSign())){//去登陆
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    usernamezhong, null, false, request.getRemoteAddr(), "", UserType.MEMBER);
            //选择登陆方式
            LoginFromType loginFromType;
            if(bo.getType().equals("ali")){
                loginFromType=LoginFromType.ALI;
            }else if(bo.getType().equals("tb")){
                loginFromType=LoginFromType.TAOBAO;
            }else if(bo.getType().equals("qq")){
                loginFromType=LoginFromType.QQ;
            }else if(bo.getType().equals("wx")){
                loginFromType=LoginFromType.WX;
            }else{
                throw new Main4Exception("登陆方式传入有错");
            }
            token.setLoginFromType(loginFromType);
            token.setRememberMe(true);
            token.setSubKey(bo.getKey());
            try {
                currentUser.login(token);
                if(currentUser.hasRole(RoleEnum.STORE.getValue())&&loginFromType==LoginFromType.TAOBAO){//有店铺
                    PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
                    if(StringUtils.isEmpty(ps.getLogshop().getTbNick())){//需要绑定一下淘宝到店
                        memberSimpleService.updateShopNick(ps.getLogshop().getShopId(),usernamezhong);
                    }
                }
                //得到回调用地址
                String backUrl= (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
                session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
                return "redirect:"+loginSuccessUrl(backUrl);
            } catch (LoginAuthException e) {
                if(e.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//还没绑定星座网用户,去绑定一下
                    return "redirect:userPhoneBind.htm";
                }else{
                    throw e;
                }
            }
        }
        return "redirect:"+memberFilter.getSuccessUrl();
    }

    /**
     * 手机号直接登陆
     * @return
     */
    @RequestMapping("phoneAuthCodeLogininit")
    public String phoneAuthCodeLogininit(String backUrl,HttpSession session){
        if(backUrl!=null){
            session.setAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue(),backUrl);
        }
        return "buyer/phoneAuthCodeLogininit";
    }

    /**
     * 手机登陆提交
     * @return
     */
    @RequestMapping("loginByPhone")
    public String loginByPhone(LoginByPhoneBO bo, HttpServletRequest request, HttpSession session, Model model) throws Main4Exception {
        if(bo!=null&&bo.getTelephone()!=null&&bo.getPhoneVerify()!=null){
            PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_LOGIN_MSG.getValue());
            if(phoneCode==null||!phoneCode.getVerify().equals(bo.getPhoneVerify())
                    ||!phoneCode.getPhone().equals(bo.getTelephone())){//验证不通过
                model.addAttribute("errorString","您输入的验证码不正确");
                model.addAttribute("telephone",bo.getTelephone());
            }else {//跳修改密码页面
                try {
                    phoneLogin(request.getRemoteAddr(),bo.getTelephone());
                    return "redirect:"+loginSuccessUrl((String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue()));
                } catch (Main4LoginException e) {
                    model.addAttribute("errorString",e.getMessage());
                    model.addAttribute("telephone",bo.getTelephone());
                }
            }
        }
        return "buyer/phoneAuthCodeLogininit";
    }

    /**
     * 手机号码登陆,验证码
     * @return
     */
    @RequestMapping("loginPhoneVerification")
    @ResponseBody
    public JSONObject loginPhoneVerification(String phone,HttpSession session){
        String code= RedomUtil.redomNumber(6);
        session.setAttribute(SessionEnum.PHONE_LOGIN_MSG.getValue(), new PhoneVerify(phone, code));
        sendMsgService.sendVerificationCode(phone, code);
//        System.out.println(code);
        return JsonResponseUtil.success();
    }
    /**
     * 忘记密码
     * @return
     */
    @RequestMapping(value = "forgetPassword", method = RequestMethod.GET)
    public String forgetPassword() throws Main4Exception {
        return "buyer/forgetPassword";
    }

    @ResponseBody
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
    public JSONObject doForgetPassword(String telephone, String imgValidate, HttpServletRequest request, HttpSession session, Model model) throws Main4Exception {
        if(imgValidate !=null){
            session.setAttribute("gotPassStep", 1);
            //是提交
            PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
            if(phoneCode==null||!phoneCode.getVerify().equals(imgValidate)
                    ||!phoneCode.getPhone().equals(telephone)){//验证不通过
                model.addAttribute("errorString","您输入的验证码不正确");
            }else{//跳修改密码页面
                try {
                    phoneLogin(request.getRemoteAddr(),telephone);
                    PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
                    phoneCode.setUserId(ps.getUserId());
                } catch (Main4LoginException e) {
                    model.addAttribute("errorString",e.getMessage());
                }
            }
        }
        return JsonResponseUtil.success();
    }

    /**
     * 手机号码登陆
     * @param remoteAddr
     * @param phone
     * @throws Main4Exception
     */
    private void phoneLogin(String remoteAddr,String phone) throws Main4Exception {
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                phone, null, false, remoteAddr, "", UserType.MEMBER);
        //星座用户登陆
        token.setLoginFromType(LoginFromType.PHONE);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
        } catch (LoginAuthException e) {
            //如果手机账号不存在
            if(e.getMsgback().equals(LoginErrorEnum.NO_USER)){//用户不存在
                throw new Main4LoginException("账号["+phone+"]不存在");
            }else{
                logger.error(phone+"用户数据有问题",e);
                throw new Main4Exception(phone+"用户数据有问题");
            }
        }
    }
    /**
     * 发送忘记密码短信
     * @param phone
     * @return
     */
    @RequestMapping("forgetPhoneVerification")
    @ResponseBody
    public JSONObject forgetPhoneVerification(String phone,HttpSession session){
        String code= RedomUtil.redomNumber(6);
        session.setAttribute(SessionEnum.PHONE_FORGET_MSG.getValue(), new PhoneVerify(phone, code));
        sendMsgService.sendVerificationCode(phone, code);
//        System.out.println(code);
        return JSONObject.fromObject("{'result':'success'}");
    }

    /**
     * 获取登陆状态
     * @return
     */
    @RequestMapping("jsonislogin")
    @ResponseBody
    public JSONObject islogin(String callback,HttpServletResponse response, HttpSession session) throws IOException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        JSONObject obj=JSONObject.fromObject("{}");
        if(ps!=null){
            obj.element("OK","OK");
            obj.element("userNick",ps.getUserNick());
            obj.element("userName",ps.getLoginName());
            obj.element("loginName",ps.getLoginName());
            obj.element("userId",ps.getUserId());
        }else{
            obj.element("OK","error");
            obj.element("result", URLEncoder.encode(URLEncoder.encode("没有登陆","utf-8"),"utf-8"));
        }
        PrintWriter pw=response.getWriter();
        pw.write(callback+"("+obj+")");
        pw.flush();
        pw.close();
        return null;
    }

    /**
     * 代发拿UID
     * @param session
     * @return
     */
    @RequestMapping("selLoginUid")
    @ResponseBody
    public Long selLoginUid(HttpSession session){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps==null){
            return -1L;
        }else{
            return ps.getUserId();
        }
    }

    /**
     * 外站查询登陆信息
     * @param session
     * @return
     */
    @RequestMapping("selLoginTbNick")
    @ResponseBody
    public JSONObject selLoginTbNick(HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps==null){
            throw new JsonErrException("没有登陆");
        }
        LoginMsgVO vo=new LoginMsgVO();
        vo.setUserId(ps.getUserId());
        if(ps.getLoginFromType().equals(LoginFromType.TAOBAO)){
            vo.setFromTaobao(true);
            vo.setTbNick(ps.getLoginName());
        }else{
            vo.setFromTaobao(false);
        }
        return JSONObject.fromObject(vo).element("result","success");
    }
    /**
     * 代发拿UID
     * @param session
     * @return
     */
    @RequestMapping("selLoginSubUid")
    @ResponseBody
    public Long selLoginSubUid(HttpSession session){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps==null){
            return -1L;
        }else{
            return ps.getSubUserId();
        }
    }

    /**
     * 一键,拿nick
     * @param session
     * @return
     */
    @RequestMapping("selLoginNick")
    @ResponseBody
    public String selLoginNick(HttpSession session){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps!=null&&ps.getLoginFromType().equals(LoginFromType.TAOBAO)){
            return ps.getLoginName();
        }else{
            return "";
        }
    }

    /**
     * 登出
     */
    @RequestMapping("membertc")
    public String logout(String backUrl,HttpServletRequest request){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        String loginUrl=memberFilter.getLoginUrl();
        if(backUrl!=null&&!"".equals(backUrl)){
            try {
                loginUrl+="?backUrl="+URLEncoder.encode(backUrl,"utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("登出时backUrl  Encode失败",e);
            }
        }else{//自己计算backUrl
//            String queryString=request.getQueryString();
            String url=request.getHeader("Referer");
            if(url!=null){
                try {
                    backUrl=URLEncoder.encode(url, "utf-8");
                    loginUrl+="?backUrl="+backUrl;
                } catch (UnsupportedEncodingException e) {
                    logger.error("退出计算回调地址错误",e);
                }
            }
        }
        return "redirect:"+loginUrl;
    }

    /**
     * 手机号绑定
     * @return
     */
    @RequestMapping("userPhoneBind")
    public String userPhoneBind(String backUrl,Model model) throws Main4Exception {
        model.addAttribute("backUrl", backUrl);
        return "buyer/userPhoneBind";
    }

    /**
     * 手机号绑定
     * @param bo bind message send.
     * @param session session
     * @return data
     */
    @RequestMapping("bindTelephone")
    @ResponseBody
    public JSONObject doBindPhoneVerification(@Valid BindPhoneBO bo, BindingResult result, HttpServletRequest request, HttpSession session) throws Main4Exception {
        if (result.hasErrors()) {
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PhoneVerify phoneVerify= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_BIND_MSG.getValue());
        if(phoneVerify==null||!bo.getTelephone().equals(phoneVerify.getPhone())
                ||!bo.getMsgValidate().equals(phoneVerify.getVerify())){
            throw new JsonErrException("短信验证码错误").addErrMap("ele", "msgValidate");
        }else {
            String imgcode= (String) session.getAttribute(SessionEnum.SEND_REGISTER_MSG.getValue());
            if(imgcode==null||!imgcode.equals(bo.getImgValidate())){//图片验证通不过
                throw new JsonErrException("图片验证码不正确").addErrMap("ele", "imgValidate");
            }
            //把第三方账号绑给现在这个手机号
            Rds3TempUser rds3TempUser = (Rds3TempUser) session.getAttribute(SessionEnum.RDS3_TEMPUSER.getValue());
            if (rds3TempUser == null) {
                throw new Main4Exception("第三方未登陆或登陆异常");
            }
            /*
             * 如果是手机来的,就是星座号绑定手机
             */
            if (rds3TempUser.getLoginFromType().equals(LoginFromType.PHONE)) {
                if (registerAndLoginService.userCanRegist(bo.getTelephone(), LoginFromType.PHONE)) {
                    userLicenseService.bindPhone(Long.valueOf(rds3TempUser.getSubUserKey()),bo.getTelephone());
                } else {
                    throw new Main4Exception("该手机号已被使用");
                }
                rds3TempUser.setSubUserName(bo.getTelephone());
            } else {
                registerAndLoginService.bind3RdUser(bo.getTelephone(), rds3TempUser);
            }
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                    rds3TempUser.getSubUserName(), null, false, request.getRemoteAddr(), "", UserType.MEMBER);
            token.setLoginFromType(rds3TempUser.getLoginFromType());
            //星座用户登陆
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                currentUser.hasRole(RoleEnum.STORE.getValue());
            } catch (LoginAuthException e) {
                throw new Main4Exception(e.getMessage());
            }
            //跳登陆中心
//                return "redirect:"+memberFilter.getSuccessUrl();
            String backUrl = (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            return JsonResponseUtil.success().element("backUrl", backUrl);
        }
    }
    /**
     * 发送手机号绑定的短信
     * @param bo bind message send.
     * @param session session
     * @return data
     */
    @RequestMapping("bindPhoneVerification")
    @ResponseBody
    public JSONObject bindPhoneVerification(@Valid RegistVerifyBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage()).addErrMap("ele", "msgValidate");
        }
        String imgcode= (String) session.getAttribute(SessionEnum.SEND_REGISTER_MSG.getValue());
        if(imgcode==null||!imgcode.equals(bo.getImgValidate())){//图片验证通不过
            throw new JsonErrException("图片验证码不正确").addErrMap("ele", "imgValidate");
        }
        String code= RedomUtil.redomNumber(6);
        session.setAttribute(SessionEnum.PHONE_BIND_MSG.getValue(), new PhoneVerify(bo.getTelephone(), code));
        sendMsgService.sendVerificationCode(bo.getTelephone(), code);
        return JsonResponseUtil.success();
    }
    /**
     * 得到登陆成功链接
     * @param backUrl
     * @return
     */
    private String loginSuccessUrl(String backUrl){
        String toUrl;
        if(backUrl!=null&&!"http://www.571xz.com/".equals(backUrl)){//TODO 首页的,等页面改好,这里再去掉
            toUrl=backUrl;
        }else{
            //如果个人,跳到这个,如果商户跳到seller
            toUrl=memberFilter.getSuccessUrl();
        }
        return toUrl;
    }

}
