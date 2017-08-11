package com.shigu.main4.daifa.model.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.*;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.DeliveryBO;
import com.shigu.main4.daifa.config.MQConfig;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jmb on 2017/8/10.
 * Path com.shigu.main4.spring-database.model.OrderModelImpl
 */
@Repository
@Scope("prototype")
public class OrderModelImpl implements OrderModel {

    private DaifaTrade daifaTrade;

    private Long tid;

    @Autowired
    private DaifaTradeMapper daifaTradeMapper;

    @Autowired
    private DaifaTradeIdGeneratorMapper daifaTradeIdGeneratorMapper;

    @Autowired
    private DaifaSendMapper daifaSendMapper;

    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;

    @Autowired
    private DaifaOrderMapper daifaOrderMapper;

    @Autowired
    private DaifaGgoodsMapper daifaGgoodsMapper;

    @Autowired
    private DaifaSendOrderMapper daifaSendOrderMapper;

    @Autowired
    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;

    @Autowired
    private DaifaWaitSendMapper daifaWaitSendMapper;


    @Autowired
    private Producer producer;

    @Autowired
    private MQConfig mQConfig;

//    private final static Logger logger = (Logger) LoggerFactory.getLogger(OrderModelImpl.class);

    public OrderModelImpl(Long tid) {
        this.tid = tid;
    }

    public OrderModelImpl(DaifaTrade daifaTrade) {
        this.daifaTrade = daifaTrade;
        this.tid = daifaTrade.getDfTradeId();
    }


    /**
     * 创建订单
     */
    @Override
    @PostConstruct
    public void init() {
        daifaTrade = daifaTradeMapper.selectByPrimaryKey(tid);
    }


