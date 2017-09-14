package com.shigu.trade.services;

import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/18.
 */
@Service
public class AliPayService {
    private static final Logger logger = LoggerFactory.getLogger(AliPayService.class);

    @Resource(name="aliPayerService")
    private PayerService payerService;


    @Value("${alipayPulicKey}")
    private String alipayPulicKey;

    @Value("${signType}")
    private String signType;

    @Transactional(rollbackFor = Exception.class)
    public void payNotice(Map<String, String> paramsMapAli) throws PayerException {
        String outTradeNo = paramsMapAli.get("out_trade_no");
        String tradeNo=paramsMapAli.get("trade_no");
        String totalAmount = paramsMapAli.get("total_amount");
        String buyerId = paramsMapAli.get("buyer_id");
        Long totalFee = ((Double) (Double.valueOf(totalAmount.replaceAll("[$￥,]", "")) * 100.0)).longValue();

        payerService.paySure(Long.valueOf(outTradeNo), tradeNo, buyerId, totalFee);
    }

    public String getPublicKey() {
        return alipayPulicKey;
    }

    public String getSignType() {
        return signType;
    }
}
