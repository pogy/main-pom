package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.vo.OpenInfo;
import com.shigu.daifa.vo.StatusMoveVo;
import com.shigu.main4.common.util.DateUtil;
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
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
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
            //拿货

            OpenInfo marke = getOpenInfo(dfOrderId);
            if (marke != null) {
                openInfoList.add(marke);
                List<OpenInfo> fenpei = getGoodsTask(dfOrderId);
                if (fenpei.size()>0) {
                    openInfoList.addAll(fenpei);
                    OpenInfo yifa = sendOrder(dfOrderId);
                    if (yifa != null) {
                        openInfoList.add(yifa);
                        List<OpenInfo> sh = getAfterOrder(dfOrderId);
                        if (sh.size()>0) {
                            openInfoList.addAll(sh);
                            OpenInfo crk = getStock(dfOrderId);
                            if (crk != null) {
                                openInfoList.add(crk);

                                    Long refundId = getrefundId(dfOrderId);
                                    if (refundId != null) {
                                        List<OpenInfo> openInfos = getConsultMoney(refundId);
                                        if (openInfos != null) {
                                            openInfoList.addAll(openInfos);
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
        OpenInfo openInfo = new OpenInfo();
        DaifaOrder daifaOrder = daifaOrderMapper.selectByPrimaryKey(dfOrderId);
        if (daifaOrder != null) {
            openInfo.setOpePeople("");
            openInfo.setOpeStateText("创建");
            openInfo.setOpeTime(DateUtil.dateToString(daifaOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return openInfo;
    }

    //分配
    public List<OpenInfo> getGoodsTask(Long dfOrderId) {
        OpenInfo openInfo1 = new OpenInfo();
        OpenInfo openInfo2 = new OpenInfo();
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaGgoodsTasksExample tasksExample = new DaifaGgoodsTasksExample();
        tasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
        tasksExample.setOrderByClause("create_time desc");
        List<DaifaGgoodsTasks> tasksList = daifaGgoodsTasksMapper.selectByExample(tasksExample);
        for (DaifaGgoodsTasks tasks : tasksList) {
            if (tasks.getTakeGoodsStatus() == 1) {
                String name = getWorkerName(tasks.getDaifaWorkerId());
                openInfo1.setOpePeople(name != null ? name : null);
                openInfo1.setOpeStateText("分配");
                openInfo1.setOpeTime(DateUtil.dateToString(tasks.getAllocatTime(), "yyyy-MM-dd HH:mm:ss"));

                openInfo2.setOpePeople(name != null ? name : null);
                openInfo2.setOpeStateText("拿货");
                openInfo2.setOpeTime(tasks.getTakeGoodsDate());
            }
            if (tasks.getTakeGoodsStatus() == 2) {
                String name = getWorkerName(tasks.getDaifaWorkerId());
                openInfo1.setOpePeople(name != null ? name : null);
                openInfo1.setOpeStateText("缺货");
                openInfo1.setOpeTime(DateUtil.dateToString(tasks.getYouhuoDate(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (tasks.getDelistIs() == 1) {
                String name = getWorkerName(tasks.getDaifaWorkerId());
                openInfo1.setOpePeople(name != null ? name : null);
                openInfo1.setOpeStateText("下架");
                openInfo1.setOpeTime(DateUtil.dateToString(tasks.getYouhuoDate(), "yyyy-MM-dd HH:mm:ss"));
            }

        }
        openInfos.add(openInfo1);
        openInfos.add(openInfo2);
        return openInfos;
    }

    public String getWorkerName(Long dfWorkerId) {
        DaifaWorker worker = new DaifaWorker();
        if (dfWorkerId != null){
            worker.setDaifaWorkerId(dfWorkerId);
            worker = daifaWorkerMapper.selectOne(worker);
            if (worker != null) {
                return worker.getUserName();
            }
        }
        return "";
    }

    public OpenInfo sendOrder(Long dfOrderId) {
        OpenInfo openInfo = new OpenInfo();
        DaifaSendOrder sendOrder = new DaifaSendOrder();
        sendOrder.setDfOrderId(dfOrderId);
        sendOrder = daifaSendOrderMapper.selectOne(sendOrder);
        if (sendOrder != null) {
            openInfo.setOpePeople("");
            openInfo.setOpeStateText("发货");
            openInfo.setOpeTime(DateUtil.dateToString(sendOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        return openInfo;
    }

    public List<OpenInfo> getAfterOrder(Long dfOrderId) {
        List<OpenInfo> openInfos = new ArrayList<>();
        OpenInfo openInfo1 = new OpenInfo();
        OpenInfo openInfo2 = new OpenInfo();
        OpenInfo openInfo3 = new OpenInfo();
        DaifaAfterSaleSub afterSaleSub = new DaifaAfterSaleSub();
        afterSaleSub.setDfOrderId(dfOrderId);
        afterSaleSub = daifaAfterSaleSubMapper.selectOne(afterSaleSub);
        if (afterSaleSub != null) {
            openInfo1.setOpePeople("");
            openInfo1.setOpeStateText("申请售后");
            openInfo1.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyTime(), "yyyy-MM-dd HH:mm:ss"));

            Integer applyDealStatus = afterSaleSub.getApplyDealStatus();
            if (applyDealStatus != null){
                if ( applyDealStatus== 1) {
                    openInfo2.setOpeStateText("同意申请");
                    openInfo2.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyDealTime(), "yyyy-MM-dd HH:mm:ss"));

                    openInfo3.setOpeStateText("填写快递单");
                    openInfo3.setOpeTime(DateUtil.dateToString(afterSaleSub.getSendReturnTime(), "yyyy-MM-dd HH:mm:ss"));

                    openInfo3.setOpeStateText("入库");
                    openInfo3.setOpeTime(DateUtil.dateToString(afterSaleSub.getSendReturnTime(), "yyyy-MM-dd HH:mm:ss"));
                } else {
                    openInfo2.setOpeStateText("拒绝申请");
                    openInfo2.setOpeTime(DateUtil.dateToString(afterSaleSub.getApplyDealTime(), "yyyy-MM-dd HH:mm:ss"));
                }
            }
        }
        openInfos.add(openInfo1);
        openInfos.add(openInfo2);
        openInfos.add(openInfo3);
        return openInfos;
    }


    public OpenInfo getStock(Long dfOrderId) {
        OpenInfo openInfo = new OpenInfo();
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
                    if (stockRecord.getInOutType() == 1) {
                        openInfo.setOpePeople(stockRecord.getDaifaWorker());
                        openInfo.setOpeStateText("入库");
                        openInfo.setOpeTime(DateUtil.dateToString(stockRecord.getInTime(), "yyyy-MM-dd HH:mm:ss"));
                    }
                    if (stockRecord.getInOutType() == 2) {
                        openInfo.setOpePeople(stockRecord.getDaifaWorker());
                        openInfo.setOpeStateText("出库");
                        openInfo.setOpeTime(DateUtil.dateToString(stockRecord.getOutTime(), "yyyy-MM-dd HH:mm:ss"));
                    }
                    if (stockRecord.getInOutType() == 3) {
                        openInfo.setOpePeople(stockRecord.getDaifaWorker());
                        openInfo.setOpeStateText("退货完成");
                        openInfo.setOpeTime(DateUtil.dateToString(stockRecord.getReturnTime(), "yyyy-MM-dd HH:mm:ss"));
                    }
                }
            }
        }
        return openInfo;
    }


    public List<OpenInfo> getConsultMoney(Long refundId) {
        OpenInfo openInfo=new OpenInfo();
        List<OpenInfo> openInfos = new ArrayList<>();
        DaifaAfterMoneyConsultExample consultExample = new DaifaAfterMoneyConsultExample();
        consultExample.createCriteria().andRefundIdEqualTo(refundId);
        consultExample.setOrderByClause("after_consult_id desc");
        List<DaifaAfterMoneyConsult> consultList = daifaAfterMoneyConsultMapper.selectByExample(consultExample);
        for (DaifaAfterMoneyConsult moneyConsult : consultList) {
            if (moneyConsult.getConsultType() == 1) {
                openInfo.setOpePeople("");
                openInfo.setOpeStateText("议价");
                openInfo.setOpeTime(DateUtil.dateToString(moneyConsult.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if (moneyConsult.getConsultType() == 1) {
                openInfo.setOpePeople("");
                openInfo.setOpeStateText("拒绝议价");
                openInfo.setOpeTime(DateUtil.dateToString(moneyConsult.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            }
        }
        openInfos.add(openInfo);
        return openInfos;
    }


//    public StatusMoveVo selDaifaOrder(Long dfOrderId) {
//        List<OpenInfo> openInfoList = new ArrayList<>();
//
//        StatusMoveVo moveVo = new StatusMoveVo();
//        DaifaOrder daifaOrder = daifaOrderMapper.selectFieldsByPrimaryKey(dfOrderId, FieldUtil.codeFields("df_trade_id,df_order_id,create_time,order_status,take_goods_status,take_goods_date,delist_is,have_goods_date"));
//        if (daifaOrder != null) {
//            moveVo.setDfTradeId(daifaOrder.getDfTradeId());
//            moveVo.setDfOrderId(daifaOrder.getDfOrderId());
//            moveVo.setCreateTime(DateUtil.dateToString(daifaOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));//代发订单创建时间
//            Long orderStatus = daifaOrder.getOrderStatus();
//            moveVo.setStatus(orderStatus);//订单状态 1、已付款（等待分配），2、配货中，3、发货
//            if (orderStatus == 1) {//订单创建
//                return moveVo;
//            }
//            List<GoodsTasksVo> goodsTasksVo = getGoodsTasks(dfOrderId);
//            moveVo.setGoodsTasksVoList(goodsTasksVo);
//            Integer takeGoodsStatus = daifaOrder.getTakeGoodsStatus();//拿货状态@0未拿1已拿2缺货（默认为0）
//            if (takeGoodsStatus == 0) {
//                return moveVo;
//            }
//            moveVo.setTaskGoodsDate(DateUtil.dateToString(daifaOrder.getTakeGoodsDate(), "yyyy-MM-dd HH:mm:ss"));//拿货日期
//            if (takeGoodsStatus == 1) {
//                return moveVo;
//            }
//            if (daifaOrder.getDelistIs() == 1) {//有下架标志，则设置下架，否则就是有货日期。 delistis = 0 haveGoodsDate = null 的情况不存在
//                moveVo.setDelistIs(1);
//            } else {
//                moveVo.setHaveGoodsDate(DateUtil.dateToString(daifaOrder.getHaveGoodsDate(), "yyyy-MM-dd HH:mm:ss"));//有货日期
//            }
////            if (takeGoodsStatus == 2){
////                return moveVo;
////            }
//            if (orderStatus == 2) {//已分配，拿货中，获取分配时间，分配人,拿货情况
//                return moveVo;
//            }
//            //发货信息
//            DaifaWaitSendOrder daifaWaitSendOrder = new DaifaWaitSendOrder();
//            daifaWaitSendOrder.setDfOrderId(dfOrderId);
//            daifaWaitSendOrder = daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
//
//            DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(moveVo.getDfTradeId());//发货信息，快递
//            moveVo.setApplyExpressName(trade.getExpressName());
//            moveVo.setApplyExpressCode(trade.getExpressCode());
//            moveVo.setSendTime(DateUtil.dateToString(trade.getSendTime(), "yyyy-MM-dd HH:mm:ss"));
//
//            if (orderStatus == 3) {//已发
//                DaifaAfterSaleSub afterSaleSub = selAfterOrder(dfOrderId);
//                if (afterSaleSub == null) {//没有售后信息
//                    return moveVo;
//                } else {
//                    disposeAfter(moveVo, afterSaleSub);
//
//                }
//            }
//        }
//        return moveVo;
//    }
//
//    public StatusMoveVo disposeAfter(StatusMoveVo moveVo, DaifaAfterSaleSub afterSaleSub) {
//        moveVo.setAfterType(afterSaleSub.getAfterType());
//        Integer afterStatus = afterSaleSub.getAfterStatus();
//        moveVo.setAfterStatus(afterStatus);
//
//        moveVo.setApplyTime(DateUtil.dateToString(afterSaleSub.getApplyTime(), "yyyy-MM-dd HH:mm:ss"));
//        if (afterStatus == 1) { //售后状态@0无售后1售后申请2申请处理3客户发货4收到货5档口退换货完成6客户确认7客户拒绝10协商解决
//            return moveVo;
//        }
//        Integer applyDealStatus = afterSaleSub.getApplyDealStatus();//售后申请状态@1同意并发送售后收货地址2拒绝
//        moveVo.setApplyDealStatus(applyDealStatus);
//        if (applyDealStatus == 1) {
//            moveVo.setApplyDealTime(DateUtil.dateToString(afterSaleSub.getApplyDealTime(), "yyyy-MM-dd HH:mm:ss"));
//        } else {
//            moveVo.setApplyRefuseReason(afterSaleSub.getApplyRefuseReason());
//        }
//        if (afterStatus == 2) {
//            return moveVo;
//        }
//        moveVo.setApplyExpressName(afterSaleSub.getApplyExpressName());//退回的快递信息
//        moveVo.setApplyExpressCode(afterSaleSub.getApplyExpressCode());
//        if (afterStatus == 3) {
//            return moveVo;
//        }
//        //收到货。入库信息
//        DaifaStock daifaStock = new DaifaStock();
//        daifaStock.setDfOrderId(moveVo.getDfOrderId());
//        daifaStock = daifaStockMapper.selectOne(daifaStock);
//        DaifaStockRecordExample recordExample = new DaifaStockRecordExample();
//        recordExample.createCriteria().andStockIdEqualTo(daifaStock.getStockId());
//        recordExample.setOrderByClause("stock_record_id asc");
//        List<DaifaStockRecord> recordList = daifaStockRecordMapper.selectByExample(recordExample);
////        DaifaStockRecord stockRecord = recordList.get(recordList.size()-1);//最后一条记录
////        Integer inOutType = stockRecord.getInOutType();
//        List<DaifaStockRecord> stockRecords = new ArrayList<>();
//
//        stockRecords.add(recordList.get(0));//取第一条最后一条记录
//        stockRecords.add(recordList.get(recordList.size() - 1));
//
//        moveVo.setRecordList(stockRecords);
//        if (afterStatus == 4 || afterStatus == 5) {
//            return moveVo;
//        }
//
//        if (afterStatus == 6) {//客户同意退款
//            StatusMoveVo statusMoveVo = selConsult(moveVo, 1);
//            return statusMoveVo;
//        }
//        if (afterStatus == 7) {//拒绝
//            StatusMoveVo statusMoveVo = selConsult(moveVo, 2);
//            return statusMoveVo;
//        }
//        return moveVo;
//    }
//
//    public StatusMoveVo selConsult(StatusMoveVo moveVo, Integer consultType) {
//        DaifaAfterMoneyConsultExample consultExample = new DaifaAfterMoneyConsultExample();
//        consultExample.createCriteria().andRefundIdEqualTo(moveVo.getRefundId()).andConsultTypeEqualTo(consultType);
//        consultExample.setOrderByClause("after_consult_id desc");
//        List<DaifaAfterMoneyConsult> consultList = daifaAfterMoneyConsultMapper.selectByExample(consultExample);
//        DaifaAfterMoneyConsult afterMoneyConsult = consultList.get(0);
//        moveVo.setConsultMoney(afterMoneyConsult.getConsultMoney());//同意或拒绝退款的金额
//        moveVo.setRefundTime(DateUtil.dateToString(afterMoneyConsult.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));//同意或拒绝退款的时间
//        return moveVo;
//    }
//
//    public List<GoodsTasksVo> getGoodsTasks(Long dfOrderId) {
//        List<GoodsTasksVo> goodsTasksVo = new ArrayList<>();
//        DaifaGgoodsTasksExample tasksExample = new DaifaGgoodsTasksExample();
//        tasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
//        tasksExample.setOrderByClause("create_time ASC");
//        List<DaifaGgoodsTasks> tasksList = daifaGgoodsTasksMapper.selectFieldsByExample(tasksExample, FieldUtil.codeFields("tasks_id,daifa_worker_id,allocat_time"));
//        List<Long> longList = tasksList.stream().map(daifaGgoodsTasks -> daifaGgoodsTasks.getDaifaWorkerId()).collect(Collectors.toList());
//
//        DaifaWorkerExample workerExample = new DaifaWorkerExample();
//        workerExample.createCriteria().andDaifaWorkerIdIn(longList);
//        List<DaifaWorker> workerList = daifaWorkerMapper.selectFieldsByExample(workerExample, FieldUtil.codeFields("daifa_worker_id,user_Name"));
//        Map<Long, String> workerMap = workerList.stream().collect(Collectors.toMap(DaifaWorker::getDaifaWorkerId, DaifaWorker::getUserName));
//        for (DaifaGgoodsTasks tasks : tasksList) {
//            GoodsTasksVo tasksVo = new GoodsTasksVo();
//            tasksVo.setTasksId(tasks.getTasksId());
//            tasksVo.setDaifaWorkerId(tasks.getDaifaWorkerId() != null ? tasks.getDaifaWorkerId() : null);
//            String allTime = DateUtil.dateToString(tasks.getAllocatTime(), "yyyy-MM-dd HH:mm:ss");
//            tasksVo.setAllocatTime(allTime != null ? allTime : null);
//            tasksVo.setUserName(workerMap.get(tasks.getDaifaWorkerId()));
//            goodsTasksVo.add(tasksVo);//taskId ,分配时间，拿货人id ,姓名
//        }
//        return goodsTasksVo;
//    }
//
//    public DaifaAfterSaleSub selAfterOrder(Long dfOrderId) {
//        DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
//        daifaAfterSaleSub.setDfOrderId(dfOrderId);
//        return daifaAfterSaleSubMapper.selectOne(daifaAfterSaleSub);
//    }

//    public StatusMoveVo selOrderMove(Long dfOrderId) {
//        StatusMoveVo moveVo = new StatusMoveVo();
//        List<GoodsTasksVo> goodsTasksVo = new ArrayList<>();
//
//        DaifaOrderExample orderExample = new DaifaOrderExample();
//        orderExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
//        DaifaOrder daifaOrder = daifaOrderMapper.selectFieldsByPrimaryKey(dfOrderId, FieldUtil.codeFields("df_order_id,df_trade_id,create_time,order_status,delist_is"));
//        if (daifaOrder != null) {
//
//            //moveVo.setCreateTime(DateUtil.dateToString(daifaOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));//代发订单创建时间
//            moveVo.setStatus(daifaOrder.getOrderStatus());//订单状态 1、已付款（等待分配），2、配货中，3、发货
//            moveVo.setDfOrderId(dfOrderId);//子单号，即查询所用单号
//            moveVo.setDelistIs(daifaOrder.getDelistIs());//下架标记 0可售1下架
//            moveVo.setDfTradeId(daifaOrder.getDfTradeId());//交易id
//
//            DaifaGgoodsTasksExample tasksExample = new DaifaGgoodsTasksExample();
//            tasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
//            tasksExample.setOrderByClause("create_time ASC");
//            List<DaifaGgoodsTasks> tasksList = daifaGgoodsTasksMapper.selectFieldsByExample(tasksExample, FieldUtil.codeFields("tasks_id,daifa_worker_id,allocat_time"));
//            if (tasksList.get(0).getAllocatTime() == null){
//                return moveVo;
//            }
//            List<Long> longList = tasksList.stream().map(daifaGgoodsTasks -> daifaGgoodsTasks.getDaifaWorkerId()).collect(Collectors.toList());
//
//            DaifaWorkerExample workerExample = new DaifaWorkerExample();
//            workerExample.createCriteria().andDaifaWorkerIdIn(longList);
//            List<DaifaWorker> workerList = daifaWorkerMapper.selectFieldsByExample(workerExample, FieldUtil.codeFields("daifa_worker_id,user_Name"));
//            Map<Long, String> workerMap = workerList.stream().collect(Collectors.toMap(DaifaWorker::getDaifaWorkerId, DaifaWorker::getUserName));
//            for (DaifaGgoodsTasks tasks : tasksList) {
//                GoodsTasksVo tasksVo = new GoodsTasksVo();
//                tasksVo.setTasksId(tasks.getTasksId());
//                tasksVo.setDaifaWorkerId(tasks.getDaifaWorkerId() != null ? tasks.getDaifaWorkerId() : null);
//                String allTime = DateUtil.dateToString(tasks.getAllocatTime(), "yyyy-MM-dd HH:mm:ss");
//                tasksVo.setAllocatTime(allTime != null ? allTime : null);
//                tasksVo.setUserName(workerMap.get(tasks.getDaifaWorkerId()));
//                goodsTasksVo.add(tasksVo);//taskId ,分配时间，拿货人id ,姓名
//            }
//            moveVo.setGoodsTasksVoList(goodsTasksVo);
//
//            DaifaWaitSendOrder daifaWaitSendOrder = new DaifaWaitSendOrder();
//            daifaWaitSendOrder.setDfOrderId(dfOrderId);
//            daifaWaitSendOrder = daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
//
//            moveVo.setSendStatus(daifaWaitSendOrder.getSendStatus());//订单发货状态
//            moveVo.setSendTime(DateUtil.dateToString(daifaWaitSendOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));//订单代发货日期
//
//            DaifaAfterSaleSub daifaAfterSaleSub = new DaifaAfterSaleSub();
//            daifaAfterSaleSub.setDfOrderId(dfOrderId);
//            daifaAfterSaleSub = daifaAfterSaleSubMapper.selectOne(daifaAfterSaleSub);
//            moveVo.setRefundId(daifaAfterSaleSub.getRefundId());
//
//            DaifaStock daifaStock = new DaifaStock();
//            daifaStock.setDfOrderId(dfOrderId);
//            daifaStock = daifaStockMapper.selectOne(daifaStock);
//            DaifaStockRecordExample recordExample = new DaifaStockRecordExample();
//            recordExample.createCriteria().andStockIdEqualTo(daifaStock.getStockId());
//            recordExample.setOrderByClause("stock_record_id asc");
//            List<DaifaStockRecord> recordList = daifaStockRecordMapper.selectByExample(recordExample);
//
//            moveVo.setRecordList(recordList);//出入库记录
//
//            DaifaAfterMoneyConsultExample consultExample = new DaifaAfterMoneyConsultExample();
//            consultExample.createCriteria().andRefundIdEqualTo(moveVo.getRefundId());
//            List<DaifaAfterMoneyConsult> consultList = daifaAfterMoneyConsultMapper.selectByExample(consultExample);
//
//            moveVo.setConsultList(consultList);
//        }
//        return moveVo;
//    }


}
