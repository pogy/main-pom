package com.shigu.main4.order.mq.listener;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.SubOrderSoidps;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.SubOrderSoidpsExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.SubOrderSoidpsMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.exceptions.RefundException;
import com.shigu.main4.order.model.*;
import com.shigu.main4.order.mq.msg.*;
import com.shigu.main4.order.mq.producter.OrderMessageProducter;
import com.shigu.main4.order.process.QimenTradeProcess;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.SubAfterSaleSimpleOrderVO;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 代发消息队列接收处理
 * Created by bugzy on 2017/8/14 0014.
 */
@Component("dfMessageListener")
public class DfMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(DfMessageListener.class);
    private static final com.alibaba.dubbo.common.logger.Logger dubbologger = com.alibaba.dubbo.common.logger.LoggerFactory
            .getLogger(DfMessageListener.class);
    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private SubOrderSoidpsMapper subOrderSoidpsMapper;

    @Autowired
    private SoidsCreater soidsCreater;

    @Autowired
    private SoidsModel soidsModel;

    @Autowired
    private AfterSaleService afterSaleService;

    @Autowired
    private OrderMessageProducter orderMessageProducter;
    @Autowired
    QimenTradeProcess qimenTradeProcess;

    public enum DfMqTag {
        refund_agree(RefundMessage.class),

        weight_set(SubOrderInfoMessage.class),

        send_all(SendAllMessage.class),

        stop_trade(StopTradeMessage.class),

        shop_refuse(ShopRefuseMessage.class),

        reprice_apply(RepriceApplyMessage.class),

        after_sale_accept(AfterSaleAcceptMessage.class),

        have_time(HaveTimeMessage.class),

        mark_down(MarkDownMessage.class),

        update_express_code(UpdateExpressCodeMessage.class),

        ;
        public final Class<?> clazz;

        DfMqTag(Class<?> clazz) {
            this.clazz = clazz;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Action consume(Message message, ConsumeContext consumeContext) {
        String body = new String(message.getBody());
        logger.info(body);
        DfMqTag dfMqTag;
        try {
            dfMqTag = DfMqTag.valueOf(message.getTag());
        } catch (IllegalArgumentException e) {
            logger.error(String.format("不支持的消息类型[%s]::body[%s]", message.getTag(), body));
            return Action.ReconsumeLater;
        }
        BaseMessage baseMessage = JSON.parseObject(body, BaseMessage.class);
        if (!baseMessage.getStatus() || baseMessage.getData() == null) {
            logger.error(baseMessage.getMsg());
            return Action.CommitMessage;
        }

        baseMessage.setData(JSON.parseObject(baseMessage.getData().toString(), dfMqTag.clazz));

        switch (dfMqTag) {
            case refund_agree:
                refundAgree(baseMessage);
                break;
            case weight_set:
                weightSet(baseMessage);
                break;
            case send_all:
                sendAll(baseMessage);
                break;
            case update_express_code:
                updateExpressCode(baseMessage);
                break;
            case stop_trade:
                stopTrade(baseMessage);
                break;
            case shop_refuse:
                shopRefuse(baseMessage);
                break;
            case reprice_apply:
                repriceApply(baseMessage);
                break;
            case after_sale_accept:
                afterSaleAccept(baseMessage);
                break;
            case have_time:
                haveTime(baseMessage);
                break;
            case mark_down:
                makeDown(baseMessage);
                break;
            default:{
                logger.info(message.getTag()+">>>>>>>>>");
            }

        }
        return Action.CommitMessage;
    }

    public void makeDown(BaseMessage<MarkDownMessage> baseMessage) {
        logger.info("soidpid>>>>>>>"+baseMessage.getData().getOrderPartitionId());
        //更新sub_order_soidps#down_is
        SubOrderSoidps subOrderSoidps = new SubOrderSoidps();
        subOrderSoidps.setDownIs(true);
        subOrderSoidps.setSoidpId(baseMessage.getData().getOrderPartitionId());
        subOrderSoidpsMapper.updateByPrimaryKeySelective(subOrderSoidps);
    }

    public synchronized void refundAgree(BaseMessage<RefundMessage> msg) {
        try {
            RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, msg.getData().getRefundId());
            refundItemOrder.success();
            RefundVO refundinfo = refundItemOrder.refundinfo();
            ItemOrderRefund itemOrderRefund = new ItemOrderRefund();
            itemOrderRefund.setOid(refundinfo.getOid());
            itemOrderRefund.setStatus(RefundStateEnum.ENT_REFUND.refundStatus);
            int soidps = itemOrderRefundMapper.select(itemOrderRefund).stream().mapToInt(ItemOrderRefund::getNumber).sum();

            ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, refundinfo.getOid());
            if (soidps == itemOrder.subOrdersInfo().stream().mapToInt(SubItemOrderVO::getNum).sum()) {
                itemOrder.finished();
            }
        } catch (PayerException | RefundException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void weightSet(BaseMessage<SubOrderInfoMessage> msg) {

    }

    public void sendAll(BaseMessage<SendAllMessage> msg) {
        SendAllMessage sendAllMessage = msg.getData();
        SpringBeanFactory.getBean(ItemOrder.class, sendAllMessage.getOrderId()).sended(sendAllMessage.getExpressCode());
        try {
            qimenTradeProcess.toOut(sendAllMessage.getOrderId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateExpressCode(BaseMessage<UpdateExpressCodeMessage> msg) {
        UpdateExpressCodeMessage updateExpressCodeMessage = msg.getData();
        SpringBeanFactory.getBean(ItemOrder.class, updateExpressCodeMessage.getOrderId()).updateExpressCode(updateExpressCodeMessage.getExpressCode());
    }

    public void stopTrade(BaseMessage<StopTradeMessage> msg) {
        soidsCreater.selSoidsBySoidps(msg.getData().getRefundSubOrderIds()).forEach((k, v) -> {
            SubItemOrder subItemOrder = SpringBeanFactory.getBean(SubItemOrder.class, k);
            try {
                SubAfterSaleSimpleOrderVO subSimple = afterSaleService.subAfterSaleSimpleOrder(k);
                Long price = v.size() * subSimple.getPrice();
                Long maxItemCanRefund = afterSaleService.maxItemCanRefundBySubOrderId(subSimple.getSubOrderId());
                if (price > maxItemCanRefund) {
                    price = maxItemCanRefund;
                }
                if (subSimple.getOtherRefundPrice() != null) {
                    //最后一单全退，才退快递费
                    if (Objects.equals(v.size(),subSimple.getNum())) {
                        price += subSimple.getOtherRefundPrice();
                    }
                }
                Long refundId = subItemOrder.refundApply(4, v.size(), price, msg.getMsg());
                SubOrderSoidps soidps = new SubOrderSoidps();
                soidps.setAlreadyRefund(true);
                SubOrderSoidpsExample example = new SubOrderSoidpsExample();
                example.createCriteria().andSoidpIdIn(v);
                subOrderSoidpsMapper.updateByExampleSelective(soidps,example);
                orderMessageProducter.orderRefundNoItem(refundId, k, v);
            } catch (OrderException e) {
                logger.error(e.getMessage(), e);
            }
        });
    }

    public void shopRefuse(BaseMessage<ShopRefuseMessage> msg) {
        ShopRefuseMessage data = msg.getData();
        SpringBeanFactory.getBean(RefundItemOrder.class, data.getRefundId()).shopRefuse(data.getNum(),msg.getMsg());
    }

    public void repriceApply(BaseMessage<RepriceApplyMessage> msg) {
        RepriceApplyMessage data = msg.getData();
        //议价原因
        String proposalMsg = "卖家确定退货金额";
        SpringBeanFactory.getBean(RefundItemOrder.class, data.getRefundId()).sellerProposal(data.getStoreMoney(), proposalMsg);
    }

    public void afterSaleAccept(BaseMessage<AfterSaleAcceptMessage> msg) {
        AfterSaleAcceptMessage data = msg.getData();
        RefundItemOrder refundModel = SpringBeanFactory.getBean(RefundItemOrder.class, data.getRefundId());
        if (!data.getCanRefund()) {
            refundModel.sellerRefuse(data.getReason());
        } else {
            refundModel.sellerAgree();
        }
    }

    /**
     * 有货时间消息
     * @param msg
     */
    public void haveTime(BaseMessage<HaveTimeMessage> msg) {
        HaveTimeMessage data = msg.getData();
        soidsModel.havaTime(data.getPsoid(),data.getDay());
    }
}
