package com.shigu.main4.active.enums;

import com.shigu.main4.active.vo.ShiguActivityVO;

import java.util.Date;

/**
 * 活动申请状态
 * Created by bugzy on 2017/6/30 0030.
 */
public enum ApplyStatus {
    
     APPLY_NOT_BEGUN,   // 活动未开始报名
     APPLYING,          // 活动正在报名
     APPLY_CLOSED,     // 报名结束
    ;

    /**
     * // 为活动信息设置报名状态
     * @param vo 活动信息
     */
     public static ApplyStatus check(ShiguActivityVO vo) {
         if (vo.getStartApply() == null || vo.getEndApply() == null) {
             return APPLY_NOT_BEGUN;
         }
         Date now = new Date();
         if (now.before(vo.getStartApply()))
             return APPLY_NOT_BEGUN;
         else if (now.after(vo.getEndApply()))
             return APPLY_CLOSED;
         else
             return APPLYING;
     }
}
