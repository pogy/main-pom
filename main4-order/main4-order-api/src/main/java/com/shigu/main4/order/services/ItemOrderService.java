package com.shigu.main4.order.services;

import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.PidNumBO;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.vo.BuyerAddressVO;

import java.util.List;
import java.util.UUID;

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
    Long createOrder(ItemOrderBO orderBO);

    /**
     * 重算快递费
     * @param senderId 发件机构ID
     * @param companyId 物流公司ID
     * @param provId 省份ID
     * @return
     */
    Long calculateLogisticsFee(Long senderId,Long companyId,Long provId,List<PidNumBO> pids);

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
    void saveBuyerAddress(BuyerAddressVO buyerAddressVO);

    /**
     * 删除地址
     * @param addressId
     */
    void rmBuyerAddress(Long addressId);

}
