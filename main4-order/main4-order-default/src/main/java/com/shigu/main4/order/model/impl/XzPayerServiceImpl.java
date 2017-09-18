package com.shigu.main4.order.model.impl;

import com.openJar.requests.sgpay.RefundRequest;
import com.openJar.responses.sgpay.RefundResponse;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayerException;

import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.tools.XzSdkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 星座支付
 * Created by zhulm on 17/6/21.
 */
@Service("xzPayerService")
public class XzPayerServiceImpl extends PayerServiceAble {
    private static final Logger logger = LoggerFactory.getLogger(XzPayerServiceImpl.class);

    @Autowired
    private XzSdkClient xzSdkClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId,Long oid, Long money, String title) {
        OrderPayApply apply = new OrderPayApply();
        apply.setOid(oid);
        apply.setMoney(money);
        apply.setUserId(userId);
        apply.setType(PayType.XZ.getValue());
        orderPayApplyMapper.insertSelective(apply);

        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refund(Long payId, Long money) throws PayerException  {
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

        //TODO: call xz refund
        XzRefund(orderPay, money.intValue());

        OrderPay pay = new OrderPay();
        pay.setPayId(orderPay.getPayId());
        pay.setRefundMoney(orderPay.getRefundMoney() + money);
        orderPayMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public void payRollback(Long applyId, String outerPid, String outerPuser, Long payMoney, Long money) throws PayerException {
        OrderPay orderPay=new OrderPay();
        orderPay.setOuterPid(outerPid);
        orderPay.setApplyId(applyId);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPay.setRefundMoney(0L);
        XzRefund(orderPay,money.intValue());
    }

    private void XzRefund(OrderPay orderPay, int refundFee) throws PayerException {
        OrderPayApply orderPayApply = orderPayApplyMapper.selectByPrimaryKey(orderPay.getApplyId());
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, orderPayApply.getOid());
        if (itemOrder == null || itemOrder.selSender() == null) {
            throw new PayerException("星座支付退款失败， 无法获取对应代发资金分组：payId=" + orderPay.getPayId());
        }
        RefundRequest  req = new RefundRequest();
        req.setRefundType(5);
        req.setMoney(Long.valueOf(refundFee));
        req.setOutTradeId(orderPay.getOuterPid());

        List<String> subTradeIdList = new ArrayList<String>();
        subTradeIdList.add(UUIDGenerator.getUUID());
        req.setSubOutTradeId(subTradeIdList);
        req.setDfGroupId(itemOrder.selSender().getSenderId());

        RefundResponse res = xzSdkClient.getPcOpenClient().execute(req);
        if (res==null || !res.isSuccess()) {
            throw new PayerException("星座支付退款失败：payid=" + orderPay.getPayId());
        }
    }
}
