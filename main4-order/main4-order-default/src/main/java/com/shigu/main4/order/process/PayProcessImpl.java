package com.shigu.main4.order.process;

import com.opentae.data.mall.beans.OrderIdGenerator;
import com.opentae.data.mall.interfaces.OrderIdGeneratorMapper;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("payProcess")
public class PayProcessImpl implements PayProcess{

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;

    @Override
    public PayApplyVO payApply(Long orderId, PayType payType) throws PayApplyException {
        return SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId).payApply(payType);
    }

    @Override
    public PayApplyVO rechargeApply(Long userId, PayType payType,Long money) throws PayApplyException {
        OrderIdGenerator idGenerator = new OrderIdGenerator();
        idGenerator.setType(OrderType.INCHANGE.type);
        orderIdGeneratorMapper.insertSelective(idGenerator);
        RechargeOrder order=SpringBeanFactory.getBean(RechargeOrder.class,userId,idGenerator.getOid(),money);
        return order.payApply(payType);
    }


}
