package com.shigu.main4.activity.service.impl;

import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.LedActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.model.Activity;
import com.shigu.main4.activity.service.ActivityDubboService;
import com.shigu.main4.activity.model.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.activity.vo.GoatActivityWithEnlist;
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
    public <T extends ActivityVO> List<T> selActivityInTerm(Long termId) {
        return activityFactory.selTermById(termId).selActivitys();
    }

    @Override
    public void modifyTerm(Long termId,ActivityType type, Date start, Date end) throws ActivityException {
        modifyTerm(termId, type, start, end,null);
    }

    @Override
    public void modifyTerm(Long termId, ActivityType type, Date start, Date end, String manOrWoman) throws ActivityException {
        ActivityTerm term=activityFactory.selTermById(termId);
        term.modify(type,start,end,manOrWoman);
    }

    @Override
    public <T extends ActivityVO> Long throwActivity(Long termId, T activity) {
        ActivityTerm term=activityFactory.selTermById(termId);
        return term.throwActivity(activity);
    }

    @Override
    public ActivityVO selActivityById(Long activityId) throws ActivityException {
        System.out.println("112112121");
        ActivityVO activityVO=BeanMapper.map(activityFactory.selActivityById(activityId),ActivityVO.class);
        System.out.println(activityVO);
        return activityVO;
    }

    @Override
    public GoatActivityWithEnlist selActivityEnlists(Long activityId, Integer hitType) throws ActivityException {
        Activity activity=activityFactory.selActivityById(activityId);
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

    @Override
    public void delActivity(Long termId, Long activityId) {
        ActivityTerm term=activityFactory.selTermById(termId);
        term.delActivity(activityId);
    }

    @Override
    public void randomTen(Long activityId, Integer number) throws ActivityException {
        LedActivity activity=activityFactory.selActivityById(activityId);
        activity.randomHit(number);
    }

    @Override
    public ActivityTermVO selTermByTime(ActivityType type, Date time) {
        return selTermByTime(type, time, "man");
    }

    @Override
    public ActivityTermVO selTermByTime(ActivityType type, Date time, String manOrWoman) {
        return BeanMapper.map(activityFactory.selTermByTime(type,time,manOrWoman),ActivityTermVO.class);
    }

    @Override
    public ActivityTermVO selNowFinishedTerm(ActivityType type, Date time) {
        return selNowFinishedTerm(type,time,"man");
    }

    @Override
    public ActivityTermVO selNowFinishedTerm(ActivityType type, Date time, String manOrWoman) {
        return BeanMapper.map(activityFactory.selNowFinishedTerm(type,time,manOrWoman),ActivityTermVO.class);
    }

    @Override
    public Boolean hasJoin(Long activityId, Long userId) throws ActivityException {
        return activityFactory.selActivityById(activityId).hasJoin(userId);
    }

    @Override
    public ActivityEnlistVO activityJoinMsg(Long activityId, Long userId) throws ActivityException {
        return activityFactory.selActivityById(activityId).joinMsg(userId);
    }

    @Override
    public List<ActivityEnlistVO> selEnlist(int hasTrue,Long activityId) throws ActivityException {
        return activityFactory.selActivityById(activityId).selEnlist(hasTrue);
    }

    @Override
    public ActivityTermVO selafterTermId(ActivityType type, Long termId) {
        return selafterTermId(type,termId,"man");
    }

    @Override
    public ActivityTermVO selafterTermId(ActivityType type, Long termId, String manOrWoman) {
        return BeanMapper.map(activityFactory.selafterTermId(type,termId,manOrWoman),ActivityTermVO.class);
    }

    @Override
    public void joinActivity(Long activityId, Long userId, Long shopId,String userName, String tel) throws ActivityException {
        activityFactory.selActivityById(activityId).joinActivity(userId,shopId,userName,tel);
    }



}
