package com.shigu.main4.spread.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.beans.ActivityDrawPrizePool;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.examples.ActiveDrawRecordExample;
import com.opentae.data.mall.examples.ActivityDrawPrizePoolExample;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ActivityDrawPrizePoolMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.spread.service.ActiveShowService;
import com.shigu.main4.spread.vo.*;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类名：ActiveShowServiceImpl
 * 类路径：com.shigu.main4.spread.service.impl.ActiveShowServiceImpl
 * 创建者：王浩翔
 * 创建时间：2017-11-21 9:36
 * 项目：main-pom
 * 描述：
 */
@Service("activeShowService")
public class ActiveShowServiceImpl implements ActiveShowService {
    
    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

    @Autowired
    private ActivityDrawPrizePoolMapper activityDrawPrizePoolMapper;

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    private SimpleDateFormat showDateFormat = new SimpleDateFormat("yyyy年MM月dd日");


    /**
     * 获取当前可领奖活动期次
     * @return
     */
    @Override
    public List<ActiveDrawPemVo> selShowAwardPems() {
        Calendar instance = Calendar.getInstance();
        Date now = instance.getTime();
        instance.add(Calendar.DATE,-7);
        Date weekAgo = instance.getTime();
        ActiveDrawPemExample example = new ActiveDrawPemExample();
        example.createCriteria().andStartTimeLessThan(now).andEndTimeGreaterThan(weekAgo);
        example.setOrderByClause("start_time desc");
        return BeanMapper.mapList(activeDrawPemMapper.selectByExample(example),ActiveDrawPemVo.class);
    }

    /**
     * 获取当前可领取期次奖品信息（不包括具体用户中奖信息）
     * @return
     */
    @Override
    public List<ActiveForShowVO> selCurrentAwardInfoWithoutUser(){
        List<ActiveDrawPemVo> activeDrawPemVos = selShowAwardPems();
        if (activeDrawPemVos.size() == 0) {
            return new ArrayList<>();
        }
        List<Long> pemIds = BeanMapper.getFieldList(activeDrawPemVos, "id", Long.class);
        ActivityDrawPrizePoolExample activityDrawPrizePoolExample = new ActivityDrawPrizePoolExample();
        activityDrawPrizePoolExample.createCriteria().andPemIdIn(pemIds);
        Map<Long, List<ActivityDrawPrizePool>> pemIdPrizeMap = BeanMapper.groupBy(activityDrawPrizePoolMapper.selectByExample(activityDrawPrizePoolExample), "pemId", Long.class);
        Map<String, List<ActiveDrawPemVo>> flagMap = BeanMapper.groupBy(activeDrawPemVos, "flag", String.class);
        ArrayList<ActiveForShowVO> activeForShowVOS = new ArrayList<>();
        for (Map.Entry<String, List<ActiveDrawPemVo>> entry : flagMap.entrySet()) {
            ActiveForShowVO activeForShowVO = new ActiveForShowVO();
            activeForShowVO.setActName(entry.getKey());
            ArrayList<ActivePhaseForShowVO> actPhaseList = new ArrayList<>();
            activeForShowVO.setActPhaseList(actPhaseList);
            for (ActiveDrawPemVo activeDrawPemVo : entry.getValue()) {
                ActivePhaseForShowVO activePhaseForShowVO = new ActivePhaseForShowVO();
                activePhaseForShowVO.setPemId(activeDrawPemVo.getId());
                activePhaseForShowVO.setStartTime(activeDrawPemVo.getStartTime());
                activePhaseForShowVO.setEndTime(activeDrawPemVo.getEndTime());
                String parseTime = showDateFormat.format(activeDrawPemVo.getStartTime())+"----"+showDateFormat.format(activeDrawPemVo.getEndTime());
                activePhaseForShowVO.setPhaseTime(parseTime);
                JSONObject infoObject = JSONObject.parseObject(activeDrawPemVo.getInfo());
                ArrayList<String> ruleList = new ArrayList<>();
                //活动规则
                for (Object rules : infoObject.getJSONArray("rules")) {
                    ruleList.add(rules.toString());
                }
                activePhaseForShowVO.setRuleList(ruleList);
                ArrayList<UserPrizeForShowVO> userPrizeForShowVOS = new ArrayList<>();
                activePhaseForShowVO.setAwardList(userPrizeForShowVOS);
                List<ActivityDrawPrizePool> activityDrawPrizePools = pemIdPrizeMap.get(activeDrawPemVo.getId());
                for (ActivityDrawPrizePool activityDrawPrizePool : activityDrawPrizePools) {
                    UserPrizeForShowVO userPrizeForShowVO = new UserPrizeForShowVO();
                    userPrizeForShowVO.setRank(activityDrawPrizePool.getRank());
                    userPrizeForShowVO.setName(activityDrawPrizePool.getRankStr());
                    userPrizeForShowVO.setPrize(activityDrawPrizePool.getPrizeName());
                    userPrizeForShowVO.setImg(activityDrawPrizePool.getPrizeImgUrl());
                    userPrizeForShowVOS.add(userPrizeForShowVO);
                }
                actPhaseList.add(activePhaseForShowVO);
            }
            activeForShowVOS.add(activeForShowVO);
        }
        return activeForShowVOS;
    }


    /**
     * 返回对应期次用户所有中奖数据
     * @param userId
     * @param pemIds
     * @return
     */
    @Override
    public List<ActiveDrawRecordVO> selUserAwardInfo(Long userId,List<Long> pemIds) {
        if (pemIds.size()==0) {
            return new ArrayList<>();
        }
        ActiveDrawRecordExample example = new ActiveDrawRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andPemIdIn(pemIds);
        return BeanMapper.mapList(activeDrawRecordMapper.selectByExample(example), ActiveDrawRecordVO.class);
    }


    public PrizePoolVO selUserDrawList(String drawCode) throws Main4Exception {
        ActiveDrawRecord activeDrawRecord = new ActiveDrawRecord();
        activeDrawRecord.setDrawCode(drawCode);
        activeDrawRecord = activeDrawRecordMapper.selectOne(activeDrawRecord);
        if(activeDrawRecord == null){
            throw new Main4Exception("提货码错误");
        }
        if(activeDrawRecord.getDrawStatus() != 3){
            throw new Main4Exception("未中奖");
        }
        if(activeDrawRecord.getReceivesYes()){
            throw new Main4Exception("已经领取，不能重复领取");
        }
        List<ActiveDrawPemVo> activeDrawPemVos = selShowAwardPems();
        if(activeDrawPemVos.size() == 0){
            throw new Main4Exception("数据有误，活动从未开始");
        }
        for (ActiveDrawPemVo activeDrawPemVo : activeDrawPemVos) {
            if (activeDrawPemVo.getId().equals(activeDrawRecord.getPemId())) {
                ActivityDrawPrizePool activityDrawPrizePool = new ActivityDrawPrizePool();
                activityDrawPrizePool.setPemId(activeDrawRecord.getPemId());
                activityDrawPrizePool.setRank(Integer.valueOf(activeDrawRecord.getWard()));
                activityDrawPrizePool = activityDrawPrizePoolMapper.selectOne(activityDrawPrizePool);
                return BeanMapper.map(activityDrawPrizePool, PrizePoolVO.class);
            }
        }
        throw new Main4Exception("已超过领奖时间");
    }

}
