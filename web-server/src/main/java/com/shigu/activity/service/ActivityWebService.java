package com.shigu.activity.service;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import com.opentae.data.mall.beans.ShiguNewActivity;
import com.opentae.data.mall.examples.ShiguNewActivityExample;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.ShiguNewActiveParticipantsMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityMapper;
import com.shigu.activity.process.NewActivityProcess;
import com.shigu.activity.process.StrengthMemberService;
import com.shigu.activity.vo.NewActivityVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.spread.enums.ActiveEnum;
import com.shigu.main4.spread.service.ActiveShowService;
import com.shigu.main4.spread.vo.*;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    NewActivityProcess newActivityProcess;
    @Autowired
    StrengthMemberService strengthMemberService;
    @Autowired
    private ShiguNewActivityMapper shiguNewActivityMapper;
    @Autowired
    MemberUserSubMapper memberUserSubMapper;

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
     * 上传得现金活动的中奖信息
     * @param userId
     * @return
     */
    public void getActivityAwardInfo(Long userId, Model model) {
        List activeForShowVOList = new ArrayList<>();
        List<NewActivityVO> newActivityVOS = newActivityProcess.selActivitys();
        for (NewActivityVO newActivityVO : newActivityVOS) {
            switch (newActivityVO.getActName()) {
                case "上传商品得现金活动": {
                    SpringBeanFactory.getBean("tae_activityForShowCashImpl", ActivityForShowInterface.class)
                            .add(userId, activeForShowVOList, newActivityVO);
                    break;
                }
                case "实力会员招募" :{
                    SpringBeanFactory.getBean("tae_activityForShowStrengthMemberImpl", ActivityForShowInterface.class)
                            .add(userId, activeForShowVOList, newActivityVO);
                    break;
                }
                case "泉州商品上传抽奖":{
                    SpringBeanFactory.getBean("tae_activityForShowHotGoodsDrawImpl", ActivityForShowInterface.class)
                            .add(userId, activeForShowVOList, newActivityVO);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        model.addAttribute("actList", activeForShowVOList);
    }

}
