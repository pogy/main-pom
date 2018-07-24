package com.shigu.main4.order.whx;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.order.BaseTest;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：XzRefundBatch
 * 类路径：com.shigu.main4.order.whx.XzRefundBatch
 * 创建者：王浩翔
 * 创建时间：2017-09-08 15:27
 * 项目：main-pom
 * 描述：
 */
public class XzRefundBatch extends BaseTest {

    @Autowired
    PayerService xzPayerService;

    @Autowired
    ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    ItemOrderMapper itemOrderMapper;

    @Autowired
    ItemOrderLogisticsMapper itemOrderLogisticsMapper;

    @Autowired
    ItemOrderServiceMapper itemOrderServiceMapper;

    @Autowired
    OrderPayMapper orderPayMapper;

    @Autowired
    OrderPayApplyMapper orderPayApplyMapper;

    @Autowired
    ItemOrderSubMapper itemOrderSubMapper;

    /**
     * 手动退一些坑的退款
     */
    @Test
    public void refundSingle() throws RefundException, PayerException {
        RefundApplyBO applyBO = new RefundApplyBO();
        applyBO.setOid(Long.valueOf(165482));
        applyBO.setSoid(Long.valueOf(118250));
        applyBO.setHopeMoney(Long.valueOf(5300));
        applyBO.setType(1);
        applyBO.setNumber(1);
//        applyBO.setReason("退货");
        //applyBO.setReason("退货,收到的是55的衣服");
        applyBO.setReason("退款，含快递费");
        //applyBO.setReason("退款");
//        applyBO.setReason("退快递费");
        //applyBO.setReason("退款申请，人工处理，包含运费");
        SpringBeanFactory.getBean(RefundItemOrder.class,applyBO,true).success();
        //SpringBeanFactory.getBean(RefundItemOrder.class,36655L).success();
    }

