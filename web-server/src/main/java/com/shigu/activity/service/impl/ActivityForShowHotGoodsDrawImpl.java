package com.shigu.activity.service.impl;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import com.opentae.data.mall.beans.ShiguNewActivity;
import com.opentae.data.mall.examples.ShiguNewActivityExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShiguNewActiveParticipantsMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityMapper;
import com.shigu.activity.process.StrengthMemberService;
import com.shigu.activity.service.ActivityForShowInterface;
import com.shigu.activity.vo.NewActivityVO;
import com.shigu.main4.spread.vo.ActiveForShowVO;
import com.shigu.main4.spread.vo.ActivePhaseForShowVO;
import com.shigu.main4.spread.vo.UserPrizeForShowVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("tae_activityForShowHotGoodsDrawImpl")
public class ActivityForShowHotGoodsDrawImpl implements ActivityForShowInterface{
    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    @Autowired
    StrengthMemberService strengthMemberService;
    @Override
    public void add(Long userId,List activeForShowVOList,NewActivityVO newActivityVO) {

    }
}
