package com.shigu.main4.order.model.able;

import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 支付部分实现
 * Created by zhaohongbo on 17/6/9.
 */
public abstract class PayerServiceAble implements PayerService{

    @Autowired
    protected OrderPayApplyMapper orderPayApplyMapper;

    @Override
    public Long payedLeft(Long payId) {
        return null;
    }

    @Override
    public void paySure(Long applyId, String outerPid, String outerPuser, Long payMoney) {

    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(applyId), PayApplyVO.class);
    }
}
