package com.shigu.daifa.vo;

import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;
import com.opentae.data.daifa.beans.DaifaStockRecord;

import java.util.List;

/**
 * Created By zyl on 2018/9/19 0019/17:28
 */
public class StatusMoveVo {

    private List<OpenInfo> openInfoList;

    public List<OpenInfo> getOpenInfoList() {
        return openInfoList;
    }

    public void setOpenInfoList(List<OpenInfo> openInfoList) {
        this.openInfoList = openInfoList;
    }

    private Long dfTradeId;
    private Long dfOrderId;
    private Long status;//订单状态
    private String createTime;//代发订单创建时间
    private List<GoodsTasksVo> goodsTasksVoList;//订单拿货信息集合
    private Integer delistIs;//下架标志 0可售1下架
    private Integer taskGoodsStatus;//拿货状态
    private String taskGoodsDate;//拿货日期
    private String haveGoodsDate;//有货日期
    private String sendTime;//发货时间
    private String sendExpressName;//发货的快递
    private String getSendExpressCode;
    private Integer afterType;//售后类型
    private Integer afterStatus;//售后状态
    private String applyTime;//售后申请时间
    private Integer applyDealStatus;//售后申请状态
    private String applyDealTime;//申请处理时间
    private String applyRefuseReason;//拒绝申请的原因
    private String applyExpressName;//退货的快递名
    private String applyExpressCode;//退货的快递单号

    private String consultMoney;//退款金额
    private String refundTime;//退款时间


    private Integer sendStatus;//发货状态@1待发货2已发货

    private Integer stockStatus;//入库状态
    private Integer refundStatus;//退款状态


    private String receivedTime;//收货时间
    private Integer inStock;//入库状态
    private Long stockId;//库存id
    private Long inOutType;//库存状态
    private String inTime;
    private String outTime;
    private String daifaWorker;//库存操作人员
    private Long refundId;//
    private Integer consultType;//协商类型


    private List<DaifaStockRecord> recordList;

    private List<DaifaAfterMoneyConsult> consultList;

    public String getSendExpressName() {
        return sendExpressName;
    }

    public void setSendExpressName(String sendExpressName) {
        this.sendExpressName = sendExpressName;
    }

    public String getGetSendExpressCode() {
        return getSendExpressCode;
    }

    public void setGetSendExpressCode(String getSendExpressCode) {
        this.getSendExpressCode = getSendExpressCode;
    }

    public String getHaveGoodsDate() {
        return haveGoodsDate;
    }

    public void setHaveGoodsDate(String haveGoodsDate) {
        this.haveGoodsDate = haveGoodsDate;
    }

    public String getTaskGoodsDate() {
        return taskGoodsDate;
    }

    public void setTaskGoodsDate(String taskGoodsDate) {
        this.taskGoodsDate = taskGoodsDate;
    }

    public List<DaifaAfterMoneyConsult> getConsultList() {
        return consultList;
    }

    public void setConsultList(List<DaifaAfterMoneyConsult> consultList) {
        this.consultList = consultList;
    }

    public List<DaifaStockRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<DaifaStockRecord> recordList) {
        this.recordList = recordList;
    }

    public Integer getAfterType() {
        return afterType;
    }

    public void setAfterType(Integer afterType) {
        this.afterType = afterType;
    }

    public Integer getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(Integer afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyDealStatus() {
        return applyDealStatus;
    }

    public void setApplyDealStatus(Integer applyDealStatus) {
        this.applyDealStatus = applyDealStatus;
    }

    public String getApplyDealTime() {
        return applyDealTime;
    }

    public void setApplyDealTime(String applyDealTime) {
        this.applyDealTime = applyDealTime;
    }

    public String getApplyRefuseReason() {
        return applyRefuseReason;
    }

    public void setApplyRefuseReason(String applyRefuseReason) {
        this.applyRefuseReason = applyRefuseReason;
    }

    public String getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(String receivedTime) {
        this.receivedTime = receivedTime;
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

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getInOutType() {
        return inOutType;
    }

    public void setInOutType(Long inOutType) {
        this.inOutType = inOutType;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDaifaWorker() {
        return daifaWorker;
    }

    public void setDaifaWorker(String daifaWorker) {
        this.daifaWorker = daifaWorker;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Integer getConsultType() {
        return consultType;
    }

    public void setConsultType(Integer consultType) {
        this.consultType = consultType;
    }

    public String getConsultMoney() {
        return consultMoney;
    }

    public void setConsultMoney(String consultMoney) {
        this.consultMoney = consultMoney;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getTaskGoodsStatus() {
        return taskGoodsStatus;
    }

    public void setTaskGoodsStatus(Integer taskGoodsStatus) {
        this.taskGoodsStatus = taskGoodsStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getDelistIs() {
        return delistIs;
    }

    public void setDelistIs(Integer delistIs) {
        this.delistIs = delistIs;
    }

    public Long getDfTradeId() {
        return dfTradeId;
    }

    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }

    public Long getDfOrderId() {
        return dfOrderId;
    }

    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<GoodsTasksVo> getGoodsTasksVoList() {
        return goodsTasksVoList;
    }

    public void setGoodsTasksVoList(List<GoodsTasksVo> goodsTasksVoList) {
        this.goodsTasksVoList = goodsTasksVoList;
    }
}
