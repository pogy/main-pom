package com.shigu.main4.order.model.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付宝支付
 * Created by zhaohongbo on 17/6/9.
 */
@Service("aliPayerService")
public class AliPayerServiceImpl extends PayerServiceAble {
    @Autowired
    private AlipayClient alipayClient;

    @Value("${returnUrl}")
    private String  returnUrl;

    @Value("${notifyUrl}")
    private String notifyUrl;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long oid, Long money, String title) throws PayApplyException {

        OrderPayApply apply = new OrderPayApply();
        apply.setOid(oid);
        apply.setMoney(money);
        apply.setType(PayType.ALI.getValue());
        orderPayApplyMapper.insertSelective(apply);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回调和通知地址

        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + apply.getApplyId() + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + String.format("%,.2f", money * .01) + "," +
                "    \"subject\":\"" + title + "\"" +
                "  }");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            throw new PayApplyException(e.getMessage());
        }

        OrderPayApply payApply = new OrderPayApply();
        payApply.setApplyId(apply.getApplyId());
        payApply.setPayLink(form);
        orderPayApplyMapper.updateByPrimaryKeySelective(payApply);

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

        //TODO: call alipay refund
        alipayRefund(orderPay, money);

        OrderPay pay = new OrderPay();
        pay.setPayId(orderPay.getPayId());
        pay.setRefundMoney(orderPay.getRefundMoney() + money);
        orderPayMapper.updateByPrimaryKeySelective(pay);
    }


    private void alipayRefund(OrderPay orderPay, Long money) throws PayerException {
        OrderPayApply orderPayApply = orderPayApplyMapper.selectByPrimaryKey(orderPay.getApplyId());
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, orderPayApply.getOid());
        if (itemOrder == null || itemOrder.selSender() == null) {
            throw new PayerException("支付宝退款失败， 无法获取对应代发资金分组：payId=" + orderPay.getPayId());
        }
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderPayApply.getApplyId() + "\"," +
                "    \"refund_amount\":" + String.format("$,.2f", money * .01)  + "," +
                "    \"refund_reason\":\"正常退款\"," +
                "    \"out_request_no\":\"" + UUIDGenerator.getUUID() + "\"" +
                "  }");
        try {
            AlipayResponse response = alipayClient.execute(request);
            if(!response.isSuccess()){
                throw new PayerException("支付宝退款失败: "+ response.getCode() + ", " + response.getMsg());
            }
        } catch (AlipayApiException e) {
            throw new PayerException(e.getMessage());
        }
    }

}
