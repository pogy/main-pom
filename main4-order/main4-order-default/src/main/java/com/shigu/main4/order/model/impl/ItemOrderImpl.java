package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.enums.SubOrderStatus;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 商品订单
 * Created by zhaohongbo on 17/6/1.
 */
@Repository
@Scope("prototype")
public class ItemOrderImpl implements ItemOrder{

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;

    @Autowired
    private ItemOrderPackageMapper itemOrderPackageMapper;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;

    @Autowired
    private OrderConstantService orderConstantService;

    /**
     * 订单ID
     */
    private Long oid;

    /**
     * 发送单位信息
     */
    private SenderVO senderVO;

    public ItemOrderImpl(Long oid) {
        this.oid=oid;
    }

    @Override
    public List<LogisticsVO> selLogisticses() {
        ItemOrderLogistics logistics = new ItemOrderLogistics();
        logistics.setOid(oid);
        List<ItemOrderLogistics> select = itemOrderLogisticsMapper.select(logistics);

        ItemOrderSub orderSub = new ItemOrderSub();
        orderSub.setOid(oid);
        Map<Long, List<ItemOrderSub>> logisticsGroup = BeanMapper.groupBy(itemOrderSubMapper.select(orderSub), "logisticsId", Long.class);
        List<LogisticsVO> logisticsVOS = BeanMapper.mapList(select, LogisticsVO.class);
        for (LogisticsVO logisticsVO : logisticsVOS) {
            logisticsVO.setSoids(BeanMapper.getFieldList(logisticsGroup.get(logisticsVO.getId()), "soid", Long.class));
        }
        return logisticsVOS;
    }

    @Override
    public ItemOrderVO orderInfo() {
        com.opentae.data.mall.beans.ItemOrder order = itemOrderMapper.selectByPrimaryKey(oid);
        ItemOrderVO orderVO = new ItemOrderVO();
        orderVO.setSenderId(order.getSenderId());
        orderVO.setTotalFee(order.getTotalFee());
        orderVO.setRefundFee(order.getRefundFee());
        orderVO.setPayedFee(order.getPayedFee());
        orderVO.setType(OrderType.typeOf(order.getType()));
        orderVO.setOrderId(order.getOid());
        orderVO.setOrderStatus(OrderStatus.statusOf(order.getOrderStatus()));
        return orderVO;
    }

