package com.shigu.main4.activity.model;

import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.vo.ActivityEnlistVO;

import java.util.Date;
import java.util.List;

/**
 * 活动投放
 * Created by zhaohongbo on 17/5/4.
 */
public interface Activity {
    /**
     * 活动参与限制
     * @return true允许
     */
    boolean limit(Object... param);

    /**
     * 参加活动
     * @param userId 用户ID
     * @param shopId 店铺ID
     * @param name 联系人
     * @param phone 联系电话
     * @return 报名记录ID
     */
    Long joinActivity(Long userId,Long shopId,String name,String phone) throws ActivityException;

    /**
     * 在报名人中,随机命中指定人数
     * @param number 人数
     * @return 命中的人列表
     */
    List<ActivityEnlistVO> randomHit(Integer number) throws ActivityException;

    /**
     * 查询报名列表
     * @param hitType 命中类别,0不命中,1命中,2命中+不命中
     * @return 命中的人列表
     */
    List<ActivityEnlistVO> selEnlist(int hitType);

    /**
     * 是否参与
     * @param userId
     * @return
     */
    Boolean hasJoin(Long userId);

    ActivityEnlistVO joinMsg(Long userId);

}
