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
     * 物流类型
     */
    int LOGISTICS_TYPE = 1;
    /**
     * 服务类型
     */
    int SERVICE_TYPE = 2;

    /**
     * 包材类型
     */
    int PACKAGE_TYPE = 3;
    /**
     * 初始化
     */
    void init();

    /**
     * 查询服务
     * @return
     */
    List<ServiceVO> selServices(Long senderId);

    /**
     * 按服务ID查服务
     * @param id
     * @return
     */
    ServiceVO selServiceById(Long senderId,Long id);

    /**
     * 查询所有包材
     * @return
     */
    List<MetarialVO> selMetarials(Long senderId);

    /**
     * 按包材ID查包材
     * @param id
     * @return
     */
    MetarialVO selMetarialById(Long senderId,Long id);

    /**
     * 查询所有物流信息
     * @return
     */
    List<LogisticsCompanyVO> selLogistics(Long senderId);

    /**
     * 按物流信息ID查物流
     * @param id
     * @return
     */
    LogisticsCompanyVO selLogisticsById(Long senderId,Long id);
}
