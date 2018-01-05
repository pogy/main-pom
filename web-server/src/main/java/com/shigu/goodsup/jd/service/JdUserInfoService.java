package com.shigu.goodsup.jd.service;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/26/11:01
 * 根据userId查询京东uid
 */
@Service
public class JdUserInfoService {

    @Autowired
    private MemberUserSubMapper mebMemberUserSubMapper;

    /**
     *  根据userId查询京东uid
     * @param subUid
     * @return
     * @throws JdNotBindException
     */
    public String getJdUidBySubUid(Long subUid) {
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserId(subUid);
        memberUserSub.setAccountType(LoginFromType.JD.getAccountType());
        memberUserSub = mebMemberUserSubMapper.selectOne(memberUserSub);
        return memberUserSub.getSubUserKey();
    }
}
