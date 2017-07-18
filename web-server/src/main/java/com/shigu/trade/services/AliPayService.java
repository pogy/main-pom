package com.shigu.trade.services;

import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.tools.AmountUtils;
import com.shigu.trade.bo.ScanPayBo;
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

    @Transactional(rollbackFor = Exception.class)
    public void payNotice(Map<String, String> paramsMapAli) throws PayerException {
        String outTradeNo = paramsMapAli.get("out_trade_no");
        String totalAmount = paramsMapAli.get("total_amount");
        String sellerId = paramsMapAli.get("seller_id");

        String totalFee = AmountUtils.changeY2F(totalAmount);

        Long applyId;
        try {
            applyId = Long.valueOf(outTradeNo.substring(2));
        } catch (NumberFormatException e) {
            logger.error(String.format("支付宝支付成功通知： 外部订单号[%s]解析失败.", outTradeNo));
            throw new PayerException(e.getMessage());
        }
        payerService.paySure(applyId, outTradeNo, sellerId, Long.valueOf(totalFee));
    }

    public String getPublicKey() {
        return alipayPulicKey;
    }
}
