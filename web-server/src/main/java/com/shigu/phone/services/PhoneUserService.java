package com.shigu.phone.services;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.AboutMeRequest;
import com.openJar.requests.app.ChangePasswordRequest;
import com.openJar.requests.app.LoginRequest;
import com.openJar.responses.app.AboutMeResponse;
import com.openJar.responses.app.ChangePasswordResponse;
import com.openJar.responses.app.LoginResponse;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.buyer.bo.LoginBO;
import com.shigu.buyer.bo.LoginByPhoneBO;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.UserInfo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.JsonResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

/**
 * 类名：PhoneUserService
 * 类路径：com.shigu.phone.services.PhoneUserService
 * 创建者：王浩翔
 * 创建时间：2017-08-31 17:04
 * 项目：main-pom
 * 描述：移动端用户服务
 */
@Service
public class PhoneUserService {

    @Autowired
    private MemberLicenseMapper memberLicenseMapper;


    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private UserLicenseService userLicenseService;

    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Autowired
    private UserAccountService userAccountService;

    /**
     * 移动端我的信息
     *
     * @param request
     * @return
     */
    public AboutMeResponse aboutMe(AboutMeRequest request) {
        AboutMeResponse resp = new AboutMeResponse();
        UserInfo userInfo = userBaseService.selUserInfo(request.getUserId());
        resp.setUserNick(userInfo.getUserNick());
        resp.setHeadUrl(userInfo.getHeadUrl());
        //获取用户绑定手机
        MemberLicense memberLicense = new MemberLicense();
        memberLicense.setUserId(request.getUserId());
        memberLicense.setLicenseType(MemberLicenseType.PHONE_BIND.getValue());
        memberLicense = memberLicenseMapper.selectOne(memberLicense);
        if (memberLicense != null) {
            resp.setPhoneBind(memberLicense.getContext());
        }
        resp.setSuccess(true);
        return resp;
    }

    /**
     * 移动端登录
     */
    public LoginResponse login(LoginRequest request,HttpServletRequest servletRequest){
        LoginResponse resp=new LoginResponse();
        Integer phoneType = request.getType();
        if (phoneType==1){
            //1普通账号密码登陆
            if(!StringUtil.isNull(request.getUserName())&&!StringUtil.isNull(request.getPassword())){
                //用户名和密码不为空
                Subject currentUser = SecurityUtils.getSubject();
                String passWord = EncryptUtil.encrypt(request.getPassword());

                CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                        request.getUserName(), passWord, false, servletRequest.getRemoteAddr(), "", UserType.MEMBER);
                //星座用户登陆
                token.setLoginFromType(LoginFromType.XZ);
                token.setRememberMe(true);
                //调用安全管理器,安全管理器调用realm
                try {
                   // currentUser.login(token);
                   // currentUser.hasRole(RoleEnum.STORE.getValue());
                    PersonalSession personalSession = userBaseService.selUserForSessionByUserName(request.getUserName(), LoginFromType.XZ);
                    resp.setUserId(personalSession.getUserId());
                    String headUrl = personalSession.getHeadUrl();
                    resp.setImgsrc(headUrl);


                    resp.setUserNick(personalSession.getUserNick());
                    //生成token,存入redis里(未实现)
                    String uuid = UUIDGenerator.getUUID();
                    //imSeller
                    ShopSession logshop = personalSession.getLogshop();
                    if(!StringUtil.isNull(logshop)){
                        resp.setImSeller(true);

                    }else{
                        resp.setImSeller(false);
                    }
                    resp.setToken(uuid);
                    resp.setSuccess(true);
                    return resp;
                } catch (AuthenticationException e) {
                    //登陆失败
                    token.clear();
                }


            }



        }else if(phoneType==2){
            //2手机验证码登陆
            LoginByPhoneBO loginByPhoneBO=new LoginByPhoneBO();
            loginByPhoneBO.setTelephone(request.getUserName());
            loginByPhoneBO.setPhoneVerify(request.getPassword());
        }else{
            //提示错误
        }

        return resp;
    }

    /**
     * 移动端修改密码
     *
     * @param request
     * @return
     */
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) {
        ChangePasswordResponse resp = new ChangePasswordResponse();
        //用户验证不通过或原密码输入不正确
        if (!registerAndLoginService.checkToken(request.getUserId(), request.getToken()) || !EncryptUtil.encrypt(request.getOldPwd()).equals(userBaseService.selUserPwdByUserId(request.getUserId()))) {
            resp.setSuccess(false);
            return resp;
        }
        try {
            userLicenseService.changePassword(request.getUserId(), request.getNewPwd());
            resp.setSuccess(true);
        } catch (Main4Exception e) {
            resp.setException(new OpenException());
        }
        return resp;
    }

}