    /**
     * 订单超时
     */
    @Override
    @Transactional
    public void timeout() {
        DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(tid);
        Date createTime = trade.getCreateTime();
        TypeConvert.dateAddDay(createTime, 3);

        if (createTime.getTime() < new Date().getTime()) {
            DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andDfTradeIdEqualTo(tid)
                    .andReturnStatusEqualTo(0).andUseStatusEqualTo(1)
                    .andEndStatusEqualTo(0).andAllocatStatusEqualTo(0)
                    .andOperateIsEqualTo(0);
            DaifaGgoodsTasks daifaGgoodsTask = new DaifaGgoodsTasks();
            daifaGgoodsTask.setEndStatus(1);
            List<DaifaGgoodsTasks> daifaGgoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,"df_order_id");
            List<Long> dfOrderIds=new ArrayList<>();
            if (daifaGgoodsTasks.size()>0){
                daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTask, daifaGgoodsTasksExample);
                dfOrderIds= BeanMapper.getFieldList(daifaGgoodsTasks, "dfOrderId", Long.class);
            }
            JSONObject jsonObject=new JSONObject();
            Map<String,Object>map=new HashMap<>();
            map.put("orderId",tid);
            map.put("refundSubOrderIds",dfOrderIds);
            jsonObject.put("data",map);
            jsonObject.put("msg", DaifaSendMqEnum.cutOff.getMsg());
            jsonObject.put("status","true");
            String message = jsonObject.toString();
            sendMessage(DaifaSendMqEnum.cutOff.getMessageTag()+tid, DaifaSendMqEnum.cutOff.getMessageKey(), message);
        }
        trade.setTradeStatus(10);
        daifaTradeMapper.updateByPrimaryKeySelective(trade);
    }

    /**
     * 发货
     *
     * @param delivery
     */
    @Override
    @Transactional
    public void send(DeliveryBO delivery) throws DaifaException {
        if (delivery == null) {
            throw new DaifaException("deliceryBo为空");
        }
        if (delivery.getMarkDestination() == null || delivery.getDfTradeId() == null || delivery.getPackageName() == null || delivery.getExpressCode() == null) {
            throw new DaifaException("主单id，三段码，集包地,快递单号都不能为空");
        }
        DaifaTrade trade = new DaifaTrade();
        trade.setTradeStatus(3);
        trade.setSendTime(new Date());
        trade.setSendStatus(2);
        trade.setDfTradeId(delivery.getDfTradeId());
        if (delivery.getExpressCode() != null) {

            trade.setExpressCode(delivery.getExpressCode());
        }
        if (delivery.getExpressName() != null) {
            trade.setExpressName(delivery.getExpressName());
        }
        if (delivery.getExpressId() != null) {
            trade.setExpressId(delivery.getExpressId());
        }
        daifaTradeMapper.updateByPrimaryKeySelective(trade);

        DaifaSend send = BeanMapper.map(delivery, DaifaSend.class);
        send.setSendStatus(2);
        daifaSendMapper.insertSelective(send);
        DaifaSendExample daifaSendExample=new DaifaSendExample();
        daifaSendExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        List<DaifaSend> sends = daifaSendMapper.selectByExample(daifaSendExample);
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        DaifaWaitSend daifaWaitSend=new DaifaWaitSend();
        daifaWaitSend.setDfTradeId(delivery.getDfTradeId());
        daifaWaitSend.setSendStatus(2);
        daifaWaitSendMapper.updateByPrimaryKeySelective(daifaWaitSend);

        if (delivery.getDfOrderIds()!=null&&delivery.getDfOrderIds().size()>0){
            DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
            daifaWaitSendOrder.setSendStatus(2);
            DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
            daifaWaitSendOrderExample.createCriteria().andDfOrderIdIn(delivery.getDfOrderIds()).andDfTradeIdEqualTo(delivery.getDfTradeId());
            daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);
            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andDfOrderIdIn(delivery.getDfOrderIds());
            List<DaifaOrder> daifaOrders = daifaOrderMapper.selectByExample(daifaOrderExample);
            List<DaifaSendOrder> daifaSendOrders = BeanMapper.mapList(daifaOrders, DaifaSendOrder.class);

            for (DaifaSendOrder d:daifaSendOrders){
                d.setCreateDate(DateUtil.dateToString(new Date(),DateUtil.patternB));
                d.setCreateTime(new Date());
                d.setWebSite("hz");
                d.setTakeGoodsStatus(1);
                d.setSendStatus(2);
                if (sends.size()>0){

                    d.setSendId(sends.get(0).getSendId());
                }
                d.setSellerId(delivery.getSellerId());
                daifaSendOrderMapper.insertSelective(d);
            }
        }


    }

    /**
     * 自动退款处理
     * @param refundId 退单ID
     * @param subOrderIds 退单包含的子单信息
     */
    @Override
    @Transactional
    public void autoRefund(Long refundId, List<Long> subOrderIds) {
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(subOrderIds);
        DaifaOrder daifaOrder=new DaifaOrder();
        daifaOrder.setRefundStatus(2);
        daifaOrder.setRefundId(refundId);
        daifaOrder.setRefundFinishTime(new Date());
        daifaOrderMapper.updateByExampleSelective(daifaOrder,daifaOrderExample);
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoods daifaGgoods =new DaifaGgoods();
        daifaGgoods.setReturnStatus(2);
        daifaGgoodsMapper.updateByExampleSelective(daifaGgoods,daifaGgoodsExample);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setReturnStatus(2);
        daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTasks,daifaGgoodsTasksExample);
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
        daifaSendOrder.setRefundStatus(2);
        daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder,daifaSendOrderExample);
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(tid).andDfOrderIdIn(subOrderIds);
        DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
        daifaWaitSendOrder.setRefundStatus(2);
        daifaWaitSendOrder.setRefundTime(new Date());
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);
        sendRefundMq(refundId.toString(),null);
    }
    /**
     * 退款
     * @param refundId
     * @param msg
     */
    public void sendRefundMq(String refundId,String msg){
        JSONObject obj=new JSONObject();
        if(msg==null){
            JSONObject o1=new JSONObject();
            o1.put("refundId",refundId);
            obj.put("data",o1);
            obj.put("msg",DaifaSendMqEnum.refund.getMsg());
            obj.put("status",true);
        }else{
            obj.put("msg",msg);
            obj.put("status",false);
        }
        sendMessage(DaifaSendMqEnum.refund.getMessageTag()+refundId,
                DaifaSendMqEnum.refund.getMessageKey(),
                obj.toString());
    }

    /**
     * 生成主单id
     *
     * @return 主单id
     */
    private Long selTradeId() {
        DaifaTradeIdGenerator dtig = new DaifaTradeIdGenerator();
        dtig.setCreateTime(new Date());
        daifaTradeIdGeneratorMapper.insertSelective(dtig);
        Long tid = dtig.getDfTradeId();
        Long jidi = 100000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Long dlong = Long.parseLong(sdf.format(new Date()));
        tid = 6 * jidi * 100000000 + dlong * jidi + (tid % jidi);//新的代发前面最前面系数改2原来是1
        return tid;
    }

    public void sendMessage(String messageTag, String messageKey, String messages) {
        System.out.println(messageTag + "------------" + messages);

        byte[] bs = null;
        try {
            bs = messages.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Message msg = new Message( //
                // Message所属的Topic
                mQConfig.topic,
                // Message Tag 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在MQ服务器过滤
                messageTag,
                // Message Body 可以是任何二进制形式的数据， MQ不做任何干预
                // 需要Producer与Consumer协商好一致的序列化和反序列化方式
                bs);
        // 设置代表消息的业务关键属性，请尽可能全局唯一
        // 以方便您在无法正常收到消息情况下，可通过MQ 控制台查询消息并补发
        // 注意：不设置也不会影响消息正常收发
        msg.setKey(messageKey);
        System.out.println("send body: " + new String(msg.getBody()));
        // 发送消息，只要不抛异常就是成功
        producer.sendAsync(msg, new SendCallback() {
            @Override
            public void onSuccess(final SendResult sendResult) {
                // 消费发送成功
                System.out.println("send success: " + sendResult.getMessageId());

            }

            @Override
            public void onException(OnExceptionContext context) {
                // 消息发送失败
                System.out.println("发送失败");
            }
        });


    }


    public DaifaTrade getDaifaTrade() {
        return daifaTrade;
    }

    public void setDaifaTrade(DaifaTrade daifaTrade) {
        this.daifaTrade = daifaTrade;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}
