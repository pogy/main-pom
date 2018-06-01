package com.shigu.main4.order.model.impl;

import com.openJar.requests.sgpay.OrderCashbackRechargeRequest;
import com.openJar.responses.sgpay.OrderCashbackRechargeResponse;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.examples.OrderPayExample;
import com.opentae.data.mall.examples.OrderPayRelationshipExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.SubOrderBO;
import com.shigu.main4.order.dto.TradeCountDTO;
import com.shigu.main4.order.enums.OrderStatus;
import com.shigu.main4.order.enums.OrderType;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.model.Sender;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.SubOrderStatus;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.tools.XzSdkClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品订单
 * Created by zhaohongbo on 17/6/1.
 */
@Repository
@Scope("prototype")
public class ItemOrderImpl implements ItemOrder {

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

    @Autowired
    private OrderPayRelationshipMapper orderPayRelationshipMapper;

    @Autowired
    private OrderPayMapper orderPayMapper;

    @Autowired
    private OrderStatusRecordMapper orderStatusRecordMapper;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private  XzSdkClient xzSdkClient;

    @Autowired
    private ShiguOrderCashbackMapper shiguOrderCashbackMapper;

    private static String ACTIVITY_ORDER_CASHBACK = "activity_order_cashback";


    /**
     * 订单ID
     */
    private Long oid;

    /**
     * 发送单位信息
     */
    private SenderVO senderVO;

    public ItemOrderImpl(Long oid) {
        this.oid = oid;
    }

