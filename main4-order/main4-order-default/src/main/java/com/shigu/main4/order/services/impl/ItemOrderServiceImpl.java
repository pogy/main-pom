package com.shigu.main4.order.services.impl;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.SubOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商品订单服务
 * Created by zhaohongbo on 17/6/2.
 */
@Service("itemOrderService")
public class ItemOrderServiceImpl implements ItemOrderService{

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(ItemOrderBO orderBO) {
        // 初始化一个订单
        ItemOrder order = BeanMapper.map(orderBO, ItemOrder.class);
        order.setType(1);
        order.setTotalFee(0L);
        order.setPayedFee(0L);
        order.setRefundFee(0L);
        order.setOrderStatus(1);
        itemOrderMapper.insertSelective(order);

        // 获取订单操作接口
        com.shigu.main4.order.model.ItemOrder itemOrder
                = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, order.getOid());

        // a, 添加物流
        LogisticsBO logistics = orderBO.getLogistics();
//        itemOrder.addLogistics(Arrays.asList(order.getOid()), );

        // b, 添加服务
        for (Long sid : orderBO.getServiceIds()) {
            itemOrder.addService(sid);
        }

        // c, 添加包材
        for (PackageBO packageBO : orderBO.getPackages()) {
            itemOrder.addPackage(packageBO.getMetarialId(), packageBO.getNum());
        }

        // d, 添加子订单
        List<SubOrderVO> subOrders = new ArrayList<>();
        for (SubItemOrderBO subItemOrderBO : orderBO.getSubOrders()) {
//            subOrders.add(someThing)
        }
        itemOrder.addSubOrder(subOrders);
        return null;
    }

    @Override
    public Long calculateLogisticsFee(Long senderId, Long companyId, Long provId,List<PidNumBO> pids) {
        return null;
    }
}
