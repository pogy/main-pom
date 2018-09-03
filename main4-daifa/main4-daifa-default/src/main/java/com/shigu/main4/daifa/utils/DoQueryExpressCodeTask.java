package com.shigu.main4.daifa.utils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.daifa.bo.OrderExpressBO;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.ExpressModel;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoQueryExpressCodeTask implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(DoQueryExpressCodeTask.class);
    private PackDeliveryProcess packDeliveryProcess;
    private RedisIO redisIO;
    private DaifaTradeMapper daifaTradeMapper;
    private MQUtil mqUtil;

    DoQueryExpressCodeTask(PackDeliveryProcess packDeliveryProcess, RedisIO redisIO, DaifaTradeMapper daifaTradeMapper,MQUtil mqUtil) {
        this.packDeliveryProcess = packDeliveryProcess;
        this.redisIO = redisIO;
        this.daifaTradeMapper = daifaTradeMapper;
        this.mqUtil = mqUtil;
    }

    @Override
    public void run() {
        String tidString;
        while ((tidString = redisIO.lpop("QueryExpressCodeThread", String.class))!=null){
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
        ExpressVO vo=null;
        try {
            vo = expressModel.callExpress(exbo);
        } catch (Exception e) {
            if(e instanceof DaifaException){
                logger.error(tidString+"尝试获取单号失败,错误信息:"+e.getMessage());
            }else{
                logger.error(tidString+"尝试获取单号失败",e);
            }
        }
        try {
            if (vo != null && vo.getExpressCode() != null){
                Boolean expressNumber = redisIO.get("ORDER_EXPRESS_GETEXPRESSNUMBER", Boolean.class);
                if (expressNumber != null && expressNumber){
                    Map<String,Object> map=new HashMap<>();
                    map.put("orderId",trade.getTradeCode());
                    map.put("expressCode",vo.getExpressCode());
                    JSONObject obj=new JSONObject();
                    obj.put("data",map);
                    obj.put("msg","更新快递单号");
                    obj.put("status",true);
                    mqUtil.sendMessage(DaifaSendMqEnum.updateExpressCode.getMessageKey()+trade.getTradeCode(),
                            DaifaSendMqEnum.updateExpressCode.getMessageTag(), obj.toString());
                }
            }
        } catch (Exception ignored) {
        }

    }
}