    @Override
    public List<LogisticsVO> selLogisticses() {
        ItemOrderLogistics logistics = new ItemOrderLogistics();
        logistics.setOid(oid == null ? -1L : oid);
        List<ItemOrderLogistics> select = itemOrderLogisticsMapper.select(logistics);

        ItemOrderSub orderSub = new ItemOrderSub();
        orderSub.setOid(oid);
        Map<Long, List<ItemOrderSub>> longListMap = itemOrderSubMapper.select(orderSub).stream().collect(Collectors.groupingBy(ItemOrderSub::getLogisticsId));

        List<LogisticsVO> logisticsVOS = BeanMapper.mapList(select, LogisticsVO.class);
        logisticsVOS.forEach(logisticsVO -> {
            if (longListMap.get(logisticsVO.getId()) != null) {
                logisticsVO.setSoids(longListMap.get(logisticsVO.getId()).stream().map(ItemOrderSub::getSoid).collect(Collectors.toList()));
            }
        });
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
        orderVO.setTitle(order.getTitle());
        orderVO.setWebSite(order.getWebSite());
        orderVO.setOrderStatus(OrderStatus.statusOf(order.getOrderStatus()));
        orderVO.setCreateTime(order.getCreateTime());
        orderVO.setFinishTime(order.getFinishTime());
        orderVO.setOuterId(order.getOuterId());
        orderVO.setUserId(order.getUserId());
        orderVO.setTbSend(order.getTbSend());
        orderVO.setSendTime(order.getSendTime());
        orderVO.setPayTime(order.getPayTime());
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
            vo.setNum(vo.getNum());
            ItemProductVO info = SpringBeanFactory.getBean(ItemProduct.class, vo.getGoodsId(), vo.getColor(), vo.getSize()).info();
            vo.setProduct(info);
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addLogistics(List<Long> soids, LogisticsVO logistics,boolean needReprice) {
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        orderLogistics.setOid(oid);
        itemOrderLogisticsMapper.insertSelective(orderLogistics);
        if (needReprice) {
            // 重新计算订单总额
            recountTotalOrderAmount();
        }

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
    @Transactional(rollbackFor = Exception.class)
    public void modifyLogistics(Long id, LogisticsVO logistics) {
        logistics.setId(id);
        ItemOrderLogistics orderLogistics = BeanMapper.map(logistics, ItemOrderLogistics.class);
        itemOrderLogisticsMapper.updateByPrimaryKeySelective(orderLogistics);
        if (logistics.getMoney() != null) {
            recountTotalOrderAmount();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPackage(Long metarialId, Integer num,boolean needReprice) {
        MetarialVO metarialVO = orderConstantService.selMetarialById(selSender().getSenderId(), metarialId);
        ItemOrderPackage orderPackage = BeanMapper.map(metarialVO, ItemOrderPackage.class);
        orderPackage.setId(null);
        orderPackage.setNum(num);
        orderPackage.setMoney(metarialVO.getPrice());
        orderPackage.setOid(oid);
        orderPackage.setMetarialId(metarialId);
        itemOrderPackageMapper.insertSelective(orderPackage);
        if (needReprice) {
            recountTotalOrderAmount();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refundPackage(Long id, Long money) throws RefundException {
        ItemOrderPackage itemOrderPackage;
        if (id == null || (itemOrderPackage = itemOrderPackageMapper.selectByPrimaryKey(id)) == null || money == null) {
            throw new RefundException(String.format("退包材接口参数有误 id[%d], money[%d]", id, money));
        }
        Long packageMoney = itemOrderPackage.getMoney();
        Long refundMoney = itemOrderPackage.getRefundMoney();
        if (packageMoney - refundMoney > money) {
            refunds(money);
            ItemOrderPackage orderPackage = new ItemOrderPackage();
            orderPackage.setId(id);
            orderPackage.setRefundMoney(refundMoney + money);
            itemOrderPackageMapper.updateByPrimaryKeySelective(orderPackage);
        } else {
            throw new RefundException(String.format("包材费不足。包材费总额[%d], 已退[%d]", packageMoney, refundMoney));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addDfService(ServiceVO serviceVO, Long soid, Integer number,boolean needReprice) {
        // 记录订单服务信息
        ItemOrderService itemOrderService = BeanMapper.map(serviceVO, ItemOrderService.class);
        itemOrderService.setMoney(serviceVO.getPrice() * number);
        itemOrderService.setOid(oid);
        itemOrderService.setSoid(soid);
        itemOrderService.setServiceId(serviceVO.getId());
        itemOrderService.setId(null);
        itemOrderServiceMapper.insertSelective(itemOrderService);
        if (needReprice) {
            // 重新计算订单总额
            recountTotalOrderAmount();
        }
    }

    /**
     * 重新计算订单总额
     */
    private void recountTotalOrderAmount() {
        // 计算订单总额 = 子单总额 + 物流总额 + 发货服务总额 + 包材总额
        Long total = 0L;

        // 子单总额
        total += subOrdersInfo().stream().mapToLong(vo -> vo.getProduct().getPrice() * vo.getNum()).sum();

        // 其他费用
        total += orderOtherAmount();
        // TODO: 包材总额
        /*ItemOrderPackage orderPackage = new ItemOrderPackage();
        orderPackage.setOid(oid);
        for (ItemOrderPackage itemOrderPackage : itemOrderPackageMapper.select(orderPackage)) {
            total += itemOrderPackage.getMoney();
        }*/

        com.opentae.data.mall.beans.ItemOrder order = new com.opentae.data.mall.beans.ItemOrder();
        order.setOid(oid);
        order.setTotalFee(total);
        itemOrderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 除商品外的其他钱
     */
    public Long orderOtherAmount() {
        // 物流总额
        Long logisticsAmount = selLogisticses().stream().mapToLong(LogisticsVO::getMoney).sum();

        // 发货服务总额，每种服务都是按件计费 TODO: 不同市场代发费不同，
        return logisticsAmount + selServices().stream().mapToLong(OrderServiceVO::getMoney).sum();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refundService(Long id, Long money) throws RefundException {
        ItemOrderService orderService;
        if (id == null || (orderService = itemOrderServiceMapper.selectByPrimaryKey(id)) == null || money == null) {
            throw new RefundException(String.format("退服务接口参数有误 id[%d], money[%d]", id, money));
        }
        Long refundMoney = orderService.getRefundMoney();
        Long serviceMoney = orderService.getMoney();
        if (serviceMoney - refundMoney > money) {
            refunds(money);
            ItemOrderService os = new ItemOrderService();
            os.setId(id);
            os.setRefundMoney(refundMoney + money);
            itemOrderServiceMapper.updateByPrimaryKeySelective(os);
        } else {
            throw new RefundException(String.format("服务费不足。服务费总额[%d], 已退[%d]", serviceMoney, refundMoney));
        }
    }

    @Override
    public List<OrderServiceVO> selServices() {
        ItemOrderService itemOrderService = new ItemOrderService();
        itemOrderService.setOid(oid);
        return BeanMapper.mapList(itemOrderServiceMapper.select(itemOrderService), OrderServiceVO.class);
    }

    @Override
    public void sended(String courierNumber) {
        List<LogisticsVO> logisticsVOS = selLogisticses();
        if (logisticsVOS.size() == 1) {
            ItemOrderLogistics logistics = new ItemOrderLogistics();
            logistics.setId(logisticsVOS.get(0).getId());
            logistics.setCourierNumber(courierNumber);
            itemOrderLogisticsMapper.updateByPrimaryKeySelective(logistics);
        }

        changeStatus(OrderStatus.SELLER_SENDED_GOODS);
    }

    @Override
    public void sendPart(Long logisticsId, List<Long> soids, String courierNumber) {

    }

    @Override
    public SenderVO selSender() {
        if (senderVO == null) {
            senderVO = SpringBeanFactory.getBean(Sender.class, orderInfo().getSenderId()).senderInfo();
        }
        return senderVO;
    }

    @Override
    public PayApplyVO payApply(PayType payType) throws PayApplyException {
        ItemOrderVO orderInfo = orderInfo();
        return SpringBeanFactory.getBean(payType.getService(), PayerService.class).payApply(orderInfo.getUserId(), orderInfo.getTotalFee(), orderInfo.getTitle(),orderInfo.getOrderId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSubOrder(List<SubOrderBO> subOrders,boolean needReprice) throws OrderException {
        for (SubOrderBO bo : subOrders) {
            ItemOrderSub sub=new ItemOrderSub();
            ItemProduct product = SpringBeanFactory.getBean(ItemProduct.class, bo.getPid(), bo.getSkuId());
            sub.setPid(product.getPid());
            sub.setSkuId(product.getSkuId());
            sub.setNum(bo.getNumber());
            ItemProductVO info = product.info();
            BeanMapper.map(info, sub);
            // 应付总价 产品单价 X 数量
            sub.setColor(info.getSelectiveSku().getColor());
            sub.setSize(info.getSelectiveSku().getSize());
            sub.setWeight(product.selWeight());
            sub.setShouldPayMoney(sub.getPrice() * sub.getNum());
            sub.setRefundMoney(0L);
            sub.setStatus(SubOrderStatus.ORIGINAL.status);
            sub.setOid(oid);
//            if(StringUtils.isEmpty(sub.getGoodsNo())){
//                throw new OrderException("没有货号不允许下单，请先联系商家补全货号");
//            }
            itemOrderSubMapper.insertSelective(sub);
        }
        if (needReprice) {
            recountTotalOrderAmount();
        }
    }

    @Override
    public PayApplyVO repayApply(PayType type) {
        return null;
    }

    /**
     * 已支付的情况查询
     *
     * @return
     */
    @Override
    public List<PayedVO> payedInfo() {
        List<PayedVO> payedVOS = new ArrayList<>();
        OrderPayRelationshipExample orderPayRelationshipExample = new OrderPayRelationshipExample();
        orderPayRelationshipExample.createCriteria().andOidEqualTo(oid);
        List<OrderPayRelationship> orderPayRelationships = orderPayRelationshipMapper.selectByExample(orderPayRelationshipExample);
        List<Long> payIds = BeanMapper.getFieldList(orderPayRelationships, "payId", Long.class);
        if (payIds.size() > 0) {
            OrderPayExample orderPayExample = new OrderPayExample();
            orderPayExample.createCriteria().andPayIdIn(payIds);
            List<OrderPay> orderPays = orderPayMapper.selectByExample(orderPayExample);
            List<PayedVO> payedVOS1 = BeanMapper.mapList(orderPays, PayedVO.class);
            Map<Long, OrderPay> type = BeanMapper.list2Map(orderPays, "payId", Long.class);
            for (PayedVO o : payedVOS1) {
                o.setPayType(PayType.valueOf(type.get(o.getPayId()).getType()));
            }
            payedVOS.addAll(payedVOS1);
        }
        return payedVOS;
    }

    @Override
    public void refunds(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }

    @Override
    public void payed() {
        com.opentae.data.mall.beans.ItemOrder order=itemOrderMapper.selectFieldsByPrimaryKey(oid,
                FieldUtil.codeFields("oid,total_fee"));
        payed(order.getTotalFee());
        countTrade();
    }

    @Override
    public void payed(Long payMoney) {
        com.opentae.data.mall.beans.ItemOrder order=new com.opentae.data.mall.beans.ItemOrder();
        order.setOid(oid);
        order.setPayedFee(payMoney);
        order.setPayTime(new Date());
        itemOrderMapper.updateByPrimaryKeySelective(order);
        changeStatus(OrderStatus.BUYER_PAYED);
    }

    @Override
    public void finished() {
        changeStatus(OrderStatus.TRADE_FINISHED);

        Boolean b = Boolean.parseBoolean(redisIO.get(ACTIVITY_ORDER_CASHBACK,String.class));
        if (b != null && b){
            OrderCashbackRechargeRequest request = new OrderCashbackRechargeRequest();
            request.setXzUserId(itemOrderSubMapper.selectUserIdByOid(oid));
            request.setCashbackOrderNo(oid);
            List<OrderSubMoney> orderSubMoneyList = itemOrderSubMapper.selectOrderSubByOid(oid);
            Long money = 0l;
            if (orderSubMoneyList!=null||orderSubMoneyList.size()>0){
                for (int i = 0; i <orderSubMoneyList.size() ; i++) {
                    money = orderSubMoneyList.get(i).getNum()*orderSubMoneyList.get(i).getPrice()+money;
                }
                Long refund = itemOrderSubMapper.selectRefundByOid(oid);
                if (refund != null && refund > 0)
                    money = money-refund;
            }
            if (money>0) {
                request.setCashbackAmount(money / 100);
                ShiguOrderCashback shiguOrderCashback = new ShiguOrderCashback();
                shiguOrderCashback.setOId(oid);
                shiguOrderCashback.setCashback(money / 100);
                shiguOrderCashbackMapper.insertSelective(shiguOrderCashback);
                OrderCashbackRechargeResponse resp = xzSdkClient.getPcOpenClient().execute(request);
                if (resp == null || !resp.isSuccess()) {
                    try {
                        throw new RefundException("订单返现失败：oid=" + oid);
                    } catch (RefundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void closed() {
        if(selOrderStatus().equals(OrderStatus.WAIT_BUYER_PAY))
        changeStatus(OrderStatus.TRADE_CLOSED);
    }

    @Override
    public void remove() {
        OrderStatus nowStatus=selOrderStatus();
        if(nowStatus.equals(OrderStatus.TRADE_CLOSED)||nowStatus.equals(OrderStatus.TRADE_FINISHED)) {
            com.opentae.data.mall.beans.ItemOrder order = new com.opentae.data.mall.beans.ItemOrder();
            order.setOid(oid);
            order.setDisenable(true);
            itemOrderMapper.updateByPrimaryKeySelective(order);
        }
    }

    /**
     * 改状态
     *
     * @param status
     */
    private void changeStatus(OrderStatus status) {
        OrderStatusRecord record = new OrderStatusRecord();
        record.setCreateTime(new Date());
        record.setOid(oid);
        record.setStatus(status.status);
        orderStatusRecordMapper.insertSelective(record);
        com.opentae.data.mall.beans.ItemOrder order = new com.opentae.data.mall.beans.ItemOrder();
        order.setOid(oid);
        order.setOrderStatus(status.status);
        if(status==OrderStatus.SELLER_SENDED_GOODS){
            order.setSendTime(new Date());
        }
        itemOrderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 查本单的状态
     * @return
     */
    private OrderStatus selOrderStatus(){
        com.opentae.data.mall.beans.ItemOrder order=itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,order_status"));
        return OrderStatus.statusOf(order.getOrderStatus());
    }

    /**
     * 推送商品销量增值
     */
    private void countTrade(){
        ItemOrderSub itemOrderSub = new ItemOrderSub();
        itemOrderSub.setOid(oid);
        List<ItemOrderSub> select = itemOrderSubMapper.select(itemOrderSub);
        for (ItemOrderSub orderSub : select) {
            TradeCountDTO tradeCountDTO = new TradeCountDTO();
            tradeCountDTO.setGoodsId(orderSub.getGoodsId());
            tradeCountDTO.setNum(orderSub.getNum());
            redisIO.rpush(TradeCountDTO.TRADE_COUNT_REDIS_QUEUE_,tradeCountDTO);
        }
    }

}
