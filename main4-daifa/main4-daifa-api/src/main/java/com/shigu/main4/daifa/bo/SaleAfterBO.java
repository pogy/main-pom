package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：SaleAfterBO
 * @文件路径：com.shigu.main4.daifa.bo.SaleAfterBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:30
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class SaleAfterBO implements Serializable{
    //售后ID
    private Long refundId;
    //外部子单ID
    private Long subOid;
    //理由
    private String reason;
    //1退货,2换货
    private Integer afterType;
    //数量
    private Integer num;

    public Long getRefundId() {
        return this.refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getSubOid() {
        return this.subOid;
    }

    public void setSubOid(Long subOid) {
        this.subOid = subOid;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAfterType() {
        return this.afterType;
    }

    public void setAfterType(Integer afterType) {
        this.afterType = afterType;
    }

    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
