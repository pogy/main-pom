package com.shigu.mq.services;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.order.process.QimenTradeProcess;
import com.shigu.mq.beans.*;
import com.shigu.mq.receives.SendMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private OrderManageProcess orderManageProcess;
    @Autowired
    private SaleAfterProcess saleAfterProcess;
    @Autowired
    private TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    QimenTradeProcess qimenTradeProcess;

    public void orderConvertTrade(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if (res.isStatus()) {
            OrderBO orderBean = JSON.parseObject(res.getData().toString(), OrderBO.class);
            // //System.out.println (orderBean);
            synchronized (orderBean.getOid().toString().intern()) {
                orderManageProcess.newOrder(orderBean);
            }
            try {
                qimenTradeProcess.toCheck(orderBean.getOid());
            } catch (Exception e) {
                e.printStackTrace();
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
            } catch (DaifaException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void returnOrChange(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if(res.isStatus()){
            ReturnOrChangeBean rg=JSON.parseObject(JSON.toJSONString(res.getData()), ReturnOrChangeBean.class);
            synchronized (rg.getRefundId().toString().intern()){
                SaleAfterBO bo=new SaleAfterBO();
                bo.setSubOid(rg.getSoid());
                bo.setRefundId(rg.getRefundId());
                bo.setReason(rg.getReason());
                bo.setNum(rg.getNum());
                bo.setAfterType(rg.getType());
                try {
                    saleAfterProcess.newSaleAfter(bo);
                } catch (DaifaException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void setPost(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if(res.isStatus()){
            ReturnExpress ex=JSON.parseObject(JSON.toJSONString(res.getData()), ReturnExpress.class);
            SaleAfterExpressBO bo=new SaleAfterExpressBO();
            bo.setRefundId(ex.getRefundId());
            bo.setExpressCode(ex.getCourierNumber());
            bo.setExpressName(ex.getCompany());
            try {
                saleAfterProcess.saleAfterExpress(bo);
            } catch (DaifaException e) {
                logger.error(e.getMessage());
            }
        }
    }
    public void reproce(String body){
        ResponseBasic res = JSON.parseObject(body, ResponseBasic.class);
        if(res.isStatus()){
            Reproce ex=JSON.parseObject(JSON.toJSONString(res.getData()), Reproce.class);
            MoneyConsultBO bo=new MoneyConsultBO();
            bo.setRefundId(ex.getRefundId());
            if(!ex.getAgree()){
                try {
                    saleAfterProcess.moneyConsultRefuse(bo);
                } catch (DaifaException e) {
                    logger.error(e.getMessage());
                }
            }else{
                try {
                    saleAfterProcess.moneyConsultAgree(bo);
                } catch (DaifaException e) {
                    logger.error(e.getMessage());
                }
            }

        }
    }

}
