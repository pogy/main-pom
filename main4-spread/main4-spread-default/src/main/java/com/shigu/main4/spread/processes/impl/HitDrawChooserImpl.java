package com.shigu.main4.spread.processes.impl;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.processes.HitDrawChooser;
import com.shigu.main4.spread.service.HitDrawModel;
import com.shigu.main4.spread.vo.active.draw.DrawPrizePool;
import com.shigu.main4.spread.vo.active.draw.DrawResult;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 类名：HitDrawChooserImpl
 * 类路径：com.shigu.main4.spread.processes.impl.HitDrawChooserImpl
 * 创建者：王浩翔
 * 创建时间：2017-08-14 17:55
 * 项目：main-pom
 * 描述：
 */
@Component("hitDrawChooser")
public class HitDrawChooserImpl implements HitDrawChooser{

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public DrawResult tryHitDraw(ActivityDrawEnum drawEnum, DrawVerifyVO drawVerifyVO) throws JsonErrException {
        //不在抽奖活动期间，无法抽奖
        boolean verifyTime = verifyTime(drawEnum);
        if (!verifyTime) {
            throw new JsonErrException("不在抽奖时间内");
        }
        //选择对应的抽奖活动
        if (drawEnum != null) {
            HitDrawModel hitDrawModel = SpringBeanFactory.getBeanByName(drawEnum.drawModelName, HitDrawModel.class);
            return hitDraw(hitDrawModel,drawVerifyVO);
        }
        //没有对应的抽奖信息，则返回null
        throw new JsonErrException("不在活动时间内");
    }

    @Override
    public void updateQualification(Long userId,Integer upNum, ActivityDrawEnum drawEnum) {
        //不在活动期间
        if (!verifyTime(drawEnum)) {
            return;
        }
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
    private synchronized DrawResult hitDraw(HitDrawModel hitDrawModel,DrawVerifyVO drawVerifyVO) throws JsonErrException {
        hitDrawModel.updatePrizePool();
        List<DrawPrizePool> prizePools = hitDrawModel.selDrawPrizePool();
        return hitDrawModel.tryHitDraw(drawVerifyVO,prizePools);
    }

    private boolean verifyTime(ActivityDrawEnum drawEnum) {
        Date deadline = null;
        Date startTime = null;
        try {
            deadline = sdf.parse(drawEnum.deadline);
            startTime = sdf.parse(drawEnum.startTime);
        } catch (ParseException e) {
            return false;
        }
        Date now = new Date();
        //在抽奖活动时间内，可以进行抽奖
        if (now.after(startTime)&&now.before(deadline)){
            return true;
        }
        return false;
    }
}
