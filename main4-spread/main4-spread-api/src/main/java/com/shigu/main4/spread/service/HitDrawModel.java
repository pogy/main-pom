package com.shigu.main4.spread.service;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.vo.active.draw.DrawPrizePool;
import com.shigu.main4.spread.vo.active.draw.DrawResult;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;

import java.util.List;

/**
 * 类名：HitDrawModel
 * 类路径：com.shigu.main4.spread.service.HitDrawModel
 * 创建者：王浩翔
 * 创建时间：2017-08-14 15:51
 * 项目：main-pom
 * 描述：抽奖操作
 */
public interface HitDrawModel {
    /**
     * 没有抽奖资格,抽奖结果点数返回NO_DRAW_QUALIFICATION
     */
    Integer NO_DRAW_QUALIFICATION = -1;
    /**
     * 未中奖奖品信息
     */
    String NO_PRIZE = "NO-PRIZE";
    /**
     * 未中奖中奖等级信息
     */
    Integer NO_PRIZE_RANK = 0;
    /**
     * 抽奖
     * @param drawMsg 抽奖人信息
     * @param prizePool 奖池信息
     * @return 抽奖结果
     */
    DrawResult tryHitDraw(DrawVerifyVO drawMsg, List<DrawPrizePool> prizePool) throws JsonErrException;

    /**
     * 获取奖池情况，各活动根据情况具体实现
     * @param
     * @return 本次活动奖池状况
     */
    List<DrawPrizePool> selDrawPrizePool();

    /**
     * 触发自动更新用户抽奖资格信息
     * @param userId
     */
    void triggerUpdateQualification(Long userId,Integer upNum);

    /**
     * 更新奖池信息
     */
    void updatePrizePool();
}
