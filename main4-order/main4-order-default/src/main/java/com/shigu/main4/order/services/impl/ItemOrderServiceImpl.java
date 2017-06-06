package com.shigu.main4.order.services.impl;

import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.PidNumBO;
import com.shigu.main4.order.services.ItemOrderService;

import java.util.List;

/**
 * 商品订单服务
 * Created by zhaohongbo on 17/6/2.
 */
public class ItemOrderServiceImpl implements ItemOrderService{
    @Override
    public Long createOrder(ItemOrderBO orderBO) {
        return null;
    }

    @Override
    public Long calculateLogisticsFee(Long senderId, Long companyId, Long provId,List<PidNumBO> pids) {
        return null;
    }
}
