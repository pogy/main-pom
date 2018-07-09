package com.shigu.main4.order.model.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.opentae.data.mall.beans.OrderPay;
import com.opentae.data.mall.beans.OrderPayApply;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 支付宝App支付
 * Created by gtx on 18/4/24.
 */
@Service("aliAppPayerQzService")
public class AliAppPayerQzServiceImpl extends PayerServiceAble {
    @Resource(name="alipayQzClient")
    private AlipayClient alipayClient;

    @Value("${qzreturnUrl}")
    private String  returnUrl;

    @Value("${qznotifyUrl}")
    private String notifyUrl;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId, Long money, String title, Long[] oids) throws PayApplyException {

        if (oids == null || oids.length==0) {
            throw new PayApplyException("缺少订单ID");
        }
        OrderPayApply apply = payApplyPrepare(userId,money, PayType.ALI_APP,oids);

        AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
        alipayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回调和通知地址
        if (title != null) {
            String regex = "[^\\u4e00-\\u9fa5A-Za-z\\d\\.]+";
            title = title.replaceAll(regex,"");
        }
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setSubject(title);
        model.setOutTradeNo(apply.getApplyId().toString());
        model.setTotalAmount(String.format("%.2f", money * .01));
        model.setProductCode("FAST_INSTANT_TRADE_PAY");

        alipayRequest.setBizModel(model);//填充业务参数
        AlipayTradeAppPayResponse response = null;
        try {
            response = alipayClient.sdkExecute(alipayRequest);
        } catch (AlipayApiException e) {
            throw new PayApplyException(e.getMessage());
        }

        OrderPayApply payApply = new OrderPayApply();
        payApply.setApplyId(apply.getApplyId());
        payApply.setPayLink(response.getBody());
        orderPayApplyMapper.updateByPrimaryKeySelective(payApply);

        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    @Override
    protected void realRefund(String refundNo, OrderPay orderPay, Long money) throws PayerException {
        alipayRefund(refundNo,orderPay, money);
    }

    @Override
    public void payRollback(Long applyId, String outerPid, String outerPuser, Long payMoney, Long money) throws PayerException {
        OrderPay orderPay=new OrderPay();
        orderPay.setOuterPid(outerPid);
        orderPay.setApplyId(applyId);
        orderPay.setOuterPuser(outerPuser);
        orderPay.setMoney(payMoney);
        orderPay.setRefundMoney(0L);
        alipayRefund("ROLL_"+applyId,orderPay,money);
    }


    private void alipayRefund(String refundNo, OrderPay orderPay, Long money) throws PayerException {
        OrderPayApply orderPayApply = orderPayApplyMapper.selectByPrimaryKey(orderPay.getApplyId());
//        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, orderPayApply.getOid());
//        if (itemOrder == null || itemOrder.selSender() == null) {
//            throw new PayerException("支付宝退款失败， 无法获取对应代发资金分组：payId=" + orderPay.getPayId());
//        }
        //查出第几次退
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo(orderPayApply.getApplyId().toString());
        model.setRefundAmount(String.format("%.2f", money * .01));
        model.setRefundReason("正常退款");
        model.setOutRequestNo(refundNo);

        request.setBizModel(model);
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
