package com.shigu.main4.active.model;

import com.shigu.main4.active.vo.ShiguActivityApplyVO;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.activity.exceptions.ActivityException;

import java.util.List;

/**
 * 活动操纵服务
 * 本服务采用多例，使用 spring 管理，\n由 SpringBeanFactory 创建新实例，\n单构造单参数 activityId
 * Created by bugzy on 2017/6/30 0030.
 */
public interface ShiguActivityModel {

    /**
     * 当前活动详情
     * @return
     */
    ShiguActivityVO info();

    /**
     * 活动报名，验证活动申请状态，如果 ApplyStatus != APPLYING 扔出异常
     * @param vo 申请信息
     */
    void apply(ShiguActivityApplyVO vo) throws ActivityException;

    /**
     * 报名成功该活动的列表
     * @return
     */
    List<ShiguActivityApplyVO> listApplies();

    /**
     * 本活动申请通过的列表
     * @return
     */
    List<ShiguActivityApplyVO> luckyDogs();

    ShiguActivityApplyVO someOneApply(Long userId);

    boolean yourLuckOne(Long userId);

    /**
     * 选中一个申请
     * @param applyId
     */
    void chooseOne(Long applyId); 

    /**
     * 取消选中一个申请
     * @param applyId
     */
    void forgetMe(Long applyId);
}
