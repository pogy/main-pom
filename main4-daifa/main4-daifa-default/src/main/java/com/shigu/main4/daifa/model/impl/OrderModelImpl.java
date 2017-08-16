package com.shigu.main4.daifa.model.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.*;
import com.opentae.common.beans.LogUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.config.MQConfig;
import com.shigu.main4.daifa.enums.DaifaListDealTypeEnum;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.utils.CdkeyUtil;
import com.shigu.main4.daifa.utils.DaifaListDealUtil;
import com.shigu.main4.daifa.utils.PinyinUtil;
import com.shigu.main4.daifa.utils.PriceConvertUtils;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jmb on 2017/8/10.
 * Path com.shigu.main4.daifa.model.impl.OrderModelImpl
 */
@Repository
@Scope("prototype")
public class OrderModelImpl implements OrderModel {

    private OrderBO orderBO;

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
    private DaifaListDealUtil daifaListDealUtil;


    @Autowired
    private Producer producer;

    @Autowired
    private MQConfig mQConfig;

    private final Logger log = LogUtil.getLog(OrderModelImpl.class);

    public OrderModelImpl(Long tid) {
        this.tid = tid;
    }

    public OrderModelImpl(OrderBO bo) {
        this.orderBO = bo;
    }

    @PostConstruct
    public void  beforeInit(){
        if (orderBO!=null){
            init();
        }
    }

