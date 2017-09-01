package com.shigu.phone.services;

import com.openJar.requests.app.AboutMeRequest;
import com.openJar.responses.app.AboutMeResponse;
import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.examples.MemberLicenseExample;
import com.opentae.data.mall.interfaces.MemberLicenseMapper;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.services.UserBaseService;
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
}
