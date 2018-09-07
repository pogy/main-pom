package com.shigu.main4.daifa.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.enums.DaifaListDealTypeEnum;
import com.shigu.main4.daifa.enums.TakeGoodsEnum;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.utils.DaifaListDealUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pc on 2017-08-09.
 * 拿货模实现
 *
 * @author lys
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Repository
@Scope("prototype")
public class CargoManImpl implements CargoManModel {
    public static Lock takeLock = new ReentrantLock();
    private Long cargoManId;//拿货源Id
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    private DaifaWorkerMapper daifaWorkerMapper;
    private DaifaGgoodsMapper daifaGgoodsMapper;
    private DaifaOrderMapper daifaOrderMapper;
    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    private DaifaTradeMapper daifaTradeMapper;
    private DaifaWaitSendMapper daifaWaitSendMapper;
    private DaifaListDealUtil daifaListDealUtil;

    public CargoManImpl(Long cargoManId) {
        super();
        this.cargoManId = cargoManId;
    }

    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    @Autowired
    public void setDaifaWorkerMapper(DaifaWorkerMapper daifaWorkerMapper) {
        this.daifaWorkerMapper = daifaWorkerMapper;
    }

    @Autowired
    public void setDaifaGgoodsMapper(DaifaGgoodsMapper daifaGgoodsMapper) {
        this.daifaGgoodsMapper = daifaGgoodsMapper;
    }

    @Autowired
    public void setDaifaOrderMapper(DaifaOrderMapper daifaOrderMapper) {
        this.daifaOrderMapper = daifaOrderMapper;
    }

    @Autowired
    public void setDaifaWaitSendOrderMapper(DaifaWaitSendOrderMapper daifaWaitSendOrderMapper) {
        this.daifaWaitSendOrderMapper = daifaWaitSendOrderMapper;
    }

    @Autowired
    public void setDaifaTradeMapper(DaifaTradeMapper daifaTradeMapper) {
        this.daifaTradeMapper = daifaTradeMapper;
    }

    @Autowired
    public void setDaifaWaitSendMapper(DaifaWaitSendMapper daifaWaitSendMapper) {
        this.daifaWaitSendMapper = daifaWaitSendMapper;
    }

