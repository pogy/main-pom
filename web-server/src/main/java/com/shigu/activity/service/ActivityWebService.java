package com.shigu.activity.service;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.spread.enums.ActiveEnum;
import com.shigu.main4.spread.service.ActiveShowService;
import com.shigu.main4.spread.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    ActiveShowService activeShowService;

    public List<ActiveForShowVO> getAwardInfo(Long userId,boolean vipIs){
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



}
