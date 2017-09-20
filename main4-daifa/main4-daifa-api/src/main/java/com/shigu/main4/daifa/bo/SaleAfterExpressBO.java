package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：SaleAfterExpressBO
 * @文件路径：com.shigu.main4.daifa.bo.SaleAfterExpressBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:14
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SaleAfterExpressBO implements Serializable{
    //售后ID
    private Long refundId;
    //快递名
    private String expressName;
    //快递单号
    private String expressCode;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public String getExpressName() {
        return this.expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return this.expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}
