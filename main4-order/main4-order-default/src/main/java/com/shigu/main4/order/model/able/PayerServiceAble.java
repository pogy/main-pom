package com.shigu.main4.order.model.able;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.OrderPayApplyRelationExample;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.examples.OrderPayRelationshipExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 支付部分实现
 * Created by zhaohongbo on 17/6/9.
 */
public abstract class PayerServiceAble implements PayerService{

    private static final Logger logger = LoggerFactory.getLogger(PayerServiceAble.class);
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

    @Autowired
    protected OrderPayApplyRelationMapper orderPayApplyRelationMapper;

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
        try {
            OrderPayApply apply;
            if (applyId == null || (apply = orderPayApplyMapper.selectByPrimaryKey(applyId)) == null)
                throw new PayerException(String.format("支付请求不存在：[%d]", applyId));
            if (StringUtils.isEmpty(outerPid)) {
                outerPid = apply.getApplyId().toString();
            }
            OrderPayApplyRelationExample relationExample=new OrderPayApplyRelationExample();
            relationExample.createCriteria().andApplyIdEqualTo(applyId);
            List<Long> oids=BeanMapper.getFieldList(orderPayApplyRelationMapper.selectByExample(relationExample),"oid",Long.class);
            if(oids.size()==0&&apply.getOid()!=null){
                oids.add(apply.getOid());
            }
            //验证重复支付
            OrderPayExample orderPayExample=new OrderPayExample();
            OrderPayRelationshipExample relationshipExample=new OrderPayRelationshipExample();
            MultipleExample multipleExample= MultipleExampleBuilder.from(orderPayExample).innerJoin(relationshipExample)
                    .on(orderPayExample.createCriteria().equalTo(OrderPayExample.payId,OrderPayRelationshipExample.payId))
                    .where(relationshipExample.createCriteria().andOidIn(oids)
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
                for(Long oid:oids){
                    OrderIdGenerator orderId=orderIdGeneratorMapper.selectByPrimaryKey(oid);
                    if (orderId != null&&orderId.getType()>0) {//商品订单
                        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, oid);
                        itemOrder.payed();
                        orderMessageProducter.orderPush(itemOrder);
                    }else if(orderId != null&&orderId.getType()== OrderType.INCHANGE.type){//假如是走充值的
                        RechargeOrder rechargeOrder=SpringBeanFactory.getBean(RechargeOrder.class,apply.getUserId(),apply.getOid(),apply.getMoney());
                        try {
                            rechargeOrder.payed(outerPid);
                        } catch (PayApplyException e) {
                            logger.error("oid="+orderId.getOid()+",type="+orderId.getType()+",applyId="+applyId
                                    +",payMoney="+payMoney+",充值失败，需要退回",e);
//
                        }

                    }
                }
            }
        } catch (Exception e) {
            logger.error("支付确认失败",e);
            throw e;
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

        OrderPayApplyRelationExample orderPayApplyRelationExample=new OrderPayApplyRelationExample();
        orderPayApplyRelationExample.createCriteria().andApplyIdEqualTo(apply.getApplyId());
        List<OrderPayApplyRelation> orderPayApplyRelations=orderPayApplyRelationMapper.selectByExample(orderPayApplyRelationExample);

        List<OrderPayRelationship> relationships=orderPayApplyRelations.stream()
                .map(orderPayApplyRelation -> {
                    OrderPayRelationship relationship = new OrderPayRelationship();
                    relationship.setOid(orderPayApplyRelation.getOid());
                    relationship.setPayId(orderPayApplyRelation.getApplyId());
                    return relationship;
                }).collect(Collectors.toList());

        orderPayRelationshipMapper.insertListNoId(relationships);
        return orderPay.getPayId();
    }

    /**
     * 支付申请准备工作
     * @param userId
     * @param money
     * @param oids
     * @return
     */
    protected OrderPayApply payApplyPrepare(Long userId,Long money,PayType type,Long[] oids){
        OrderPayApply apply = new OrderPayApply();
//        apply.setOid(oid);
        apply.setMoney(money);
        apply.setUserId(userId);
        apply.setType(type.getValue());
        orderPayApplyMapper.insertSelective(apply);
        //插入申请关联表
        List<OrderPayApplyRelation> relations=new ArrayList<>();
        for(Long oid:oids){
            OrderPayApplyRelation relation=new OrderPayApplyRelation();
            relation.setApplyId(apply.getApplyId());
            relation.setOid(oid);
            relations.add(relation);
        }
        orderPayApplyRelationMapper.insertListNoId(relations);
        return apply;
    }

    @Override
    public PayApplyVO selApply(Long applyId) {
        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(applyId), PayApplyVO.class);
    }
}
