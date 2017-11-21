package com.shigu.main4.spread.service;

import com.shigu.main4.spread.vo.ActiveDrawRecordVO;
import com.shigu.main4.spread.vo.ActiveForShowVO;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;

import java.util.List;

/**
 * 类名：ActiveShowService
 * 类路径：com.shigu.main4.spread.service.ActiveShowService
 * 创建者：王浩翔
 * 创建时间：2017-11-21 9:35
 * 项目：main-pom
 * 描述：
 */
public interface ActiveShowService {
    /**
     * 获取当前可领奖活动期次
     * @return
     */
    List<ActiveDrawPemVo> selShowAwardPems();
    /**
     * 获取当前可领取期次奖品信息（不包括具体用户中奖信息）
     * @return
     */
    List<ActiveForShowVO> selCurrentAwardInfoWithoutUser();
    /**
     * 返回对应期次用户所有中奖数据
     * @param userId
     * @param pemIds
     * @return
     */
    List<ActiveDrawRecordVO> selUserAwardInfo(Long userId, List<Long> pemIds);
}
