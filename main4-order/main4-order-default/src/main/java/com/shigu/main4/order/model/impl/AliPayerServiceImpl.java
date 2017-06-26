package com.shigu.main4.order.model.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.opentae.data.mall.beans.OrderPayApply;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.model.able.PayerServiceAble;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.AmountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Service;

/**
 * 支付宝支付
 * Created by zhaohongbo on 17/6/9.
 */
@Service("aliPayerService")
public class AliPayerServiceImpl extends PayerServiceAble {
    @Autowired
    private AlipayClient alipayClient;
    @Override
    public PayApplyVO payApply(Long oid, Long money, String title)  {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://www.571xz.com/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址

        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + oid + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":" + AmountUtils.changeF2Y(money) + "," +
                "    \"subject\":\"" + title + "\"," +
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        OrderPayApply apply = new OrderPayApply();
        apply.setOid(oid);
        apply.setMoney(money);
        apply.setType(PayType.ALI.getValue());
        apply.setPayLink(form);
        orderPayApplyMapper.insertSelective(apply);

        return BeanMapper.map(orderPayApplyMapper.selectByPrimaryKey(apply.getApplyId()), PayApplyVO.class);
    }

    @Override
    public void refund(Long payId, Long money) {

    }


}
