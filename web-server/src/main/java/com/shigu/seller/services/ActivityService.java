package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguActivity;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.seller.vo.ActivityListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 港风活动报名
 * Created by bugzy on 2017/6/30 0030.
 */
@Service
public class ActivityService {

    @Autowired
    private ShiguActivityMapper shiguActivityMapper;

    private static final String DATE_FORMAT_PARRERN = "yyyy.MM.dd";

    public List<ActivityListVO> selAllActivities() {
        ShiguActivity t = new ShiguActivity();
        List<ShiguActivity> activities = shiguActivityMapper.select(t);
        List<ActivityListVO> activityListVOS = new ArrayList<>(activities.size());
        for (ShiguActivity activity : activities) {
            ActivityListVO vo = new ActivityListVO();
            activityListVOS.add(vo);
            vo.setActid(activity.getActivityId());
            vo.setActTitle(activity.getTitle());
            vo.setActEndTime(DateUtil.dateToString(activity.getEndTime(), DATE_FORMAT_PARRERN));
            vo.setActStartTime(DateUtil.dateToString(activity.getStartTime(), DATE_FORMAT_PARRERN));
            vo.setActImg(activity.getImage());
            vo.setActNums(activity.getNums());
            vo.setApplyTime(
                    DateUtil.dateToString(activity.getStartApply(), DATE_FORMAT_PARRERN)
                            + "-"
                            + DateUtil.dateToString(activity.getEndApply(), DATE_FORMAT_PARRERN));
            vo.setApplyRange(activity.getRuleInfo());
            vo.setChargeStyle(activity.getCostDesc());
            vo.setSupportReturn(activity.getServices().contains("1"));
            vo.setSupportBarter(activity.getServices().contains("2"));
//            vo.setStatusNum(activity.getsta);
            vo.setPartIn(false);
        }
        return activityListVOS;
    }
}
