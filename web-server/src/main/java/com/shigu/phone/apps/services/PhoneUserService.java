package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.BindUserVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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


    /**
     * 得到手机验证码
     */
    public GetPhoneMsgResponse getPhoneMsg(GetPhoneMsgRequest request){
        GetPhoneMsgResponse resp=new GetPhoneMsgResponse();
        try {
            String msgCode = basePhoneUserService.getPhoneMsg(request.getTelephone(),request.getType());
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
            appUser.setToken(createToken(personalSession.getUserId(),"phone_login_token"));
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
        jedis.setex(key+userId, 604800, inRedisToken);
        return uuid;
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
