package com.shigu.main4.order.mq.producter;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.opentae.data.mall.beans.MemberUser;
import com.opentae.data.mall.interfaces.MemberUserMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.mq.msg.*;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.order.vo.OrderServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单消息生产
 * Created by bugzy on 2017/8/14 0014.
 */
@Service
public class OrderMessageProducter {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageProducter.class);

    public static final String TOPIC = "SHIGU_TRADE_TEST";

    public enum OrderMQTag {
        order_push("oid_"),
        order_refund_noitem("refund_"),
        order_refund_hasitem("refund_hasitem_"),
        refund_courier_number("courier_"),
        refund_courier_number_modify("courier_modify_");

        public final String preKey;

        OrderMQTag(String preKey) {
            this.preKey = preKey;
        }
    }

    @Autowired
    private ProducerBean producerBean;

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    /**
     * 订单推送
     * @param itemOrder
     */
    public void orderPush(ItemOrder itemOrder) {
        OrderMessage order = new OrderMessage();
        ItemOrderVO itemOrderVO = itemOrder.orderInfo();

        order.setOid(itemOrderVO.getOrderId());
        order.setAggrement(1);
        order.setSenderId(itemOrderVO.getSenderId());
        order.setType(itemOrderVO.getType().type);
        order.setSubOrders(itemOrder.subOrdersInfo().stream().map(subItemOrderVO -> {
            ItemProductVO product = subItemOrderVO.getProduct();
            SubOrderInfoMessage subOrder = BeanMapper.map(subItemOrderVO, SubOrderInfoMessage.class);
            subOrder.setTitle(product.getTitle());
            subOrder.setSinglePay(product.getPrice());
            subOrder.setPicUrl(product.getPicUrl());
            subOrder.setWebSite(product.getWebSite());
            subOrder.setWeight(product.getWeight());
            subOrder.setMarketId(product.getMarketId());
            subOrder.setMarketName(product.getMarketName());
            subOrder.setFloorId(product.getFloorId());
            subOrder.setFloor(product.getFloor());
            subOrder.setShopId(product.getShopId());
            subOrder.setShopNum(product.getShopNum());
            //TODO: subOrder.setSoidps();
            return subOrder;
        }).collect(Collectors.toList()));

        List<ServiceMessage> services = new ArrayList<>();
        for (OrderServiceVO serviceVO : itemOrder.selServices()) {
            for (SubOrderInfoMessage orderInfoMessage : order.getSubOrders()) {
                ServiceMessage serviceMessage = BeanMapper.map(serviceVO, ServiceMessage.class);
                serviceMessage.setSoid(orderInfoMessage.getSoid());
                serviceMessage.setId(serviceVO.getServiceId());
                services.add(serviceMessage);
            }
        }
        order.setServices(services);

        order.setLogistics(itemOrder.selLogisticses().stream().map(logisticsVO -> {
            LogisticMessage message = BeanMapper.map(logisticsVO, LogisticMessage.class);
            message.setCity(orderConstantService.selCityByCid(message.getCityId()).getCity());
            message.setProv(orderConstantService.selProvByPid(message.getCityId()).getProvince());
            message.setTown(orderConstantService.selTownByTid(message.getTownId()).getTown());
            message.setCompany(orderConstantService.selByExpressId(message.getCompanyId()).getExpressName());
            return message;
        }).collect(Collectors.toList()));

        Buyer buyer = new Buyer();
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(itemOrderVO.getUserId());
        if (memberUser != null) {
            buyer.setAliWw(memberUser.getImAliww());
            buyer.setPhone(memberUser.getPhoneMob());
            buyer.setNickInMarket(memberUser.getUserNick());
        }
        order.setBuyer(buyer);

        sendAsync(OrderMQTag.order_push, BaseMessage.success(order.getOid().toString(), "订单创建", order));
    }

    public void orderRefundNoItem(Long refundId, Long subOrderId) {
        RefundMessage refund = new RefundMessage();
        refund.setRefundId(refundId);
        ArrayList<SubOrderMessage> soids = new ArrayList<>();
        SubOrderMessage subOrder = new SubOrderMessage();
        subOrder.setSoid(subOrderId);
        subOrder.setSoidps(Arrays.asList(subOrderId));
        soids.add(subOrder);
        refund.setSuborders(soids);

        sendAsync(OrderMQTag.order_refund_noitem, BaseMessage.success(refund.getRefundId().toString(), "仅退款", refund));
    }

    public void orderRefundHasItem(Long refundId, Long subOrderId, Long money, String reason) {
        RefundMessage refund = new RefundMessage();
        refund.setRefundId(refundId);
        refund.setMoney(money);
        refund.setReason(reason);

        ArrayList<SubOrderMessage> soids = new ArrayList<>();
        SubOrderMessage subOrder = new SubOrderMessage();
        subOrder.setSoid(subOrderId);
        subOrder.setSoidps(Arrays.asList(subOrderId));
        subOrder.setSingleMoney(money);
        soids.add(subOrder);
        refund.setSuborders(soids);

        sendAsync(OrderMQTag.order_refund_hasitem, BaseMessage.success(refund.getRefundId().toString(), "退货退款", refund));
    }

    public void refundCourierNumberModify(Long refundId, String company, String courierNumber, boolean modify) {
        CourierMessage courier = new CourierMessage();
        courier.setRefundId(refundId);
        courier.setCompany(company);
        courier.setCourierNumber(courierNumber);
        OrderMQTag tag;
        String msg;
        if (modify) {
            tag = OrderMQTag.refund_courier_number_modify;
            msg = "快递单修改";
        } else {
            tag = OrderMQTag.refund_courier_number;
            msg = "填写快递单";
        }
        sendAsync(tag, BaseMessage.success(courier.getRefundId().toString(), msg, courier));
    }

    public void error(OrderMQTag tag, String key, String msg) {
        sendAsync(tag, BaseMessage.error(key, msg));
    }

    private void sendAsync(OrderMQTag tag, BaseMessage msg) {
        producerBean.sendAsync(
                new Message(TOPIC, tag.name(), tag.preKey + msg.getKey(), msg.toString().getBytes()),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                    }

                    @Override
                    public void onException(OnExceptionContext context) {
                        logger.error(String.format(
                                "订单相关消息推送失败！topic:%s, messageid:%s,exception:%s, body:%s",
                                context.getTopic(),
                                context.getMessageId(),
                                context.getException().getMessage(),
                                msg.toString()
                                )
                        );
                    }
                }
        );
    }
}
