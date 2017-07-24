package com.shigu.main4.order.model.able;

import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.beans.OrderPayRelationship;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.opentae.data.mall.interfaces.OrderPayMapper;
import com.opentae.data.mall.interfaces.OrderPayRelationshipMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.vo.PayApplyVO;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private OrderPayRelationshipMapper orderPayRelationshipMapper;

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
        if (StringUtils.isEmpty(outerPid)) {
            outerPid = apply.getOid().toString();
        }
        OrderPay orderPay = new OrderPay();
        orderPay.setApplyId(apply.getApplyId());

        OrderPay tmpOrderPay  = orderPayMapper.selectOne(orderPay);
        if (tmpOrderPay == null) {
            orderPay = BeanMapper.map(apply, OrderPay.class);
            orderPay.setCreateTime(null);
            orderPay.setOuterPid(outerPid);
            orderPay.setOuterPuser(outerPuser);
            orderPay.setMoney(payMoney);
            orderPayMapper.insertSelective(orderPay);

            // 记录 oid - payid 关系
            OrderPayRelationship relationship = new OrderPayRelationship();
            relationship.setOid(apply.getOid());
            relationship.setPayId(orderPay.getPayId());
            orderPayRelationshipMapper.insertSelective(relationship);
        }
    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(applyId), PayApplyVO.class);
    }
}
