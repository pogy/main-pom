package com.shigu.main4.daifa.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaWaitSendOrderExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.bo.SubOrderModelBO;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.utils.CdkeyUtil;
import com.shigu.main4.daifa.utils.MQUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;


/**
 * 子单
 * 多例,描述了一个子单的所有变化
 * 有直接构建子单与按子单ID构建两种
 * Created by zhaohongbo on 17/8/9.
 */
@Repository
@Scope("prototype")
public class SubOrderModelImpl implements SubOrderModel {
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaWaitSendMapper daifaWaitSendMapper;
    @Autowired
    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    private MQUtil mqUtil;
    private SubOrderModelBO subOrderBO;

    private Long subOrderId;

    public SubOrderModelImpl(SubOrderModelBO subOrderBO){
        super();
        this.subOrderBO=subOrderBO;
    }
    public SubOrderModelImpl(Long subOrderId){
        super();
        this.subOrderId=subOrderId;
    }
    @PostConstruct
    private void insert(){
        if(this.subOrderBO!=null){
            init();
        }
    }


    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    @Override
    public void init() {
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andGoodsIdEqualTo(subOrderBO.getGoodsId());
        daifaOrderExample.setStartIndex(0);
        daifaOrderExample.setEndIndex(1);
        daifaOrderExample.setOrderByClause("create_time desc");
        List<DaifaOrder> tmpOs=daifaOrderMapper.selectByExample(daifaOrderExample);
        if(tmpOs.size()>0){
            subOrderBO.setStoreGoodsCode(tmpOs.get(0).getStoreGoodsCode());
            subOrderBO.setGoodsCode(tmpOs.get(0).getGoodsCode());
        }

        DaifaOrder order=BeanMapper.map(subOrderBO,DaifaOrder.class);
        order.setCreateTime(new Date());
        order.setLastDoTime(order.getCreateTime());
        order.setDelistIs(0);
        order.setCdkey(cdkeyCreate());
        order.setAllocatStatus(0);
        order.setRefundStatus(0);
        daifaOrderMapper.insertSelective(order);
        this.subOrderId=order.getDfOrderId();
        DaifaGgoodsTasks insertTasks=BeanMapper.map(order,DaifaGgoodsTasks.class);
        insertTasks.setTakeGoodsDate(null);//重置分配时间
        insertTasks.setTakeGoodsStatus(0);//重置分配状态
        insertTasks.setTasksId(null);//清空id
        insertTasks.setOperateIs(0);//重置操作状态
        insertTasks.setAllocatStatus(0);
        insertTasks.setUseStatus(1);//设置数据有效
        insertTasks.setCreateDate(DateUtil.dateToString(order.getCreateTime(),DateUtil.patternB));
        insertTasks.setDaifaWorker(null);
        insertTasks.setDaifaWorkerId(null);
        insertTasks.setAllocatDate(null);
        insertTasks.setAllocatTime(null);
        insertTasks.setEndStatus(0);//设置待截单
        insertTasks.setGgoodsCode(null);//重置分配批号
        insertTasks.setPrintBarcodeStatus(1);//重置导出状态
        insertTasks.setPrintBatch(null);
        insertTasks.setPrintGoodsStatus(1);//重置打印状态
        insertTasks.setReturnStatus(0);
        insertTasks.setWebSite(subOrderBO.getWebSite());
        insertTasks.setSellerId(subOrderBO.getSellerId());
        daifaGgoodsTasksMapper.insertSelective(insertTasks);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void haveGoodsTime(Date time){
        DaifaOrder order=new DaifaOrder();
        order.setDfOrderId(subOrderId);
        order.setHaveGoodsDate(time);
        daifaOrderMapper.updateByPrimaryKeySelective(order);
        DaifaGgoodsTasks tasks=new DaifaGgoodsTasks();
        tasks.setYouhuoDate(time);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsTasksMapper.updateByExampleSelective(tasks,daifaGgoodsTasksExample);
        DaifaGgoods ggoods=new DaifaGgoods();
        ggoods.setYouhuoDate(time);
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsMapper.updateByExampleSelective(ggoods,daifaGgoodsExample);

        order=daifaOrderMapper.selectByPrimaryKey(subOrderId);
        JSONObject jsonObject=new JSONObject();
        Map<String,Object> map=new HashMap<>();
        map.put("psoid",order.getOrderPartitionId());
        map.put("day", DateUtil.dateToString(time,DateUtil.patternA));
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.haveDate.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.haveDate.getMessageKey()+order.getOrderPartitionId(),
                DaifaSendMqEnum.haveDate.getMessageTag(), jsonObject.toString());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void markDown(){
        DaifaOrder order=new DaifaOrder();
        order.setDfOrderId(subOrderId);
        order.setDelistIs(1);
        daifaOrderMapper.updateByPrimaryKeySelective(order);
        DaifaGgoodsTasks tasks=new DaifaGgoodsTasks();
        tasks.setDelistIs(1);
        tasks.setUseStatus(0);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsTasksMapper.updateByExampleSelective(tasks,daifaGgoodsTasksExample);
        DaifaGgoods ggoods=new DaifaGgoods();
        ggoods.setDelistIs(1);
        ggoods.setUseStatus(0);
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsMapper.updateByExampleSelective(ggoods,daifaGgoodsExample);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void mark(String context) throws DaifaException {
        DaifaOrder order=daifaOrderMapper.selectByPrimaryKey(subOrderId);
        if(order==null){
            throw new DaifaException("子订单不存在",DaifaException.DEBUG);
        }
        DaifaOrder updateOrder=new DaifaOrder();
        updateOrder.setDfOrderId(subOrderId);
        String remark=order.getOrderRemark();
        if(remark==null){
            remark=context;
        }else{
            remark+="\n"+context;
        }
        updateOrder.setOrderRemark(remark);
        daifaOrderMapper.updateByPrimaryKeySelective(updateOrder);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void haveTake() throws DaifaException {
        take(1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void noTake() throws DaifaException {
        take(2);
    }

    @Override
    public String cdkeyCreate() {
        return CdkeyUtil.getkey();
    }

    private void take(int status) throws DaifaException {
        Date time=new Date();
        String date=DateUtil.dateToString(time,DateUtil.patternB);
        DaifaGgoods goods=new DaifaGgoods();
        goods.setCreateDate(status==1?date:null);
        goods.setDfOrderId(subOrderId);
        goods.setUseStatus(1);
        goods.setOperateIs(0);
        try {
            goods=daifaGgoodsMapper.selectOne(goods);
        } catch (Exception e) {
            goods=null;
        }
        if(goods==null){
            throw new DaifaException("已分配表未匹配到数据,或匹配到多条",DaifaException.DEBUG);
        }
        DaifaGgoodsTasks task=new DaifaGgoodsTasks();
        task.setDfOrderId(subOrderId);
        task.setAllocatStatus(1);
        task.setOperateIs(0);
        task.setAllocatDate(status==1?date:null);
        try {
            task=daifaGgoodsTasksMapper.selectOne(task);
        } catch (Exception e) {
            task=null;
        }
        if(task==null){
            throw new DaifaException("待分配表未匹配到数据,或匹配到多条",DaifaException.DEBUG);
        }
        if(task.getEndStatus()==1){
            throw new DaifaException("订单已截单",DaifaException.DEBUG);
        }
        if(task.getReturnStatus()==2){
            throw new DaifaException("订单已退款",DaifaException.DEBUG);
        }



        //查询未发表是否存在
        DaifaWaitSend daifaWaitSend=new DaifaWaitSend();
        daifaWaitSend.setDfTradeId(task.getDfTradeId());
        daifaWaitSend=daifaWaitSendMapper.selectOne(daifaWaitSend);
        if(daifaWaitSend==null){
            if(status==1){
                DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
                daifaGgoodsExample.createCriteria().andDfTradeIdEqualTo(task.getDfTradeId());
                daifaGgoodsExample.setOrderByClause("create_time asc");
                List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(daifaGgoodsExample, FieldUtil.codeFields("df_order_id,goods_num,take_goods_id,take_goods_status"));
                Map<Long,DaifaGgoods> gmap=BeanMapper.list2Map(gs,"dfOrderId",Long.class);

                DaifaTrade trade=daifaTradeMapper.selectByPrimaryKey(task.getDfTradeId());
                DaifaWaitSend insertWait=BeanMapper.map(trade,DaifaWaitSend.class);
                insertWait.setCreateDate(date);
                insertWait.setCreateTime(time);
                daifaWaitSendMapper.insertSelective(insertWait);
                DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
                daifaOrderExample.createCriteria().andDfTradeIdEqualTo(task.getDfTradeId());
                List<DaifaOrder> orders=daifaOrderMapper.selectByExample(daifaOrderExample);
                List<DaifaWaitSendOrder> wos=new ArrayList<>();
                for(DaifaOrder o:orders){
                    DaifaWaitSendOrder wo=BeanMapper.map(o,DaifaWaitSendOrder.class);
                    wo.setCreateDate(date);
                    wo.setCreateTime(time);
                    wo.setDwsId(insertWait.getDwsId());
                    wo.setInStockFlag(0);//入库状态默认
                    wo.setHasNum(o.getDfOrderId().longValue() == subOrderId ?task.getGoodsNum():0);//设置已拿到数量
                    wo.setDaifaWorkerId(task.getDaifaWorkerId());
                    wo.setDaifaWorker(task.getDaifaWorker());
                    wo.setSendStatus(1);//设置待发货
                    int takeGoodsStatus=0;
                    if(o.getDfOrderId().longValue()==subOrderId){
                        takeGoodsStatus=status;
                    }else {
                        DaifaGgoods g=gmap.get(o.getDfOrderId());
                        if(g!=null){
                            takeGoodsStatus=g.getTakeGoodsStatus();
                        }
                    }
                    wo.setTakeGoodsStatus(takeGoodsStatus);
                    wo.setSellerId(task.getSellerId());
                    wo.setWebSite(task.getWebSite());
                    wos.add(wo);
                }
                daifaWaitSendOrderMapper.insertListNoId(wos);
            }
        }else{
            DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
            daifaWaitSendOrder.setDfOrderId(subOrderId);
            daifaWaitSendOrder=daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
            DaifaWaitSendOrder updateWaitSendOrder=new DaifaWaitSendOrder();
            updateWaitSendOrder.setDwsoId(daifaWaitSendOrder.getDwsoId());
            updateWaitSendOrder.setTakeGoodsStatus(status);//设置拿货状态
            updateWaitSendOrder.setHasNum(status==1?task.getGoodsNum():0);//设置已拿到数量
            updateWaitSendOrder.setGgoodsCode(status==1?task.getGgoodsCode():null);
            daifaWaitSendOrderMapper.updateByPrimaryKeySelective(updateWaitSendOrder);
        }

        DaifaGgoods updateGgoods=new DaifaGgoods();
        updateGgoods.setUseStatus(0);//设置记录不可用
        updateGgoods.setOperateIs(1);//设置已操作过拿货完成
        updateGgoods.setTakeGoodsId(goods.getTakeGoodsId());
        updateGgoods.setTakeGoodsStatus(status);//设置拿货状态

        DaifaGgoodsTasks updateTask=new DaifaGgoodsTasks();
        updateTask.setTasksId(task.getTasksId());
        updateTask.setOperateIs(1);//设置已操作过拿货完成
        updateTask.setUseStatus(0);
        updateTask.setTakeGoodsStatus(status);//设置拿货状态



        DaifaOrder order=new DaifaOrder();
        order.setDfOrderId(subOrderId);
        order.setTakeGoodsStatus(status);//设置拿货状态
        if(status==2){
            DaifaOrder tmpOrder=daifaOrderMapper.selectFieldsByPrimaryKey(subOrderId, FieldUtil.codeFields("df_order_id,create_time"));
            Integer day1=new Integer(DateUtil.dateToString(tmpOrder.getCreateTime(),DateUtil.patternB));
            Integer day2=new Integer(date);
            order.setStockoutCycleStatus(day1-day2>1?2:1);

            DaifaGgoodsTasks insertTasks=BeanMapper.map(task,DaifaGgoodsTasks.class);
            insertTasks.setTakeGoodsStatus(2);//设置缺货
            insertTasks.setTasksId(null);//清空id
            insertTasks.setOperateIs(0);//重置操作状态
            insertTasks.setAllocatStatus(0);//重置分配状态
            insertTasks.setUseStatus(1);//设置数据有效
            insertTasks.setCreateDate(date);
            insertTasks.setCreateTime(time);
            insertTasks.setDaifaWorker(null);
            insertTasks.setDaifaWorkerId(null);
            insertTasks.setAllocatDate(null);
            insertTasks.setAllocatTime(null);
            insertTasks.setEndStatus(0);//设置待截单
            insertTasks.setGgoodsCode(null);//重置分配批号
            insertTasks.setPrintBarcodeStatus(1);//重置导出状态
            insertTasks.setPrintBatch(null);
            insertTasks.setPrintGoodsStatus(1);//重置打印状态
            daifaGgoodsTasksMapper.insertSelective(insertTasks);
        }else{
            updateGgoods.setTakeGoodsDate(date);
            updateGgoods.setTakeGoodsTime(time);
            updateTask.setTakeGoodsDate(date);
            order.setTakeGoodsDate(time);
        }

        daifaGgoodsMapper.updateByPrimaryKeySelective(updateGgoods);
        daifaGgoodsTasksMapper.updateByPrimaryKeySelective(updateTask);
        daifaOrderMapper.updateByPrimaryKeySelective(order);
    }
}
