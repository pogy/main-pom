package com.shigu.activity.service;

import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import com.opentae.data.mall.beans.ShiguNewActivity;
import com.opentae.data.mall.examples.ShiguNewActiveParticipantsExample;
import com.opentae.data.mall.examples.ShiguNewActivityExample;
import com.opentae.data.mall.interfaces.ShiguNewActiveParticipantsMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.spread.enums.ActiveEnum;
import com.shigu.main4.spread.service.ActiveShowService;
import com.shigu.main4.spread.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类名：ActivityWebService
 * 类路径：com.shigu.activity.service.ActivityWebService
 * 创建者：王浩翔
 * 创建时间：2017-11-21 12:41
 * 项目：main-pom
 * 描述：
 */
@Service
public class ActivityWebService {
    @Autowired
    private ActiveShowService activeShowService;

    @Autowired
    private ShiguNewActivityMapper shiguNewActivityMapper;

    @Autowired
    private ShiguNewActiveParticipantsMapper shiguNewActiveParticipantsMapper;

    public List<ActiveForShowVO> getAwardInfo(Long userId, boolean vipIs){
        List<ActiveForShowVO> activeForShowVOS = activeShowService.selCurrentAwardInfoWithoutUser();
        if (!vipIs) {
            ArrayList<ActiveForShowVO> ignorePemList = new ArrayList<>();
            for (ActiveForShowVO activeForShowVO : activeForShowVOS) {
                if (ActiveEnum.VIP_VOUCHER.getFlag().equals(activeForShowVO.getActName())) {
                    ignorePemList.add(activeForShowVO);
                }
            }
            activeForShowVOS.removeAll(ignorePemList);
        }
        Map<Long, ActivePhaseForShowVO> longActivePhaseForShowVOHashMap = new HashMap<>();
        List<ActivePhaseForShowVO> phaseList = new ArrayList<>();
        for (ActiveForShowVO activeForShowVO : activeForShowVOS) {
            phaseList.addAll(activeForShowVO.getActPhaseList());
            for (ActivePhaseForShowVO activePhaseForShowVO : activeForShowVO.getActPhaseList()) {
                longActivePhaseForShowVOHashMap.put(activePhaseForShowVO.getPemId(),activePhaseForShowVO);
            }
        }
        Map<Long, List<ActiveDrawRecordVO>> pemPrizeMap = activeShowService.selUserAwardInfo(userId, new ArrayList<>(longActivePhaseForShowVOHashMap.keySet())).stream().collect(Collectors.groupingBy(ActiveDrawRecordVO::getPemId));
        Map<Long, Map<String, ActiveDrawRecordVO>> detailMap = new HashMap<>();
        for (Map.Entry<Long, List<ActiveDrawRecordVO>> entry: pemPrizeMap.entrySet()) {
            Map<String, ActiveDrawRecordVO> collect = entry.getValue().stream().collect(Collectors.toMap(ActiveDrawRecordVO::getWard, o -> o));
            detailMap.put(entry.getKey(),collect);
        }
        for (ActivePhaseForShowVO phase : phaseList) {
            Map<String, ActiveDrawRecordVO> pemPrizes = detailMap.get(phase.getPemId());
            for (UserPrizeForShowVO userPrizeForShowVO : phase.getAwardList()) {
                if (pemPrizes == null) {
                    userPrizeForShowVO.setState(2);
                    continue;
                }
                ActiveDrawRecordVO drawRecordVO = pemPrizes.get(userPrizeForShowVO.getRank().toString());
                if (drawRecordVO == null) {
                    userPrizeForShowVO.setState(2);
                    continue;
                }
                userPrizeForShowVO.setState(drawRecordVO.getDrawStatus());
                userPrizeForShowVO.setTakeCode(drawRecordVO.getDrawCode());
                userPrizeForShowVO.setTakedIs(drawRecordVO.getReceivesYes());
            }
        }
        return activeForShowVOS;
    }

    public String queryByCode(String tqcode) throws Main4Exception {
        PrizePoolVO prizePoolVO = activeShowService.selUserDrawList(tqcode);
        return String.format("第%d期可领%s", prizePoolVO.getPemId(), prizePoolVO.getPrizeName());
    }

