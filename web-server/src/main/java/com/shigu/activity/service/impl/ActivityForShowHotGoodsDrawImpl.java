package com.shigu.activity.service.impl;

import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.activity.process.HotGoodsDrawService;
import com.shigu.activity.service.ActivityForShowInterface;
import com.shigu.activity.vo.ActivePhaseForShowVO;
import com.shigu.activity.vo.NewActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("tae_activityForShowHotGoodsDrawImpl")
public class ActivityForShowHotGoodsDrawImpl implements ActivityForShowInterface{
    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    @Autowired
    HotGoodsDrawService hotGoodsDrawService;
    @Override
    public void add(Long userId,List activeForShowVOList,NewActivityVO newActivityVO) {
        List<ActivePhaseForShowVO> phaseForShowVOS = hotGoodsDrawService.activityAwards(userId);
        Map<String,Object> map=new HashMap<>();
        map.put("actName",newActivityVO.getActName());
        map.put("actPhaseList",phaseForShowVOS);
        activeForShowVOList.addAll(Collections.singletonList(map));
    }
}
