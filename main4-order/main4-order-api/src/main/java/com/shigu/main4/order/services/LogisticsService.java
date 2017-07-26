package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.LogisticsShipVo;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public interface LogisticsService {

    /**
     * 根据退款编号 查询物流信息
     * @param refundId 售后编号
     * @return 快递信息
     */
    LogisticsShipVo logisticsInfo(Long refundId);
}
