package com.shigu.activity.service.impl;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.activity.process.StrengthMemberService;
import com.shigu.activity.service.ActivityForShowInterface;
import com.shigu.activity.vo.NewActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tae_activityForShowStrengthMemberImpl")
public class ActivityForShowStrengthMemberImpl implements ActivityForShowInterface{


    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    @Autowired
    StrengthMemberService strengthMemberService;
    @Override
    public void add(Long userId,List activeForShowVOList,NewActivityVO newActivityVO) {
        MemberUserSub sub=new MemberUserSub();
        sub.setAccountType(3);
        sub.setUserId(userId);
        List<MemberUserSub> subs=memberUserSubMapper.select(sub);
        String nick=null;
        if(subs.size()!=0){
            nick=subs.get(0).getSubUserName();
        }
        activeForShowVOList.addAll(strengthMemberService.activityAwards(nick,newActivityVO.getActId()));
    }
}
