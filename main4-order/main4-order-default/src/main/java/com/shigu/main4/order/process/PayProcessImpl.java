package com.shigu.main4.order.process;

import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Service;

@Service("payProcess")
public class PayProcessImpl implements PayProcess{
    @Override
    public PayApplyVO payApply(Long orderId, PayType payType) throws PayApplyException {
        return SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId).payApply(payType);
    }
}
