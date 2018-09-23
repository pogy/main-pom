package com.shigu.daifa.services;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaAfterMoneyConsultExample;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaStockRecordExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.vo.OpenInfo;
import com.shigu.main4.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created By zyl on 2018/9/19 0019/17:13
 */
@Service
public class DaifaOrderStatusMoveService {

    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private DaifaSendOrderMapper daifaSendOrderMapper;
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;
    @Autowired
    private DaifaStockMapper daifaStockMapper;
    @Autowired
    private DaifaStockRecordMapper daifaStockRecordMapper;


    public List<OpenInfo> getStatusMoveVo(Long dfOrderId) {

        List<OpenInfo> openInfoList = new ArrayList<>();
        if (dfOrderId != null) {
            OpenInfo marke = getOpenInfo(dfOrderId);
            if (marke != null) {
                openInfoList.add(marke);
                List<OpenInfo> fenpei = getGoodsTask(dfOrderId);
                if (fenpei.size() > 0) {
                    openInfoList.addAll(fenpei);
                    OpenInfo yifa = sendOrder(dfOrderId);
                    if (yifa != null) {
                        openInfoList.add(yifa);
                        List<OpenInfo> sh = getAfterOrder(dfOrderId);
                        if (sh.size() > 0) {
                            openInfoList.addAll(sh);
                            List<OpenInfo> crk = getStock(dfOrderId);
                            if (crk.size() > 0) {
                                openInfoList.addAll(crk);
                                Long refundId = getrefundId(dfOrderId);
                                if (refundId != null) {
                                    List<OpenInfo> openInfos = getConsultMoney(refundId);
                                    if (openInfos != null) {
                                        openInfoList.addAll(openInfos);
                                        OpenInfo tuik = getAfterStoreRefundMoney(dfOrderId);
                                        if (tuik != null) {
                                            openInfoList.add(tuik);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return openInfoList;
    }


    public Long getrefundId(Long dfOrderId) {
        DaifaOrder order = new DaifaOrder();
        order.setDfOrderId(dfOrderId);
        order = daifaOrderMapper.selectOne(order);
        if (order == null) {
            return null;
        }
        return order.getRefundId();
    }

    //创建
    public OpenInfo getOpenInfo(Long dfOrderId) {
        DaifaOrder daifaOrder = daifaOrderMapper.selectByPrimaryKey(dfOrderId);
        if (daifaOrder != null) {
            OpenInfo openInfo = new OpenInfo();
            openInfo.setOpePeople("System");
            openInfo.setOpeStateText("创建");
            openInfo.setOpeTime(DateUtil.dateToString(daifaOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            return openInfo;
        }
        return null;
    }

    //分配
    public List<OpenInfo> getGoodsTask(Long dfOrderId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaGgoodsTasksExample tasksExample = new DaifaGgoodsTasksExample();
        tasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
        tasksExample.setOrderByClause("create_time asc");
        List<DaifaGgoodsTasks> tasksList = daifaGgoodsTasksMapper.selectByExample(tasksExample);
        for (DaifaGgoodsTasks tasks : tasksList) {
            if (tasks.getTakeGoodsStatus() != 0) {
                OpenInfo openInfo1 = new OpenInfo();
                String name = getWorkerName(tasks.getDaifaWorkerId());
                openInfo1.setOpePeople(name != null ? name : "System");
                openInfo1.setOpeStateText("分配");
                openInfo1.setOpeTime(DateUtil.dateToString(tasks.getAllocatTime(), "yyyy-MM-dd HH:mm:ss"));
                openInfos.add(openInfo1);

                if (tasks.getTakeGoodsStatus() == 1) {
                    OpenInfo openInfo2 = new OpenInfo();
                    openInfo2.setOpePeople(name != null ? name : "System");
                    openInfo2.setOpeStateText("拿货");
                    openInfo2.setOpeTime(tasks.getTakeGoodsDate());
                    openInfos.add(openInfo2);
                }

                if (tasks.getTakeGoodsStatus() == 2) {
                    OpenInfo openInfo2 = new OpenInfo();
                    openInfo2.setOpePeople(name != null ? name : "System");
                    openInfo2.setOpeStateText("缺货");
                    openInfo2.setOpeTime(DateUtil.dateToString(tasks.getYouhuoDate(), "yyyy-MM-dd HH:mm:ss"));
                    openInfos.add(openInfo2);
                }

                if (tasks.getDelistIs() == 1) {
                    OpenInfo openInfo3 = new OpenInfo();
                    OpenInfo openInfo4 = new OpenInfo();
                    openInfo3.setOpePeople(name != null ? name : "System");
                    openInfo3.setOpeStateText("下架");
                    openInfo3.setOpeTime(tasks.getTakeGoodsDate());
                    openInfos.add(openInfo3);
                    openInfo4.setOpeStateText("退款");
                    openInfo4.setOpeTime(tasks.getTakeGoodsDate());
                    openInfos.add(openInfo4);
                }
            }
        }
        return openInfos;
    }

    public String getWorkerName(Long dfWorkerId) {
        if (dfWorkerId != null) {
            DaifaWorker worker = new DaifaWorker();
            worker.setDaifaWorkerId(dfWorkerId);
            worker = daifaWorkerMapper.selectOne(worker);
            if (worker != null) {
                return worker.getUserName();
            }
        }
        return null;
    }

    public OpenInfo sendOrder(Long dfOrderId) {
        DaifaSendOrder sendOrder = new DaifaSendOrder();
        sendOrder.setDfOrderId(dfOrderId);
        sendOrder = daifaSendOrderMapper.selectOne(sendOrder);
        if (sendOrder != null) {
            OpenInfo openInfo = new OpenInfo();
            openInfo.setOpePeople("System");
            openInfo.setOpeStateText("发货");
            openInfo.setOpeTime(DateUtil.dateToString(sendOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            return openInfo;
        }
        return null;
    }

    public List<OpenInfo> getAfterOrder(Long dfOrderId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaAfterSaleSub afterSaleSub = new DaifaAfterSaleSub();
        afterSaleSub.setDfOrderId(dfOrderId);
        afterSaleSub = daifaAfterSaleSubMapper.selectOne(afterSaleSub);
        if (afterSaleSub != null) {
            OpenInfo openInfo1 = new OpenInfo();
            openInfo1.setOpePeople("System");
            openInfo1.setOpeStateText("申请售后");
            openInfo1.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyTime(), "yyyy-MM-dd HH:mm:ss"));
            openInfos.add(openInfo1);
            Integer applyDealStatus = afterSaleSub.getApplyDealStatus();
            if (applyDealStatus != null) {
                if (applyDealStatus == 1) {
                    OpenInfo openInfo2 = new OpenInfo();
                    OpenInfo openInfo3 = new OpenInfo();
                    openInfo2.setOpePeople("System");
                    openInfo2.setOpeStateText("同意申请");
                    openInfo2.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyDealTime(), "yyyy-MM-dd HH:mm:ss"));
                    openInfos.add(openInfo2);
                    openInfo3.setOpePeople("System");
                    openInfo3.setOpeStateText("填写快递单");
                    openInfo3.setOpeTime(DateUtil.dateToString(afterSaleSub.getSendReturnTime(), "yyyy-MM-dd HH:mm:ss"));
                    openInfos.add(openInfo3);
                } else {
                    OpenInfo openInfo2 = new OpenInfo();
                    OpenInfo openInfo3 = new OpenInfo();
                    openInfo2.setOpeStateText("拒绝申请");
                    openInfo2.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyDealTime(), "yyyy-MM-dd HH:mm:ss"));
                    openInfo3.setOpeStateText("结束");
                    openInfo3.setOpeTime(DateUtil.dateToString(afterSaleSub.getLastDoTime(), "yyyy-MM-dd HH:mm:ss"));
                    openInfos.add(openInfo2);
                    openInfos.add(openInfo3);
                }
            }
        }
        return openInfos;
    }


    public List<OpenInfo> getStock(Long dfOrderId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaStock daifaStock = new DaifaStock();
        daifaStock.setDfOrderId(dfOrderId);
        daifaStock = daifaStockMapper.selectOne(daifaStock);
        if (daifaStock != null) {
            DaifaStockRecordExample recordExample = new DaifaStockRecordExample();
            recordExample.createCriteria().andStockIdEqualTo(daifaStock.getStockId());
            recordExample.setOrderByClause("stock_record_id asc");
            List<DaifaStockRecord> recordList = daifaStockRecordMapper.selectByExample(recordExample);
            if (recordList.size() > 0) {
                for (DaifaStockRecord stockRecord : recordList) {
                    String name = stockRecord.getDaifaWorker();
                    if (stockRecord.getInOutType() == 1) {
                        OpenInfo openInfo1 = new OpenInfo();
                        openInfo1.setOpePeople(name != null ? name : "System");
                        openInfo1.setOpeStateText("入库");
                        openInfo1.setOpeTime(DateUtil.dateToString(stockRecord.getInTime(), "yyyy-MM-dd HH:mm:ss"));
                        openInfos.add(openInfo1);
                    }
                    if (stockRecord.getInOutType() == 2) {
                        OpenInfo openInfo2 = new OpenInfo();
                        openInfo2.setOpePeople(name != null ? name : "System");
                        openInfo2.setOpeStateText("出库");
                        openInfo2.setOpeTime(DateUtil.dateToString(stockRecord.getOutTime(), "yyyy-MM-dd HH:mm:ss"));
                        openInfos.add(openInfo2);
                        List<OpenInfo> openInfos1 = getAfterStoreDeal(dfOrderId);
                        openInfos.addAll(openInfos1);
                    }
                    if (stockRecord.getInOutType() == 3) {
                        OpenInfo openInfo3 = new OpenInfo();
                        openInfo3.setOpePeople(name != null ? name : "System");
                        openInfo3.setOpeStateText("档口退货完成");
                        openInfo3.setOpeTime(DateUtil.dateToString(stockRecord.getReturnTime(), "yyyy-MM-dd HH:mm:ss"));
                        openInfos.add(openInfo3);
                    }
                }
            }
        }
        return openInfos;
    }

    public List<OpenInfo> getAfterStoreDeal(Long dfOrderId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaAfterSaleSub afterSaleSub = new DaifaAfterSaleSub();
        afterSaleSub.setDfOrderId(dfOrderId);
        afterSaleSub = daifaAfterSaleSubMapper.selectOne(afterSaleSub);
        if (afterSaleSub.getStoreDealStatus() == 1) {
            OpenInfo openInfo = new OpenInfo();
            openInfo.setOpePeople("System");
            openInfo.setOpeStateText("档口同意退款");
            openInfo.setOpeTime(DateUtil.dateToString(afterSaleSub.getStoreDealTime(), "yyyy-MM-dd HH:mm:ss"));
            openInfos.add(openInfo);
        }
        if (afterSaleSub.getStoreDealStatus() == 2) {
            OpenInfo openInfo2 = new OpenInfo();
            OpenInfo openInfo1 = new OpenInfo();
            openInfo2.setOpePeople("System");
            openInfo2.setOpeStateText("档口拒绝退款");
            openInfo2.setOpeTime(DateUtil.dateToString(afterSaleSub.getStoreDealTime(), "yyyy-MM-dd HH:mm:ss"));
            openInfos.add(openInfo2);
            openInfo1.setOpePeople("System");
            openInfo1.setOpeStateText("结束");
            openInfo1.setOpeTime(DateUtil.dateToString(afterSaleSub.getLastDoTime(), "yyyy-MM-dd HH:mm:ss"));
            openInfos.add(openInfo1);
        }
        return openInfos;
    }


    public List<OpenInfo> getConsultMoney(Long refundId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaAfterMoneyConsultExample consultExample = new DaifaAfterMoneyConsultExample();
        consultExample.createCriteria().andRefundIdEqualTo(refundId);
        consultExample.setOrderByClause("create_time asc");
        List<DaifaAfterMoneyConsult> consultList = daifaAfterMoneyConsultMapper.selectByExample(consultExample);
        for (DaifaAfterMoneyConsult moneyConsult : consultList) {
            if (moneyConsult.getConsultType() == 2) {
                OpenInfo openInfo1 = new OpenInfo();
                openInfo1.setOpePeople("System");
                openInfo1.setOpeStateText("拒绝议价");
                openInfo1.setOpeTime(DateUtil.dateToString(moneyConsult.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                openInfos.add(openInfo1);
            }
            if (moneyConsult.getConsultType() == 1) {
                OpenInfo openInfo = new OpenInfo();
                openInfo.setOpePeople("System");
                openInfo.setOpeStateText("议价");
                openInfo.setOpeTime(DateUtil.dateToString(moneyConsult.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                openInfos.add(openInfo);
            }
        }
        return openInfos;
    }

    public OpenInfo getAfterStoreRefundMoney(Long dfOrderId) {
        DaifaAfterSaleSub afterSaleSub = new DaifaAfterSaleSub();
        afterSaleSub.setDfOrderId(dfOrderId);
        afterSaleSub = daifaAfterSaleSubMapper.selectOne(afterSaleSub);
        if (afterSaleSub.getAfterStatus() == 6) {
            if (StringUtils.isNotBlank(afterSaleSub.getStoreReturnMoney())) {
                OpenInfo openInfo = new OpenInfo();
                openInfo.setOpePeople("System");
                openInfo.setOpeStateText("退款");
                openInfo.setOpeTime(DateUtil.dateToString(afterSaleSub.getLastDoTime(), "yyyy-MM-dd HH:mm:ss"));
                return openInfo;
            }
        }
        return null;
    }
}
