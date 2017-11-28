package com.shigu.main4.activity.service;

import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.activity.vo.GoatActivityWithEnlist;

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

    ActivityVO selActivityById(Long activityId) throws ActivityException;

    GoatActivityWithEnlist selActivityEnlists(Long activityId, Integer hitType) throws ActivityException;

    /**
     * 中签不中签
     * @param enId 报名ID
     * @param ishit 是否中签
     */
    void hitUnhit(Long enId,Boolean ishit) throws ActivityException;

    void delActivity(Long termId,Long activityId);

    void randomTen(Long activityId,Integer number) throws ActivityException;

    /**
     * 获取当前期广告
     * @param type
     * @param time
     * @return
     */
    @Deprecated
    ActivityTermVO selTermByTime(ActivityType type, Date time);

    /**
     * 获取当前期广告，根据男装女装进行区分
     * @param type
     * @param time
     * @param manOrWoman
     * @return
     */
    ActivityTermVO selTermByTime(ActivityType type, Date time,String manOrWoman);

    /**
     * 获取已经结束的最后一期广告
     * @param type
     * @param time
     * @return
     */
    @Deprecated
    ActivityTermVO selNowFinishedTerm(ActivityType type, Date time);

    /**
     * 获取已经结束的最后一期广告，根据男装女装进行区分
     * @param type
     * @param time
     * @param manOrWoman
     * @return
     */
    ActivityTermVO selNowFinishedTerm(ActivityType type, Date time,String manOrWoman);

    Boolean hasJoin(Long activityId,Long userId) throws ActivityException;

    ActivityEnlistVO activityJoinMsg(Long activityId,Long userId) throws ActivityException;

    List<ActivityEnlistVO> selEnlist(int hasTrue,Long activityId) throws ActivityException;

    /**
     * 某一期后面一期
     * @param termId
     * @return
     */
    @Deprecated
    ActivityTermVO selafterTermId(ActivityType type,Long termId);

    /**
     * 获取某一期后面一期
     * @param type
     * @param termId
     * @param manOrWoman
     * @return
     */
    ActivityTermVO selafterTermId(ActivityType type,Long termId, String manOrWoman);

    void joinActivity(Long activityId,Long userId,Long shopId,String userName,String tel) throws ActivityException;
}
