package com.shigu.mq.services;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.mq.beans.RefundBean;
import com.shigu.mq.beans.ResponseBasic;
import com.shigu.mq.beans.SubRefundBean;
import com.shigu.mq.receives.SendMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
    private static final Logger logger = LoggerFactory.getLogger(OrderConsumerService.class);
    @Autowired
    SendMessageListener sendMessageListener;

    private OrderManageProcess orderManageProcess;

    @Autowired
    public void setOrderManageProcess(OrderManageProcess orderManageProcess) {
        this.orderManageProcess = orderManageProcess;
    }

    public void orderConvertTrade(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if (res.isStatus()) {
            OrderBO orderBean = JSON.parseObject(res.getData().toString(), OrderBO.class);
            // System.out.println (orderBean);
            synchronized (orderBean.getOid().toString().intern()) {
                orderManageProcess.newOrder(orderBean);
            }

        }
    }

    public void refund(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if (res.isStatus()) {
            RefundBean refund = JSON.parseObject(JSON.toJSONString(res.getData()), RefundBean.class);
            // RefundBean refund=JSON.parseObject(res.getData().toString(),RefundBean.class);
            if (refund.getSuborders() == null || refund.getSuborders().size() == 0) {
                return;
            }
            try {
                //=============事物start=================
                List<AutoRefundBo> bos=new ArrayList<>();
                for (SubRefundBean srb : refund.getSuborders()) {
                    AutoRefundBo bo=new AutoRefundBo();
                    bo.setSoid(srb.getSoid());
                    bo.setSoidps(srb.getSoidps());
                    bo.setNum(srb.getNum());
                    bos.add(bo);
                }
                orderManageProcess.autoRefund(refund.getRefundId(), bos);
                //=============事物end=================
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
