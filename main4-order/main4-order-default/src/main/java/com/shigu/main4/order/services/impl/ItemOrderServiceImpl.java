package com.shigu.main4.order.services.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.BuyerAddress;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.OrderIdGenerator;
import com.opentae.data.mall.examples.BuyerAddressExample;
import com.opentae.data.mall.interfaces.BuyerAddressMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.OrderIdGeneratorMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.*;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.exceptions.BuyerAddressException;
import com.shigu.main4.order.model.SubOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import com.shigu.main4.order.vo.SubOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品订单服务
 * Created by zhaohongbo on 17/6/2.
 */
@Service("itemOrderService")
public class ItemOrderServiceImpl implements ItemOrderService{

    private static final Logger logger = LoggerFactory.getLogger(ItemOrderServiceImpl.class);

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private OrderIdGeneratorMapper orderIdGeneratorMapper;

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;

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
     * @param userId
     * @return 买家现有地址列表
     */
    @Override
    public List<BuyerAddressVO> selBuyerAddress(Long userId) {
        List<BuyerAddressVO> buyerAddressVOS = new ArrayList<BuyerAddressVO>(5);
        BuyerAddressExample buyerAddressExample = new BuyerAddressExample();
        buyerAddressExample.createCriteria().andUserIdEqualTo(userId);
        List<BuyerAddress> buyerAddresses = buyerAddressMapper.selectByExample(buyerAddressExample);
        BuyerAddressVO buyerAddressVO = null;
        for (BuyerAddress buyerAddress:buyerAddresses) {
            buyerAddressVO = BeanMapper.map(buyerAddress, BuyerAddressVO.class);
            buyerAddressVO.setProvince(buyerAddress.getProvName());
            buyerAddressVO.setCity(buyerAddress.getCityName());
            buyerAddressVO.setTown(buyerAddress.getTownName());
            buyerAddressVOS.add(buyerAddressVO);
        }
        return buyerAddressVOS;
    }

    /**
     * 保存地址，BuyerAddressVO中信息不足则会失败，用户已有超过5条地址则会覆盖最老地址
     * @param buyerAddressVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBuyerAddress(BuyerAddressVO buyerAddressVO) {
        //信息不足
        boolean isInformationInsufficient = buyerAddressVO.getProvId()==null || buyerAddressVO.getCityId()==null || buyerAddressVO.getTownId()==null ||
                StringUtil.isNull(buyerAddressVO.getAddress()) || buyerAddressVO.getUserId()==null || StringUtil.isNull(buyerAddressVO.getTelephone()) ||
                StringUtil.isNull(buyerAddressVO.getName()) || StringUtil.isNull(buyerAddressVO.getProvince()) || StringUtil.isNull(buyerAddressVO.getCity()) ||
                StringUtil.isNull(buyerAddressVO.getTown());
        if (isInformationInsufficient) {
            try {
                throw new BuyerAddressException("信息不足");
            } catch (BuyerAddressException e) {
                logger.error("买家地址存储失败",e);
            } finally {
                return;
            }
        }
        BuyerAddressExample buyerAddressExample = new BuyerAddressExample();
        buyerAddressExample.createCriteria().andUserIdEqualTo(buyerAddressVO.getUserId());
        buyerAddressExample.setOrderByClause("address_id asc");
        List<Long> userAddressIds = BeanMapper.getFieldList(buyerAddressMapper.selectFieldsByExample(buyerAddressExample,"address_id"),
                "addressId", Long.class);
        while (userAddressIds.size() >= 5) {
            rmBuyerAddress(userAddressIds.get(0));
            userAddressIds.remove(0);
        }
        BuyerAddress buyerAddress = BeanMapper.map(buyerAddressVO,BuyerAddress.class);
        buyerAddress.setAddressId(null);
        buyerAddress.setProvName(buyerAddressVO.getProvince());
        buyerAddress.setCityName(buyerAddressVO.getCity());
        buyerAddress.setTownName(buyerAddressVO.getTown());
        buyerAddressMapper.insert(buyerAddress);
    }

    /**
     * 删除地址
     * @param addressId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rmBuyerAddress(Long addressId) {
        buyerAddressMapper.deleteByPrimaryKey(addressId);
    }
}
