package com.shigu.main4.order.model.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
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
 * 支付宝支付
 * Created by zhaohongbo on 17/6/9.
 */
@Service("aliPayerQzService")
public class AliPayerQzServiceImpl extends PayerServiceAble {
    @Resource(name="alipayQzClient")
    private AlipayClient alipayClient;

    @Value("${qzReturnUrl}")
    private String  returnUrl;

    @Value("${qzNotifyUrl}")
    private String notifyUrl;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long userId, Long money, String title, Long[] oids) throws PayApplyException {

        if (oids == null || oids.length==0) {
            throw new PayApplyException("缺少订单ID");
        }
        OrderPayApply apply = payApplyPrepare(userId,money,PayType.QZ_ALI,oids);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回调和通知地址
        if (title != null) {
            String regex = "[^\\u4e00-\\u9fa5A-Za-z\\d\\.]+";
            title = title.replaceAll(regex,"");
        }
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + apply.getApplyId() + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + String.format("%.2f", money * .01) + "," +
                "    \"subject\":\"" + title + "\"" +
                "  }");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            throw new PayApplyException(e.getMessage());
        }
        System.out.println(form);
        OrderPayApply payApply = new OrderPayApply();
        payApply.setApplyId(apply.getApplyId());
        payApply.setPayLink(form);
        orderPayApplyMapper.updateByPrimaryKeySelective(payApply);

        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    @Override
    protected void realRefund(String refundNo,OrderPay orderPay, Long money) throws PayerException {
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


    private void alipayRefund(String refundNo,OrderPay orderPay, Long money) throws PayerException {
        OrderPayApply orderPayApply = orderPayApplyMapper.selectByPrimaryKey(orderPay.getApplyId());
//        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, orderPayApply.getOid());
//        if (itemOrder == null || itemOrder.selSender() == null) {
//            throw new PayerException("支付宝退款失败， 无法获取对应代发资金分组：payId=" + orderPay.getPayId());
//        }
        //查出第几次退
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderPayApply.getApplyId() +"\"," +
                "    \"refund_amount\":" + String.format("%.2f", money * .01)  + "," +
                "    \"refund_reason\":\"正常退款\"," +
                "    \"out_request_no\":\"" + refundNo + "\"" +
                "  }");
        try {
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            if(!response.isSuccess()){
                throw new PayerException("支付宝退款失败: "+ response.getCode() + ", " + response.getMsg());
            }
            if("N".equals(response.getFundChange())){
                throw new PayerException("退款重复,回滚");
            }
        } catch (AlipayApiException e) {
            throw new PayerException(e.getMessage());
        }
    }

}
