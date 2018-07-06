package com.shigu.goodsup.sn.service;

import com.openJar.requests.api.SnBrandRequest;
import com.openJar.responses.api.SnBrandResponse;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.session.main4.enums.LoginFromType;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnUserInfoService {
    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    @Autowired
    XzJdSdkSend xzJdSdkSend;

    public String getSnUsernameBySubUid(Long subUid){
        MemberUserSub memberUserSub = new MemberUserSub();
        memberUserSub.setSubUserId(subUid);
        memberUserSub.setAccountType(LoginFromType.SN.getAccountType());
        memberUserSub=memberUserSubMapper.selectOne(memberUserSub);
        return memberUserSub.getSubUserKey();
    }

    public List<NewbrandQueryResponse.QueryNewbrand> getBrand(String username,String categoryCode){
        SnBrandRequest snBrandRequest= new SnBrandRequest();
        snBrandRequest.setUsername(username);
        snBrandRequest.setCategoryCode(categoryCode);
        SnBrandResponse response=new SnBrandResponse();
        try {
            response = xzJdSdkSend.send(snBrandRequest);
        }catch (Exception e){
            return null;
        }
        if(!response.isSuccess()){
            return null;
        }
        return response.getQueryNewbrand();
    }
}
