package com.shigu.main4.spread.processes;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.vo.active.draw.DrawResult;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;

/**
 * 类名：HitDrawChooser
 * 类路径：com.shigu.main4.spread.processes.HitDrawChooser
 * 创建者：王浩翔
 * 创建时间：2017-08-14 17:51
 * 项目：main-pom
 * 描述：选择活动抽奖模型
 */
public interface HitDrawChooser {

    /**
     * 没有对应活动
     * @param drawEnum 抽奖活动对应常量值，用于选择抽奖模型
     * @param drawVerifyVO 用户抽奖资格信息
     * @return
     */
    DrawResult tryHitDraw(ActivityDrawEnum drawEnum, DrawVerifyVO drawVerifyVO);

    /**
     * 上款更新抽奖资格
     * @param userId
     * @param drawEnum
     * @throws JsonErrException
     */
    void updateQualification(Long userId,Integer upNum, ActivityDrawEnum drawEnum);

}
