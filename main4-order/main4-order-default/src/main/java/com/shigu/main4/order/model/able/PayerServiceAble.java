package com.shigu.main4.order.model.able;

import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.opentae.data.mall.interfaces.OrderPayMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.PayerException;
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

    @Autowired
    protected OrderPayMapper orderPayMapper;

    @Override
    public Long payedLeft(Long payId) {
        OrderPay orderPay = orderPayMapper.selectByPrimaryKey(payId);
        if (orderPay == null) {
            return 0L;
        }
        return orderPay.getMoney() - orderPay.getRefundMoney();
    }

    @Override
    public void paySure(Long applyId, String outerPid, String outerPuser, Long payMoney) throws PayerException {
        OrderPayApply apply;
        if (applyId == null || (apply = orderPayApplyMapper.selectByPrimaryKey(applyId)) == null)
            throw new PayerException(String.format("支付请求不存在：[%d]", applyId));
        OrderPay orderPay = BeanMapper.map(apply, OrderPay.class);
        orderPay.setCreateTime(null);
        orderPay.setOuterPid(outerPid);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPayMapper.insertSelective(orderPay);
    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(applyId), PayApplyVO.class);
    }
}
