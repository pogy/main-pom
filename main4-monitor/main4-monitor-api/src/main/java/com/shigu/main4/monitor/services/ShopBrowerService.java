package com.shigu.main4.monitor.services;

import com.shigu.main4.monitor.enums.FlowType;
import com.shigu.main4.monitor.vo.DataLineVO;

import java.util.Date;
import java.util.List;

/**
 * 店铺浏览量服务
 * Created by zhaohongbo on 17/3/8.
 */
public interface ShopBrowerService {
    /**
     * 按小时统计店铺流量
     * @param start
     * @param number
     * @param type
     * @return
     */
    List<DataLineVO> selShopFlowByHour(Long shopId,Date start, Integer number, FlowType type);

    /**
     * 按天统计店铺流量
     * @param start
     * @param number
     * @param type
     * @return
     */
    List<DataLineVO> selShopFlowByDay(Long shopId,Date start, Integer number, FlowType type);
}
