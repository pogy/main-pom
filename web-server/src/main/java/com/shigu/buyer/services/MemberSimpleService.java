package com.shigu.buyer.services;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.session.main4.enums.LoginFromType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户简单服务
 * Created by zhaohongbo on 17/3/23.
 */
@Service
public class MemberSimpleService {
    @Autowired
    MemberUserSubMapper memberUserSubMapper;

    /**
     * 查用户的淘宝昵称,如果有多个淘宝账号,只取第一个
     * @param userId
     * @return
     */
    public String selNick(Long userId){
        MemberUserSubExample subExample=new MemberUserSubExample();
        subExample.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(LoginFromType.TAOBAO.getAccountType());
        subExample.setStartIndex(0);
        subExample.setEndIndex(1);
        List<MemberUserSub> list=memberUserSubMapper.selectByConditionList(subExample);
        if(list.size()==0){
            return null;
        }
        return list.get(0).getSubUserName();
    }
}