    /**
     * 含快递费退款
     */
    @Test
    public void refundWithLogisticsAndService() throws RefundException, PayerException {
        long soid = 121859L;
//        boolean refundServiceMoney = true;
        boolean refundServiceMoney = false;
        boolean fromUser = true;
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(soid);
        ItemOrderLogistics itemOrderLogistics = new ItemOrderLogistics();
        itemOrderLogistics.setOid(itemOrderSub.getOid());
        itemOrderLogistics = itemOrderLogisticsMapper.selectOne(itemOrderLogistics);
        RefundApplyBO applyBO = new RefundApplyBO();
        applyBO.setType(1);
        applyBO.setReason("退款，含快递费");
        long serviceMoney = 0;
        if (refundServiceMoney) {
            ItemOrderService itemOrderService = new ItemOrderService();
            itemOrderService.setSoid(soid);
            itemOrderService = itemOrderServiceMapper.selectOne(itemOrderService);
            if (itemOrderService != null) {
                serviceMoney = itemOrderService.getMoney();
                applyBO.setReason("退款，含快递费，服务费");
            }
        }

        applyBO.setNumber(itemOrderSub.getNum());
        applyBO.setSoid(itemOrderSub.getSoid());
        applyBO.setOid(itemOrderSub.getOid());
        applyBO.setHopeMoney(itemOrderSub.getNum()*itemOrderSub.getPrice()+itemOrderLogistics.getMoney()+serviceMoney);
        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, applyBO, fromUser);
        refundItemOrder.success();
    }

    /**
     * 更具子单号退，只退货款
     * @throws RefundException
     * @throws PayerException
     */
    @Test
    public void batchOneOrder() throws RefundException, PayerException {
        ItemOrderSubExample example = new ItemOrderSubExample();
        //example.createCriteria().andOidEqualTo(Long.valueOf(160516));
        //example.createCriteria().andOidEqualTo(160516L)
        //        .andSoidNotEqualTo(Long.valueOf(114857))
        //        .andSoidNotEqualTo(Long.valueOf(57838))
        //        .andSoidNotEqualTo(Long.valueOf(57876))
        //        .andSoidNotEqualTo(Long.valueOf(57903))
        //        .andSoidNotEqualTo(Long.valueOf(57907))
        //        .andSoidNotEqualTo(Long.valueOf(57948))
        //        .andSoidNotEqualTo(Long.valueOf(57953))
        //        ;
        example.createCriteria().andSoidIn(Lists.newArrayList(
                73076L,73089L,105721L
        ));
        //example.createCriteria().andSoidEqualTo(Long.valueOf(96150));
        List<ItemOrderSub> itemOrderSubs = itemOrderSubMapper.selectByExample(example);
        for (ItemOrderSub itemOrderSub : itemOrderSubs) {
            RefundApplyBO applyBO = new RefundApplyBO();
            applyBO.setOid(itemOrderSub.getOid());
            applyBO.setSoid(itemOrderSub.getSoid());
            applyBO.setHopeMoney(itemOrderSub.getPrice()*itemOrderSub.getNum());
            applyBO.setType(2);
            applyBO.setNumber(itemOrderSub.getNum());
            applyBO.setReason("退货");
            SpringBeanFactory.getBean(RefundItemOrder.class,applyBO,true).success();
        }
    }

    //44272L
    @Test
    public void refundWithRefundIds() throws RefundException, PayerException {
        ArrayList<Long> refundIds = Lists.newArrayList(44265L,44266L,44271L);
        for (Long refundId : refundIds) {
            refundExitRefund(refundId);
        }
    }
    /**
     * 已有退单号退单
     * @throws RefundException
     * @throws PayerException
     */

    public void refundExitRefund(Long refundId) throws RefundException, PayerException {
        try {
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundId);
            refundItemOrder.success();
            RefundVO refundinfo = refundItemOrder.refundinfo();
            ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
            itemOrderRefund.setOid(refundinfo.getOid());
            itemOrderRefund.setStatus(RefundStateEnum.ENT_REFUND.refundStatus);
            int soidps = itemOrderRefundMapper.select(itemOrderRefund).stream().mapToInt(ItemOrderRefund::getNumber).sum();

            com.shigu.main4.order.model.ItemOrder itemOrder = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, refundinfo.getOid());
            if (soidps == itemOrder.subOrdersInfo().stream().mapToInt(SubItemOrderVO::getNum).sum()) {
                itemOrder.finished();
            }
        } catch (PayerException | RefundException e) {
            e.printStackTrace();
        }
    }

    public void refund(Long refundId){
        try {
            SpringBeanFactory.getBean(RefundItemOrder.class,refundId).success();
        } catch (PayerException | RefundException e) {
            System.out.println("退单失败refundId"+refundId);
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void singleRefund(Long refundId) {
        try {
            ItemOrderRefund itemOrderRefund = itemOrderRefundMapper.selectByPrimaryKey(refundId);
            OrderPayApply orderPayApply = new OrderPayApply();
            orderPayApply.setOid(itemOrderRefund.getOid());
            orderPayApply = orderPayApplyMapper.selectOne(orderPayApply);
            OrderPay orderPay = new OrderPay();
            orderPay.setApplyId(orderPayApply.getApplyId());
            orderPay = orderPayMapper.selectOne(orderPay);
            xzPayerService.refund(orderPay.getPayId(), itemOrderRefund.getHopeMoney());
        } catch (Exception e){
            System.out.println("refundId" + refundId + " 退单失败");
            e.printStackTrace();
        }
    }
}
    ////singleRefund(36451L);
    //ArrayList<Long> refundIds = Lists.newArrayList(36582l,
    //        36451l,
    //        36456l,
    //        36455l,
    //        36485l,
    //        36486l,
    //        36487l,
    //        36488l,
    //        36489l,
    //        36490l,
    //        36491l,
    //        36492l,
    //        36493l,
    //        36494l,
    //        36495l,
    //        36496l,
    //        36497l,
    //        36498l,
    //        36499l,
    //        36500l,
    //        36502l,
    //        36529l,
    //        36530l,
    //        36532l);

//    ArrayList<Long> refundIds = Lists.newArrayList(
//            36473l,
//            36475l,
//            36476l,
//            36477l,
//            36471l,
//            36472l,
//            36474l,
//            36436l,
//            36436l,
//            36478l,
//            36479l,
//            36481l
//    );