package com.shigu.main4.activity.service.impl;

import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.GoatActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.Activity;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.service.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.activity.vo.GoatActivityWithEnlist;
import com.shigu.main4.activity.vo.GoatSimpleVO;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        ActivityTerm term=activityFactory.selTermById(termId);
        ActivityTermVO termVO=BeanMapper.map(term,ActivityTermVO.class);
        List<ActivityVO> vos=term.selActivitys();
        String content="";
        if (vos != null) {
            for(ActivityVO vo:vos){
                content+=","+vo.toString();
            }
        }
        termVO.setContent(content);
        return termVO;
    }

    @Override
    public List<ActivityVO> selActivityInTerm(Long termId) {
        return activityFactory.selTermById(termId).selActivitys();
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

    @Override
    public GoatActivityWithEnlist selActivityEnlists(Long activityId, Integer hitType) throws ActivityException {
        GoatActivity activity=activityFactory.selActivityById(activityId);
        GoatActivityWithEnlist gawe=BeanMapper.map(activity,GoatActivityWithEnlist.class);
        gawe.setEnlists(activity.selEnlist(hitType));
        return gawe;
    }

    @Override
    public void hitUnhit(Long enId, Boolean ishit) throws ActivityException {
        ActivityEnlist enlist=activityFactory.selEnlistById(enId);
        if(ishit){
            enlist.hit();
        }else{
            enlist.unhit();
        }
    }

}
