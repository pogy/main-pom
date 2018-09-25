package com.shigu.main4.pay.services;

import com.opentae.data.pays.beans.PayAccount;
import com.opentae.data.pays.beans.PayRecharge;
import com.opentae.data.pays.beans.PayTrade;
import com.opentae.data.pays.interfaces.PayRechargeMapper;
import com.shigu.main4.pay.configs.XzbSystemConstant;
import com.shigu.main4.pay.exceptions.XzbBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 类名：XzbAlipayHandleService
 * 类路径： com.shigu.main4.pay.services.XzbAlipayHandleService
 * 创建者： whx
 * 创建时间： 8/9/18 2:17 PM
 * 项目： main-pom
 * 描述：
 */
@Service
public class XzbAlipayHandleService {

    @Autowired
    private PayRechargeMapper payRechargeMapper;

    @Autowired
    private XzbBaseService xzbBaseService;

    @Autowired
    private XzbTradeService xzbTradeService;

    public void rechargeByAlipay(Long xzUserId, Long accountId, String alipayNo, Long money) throws XzbBaseException {
        PayAccount account = xzbBaseService.selPayAccount(xzUserId, accountId);
        PayRecharge payRecharge = new PayRecharge();
        payRecharge.setAlipayNo(alipayNo);
        int payRechargeCount = payRechargeMapper.selectCount(payRecharge);
        if (payRechargeCount > 0) {
            throw new XzbBaseException("该交易已经充值处理>>支付宝充值检测>>支付宝交易号:" + alipayNo);
        }
        Date now = new Date();
        payRecharge.setAlipayNo(alipayNo);
        payRecharge.setAccountId(account.getAccountId().toString());
        payRecharge.setCreateTime(now);
        payRecharge.setPrice(money);
        // 充值信息记录
        payRechargeMapper.insertSelective(payRecharge);

        PayTrade payTrade = new PayTrade();
        payTrade.setType(XzbSystemConstant.PAY_TRADE_TYPE_RECHARGE);
        payTrade.setAlipayNo(alipayNo);
        payTrade.setRechargeId(payRecharge.getRechargeId());
        payTrade.setFromAccountId(account.getAccountId());
        payTrade.setToAccountId(account.getAccountId());
        payTrade.setPrice(money);
        payTrade.setCreateTime(now);
        payTrade.setOutTradeNo(String.valueOf(System.nanoTime() + "_" + payRecharge.getRechargeId()));
        payTrade.setDebitType(XzbSystemConstant.PAY_TRADE_DEBIT_TYPE_ALIPAY);
        // 添加交易记录
        xzbTradeService.changeTrade(payTrade);
        // 公司支付宝添加记录
        xzbTradeService.addMoneyAlipay(XzbSystemConstant.COMPANY_ALIPAY_USER_ID, money);
        // 星座宝充值
        xzbTradeService.rechargeMoney(account.getAccountId(), money, XzbSystemConstant.XZB_RECORD_TYPE_RECHARGE, payTrade.getPayId(), payRecharge.getRechargeId());
    }
}
