package com.shigu.main4.daifa.process.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.SaleAfterModel;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("saleAfterProcess")
public class SaleAfterProcessImpl implements SaleAfterProcess {
    private static final Logger logger = LoggerFactory.getLogger(SaleAfterProcessImpl.class);
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;

    /**
     * ====================================================================================
     * @方法名： newSaleAfter  客户发起
     * @user gzy 2017/9/15 11:31
     * @功能： 客户发起售后的写入 应该是MQ来的
     * 转成代发能调用的单子子单信息的处理调用SaleAfterModel.saleAfterApply
     * @param: bo
     * @return:
     * @exception:
     * @PS: 消息类dubbo,需记录异常
     * ====================================================================================
     *
     */
    @Override
    public void newSaleAfter(SaleAfterBO bo) throws DaifaException {
        try {
            SpringBeanFactory.getBean(SaleAfterModel.class, bo.getRefundId())
                    .saleAfterApply(bo.getSubOid(), bo.getAfterType(), bo.getNum(), bo.getReason());
        } catch (DaifaException e) {
            String param= JSONObject.fromObject(bo).toString();
            e.addSuppressed(new DaifaException("param:"+param,DaifaException.ERROR));
            logger.error(e);
            throw e;
        }
    }
    /**
     * ====================================================================================
     * @方法名： afterApplyDeal 客服发起
     * @user gzy 2017/9/15 11:33
     * @功能： 售后申请处理 1可能是同意并发回快递收货地址2可能是拒绝
     * SaleAfterModel.saleAfterApplyDeal
     * @param: refundId售后ID,status(1同意2拒绝),reason拒绝理由
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public String afterApplyDeal(Long refundId,Integer status,String reason) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class, refundId).saleAfterApplyDeal(status,reason);
        return null;
    }
    /**
     * ====================================================================================
     * @方法名： storeRefundDeal  客服发起
     * @user gzy 2017/9/15 11:42
     * @功能： 档口同意
     * SaleAfterModel.storeRefundMoney
     * @param: refundId售后ID,money档口退款金额(元)
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public String storeRefundAgree(Long refundId,String money) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class, refundId).storeRefundMoney(money);
        return null;
    }
    /**
     * ====================================================================================
     * @方法名： storeRefundDeal  客服发起
     * @user gzy 2017/9/15 11:42
     * @功能： 档口拒绝
     * SaleAfterModel.storeRefundRefuse和SaleAfterModel.refundFailInStock
     * @param: refundId售后ID,reason理由,stockLocktion货架
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String storeRefundRefuse(Long orderId,String reason,String stockLocktion) throws DaifaException {
        SaleAfterModel model=SpringBeanFactory.getBean(SaleAfterModel.class);
        model.storeRefundRefuse(orderId,reason);
        DaifaAfterSaleSub sub=new DaifaAfterSaleSub();
        sub.setDfOrderId(orderId);
        sub=daifaAfterSaleSubMapper.selectOne(sub);
        if(sub.getInStock()!=null){
            model.refundFailInStock(orderId,2,stockLocktion,null);
        }
        return null;
    }

    /**
     * ====================================================================================
     * @方法名： saleAfterExpress 客户发起
     * @user gzy 2017/9/15 12:13
     * @功能： 代发快递信息的写入
     * @param:bo
     * @return:
     * @exception:
     * @PS: 消息类dubbo,需记录异常
     * ====================================================================================
     *
     */
    @Override
    public String saleAfterExpress(SaleAfterExpressBO bo) throws DaifaException {
        try {
            SpringBeanFactory.getBean(SaleAfterModel.class, bo.getRefundId()).saleAfterExpress(bo.getExpressName(),bo.getExpressCode());
        } catch (DaifaException e) {
            String param= JSONObject.fromObject(bo).toString();
            e.addSuppressed(new DaifaException("param:"+param,DaifaException.ERROR));
            logger.error(e);
            throw e;
        }
        return null;
    }

    @Override
    public String saleAfterRemark(SaleAfterRemarkerBO bo) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class).saleAfterRemark(bo.getAfterSaleId(),bo.getRemark());
        return null;
    }

    /**
     * ====================================================================================
     * @方法名： moneyConsultRefuse  客户发起
     * @user gzy 2017/9/15 11:51
     * @功能： 客户拒绝协商金额    SaleAfterModel.moneyConsultRefuse
     * @param: bo
     * @return:
     * @exception:
     * @PS: 消息类dubbo,需记录异常
     * ====================================================================================
     *
     */
    @Override
    public String moneyConsultRefuse(MoneyConsultBO bo) throws DaifaException {
        try {
            SpringBeanFactory.getBean(SaleAfterModel.class, bo.getRefundId()).moneyConsultRefuse();
        } catch (DaifaException e) {
            String param= JSONObject.fromObject(bo).toString();
            e.addSuppressed(new DaifaException("param:"+param,DaifaException.ERROR));
            logger.error(e);
            throw e;
        }
        return null;
    }

    @Override
    public String moneyConsultAgree(MoneyConsultBO bo) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class, bo.getRefundId()).moneyConsultAgree();
        return null;
    }

    /**
     * ====================================================================================
     * @方法名： moneyConsult  客服发起
     * @user gzy 2017/9/15 11:54
     * @功能： 客服重新把商量的金额写入  SaleAfterModel.moneyConsult
     * @param: refundId售后ID,money金额
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public String moneyConsult(Long refundId,String money) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class, refundId).moneyConsult(money);
        return null;
    }

    @Override
    public void saleInStock(Long orderId, String stockLocktion, String sendPhone) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class).refundFailInStock(orderId,1,stockLocktion,sendPhone);
    }

    @Override
    public void changeEnt(Long refundId) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class,refundId).changeEnt();
    }
}
