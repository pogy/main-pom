package com.shigu.activity.service.impl;

import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.activity.service.DrawQualification;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.service.HitDrawModel;
import com.shigu.main4.spread.vo.active.draw.DrawVerifyVO;
import com.shigu.main4.spread.vo.active.draw.NewAutumnDrawVerifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：DrawQualificationAutumnImpl
 * 类路径：com.shigu.activity.service.impl.DrawQualificationAutumnImpl
 * 创建者：王浩翔
 * 创建时间：2017-08-14 17:37
 * 项目：main-pom
 * 描述：秋装新品发布会抽奖，奖池信息和抽奖资格信息获取
 */
@Service("newAutumnDrawQualification")
public class DrawQualificationAutumnImpl extends DrawQualification {


    @Autowired
    private ShiguTempMapper shiguTempMapper;
    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    private ActivityDrawEnum newAutumn = ActivityDrawEnum.NEW_AUTUMN;

    @Override
    public DrawVerifyVO hasDrawQualification(Long userId) {
        if (userId == null) {
            return null;
        }
        NewAutumnDrawVerifyVO vo = new NewAutumnDrawVerifyVO();
        vo.setUserId(userId);
        vo.setTerm(newAutumn.term);
        vo.setType(newAutumn.type);
        //获取抽奖记录
        ShiguTemp shiguTemp = new ShiguTemp();
        shiguTemp.setFlag(NewAutumnDrawVerifyVO.DRAW_RECORD_FLAG);
        shiguTemp.setKey1(userId.toString());
        shiguTemp = shiguTempMapper.selectOne(shiguTemp);
        //没有抽奖资格记录
        if (shiguTemp == null) {
            vo.setUsedFrequency(0);
            vo.setOpportunityFrequency(0);
            return vo;
        }
        //已用抽奖次数
        vo.setUsedFrequency(Integer.valueOf(shiguTemp.getKey2()));
        //总抽奖次数
        vo.setOpportunityFrequency(Integer.valueOf(shiguTemp.getKey3()));
        //抽奖记录id
        vo.setDrawVerifyId(shiguTemp.getId());
        //获取中奖记录
        ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
        activeDrawRecord.setUserId(userId);
        activeDrawRecord.setPemId(newAutumn.pemId);
        activeDrawRecord = activeDrawRecordMapper.selectOne(activeDrawRecord);
        if (activeDrawRecord != null) {
            vo.setId(activeDrawRecord.getId());
            vo.setHasWard(activeDrawRecord.getWard());
        }else {
            vo.setHasWard(HitDrawModel.NO_PRIZE);
        }
        return vo;
    }

    @Override
    public ActivityDrawEnum getActiveIdentity() {
        return ActivityDrawEnum.NEW_AUTUMN;
    }

}
