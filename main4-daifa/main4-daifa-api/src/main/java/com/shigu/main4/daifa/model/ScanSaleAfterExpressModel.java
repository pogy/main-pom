package com.shigu.main4.daifa.model;

import com.shigu.main4.daifa.bo.RebackPrintExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;

/**
 * @类编号
 * @类名称：ScanSaleAfterExpressModel
 * @文件路径：com.shigu.main4.daifa.model.ScanSaleAfterExpressModel
 * @内容摘要：售后快递处理
 * @编码作者：gzy
 * @创建日期：2017/9/15 11:58
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface ScanSaleAfterExpressModel {

    /**
     * ====================================================================================
     * @方法名：expressScanRelevance
     * @user gzy 2017/9/15 12:17
     * @功能： 收到货的扫描关联
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String expressScanRelevance(String expressCode)throws DaifaException;

    /**
     * ====================================================================================
     * @方法名： expressScanInStock
     * @user gzy 2017/9/15 12:20
     * @功能： 扫描入库
     * @param: expressName快递名，expressCode快递单号，stockLocation货架，sendPhone发货人的手机号
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String expressScanInStock(String expressName,String expressCode,String stockLocation,String sendPhone);

    /**
     * ====================================================================================
     * @方法名： rebackPrintExpress
     * @user gzy 2017/9/15 12:44
     * @功能： 售后发回的快递单
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    String rebackPrintExpress(RebackPrintExpressBO bo)throws DaifaException;

}
