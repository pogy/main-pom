package com.shigu.main4.order.model.able;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.OrderIdGenerator;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.beans.OrderPayRelationship;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.examples.OrderPayRelationshipExample;
import com.opentae.data.mall.interfaces.OrderIdGeneratorMapper;
import com.opentae.data.mall.interfaces.OrderPayApplyMapper;
import com.opentae.data.mall.interfaces.OrderPayMapper;
import com.opentae.data.mall.interfaces.OrderPayRelationshipMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RechargeOrder;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;

    @Autowired
    private OrderMessageProducter orderMessageProducter;

    @Autowired
    private MultipleMapper multipleMapper;

    @Override
    public Long payedLeft(Long payId) {
        OrderPay orderPay = orderPayMapper.selectByPrimaryKey(payId);
        if (orderPay == null) {
            return 0L;
        }
        return orderPay.getMoney() - orderPay.getRefundMoney();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void paySure(Long applyId, String outerPid, String outerPuser, Long payMoney) throws PayerException {
        OrderPayApply apply;
        if (applyId == null || (apply = orderPayApplyMapper.selectByPrimaryKey(applyId)) == null)
            throw new PayerException(String.format("支付请求不存在：[%d]", applyId));
        if (StringUtils.isEmpty(outerPid)) {
            outerPid = apply.getOid().toString();
        }
        //验证重复支付
        OrderPayExample orderPayExample=new OrderPayExample();
        OrderPayRelationshipExample relationshipExample=new OrderPayRelationshipExample();
        MultipleExample multipleExample= MultipleExampleBuilder.from(orderPayExample).innerJoin(relationshipExample)
                .on(orderPayExample.createCriteria().equalTo(OrderPayExample.payId,OrderPayRelationshipExample.payId))
                .where(relationshipExample.createCriteria().andOidEqualTo(apply.getOid())
                        ,orderPayExample.createCriteria().andApplyIdNotEqualTo(applyId)).build();
        if(multipleMapper.countByMultipleExample(multipleExample)>0){//之前有付过，现在又来付
            refund(createPay(apply,outerPid,outerPuser,payMoney),payMoney);//把新支付创建出来，再退款退掉
            return;
        }

        OrderPay orderPay = new OrderPay();
        orderPay.setApplyId(apply.getApplyId());

        OrderPay tmpOrderPay  = orderPayMapper.selectOne(orderPay);
        //验证重复通知
        if (tmpOrderPay == null) {
            createPay(apply,outerPid,outerPuser,payMoney);
            OrderIdGenerator orderId=orderIdGeneratorMapper.selectByPrimaryKey(apply.getOid());
            if (orderId != null&&orderId.getType()>0) {//商品订单
                ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, apply.getOid());
                itemOrder.payed();
                orderMessageProducter.orderPush(itemOrder);
            }else if(orderId != null&&orderId.getType()== OrderType.INCHANGE.type){//假如是走充值的
                RechargeOrder rechargeOrder=SpringBeanFactory.getBean(RechargeOrder.class,apply.getUserId(),apply.getOid(),apply.getMoney());
                try {
                    rechargeOrder.payed(outerPid);
                    createPay(apply,outerPid,outerPuser,payMoney);
                } catch (PayApplyException e) {
                    refund(createPay(apply,outerPid,outerPuser,payMoney),payMoney);//充值失败，退回
                }

            }
        }
    }

    /**
     * 创建付款成功记录
     * @param apply
     * @param outerPid
     * @param outerPuser
     * @param payMoney
     */
    private Long createPay(OrderPayApply apply,String outerPid,String outerPuser,Long payMoney){
        OrderPay orderPay = new OrderPay();
        orderPay.setApplyId(apply.getApplyId());
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
        return orderPay.getPayId();
    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(applyId), PayApplyVO.class);
    }
}
