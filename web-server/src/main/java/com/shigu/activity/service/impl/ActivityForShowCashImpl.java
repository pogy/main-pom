package com.shigu.activity.service.impl;

import com.opentae.data.mall.beans.ShiguNewActiveParticipants;
import com.opentae.data.mall.beans.ShiguNewActivity;
import com.opentae.data.mall.examples.ShiguNewActivityExample;
import com.opentae.data.mall.interfaces.ShiguNewActiveParticipantsMapper;
import com.opentae.data.mall.interfaces.ShiguNewActivityMapper;
import com.shigu.activity.service.ActivityForShowInterface;
import com.shigu.activity.vo.NewActivityVO;
import com.shigu.main4.spread.vo.ActiveForShowVO;
import com.shigu.main4.spread.vo.ActivePhaseForShowVO;
import com.shigu.main4.spread.vo.UserPrizeForShowVO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("tae_activityForShowCashImpl")
public class ActivityForShowCashImpl implements ActivityForShowInterface{
    @Autowired
    ShiguNewActivityMapper shiguNewActivityMapper;
    @Autowired
    ShiguNewActiveParticipantsMapper shiguNewActiveParticipantsMapper;
    @Override
    public void add(Long userId,List activeForShowVOList,NewActivityVO newActivityVO) {
        // 获取最新的两期活动
        ActiveForShowVO activeForShowVO = new ActiveForShowVO();
        activeForShowVO.setActName(newActivityVO.getActName());
        List<ShiguNewActivity> activityList = getNewestActivityList();
        if (activityList != null && !activityList.isEmpty()) {
            List<ActivePhaseForShowVO> actPhaseList = new ArrayList<>();
            for (ShiguNewActivity activity : activityList) {
                ActivePhaseForShowVO activePhaseForShowVO = new ActivePhaseForShowVO();
                activePhaseForShowVO.setPhaseTime(DateFormatUtils.format(activity.getStartTime(), "yyyy年MM月dd日")
                        + " —— " + DateFormatUtils.format(activity.getEndTime(), "yyyy年MM月dd日"));
                activePhaseForShowVO.setRuleList(Arrays.asList(activity.getActiveRules().split("\n")));
                UserPrizeForShowVO userPrizeForShowVO = new UserPrizeForShowVO();
                userPrizeForShowVO.setImg("http://imgs.571xz.net/super/80e6705a65e2ee0c0d6b7b9eb548b5dc.jpg");
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
                            userPrizeForShowVO.setImg("http://imgs.571xz.net/super/fdc2e13ff182ea915032cb2da1b0de74.jpg");
                            userPrizeForShowVO.setState(3); // 已中奖
                            userPrizeForShowVO.setTakedIs(false); // 未领奖
                            userPrizeForShowVO.setTakeCode(participants.getWinningCode());
                        } else if (participants.getWinningStatus() == 4) {
                            userPrizeForShowVO.setImg("http://imgs.571xz.net/super/fdc2e13ff182ea915032cb2da1b0de74.jpg");
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
            activeForShowVO.setActPhaseList(actPhaseList);
            activeForShowVOList.add(activeForShowVO);
        }
    }
    /**
     * 获取最新的两期上传得现金活动
     * @return
     */
    private List<ShiguNewActivity> getNewestActivityList() {
        Date now = new Date();
        ShiguNewActivityExample example = new ShiguNewActivityExample();
        example.setStartIndex(0);
        example.setEndIndex(1);
        example.setOrderByClause("id desc");
        ShiguNewActivityExample.Criteria criteria = example.createCriteria();
        criteria.andStartTimeLessThanOrEqualTo(now).andIdLessThan(11L);
        return shiguNewActivityMapper.selectByConditionList(example);
    }
}
