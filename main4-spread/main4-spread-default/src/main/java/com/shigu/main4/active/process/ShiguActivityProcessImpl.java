package com.shigu.main4.active.process;

import com.shigu.main4.active.model.ShiguActivityModel;
import com.shigu.main4.active.vo.ShiguActivityApplyVO;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报名式活动服务
 * Created by zhaohongbo on 17/8/4.
 */
@Service("shiguActivityProcess")
public class ShiguActivityProcessImpl implements ShiguActivityProcess{
    @Override
    public List<ShiguActivityApplyVO> luckyDogs(Long activityId) {
        return activity(activityId).luckyDogs();
    }

    @Override
    public ShiguActivityVO info(Long activityId) {
        return activity(activityId).info();
    }

    @Override
    public void apply(Long activityId, ShiguActivityApplyVO vo) throws ActivityException {
        activity(activityId).apply(vo);
    }

    @Override
    public ShiguActivityApplyVO someOneApply(Long activityId,Long userId) {
        return activity(activityId).someOneApply(userId);
    }

    private ShiguActivityModel activity(Long actid) {
        return SpringBeanFactory.getBean(ShiguActivityModel.class, actid);
    }
}
