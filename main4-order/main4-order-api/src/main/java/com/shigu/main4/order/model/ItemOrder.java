package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.vo.*;

import java.util.List;

/**
 * 商品订单
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrder extends Order{
    /**
     * 查询订单物流信息.
     * @return 物流信息
     */
    List<LogisticsVO> selLogisticses();

    /**
     * 查订单信息.
     * @return
     */
    ItemOrderVO orderInfo();

    /**
     * 查子订单信息.
     * @return
     */
    List<SubItemOrderVO> subOrdersInfo();

    /**
     * 添加物流信息.
     * @param logistics
     * @param needReprice 是否需要重新计算价格
     */
    Long addLogistics(List<Long> soids,LogisticsVO logistics,boolean needReprice);

    /**
     * 修改物流信息.
     * @param id 物流信息ID
     * @param logistics 改后的物流信息
     */
    void modifyLogistics(Long id,LogisticsVO logistics);

    /**
     * 添加包材.
     * @param metarialId 材料ID
     */
    void addPackage(Long metarialId,Integer num,boolean needReprice);

    /**
     * 退包材.
     * @param money 退的费用
     */
    void refundPackage(Long id,Long money) throws RefundException;

    /**
     * 添加代发费的服务
     * @param serviceVO
     * @param number
     */
    void addDfService(ServiceVO serviceVO,Long soid,Integer number,boolean needReprice);

    /**
     * 除商品外的其他钱
     */
    Long orderOtherAmount();
    /**
     * 退服务款.
     * @param id 服务ID
     * @param money 退的费用
     */
    void refundService(Long id,Long money) throws RefundException;//退服务

    /**
     * 查询本单的服务
     * @return
     */
    List<OrderServiceVO> selServices();

    /**
     * 全单发货.
     */
    void sended(String courierNumber);

    /**
     * 部分发货
     * @param logisticsId
     * @param courierNumber
     */
    void sendPart(Long logisticsId,List<Long> soids,String courierNumber);//部分发货

    /**
     * 查询发件单位.
     * @return
     */
    SenderVO selSender();


    /**
     * 添加代金券折扣
     * @param voucherId
     * @return
     */
    void addVoucher(Long voucherId);

}
