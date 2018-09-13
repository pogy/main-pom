package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
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
import com.shigu.main4.order.services.SellerMsgService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.SubOrderStatus;
import com.shigu.main4.pay.requests.XzbInviteRechargeRequest;
import com.shigu.main4.pay.requests.XzbOrderCashBackRequest;
import com.shigu.main4.pay.responses.XzbInviteRechargeResponse;
import com.shigu.main4.pay.responses.XzbOrderCashBackResponse;
import com.shigu.main4.pay.services.XzbService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.tools.XzSdkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
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

    @Autowired
    private ItemVoucherMapper itemVoucherMapper;

    @Autowired
    private ItemOrderVoucherRelationMapper itemOrderVoucherRelationMapper;

    @Autowired
    private ShiguRebateTypeMapper shiguRebateTypeMapper;

    @Autowired
    private ShiguRebateGoodsMapper shiguRebateGoodsMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private MemberInviteMapper memberInviteMapper;

    @Autowired
    private InviteOrderRebateRecordMapper inviteOrderRebateRecordMapper;

    @Autowired
    private SellerMsgService sellerMsgService;

    @Autowired
    private XzbService xzbService;

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
        orderVO.setRealVoucherAmount(order.getRealVoucherAmount());
        orderVO.setTotalFeeWithoutVoucher(order.getTotalFeeWithoutVoucher());
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
            ItemProductVO info = SpringBeanFactory.getBean(ItemProduct.class,orderSub.getPid(),orderSub.getSkuId()).info();
            info.setPrice(orderSub.getPrice());
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

        // TODO: 包材总额
        /*ItemOrderPackage orderPackage = new ItemOrderPackage();
        orderPackage.setOid(oid);
        for (ItemOrderPackage itemOrderPackage : itemOrderPackageMapper.select(orderPackage)) {
            total += itemOrderPackage.getMoney();
        }*/
        // 优惠/代金券计算
        // 优惠券总金额
        long voucherAmount = voucherInfo().stream().mapToLong(VoucherVO::getVoucherAmount).sum();
        // 实际优惠总金额不高于商品总金额
        long realVoucherAmount = voucherAmount < total? voucherAmount: (total - 1L);
        // 其他费用
        total += orderOtherAmount();
        com.opentae.data.mall.beans.ItemOrder order = new com.opentae.data.mall.beans.ItemOrder();
        order.setOid(oid);
        order.setTotalFeeWithoutVoucher(total);
        order.setTotalFee(total - realVoucherAmount);
        order.setRealVoucherAmount(realVoucherAmount);
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
    public void updateExpressCode(String courierNumber){
        List<LogisticsVO> logisticsVOS = selLogisticses();
        if (logisticsVOS.size() == 1) {
            ItemOrderLogistics logistics = new ItemOrderLogistics();
            logistics.setId(logisticsVOS.get(0).getId());
            logistics.setCourierNumber(courierNumber);
            itemOrderLogisticsMapper.updateByPrimaryKeySelective(logistics);
        }
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
    public void addSubOrder(List<SubOrderBO> subOrders,boolean needReprice,Long userId) throws OrderException {
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

        try {
            sellerMsgService.pushNewOrderMsg(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 实际使用代金券
        realUseVoucher();
        changeStatus(OrderStatus.BUYER_PAYED);
    }

    @Override
    public void finished() {
        changeStatus(OrderStatus.TRADE_FINISHED);
        Date date = itemOrderMapper.selectByPrimaryKey(oid).getPayTime();
        if (date.getTime() - 1527782400000L > 0){
            Boolean b = Boolean.parseBoolean(redisIO.get(ACTIVITY_ORDER_CASHBACK, String.class));
            if (b != null && b) {
                XzbOrderCashBackRequest request = new XzbOrderCashBackRequest();
                request.setXzUserId(itemOrderSubMapper.selectUserIdByOid(oid));
                request.setCashbackOrderNo(oid);
                List<OrderSubMoney> orderSubMoneyList = itemOrderSubMapper.selectOrderSubByOid(oid);
                Long money = 0l;
                if (orderSubMoneyList != null || orderSubMoneyList.size() > 0) {
                    for (int i = 0; i < orderSubMoneyList.size(); i++) {
                        money = orderSubMoneyList.get(i).getNum() * orderSubMoneyList.get(i).getPrice() + money;
                    }
                    Long refund = itemOrderSubMapper.selectRefundByOid(oid);
                    if (refund != null && refund > 0)
                        money = money - refund;
                }
                if (money > 0) {
                    request.setCashbackAmount(money / 100);
                    ShiguOrderCashback shiguOrderCashback = new ShiguOrderCashback();
                    shiguOrderCashback.setOId(oid);
                    shiguOrderCashback.setCashback(money / 100);
                    shiguOrderCashbackMapper.insertSelective(shiguOrderCashback);
                    XzbOrderCashBackResponse resp = xzbService.orderCashBack(request);
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
        // 邀请新人返点是否可用
        Boolean inviteRebateActive = Boolean.parseBoolean(redisIO.get("activity_order_invite_rebate", String.class));
        if (inviteRebateActive) {
            Long userId = orderInfo().getUserId();
            MemberInvite memberInvite = new MemberInvite();
            memberInvite.setUserId(userId);
            memberInvite = memberInviteMapper.selectOne(memberInvite);
            if (memberInvite != null) {
                List<SubItemOrderVO> subItemOrderVOS = subOrdersInfo();
                List<Long> goodsIds = BeanMapper.getFieldList(subItemOrderVOS, "goodsId", Long.class);
                if (goodsIds.size()>0) {
                    // 返现金额
                    Long rebateAmount = 0L;
                    //默认返点比例 万分之几
                    Integer defaultRebateNum = 0;
                    Map<Long, ShiguRebateType> shiguRebateTypeIdMap = new HashMap<>();
                    //查询默认返点类型
                    ShiguRebateType defaultType = new ShiguRebateType();
                    defaultType.setIsDefault(1);
                    defaultType.setIsActive(1);
                    List<ShiguRebateType> defaultTypes = shiguRebateTypeMapper.select(defaultType);
                    if (defaultTypes.size()>0) {
                        defaultRebateNum = defaultTypes.get(0).getRebateNum();
                    }
                    // 查看设置有效的商品返现类别
                    ShiguRebateGoodsExample goodsExample = new ShiguRebateGoodsExample();
                    goodsExample.createCriteria().andGoodsStatusEqualTo(1).andGoodsIdIn(goodsIds);
                    List<ShiguRebateGoods> goodsRebates = shiguRebateGoodsMapper.selectByExample(goodsExample);
                    Map<String, ShiguRebateGoods> goodsTypeMap = goodsRebates.stream().collect(Collectors.toMap(item->String.valueOf(item.getGoodsId()), o -> o));
                    Set<Long> typeTabs = goodsRebates.stream().map(ShiguRebateGoods::getGoodsTabId).collect(Collectors.toSet());
                    if (typeTabs.size()>0) {
                        ShiguRebateTypeExample shiguRebateTypeExample = new ShiguRebateTypeExample();
                        shiguRebateTypeExample.createCriteria().andIsActiveEqualTo(1).andTypeIdIn(new ArrayList<>(typeTabs));
                        shiguRebateTypeIdMap.putAll(shiguRebateTypeMapper.selectByExample(shiguRebateTypeExample).stream().collect(Collectors.toMap(ShiguRebateType::getTypeId,o->o)));
                    }
                    // 完成退款/售后的商品
                    ItemOrderRefund itemOrderRefundQuery = new ItemOrderRefund();
                    itemOrderRefundQuery.setOid(oid);
                    itemOrderRefundQuery.setStatus(2);
                    List<ItemOrderRefund> refunds = itemOrderRefundMapper.select(itemOrderRefundQuery);
                    Map<Long, List<ItemOrderRefund>> soidMaps = refunds.stream().collect(Collectors.groupingBy(ItemOrderRefund::getSoid, Collectors.toList()));
                    Integer goodsRebateNum = 0;
                    for (SubItemOrderVO subItemOrderVO : subItemOrderVOS) {
                        // 未退款/售后商品数量
                        int goodsUnRefundNum = subItemOrderVO.getNum() -
                                (soidMaps.get(subItemOrderVO.getSoid()) == null ? 0 : soidMaps
                                        .get(subItemOrderVO.getSoid()).stream().mapToInt(ItemOrderRefund::getNumber)
                                        .sum());
                        BigDecimal unRefundItemPrice = BigDecimal.valueOf(goodsUnRefundNum).multiply(BigDecimal.valueOf(subItemOrderVO.getPrice()));
                        if (goodsUnRefundNum>0) {
                            Long goodsId = subItemOrderVO.getGoodsId();
                            ShiguRebateGoods rebateType = goodsTypeMap.get(String.valueOf(goodsId));
                            if (rebateType != null && shiguRebateTypeIdMap.get(rebateType.getGoodsTabId())!=null && shiguRebateTypeIdMap.get(rebateType.getGoodsTabId()).getIsDefault()!=1) {
                                goodsRebateNum =  shiguRebateTypeIdMap.get(rebateType.getGoodsTabId()).getRebateNum();
                            } else {
                                goodsRebateNum = defaultRebateNum;
                            }
                            rebateAmount += unRefundItemPrice.multiply(BigDecimal.valueOf(goodsRebateNum)).divide(BigDecimal.valueOf(10000),2,BigDecimal.ROUND_DOWN).longValue();
                        }
                    }
                    // 邀请人用户id
                    Long inviteUserId = memberInvite.getInviteUserId();
                    if (rebateAmount > 0) {
                        InviteOrderRebateRecord inviteOrderRebateRecord = new InviteOrderRebateRecord();
                        inviteOrderRebateRecord.setOrderId(oid);
                        if (inviteOrderRebateRecordMapper.selectCount(inviteOrderRebateRecord) == 0) {
                            inviteOrderRebateRecord.setInviteUserId(inviteUserId);
                            inviteOrderRebateRecord.setUserId(userId);
                            inviteOrderRebateRecord.setRebateAmount(rebateAmount);
                            inviteOrderRebateRecord.setRebateState(1);
                            inviteOrderRebateRecordMapper.insertSelective(inviteOrderRebateRecord);
                        }
                        XzbInviteRechargeRequest inviteRebateRechargeRequest = new XzbInviteRechargeRequest();
                        inviteRebateRechargeRequest.setXzUserId(inviteUserId);
                        inviteRebateRechargeRequest.setRebateOrderNo(oid);
                        inviteRebateRechargeRequest.setRebateAmount(rebateAmount);
                        XzbInviteRechargeResponse resp = xzbService.inviteRebateRecharge(inviteRebateRechargeRequest);
                        if (resp == null || !resp.isSuccess()) {
                            try {
                                throw new RefundException("邀请注册订单返点失败：oid=" + oid);
                            } catch (RefundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public void closed() {
        if(selOrderStatus().equals(OrderStatus.WAIT_BUYER_PAY)) {
            changeStatus(OrderStatus.TRADE_CLOSED);
            calcelVoucherUse();
        }
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

    @Override
    public void addVoucher(Long voucherId) {
        if (voucherId == null) {
            return;
        }
        ItemVoucher itemVoucher = itemVoucherMapper.selectByPrimaryKey(voucherId);
        // 非该用户的代金券
        if (!orderInfo().getUserId().equals(itemVoucher.getUserId())) {
            return;
        }
        // 代金券状态不为可用
        if (!itemVoucher.getVoucherState().equals(1)) {
            return;
        }
        // 代金券已经过期
        if (itemVoucher.getExpireTime().before(new Date())) {
            itemVoucher.setVoucherState(0);
            itemVoucherMapper.updateByPrimaryKeySelective(itemVoucher);
            return;
        }
        ItemOrderVoucherRelation itemOrderVoucherRelation = new ItemOrderVoucherRelation();
        itemOrderVoucherRelation.setVoucherId(voucherId);
        List<ItemOrderVoucherRelation> voucherInfo = itemOrderVoucherRelationMapper.select(itemOrderVoucherRelation);
        for (ItemOrderVoucherRelation orderVoucherRelation : voucherInfo) {
            Integer voucherStatus = orderVoucherRelation.getVoucherStatus();
            // 代金券已被订单选中或已被使用
            if (0 == voucherStatus || 1 == voucherStatus) {
                return;
            }
        }
        // 订单关联选定代金券
        ItemOrderVoucherRelation usedVoucher = new ItemOrderVoucherRelation();
        usedVoucher.setVoucherId(voucherId);
        usedVoucher.setOrderId(oid);
        usedVoucher.setVoucherStatus(0);
        itemOrderVoucherRelationMapper.insertSelective(usedVoucher);
        // 代金券改为被选定状态
        itemVoucher = new ItemVoucher();
        itemVoucher.setVoucherId(voucherId);
        itemVoucher.setVoucherState(2);
        itemVoucherMapper.updateByPrimaryKeySelective(itemVoucher);
        // 重新计算订单金额
        recountTotalOrderAmount();
    }


    /**
     * 订单优惠信息
     * @return
     */
    public List<VoucherVO> voucherInfo() {
        // 订单使用的代金券
        List<VoucherVO> voucherVOS = new ArrayList<>();
        ItemOrderVoucherRelation query = new ItemOrderVoucherRelation();
        query.setOrderId(oid);
        List<Long> voucherIds = itemOrderVoucherRelationMapper.select(query).stream().filter(voucherRelation -> voucherRelation.getVoucherStatus() != 2).map(ItemOrderVoucherRelation::getVoucherId).collect(Collectors.toList());
        if (voucherIds.size()>0) {
            ItemVoucherExample example = new ItemVoucherExample();
            example.createCriteria().andVoucherIdIn(voucherIds);
            List<ItemVoucher> itemVouchers = itemVoucherMapper.selectByExample(example);
            for (ItemVoucher itemVoucher : itemVouchers) {
                if (itemVoucher.getVoucherState() == 2 || itemVoucher.getVoucherState() == 3) {
                    VoucherVO vo = new VoucherVO();
                    vo.setVoucherId(itemVoucher.getVoucherId());
                    vo.setVoucherInfo(itemVoucher.getVoucherInfo());
                    vo.setVoucherAmount(itemVoucher.getVoucherAmount());
                    voucherVOS.add(vo);
                }
            }
        }
        return voucherVOS;
    }

    /**
     * 支付完成，代金券实际使用
     */
    public void realUseVoucher() {
        ItemOrderVoucherRelation relation = new ItemOrderVoucherRelation();
        relation.setOrderId(oid);
        List<ItemOrderVoucherRelation> relations = itemOrderVoucherRelationMapper.select(relation);
        List<Long> relationIds = relations.stream().filter(r -> r.getVoucherStatus() == 0).map(ItemOrderVoucherRelation::getVoucherOrderRelationId).collect(Collectors.toList());
        if (relationIds.size()>0) {
            ItemOrderVoucherRelation used = new ItemOrderVoucherRelation();
            used.setVoucherStatus(1);
            ItemOrderVoucherRelationExample relationExample = new ItemOrderVoucherRelationExample();
            relationExample.createCriteria().andVoucherOrderRelationIdIn(relationIds);
            itemOrderVoucherRelationMapper.updateByExampleSelective(used,relationExample);
            List<Long> voucherIds = relations.stream().filter(r -> r.getVoucherStatus() == 0).map(ItemOrderVoucherRelation::getVoucherId).collect(Collectors.toList());
            if (voucherIds.size()>0) {
                ItemVoucher voucher = new ItemVoucher();
                voucher.setVoucherState(3);
                voucher.setUsedTime(new Date());
                ItemVoucherExample itemVoucherExample = new ItemVoucherExample();
                itemVoucherExample.createCriteria().andVoucherIdIn(voucherIds);
                itemVoucherMapper.updateByExampleSelective(voucher, itemVoucherExample);
            }
        }
    }

    /**
     * 没有进行支付，直接取消订单，返还优惠券
     */
    public void calcelVoucherUse() {
        // 已经进行过支付，订单实际进行过交易，不返还优惠券
        if (orderInfo().getPayTime() != null) {
            return;
        }
        ItemOrderVoucherRelation relation = new ItemOrderVoucherRelation();
        relation.setOrderId(oid);
        List<ItemOrderVoucherRelation> relations = itemOrderVoucherRelationMapper.select(relation);
        List<Long> relationIds = relations.stream().filter(r -> r.getVoucherStatus() == 0).map(ItemOrderVoucherRelation::getVoucherOrderRelationId).collect(Collectors.toList());
        if (relationIds.size()>0) {
            // 没有实际下单，订单和代金券关系取消
            ItemOrderVoucherRelation calcelRelation = new ItemOrderVoucherRelation();
            calcelRelation.setVoucherStatus(2);
            ItemOrderVoucherRelationExample relationExample = new ItemOrderVoucherRelationExample();
            relationExample.createCriteria().andVoucherOrderRelationIdIn(relationIds);
            itemOrderVoucherRelationMapper.updateByExampleSelective(calcelRelation,relationExample);
            List<Long> voucherIds = relations.stream().filter(r -> r.getVoucherStatus() == 0).map(ItemOrderVoucherRelation::getVoucherId).collect(Collectors.toList());
            if (voucherIds.size()>0) {
                Date now = new Date();
                // 没过期的代金券返还后可用
                ItemVoucher voucher = new ItemVoucher();
                voucher.setVoucherState(1);
                ItemVoucherExample itemVoucherExample = new ItemVoucherExample();
                itemVoucherExample.createCriteria().andVoucherIdIn(voucherIds).andExpireTimeGreaterThanOrEqualTo(now);
                itemVoucherMapper.updateByExampleSelective(voucher, itemVoucherExample);
                // 清理过期的代金券
                voucher.setVoucherState(0);
                itemVoucherExample = new ItemVoucherExample();
                itemVoucherExample.createCriteria().andVoucherIdIn(voucherIds).andExpireTimeLessThan(now);
                itemVoucherMapper.updateByExampleSelective(voucher, itemVoucherExample);
            }

        }
    }
}
