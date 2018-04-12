package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppLoginBackBO;
import com.openJar.beans.app.AppUser;
import com.openJar.commons.MD5Attestation;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.apps.actions.OrtherLoginAction;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.BindUserVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class PhoneUserService {
    private static Logger logger = LoggerFactory.getLogger(PhoneUserService.class);
    @Autowired
    private BasePhoneUserService basePhoneUserService;
    @Autowired
    private RedisIO redisIO;

    @Autowired
    private UserBaseService userBaseService;

    /**
     * 移动端我的信息
     *
     * @param request
     * @return
     */
    public AboutMeResponse aboutMe( AboutMeRequest request) {
        AboutMeResponse resp = new AboutMeResponse();
        AboutMeVO aboutMeVO = basePhoneUserService.aboutMe(request.getUserId());
        AppUser appUser=new AppUser();
        appUser.setToken(request.getToken());
        appUser.setUserNick(aboutMeVO.getUserNick());
        appUser.setImgsrc(aboutMeVO.getHeadUrl());
        resp.setUsers(appUser);
        resp.setUserNick(aboutMeVO.getUserNick());
        resp.setHeadUrl(aboutMeVO.getHeadUrl());
        resp.setPhoneBind(aboutMeVO.getPhoneBind());
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端登录
     */
    public LoginResponse login( LoginRequest request, HttpServletRequest servletRequest) {
        LoginResponse resp = new LoginResponse();
        try {
            AppUser appUser = basePhoneUserService.login(request.getUserName(), request.getPassword(), request.getType(), servletRequest.getRemoteAddr());
            resp.setUsers(appUser);
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setSuccess(false);
            resp.setException(e);
        }
        return resp;
    }

    //微信登录
    public WxLoginResponse WxLogin(WxLoginRequest request,BindingResult result,HttpServletRequest servletrequest) throws Main4Exception {
        WxLoginResponse resp =new WxLoginResponse();
        //shiro框架-----得到验证用户
        Subject currentUser = SecurityUtils.getSubject();
        AppLoginBackBO bo=new AppLoginBackBO();
        AppUser appUser=new AppUser();
        bo.setNick(request.getNickname());
        bo.setKey(request.getUnionid());
        bo.setType(2);
        CaptchaUsernamePasswordToken token = getToken(bo, result, servletrequest);
        try {
            //登录成功
            currentUser.login(token);
            //返回需要数据
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getNickname(), bo.getKey(),LoginFromType.WX);
//            Long userId = personalSession.getUserId();
            //token
            String uuid=createToken(personalSession.getUserId(),"phone_login_token");
            uuid = TokenUtil.str2HexStr(uuid);
            resp.setType(1);
            appUser.setToken(uuid);
            //是否是商户
            if(SecurityUtils.getSubject().hasRole(RoleEnum.STORE.getValue())){
                appUser.setImSeller(true);
            }else{
                appUser.setImSeller(false);
            }
            appUser.setUserNick(personalSession.getUserNick());
            appUser.setImgsrc(personalSession.getHeadUrl());
            resp.setSuccess(true);
        }catch (LoginAuthException e) {
            //还没绑定星座网用户,去绑定一下
            resp.setType(0);
            resp.setSuccess(true);
        }catch (Exception e) {
            //还没绑定星座网用户,去绑定一下
            resp.setSuccess(false);
        }
        resp.setUsers(appUser);
        resp.setSuccess(true);
        return resp;
    }

    //得到shiro验证的token
    public CaptchaUsernamePasswordToken getToken(@Valid AppLoginBackBO bo, BindingResult result, HttpServletRequest request) throws Main4Exception {
        if(result.hasErrors()){
            throw new Main4Exception(result.getAllErrors().get(0).getDefaultMessage());
        }
        CaptchaUsernamePasswordToken token=null;
        //这里用了老的代码
        String usernamezhong = bo.getNick();
//        Map<String,String> map=new HashMap<String, String>();
        try {//为什么decode来decode去,不知道,返回照做
            usernamezhong= URLDecoder.decode(URLDecoder.decode(bo.getNick(),"utf-8"),"utf-8");
            bo.setNick(URLEncoder.encode(URLEncoder.encode(usernamezhong, "utf-8"), "utf-8"));
        } catch (UnsupportedEncodingException e1) {
            logger.error("用户名转义出错",e1);
        }

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
    /**
     * 得到手机验证码
     */
    public GetPhoneMsgResponse getPhoneMsg(GetPhoneMsgRequest request){
        GetPhoneMsgResponse resp=new GetPhoneMsgResponse();
        try {
            String msgCode = basePhoneUserService.getPhoneMsg(request.getTelephone(),request.getType());
            //todo 正式上线删除msgCode的返回值
            resp.setMsgCode(msgCode);
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    /**
     * 移动端修改密码
     *
     * @param request
     * @return
     */
    public ChangePasswordResponse changePassword( ChangePasswordRequest request) {
        ChangePasswordResponse resp = new ChangePasswordResponse();
        try {
            basePhoneUserService.changePassword(request.getOldPwd(), request.getNewPwd(),request.getUserId());
            resp.setSuccess(true);
        }catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    //忘记密码
    public ForgetPasswordResponse forgetPassword( ForgetPasswordRequest request ) {
        ForgetPasswordResponse resp=new ForgetPasswordResponse();
        try {
            basePhoneUserService.forgetPassword(request.getTelephone(),request.getMsgCode(),request.getNewPassword());
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    /**
     * 移动端用户注册
     * @param request
     * @return
     */
    public RegistResponse regist( RegistRequest request){
        RegistResponse resp = new RegistResponse();
        try {
            AppUser appUser = basePhoneUserService.regist(request.getTelephone(), request.getCode(), request.getPassword());
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getTelephone(),LoginFromType.XZ);
            String phone_login_token =createToken(personalSession.getUserId(),"phone_login_token");
            phone_login_token = TokenUtil.str2HexStr(phone_login_token);
            appUser.setToken(phone_login_token);

            resp.setUsers(appUser);
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    public String createToken(Long userId,String key){
        //token
        String uuid= TokenUtil.format(userId);
        String inRedisToken= uuid+"@@@@@---@@@@@"+new Date().getTime();
        //把token存入redis,设置存活时间30分钟
        // redisIO.putFixedTemp("phone_login_token",uuid,1800);会提前转译一次json,
        Jedis jedis = redisIO.getJedis();
        try {
            jedis.setex(key + userId, 604800, inRedisToken);
            return uuid;
        }finally {
            redisIO.returnJedis(jedis);
        }
    }

    /**
     * 移动端绑定手机
     * @param request
     * @return
     */
    public BindUserResponse bindUser( BindUserRequest request, String remoteAddr){
        BindUserResponse resp = new BindUserResponse();
        //验证码校验
        if(!request.getCode().equals(redisIO.get("phone_bind_type_msg_"+request.getTelephone()))){
            OpenException openException = new OpenException();
            openException.setErrMsg("验证码错误");
            resp.setException(openException);
            resp.setSuccess(false);
            return resp;
        }
        BindUserBO bo  = new BindUserBO();
        bo.setCode(request.getCode());
        bo.setRemoteAddr(remoteAddr);
        bo.setTelephone(request.getTelephone());
        bo.setTempId(request.getTempId());
        bo.setType(request.getType());
        bo.setUserNick(request.getUserNick());

        try {
            BindUserVO bindUserVO = basePhoneUserService.bindUser(bo);
            AppUser appUser=new AppUser();
            appUser.setImgsrc(bindUserVO.getImgsrc());
            appUser.setUserNick(bindUserVO.getUserNick());
            appUser.setToken(bindUserVO.getToken());
            appUser.setImSeller(bindUserVO.getImSeller());
            resp.setUsers(appUser);
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    public ImgUploadResponse imgUpload(ImgUploadRequest request){
        ImgUploadResponse response = new ImgUploadResponse();
        try {
            UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
            userInfoUpdate.setUserId(request.getUserId());
            userInfoUpdate.setHeadUrl(request.getFile());
            basePhoneUserService.imgUpload(userInfoUpdate);
            response.setSuccess(true);
        } catch (OpenException e) {
            response.setException(e);
            response.setSuccess(false);
        }
        return response;
    }

    /**
     * 获取 OSS 临时授权
     * @return
     */
    public CreatePostSignInfoResponse createPostSignInfo(){
        CreatePostSignInfoResponse response = new CreatePostSignInfoResponse();
        try {
            CreatePostSignInfoVO postSignInfo = basePhoneUserService.createPostSignInfo();

            response.setAccessid(postSignInfo.getAccessid());
            response.setPolicy(postSignInfo.getPolicy());
            response.setSignature(postSignInfo.getSignature());
            response.setDir(postSignInfo.getDir());
            response.setHost(postSignInfo.getHost());
            response.setExpire(postSignInfo.getExpire());
            response.setSuccess(true);
        } catch (OpenException e) {
            response.setException(e);
            response.setSuccess(false);
        }
        return response;
    }

}
