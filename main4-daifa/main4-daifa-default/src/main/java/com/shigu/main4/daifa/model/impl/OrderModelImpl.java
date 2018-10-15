package com.shigu.main4.daifa.model.impl;

import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.daifa.bo.*;
import com.shigu.main4.daifa.enums.DaifaListDealTypeEnum;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.utils.*;
import com.shigu.main4.daifa.utils.BigNumber;
import com.shigu.main4.daifa.utils.DaifaListDealUtil;
import com.shigu.main4.daifa.utils.Pingyin;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jmb on 2017/8/10.
 * Path com.shigu.main4.daifa.model.impl.OrderModelImpl
 */
@Repository
@Scope("prototype")
public class OrderModelImpl implements OrderModel {
    @Autowired
    WorkerMan workerMan;

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
    PackDeliveryProcess packDeliveryProcess;
    @Autowired
    RedisIO redisIO;
    @Autowired
    private MQUtil mqUtil;
    @Value("${DAIFA_IS_TEST}")
    private String daifaIsTest;
    @Value("${DAIFA_IS_PAY_TEST}")
    private String daifaIsPayTest;
    public OrderModelImpl(Long tid) {
        this.tid = tid;
    }

    public OrderModelImpl(OrderBO bo) {
        this.orderBO = bo;
    }
    public OrderModelImpl() {
    }