    /**
     * 创建订单
     */
    @Override
    public void init() {
        DaifaTrade daifaTrade=new DaifaTrade();
        SubOrderModelBO subOrderModelBO=new SubOrderModelBO();
        daifaTrade.setDfTradeId(selTradeId());
        daifaTrade.setSellerId(orderBO.getSenderId());
        List<SubOrderBO> subOrders = orderBO.getSubOrders();
        daifaTrade.setTradeCode(orderBO.getOid().toString());
        int num=0;
        Double goodsFee= 0.00;
        Map<Long, ServiceBO> serviceBOMap = BeanMapper.list2Map(orderBO.getServices(), "soid", Long.class);
        for (SubOrderBO bo:subOrders){
            num+=bo.getNum();
        }
        int i=0;
        for (SubOrderBO bo:subOrders){
            subOrderModelBO.setOrderCode(bo.getSoid().toString());

            if (bo.getSoidps().size()>0){
                for (Long soidp :bo.getSoidps()){
                    i++;
                    subOrderModelBO.setOrderPartitionId(soidp.toString());
                    subOrderModelBO.setMarketId(bo.getMarketId());
                    subOrderModelBO.setMarketName(bo.getMarketName());
                    subOrderModelBO.setFloorId(bo.getFloorId());
                    subOrderModelBO.setFloorName(bo.getFloor());
                    subOrderModelBO.setStoreId(bo.getShopId());
                    subOrderModelBO.setStoreNum(bo.getShopNum());
                    subOrderModelBO.setGoodsId(bo.getGoodsId());
                    subOrderModelBO.setGoodsCode(bo.getGoodsNo());
                    subOrderModelBO.setTitle(bo.getTitle());
                    subOrderModelBO.setPicPath(bo.getPicUrl());
                    subOrderModelBO.setStoreGoodsCode(PinyinUtil.getPinYinHeadCharToLowerCase(bo.getMarketName())+"_"+bo.getShopNum()+"_"+bo.getGoodsNo());
                    subOrderModelBO.setOrderDiscountFee("0.00");
                    subOrderModelBO.setPropStr(bo.getColor()+":"+bo.getSize());
                    subOrderModelBO.setGoodsNum(1);
                    subOrderModelBO.setSinglePiPrice(bo.getSinglePay());
                    subOrderModelBO.setSinglePay(bo.getSinglePay());
                    subOrderModelBO.setSellerId(orderBO.getSenderId());
                    subOrderModelBO.setTotalFee(bo.getSinglePay());
                    subOrderModelBO.setOrderStatus(Long.valueOf(1));
                    subOrderModelBO.setAggrement(1);
                    subOrderModelBO.setTradeCode(daifaTrade.getTradeCode());
                    subOrderModelBO.setWebSite(bo.getWebSite());
                    subOrderModelBO.setDfTradeId(daifaTrade.getDfTradeId());
                    subOrderModelBO.setBarCodeKeyNum (num+"-"+i);
                    Double serviceFee = Double.parseDouble(serviceBOMap.get(bo.getSoid()).getMoney()) / Double.valueOf(bo.getNum());
                    subOrderModelBO.setSingleServicesFee(PriceConvertUtils.doublePriceToString (serviceFee));
                    subOrderModelBO.setTotalServiceFee (PriceConvertUtils.doublePriceToString (serviceFee));

                    SpringBeanFactory.getBean(SubOrderModel.class,subOrderModelBO);
                    goodsFee+=Double.parseDouble(bo.getSinglePay());
                }

            }
        }
        daifaTrade.setGoodsNum(Long.valueOf(num));
        LogisticsBO logisticsBO = orderBO.getLogistics().get(0);
        daifaTrade.setReceiverName(logisticsBO.getName());
        daifaTrade.setReceiverPhone(logisticsBO.getTelephone());
        daifaTrade.setReceiverState(logisticsBO.getProv());
        daifaTrade.setReceiverAddress(logisticsBO.getProv()+" "+logisticsBO.getCity()+" "+logisticsBO.getTown()+" "+logisticsBO.getAddress());
        daifaTrade.setDaifaType(orderBO.getType());
        daifaTrade.setExpressId(logisticsBO.getCompanyId());
        daifaTrade.setExpressName(logisticsBO.getCompany());
        daifaTrade.setTradeStatus(1);
        daifaTrade.setBuyerNick(orderBO.getBuyerBO().getNickInMarket());
        daifaTrade.setGoodsFee(PriceConvertUtils.doublePriceToString (goodsFee));
        daifaTrade.setBuyerRemark (orderBO.getBuyRemark ());

        daifaTrade.setExpressFee(PriceConvertUtils.doublePriceToString (logisticsBO.getMoney()));
        List<ServiceBO> services = orderBO.getServices();
        Double serviceFee=0.00;
        for (ServiceBO bo:services){
            serviceFee+=Double.parseDouble(bo.getMoney());
        }
        daifaTrade.setServicesFee(PriceConvertUtils.doublePriceToString (serviceFee));
        daifaTrade.setTradeDiscountFee("0.00");
        daifaTrade.setTotalFee(PriceConvertUtils.doublePriceToString(serviceFee+goodsFee+logisticsBO.getMoney()));
        daifaTrade.setMoney(PriceConvertUtils.doublePriceToString(serviceFee+goodsFee+logisticsBO.getMoney()));
        daifaTrade.setSendStatus (1);
        daifaTrade.setRealPayMoney(PriceConvertUtils.doublePriceToString(serviceFee+goodsFee+logisticsBO.getMoney()));

        daifaTrade.setCreateTime(new Date());
        daifaTrade.setLastDoTime(new Date());
        daifaTrade.setBarCodeKey(daifaListDealUtil.queryListCode(DaifaListDealTypeEnum.TRADE_SORT,orderBO.getSenderId(),null));
        daifaTradeMapper.insertSelective(daifaTrade);
        this.tid=daifaTrade.getDfTradeId();
    }
    /**
     * 订单超时
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor ={Exception.class,RuntimeException.class})
    public void timeout() {
        DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(tid);
        Date createTime = trade.getCreateTime();
        TypeConvert.dateAddDay(createTime, 3);
        //判断是否超时
        if (createTime.getTime() < new Date().getTime()) {
            DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andDfTradeIdEqualTo(tid)
                    .andReturnStatusEqualTo(0).andUseStatusEqualTo(1)
                    .andEndStatusEqualTo(0).andAllocatStatusEqualTo(0);
            DaifaGgoodsTasks daifaGgoodsTask = new DaifaGgoodsTasks();
            daifaGgoodsTask.setEndStatus(1);
            //查询待拿货表
            //修改代拿货表状态为已截单
            //为发消息，拿到待拿货的id集合
            List<DaifaGgoodsTasks> daifaGgoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,"df_order_id");
            List<Long> dfOrderIds=new ArrayList<>();
            if (daifaGgoodsTasks.size()>0){
                daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTask, daifaGgoodsTasksExample);
                dfOrderIds= BeanMapper.getFieldList(daifaGgoodsTasks, "dfOrderId", Long.class);
            }
            daifaTradeMapper.updateByPrimaryKeySelective(trade);
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
    }

    /**
     * 发货
     *
     * @param delivery
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor ={Exception.class,RuntimeException.class})
    public void send(DeliveryBO delivery) throws DaifaException {
        if (delivery == null) {
            throw new DaifaException("deliceryBo为空");
        }
        if (delivery.getMarkDestination() == null || delivery.getDfTradeId() == null || delivery.getExpressCode() == null) {
            throw new DaifaException("主单id，三段码，快递单号都不能为空");
        }
        Date time=new Date();
        String date=DateUtil.dateToString(time,DateUtil.patternB);
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

        //把发货信息写入已发货表
        DaifaSend send = BeanMapper.map(delivery, DaifaSend.class);
        send.setSendStatus(2);
        send.setCreateTime(time);
        send.setCreateDate(date);
        daifaSendMapper.insertSelective(send);

        //更新代发货主表状态为已发货
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        DaifaWaitSend daifaWaitSend=new DaifaWaitSend();
        daifaWaitSend.setSendStatus(2);
        daifaWaitSendMapper.updateByExampleSelective(daifaWaitSend,daifaWaitSendExample);


        //设置待发货子表的查询和修改条件
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        //发货校验：1.有货先发：缺货部分如果没退款就不发货
        List<DaifaWaitSendOrder> daifaWaitSendOrders = daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample);
        for (DaifaWaitSendOrder waitSendOrder :daifaWaitSendOrders){
            if (waitSendOrder.getTakeGoodsStatus()==2&&(waitSendOrder.getRefundStatus()==null||waitSendOrder.getRefundStatus()!=2)){
                throw new DaifaException("缺货部分未退款，不能发货。");
            }
        }
        //修改已发货子表状态为已发货
        DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
        daifaWaitSendOrder.setSendStatus(2);
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);


        //查询子单信息填充已发货子单信息
        List<DaifaSendOrder> daifaSendOrders = BeanMapper.mapList(daifaWaitSendOrders, DaifaSendOrder.class);

        for (DaifaSendOrder d:daifaSendOrders){
            d.setCreateDate(date);
            d.setCreateTime(time);
            d.setTakeGoodsStatus(1);
            d.setSendStatus(2);
            d.setSendId(send.getSendId());
            d.setSellerId(delivery.getSellerId());
            daifaSendOrderMapper.insertSelective(d);
        }
    }

    /**
     * 自动退款处理
     * @param refundId 退单ID
     * @param subOrderIds 退单包含的子单信息
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor ={Exception.class,RuntimeException.class})
    public void autoRefund(Long refundId, List<Long> subOrderIds) throws DaifaException {
        //检测是否可以自动退款
        DaifaOrderExample orderExample=new DaifaOrderExample();
        orderExample.createCriteria().andDfOrderIdIn(subOrderIds).andOrderStatusNotEqualTo((long)SubOrderStatus.PAYED.getValue());
        if(daifaOrderMapper.countByExample(orderExample)>0){//有单子处在不可退状态
            throw new DaifaException("有部分子单已发或已拿");
        }
        //更新子单状态为已退款
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(subOrderIds);
        DaifaOrder daifaOrder=new DaifaOrder();
        daifaOrder.setRefundStatus(2);
        daifaOrder.setRefundId(refundId);
        daifaOrder.setRefundFinishTime(new Date());
        daifaOrderMapper.updateByExampleSelective(daifaOrder,daifaOrderExample);

        //更新已分配表状态为已退款
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoods daifaGgoods =new DaifaGgoods();
        daifaGgoods.setReturnStatus(2);
        daifaGgoods.setUseStatus(0);
        daifaGgoodsMapper.updateByExampleSelective(daifaGgoods,daifaGgoodsExample);

        //更新待分配表状态为已退款
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setReturnStatus(2);
        daifaGgoodsTasks.setUseStatus(0);
        daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTasks,daifaGgoodsTasksExample);

        //更新已发货表状态为已退款
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
        daifaSendOrder.setRefundStatus(2);
        daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder,daifaSendOrderExample);

        //更新待发货表状态为已退款
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
        log.info(messageTag + "------------" + messages);

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
        log.info("send body: " + new String(msg.getBody()));
        // 发送消息，只要不抛异常就是成功
        producer.sendAsync(msg, new SendCallback() {
            @Override
            public void onSuccess(final SendResult sendResult) {
                // 消费发送成功
                log.info("send success: " + sendResult.getMessageId());

            }

            @Override
            public void onException(OnExceptionContext context) {
                // 消息发送失败
                log.error("发送失败");
            }
        });


    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public OrderBO getOrderBO() {
        return orderBO;
    }

    public void setOrderBO(OrderBO orderBO) {
        this.orderBO = orderBO;
    }
}