    @Autowired
    public void setDaifaListDealUtil(DaifaListDealUtil daifaListDealUtil) {
        this.daifaListDealUtil = daifaListDealUtil;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String takeToMe(List<Long> waitIssueIds) throws DaifaException {
        //查询出待分配任务
        if (waitIssueIds == null || waitIssueIds.isEmpty()) {
            throw new DaifaException("待分配Id为空",DaifaException.DEBUG);
        }
        //查询拿货人
        DaifaWorker daifaWorker = daifaWorkerMapper.selectFieldsByPrimaryKey(this.cargoManId
                , FieldUtil.codeFields("daifa_worker_id,daifa_worker,daifa_seller_id"));
        if (daifaWorker == null) {
            throw new DaifaException("系统无此拿货人",DaifaException.DEBUG);
        }
        Date theTime=new Date();
        String theDay=DateUtil.dateToString(theTime, DateUtil.patternB);

        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andSellerIdEqualTo(daifaWorker.getDaifaSellerId())
                .andAllocatStatusEqualTo(1).andTakeGoodsStatusEqualTo(0).andAllocatDateLessThan(theDay);
        if(daifaGgoodsTasksMapper.countByExample(daifaGgoodsTasksExample)!=0){
            throw new DaifaException("存在今天之前分配的拿货中的数据,禁止分配",DaifaException.DEBUG);
        }
        try {
            takeLock.lock();
            //拿货拿货code
            String code = daifaListDealUtil.queryListCode(DaifaListDealTypeEnum.GGOODS_CODE
                    , daifaWorker.getDaifaSellerId(), this.cargoManId);


            DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
            dgtex.createCriteria().andTasksIdIn(waitIssueIds)
                    .andAllocatStatusEqualTo(0)//未分配
                    .andUseStatusEqualTo(1)//可用的
                    .andReturnStatusEqualTo(0)//未处于退款流程
                    .andEndStatusEqualTo(0);//未结算
            List<DaifaGgoodsTasks> daifaGgoodsTasks = daifaGgoodsTasksMapper.selectByExample(dgtex);
            List<DaifaGgoods> ggoodsList = new ArrayList<>();
            List<Long> orderIds=new ArrayList<>();
            for (DaifaGgoodsTasks tasks : daifaGgoodsTasks) {
                DaifaGgoods ggoods = new DaifaGgoods();
                BeanUtils.copyProperties(tasks, ggoods);
                ggoodsList.add(ggoods);
                tasks.setAllocatStatus(1);//已分配
                tasks.setAllocatTime(theTime);
                tasks.setOperateIs(0);//未操作拿货完成
                tasks.setUseStatus(0);
                tasks.setGgoodsCode(code);
                tasks.setAllocatDate(theDay);
                tasks.setDaifaWorkerId(daifaWorker.getDaifaWorkerId());
                tasks.setDaifaWorker(daifaWorker.getDaifaWorker());
                ggoods.setCreateTime(theTime);
                ggoods.setCreateDate(theDay);
                ggoods.setDaifaWorkerId(cargoManId);
                ggoods.setDaifaWorker(daifaWorker.getDaifaWorker());
                ggoods.setGgoodsCode(code);
                ggoods.setUseStatus(1);
                ggoods.setOperateIs(0);
                ggoods.setTakeGoodsStatus(0);
                ggoods.setTakeGoodsTime(null);
                ggoods.setTakeGoodsDate(null);
                ggoods.setDaifaWorkerId(daifaWorker.getDaifaWorkerId());
                ggoods.setDaifaWorker(daifaWorker.getDaifaWorker());
                //修改任务表
                daifaGgoodsTasksMapper.updateByPrimaryKeySelective(tasks);
                //修改子订单表状态
                orderIds.add(tasks.getDfOrderId());
                DaifaOrder order = new DaifaOrder();
                order.setDfOrderId(tasks.getDfOrderId());
                order.setOrderStatus(2);
                order.setAllocatStatus(1);
                daifaOrderMapper.updateByPrimaryKeySelective(order);
            }
            if(orderIds.size()>0){
                DaifaOrder order = new DaifaOrder();
                order.setOrderStatus(2);
                order.setAllocatStatus(1);
                DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
                daifaOrderExample.createCriteria().andDfOrderIdIn(orderIds);
                daifaOrderMapper.updateByExampleSelective(order,daifaOrderExample);
            }

            //写入已分配表
            if (ggoodsList.size() != 0) {
                daifaGgoodsMapper.insertListNoId(ggoodsList);
                return code;
            }
        }finally {
            takeLock.unlock();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void finishTakeGoods() throws DaifaException {
        //查询出该处理的s

        DaifaWorker daifaWorker = daifaWorkerMapper.selectFieldsByPrimaryKey(this.cargoManId
                , FieldUtil.codeFields("daifa_worker_id,daifa_worker,daifa_seller_id"));
        if (daifaWorker == null) {
            throw new DaifaException("系统无此拿货人",DaifaException.DEBUG);
        }
        DaifaGgoodsExample dggex = new DaifaGgoodsExample();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String datestr = format.format(new Date());
        dggex.createCriteria().andDaifaWorkerIdEqualTo(this.cargoManId).
                andCreateDateEqualTo(datestr).andUseStatusEqualTo(1).andSellerIdEqualTo(daifaWorker.getDaifaSellerId());
        List<DaifaGgoods> gglist = daifaGgoodsMapper.selectByExample(dggex);
        //状态修改s
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        DaifaWaitSendOrderExample dfwsoex = new DaifaWaitSendOrderExample();
        fo:for (DaifaGgoods ddgoods : gglist) {
            ddgoods.setUseStatus(0);//变成不可用了
            ddgoods.setOperateIs(1);
            if (!Objects.equals(ddgoods.getTakeGoodsStatus(), TakeGoodsEnum.HAS_TAKE.getValue())) {//未拿到货的
                ddgoods.setTakeGoodsStatus(TakeGoodsEnum.NO_GOODS.getValue());//缺货的
                DaifaOrder order = daifaOrderMapper.selectFieldsByPrimaryKey(ddgoods.getDfOrderId()
                        , FieldUtil.codeFields("DF_ORDER_ID,df_trade_id,allocat_status,order_code"));
                order.setTakeGoodsStatus(TakeGoodsEnum.NO_GOODS.getValue());
                //修改已分配任务为操作过拿货完成s
                dgtex.clear();
                dgtex.createCriteria().andDaifaWorkerIdEqualTo(ddgoods.getDaifaWorkerId())
                        .andDfOrderIdEqualTo(ddgoods.getDfOrderId()).andAllocatStatusEqualTo(1).andUseStatusEqualTo(0)
                        .andOperateIsEqualTo(0);
                DaifaGgoodsTasks dgtt = new DaifaGgoodsTasks();
                dgtt.setAllocatStatus(1);//设置为已分配
                dgtt.setOperateIs(1);
                daifaGgoodsTasksMapper.updateByExampleSelective(dgtt, dgtex);
                //修改已分配任务为操作过拿货完成e
                //如果已进入代发货则修改代发货状态s
                dfwsoex.clear();
                dfwsoex.createCriteria().andDfOrderIdEqualTo(ddgoods.getDfOrderId());
                List<DaifaWaitSendOrder> listsn = daifaWaitSendOrderMapper.selectFieldsByExample(dfwsoex, FieldUtil.codeFields("dwso_id,take_goods_status"));
                if (listsn.size() > 0) {
                    DaifaWaitSendOrder ooo = listsn.get(0);
                    ooo.setTakeGoodsStatus(TakeGoodsEnum.NO_GOODS.getValue());//设置为缺货
                    daifaWaitSendOrderMapper.updateByPrimaryKeySelective(ooo);
                }
                //如果已进入代发货则修改代发货状态e

                DaifaGgoodsTasks tasks = new DaifaGgoodsTasks();
                BeanUtils.copyProperties(ddgoods, tasks);
                tasks.setGoodsNum(ddgoods.getGoodsNum());
                tasks.setDfTradeId(order.getDfTradeId());
                tasks.setAllocatStatus(0);
                tasks.setUseStatus(1);
                tasks.setDaifaWorkerId(null);
                tasks.setDaifaWorker(null);
                tasks.setCreateTime(new Date());
                tasks.setPrintGoodsStatus(1);
                tasks.setOperateIs(0);
                tasks.setTakeGoodsStatus(2);
                tasks.setCreateDate(DateUtil.dateToString(tasks.getCreateTime(), DateUtil.patternB));
                daifaGgoodsTasksMapper.insertSelective(tasks);//插入任务表
                daifaGgoodsMapper.updateByPrimaryKeySelective(ddgoods);//更新拿货表
                daifaOrderMapper.updateByPrimaryKeySelective(order);//更新order表

            } else {
                ddgoods.setTakeGoodsStatus(TakeGoodsEnum.HAS_TAKE.getValue());//拿到货
                DaifaOrder order = daifaOrderMapper.selectFieldsByPrimaryKey(ddgoods.getDfOrderId()
                        , FieldUtil.codeFields("DF_ORDER_ID,df_trade_id,allocat_status"));
                //修改daifaorder 的有货状态
                order.setTakeGoodsStatus(TakeGoodsEnum.HAS_TAKE.getValue());
                DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(order.getDfTradeId());
                DaifaOrderExample doex = new DaifaOrderExample();
                doex.createCriteria().andDfTradeIdEqualTo(trade.getDfTradeId());
                List<DaifaOrder> orderList = daifaOrderMapper.selectByExample(doex);

                //先查询待发表是否存在s
                DaifaWaitSendExample dwex = new DaifaWaitSendExample();
                dwex.createCriteria().andDfTradeIdEqualTo(trade.getDfTradeId());
                List<DaifaWaitSend> sends = daifaWaitSendMapper.selectByExample(dwex);
                DaifaWaitSendOrderExample dwsoex = new DaifaWaitSendOrderExample();
                dwsoex.createCriteria().andDfOrderIdEqualTo(order.getDfOrderId());
                List<DaifaWaitSendOrder> sendOrders = daifaWaitSendOrderMapper.selectByExample(dwsoex);
                //修改已分配任务为操作过拿货完成s
                dgtex.clear();
                dgtex.createCriteria().andDaifaWorkerIdEqualTo(ddgoods.getDaifaWorkerId())
                        .andDfOrderIdEqualTo(ddgoods.getDfOrderId()).andAllocatStatusEqualTo(1).andUseStatusEqualTo(0)
                        .andOperateIsEqualTo(0);
                com.opentae.data.daifa.beans.DaifaGgoodsTasks dgtt = new com.opentae.data.daifa.beans.DaifaGgoodsTasks();
                dgtt.setAllocatStatus(1);//已分配
                dgtt.setOperateIs(1);//操作过拿货完成
                //修改已分配任务为操作过拿货完成e
                if (sends.size() == 0) { //如果不存在插入数据 插入数据插入的数据包裹daifawaitsend 和daifawaitsendorder
                    DaifaWaitSend sendt = new DaifaWaitSend();
                    BeanUtils.copyProperties(trade, sendt);
                    sendt.setCreateTime(new Date());
                    sendt.setCreateDate(DateUtil.dateToString(sendt.getCreateTime(), DateUtil.patternB));
                    sendt.setSendStatus(1);//待发状态
                    sendt.setSendDate(null);
                    sendt.setSendTime(null);
                    daifaWaitSendMapper.insertSelective(sendt);

                    for (DaifaOrder order1 : orderList) {
                        DaifaWaitSendOrder sendo = new DaifaWaitSendOrder();
                        BeanUtils.copyProperties(order1, sendo);
                        sendo.setSellerId(trade.getSellerId());
                        sendo.setDwsId(sendt.getDwsId());
                        sendo.setCreateTime(new Date());
                        sendo.setCreateDate(DateUtil.dateToString(sendo.getCreateTime(), DateUtil.patternB));
                        sendo.setSendStatus(1);//未发
                        sendo.setInStockFlag(0);
                        sendo.setDaifaWorkerId(ddgoods.getDaifaWorkerId());
                        sendo.setDaifaWorker(ddgoods.getDaifaWorker());
                        sendo.setOrderCode(order1.getOrderCode());
                        if (ddgoods.getDfOrderId() == order1.getDfOrderId().longValue()) {
                            sendo.setTakeGoodsStatus(TakeGoodsEnum.HAS_TAKE.getValue());//有货
                            sendo.setGgoodsCode(ddgoods.getGgoodsCode());
                        } else if (order1.getTakeGoodsStatus() != null && order1.getTakeGoodsStatus() == 2) {
                            sendo.setTakeGoodsStatus(TakeGoodsEnum.NO_GOODS.getValue());//缺货
                        } else {
                            sendo.setTakeGoodsStatus(TakeGoodsEnum.DEFAULT.getValue());
                        }
                        daifaWaitSendOrderMapper.insertSelective(sendo);
                    }
                } else {
                    DaifaWaitSendOrder sendorder = sendOrders.get(0);
                    sendorder.setGgoodsCode(ddgoods.getGgoodsCode());
                    sendorder.setTakeGoodsStatus(TakeGoodsEnum.HAS_TAKE.getValue());
                    sendorder.setGoodsNum(ddgoods.getGoodsNum());
                    daifaWaitSendOrderMapper.updateByPrimaryKeySelective(sendorder);
                }
                daifaGgoodsTasksMapper.updateByExampleSelective(dgtt, dgtex);
                daifaOrderMapper.updateByPrimaryKeySelective(order);
            }
            daifaGgoodsMapper.updateByPrimaryKeySelective(ddgoods);//更新拿货表
        }
    }

    public Long getCargoManId() {
        return cargoManId;
    }

    public void setCargoManId(Long cargoManId) {
        this.cargoManId = cargoManId;
    }
}
