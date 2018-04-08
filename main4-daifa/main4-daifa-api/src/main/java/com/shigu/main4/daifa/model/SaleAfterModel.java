package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.exceptions.IsOldException;

import java.util.List;

/**
 * @类编号
 * @类名称：AfterModel
 * @文件路径：com.shigu.main4.daifa.model.AfterModel
 * @内容摘要：售后处理
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:14
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface SaleAfterModel {

    /**
     * ====================================================================================
     * @方法名： afterApply
     * @user gzy 2017/9/15 11:21
     * @功能： 代发售后申请的写入 客户发起
     * @param: orderCode外部子单号,afterType售后类型(1退货2换货),num申请数量,reason原因
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    String saleAfterApply(Long orderCode,Integer afterType,Integer num,String reason)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： afterApplyDeal
     * @user gzy 2017/9/15 11:22
     * @功能： 代发售后申请的处理 客服处理
     * @param: status是否同意申请(1同意2拒绝),reason拒绝理由
     * 同意发回收货地址，如果不同意返回拒绝的理由
     * @return:
     * @exception: 
     * ====================================================================================
     * 
     */
    String saleAfterApplyDeal(Integer status,String reason)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： saleAfterExpress
     * @user gzy 2017/9/15 12:13
     * @功能： 代发快递信息的写入  客户发起
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String saleAfterExpress(String expressName,String expressCode)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： afterRemark
     * @user gzy 2017/9/15 11:35
     * @功能： 代发备注的写入 客服处理
     * @param: refundId退货ID,orderId代发子订单ID，备注
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    int saleAfterRemark(Long afterSaleId,String remark)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： storeRefundMoney
     * @user gzy 2017/9/15 11:41
     * @功能： 档口退货成功退款 客服处理
     * @param: money金额
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String storeRefundMoney(String money)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： storeReturnRefuse
     * @user gzy 2017/9/15 11:39
     * @功能： 档口退货拒绝 客服处理
     * @param: orderId代发子订单ID,reason原因
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String storeRefundRefuse(Long orderId,String reason)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： refundFailInStock
     * @user gzy 2017/9/15 11:45
     * @功能： 售后入库  客服处理
     * @param: orderId代发子订单ID,inStockType入库类型(1售后退货入库2退货失败入库)，stockLocktion库位,sendPhone包裹手机号(退货入库时传)
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String refundFailInStock(Long orderId,Integer inStockType,String stockLocktion,String sendPhone)throws DaifaException;

    /**
     * 写入库存
     * @param afterSubId
     * @param workerId
     */
    void insertDaifaStock(Long afterSubId,Long workerId);

    /**
     * 写入出入库
     * @param stockStatus
     * @param stockId
     * @param workerId
     */
    void insertDaifaStockRecord(int stockStatus,Long stockId,Long workerId,String piCode);


    //============================客户不同意退回的金额的处理=====================================================
    /**
     * ====================================================================================
     * @方法名： moneyConsultRefuse
     * @user gzy 2017/9/15 11:51
     * @功能： 客户拒绝协商金额 客户发起的
     * daifa_after_money_consult  客服协商金表城进行修改
     * @param: refundId退货ID
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String moneyConsultRefuse()throws DaifaException;

    /**
     * 客户同意协商金额
     * @return
     * @throws DaifaException
     */
    String moneyConsultAgree()throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： moneyConsult
     * @user gzy 2017/9/15 11:54
     * @功能： 客服重新把商量的金额写入
     * daifa_after_money_consult  客服协商金表城进行写入
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String moneyConsult(String money)throws DaifaException;

    /**
     * 换货完成
     * @return
     */
    String changeEnt() throws DaifaException;

    /**
     * 获取当前的库存状态
     * @param dfOrderId
     * @return
     */
    int selNowStockStatus(Long dfOrderId) throws IsOldException;
    /**
     * 获取当前的库存状态
     * @param stockId
     * @return
     */
    int selNowStockStatusByStockId(Long stockId);

}
