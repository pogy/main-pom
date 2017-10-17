package com.shigu.main4.daifa.process;


import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.OrderSendErrorDealVO;
import com.shigu.main4.daifa.vo.PackResultVO;
import com.shigu.main4.daifa.vo.PrintExpressVO;

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

    int dealSubOrderError(Long dfOrderId,String propStr)throws DaifaException;
}
