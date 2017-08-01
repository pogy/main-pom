package com.shigu.main4.order.services;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.PidNumBO;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderInfoVO;
import com.shigu.main4.order.servicevo.OrderLogVO;
import com.shigu.main4.order.servicevo.RefundInfoVO;
import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.BuyerAddressVO;

import java.text.ParseException;
import java.util.List;

/**
 * 商品交易订单服务
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrderService {
    /**
     * oid获取器
     * @return
     */
    Long idGenerator(OrderType type);
    /**
     * 创建订单
     * @param orderBO
     * @return
     */
    Long createOrder(ItemOrderBO orderBO) throws OrderException;

    /**
     * 重算快递费
     * @param senderId 发件机构ID
     * @param companyId 物流公司ID
     * @param provId 省份ID
     * @return
     */
    Long calculateLogisticsFee(Long senderId,Long companyId,Long provId,List<PidNumBO> pids) throws OrderException;

    /**
     * 查询买家有的地址
     * @param userId
     * @return
     */
    List<BuyerAddressVO> selBuyerAddress(Long userId);

    /**
     * 保存地址
     * @param buyerAddressVO
     */
    void saveBuyerAddress(BuyerAddressVO buyerAddressVO) throws JsonErrException;

    /**
     * 删除地址
     * @param addressId
     */
    void rmBuyerAddress(Long addressId);

    /**
     * 查询订单的物流信息
     * @param orderId
     * @return
     */
    ExpressInfoVO expressInfo(Long orderId) throws Main4Exception;

    /**
     * 查询物流日志
     * @param expressId
     * @return
     */
    List<ExpressLogVO> expressLog(Long expressId) throws Main4Exception, ParseException;

    /**
     * 查询物流日志
     * @param companyCode 公司代码
     * @param courierNumber 快递单号
     * @return logs
     * @throws Main4Exception
     * @throws ParseException
     */
    List<ExpressLogVO> expressLog(String companyCode, String courierNumber) throws Main4Exception, ParseException;
    /**
     * 订单日志
     * @param orderId
     * @return
     */
    List<OrderLogVO> orderLog(Long orderId);
}
