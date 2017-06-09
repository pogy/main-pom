package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemOrderLogistics;
import com.opentae.data.mall.beans.ItemOrderPackage;
import com.opentae.data.mall.beans.ItemOrderService;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderPackageMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    @Override
    public ItemOrderVO orderInfo() {
        return null;
    }

    @Override
    public List<SubItemOrderVO> subOrdersInfo() {
        return null;
    }

    @Override
    public Long addLogistics(List<Long> soids,LogisticsVO logistics) {
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        itemOrderLogisticsMapper.insertSelective(orderLogistics);

        // TODO：重新计算订单总额
        // do something...

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

    }

    @Override
    public void addPackage(Long metarialId,Integer num) {
        Long sender = 0L;// TODO: UNKNOWN sender
        MetarialVO metarialVO = orderConstantService.selMetarialById(sender, metarialId);
        ItemOrderPackage orderPackage = BeanMapper.map(metarialVO, ItemOrderPackage.class);
        orderPackage.setNum(num);
        orderPackage.setMoney(metarialVO.getPrice());
        orderPackage.setOid(oid);
        //orderPackage.setSize...  VO 中多一个size属性，bean中没有对应

        itemOrderPackageMapper.insertSelective(orderPackage);

        // TODO: 重新计算订单总额 ？
    }

    @Override
    public void refundPackage(Long id, Long money) {

    }

    @Override
    public void addService(Long serviceId) {
        // 记录订单服务信息
        Long sender = 0L;// TODO: UNKNOWN sender
        ServiceVO serviceVO = orderConstantService.selServiceById(sender, serviceId);
        ItemOrderService itemOrderService = BeanMapper.map(serviceVO, ItemOrderService.class);
        itemOrderService.setMoney(serviceVO.getPrice());
        itemOrderService.setOid(oid);
        itemOrderServiceMapper.insertSelective(itemOrderService);

        // TODO:重新计算订单总额
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

        // TODO：重新计算订单总额
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
