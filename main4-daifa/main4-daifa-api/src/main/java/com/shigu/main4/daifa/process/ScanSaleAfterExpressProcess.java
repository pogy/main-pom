package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.bo.ExpressScanBO;
import com.shigu.main4.daifa.bo.ExpressScanInStockBO;
import com.shigu.main4.daifa.bo.RebackPrintExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.ExpressRelevanceVO;

import java.util.List;

/**
 * @类编号
 * @类名称：ScanSaleAfterExpressProcess
 * @文件路径：com.shigu.main4.daifa.process.ScanSaleAfterExpressProcess
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/15 12:23
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public interface ScanSaleAfterExpressProcess {

    /**
     * ====================================================================================
     * @方法名： expressScan
     * @user gzy 2017/9/15 12:26
     * @功能： 快递扫描关联
     * 1把扫描进来的快递单号与售后子表里的数据进行关联，1.1如果先查询关联成功
     * 如果查询到了就先执行ScanSaleAfterExpressModel.expressScanRelevance
     * 再返回售后的整个订单与所有子订单，
     *1.2如果没有关联到那么就返回空列表
     * @param: 
     * @return: 
     * @exception: 
     * ====================================================================================
     * 
     */
    List<ExpressRelevanceVO> expressScan(String expressCode);

    /**
     * ====================================================================================
     * @方法名： expressScanInStock
     * @user gzy 2017/9/15 12:20
     * @功能： 扫描入库
     * 上面没有关联上，这时如果扫描人员点击了入库那么就执行入库
     * @param: bo
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    String expressScanInStock(ExpressScanInStockBO bo);

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

    /**
     * 修改daifa_after_receive_expres_stock备注
     * @param receivedExpressIds  主键
     * @param packageRemark      备注
     */
    void updatePackageRemark(List<Integer> receivedExpressIds,String packageRemark);
}
