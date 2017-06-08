package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemOrderLogistics;
import com.opentae.data.mall.beans.ItemOrderPackage;
import com.opentae.data.mall.beans.ItemOrderService;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;

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
    private OrderConstantService orderConstantService;

    /**
     * 订单ID
     */
    private Long oid;

    public ItemOrderImpl(Long oid) {
        this.oid=oid;
    }

    @Override
    public List<LogisticsVO> selLogisticses() {
        ItemOrderLogistics logistics = new ItemOrderLogistics();
        logistics.setOid(oid);
        List<ItemOrderLogistics> select = itemOrderLogisticsMapper.select(logistics);
        Map<Long, ItemOrderLogistics> logisticsMap = BeanMapper.list2Map(select, "id", Long.class);

        List<LogisticsVO> logisticsVOS = BeanMapper.mapList(select, LogisticsVO.class);
        for (LogisticsVO logisticsVO : logisticsVOS) {
            ItemOrderLogistics orderLogistics = logisticsMap.get(logisticsVO.getId());

        }
        return logisticsVOS;
    }

    @Override
    public ItemOrderVO orderInfo() {
        com.opentae.data.mall.beans.ItemOrder order = itemOrderMapper.selectByPrimaryKey(oid);
        ItemOrderVO orderVO = BeanMapper.map(order, ItemOrderVO.class);
        orderVO.setType(OrderType.typeOf(order.getType()));
        orderVO.setOrderId(order.getOid());
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

        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addLogistics(List<Long> soids,LogisticsVO logistics) {
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        itemOrderLogisticsMapper.insertSelective(orderLogistics);

        // 重新计算订单总额
        recountTotalOrderAmount(selSender().getSenderId());

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
        Long senderId = selSender().getSenderId();
        MetarialVO metarialVO = orderConstantService.selMetarialById(senderId, metarialId);
        ItemOrderPackage orderPackage = BeanMapper.map(metarialVO, ItemOrderPackage.class);
        orderPackage.setNum(num);
        orderPackage.setMoney(metarialVO.getPrice());
        orderPackage.setOid(oid);
        //orderPackage.setSize...  VO 中多一个size属性，bean中没有对应

        itemOrderPackageMapper.insertSelective(orderPackage);

        recountTotalOrderAmount(senderId);
    }

    @Override
    public void refundPackage(Long id, Long money) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addService(Long serviceId) {
        // 记录订单服务信息
        Long senderId = selSender().getSenderId();
        ServiceVO serviceVO = orderConstantService.selServiceById(senderId, serviceId);
        ItemOrderService itemOrderService = BeanMapper.map(serviceVO, ItemOrderService.class);
        itemOrderService.setMoney(serviceVO.getPrice());
        itemOrderService.setOid(oid);
        itemOrderServiceMapper.insertSelective(itemOrderService);

        // 重新计算订单总额
        recountTotalOrderAmount(senderId);
    }

    /**
     * TODO:重新计算订单总额
     * @param senderId 发货机构ID
     */
    private void recountTotalOrderAmount(Long senderId) {
        // 计算订单总额 = 子单总额 + 物流总额 + 发货服务总额 + 包材总额
        Long total = 0L;

        // 子单总额
        for (SubItemOrderVO subItemOrderVO : subOrdersInfo()) {
//            total += subItemOrderVO.getProduct().getPrice();
        }
        // 物流总额
        for (LogisticsVO logisticsVO : selLogisticses()) {
            total += logisticsVO.getMoney();
        }

        // 发货服务总额
        for (ServiceVO serviceVO : orderConstantService.selServices(senderId)) {
            total += serviceVO.getPrice();
        }

        for (MetarialVO metarialVO : orderConstantService.selMetarials(senderId)) {
            total += metarialVO.getPrice();
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
        return null;
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
            sub.setDistributionNum(0);
            // 应付总价 产品单价 X 数量
//            sub.setShouldPayMoney(sub.getPayMoney() * sub.getNum());
            sub.setPayMoney(0L);
            sub.setRefundMoney(0L);
            sub.setSend(false);
            sub.setRefund(false);
        }
        itemOrderSubMapper.insertListNoId(subs);

        recountTotalOrderAmount(selSender().getSenderId());
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
