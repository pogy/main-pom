package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.exceptions.DaifaException;

/**
 * @类编号
 * @类名称：SaleAfterProcess
 * @文件路径：com.shigu.main4.daifa.process.SaleAfterProcess
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:26
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface SaleAfterProcess {


    /**
     * ====================================================================================
     * @方法名： newSaleAfter  客户发起
     * @user gzy 2017/9/15 11:31
     * @功能： 客户发起售后的写入 应该是MQ来的
     * 转成代发能调用的单子子单信息的处理调用SaleAfterModel.saleAfterApply
     * @param: bo
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    void newSaleAfter(SaleAfterBO bo)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： afterApplyDeal 客服发起
     * @user gzy 2017/9/15 11:33
     * @功能： 售后申请处理 1可能是同意并发回快递收货地址2可能是拒绝
     * SaleAfterModel.saleAfterApplyDeal
     * @param: bo
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String afterApplyDeal(SaleAfterBO bo)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： storeRefundDeal  客服发起
     * @user gzy 2017/9/15 11:42
     * @功能： 档口退货处理  可能是退货成功，也可能是拒绝退货
     * 1、退货失败(单件商品操作)
     * 2、退货成功（按申请的refundId对应，一次操作除失败以外的所有单件）
     *     a、价格与申请时候的价格一样，退货成功
     *     b、价格（包括退失败的）与申请价格不一样，发起议价
     *
     * SaleAfterModel.storeRefundMoney或SaleAfterModel.storeRefundRefuse
     * @param: bo
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String storeRefundDeal(StoreRefundDealBO bo)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： saleAfterExpress 客户发起
     * @user gzy 2017/9/15 12:13
     * @功能： 代发快递信息的写入
     * @param:bo
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    String saleAfterExpress(SaleAfterExpressBO bo)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： saleAfterRemark  客服发起
     * @user gzy 2017/9/15 12:10
     * @功能： 售后备注  SaleAfterModel.saleAfterRemark
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String saleAfterRemark(SaleAfterBO bo)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： refundFailInStock  客服发起
     * @user gzy 2017/9/15 11:56
     * @功能： 退货失败入库   SaleAfterModel.refundFailInStock
     * @param: bo
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String refundFailInStock(InStockBO bo)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： moneyConsultRefuse  客户发起
     * @user gzy 2017/9/15 11:51
     * @功能： 客户拒绝协商金额    SaleAfterModel.moneyConsultRefuse
     * @param: bo
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    String moneyConsultRefuse(MoneyConsultBO bo)throws DaifaException;
    /**
     * ====================================================================================
     * @方法名： moneyConsult  客服发起
     * @user gzy 2017/9/15 11:54
     * @功能： 客服重新把商量的金额写入  SaleAfterModel.moneyConsult
     * @param:bo
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    String moneyConsult(MoneyConsultBO bo)throws DaifaException;


}
