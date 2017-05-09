package com.shigu.main4.activity.service.impl;

import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.service.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 活动对外接口
 * Created by zhaohongbo on 17/5/9.
 */
@Service("activityDubboService")
public class ActivityDubboServiceImpl implements ActivityDubboService{

    @Autowired
    ActivityFactory activityFactory;

    @Override
    public Long addTerm(ActivityTermVO vo) throws ActivityException {
        return activityFactory.addAndGetTerm(vo).getTermId();
    }

    @Override
    public ActivityTermVO selByTermId(Long termId) {
        return activityFactory.selTermById(termId);
    }

    @Override
    public void modifyTerm(Long termId,ActivityType type, Date start, Date end) throws ActivityException {
        ActivityTerm term=activityFactory.selTermById(termId);
        term.modify(type,start,end);
    }

    @Override
    public <T extends ActivityVO> Long throwActivity(Long termId, T activity) {
        ActivityTerm term=activityFactory.selTermById(termId);
        return term.throwActivity(activity);
    }
}
