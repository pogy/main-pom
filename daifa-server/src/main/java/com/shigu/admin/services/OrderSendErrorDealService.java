package com.shigu.admin.services;

import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.admin.bo.OrderSendErrorDealBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @类编号
 * @类名称：OrderSendErrorDealService
 * @文件路径：com.shigu.admin.services.OrderSendErrorDealService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/12 12:38
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class OrderSendErrorDealService {
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private PackDeliveryProcess packDeliveryProcess;
    /**
     * ====================================================================================
     * @方法名： sendErrorDeal
     * @user gzy 2017/9/12 15:09
     * @功能：列表数据
     * @param: [bo]
     * @return: java.util.List<com.opentae.data.daifa.beans.DaifaTrade>
     * @exception:
     * ====================================================================================
     *
     */
    public List<DaifaTrade> sendErrorDeal(OrderSendErrorDealBO bo){

        DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
        DaifaTradeExample.Criteria exampleCriteria = daifaTradeExample.createCriteria();
        DaifaTradeExample.Criteria eca = daifaTradeExample.createCriteria();
        exampleCriteria.andSendStatusEqualTo (1).andIsOldEqualTo (0);
        if (bo.getDfTradeId() != null) {
            exampleCriteria.andDfTradeIdLike("%" + bo.getDfTradeId()).or().andTradeCodeLike("%"+bo.getDfTradeId());
        }

        if (StringUtils.hasText(bo.getPhone())) {
            exampleCriteria.andReceiverMobileEqualTo(bo.getPhone());
        }
        if(bo.getFlo ()==1){
            eca.andReceiverNameLike ("%&%").or().andReceiverAddressLike ("%&%");
            daifaTradeExample.and (eca);
        }
       return  daifaTradeMapper.selectByExample (daifaTradeExample);

    }
    /**
     * ====================================================================================
     * @方法名： dealOrderSendError
     * @user gzy 2017/9/12 16:29
     * @功能：订单的收货地址或收货人错误
     * @param: [dfTradeId, receiverName, receiverAddr]
     * @return: void
     * @exception:
     * ====================================================================================
     *
     */
    public void dealOrderSendError(Long dfTradeId,String receiverName,String receiverAddr)throws DaifaException{

        packDeliveryProcess.dealOrderSendError (dfTradeId,receiverName,receiverAddr);
    }

}
