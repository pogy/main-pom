package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.bo.AutoRefundBo;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.enums.DaifaTradeStatus;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.exceptions.OrderNotFindException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderManageProcess")
public class OrderManageProcessImpl implements OrderManageProcess {

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

    @Override
    public void newOrder(OrderBO order) {
        SpringBeanFactory.getBean(OrderModel.class, order);
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
     * 售后备注
     * @param orderId 单号
     * @param mark 备注内容给
     */
    @Override
    public void addAfterRemark(Long orderId, String mark) throws DaifaException {
        DaifaTrade trade = daifaTradeMapper.selectFieldsByPrimaryKey(orderId,
                FieldUtil.codeFields("df_trade_id,after_remark"));
        if(trade == null){
            throw new DaifaException("不存在此订单");
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
            throw new DaifaException("订单不存在");
        }
        if(ts.get(0).getEndStatus()==1){
            throw new DaifaException("订单已截单");
        }
        if(ts.get(0).getReturnStatus()==2){
            throw new DaifaException("订单已退款");
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
    public void markDown(Long subOrderId) throws DaifaException {
        SubOrderModel subOrderModel = SpringBeanFactory.getBean(SubOrderModel.class, subOrderId);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(subOrderId);
        daifaGgoodsTasksExample.setOrderByClause("create_time desc");
        daifaGgoodsTasksExample.setStartIndex(0);
        daifaGgoodsTasksExample.setEndIndex(1);
        List<DaifaGgoodsTasks> ts = daifaGgoodsTasksMapper.selectByConditionList(daifaGgoodsTasksExample);
        if (ts.size() == 0) {
            throw new DaifaException("订单不存在");
        }
        if(ts.get(0).getEndStatus()==1){
            throw new DaifaException("订单已截单");
        }
        if(ts.get(0).getReturnStatus()==2){
            throw new DaifaException("订单已退款");
        }
        if (ts.get(0).getAllocatStatus() == 1) {
            subOrderModel.noTake();
        }
        subOrderModel.markDown();
    }

    @Override
    public void orderTimeout() {
        //查出超时的单子
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);
        Date minTime = cal.getTime();
        DaifaTradeExample example = new DaifaTradeExample();
        example.createCriteria().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PAYED.getValue()).andIsOldEqualTo (0);
        example.or().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PACKING.getValue()).andIsOldEqualTo (0);
        List<DaifaTrade> timeoutTrades = daifaTradeMapper.selectFieldsByExample(example, FieldUtil.codeFields("df_trade_id"));
        timeoutTrades.forEach(t -> {
            OrderModel orderModel = SpringBeanFactory.getBean(OrderModel.class, t.getDfTradeId());
            orderModel.timeout();
        });
    }

    @Override
    public List<Long> tryRefund(String outerSubOrderId) throws OrderNotFindException {
        return refundChecked(outerSubOrderId,1);
    }

    @Override
    public void autoRefund(Long refundId, List<AutoRefundBo> bos) throws DaifaException {
        List<Long> refundableIds=new ArrayList<>();
        List<String> soidps=new ArrayList<>();
        List<String> soidpsNum=new ArrayList<>();
        for(AutoRefundBo bo:bos){
            try {
                List<Long> tmps=refundChecked(bo.getSoid(),2);
                refundableIds.addAll(tmps);
                if(bo.getSoidps()!=null&&bo.getSoidps().size()>0){
                    if(soidpsNum.size()>0){
                        throw new DaifaException("退款失败,soidps和num只能存在一个");
                    }
                    soidps.addAll(bo.getSoidps());
                }else{
                    if(soidps.size()>0){
                        throw new DaifaException("退款失败,soidps和num只能存在一个");
                    }
                    if(bo.getNum()==null){
                        throw new DaifaException("退款失败,soidps和num至少存在一个");
                    }
                    if(bo.getNum()<1){
                        throw new DaifaException("退款失败,数量不能小于1");
                    }
                    if(bo.getNum()>tmps.size()){
                        throw new DaifaException("退款失败,申请数量大于可退数量");
                    }
                    for(int i=0;i<bo.getNum();i++){
                        soidpsNum.add(tmps.get(i).toString());
                    }
                }
            } catch (OrderNotFindException e) {
                throw new DaifaException("退款失败,存在错误的单号");
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
                throw new DaifaException("退款失败,可退款数量校验失败");
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
            throw new DaifaException("不支持修改");
        }
        DaifaOrder o1=new DaifaOrder();
        o1.setGoodsCode(goodsNo);
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaOrderMapper.updateByExampleSelective(o1,daifaOrderExample);

        DaifaGgoodsTasks t=new DaifaGgoodsTasks();
        t.setGoodsCode(goodsNo);
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaGgoodsTasksMapper.updateByExampleSelective(t,daifaGgoodsTasksExample);

        DaifaGgoods g=new DaifaGgoods();
        g.setGoodsCode(goodsNo);
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaGgoodsMapper.updateByExampleSelective(g,daifaGgoodsExample);

        DaifaWaitSendOrder wso=new DaifaWaitSendOrder();
        wso.setGoodsCode(goodsNo);
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaWaitSendOrderMapper.updateByExampleSelective(wso,daifaWaitSendOrderExample);

        DaifaSendOrder so=new DaifaSendOrder();
        so.setGoodsCode(goodsNo);
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andGoodsIdEqualTo(goodsId);
        daifaSendOrderMapper.updateByExampleSelective(so,daifaSendOrderExample);
    }


}
