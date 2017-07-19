package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderConstant;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.beans.OrderTown;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderConstantMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.opentae.data.mall.interfaces.OrderTownMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 订单常量资源管理 实现
 * Created by bugzy on 2017/6/9 0009.
 */
@Service("orderConstantService")
public class OrderConstantServiceImpl implements OrderConstantService {

    @Autowired
    private OrderConstantMapper orderConstantMapper;

    @Autowired
    private OrderProvMapper orderProvMapper;

    @Autowired
    private OrderCityMapper orderCityMapper;

    @Autowired
    private OrderTownMapper orderTownMapper;

    /**
     * 订单常量
     */
    public enum OrderConstantType {
        LOGISTICS(LOGISTICS_TYPE, LogisticsCompanyVO.class),
        SERVICE(SERVICE_TYPE, ServiceVO.class),
        PACKAGE(PACKAGE_TYPE, MetarialVO.class);
        private int type;
        private Class<? extends OrderConstantVo> voClazz;
        private Map<Long, List<OrderConstantVo>> orderConstantsMap;
        OrderConstantType(int type, Class<? extends OrderConstantVo> clazz) {
            this.type = type;
            this.voClazz = clazz;
            orderConstantsMap = new HashMap<>();
        }
        static OrderConstantType typeOf(int type) {
            for (OrderConstantType constantType : values()) {
                if (constantType.type == type)
                    return constantType;
            }
            throw new IllegalArgumentException(String.format("OrderConstant type[%d] does not exist.", type));
        }

        void put(Long senderId, OrderConstant constant) {
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId);
            if (orderConstants == null) {
                orderConstants = new ArrayList<>();
                orderConstantsMap.put(senderId, orderConstants);
            }
             orderConstants.add(JSON.parseObject(constant.getContext(), voClazz));
        }

        @SuppressWarnings("unchecked")
        <T> T get(Long senderId, Long id) {
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId == null ? -1L : senderId);
            if (orderConstants != null) {
                for (OrderConstantVo orderConstant : orderConstants)
                    if (Objects.equals(orderConstant.getId(), id))
                        return (T) orderConstant;
            }
            return null;
        }

        @SuppressWarnings("unchecked")
        <T extends OrderConstantVo> List<T> all(Long senderId) {
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId);
            if (orderConstants == null)
                orderConstants = Collections.emptyList();
            return (List<T>) orderConstants;
        }
    }

    /**
     * 初始化
     */
    @Override
    @PostConstruct
    public void init() {
        for (OrderConstant constant : orderConstantMapper.select(new OrderConstant())) {
            OrderConstantType.typeOf(constant.getType()).put(constant.getSenderId(), constant);
        }
    }

    /**
     * 查询服务
     *
     * @param senderId 发送单位ID
     * @return 发送单位所有服务
     */
    @Override
    public List<ServiceVO> selServices(Long senderId) {
        return OrderConstantType.SERVICE.all(senderId);
    }

    /**
     * 按服务ID查服务
     *
     * @param senderId 发送单位ID
     * @param id 服务ID
     * @return 某发送单位的某服务
     */
    @Override
    public ServiceVO selServiceById(Long senderId, Long id) {
        return OrderConstantType.SERVICE.get(senderId, id);
    }

    /**
     * 查询所有包材
     *
     * @param senderId 发送单位ID
     * @return 发送单位全部包材
     */
    @Override
    public List<MetarialVO> selMetarials(Long senderId) {
        return OrderConstantType.PACKAGE.all(senderId);
    }

    /**
     * 按包材ID查包材
     *
     * @param senderId 发送单位ID
     * @param id 包材ID
     * @return 某发送单位的某包材
     */
    @Override
    public MetarialVO selMetarialById(Long senderId, Long id) {
        return OrderConstantType.PACKAGE.get(senderId, id);
    }

    /**
     * 查询所有物流信息
     *
     * @param senderId 发送单位ID
     * @return 发送单位支持的全部物流
     */
    @Override
    public List<LogisticsCompanyVO> selLogistics(Long senderId) {
        return OrderConstantType.LOGISTICS.all(senderId);
    }

    /**
     * 按物流信息ID查物流
     *
     * @param senderId 发送单位ID
     * @param id 物流ID
     * @return 某发送单位的某物流
     */
    @Override
    public LogisticsCompanyVO selLogisticsById(Long senderId, Long id) {
        return OrderConstantType.LOGISTICS.get(senderId, id);
    }

    /**
     * 查询所有省份
     *
     * @return
     */
    @Override
    public List<ProvinceVO> selProvinces() {
        List<OrderProv> select = orderProvMapper.select(new OrderProv());
        List<ProvinceVO> vos = new ArrayList<>(select.size());
        for (OrderProv orderProv : select) {
            ProvinceVO vo = new ProvinceVO();
            vos.add(vo);
            vo.setProvinceId(orderProv.getProvId());
            vo.setProvince(orderProv.getProvName());
        }
        return vos;
    }

    /**
     * 按省份ID查城市
     *
     * @param provinceId
     * @return
     */
    @Override
    public List<CityVO> selCitysByPid(Long provinceId) {
        if (provinceId == null) {
            return Collections.emptyList();
        }
        OrderCity orderCity = new OrderCity();
        orderCity.setProvId(provinceId);
        List<OrderCity> orderCities = orderCityMapper.select(orderCity);
        List<CityVO> cityVOS = new ArrayList<>(orderCities.size());
        for (OrderCity city : orderCities) {
            CityVO vo = new CityVO();
            cityVOS.add(vo);
            vo.setCityId(city.getCityId());
            vo.setCity(city.getCityName());
        }
        return cityVOS;
    }



    /**
     * 按城市ID查地区
     *
     * @param cityId
     * @return
     */
    @Override
    public List<TownVO> selTownByCid(Long cityId) {
        if (cityId == null) {
            return Collections.emptyList();
        }
        OrderTown orderTown = new OrderTown();
        orderTown.setCityId(cityId);
        List<OrderTown> orderTowns = orderTownMapper.select(orderTown);
        List<TownVO> cityVOS = new ArrayList<>(orderTowns.size());
        for (OrderTown town : orderTowns) {
            TownVO vo = new TownVO();
            cityVOS.add(vo);
            vo.setTownId(town.getTownId());
            vo.setTown(town.getTownName());
        }
        return cityVOS;
    }


}
