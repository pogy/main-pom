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

import java.util.HashMap;
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

    public void orderConvertTrade(byte[] body) {
        ResponseBasic res= JSON.parseObject(body,ResponseBasic.class);
        if(res.isStatus()){
            synchronized (this) {
                OrderBO orderBean = JSON.parseObject(res.getData().toString(),OrderBO.class);
                orderManageProcess.newOrder(orderBean);
            }
        }
    }

    public void refund(byte[] body){
        ResponseBasic res= JSON.parseObject(body,ResponseBasic.class);
        if(res.isStatus()){
            JSONObject refundObj= JSONObject.fromObject(res.getData());
            Map<String,Class> cmap=new HashMap<>();
            cmap.put("suborders", SubRefundBean.class);
            RefundBean refund= (RefundBean) JSONObject.toBean(refundObj,RefundBean.class,cmap);
            if(refund.getSuborders()==null||refund.getSuborders().getSoidps().size()==0){
                return;
            }
            try {
                orderManageProcess.autoRefund(refund.getRefundId(),refund.getSuborders().getSoid(),refund.getSuborders().getSoidps());
            } catch (DaifaException e) {
                JSONObject obj=new JSONObject();
                obj.put("msg",e.getMessage());
                obj.put("status",false);
                sendMessageListener.sendMessage("refund_"+refund.getRefundId(),
                        "refund_agree",
                        obj.toString());
            }
        }
    }
}