    /**
     * 创建订单
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
    public void init() {
        if (orderBO.getBuyer().getBuyerId().intValue() == 9968) {
            //测试账号的单子不写进来,如果是正式队列
            if ("false".equals(daifaIsTest)) {
                return;
            }
        }
        DaifaTradeExample example = new DaifaTradeExample();
        example.createCriteria().andTradeCodeEqualTo(orderBO.getOid().toString());
        int ki = daifaTradeMapper.countByExample(example);
        if (ki == 0) {//验证这个交易号在代发交易表中不存在
            DaifaTrade daifaTrade = new DaifaTrade();
            SubOrderModelBO subOrderModelBO = new SubOrderModelBO();
            daifaTrade.setDfTradeId(selTradeId());
            daifaTrade.setSellerId(orderBO.getSenderId());
            List<SubOrderBO> subOrders = orderBO.getSubOrders();
            daifaTrade.setTradeCode(orderBO.getOid().toString());
            int num = 0;
            BigNumber goodsFee = new BigNumber("0.00");
            Map<Long, ServiceBO> serviceBOMap = BeanMapper.list2Map(orderBO.getServices(), "soid", Long.class);
            for (SubOrderBO bo : subOrders) {
                num += bo.getNum();
            }
            daifaTrade.setGoodsNum((long) num);
            LogisticsBO logisticsBO = orderBO.getLogistics().get(0);

            String receiveName = logisticsBO.getName().replaceAll("\\+", "");
            daifaTrade.setReceiverName(receiveName);


            daifaTrade.setReceiverPhone(logisticsBO.getTelephone());
            daifaTrade.setReceiverState(logisticsBO.getProv());
            /////////////////////////==============地址处理start===========///////////////////////////
            String addrs = logisticsBO.getAddress();
            if (logisticsBO.getProv() != null && !"".equals(logisticsBO.getProv()) && logisticsBO.getProv().endsWith("省")) {
                addrs = addrs.replaceAll(logisticsBO.getProv(), "");
            }
            String prov = logisticsBO.getProv();
            if (prov != null && !"".equals(prov)) {
                if (prov.endsWith("省") || prov.endsWith("市") || "香港".equals(prov) || "澳门".equals(prov)) {
                    addrs = addrs.replaceAll(prov, "");
                } else {
                    if ("广西".equals(prov)) {
                        addrs = addrs.replaceAll("广西壮族自治区", "");
                    } else if ("宁夏".equals(prov)) {
                        addrs = addrs.replaceAll("宁夏回族自治区", "");
                    } else if ("新疆".equals(prov)) {
                        addrs = addrs.replaceAll("新疆维吾尔自治区", "");
                    } else if ("西藏".equals(prov)) {
                        addrs = addrs.replaceAll("西藏自治区", "");
                    } else if ("内蒙古".equals(prov)) {
                        addrs = addrs.replaceAll("内蒙古自治区", "");
                    }

                }
            }

            if (logisticsBO.getCity() != null && !"".equals(logisticsBO.getCity())) {
                addrs = addrs.replaceAll(logisticsBO.getCity(), "");
            }
            if (logisticsBO.getTown() != null && !"".equals(logisticsBO.getTown())) {
                addrs = addrs.replaceAll(logisticsBO.getTown(), "");
            }
            addrs = addrs.replaceAll("null", "");
            addrs = addrs.replaceAll(" ", "");
            addrs = addrs.replaceAll(",", "");
            addrs = addrs.replaceAll("，", "");
            addrs = addrs.replaceAll("\\+", "");
            ////////////////////////===============地址处理end============/////////////////////////////
            if (logisticsBO.getTown() != null) {
                daifaTrade.setReceiverAddress(logisticsBO.getProv() + " " + logisticsBO.getCity() + " " + logisticsBO.getTown() + " " + addrs.trim());
            } else {
                daifaTrade.setReceiverAddress(logisticsBO.getProv() + " " + logisticsBO.getCity() + " " + addrs.trim());//区为空
            }


            daifaTrade.setDaifaType(orderBO.getType());
            daifaTrade.setExpressId(logisticsBO.getCompanyId());
            daifaTrade.setExpressName(logisticsBO.getCompany());
            daifaTrade.setTradeStatus(1);//已付款待分配
            daifaTrade.setSendStatus(1);
            daifaTrade.setCreateTime(new Date());
            daifaTrade.setLastDoTime(new Date());
            daifaTrade.setBuyerRemark(orderBO.getBuyRemark());

            daifaTrade.setBarCodeKey(daifaListDealUtil.queryListCode(DaifaListDealTypeEnum.TRADE_SORT, orderBO.getSenderId(), null));
            if (orderBO.getBuyer() != null) {
                daifaTrade.setBuyerWw(orderBO.getBuyer().getAliWw());
                daifaTrade.setBuyerNick(orderBO.getBuyer().getNickInMarket());
                daifaTrade.setBuyerQq(orderBO.getBuyer().getImQq());
                daifaTrade.setBuyerTelephone(orderBO.getBuyer().getPhone());
                daifaTrade.setBuyerId(orderBO.getBuyer().getBuyerId());
            }
            List<ServiceBO> services = orderBO.getServices();
            BigNumber serviceTradeFee = new BigNumber("0.00");
            if (services != null) {
                for (ServiceBO bo : services) {
                    serviceTradeFee = serviceTradeFee.Add(new BigNumber(bo.getMoney()));
                }
            }
            daifaTrade.setTradeDiscountFee("0.00");
            daifaTrade.setExpressFee(logisticsBO.getMoney());
            daifaTrade.setServicesFee(PriceConvertUtils.stringPriceToString(serviceTradeFee.toString()));
            daifaTrade.setGoodsFee(PriceConvertUtils.stringPriceToString(goodsFee.toString()));
            daifaTrade.setTotalFee(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            daifaTrade.setMoney(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            daifaTrade.setRealPayMoney(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            daifaTradeMapper.insertSelective(daifaTrade);

            int i = 0;
            for (SubOrderBO bo : subOrders) {
                subOrderModelBO.setOrderCode(bo.getSoid().toString());
                if (bo.getSoidps().size() > 0) {
                    for (Long soidp : bo.getSoidps()) {
                        i++;
                        subOrderModelBO.setOrderPartitionId(soidp.toString());
                        subOrderModelBO.setMarketId(bo.getMarketId());
                        subOrderModelBO.setMarketName(bo.getMarketName());
                        subOrderModelBO.setFloorId(bo.getFloorId());
                        subOrderModelBO.setFloorName(bo.getFloor());
                        subOrderModelBO.setStoreId(bo.getShopId());
                        subOrderModelBO.setStoreNum(bo.getShopNum());
                        subOrderModelBO.setGoodsId(bo.getGoodsId());
                        subOrderModelBO.setGoodsCode(StringUtils.isEmpty(bo.getGoodsNo()) ? null : bo.getGoodsNo());
                        String goodsNo = bo.getGoodsNo();
                        if (goodsNo != null) {
                            goodsNo = goodsNo.replaceAll("\\+", "加");
                            subOrderModelBO.setGoodsCode(goodsNo);
                        }


                        subOrderModelBO.setTitle(bo.getTitle());
                        String title = subOrderModelBO.getTitle().replaceAll("\\+", "加");
                        subOrderModelBO.setTitle(title);

                        subOrderModelBO.setPicPath(bo.getPicUrl());
                        subOrderModelBO.setStoreGoodsCode(Pingyin.getPinYinHeadChar(bo.getMarketName()) + "_" + bo.getShopNum() + "_" + bo.getGoodsNo());
                        String StoreGoodsCode = subOrderModelBO.getStoreGoodsCode().replaceAll("\\+", "加");
                        subOrderModelBO.setStoreGoodsCode(StoreGoodsCode);

                        subOrderModelBO.setOrderDiscountFee("0.00");
                        subOrderModelBO.setPropStr(bo.getColor() + ":" + bo.getSize());
                        String prop = subOrderModelBO.getPropStr().replaceAll("\\+", "加");
                        subOrderModelBO.setPropStr(prop);

                        subOrderModelBO.setGoodsNum(1);
                        subOrderModelBO.setSinglePiPrice(bo.getSinglePay());
                        subOrderModelBO.setSellerId(orderBO.getSenderId());
                        subOrderModelBO.setOrderStatus(1L);
                        subOrderModelBO.setAggrement(orderBO.getAggrement());
                        subOrderModelBO.setTradeCode(daifaTrade.getTradeCode());
                        subOrderModelBO.setWebSite(bo.getWebSite());
                        subOrderModelBO.setDfTradeId(daifaTrade.getDfTradeId());
                        if (num > 1) {
                            subOrderModelBO.setBarCodeKeyNum(num + "-" + i);
                        }
                        subOrderModelBO.setGoodsWeight(bo.getWeight());//重量
                        if (serviceBOMap != null && serviceBOMap.size() > 0) {
                            if (serviceBOMap.get(bo.getSoid()) != null) {
                                BigDecimal serviceFeeSum = new BigDecimal(serviceBOMap.get(bo.getSoid()).getMoney());
                                BigDecimal serviceFee = serviceFeeSum.divide(new BigDecimal(bo.getNum()), 2, BigDecimal.ROUND_DOWN);
                                subOrderModelBO.setSingleServicesFee(PriceConvertUtils.doublePriceToString(serviceFee.doubleValue()));
                                subOrderModelBO.setTotalServiceFee(PriceConvertUtils.doublePriceToString(serviceFee.doubleValue()));
                            } else {
                                subOrderModelBO.setSingleServicesFee("0.00");
                                subOrderModelBO.setTotalServiceFee("0.00");
                            }
                        } else {
                            subOrderModelBO.setSingleServicesFee("0.00");
                            subOrderModelBO.setTotalServiceFee("0.00");
                        }
                        subOrderModelBO.setSinglePay(MoneyUtil.dealPrice(MoneyUtil.StringToLong(bo.getSinglePay()) + MoneyUtil.StringToLong(subOrderModelBO.getSingleServicesFee())));
                        subOrderModelBO.setTotalFee(subOrderModelBO.getSinglePay());
                        SpringBeanFactory.getBean(SubOrderModel.class, subOrderModelBO);
                        BigNumber singlePay = new BigNumber(bo.getSinglePay());
                        goodsFee = goodsFee.Add(singlePay);
                    }
                }
            }
            DaifaTrade t = new DaifaTrade();
            t.setDfTradeId(daifaTrade.getDfTradeId());
            t.setGoodsFee(PriceConvertUtils.stringPriceToString(goodsFee.toString()));
            t.setTotalFee(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            t.setMoney(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            t.setRealPayMoney(PriceConvertUtils.stringPriceToString(serviceTradeFee.Add(goodsFee).Add(new BigNumber(logisticsBO.getMoney())).toString()));
            daifaTradeMapper.updateByPrimaryKeySelective(t);
        }
    }

    /**
     * 订单超时
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
    public void timeout() {
        DaifaTrade trade = daifaTradeMapper.selectByPrimaryKey(tid);
        Date createTime = trade.getCreateTime();
        TypeConvert.dateAddDay(createTime, 3);
        //判断是否超时
        if (createTime.getTime() < System.currentTimeMillis()) {
            DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andDfTradeIdEqualTo(tid)
                    .andReturnStatusEqualTo(0).andUseStatusEqualTo(1).andOperateIsEqualTo(0)
                    .andEndStatusEqualTo(0).andAllocatStatusEqualTo(0);
            daifaGgoodsTasksExample.or().andDfTradeIdEqualTo(tid)
                    .andReturnStatusEqualTo(0).andUseStatusEqualTo(0).andDelistIsEqualTo(1)
                    .andOperateIsEqualTo(0).andEndStatusEqualTo(0).andAllocatStatusEqualTo(0);
            DaifaGgoodsTasks daifaGgoodsTask = new DaifaGgoodsTasks();
            daifaGgoodsTask.setEndStatus(1);
            daifaGgoodsTask.setReturnStatus(1);
            //查询待拿货表
            //修改代拿货表状态为已截单
            //为发消息，拿到待拿货的id集合
            List<DaifaGgoodsTasks> daifaGgoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample, FieldUtil.codeFields("tasks_id,df_order_id"));
            List<Long> dfOrderIds;
            if (daifaGgoodsTasks.size() > 0) {
                daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTask, daifaGgoodsTasksExample);
                dfOrderIds = BeanMapper.getFieldList(daifaGgoodsTasks, "dfOrderId", Long.class);
                DaifaOrderExample orderExample = new DaifaOrderExample();
                orderExample.createCriteria().andDfOrderIdIn(dfOrderIds);
                DaifaOrder order = new DaifaOrder();
                order.setRefundStatus(1);
                daifaOrderMapper.updateByExampleSelective(order, orderExample);
                List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(orderExample, FieldUtil.codeFields("df_order_id,order_partition_id"));
                List<String> pcodes = BeanMapper.getFieldList(orders, "orderPartitionId", String.class);
                JSONObject jsonObject = new JSONObject();
                Map<String, Object> map = new HashMap<>();
                map.put("orderId", trade.getTradeCode());
                map.put("refundSubOrderIds", pcodes);
                jsonObject.put("data", map);
                jsonObject.put("msg", DaifaSendMqEnum.cutOff.getMsg());
                jsonObject.put("status", "true");
                String message = jsonObject.toString();
                mqUtil.sendMessage(DaifaSendMqEnum.cutOff.getMessageKey() + trade.getTradeCode(),
                        DaifaSendMqEnum.cutOff.getMessageTag(), message);

            }
        }
    }

    /**
     * 发货
     *
     * @param delivery
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
    public void send(DeliveryBO delivery) throws DaifaException {
        if (delivery == null) {
            throw new DaifaException("deliceryBo为空", DaifaException.DEBUG);
        }
        //手动发货接口进来的
        if (delivery.getTag() == 2) {
            if (delivery.getDfTradeId() == null || delivery.getExpressCode() == null) {
                throw new DaifaException("主单id，快递单号都不能为空", DaifaException.DEBUG);
            }
        }else if (delivery.getMarkDestination() == null || delivery.getDfTradeId() == null || delivery.getExpressCode() == null) {
            throw new DaifaException("主单id，三段码，快递单号都不能为空", DaifaException.DEBUG);
        }
        //发货校验：1.有货先发：缺货部分如果没退款就不发货
        DaifaWaitSendOrderExample daifaWaitSendOrderExample = new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        List<DaifaWaitSendOrder> daifaWaitSendOrders = daifaWaitSendOrderMapper.selectByExample(daifaWaitSendOrderExample);
        for (DaifaWaitSendOrder waitSendOrder : daifaWaitSendOrders) {
            if (waitSendOrder.getTakeGoodsStatus() == 2 && (waitSendOrder.getRefundStatus() == null || waitSendOrder.getRefundStatus() != 2)) {
                throw new DaifaException("缺货部分未退款，不能发货。", DaifaException.DEBUG);
            }
        }
        Date time = new Date();
        String date = DateUtil.dateToString(time, DateUtil.patternB);
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
        send.setSendDate(date);
        send.setSendTime(time);
        daifaSendMapper.insertSelective(send);

        //更新代发货主表状态为已发货
        DaifaWaitSendExample daifaWaitSendExample = new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria().andDfTradeIdEqualTo(delivery.getDfTradeId());
        DaifaWaitSend daifaWaitSend = new DaifaWaitSend();
        daifaWaitSend.setSendStatus(2);
        daifaWaitSend.setSendDate(date);
        daifaWaitSend.setSendTime(time);
        daifaWaitSendMapper.updateByExampleSelective(daifaWaitSend, daifaWaitSendExample);


        //设置待发货子表的查询和修改条件

        //修改已发货子表状态为已发货
        DaifaWaitSendOrder daifaWaitSendOrder = new DaifaWaitSendOrder();
        daifaWaitSendOrder.setSendStatus(2);
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder, daifaWaitSendOrderExample);


        //查询子单信息填充已发货子单信息
        List<DaifaSendOrder> daifaSendOrders = BeanMapper.mapList(daifaWaitSendOrders, DaifaSendOrder.class);

        for (DaifaSendOrder d : daifaSendOrders) {
            d.setCreateDate(date);
            d.setCreateTime(time);
            d.setSendStatus(2);
            d.setSendId(send.getSendId());
            d.setSellerId(delivery.getSellerId());
            daifaSendOrderMapper.insertSelective(d);
        }
        DaifaTrade t = daifaTradeMapper.selectByPrimaryKey(trade.getDfTradeId());
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", t.getTradeCode());
        map.put("expressId",delivery.getExpressId());
        map.put("expressCode", delivery.getExpressCode());
        JSONObject obj = new JSONObject();
        obj.put("data", map);
        obj.put("msg", "全单发货");
        obj.put("status", true);
        mqUtil.sendMessage(DaifaSendMqEnum.sendAll.getMessageKey() + t.getTradeCode(),
                DaifaSendMqEnum.sendAll.getMessageTag(), obj.toString());
    }

    /**
     * 自动退款处理
     *
     * @param refundId    退单ID
     * @param subOrderIds 退单包含的子单信息
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
    public void autoRefund(Long refundId, List<Long> subOrderIds) throws DaifaException {
        //检测是否可以自动退款
        List<Integer> sts = new ArrayList<>();
        sts.add(SubOrderStatus.NO_PAY.getValue());
        sts.add(SubOrderStatus.SENDED.getValue());
        DaifaOrderExample orderExample = new DaifaOrderExample();
        orderExample.createCriteria().andDfOrderIdIn(subOrderIds).andOrderStatusIn(sts);
        if (daifaOrderMapper.countByExample(orderExample) > 0) {//有单子处在不可退状态
            throw new DaifaException("有部分子单暂不可退款", DaifaException.DEBUG);
        }
        //更新子单状态为已退款
        DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(subOrderIds);
        DaifaOrder daifaOrder = new DaifaOrder();
        daifaOrder.setRefundStatus(2);
        daifaOrder.setRefundId(refundId);
        daifaOrder.setRefundFinishTime(new Date());
        daifaOrderMapper.updateByExampleSelective(daifaOrder, daifaOrderExample);

        //更新已分配表状态为已退款
        DaifaGgoodsExample daifaGgoodsExample = new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoods daifaGgoods = new DaifaGgoods();
        daifaGgoods.setReturnStatus(2);
        daifaGgoods.setUseStatus(0);
        daifaGgoodsMapper.updateByExampleSelective(daifaGgoods, daifaGgoodsExample);

        //更新待分配表状态为已退款
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoodsTasks daifaGgoodsTasks = new DaifaGgoodsTasks();
        daifaGgoodsTasks.setReturnStatus(2);
        daifaGgoodsTasks.setUseStatus(0);
        daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTasks, daifaGgoodsTasksExample);

        //更新已发货表状态为已退款
        DaifaSendOrderExample daifaSendOrderExample = new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaSendOrder daifaSendOrder = new DaifaSendOrder();
        daifaSendOrder.setRefundStatus(2);
        daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder, daifaSendOrderExample);

        //更新待发货表状态为已退款
        DaifaWaitSendOrderExample daifaWaitSendOrderExample = new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(tid).andDfOrderIdIn(subOrderIds);
        DaifaWaitSendOrder daifaWaitSendOrder = new DaifaWaitSendOrder();
        daifaWaitSendOrder.setRefundStatus(2);
        daifaWaitSendOrder.setRefundTime(new Date());
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder, daifaWaitSendOrderExample);
        sendRefundMq(refundId.toString(), null);
    }

    @Override
    public void sendMessage(Integer refundId) {
        String refund = refundId.toString();
        String msg = null;
        sendRefundMq(refund, msg);
    }

    /**
     * 退款
     *
     * @param refundId
     * @param msg
     */
    private void sendRefundMq(String refundId, String msg) {
        //做正式和测试区分
        if ("true".equals(daifaIsTest)) {
            if ("false".equals(daifaIsPayTest)) {
                return;
            }
        }
        JSONObject obj = new JSONObject();

        if (msg == null) {
            JSONObject o1 = new JSONObject();
            o1.put("refundId", refundId);
            obj.put("data", o1);
            obj.put("msg", DaifaSendMqEnum.refund.getMsg());
            obj.put("status", true);
        } else {
            obj.put("msg", msg);
            obj.put("status", false);
        }
        mqUtil.sendMessage(DaifaSendMqEnum.refund.getMessageKey() + refundId,
                DaifaSendMqEnum.refund.getMessageTag(),
                obj.toString());

        //判断当前订单是否未发货且处于可发货状态,如果是,则尝试获取快递单号
        try {
            packDeliveryProcess.queryExpressCode(tid);
        } catch (DaifaException ignored) {
        }
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
