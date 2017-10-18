package com.shigu.phone.apps.services;

import com.openJar.beans.app.AppUser;
import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.*;
import com.openJar.responses.app.*;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.RegisterUser;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.main4.ucenter.vo.UserInfoUpdate;
import com.shigu.phone.api.actions.PhoneMsgAction;
import com.shigu.phone.api.enums.PhoneMsgTypeEnum;
import com.shigu.phone.apps.utils.TokenUtil;
import com.shigu.phone.basebo.BindUserBO;
import com.shigu.phone.baseservices.BasePhoneUserService;
import com.shigu.phone.basevo.AboutMeVO;
import com.shigu.phone.basevo.CreatePostSignInfoVO;
import com.shigu.phone.basevo.OrtherLoginVO;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.RedomUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
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
    public Object ortherLogin( OrtherLoginRequest request ) {
        OrtherLoginResponse resp=new OrtherLoginResponse();
        try {
            OrtherLoginVO ortherLoginVO = basePhoneUserService.ortherLogin(request.getType(), request.getNick(), request.getKey());
            resp.setTempId(ortherLoginVO.getTempId());
            resp.setType(ortherLoginVO.getType());
            resp.setUrl(ortherLoginVO.getUrl());
            resp.setUsers(ortherLoginVO.getUsers());
            resp.setSuccess(true);
        } catch (OpenException e) {
           resp.setException(e);
           resp.setSuccess(false);
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
