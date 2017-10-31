package com.shigu.main4.daifa.bo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：RebackPrintExpressBO
 * @文件路径：com.shigu.main4.daifa.bo.RebackPrintExpressBO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:45
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class RebackPrintExpressBO implements Serializable{

    private static final long serialVersionUID = -1768970772342636048L;

    /**
     * 返回的订单号
     */
    private Long orderId;
    /**
     * 寄回的快递名@退换货信息
     */
    private String applyExpressName;

    /**
     * 寄回的快递号@退换货信息
     */
    private String applyExpressCode;
    /**
     * 退货发回的快递单号
     */
    private String returnExpressCode;

    /**
     * 退货发回的快递名
     */
    private String returnExpressName;

    /**
     * 换回的快递单号
     */
    private String changeExpressCode;
    /**
     * 换货发回快递名
     */
    private String changeExpressName;
    /**
     * 卖家备注
     */
    private String remark;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getApplyExpressName() {
        return applyExpressName;
    }

    public void setApplyExpressName(String applyExpressName) {
        this.applyExpressName = applyExpressName;
    }

    public String getApplyExpressCode() {
        return applyExpressCode;
    }

    public void setApplyExpressCode(String applyExpressCode) {
        this.applyExpressCode = applyExpressCode;
    }

    public String getReturnExpressCode() {
        return returnExpressCode;
    }

    public void setReturnExpressCode(String returnExpressCode) {
        this.returnExpressCode = returnExpressCode;
    }

    public String getChangeExpressCode() {
        return changeExpressCode;
    }

    public void setChangeExpressCode(String changeExpressCode) {
        this.changeExpressCode = changeExpressCode;
    }

    public String getReturnExpressName() {
        return returnExpressName;
    }

    public void setReturnExpressName(String returnExpressName) {
        this.returnExpressName = returnExpressName;
    }

    public String getChangeExpressName() {
        return changeExpressName;
    }

    public void setChangeExpressName(String changeExpressName) {
        this.changeExpressName = changeExpressName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
