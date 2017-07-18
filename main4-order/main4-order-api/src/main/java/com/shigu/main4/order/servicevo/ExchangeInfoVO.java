package com.shigu.main4.order.servicevo;

import com.shigu.main4.order.enums.ExchangeStatusEnum;
import com.shigu.main4.order.enums.ExchangeWaitStatusEnum;

/**
 * Created by zf on 2017/7/17.
 */
public class ExchangeInfoVO {
    /**
     * 换货进度，为0,1,2; 0买家申请换货, 1等待处理换货申请 2换货完成
     */
    private ExchangeStatusEnum exchangeStatus;
    /**
     * 申请状态,换货进度为1时存在,为0,1,2;
     * 0申请提交，等待处理, 1同意换货申请,填写快递信息， 2换货快递已提交
     */
    private ExchangeWaitStatusEnum exchangeWaitStatus;

    /**
     * 获取 换货进度，为0,1,2; 0买家申请换货, 1等待处理换货申请 2换货完成
     */
    public ExchangeStatusEnum getExchangeStatus() {
        return this.exchangeStatus;
    }

    /**
     * 设置 换货进度，为0,1,2; 0买家申请换货, 1等待处理换货申请 2换货完成
     */
    public void setExchangeStatus(ExchangeStatusEnum exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    /**
     * 申请状态,换货进度为1时存在,为0,1,2;
     * 0申请提交，等待处理, 1同意换货申请,填写快递信息， 2换货快递已提交
     */
    public ExchangeWaitStatusEnum getExchangeWaitStatus() {
        return this.exchangeWaitStatus;
    }

    /**
     * 申请状态,换货进度为1时存在,为0,1,2;
     * 0申请提交，等待处理, 1同意换货申请,填写快递信息， 2换货快递已提交
     */
    public void setExchangeWaitStatus(ExchangeWaitStatusEnum exchangeWaitStatus) {
        this.exchangeWaitStatus = exchangeWaitStatus;
    }
}
