package com.shigu.main4.spread.processes.impl;

import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.processes.HitDrawChooser;
import com.shigu.main4.spread.service.HitDrawModel;
import com.shigu.main4.spread.vo.active.draw.DrawPrizePool;
import com.shigu.main4.spread.vo.active.draw.DrawResult;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类名：HitDrawChooserImpl
 * 类路径：com.shigu.main4.spread.processes.impl.HitDrawChooserImpl
 * 创建者：王浩翔
 * 创建时间：2017-08-14 17:55
 * 项目：main-pom
 * 描述：
 */
@Component
public class HitDrawChooserImpl implements HitDrawChooser{

    @Override
    public DrawResult tryHitDraw(ActivityDrawEnum drawEnum, DrawVerifyVO drawVerifyVO) {
        //选择对应的抽奖活动
        if (drawEnum != null) {
            HitDrawModel hitDrawModel = SpringBeanFactory.getBeanByName(drawEnum.drawModelName, HitDrawModel.class);
            return hitDraw(hitDrawModel,drawVerifyVO);
        }
        //没有对应的抽奖信息，则返回null
        return null;
    }

    @Override
    public void updateQualification(Long userId,Integer upNum, ActivityDrawEnum drawEnum) {
        if (drawEnum != null) {
            HitDrawModel hitDrawModel = SpringBeanFactory.getBeanByName(drawEnum.drawModelName, HitDrawModel.class);
            hitDrawModel.triggerUpdateQualification(userId,upNum);
        }
    }

    /**
     * 使用具体活动实现进行抽奖
     * @param hitDrawModel
     * @param drawVerifyVO
     * @return
     */
    private synchronized DrawResult hitDraw(HitDrawModel hitDrawModel,DrawVerifyVO drawVerifyVO) {
        hitDrawModel.updatePrizePool();
        List<DrawPrizePool> prizePools = hitDrawModel.selDrawPrizePool();
        return hitDrawModel.tryHitDraw(drawVerifyVO,prizePools);
    }

}
