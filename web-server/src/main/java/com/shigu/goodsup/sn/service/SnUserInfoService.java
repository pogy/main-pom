package com.shigu.goodsup.sn.service;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnUserInfoService {
    @Autowired
    MemberUserSubMapper memberUserSubMapper;

    public String getSnUsernameBySubUid(Long subUid){
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserId(subUid);
        memberUserSub.setAccountType(LoginFromType.SN.getAccountType());
        memberUserSub=memberUserSubMapper.selectOne(memberUserSub);
        return memberUserSub.getSubUserKey();
    }
}
