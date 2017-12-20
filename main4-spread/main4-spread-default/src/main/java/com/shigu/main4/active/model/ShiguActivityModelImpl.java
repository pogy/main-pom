package com.shigu.main4.active.model;

import com.opentae.data.mall.beans.ShiguActivityApply;
import com.opentae.data.mall.interfaces.ShiguActivityApplyMapper;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.shigu.main4.active.model.ShiguActivityModel;
import com.shigu.main4.active.vo.ShiguActivityApplyVO;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.common.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 活动服务
 * Created by bugzy on 2017/6/30 0030.
 */
@Service("shiguActivityService")
@Scope("prototype")
public class ShiguActivityModelImpl implements ShiguActivityModel {

    @Autowired
    private ShiguActivityMapper shiguActivityMapper;

    @Autowired
    private ShiguActivityApplyMapper shiguActivityApplyMapper;


    private Long activityId;

    public ShiguActivityModelImpl(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 当前活动详情
     *
     * @return
     */
    @Override
    public ShiguActivityVO info() {
        return BeanMapper.map(shiguActivityMapper.selectByPrimaryKey(activityId), ShiguActivityVO.class);
    }

    /**
     * 活动报名，验证活动申请状态，如果 ApplyStatus != APPLYING 扔出异常
     *
     * @param vo 申请信息
     */
    @Override
    public void apply(ShiguActivityApplyVO vo) throws ActivityException {
        String errMsg = null;
        if (vo.getItemIds() == null || vo.getItemIds().isEmpty()) {
            errMsg = "请补全商品信息";
        }
        if (StringUtils.isEmpty(vo.getPhone())) {
            errMsg = "请填写手机号, " + (errMsg == null ? "" : errMsg);
        }
        if (vo.getShopId() == null) {
            errMsg = "店铺信息缺失， " + (errMsg == null ? "" : errMsg);
        }
        if (errMsg != null) {
            throw new ActivityException(errMsg);
        }
        ShiguActivityApply apply = BeanMapper.map(vo, ShiguActivityApply.class);
        apply.setItems(StringUtils.join(vo.getItemIds(), ","));
        apply.setApplyId(null);
        apply.setActivityId(activityId);
        apply.setChoose(1);
        shiguActivityApplyMapper.insertSelective(apply);
    }

    /**
     * 报名成功该活动的列表
     *
     * @return
     */
    @Override
    public List<ShiguActivityApplyVO> listApplies() {
        return listApply(null);
    }

    private List<ShiguActivityApplyVO> listApply(Integer choose) {
        ShiguActivityApply apply = new ShiguActivityApply();
        apply.setActivityId(activityId);
        apply.setChoose(choose);
        List<ShiguActivityApply> select = shiguActivityApplyMapper.select(apply);
        Map<Long, ShiguActivityApply> activityApplyMap = BeanMapper.list2Map(select, "applyId", Long.class);
        List<ShiguActivityApplyVO> shiguActivityApplyVOS = BeanMapper.mapList(select, ShiguActivityApplyVO.class);
        for (ShiguActivityApplyVO shiguActivityApplyVO : shiguActivityApplyVOS) {
            ShiguActivityApply activityApply = activityApplyMap.get(shiguActivityApplyVO.getApplyId());
            String[] items = activityApply.getItems().split(",");
            shiguActivityApplyVO.setItemIds(new ArrayList<Long>(items.length));
            for (String item : items) {
                shiguActivityApplyVO.getItemIds().add(Long.valueOf(item));
            }
        }
        return shiguActivityApplyVOS;
    }

    /**
     * 本活动申请通过的列表
     *
     * @return
     */
    @Override
    public List<ShiguActivityApplyVO> luckyDogs() {
        return listApply(3);
    }

    @Override
    public ShiguActivityApplyVO someOneApply(Long userId) {
        for (ShiguActivityApplyVO vo : listApplies()) {
            if (vo.getUserId().equals(userId))
                return vo;
        }
        return null;
    }

    @Override
    public boolean yourLuckOne(Long userId) {
        ShiguActivityApplyVO vo = someOneApply(userId);
        return vo != null && vo.getChoose() == 3;
    }

    /**
     * 选中一个申请
     *
     * @param applyId
     */
    @Override
    public void chooseOne(Long applyId) {
        if (applyId == null) {
            return;
        }
        changeMyMind(applyId, 3);
    }

    private void changeMyMind(Long applyId, Integer choose) {
        ShiguActivityApply apply = new ShiguActivityApply();
        apply.setActivityId(activityId);
        apply.setApplyId(applyId);
        apply.setChoose(choose);
        shiguActivityApplyMapper.updateByPrimaryKeySelective(apply);
    }

    /**
     * 取消选中一个申请
     *
     * @param applyId
     */
    @Override
    public void forgetMe(Long applyId) {
        if (applyId == null) {
            return;
        }
        changeMyMind(applyId, 2);
    }

    public Long getActivityId() {
        return activityId;
    }
}
