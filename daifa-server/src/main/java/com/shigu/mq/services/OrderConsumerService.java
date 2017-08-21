package com.shigu.mq.services;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.mq.beans.RefundBean;
import com.shigu.mq.beans.ResponseBasic;
import org.springframework.beans.factory.annotation.Autowired;
import com.shigu.mq.beans.SubRefundBean;
import com.shigu.mq.receives.SendMessageListener;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-08-17.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class OrderConsumerService {
    @Autowired
    SendMessageListener sendMessageListener;

    private OrderManageProcess orderManageProcess;
    @Autowired
    public void setOrderManageProcess(OrderManageProcess orderManageProcess) {
        this.orderManageProcess = orderManageProcess;
    }

    public void orderConvertTrade(String body) throws UnsupportedEncodingException {
        ResponseBasic res= JSON.parseObject(body,ResponseBasic.class);
        if(res.isStatus()){
            synchronized (this) {
                OrderBO orderBean = JSON.parseObject(res.getData().toString(),OrderBO.class);
               // System.out.println (orderBean);
                orderManageProcess.newOrder(orderBean);
            }
        }
    }
    public void refund(String body) throws UnsupportedEncodingException {
        ResponseBasic res= JSON.parseObject(body,ResponseBasic.class);
        if(res.isStatus()){
            RefundBean refund= JSON.parseObject(JSON.toJSONString(res.getData()),RefundBean.class);
           // RefundBean refund=JSON.parseObject(res.getData().toString(),RefundBean.class);
            if(refund.getSuborders()==null||refund.getSuborders().size ()==0){
                return;
            }
            try {
                //=============事物start=================
                List<String> soidps=new ArrayList<>();
                List<String> soids=new ArrayList<>();
                for(SubRefundBean srb:refund.getSuborders()){
                    soids.add(srb.getSoid());
                    soidps.addAll(srb.getSoidps());
                }
                orderManageProcess.autoRefund(refund.getRefundId(),soids,soidps);
                //=============事物end=================
            } catch (Exception e) {
                JSONObject obj=new JSONObject();
                if(e instanceof DaifaException){
                    obj.put("msg",e.getMessage());
                }else{
                    obj.put("msg","内部错误");
                }
                obj.put("status",false);
                sendMessageListener.sendMessage("refund_"+refund.getRefundId(),
                        "refund_agree",
                        obj.toString());
            }
        }
    }
}
