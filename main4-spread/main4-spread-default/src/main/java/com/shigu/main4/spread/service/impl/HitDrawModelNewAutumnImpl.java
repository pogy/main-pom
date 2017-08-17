package com.shigu.main4.spread.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.spread.enums.ActivityDrawEnum;
import com.shigu.main4.spread.service.HitDrawModel;
import com.shigu.main4.spread.vo.active.draw.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：HitDrawModelNewAutumnImpl
 * 类路径：com.shigu.main4.spread.service.impl.HitDrawModelNewAutumnImpl
 * 创建者：王浩翔
 * 创建时间：2017-08-14 16:03
 * 项目：main-pom
 * 描述：秋装新品发布会抽奖
 */
@Component("hitDrawModelNewAutumn")
public class HitDrawModelNewAutumnImpl implements HitDrawModel {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ShiguTempMapper shiguTempMapper;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    /**
     * 抽奖
     *
     * @param drawMsg   抽奖人信息
     * @param prizePool 奖池信息
     * @return 抽奖结果 没有抽奖资格则返回null
     */
    @Override
    public DrawResult tryHitDraw(DrawVerifyVO drawMsg, List<DrawPrizePool> prizePool) throws JsonErrException {
        ActivityDrawEnum newAutumn = ActivityDrawEnum.NEW_AUTUMN;
        NewAutumnDrawVerifyVO msg = (NewAutumnDrawVerifyVO) drawMsg;
        String hasWard = msg.getHasWard();
        int usedFrequency = msg.getUsedFrequency() == null ? 0 : msg.getUsedFrequency();
        //有抽奖资格：已抽奖次数小于可抽奖次数
        if (usedFrequency++ < msg.getOpportunityFrequency() ) {
            NewAutumnPrizePool resultPool = BeanMapper.map(new DrawHitter(1000, DrawHitter.PrizeStrategy.PRIZE_CANCLE).tryHitDraw(prizePool),NewAutumnPrizePool.class);
            DrawResult drawResult = null;
            if (resultPool.getRank() != null) {
                drawResult = new DrawResult(resultPool.getHitResult(),resultPool.getRank(),resultPool.getPrizeGood());
            } else {
                drawResult = new DrawResult(resultPool.getHitResult(),HitDrawModel.NO_PRIZE_RANK,HitDrawModel.NO_PRIZE);
            }
            //已经中过非参与奖
            boolean hasHitBigPrize = !(hasWard == null || "".equals(hasWard) || NO_PRIZE.equals(hasWard));
            //if (!(hasWard == null || "".equals(hasWard)||NO_PRIZE.equals(hasWard))){
            //    drawResult = new DrawResult((int)(Math.random()*1000)+1,HitDrawModel.NO_PRIZE_RANK,HitDrawModel.NO_PRIZE);
            //}
            ShiguTemp temp = new ShiguTemp();
            temp.setId(msg.getDrawVerifyId());
            temp.setKey2(String.valueOf(usedFrequency));
            if (drawResult.getRank()>0 ) {
                //更新中奖信息
                //中了1、2、3等奖，不再有中大奖资格
                if (drawResult.getRank() >= 4 || !hasHitBigPrize) {
                    if (drawResult.getRank()<4) {
                        temp.setKey5(drawResult.getPrizeName());
                    }
                    ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
                    activeDrawRecord.setWard(drawResult.getPrizeName());
                    activeDrawRecord.setPemId(newAutumn.pemId);
                    activeDrawRecord.setUserId(msg.getUserId());
                    activeDrawRecord.setDrawStatus(1);
                    activeDrawRecord.setCreateTime(new Date());
                    activeDrawRecord.setModifyTime(new Date());
                    activeDrawRecord.setDrawCode(StringUtil.str10To37Str());
                    activeDrawRecord.setReceivesYes(false);
                    activeDrawRecord.setEnabled(false);
                    activeDrawRecordMapper.insert(activeDrawRecord);
                }else {
                    drawResult = new DrawResult(resultPool.getHitResult(),HitDrawModel.NO_PRIZE_RANK,HitDrawModel.NO_PRIZE);
                }
                ShiguTemp updatePool = new ShiguTemp();
                updatePool.setId(resultPool.getId());
                updatePool.setKey1(resultPool.getCurrentPrizeNum()-1+"");
                updatePool.setKey2(resultPool.getDistributedNum()+1+"");
                shiguTempMapper.updateByPrimaryKeySelective(updatePool);
            }
            shiguTempMapper.updateByPrimaryKeySelective(temp);
            return drawResult;
        }
        //没有抽奖资格
        throw new JsonErrException("没有抽奖资格");
    }


