package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：MoneyConsultBO
 * @文件路径：com.shigu.main4.daifa.bo.MoneyConsultBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:56
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class MoneyConsultBO implements Serializable{
    //售后ID
    private Long refundId;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }
}
