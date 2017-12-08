package com.shigu.main4.daifa.process.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.data.daifa.beans.DaifaAfterSaleSub;
import com.opentae.data.daifa.beans.DaifaStock;
import com.opentae.data.daifa.examples.DaifaAfterSaleSubExample;
import com.opentae.data.daifa.examples.DaifaStockExample;
import com.opentae.data.daifa.examples.DaifaStockRecordExample;
import com.opentae.data.daifa.interfaces.DaifaAfterSaleSubMapper;
import com.opentae.data.daifa.interfaces.DaifaStockMapper;
import com.opentae.data.daifa.interfaces.DaifaStockRecordMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.exceptions.IsOldException;
import com.shigu.main4.daifa.model.SaleAfterModel;
import com.shigu.main4.daifa.process.SaleAfterProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("saleAfterProcess")
public class SaleAfterProcessImpl implements SaleAfterProcess {
    private static final Logger logger = LoggerFactory.getLogger(SaleAfterProcessImpl.class);
    @Autowired
    private DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    private DaifaStockRecordMapper daifaStockRecordMapper;
    @Autowired
    private DaifaStockMapper daifaStockMapper;

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
        try {
            Integer st=selNowStockStatus(orderId);
            if(st==2){
                throw new DaifaException("设置失败,该商品未进行\"退货失败扫描入库\"");
            }
            if(st==3){
                throw new DaifaException("设置失败,该商品已成功退货档口");
            }
        } catch (IsOldException ignored) {
        }
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
    /**
     * ====================================================================================
     * @方法名： moneyConsult  客服发起
     * @user zf 2017/9/20 9:30
     * @功能： 退货入库  SaleAfterModel.refundFailInStock
     * @param: orderId子单ID,stockLocktion货架号,sendPhone包裹手机号
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public void saleInStock(Long orderId, String stockLocktion, String sendPhone) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class).refundFailInStock(orderId,1,stockLocktion,sendPhone);
    }
    /**
     * 批量售后入库
     * @param orderIds
     * @param stockLocktion
     * @param workerId
     * @throws DaifaException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void saleInStocks(List<Long> orderIds,String stockLocktion,Long workerId) throws DaifaException {
        DaifaAfterSaleSubExample daifaAfterSaleSubExample  = new DaifaAfterSaleSubExample();
        daifaAfterSaleSubExample.createCriteria().andDfOrderIdIn(orderIds);
        List<DaifaAfterSaleSub> daifaAfterSaleSubs = daifaAfterSaleSubMapper.selectByExample(daifaAfterSaleSubExample);
        SaleAfterModel saleAfterModel=SpringBeanFactory.getBean(SaleAfterModel.class);
        for(DaifaAfterSaleSub daifaAfterSaleSub:daifaAfterSaleSubs) {
            saleAfterModel.refundFailInStock(daifaAfterSaleSub.getDfOrderId(),1,stockLocktion,daifaAfterSaleSub.getBuyerTelephone());
            saleAfterModel.insertDaifaStock(daifaAfterSaleSub.getAfterSaleSubId(),workerId);
        }
    }

    /**
     * 批量售后出库
     * @param stockIds
     * @param workerId
     * @throws DaifaException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public String saleOutStocks(List<Long> stockIds,Long workerId) throws DaifaException {
        SaleAfterModel saleAfterModel=SpringBeanFactory.getBean(SaleAfterModel.class);
        String pi= DateUtil.dateToString(new Date(),"yyyyMMddHHmmss");
        for(Long stockId:stockIds) {
            saleAfterModel.insertDaifaStockRecord(2,stockId,workerId,pi);
        }
        return pi;
    }

    /**
     * 退货失败扫描入库
     * @param notIds:失败的ID集合
     * @param yesIds:成功的id集合
     * @param workerId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void notReturnInStocks(List<Long> notIds,List<Long> yesIds,Long workerId){
        SaleAfterModel saleAfterModel=SpringBeanFactory.getBean(SaleAfterModel.class);
        if(notIds!=null&&notIds.size()>0){
            for(Long stockId:notIds){
                saleAfterModel.insertDaifaStockRecord(1,stockId,workerId,null);
            }
        }
        if(yesIds!=null&&yesIds.size()>0){
            for(Long stockId:yesIds){
                saleAfterModel.insertDaifaStockRecord(3,stockId,workerId,null);
            }
        }
    }

    @Override
    public void changeEnt(Long refundId) throws DaifaException {
        SpringBeanFactory.getBean(SaleAfterModel.class,refundId).changeEnt();
    }
    @Override
    public int selNowStockStatus(Long dfOrderId) throws IsOldException {
        return SpringBeanFactory.getBean(SaleAfterModel.class,null).selNowStockStatus(dfOrderId);
    }
    @Override
    public int selNowStockStatusByStockId(Long stockId){
        return SpringBeanFactory.getBean(SaleAfterModel.class,null).selNowStockStatusByStockId(stockId);
    }


}
