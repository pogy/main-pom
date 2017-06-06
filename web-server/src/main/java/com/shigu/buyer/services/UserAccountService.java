package com.shigu.buyer.services;

import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.session.main4.Rds3TempUser;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户账户功能
 * Created by bugzy on 2017/6/5 0005.
 */
@Service
public class UserAccountService {
    
    @Autowired
    private UserLicenseService userLicenseService;
    
    @Autowired
    private RegisterAndLoginService registerAndLoginService;

    @Transactional
    public void bindAccount(Rds3TempUser rds3TempUser, String telephone, String remoteAddr) throws JsonErrException {
        /*
             * 如果是手机来的,就是星座号绑定手机
             */
        try {
            if (rds3TempUser.getLoginFromType().equals(LoginFromType.PHONE)) {
                if (registerAndLoginService.userCanRegist(telephone, LoginFromType.PHONE)) {
                    userLicenseService.bindPhone(Long.valueOf(rds3TempUser.getSubUserKey()), telephone);
                } else {
                    throw new JsonErrException("该手机号已被使用").addErrMap("ele", "telephone");
                }
                rds3TempUser.setSubUserName(telephone);
            } else {
                registerAndLoginService.bind3RdUser(telephone, rds3TempUser);
            }
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage()).addErrMap("ele", "telephone");
        }
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                rds3TempUser.getSubUserName(), null, false, remoteAddr, "", UserType.MEMBER);
        token.setLoginFromType(rds3TempUser.getLoginFromType());
        //星座用户登陆
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            currentUser.hasRole(RoleEnum.STORE.getValue());
        } catch (LoginAuthException e) {
            throw new JsonErrException(e.getMessage()).addErrMap("ele", "telephone");
        }
    }
}
