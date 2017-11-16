package com.shigu.main4.order.process;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.OrderIdGenerator;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.OrderIdGeneratorMapper;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("payProcess")
public class PayProcessImpl implements PayProcess{

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public PayApplyVO payApply(Long orderId, PayType payType) throws PayApplyException {
        canPayApply(orderId);
        return SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, orderId).payApply(payType);
    }

    /**
     * 1、识别订单的支付状态
     * 2、提取下单用户，如果提取出多个，扔出异常
     * 3、统计总费用
     * 4、调用付款申请
     * @param orderIds
     * @param payType
     * @return
     */
    @Override
    public PayApplyVO payApplySome(List<Long> orderIds, PayType payType) throws PayApplyException {
        Long[] oids=new Long[orderIds.size()];
        for(int i=0;i<orderIds.size();i++){
            oids[i]=orderIds.get(i);
        }
        canPayApply(oids);
        ItemOrderExample example=new ItemOrderExample();
        example.createCriteria().andOidIn(Arrays.asList(oids)).andOrderStatusEqualTo(OrderStatus.WAIT_BUYER_PAY.status);
        List<ItemOrder> orders=itemOrderMapper.selectByExample(example);
        //查询用户ID
        Long userId=null;
        Long money=0l;
        String title=null;
        for(ItemOrder order:orders){
            if(userId!=null&&!userId.equals(order.getUserId())){
                throw new PayApplyException("只能支付自己下的订单");
            }else if(userId==null){
                userId=order.getUserId();
                title=order.getTitle();
            }
            money+=order.getTotalFee();
        }
        return SpringBeanFactory.getBean(payType.getService(), PayerService.class).payApply(userId, money, "[合并付款]"+title,oids);
    }

    private void canPayApply(Long... oids) throws PayApplyException {
        ItemOrderExample example=new ItemOrderExample();
        example.createCriteria().andOidIn(Arrays.asList(oids)).andOrderStatusNotEqualTo(OrderStatus.WAIT_BUYER_PAY.status);
        if (itemOrderMapper.countByExample(example)>0) {
            throw new PayApplyException("订单已经支付过,不能再次支付");
        }
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
