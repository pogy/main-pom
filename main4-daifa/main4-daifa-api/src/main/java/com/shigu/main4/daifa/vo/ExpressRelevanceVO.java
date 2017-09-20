package com.shigu.main4.daifa.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @类编号
 * @类名称：ExpressRelevanceVO
 * @文件路径：com.shigu.main4.daifa.vo.ExpressRelevanceVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:25
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ExpressRelevanceVO implements Serializable{
    private Long saleId;
    private Long dfTradeId;
    private String createTime;
    private String imWw;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String totalFee;
    private String expressFee;
    private String discountFee;
    private String serversFee;
    private String remark;
    private List<ExpressRelevanceSubVO> orders;

    public Long getSaleId() {
        return this.saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getDfTradeId() {
        return this.dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImWw() {
        return this.imWw;
    }

    public void setImWw(String imWw) {
        this.imWw = imWw;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return this.receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return this.receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getTotalFee() {
        return this.totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getExpressFee() {
        return this.expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public String getDiscountFee() {
        return this.discountFee;
    }

    public void setDiscountFee(String discountFee) {
        this.discountFee = discountFee;
    }

    public String getServersFee() {
        return this.serversFee;
    }

    public void setServersFee(String serversFee) {
        this.serversFee = serversFee;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ExpressRelevanceSubVO> getOrders() {
        return this.orders;
    }

    public void setOrders(List<ExpressRelevanceSubVO> orders) {
        this.orders = orders;
    }
}
