package com.shigu.admin.services;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.admin.bo.OrderSendErrorDealBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.vo.ExpressVO;
import com.shigu.main4.daifa.vo.PackResultVO;
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
    private DaifaOrderMapper daifaOrderMapper;
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
        if(bo.getFlo ()!=null&&bo.getFlo ()==1){
            eca.andReceiverNameLike ("%&%").or().andReceiverAddressLike ("%&%");
            daifaTradeExample.and (eca);
        }
        int count= daifaTradeMapper.countByExample (daifaTradeExample);
        bo.setCount (count);
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        daifaTradeExample.setStartIndex((page - 1) * rows);
        daifaTradeExample.setEndIndex(rows);
       return  daifaTradeMapper.selectByConditionList (daifaTradeExample);

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
    /**
     * ====================================================================================
     * @方法名： queryErrorSubOrder
     * @user gzy 2017/9/22 17:49
     * @功能：子订单的商品属性里有'+'的就是有问题的要处理的
     * @param: [bo]
     * @return: java.util.List<com.opentae.data.daifa.beans.DaifaOrder>
     * @exception:
     * ====================================================================================
     *
     */
    public List<DaifaOrder> queryErrorSubOrder(OrderSendErrorDealBO bo){

        DaifaOrderExample example=new DaifaOrderExample ();
        DaifaOrderExample.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andRefundStatusGreaterThanOrEqualTo (0);//.andTakeGoodsStatusEqualTo (1);
        if (bo.getDfTradeId() != null) {
            exampleCriteria.andDfTradeIdLike("%" + bo.getDfTradeId());
        }else{
            exampleCriteria.andPropStrLike ("%+%");
        }

        int count= daifaOrderMapper.countByExample (example);
        bo.setCount (count);
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        example.setStartIndex((page - 1) * rows);
        example.setEndIndex(rows);
        return daifaOrderMapper.selectByConditionList (example);

    }

    public void dealSubOrderError(Long dfOrderId,String propStr,String goodsCode,String storeGoodsCode)throws DaifaException{

        packDeliveryProcess.dealSubOrderError (dfOrderId,propStr, goodsCode, storeGoodsCode);
    }
    /**
     * ====================================================================================
     * @方法名： dealSendTest
     * @user gzy 2017/10/27 17:53
     * @功能：
     * @param: [dfTradeId]
     * @return: com.shigu.main4.daifa.vo.ExpressVO
     * @exception:
     * ====================================================================================
     *
     */
    public ExpressVO dealSendTest(Long dfTradeId)throws DaifaException{

       return packDeliveryProcess.dealSendTest (dfTradeId);
    }
    /**
     * ====================================================================================
     * @方法名： dealSendordinary
     * @user gzy 2017/10/27 18:02
     * @功能：
     * @param: [subOrderId]
     * @return: com.shigu.main4.daifa.vo.PackResultVO
     * @exception:
     * ====================================================================================
     *
     */
    public PackResultVO dealSendordinary(Long subOrderId)throws DaifaException{

        return packDeliveryProcess.packSubOrder (subOrderId);
    }

}
