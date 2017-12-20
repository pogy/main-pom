package com.shigu.main4.activity.model;

import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;

import java.util.Date;

/**
 * 活动工厂服务
 *
 * Created by zhaohongbo on 17/5/4.
 */
public interface ActivityFactory {
    /**
     * 添加并取得一期
     * @param vo
     * @return
     */
    ActivityTerm addAndGetTerm(ActivityTermVO vo) throws ActivityException;
    /**
     * 获得某一类别活动中,某一时间有效的一期
     * @param type 活动类别
     * @param time 时间
     * @param manOrWoman 男装广告：man  女装广告：woman  全站广告放在男装广告中
     * @return 期次对象
     */
    ActivityTerm selTermByTime(ActivityType type, Date time, String manOrWoman);

    /**
     * 获得某一类别活动中,某一时间前结束的最后一期
     * @param type
     * @param time
     * @param manOrWoman 男装广告：man  女装广告：woman  全站广告放在男装广告中
     * @return
     */
    ActivityTerm selNowFinishedTerm(ActivityType type, Date time, String manOrWoman);

    /**
     * 某一期后面一期
     * @param termId
     * @param manOrWoman 男装广告：man  女装广告：woman  全站广告放在男装广告中
     * @return
     */
    ActivityTerm selafterTermId(ActivityType type,Long termId, String manOrWoman);

    /**
     * 查排期中的
     * @param type
     * @return
     */
    ActivityTerm selTermInPaiqi(ActivityType type);

    /**
     * 按期ID查某一期次
     * @param termId 期次ID
     * @return 期次对象
     */
    ActivityTerm selTermById(Long termId);

    /**
     * 按活动ID查某一活动
     * @param activityId 活动ID
     * @return 具体活动对象
     */
    <T extends Activity> T selActivityById(Long activityId) throws ActivityException;

    /**
     * 按期次ID查投放的广告
     * @param vo 活动值对象
     * @return 活动对象
     */
    <T extends Activity> T selActivityByVo(ActivityVO vo);

    /**
     * 按广告投放ID查报名单
     * @param enlistId 报名记录ID
     * @return 报名记录对象
     */
    ActivityEnlist selEnlistById(Long enlistId) throws ActivityException;

    /**
     * 按广告投放值对象查报名单
     * @param vo 报名值
     * @return 报名对象
     */
    ActivityEnlist selEnlistByVo(ActivityEnlistVO vo);
}
