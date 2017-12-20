package com.shigu.trade.services;

import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.trade.bo.ScanPayBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 微信支付服务
 * Created by bugzy on 2017/6/15 0015.
 */
@Service
public class WxPayService {

    private static final Logger logger = LoggerFactory.getLogger(WxPayService.class);

    @Resource(name="wxPayerService")
    private PayerService payerService;

    @Transactional(rollbackFor = Exception.class)
    public void payNotice(ScanPayBo payBo) throws PayerException {
        String out_trade_no = payBo.getOut_trade_no();
        Long applyId;
        try {
            applyId = Long.valueOf(out_trade_no.substring(2));
        } catch (NumberFormatException e) {
            logger.error(String.format("微信支付成功通知： 外部订单号[%s]解析失败.", out_trade_no));
            return;
        }
        payerService.paySure(applyId, payBo.getTransaction_id(), payBo.getOpenid(), Long.valueOf(payBo.getTotal_fee()));
    }
}
