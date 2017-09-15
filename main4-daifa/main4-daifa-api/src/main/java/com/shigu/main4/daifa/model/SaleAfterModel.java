package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.exceptions.DaifaException;

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
     * @param: refundId退货ID,orderId代发子订单ID
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String saleAfterApply(Long refundId,Long orderId)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： afterApplyDeal
     * @user gzy 2017/9/15 11:22
     * @功能： 代发售后申请的处理 客服处理
     * @param: refundId退货ID,orderId代发子订单ID
     * 同意发回收货地址，如果不同意返回拒绝的理由
     * @return:
     * @exception: 
     * ====================================================================================
     * 
     */
    String saleAfterApplyDeal(Long refundId,Long orderId)throws DaifaException;

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
    String saleAfterExpress(Long refundId,Long orderId,String expressName,String expressCode)throws DaifaException;
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
    String saleAfterRemark(Long refundId,Long orderId,String remark)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： storeRefundMoney
     * @user gzy 2017/9/15 11:41
     * @功能： 档口退货成功退款 客服处理
     * @param: refundId退货ID,orderId代发子订单ID，money金额
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String storeRefundMoney(Long refundId,Long orderId,String money)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： storeReturnRefuse
     * @user gzy 2017/9/15 11:39
     * @功能： 档口退货拒绝 客服处理
     * @param: refundId退货ID,orderId代发子订单ID
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String storeRefundRefuse(Long refundId,Long orderId)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： refundFailInStock
     * @user gzy 2017/9/15 11:45
     * @功能： 退货失败入库  客服处理
     * @param: refundId退货ID,orderId代发子订单ID,inStockType入库类型，stockLocktion库位
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String refundFailInStock(Long refundId,Long orderId,Integer inStockType,String stockLocktion)throws DaifaException;
    //============================客户不同意退回的金额的处理=====================================================
    /**
     * ====================================================================================
     * @方法名： moneyConsultRefuse
     * @user gzy 2017/9/15 11:51
     * @功能： 客户拒绝协商金额 客户发起的
     * daifa_after_money_consult  客服协商金表城进行修改
     * @param: refundId退货ID,orderId代发子订单ID
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String moneyConsultRefuse(Long refundId,Long orderId)throws DaifaException;
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
    String moneyConsult(Long refundId,Long orderId,String money)throws DaifaException;
}
