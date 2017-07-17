package com.shigu.main4.activity.service;

import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.activity.vo.GoatActivityWithEnlist;
import com.shigu.main4.activity.vo.GoatSimpleVO;

import java.util.Date;
import java.util.List;

/**
 * 活动对外接口
 * Created by zhaohongbo on 17/5/9.
 */
public interface ActivityDubboService {
    Long addTerm(ActivityTermVO vo) throws ActivityException;

    ActivityTermVO selByTermId(Long termId);

    <T extends ActivityVO> List<T> selActivityInTerm(Long termId);

    void modifyTerm(Long termId,ActivityType type, Date start, Date end) throws ActivityException;

    <T extends ActivityVO> Long throwActivity(Long termId,T activity);

    GoatActivityWithEnlist selActivityEnlists(Long activityId, Integer hitType) throws ActivityException;

    /**
     * 中签不中签
     * @param enId 报名ID
     * @param ishit 是否中签
     */
    void hitUnhit(Long enId,Boolean ishit) throws ActivityException;

    void delActivity(Long termId,Long activityId);

    void randomTen(Long activityId,Integer number) throws ActivityException;
}