package com.shigu.main4.daifa.utils;

import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.process.impl.PackDeliveryProcessImpl;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;

import java.util.List;

public class DoQueryExpressCodeTask implements Runnable{
    private PackDeliveryProcess packDeliveryProcess;
    private RedisIO redisIO;
    private DaifaTradeMapper daifaTradeMapper;

    DoQueryExpressCodeTask(PackDeliveryProcess packDeliveryProcess, RedisIO redisIO, DaifaTradeMapper daifaTradeMapper) {
        this.packDeliveryProcess = packDeliveryProcess;
        this.redisIO = redisIO;
        this.daifaTradeMapper = daifaTradeMapper;
    }

    @Override
    public void run() {
        String tidString;
        while ((tidString = redisIO.rpop("QueryExpressCodeThread", String.class))!=null){
            start(tidString);
        }
    }
    private void start(String tidString){
        Long tid;
        try {
            tid=new Long(tidString);
        } catch (Exception e) {
            return;
        }
        DaifaTrade trade=daifaTradeMapper.selectByPrimaryKey(tid);
        if(trade==null||trade.getSendStatus()==2){
            return;
        }
        List<SubOrderExpressBO> list;
        try {
            list = packDeliveryProcess.cheackeSend(tid);
        } catch (DaifaException e) {
            return;
        }
        OrderExpressBO exbo=new OrderExpressBO();
        exbo.setExpressName(trade.getExpressName());
        exbo.setReceiverAddress(trade.getReceiverAddress());
        exbo.setReceiverName(trade.getReceiverName());
        exbo.setReceiverPhone(trade.getReceiverMobile()==null?trade.getReceiverPhone():trade.getReceiverMobile());
        exbo.setTid(trade.getDfTradeId());
        exbo.setList(list);
        ExpressModel expressModel= SpringBeanFactory.getBean(ExpressModel.class,trade.getExpressId(),trade.getSellerId());
        try {
            expressModel.callExpress(exbo);
        } catch (DaifaException ignored) {
        }
    }
}
