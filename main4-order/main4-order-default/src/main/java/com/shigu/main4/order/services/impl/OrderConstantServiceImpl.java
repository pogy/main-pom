package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.OrderConstant;
import com.opentae.data.mall.interfaces.OrderConstantMapper;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.MetarialVO;
import com.shigu.main4.order.vo.OrderConstantVo;
import com.shigu.main4.order.vo.ServiceVO;
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
            List<OrderConstantVo> orderConstants = orderConstantsMap.get(senderId);
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
}
