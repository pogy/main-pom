package com.shigu.main4.order.services.impl;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.OrderIdGenerator;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.OrderIdGeneratorMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.model.SubOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
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

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;



    /**
     * oid获取器
     *
     * @param type
     * @return
     */
    @Override
    public Long idGenerator(OrderType type) {
        OrderIdGenerator idGenerator = new OrderIdGenerator();
        idGenerator.setType(type.type);
        orderIdGeneratorMapper.insertSelective(idGenerator);
        return idGenerator.getOid();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createOrder(ItemOrderBO orderBO) {
        // 初始化一个订单
        ItemOrder order = BeanMapper.map(orderBO, ItemOrder.class);
        order.setType(OrderType.XZ.type);
        order.setTotalFee(0L);
        order.setPayedFee(0L);
        order.setRefundFee(0L);
        order.setOrderStatus(OrderStatus.WAIT_BUYER_PAY.status);
        order.setOid(idGenerator(OrderType.XZ));
        itemOrderMapper.insertSelective(order);

        // 获取订单操作接口
        com.shigu.main4.order.model.ItemOrder itemOrder
                = SpringBeanFactory.getBean(com.shigu.main4.order.model.ItemOrder.class, order.getOid());

        // a, 添加物流
        LogisticsBO logistics = orderBO.getLogistics();
//        itemOrder.addLogistics(logistics.getArrays.asList(order.getOid()), );

        // b, 添加服务
        if (orderBO.getServiceIds() != null) {
            for (Long sid : orderBO.getServiceIds()) {
                itemOrder.addService(sid);
            }
        }

        // c, 添加包材
        if (orderBO.getPackages() != null) {
            for (PackageBO packageBO : orderBO.getPackages()) {
                itemOrder.addPackage(packageBO.getMetarialId(), packageBO.getNum());
            }
        }

        // d, 添加子订单
        if (orderBO.getSubOrders() != null) {
            List<SubOrderVO> subOrders = new ArrayList<>();
            for (SubItemOrderBO subItemOrderBO : orderBO.getSubOrders()) {
                SubOrderVO vo = new SubOrderVO();
                vo.setNum(subItemOrderBO.getNum());
                vo.setMark(subItemOrderBO.getMark());
                ItemProductVO productVO = subItemOrderBO.getProductVO();
                vo.setGoodsId(productVO.getGoodsId());
                ItemSkuVO selectiveSku = productVO.getSelectiveSku();
                vo.setSize(selectiveSku.getSize());
                vo.setColor(selectiveSku.getColor());
                subOrders.add(vo);
            }
            itemOrder.addSubOrder(subOrders);
        }
        return order.getOid();
    }

    @Override
    public Long calculateLogisticsFee(Long senderId, Long companyId, Long provId,List<PidNumBO> pids) {
        return null;
    }

    /**
     * 查询买家有的地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<BuyerAddressVO> selBuyerAddress(Long userId) {
        return null;
    }

    /**
     * 保存地址
     *
     * @param buyerAddressVO
     */
    @Override
    public void saveBuyerAddress(BuyerAddressVO buyerAddressVO) {

    }

    /**
     * 删除地址
     *
     * @param addressId
     */
    @Override
    public void rmBuyerAddress(Long addressId) {

    }
}
