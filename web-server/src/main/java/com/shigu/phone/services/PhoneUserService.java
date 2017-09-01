package com.shigu.phone.services;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.AboutMeRequest;
import com.openJar.requests.app.ChangePasswordRequest;
import com.openJar.responses.app.AboutMeResponse;
import com.openJar.responses.app.ChangePasswordResponse;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.services.RegisterAndLoginService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
