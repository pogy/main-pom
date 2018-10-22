package com.shigu.main4.daifa.process.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.bo.AutoRefundBo;
import com.shigu.main4.daifa.bo.MoveShopDataBO;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.enums.DaifaSendMqEnum;
import com.shigu.main4.daifa.enums.DaifaTradeStatus;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.exceptions.OrderNotFindException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.utils.MQUtil;
import com.shigu.main4.daifa.utils.Pingyin;
import com.shigu.main4.tools.SpringBeanFactory;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("orderManageProcess")
public class OrderManageProcessImpl implements OrderManageProcess {
    private static final Logger logger = LoggerFactory.getLogger(OrderManageProcessImpl.class);
    private final int MAX_TIME_OUT = 3;//3天为最大超时时间

    @Autowired
    DaifaTradeMapper daifaTradeMapper;

    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;
    @Autowired
    DaifaSendOrderMapper daifaSendOrderMapper;
    @Autowired
    DaifaWaitSendMapper daifaWaitSendMapper;
    @Autowired
    DaifaSellerMapper daifaSellerMapper;
    @Autowired
    DaifaAfterSaleSubMapper daifaAfterSaleSubMapper;
    @Autowired
    DaifaSendMapper daifaSendMapper;
    @Autowired
    MQUtil mqUtil;


    @Override
    public void newOrder(OrderBO order) {
        SpringBeanFactory.getBean(OrderModel.class, order).init();
    }

    /**
     * 备注
     *
     * @param subOrderId 子订单数据
     * @param mark       备注内容
     */
    @Override
    public void markSubOrder(Long subOrderId, String mark) throws DaifaException {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        subOrderModel.mark(mark);
    }

    /**
     * 客服查询备注
     * @param orderId 单号
     * @param mark 备注内容给
     */
    @Override
    public void addAfterRemark(Long orderId, String mark) throws DaifaException {
        DaifaTrade trade = daifaTradeMapper.selectFieldsByPrimaryKey(orderId,
                FieldUtil.codeFields("df_trade_id,after_remark"));
        if(trade == null){
            throw new DaifaException("不存在此订单",DaifaException.DEBUG);
        }
        if(StringUtils.isEmpty(trade.getAfterRemark())){
            trade.setAfterRemark(mark);
        }else{
            trade.setAfterRemark(trade.getAfterRemark()+"\n"+mark);
        }
        daifaTradeMapper.updateByPrimaryKeySelective(trade);
    }

    /**
     * 设置有货时间
     *
     * @param subOrderId 子订单数据
     * @param time       有货时间
     */
    @Override
    public void haveGoodsTime(Long subOrderId, Date time) throws DaifaException {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsTasksExample.setOrderByClause("create_time desc");
        daifaGgoodsTasksExample.setStartIndex(0);
        daifaGgoodsTasksExample.setEndIndex(1);
        List<DaifaGgoodsTasks> ts = daifaGgoodsTasksMapper.selectByConditionList(daifaGgoodsTasksExample);
        if (ts.size() == 0) {
            throw new DaifaException("订单不存在",DaifaException.DEBUG);
        }
        if(ts.get(0).getEndStatus()==1){
            throw new DaifaException("订单已截单",DaifaException.DEBUG);
        }
        if(ts.get(0).getReturnStatus()==2){
            throw new DaifaException("订单已退款",DaifaException.DEBUG);
        }
        if (ts.get(0).getAllocatStatus() == 1) {
            subOrderModel.noTake();
        }
        subOrderModel.haveGoodsTime(time);
    }