    @Override
    public List<DrawPrizePool> selDrawPrizePool() {
        ActivityDrawEnum newAutumn = ActivityDrawEnum.NEW_AUTUMN;
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andFlagEqualTo(NewAutumnPrizePool.PRIZE_POOL_FLAG);
        return shiguTempMapper.selectByExample(example).stream().map(o -> {
            //在temp表key1中的奖池记录中，在key6存放常量信息
            JSONObject constantMsg = JSON.parseObject(o.getKey6());
            NewAutumnPrizePool vo = new NewAutumnPrizePool();
            //主键
            vo.setId(o.getId());
            //活动常量信息
            vo.setTerm(newAutumn.term);
            vo.setPemId(newAutumn.pemId);
            vo.setActiveType(newAutumn.type);
            vo.setActiveName(newAutumn.activeName);
            //起始时间
            vo.setStartTime(constantMsg.getDate("startTime"));
            //截止时间
            vo.setDeadline(constantMsg.getDate("deadline"));
            //常量信息
            //奖品总数
            vo.setFullNumber(constantMsg.getInteger("fullNumber"));
            //中奖率：值/1000
            vo.setHitProbability(constantMsg.getInteger("hitProbability"));
            //奖品等级：1等奖，2等奖。。。
            vo.setRank(constantMsg.getInteger("rank"));
            //奖品
            vo.setPrizeGood(constantMsg.getString("prizeGood"));
            //变量信息
            //当前剩余可发奖品数量
            vo.setCurrentPrizeNum(Integer.valueOf(o.getKey1()));
            //已被抽中奖品数量
            vo.setDistributedNum(Integer.valueOf(o.getKey2()));
            //下次奖池投放奖品数量
            vo.setThrowNum(Integer.valueOf(o.getKey3()));
            //奖池更新周期
            vo.setUpdatePeriod(Integer.valueOf(o.getKey5()));
            //下次奖池投放奖品时间
            try {
                vo.setNextThrowInTime(sdf.parse(o.getKey4()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public void triggerUpdateQualification(Long userId,Integer upNum) {
        if (userId == null) {
            return;
        }
        int opportunityNum = upNum > 19 ? 5 : upNum > 12 ? 4 : upNum > 8 ? 3 : upNum > 4 ? 2 : upNum > 2 ? 1 : 0;
        if (opportunityNum == 0) {
            return;
        }
        ShiguTemp shiguTemp = new ShiguTemp();
        shiguTemp.setFlag(NewAutumnDrawVerifyVO.DRAW_RECORD_FLAG);
        shiguTemp.setKey1(userId.toString());
        ShiguTemp temp = shiguTempMapper.selectOne(shiguTemp);
        if (temp != null) {
            temp.setKey3(String.valueOf(opportunityNum));
            temp.setKey4(upNum.toString());
            shiguTempMapper.updateByPrimaryKeySelective(temp);
            return;
        }
        //没有抽奖记录，插入抽奖记录
        //设置可抽奖次数
        shiguTemp.setKey3(String.valueOf(opportunityNum));
        //设置上款量
        shiguTemp.setKey4(upNum.toString());
        //设置已抽奖次数
        shiguTemp.setKey2(String.valueOf(0));
        //添加抽奖资格记录
        shiguTempMapper.insertSelective(shiguTemp);
    }

    @Override
    public void updatePrizePool() {
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andFlagEqualTo(NewAutumnPrizePool.PRIZE_POOL_FLAG);
        for (ShiguTemp pool : shiguTempMapper.selectByExample(example)) {
            try {
                Date updateTime = sdf.parse(pool.getKey4());
                if (updateTime.before(new Date())) {
                    //奖池奖品投放
                    pool.setKey1(String.valueOf(Integer.valueOf(pool.getKey1()) + Integer.valueOf(pool.getKey3())));
                    //更新下次奖品投放时间
                    pool.setKey4(sdf.format(new Date(Integer.valueOf(pool.getKey5()) * 60 * 60 * 1000 + updateTime.getTime())));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
