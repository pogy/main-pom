package com.shigu.test;

import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RefundBody {
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    DaifaSendOrderMapper daifaSendOrderMapper;
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void v(List<Long> dfOrderIds, Long tid, Long refundId){
        Date time=new Date();
        String date= DateUtil.dateToString(time,DateUtil.patternB);
        for(Long dfOrderId:dfOrderIds){
            DaifaOrder uorder=new DaifaOrder();
            uorder.setDfOrderId(dfOrderId);
            uorder.setTakeGoodsStatus(2);//设置拿货状态
            uorder.setStockoutCycleStatus(1);
            daifaOrderMapper.updateByPrimaryKeySelective(uorder);

            DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
            daifaGgoodsTasksExample.setOrderByClause("tasks_id asc");
            List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.selectByExample(daifaGgoodsTasksExample);
            if(ts.size()==0){
                continue;
            }
            DaifaGgoodsTasks updateTask=new DaifaGgoodsTasks();
            updateTask.setOperateIs(1);//设置已操作过拿货完成
            updateTask.setUseStatus(0);
            updateTask.setTakeGoodsStatus(2);//设置拿货状态
            daifaGgoodsTasksMapper.updateByExampleSelective(updateTask,daifaGgoodsTasksExample);

            DaifaGgoodsTasks t=ts.get(0);
            if(t.getTakeGoodsStatus()==1){
                DaifaGgoodsTasks insertTasks= BeanMapper.map(t,DaifaGgoodsTasks.class);
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

                DaifaGgoods updateGgoods=new DaifaGgoods();
                updateGgoods.setUseStatus(0);//设置记录不可用
                updateGgoods.setOperateIs(1);//设置已操作过拿货完成
                updateGgoods.setTakeGoodsStatus(2);//设置拿货状态
                DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
                daifaGgoodsExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
                daifaGgoodsMapper.updateByExampleSelective(updateGgoods,daifaGgoodsExample);

                DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
                daifaWaitSendOrder.setDfOrderId(dfOrderId);
                daifaWaitSendOrder=daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
                if(daifaWaitSendOrder!=null){
                    DaifaWaitSendOrder updateWaitSendOrder=new DaifaWaitSendOrder();
                    updateWaitSendOrder.setDwsoId(daifaWaitSendOrder.getDwsoId());
                    updateWaitSendOrder.setTakeGoodsStatus(2);//设置拿货状态
                    updateWaitSendOrder.setHasNum(0);//设置已拿到数量
                    daifaWaitSendOrderMapper.updateByPrimaryKeySelective(updateWaitSendOrder);
                }

                DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
                daifaSendOrder.setDfOrderId(dfOrderId);
                daifaSendOrder=daifaSendOrderMapper.selectOne(daifaSendOrder);
                if(daifaSendOrder!=null){
                    DaifaSendOrder updateSendOrder=new DaifaSendOrder();
                    updateSendOrder.setSendoId(daifaSendOrder.getSendoId());
                    updateSendOrder.setTakeGoodsStatus(2);//设置拿货状态
                    updateSendOrder.setHasNum(0);//设置已拿到数量
                    daifaSendOrderMapper.updateByPrimaryKeySelective(updateSendOrder);
                }
            }
        }
        tui(refundId,dfOrderIds,tid);
    }

    private void tui(Long refundId,List<Long> subOrderIds,Long tid){
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(subOrderIds);
        DaifaOrder daifaOrder=new DaifaOrder();
        daifaOrder.setRefundStatus(2);
        daifaOrder.setRefundId(refundId);
        daifaOrder.setRefundFinishTime(new Date());
        daifaOrderMapper.updateByExampleSelective(daifaOrder,daifaOrderExample);

        //更新已分配表状态为已退款
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoods daifaGgoods =new DaifaGgoods();
        daifaGgoods.setReturnStatus(2);
        daifaGgoods.setUseStatus(0);
        daifaGgoodsMapper.updateByExampleSelective(daifaGgoods,daifaGgoodsExample);

        //更新待分配表状态为已退款
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setReturnStatus(2);
        daifaGgoodsTasks.setUseStatus(0);
        daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTasks,daifaGgoodsTasksExample);

        //更新已发货表状态为已退款
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
        daifaSendOrder.setRefundStatus(2);
        daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder,daifaSendOrderExample);

        //更新待发货表状态为已退款
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(tid).andDfOrderIdIn(subOrderIds);
        DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
        daifaWaitSendOrder.setRefundStatus(2);
        daifaWaitSendOrder.setRefundTime(new Date());
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);
    }
}
