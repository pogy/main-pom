package com.shigu.main4.order.services;

import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.PidNumBO;

import java.util.List;

/**
 * 商品交易订单服务
 * Created by zhaohongbo on 17/6/1.
 */
public interface ItemOrderService {

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
}
