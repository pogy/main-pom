package com.shigu.main4.active.process;

import com.shigu.main4.active.vo.ShiguActivityApplyVO;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.activity.exceptions.ActivityException;

import java.util.List;

/**
 * 报名式活动服务
 * Created by zhaohongbo on 17/8/4.
 */
public interface ShiguActivityProcess {
    List<ShiguActivityApplyVO> luckyDogs(Long activityId);

    ShiguActivityVO info(Long activityId);

    void apply(Long activityId,ShiguActivityApplyVO vo) throws ActivityException;

    ShiguActivityApplyVO someOneApply(Long activityId,Long userId);
}
