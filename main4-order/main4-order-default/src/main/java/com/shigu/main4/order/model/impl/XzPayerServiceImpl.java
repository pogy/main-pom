package com.shigu.main4.order.model.impl;

import com.openJar.requests.sgpay.RefundRequest;
import com.openJar.responses.sgpay.RefundResponse;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.opentae.data.mall.beans.OrderPayRelationship;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.examples.OrderPayRelationshipExample;
import com.opentae.data.mall.interfaces.OrderPayRelationshipMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
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

/**
 * 星座支付
 * Created by zhulm on 17/6/21.
 */
@Service("xzPayerService")
public class XzPayerServiceImpl extends PayerServiceAble {
    private static final Logger logger = LoggerFactory.getLogger(XzPayerServiceImpl.class);

    @Autowired
    private XzSdkClient xzSdkClient;
    @Autowired
    OrderPayRelationshipMapper orderPayRelationshipMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId, Long money, String title,Long[] oids) throws PayApplyException {
        OrderPayApply apply = payApplyPrepare(userId,money,PayType.XZ,oids);

        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }


    @Override
    protected void realRefund(String refundNo,OrderPay orderPay, Long money) throws PayerException {
        XzRefund(refundNo,orderPay, money.intValue());
    }

    @Override
    public void payRollback(Long applyId, String outerPid, String outerPuser, Long payMoney, Long money) throws PayerException {
        OrderPay orderPay=new OrderPay();
        orderPay.setOuterPid(outerPid);
        orderPay.setApplyId(applyId);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPay.setRefundMoney(0L);
        XzRefund("ROLL_"+applyId,orderPay,money.intValue());
    }

    private void XzRefund(String refundNo,OrderPay orderPay, int refundFee) throws PayerException {
        OrderPayExample orderPayExample=new OrderPayExample();
        orderPayExample.createCriteria().andApplyIdEqualTo(orderPay.getApplyId());
        List<OrderPay> orderPays=orderPayMapper.selectByExample(orderPayExample);
        OrderPayRelationshipExample orderPayRelationshipExample=new OrderPayRelationshipExample();
        orderPayRelationshipExample.createCriteria().andPayIdEqualTo(orderPays.get(0).getPayId());
        List<OrderPayRelationship> oprs= orderPayRelationshipMapper.selectByExample(orderPayRelationshipExample);
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, oprs.get(0).getOid());
        if (itemOrder == null || itemOrder.selSender() == null) {
            throw new PayerException("星座支付退款失败， 无法获取对应代发资金分组：payId=" + orderPay.getPayId());
        }
        RefundRequest  req = new RefundRequest();
        req.setRefundType(5);
        req.setMoney(Long.valueOf(refundFee));
        req.setOutTradeId(orderPay.getOuterPid());

        List<String> subTradeIdList = new ArrayList<String>();
        subTradeIdList.add(refundNo);
        req.setSubOutTradeId(subTradeIdList);
        req.setDfGroupId(itemOrder.selSender().getSenderId());

        RefundResponse res = xzSdkClient.getPcOpenClient().execute(req);
        if (res==null || !res.isSuccess()) {
            throw new PayerException("星座支付退款失败：payid=" + orderPay.getPayId());
        }
    }
}
