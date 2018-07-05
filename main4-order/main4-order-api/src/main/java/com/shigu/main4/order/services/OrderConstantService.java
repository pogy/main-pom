package com.shigu.main4.order.services;

import com.shigu.main4.order.vo.*;

import java.util.List;
import java.util.Map;

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
     * 按marketId获取代发服务
     * @param senderId
     * @param marketId
     * @return
     */
    ServiceVO selDfService(Long senderId,Long marketId);

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
     * 查询所有快递公司
     * @return
     */
    List<ExpressVo> selExpresses();

    ExpressVo selByExpressId(Long expressId);
    /**
     * 查询所有省份
     * @return
     */
    List<ProvinceVO> selProvinces();

    /**
     * 按省份ID查城市
     * @param provinceId
     * @return
     */
    List<CityVO> selCitysByPid(Long provinceId);

    /**
     * 按城市ID查地区
     * @param cityId
     * @return
     */
    List<TownVO> selTownByCid(Long cityId);

    ProvinceVO selProvByPid(Long pid);

    CityVO selCityByCid(Long cid);

    TownVO selTownByTid(Long tid);

    void initAddress();

}
