package com.shigu.main4.order.model.able;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.OrderPayApplyRelationExample;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.examples.OrderPayRelationshipExample;
import com.opentae.data.mall.interfaces.*;
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
import java.util.Arrays;
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

    @Autowired
    private ItemOrderMapper itemOrderMapper;

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
        Long payId=orderPay.getPayId();
        List<OrderPayRelationship> relationships=orderPayApplyRelations.stream()
                .map(orderPayApplyRelation -> {
                    OrderPayRelationship relationship = new OrderPayRelationship();
                    relationship.setOid(orderPayApplyRelation.getOid());
                    relationship.setPayId(payId);
                    return relationship;
                }).collect(Collectors.toList());
        for(OrderPayRelationship r:relationships){
            orderPayRelationshipMapper.insertSelective(r);
        }
//        System.out.println(relationships.get(0).getRid());
//        orderPayRelationshipMapper.insertListNoId(relationships);
        return orderPay.getPayId();
    }

    /**
     * 支付申请准备工作
     * @param userId
     * @param money
     * @param oids
     * @return
     */
    protected OrderPayApply payApplyPrepare(Long userId,Long money,PayType type,Long[] oids) throws PayApplyException {
        List<Long> oidsList = Arrays.asList(oids);
        //先确定是否已经有支付完成订单
        OrderPayRelationshipExample payedExample = new OrderPayRelationshipExample();
        payedExample.createCriteria().andOidIn(oidsList);
        List<OrderPayRelationship> alreadPayed = orderPayRelationshipMapper.selectByExample(payedExample);
        if (alreadPayed.size()>0) {
            throw new PayApplyException("订单:"+StringUtils.join(alreadPayed.stream().map(OrderPayRelationship::getOid).collect(Collectors.toList()), ",")+"已支付");
        }
        ItemOrderExample itemOrderExample = new ItemOrderExample();
        itemOrderExample.createCriteria().andOidIn(oidsList).andOrderStatusEqualTo(5);
        if (itemOrderMapper.countByExample(itemOrderExample)>0) {
            throw new PayApplyException("有已经关闭订单");
        }
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refund(Long payId, Long money) throws PayerException {
        refund(payId,null,money);
    }

    @Override
    public void refund(Long payId, String refundNo, Long money) throws PayerException {
        OrderPay orderPay;
        if (payId == null || (orderPay = orderPayMapper.selectByPrimaryKey(payId)) == null) {
            throw new PayerException(String.format("支付记录不存在。 payId[%d]", payId));
        }
        if (money <= 0 || payedLeft(payId) < money) {
            throw new PayerException(String.format("可退金额不足.payId[%d], money[%d]", payId, money));
        }
        if (System.currentTimeMillis() - orderPay.getCreateTime().getTime() > 365 * 24 * 3600 * 1000L) {
            throw new PayerException("支付完成超过一年的订单无法退款");
        }
        if (refundNo == null) {
            refundNo="RF" + orderPay.getOuterPid() + orderPay.getRefundMoney();
        }
        realRefund(refundNo,orderPay,money);
        OrderPay pay = new OrderPay();
        pay.setPayId(orderPay.getPayId());
        pay.setRefundMoney(orderPay.getRefundMoney() + money);
        orderPayMapper.updateByPrimaryKeySelective(pay);
    }

    protected abstract void realRefund(String refundNo,OrderPay orderPay, Long money) throws PayerException;
}
