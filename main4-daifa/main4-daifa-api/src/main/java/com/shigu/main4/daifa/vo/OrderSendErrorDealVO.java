package com.shigu.main4.daifa.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：OrderSendErrorDealVO
 * @文件路径：com.shigu.main4.daifa.vo.OrderSendErrorDealVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 15:48
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class OrderSendErrorDealVO implements Serializable{
    private Long dfTradeId;
    private String success;

    public Long getDfTradeId () {
        return dfTradeId;
    }

    public void setDfTradeId (Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getSuccess () {
        return success;
    }

    public void setSuccess (String success) {
        this.success = success;
    }
}
