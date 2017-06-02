package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.ServiceVO;

import java.util.List;

/**
 * 订单常量资源管理
 * Created by zhaohongbo on 17/6/2.
 */
public interface OrderConstantService {
    /**
     * 初始化
     */
    void init();

    /**
     * 查询服务
     * @return
     */
    List<ServiceVO> selServices();

    /**
     * 按服务ID查服务
     * @param id
     * @return
     */
    ServiceVO selServiceById(Long id);

    /**
     * 查询所有包材
     * @return
     */
    List<MetarialVO> selMetarials();

    /**
     * 按包材ID查包材
     * @param id
     * @return
     */
    MetarialVO selMetarialById(Long id);

    /**
     * 查询所有物流信息
     * @return
     */
    List<LogisticsCompanyVO> selLogistics();

    /**
     * 按物流信息ID查物流
     * @param id
     * @return
     */
    LogisticsCompanyVO selLogisticsById(Long id);
}
