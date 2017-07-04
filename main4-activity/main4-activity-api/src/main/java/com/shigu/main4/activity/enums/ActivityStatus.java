package com.shigu.main4.activity.enums;

import com.shigu.main4.activity.vo.ShiguActivityVO;

import java.util.Date;

/**
 * 活动状态
 * Created by bugzy on 2017/6/30 0030.
 */
public enum ActivityStatus {

    ACTIVITY_NOT_BEGUN(1),// 活动未开始
    ACTION(2),           // 活动进行中
    ACTIVITY_CLOSED(3),   // 活动结束
    ;

    public int status;
    ActivityStatus(int i) {
        this.status = i;
    }

    /**
     *  // 为活动信息设置活动状态
     * @param vo 活动信息
     */
    public static ActivityStatus check(ShiguActivityVO vo) {
        if (vo.getStartTime() == null || vo.getEndTime() == null) {
            throw new RuntimeException(String.format("活动[%d]信息请补全起止时间", vo.getActivityId()));
        }
        Date now = new Date();
        if (now.before(vo.getStartTime()))
            return ACTIVITY_NOT_BEGUN;
        else if (now.after(vo.getEndTime()))
            return ACTIVITY_CLOSED;
        else
            return ACTION;
    }
}