    /**
     * 当前时间正在进行的上传得现金活动
     * @return
     */
    public ShiguNewActivity getActivityNow() {
        ShiguNewActivity activity = null;
        Date now = new Date();
        ShiguNewActivityExample example = new ShiguNewActivityExample();
        example.setStartIndex(0);
        example.setEndIndex(1);
        ShiguNewActivityExample.Criteria criteria = example.createCriteria();
        criteria.andStartTimeLessThanOrEqualTo(now).andEndTimeGreaterThanOrEqualTo(now);
        List<ShiguNewActivity> activityList = shiguNewActivityMapper.selectByExample(example);
        if (activityList != null && !activityList.isEmpty()) {
            activity = activityList.get(0);
        }
        return activity;
    }

    /**
     * 获取最新的两期上传得现金活动
     * @return
     */
    public List<ShiguNewActivity> getNewestActivityList() {
        Date now = new Date();
        ShiguNewActivityExample example = new ShiguNewActivityExample();
        example.setStartIndex(0);
        example.setEndIndex(2);
        example.setOrderByClause("id desc");
        ShiguNewActivityExample.Criteria criteria = example.createCriteria();
        criteria.andStartTimeLessThanOrEqualTo(now);
        return shiguNewActivityMapper.selectByExample(example);
    }

    /**
     * 上传得现金活动的中奖信息
     * @param userId
     * @return
     */
    public List<ActiveForShowVO> getActivityAwardInfo(Long userId) {
        List<ActiveForShowVO> activeForShowVOList = new ArrayList<>();
        // 获取最新的两期活动
        List<ShiguNewActivity> activityList = getNewestActivityList();
        if (activityList != null && !activityList.isEmpty()) {
            List<ActivePhaseForShowVO> actPhaseList = new ArrayList<>();
            for (ShiguNewActivity activity : activityList) {
                ActivePhaseForShowVO activePhaseForShowVO = new ActivePhaseForShowVO();
                activePhaseForShowVO.setPhaseTime(DateFormatUtils.format(activity.getStartTime(), "yyyy年MM月dd日")
                        + " —— " + DateFormatUtils.format(activity.getEndTime(), "yyyy年MM月dd日"));
                activePhaseForShowVO.setRuleList(Arrays.asList(activity.getActiveRules().split("\n")));
                UserPrizeForShowVO userPrizeForShowVO = new UserPrizeForShowVO();
                userPrizeForShowVO.setImg(StringUtils.isEmpty(activity.getGoodsImgUrl()) ? "http://style.571xz.com/actTest/3.png" : activity.getGoodsImgUrl());
                userPrizeForShowVO.setName("现金奖");
                userPrizeForShowVO.setPrize(Integer.parseInt(activity.getAmount()) / 100 + "元");
                if (activity.getEndTime().getTime() > System.currentTimeMillis()) {
                    userPrizeForShowVO.setState(1); // 等待抽奖
                } else {
                    // 获取用户的中奖信息
                    ShiguNewActiveParticipants query = new ShiguNewActiveParticipants();
                    query.setNewActiveId(activity.getId());
                    query.setMemberId(userId);
                    ShiguNewActiveParticipants participants = shiguNewActiveParticipantsMapper.selectOne(query);
                    if (participants == null) {
                        userPrizeForShowVO.setState(2); // 未中奖
                    } else {
                        if (participants.getWinningStatus() == 3) {
                            userPrizeForShowVO.setState(3); // 已中奖
                            userPrizeForShowVO.setTakedIs(false); // 未领奖
                            userPrizeForShowVO.setTakeCode(participants.getWinningCode());
                        } else if (participants.getWinningStatus() == 4) {
                            userPrizeForShowVO.setState(3); // 已中奖
                            userPrizeForShowVO.setTakedIs(true); // 已领奖
                        } else {
                            userPrizeForShowVO.setState(2); // 未中奖
                        }
                    }
                }
                List<UserPrizeForShowVO> awardList = new ArrayList<>();
                awardList.add(userPrizeForShowVO);
                activePhaseForShowVO.setAwardList(awardList);
                actPhaseList.add(activePhaseForShowVO);
            }
            ActiveForShowVO activeForShowVO = new ActiveForShowVO();
            activeForShowVO.setActName("上传商品得现金活动");
            activeForShowVO.setActPhaseList(actPhaseList);
            activeForShowVOList.add(activeForShowVO);
        }
        return activeForShowVOList;
    }

}