    /**
     * 标记下架
     *
     * @param subOrderId 子订单数据
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void markDown(Long subOrderId) throws DaifaException {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsTasksExample.setOrderByClause("create_time desc");
        daifaGgoodsTasksExample.setStartIndex(0);
        daifaGgoodsTasksExample.setEndIndex(1);
        List<DaifaGgoodsTasks> ts = daifaGgoodsTasksMapper.selectByConditionList(daifaGgoodsTasksExample);
        if (ts.size() == 0) {
            throw new DaifaException("订单不存在",DaifaException.DEBUG);
        }
        if(ts.get(0).getEndStatus()==1){
            throw new DaifaException("订单已截单",DaifaException.DEBUG);
        }
        if(ts.get(0).getReturnStatus()==2){
            throw new DaifaException("订单已退款",DaifaException.DEBUG);
        }
        if (ts.get(0).getAllocatStatus() == 1) {
            subOrderModel.noTake();
        }
        subOrderModel.markDown();
    }

    @Override
    public void orderTimeout() {
        //查出超时的单子
        DaifaSellerExample daifaSellerExample=new DaifaSellerExample();
        daifaSellerExample.createCriteria().andStatusEqualTo(1);
        List<DaifaSeller> sellers=daifaSellerMapper.selectByExample(daifaSellerExample);
        for(DaifaSeller s:sellers){
            if(s.getEndSpeed()!=null&&s.getEndSpeed()<1){
                continue;
            }
            int endSpeed=s.getEndSpeed();
            if(s.getEndSpeed()==null){
                endSpeed=3;
            }
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -endSpeed);
            Date minTime = cal.getTime();
            DaifaTradeExample example = new DaifaTradeExample();
            example.createCriteria().andTradeStatusIn(Arrays.asList(DaifaTradeStatus.PAYED.getValue(),DaifaTradeStatus.PACKING.getValue()))
                    .andIsOldEqualTo(0).andCreateTimeLessThan(minTime).andSellerIdEqualTo(s.getDfSellerId());
            List<DaifaTrade> timeoutTrades = daifaTradeMapper.selectFieldsByExample(example, FieldUtil.codeFields("df_trade_id"));
            timeoutTrades.forEach(t -> {
                try {
                    OrderModel orderModel = SpringBeanFactory.getBean(OrderModel.class, t.getDfTradeId());
                    orderModel.timeout();
                } catch (Exception e) {
                }
            });
        }
    }

    @Override
    public List<Long> tryRefund(String outerSubOrderId) throws OrderNotFindException {
        return refundChecked(outerSubOrderId,1);
    }

    @Override
    public void autoRefund(Long refundId, List<AutoRefundBo> bos) throws DaifaException {
        DaifaOrderExample daifaOrderExamplex=new DaifaOrderExample();
        daifaOrderExamplex.createCriteria().andRefundIdEqualTo(refundId);
        if(daifaOrderMapper.countByExample(daifaOrderExamplex)>0){
            throw new DaifaException("退款申请已存在");
        }
        List<Long> refundableIds=new ArrayList<>();
        List<String> soidps=new ArrayList<>();
        List<String> soidpsNum=new ArrayList<>();
        for(AutoRefundBo bo:bos){
            try {
                List<Long> tmps=refundChecked(bo.getSoid(),2);
                refundableIds.addAll(tmps);
                if(bo.getSoidps()!=null&&bo.getSoidps().size()>0){
                    if(soidpsNum.size()>0){
                        throw new DaifaException("退款失败,soidps和num只能存在一个",DaifaException.ERROR);
                    }
                    soidps.addAll(bo.getSoidps());
                }else{
                    if(soidps.size()>0){
                        throw new DaifaException("退款失败,soidps和num只能存在一个",DaifaException.ERROR);
                    }
                    if(bo.getNum()==null){
                        throw new DaifaException("退款失败,soidps和num至少存在一个",DaifaException.ERROR);
                    }
                    if(bo.getNum()<1){
                        throw new DaifaException("退款失败,数量不能小于1",DaifaException.ERROR);
                    }
                    if(bo.getNum()>tmps.size()){
                        throw new DaifaException("退款失败,申请数量大于可退数量",DaifaException.ERROR);
                    }
                    for(int i=0;i<bo.getNum();i++){
                        soidpsNum.add(tmps.get(i).toString());
                    }
                }
            } catch (OrderNotFindException e) {
                throw new DaifaException("退款失败,存在错误的单号",DaifaException.ERROR);
            }
        }
        if(soidps.size()>0){
            checked:
            for (String soidp : soidps) {
                for (Long refundableId : refundableIds) {
                    if (soidp.equals(refundableId + "")) {
                        continue checked;
                    }
                }
                throw new DaifaException("退款失败,可退款数量校验失败",DaifaException.ERROR);
            }
        }else{
            soidps=soidpsNum;
        }

        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andOrderPartitionIdIn(soidps);
        List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(daifaOrderExample, FieldUtil.codeFields("df_order_id,df_trade_id"));
        List<Long> oids=BeanMapper.getFieldList(orders,"dfOrderId",Long.class);
        OrderModel model=SpringBeanFactory.getBean(OrderModel.class,orders.get(0).getDfTradeId());
        try {
            model.autoRefund(refundId,oids);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 退款校验
     * @param outerSubOrderId
     * @param type 1:来自tryRefund查询,由于该查询作用是查询可申请退款的值,所以只查未在退款状态的数据
     *             2:来自autoRefund操作,该操作是同意退款,即还需要查出申请退款的数据
     * @return
     */
    private List<Long> refundChecked(String outerSubOrderId,int type) throws OrderNotFindException {
        DaifaOrderExample orderExample = new DaifaOrderExample();
        orderExample.createCriteria().andOrderCodeEqualTo(outerSubOrderId);
        List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(orderExample, FieldUtil.codeFields("df_order_id,order_partition_id,order_status"));
        if(orders.size()==0){
            throw new OrderNotFindException();
        }
        Map<Long, String> oidpMap = new HashMap<>();
        for (DaifaOrder o : orders) {
            if(o.getOrderStatus()!=SubOrderStatus.SENDED.getValue()){
                oidpMap.put(o.getDfOrderId(), o.getOrderPartitionId());
            }
        }
        if(oidpMap.size()==0){
            return new ArrayList<>();
        }
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        DaifaGgoodsTasksExample.Criteria ce=daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(new ArrayList<>(oidpMap.keySet()))
                .andOperateIsEqualTo(0)
                .andAllocatStatusEqualTo(0);
        if(type==1){
            ce.andReturnStatusEqualTo(0);
        }else{
            ce.andReturnStatusNotEqualTo(2);
        }
        daifaGgoodsTasksExample.setOrderByClause("delist_is desc,end_status desc,take_goods_status desc,youhuo_date desc");
        List<DaifaGgoodsTasks> tasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample, FieldUtil.codeFields("df_order_id,use_status,delist_is"));
        List<Long> oidps = new ArrayList<>();
        for (DaifaGgoodsTasks t : tasks) {
            if(t.getUseStatus()==0&&t.getDelistIs()==0){
                continue;
            }
            oidps.add(new Long(oidpMap.get(t.getDfOrderId())));
        }
        return oidps;
    }

    @Override
    public void putGoodsCode(Long goodsId, String goodsNo) throws DaifaException {
        if(goodsId==-1){
            throw new DaifaException("不支持修改",DaifaException.DEBUG);
        }
        DaifaOrderExample searchDaifaOrderExample=new DaifaOrderExample();
        searchDaifaOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        searchDaifaOrderExample.setStartIndex(0);
        searchDaifaOrderExample.setEndIndex(1);
        searchDaifaOrderExample.setOrderByClause("df_order_id desc");
        List<DaifaOrder> os=daifaOrderMapper.selectByConditionList(searchDaifaOrderExample);
        String storeGoodsCode=null;
        if(os.size()>0){
            storeGoodsCode= Pingyin.getPinYinHeadChar(os.get(0).getMarketName())+"_"+os.get(0).getStoreNum()+"_"+goodsNo;
        }
        DaifaOrder o1=new DaifaOrder();
        o1.setGoodsCode(goodsNo);
        if(!StringUtils.isEmpty(storeGoodsCode)){
            o1.setStoreGoodsCode(storeGoodsCode);
        }
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaOrderMapper.updateByExampleSelective(o1,daifaOrderExample);

        DaifaGgoodsTasks t=new DaifaGgoodsTasks();
        t.setGoodsCode(goodsNo);
        t.setStoreGoodsCode(o1.getStoreGoodsCode());
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaGgoodsTasksMapper.updateByExampleSelective(t,daifaGgoodsTasksExample);

        DaifaGgoods g=new DaifaGgoods();
        g.setGoodsCode(goodsNo);
        g.setStoreGoodsCode(o1.getStoreGoodsCode());
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaGgoodsMapper.updateByExampleSelective(g,daifaGgoodsExample);

        DaifaWaitSendOrder wso=new DaifaWaitSendOrder();
        wso.setGoodsCode(goodsNo);
        wso.setGgoodsCode(o1.getStoreGoodsCode());
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaWaitSendOrderMapper.updateByExampleSelective(wso,daifaWaitSendOrderExample);

        DaifaSendOrder so=new DaifaSendOrder();
        so.setGoodsCode(goodsNo);
        so.setStoreGoodsCode(o1.getStoreGoodsCode());
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaSendOrderMapper.updateByExampleSelective(so,daifaSendOrderExample);
    }
    /**
     * ====================================================================================
     * @方法名： dealWaitSendOrderDisplay
     * @user gzy 2017/10/16 13:08
     * @功能：修改未发订单的显示状态
     * @param: [dfTradeId, orderDisplay]
     * @return: void
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public void dealWaitSendOrderDisplay (Long dfTradeId, Integer orderDisplay) throws DaifaException {

        DaifaWaitSend wso=new DaifaWaitSend();
        wso.setDfTradeId (dfTradeId);
        wso.setOrderDisplay (orderDisplay);
        DaifaWaitSendExample daifaWaitSendExample=new DaifaWaitSendExample();
        daifaWaitSendExample.createCriteria ().andDfTradeIdEqualTo (dfTradeId);
        daifaWaitSendMapper.updateByExampleSelective (wso,daifaWaitSendExample);

    }

    @Override
    public void storeMove(MoveShopDataBO bo) {
        DaifaOrderExample orderExample=new DaifaOrderExample();
        orderExample.isDistinct();
        orderExample.createCriteria().andStoreIdEqualTo(bo.getShopId());
        List<DaifaOrder> osx=daifaOrderMapper.selectFieldsByExample(orderExample,FieldUtil.codeFields("goods_id"));
        Set<Long> goodsIds=osx.stream().map(DaifaOrder::getGoodsId).collect(Collectors.toSet());
        for(Long goodsId:goodsIds){
            DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaOrderExample.setStartIndex(0);
            daifaOrderExample.setEndIndex(1);
            List<DaifaOrder> os=daifaOrderMapper.selectByConditionList(daifaOrderExample);
            if(os.size()==0){
                continue;
            }
            DaifaOrder order=new DaifaOrder();
            order.setStoreNum(bo.getShopNum());
            order.setMarketName(bo.getMarketName());
            order.setFloorName(bo.getFloorName());
            order.setMarketId(bo.getMarketId());
            order.setFloorId(bo.getFloorId());
            order.setStoreGoodsCode ((Pingyin.getPinYinHeadChar (bo.getMarketName ()) + "_" + bo.getShopNum () + "_" + os.get(0).getGoodsCode()).replaceAll ("\\+","加"));
            daifaOrderExample=new DaifaOrderExample();
            daifaOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaOrderMapper.updateByExampleSelective(order,daifaOrderExample);

            DaifaGgoodsTasks tasks=BeanMapper.map(order,DaifaGgoodsTasks.class);
            DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaGgoodsTasksMapper.updateByExampleSelective(tasks,daifaGgoodsTasksExample);

            DaifaGgoods ggoods=BeanMapper.map(order,DaifaGgoods.class);
            DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
            daifaGgoodsExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaGgoodsMapper.updateByExampleSelective(ggoods,daifaGgoodsExample);

            DaifaWaitSendOrder daifaWaitSendOrder=BeanMapper.map(order,DaifaWaitSendOrder.class);
            DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
            daifaWaitSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);

            DaifaSendOrder daifaSendOrder=BeanMapper.map(order,DaifaSendOrder.class);
            DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
            daifaSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder,daifaSendOrderExample);

            DaifaAfterSaleSub daifaAfterSaleSub=BeanMapper.map(order,DaifaAfterSaleSub.class);
            DaifaAfterSaleSubExample daifaAfterSaleSubExample=new DaifaAfterSaleSubExample();
            daifaAfterSaleSubExample.createCriteria().andGoodsIdEqualTo(goodsId);
            daifaAfterSaleSubMapper.updateByExampleSelective(daifaAfterSaleSub,daifaAfterSaleSubExample);
        }
    }

    @Override
    public void getMessage(Integer refundId) {
        SpringBeanFactory.getBean(OrderModel.class).sendMessage(refundId);
    }

    @Override
    public void updateExpress(Long dfTreadeId, Long expressId, String expressCode,String expressName) {
        DaifaTrade daifaTrade=new DaifaTrade();
        daifaTrade.setExpressId(expressId);
        daifaTrade.setExpressName(expressName);
        daifaTrade.setExpressCode(expressCode);
        daifaTrade.setDfTradeId(dfTreadeId);
        int i = daifaTradeMapper.updateByPrimaryKeySelective(daifaTrade);

        DaifaSend daifaSend = new DaifaSend();
        daifaSend.setDfTradeId(dfTreadeId);
        daifaSend = daifaSendMapper.selectOne(daifaSend);
        daifaSend.setExpressCode(expressCode);
        daifaSend.setExpressId(expressId);
        daifaSend.setExpressName(expressName);
        int x = daifaSendMapper.updateByPrimaryKeySelective(daifaSend);

        DaifaWaitSend daifaWaitSend = new DaifaWaitSend();
        daifaWaitSend.setDfTradeId(dfTreadeId);
        daifaWaitSend = daifaWaitSendMapper.selectOne(daifaWaitSend);
        daifaWaitSend.setExpressCode(expressCode);
        daifaWaitSend.setExpressId(expressId);
        daifaWaitSend.setExpressName(expressName);
        int y = daifaWaitSendMapper.updateByPrimaryKeySelective(daifaWaitSend);

        JSONObject jsonObject = new JSONObject();
        java.util.Map map = new HashMap();
        map.put("expressId",expressId);
        map.put("expressCode",expressCode);
        map.put("orderId",daifaWaitSend.getTradeCode());
        jsonObject.put("data",map);
        jsonObject.put("msg", DaifaSendMqEnum.updateExpressCode.getMsg());
        jsonObject.put("status","true");
        mqUtil.sendMessage(DaifaSendMqEnum.updateExpressCode.getMessageKey()+daifaWaitSend.getTradeCode(),
                DaifaSendMqEnum.updateExpressCode.getMessageTag(),
                jsonObject.toString());
    }

}