    @Override
    public List<SubItemOrderVO> subOrdersInfo() {
        ItemOrderSub sub = new ItemOrderSub();
        sub.setOid(oid);
        List<ItemOrderSub> select = itemOrderSubMapper.select(sub);
        Map<Long, ItemOrderSub> subOrderMap = BeanMapper.list2Map(select, "soid", Long.class);
        List<SubItemOrderVO> vos = BeanMapper.mapList(select, SubItemOrderVO.class);
        for (SubItemOrderVO vo : vos) {
            ItemOrderSub orderSub = subOrderMap.get(vo.getSoid());
            vo.setSubOrderStatus(SubOrderStatus.statusOf(orderSub.getStatus()));
            vo.setNumber(vo.getNum());
            vo.setProduct(BeanMapper.map(orderSub, ItemProductVO.class));
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addLogistics(List<Long> soids,LogisticsVO logistics) {
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        orderLogistics.setOid(oid);
        itemOrderLogisticsMapper.insertSelective(orderLogistics);

        // 重新计算订单总额
        recountTotalOrderAmount();

        // 子订单设置物流关联
        if (soids != null && !soids.isEmpty()) {
            ItemOrderSubExample subExample = new ItemOrderSubExample();
            subExample.createCriteria().andSoidIn(soids).andOidEqualTo(oid);
            ItemOrderSub sub = new ItemOrderSub();
            sub.setLogisticsId(orderLogistics.getId());
            itemOrderSubMapper.updateByExampleSelective(sub, subExample);
        }
        return orderLogistics.getId();
    }

    @Override
    public void modifyLogistics(Long id, LogisticsVO logistics) {
        logistics.setId(id);
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        itemOrderLogisticsMapper.updateByPrimaryKeySelective(orderLogistics);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPackage(Long metarialId,Integer num) {
        MetarialVO metarialVO = orderConstantService.selMetarialById(selSender().getSenderId(), metarialId);
        ItemOrderPackage orderPackage = BeanMapper.map(metarialVO, ItemOrderPackage.class);
        orderPackage.setId(null);
        orderPackage.setNum(num);
        orderPackage.setMoney(metarialVO.getPrice());
        orderPackage.setOid(oid);
        orderPackage.setMetarialId(metarialId);
        itemOrderPackageMapper.insertSelective(orderPackage);

        recountTotalOrderAmount();
    }

    @Override
    public void refundPackage(Long id, Long money) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addService(Long serviceId) {
        // 记录订单服务信息
        ServiceVO serviceVO = orderConstantService.selServiceById(selSender().getSenderId(), serviceId);
        ItemOrderService itemOrderService = BeanMapper.map(serviceVO, ItemOrderService.class);
        itemOrderService.setMoney(serviceVO.getPrice());
        itemOrderService.setOid(oid);
        itemOrderService.setServiceId(serviceId);
        itemOrderServiceMapper.insertSelective(itemOrderService);

        // 重新计算订单总额
        recountTotalOrderAmount();
    }

    /**
     * 重新计算订单总额
     */
    private void recountTotalOrderAmount() {
        // 计算订单总额 = 子单总额 + 物流总额 + 发货服务总额 + 包材总额
        Long total = 0L;

        // 子单总额
        for (SubItemOrderVO subItemOrderVO : subOrdersInfo()) {
            total += subItemOrderVO.getProduct().getPrice();
        }
        // 物流总额
        for (LogisticsVO logisticsVO : selLogisticses()) {
            total += logisticsVO.getMoney();
        }

        // 发货服务总额
        ItemOrderService service = new ItemOrderService();
        service.setOid(oid);
        for (ItemOrderService orderService : itemOrderServiceMapper.select(service)) {
            total += orderService.getMoney();
        }

        // 包材总额
        ItemOrderPackage orderPackage = new ItemOrderPackage();
        orderPackage.setOid(oid);
        for (ItemOrderPackage itemOrderPackage : itemOrderPackageMapper.select(orderPackage)) {
            total += itemOrderPackage.getMoney();
        }

        com.opentae.data.mall.beans.ItemOrder order = new com.opentae.data.mall.beans.ItemOrder();
        order.setOid(oid);
        order.setTotalFee(total);
        itemOrderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void refundService(Long id, Long money) {

    }

    @Override
    public void sended(String courierNumber) {

    }

    @Override
    public void sendPart(Long logisticsId, List<Long> soids, String courierNumber) {

    }

    @Override
    public SenderVO selSender() {
        if (senderVO == null) {
//            com.opentae.data.mall.beans.ItemOrder itemOrder TODO: 按实现类中的oid，查询item_order.outer_id ?
            ItemOrderSender itemOrderSender = itemOrderSenderMapper.selectByPrimaryKey(orderInfo().getSenderId());
            senderVO = BeanMapper.map(itemOrderSender, SenderVO.class);
        }
        return senderVO;
    }

    @Override
    public PayApplyVO payApply(PayType payType) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSubOrder(List<SubOrderVO> subOrders) {
        List<ItemOrderSub> subs = BeanMapper.mapList(subOrders, ItemOrderSub.class);
        for (ItemOrderSub sub : subs) {
            ItemProduct product = SpringBeanFactory.getBean(ItemProduct.class, sub.getGoodsId(), sub.getColor(), sub.getSize());
            sub.setPid(product.getPid());
            sub.setSkuId(product.getSkuId());
            ItemProductVO info = product.info();
            sub.setWebSite(info.getWebSite());
            sub.setPicUrl(info.getPicUrl());
            sub.setTitle(info.getTitle());
            sub.setPrice(info.getPrice());
            sub.setWeight(info.getWeight());

            sub.setDistributionNum(0);
            // 应付总价 产品单价 X 数量
            sub.setShouldPayMoney(sub.getPrice() * sub.getNum());
            sub.setPayMoney(0L);
            sub.setRefundMoney(0L);
            sub.setStatus(SubOrderStatus.ORIGINAL.status);
            sub.setOid(oid);
            itemOrderSubMapper.insertSelective(sub);
        }

        recountTotalOrderAmount();
    }

    @Override
    public PayApplyVO repayApply(PayType type) {
        return null;
    }

    @Override
    public Long pay(Long applyId, Long money) {
        return null;
    }

    @Override
    public void refunds(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }

    @Override
    public void payed() {

    }

    @Override
    public void finished() {

    }

    @Override
    public void closed() {

    }
}
