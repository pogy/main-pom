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
import com.shigu.main4.order.model.SoidsCreater;
import com.shigu.main4.order.mq.msg.*;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.OrderServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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

    public static String TOPIC;

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

    @PostConstruct
    public void init(){
        TOPIC=producerBean.getProperties().getProperty("topic");
    }

    @Autowired
    private ProducerBean producerBean;

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private SoidsCreater soidsCreater;

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
            subOrder.setSinglePay(String.format("%.2f", product.getPrice() * .01));
            subOrder.setPicUrl(product.getPicUrl());
            subOrder.setWebSite(product.getWebSite());
            subOrder.setWeight(String.format("%.3f", product.getWeight() * .001));
            subOrder.setMarketId(product.getMarketId());
            subOrder.setMarketName(product.getMarketName());
            subOrder.setFloorId(product.getFloorId());
            subOrder.setFloor(product.getFloor());
            subOrder.setShopId(product.getShopId());
            subOrder.setShopNum(product.getShopNum());
            subOrder.setSoidps(soidsCreater.makeSoidps(subItemOrderVO.getSoid(),subItemOrderVO.getNum()));
            subOrder.setColor(product.getSelectiveSku().getColor());
            subOrder.setSize(product.getSelectiveSku().getSize());
            return subOrder;
        }).collect(Collectors.toList()));

        List<OrderServiceVO> orderServiceVOS = itemOrder.selServices();

        order.setServices(orderServiceVOS.stream().map(s -> {
            ServiceMessage serviceMessage = new ServiceMessage();
            serviceMessage.setId(s.getServiceId());
            serviceMessage.setSoid(s.getSoid());
            serviceMessage.setName(s.getName());
            serviceMessage.setMoney(String.format("%.2f", s.getMoney() * .01));
            return serviceMessage;
        }).collect(Collectors.toList()));

        order.setLogistics(itemOrder.selLogisticses().stream().map(logisticsVO -> {
            LogisticMessage message = new LogisticMessage();
            message.setCityId(logisticsVO.getCityId());
            message.setTownId(logisticsVO.getTownId());
            message.setProvId(logisticsVO.getProvId());
            message.setCompanyId(logisticsVO.getCompanyId());
            message.setAddress(logisticsVO.getAddress());
            message.setMoney(String.format("%.2f", logisticsVO.getMoney() * .01));
            message.setName(logisticsVO.getName());
            message.setZipCode(logisticsVO.getZipCode());
            message.setTelephone(logisticsVO.getTelephone());
            message.setCity(orderConstantService.selCityByCid(message.getCityId()).getCity());
            message.setProv(orderConstantService.selProvByPid(message.getProvId()).getProvince());
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

    public void orderRefundNoItem(Long refundId, Long subOrderId, List<Long> refundSoidps) {
        RefundMessage refund = new RefundMessage();
        refund.setRefundId(refundId);
        ArrayList<SubOrderMessage> soids = new ArrayList<>();
        SubOrderMessage subOrder = new SubOrderMessage();
        subOrder.setSoid(subOrderId);
        subOrder.setSoidps(refundSoidps);
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
