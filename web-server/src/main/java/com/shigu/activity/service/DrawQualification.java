package com.shigu.activity.service;

import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.processes.HitDrawChooser;
import com.shigu.main4.spread.vo.active.draw.DrawResult;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：DrawQualification
 * 类路径：com.shigu.activity.service.DrawQualification
 * 创建者：王浩翔
 * 创建时间：2017-08-14 14:35
 * 项目：main-pom
 * 描述：
 */
public abstract class DrawQualification {

    @Autowired
    private HitDrawChooser hitDrawChooser;
    /**
     * 获取用户抽奖资格
     * @param userId
     * @return 本次活动用户抽奖资格，活动信息由具体抽奖活动实现类自带
     */
    public abstract DrawVerifyVO hasDrawQualification(Long userId);

    public abstract ActivityDrawEnum getActiveIdentity();

    /**
     * 用户上款时更新抽奖资格
     * @param userId 用户id
     * @param upNum 上款量
     */
    public void updateQualification(Long userId, Integer upNum){
        hitDrawChooser.updateQualification(userId,upNum,getActiveIdentity());
    }

    /**
     * 抽奖
     * @param userId 用户id
     * @return
     */
    public DrawResult tryHitDraw(Long userId){
        DrawVerifyVO drawVerifyVO = hasDrawQualification(userId);
        return hitDrawChooser.tryHitDraw(getActiveIdentity(),drawVerifyVO);
    }

}
