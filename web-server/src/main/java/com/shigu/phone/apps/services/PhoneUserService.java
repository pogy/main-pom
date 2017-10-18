package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

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
    private static final Logger logger = LoggerFactory.getLogger(PhoneUserService.class);
    @Autowired
    private BasePhoneUserService basePhoneUserService;

    /**
     * 移动端我的信息
     *
     * @param request
     * @return
     */
    public AboutMeResponse aboutMe( AboutMeRequest request) {
        AboutMeResponse resp = new AboutMeResponse();
        AboutMeVO aboutMeVO = basePhoneUserService.aboutMe(request.getUserId());
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

    //第三方登录
    public String ortherLogin( OrtherLoginRequest request ) {
         return  basePhoneUserService.ortherLogin(request.getType(), request.getNick(), request.getKey());
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
            basePhoneUserService.changePassword(request.getOldPwd(), request.getNewPwd(),request.getUserId(),request.getToken());
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
            resp.setUsers(appUser);
            resp.setSuccess(true);
        } catch (OpenException e) {
            resp.setException(e);
            resp.setSuccess(false);
        }
        return resp;
    }

    /**
     * 移动端绑定手机
     * @param request
     * @return
     */
    public BindUserResponse bindUser( BindUserRequest request, String remoteAddr){
        BindUserResponse resp = new BindUserResponse();
        BindUserBO bo  = new BindUserBO();
        bo.setCode(request.getCode());
        bo.setRemoteAddr(remoteAddr);
        bo.setTelephone(request.getTelephone());
        bo.setTempId(request.getTempId());
        bo.setType(request.getType());
        bo.setUserNick(request.getUserNick());
        try {
            basePhoneUserService.bindUser(bo);
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
