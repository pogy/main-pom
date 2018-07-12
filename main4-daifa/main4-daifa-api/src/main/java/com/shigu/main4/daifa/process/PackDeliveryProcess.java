package com.shigu.main4.daifa.process;


import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.OrderSendErrorDealVO;
import com.shigu.main4.daifa.vo.PackResultVO;
import com.shigu.main4.daifa.vo.PrintExpressVO;

import java.util.List;

/**
 * 打包发货
 * Created by zhaohongbo on 17/8/8.
 */
public interface PackDeliveryProcess {
    /**
     * 单件发货扫货
     *
     * @param subOrderId
     */
    PackResultVO packSubOrder(Long subOrderId) throws DaifaException;

    /**
     * 获取打印快递单数据,修改打印状态
     * @param sendId
     * @return
     */
    PrintExpressVO printExpress(Long sendId);


    OrderSendErrorDealVO dealOrderSendError(Long dfTradeId, String receiverName, String receiverAddr)throws DaifaException;

    int dealSubOrderError(Long dfOrderId,String propStr,String goodsCode,String storeGoodsCode)throws DaifaException;

    /**
     * 重量
     * @param subOrderId
     * @param weight
     * @param sellerId
     */
    void updateGoodsWeight(Long subOrderId,Long weight,Long sellerId);

    /**
     * 尝试获取快递单号
     * 获取成功则写入到daifa_wait_send表中(daifa_trade不写)
     * @param dfTradeId
     */
    void queryExpressCode(Long dfTradeId) throws DaifaException;
    List<SubOrderExpressBO> cheackeSend(Long dfTradeId) throws DaifaException;
    ExpressVO dealSendTest(Long dfTradeId)throws DaifaException;
}
