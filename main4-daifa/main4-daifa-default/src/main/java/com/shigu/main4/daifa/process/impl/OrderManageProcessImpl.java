package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.bo.OrderBO;
import com.shigu.main4.daifa.enums.DaifaTradeStatus;
import com.shigu.main4.daifa.enums.SubOrderStatus;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.OrderModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.tools.SpringBeanFactory;
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
        example.createCriteria().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PAYED.getValue());
        example.or().andCreateTimeLessThan(minTime).andTradeStatusEqualTo(DaifaTradeStatus.PACKING.getValue());
        List<DaifaTrade> timeoutTrades = daifaTradeMapper.selectFieldsByExample(example, FieldUtil.codeFields("df_trade_id"));
        timeoutTrades.forEach(t -> {
            OrderModel orderModel = SpringBeanFactory.getBean(OrderModel.class, t.getDfTradeId());
            orderModel.timeout();
        });
    }

    @Override
    public List<Long> tryRefund(String outerSubOrderId) {
        DaifaOrderExample orderExample = new DaifaOrderExample();
        orderExample.createCriteria().andOrderCodeEqualTo(outerSubOrderId).andOrderStatusNotEqualTo((long) SubOrderStatus.SENDED.getValue());
//        return daifaOrderMapper.countByExample(orderExample)>num;
        List<DaifaOrder> orders = daifaOrderMapper.selectFieldsByExample(orderExample, FieldUtil.codeFields("df_order_id,order_partition_id"));
        Map<Long, String> oidpMap = new HashMap<>();
        for (DaifaOrder o : orders) {
            oidpMap.put(o.getDfOrderId(), o.getOrderPartitionId());
        }
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(new ArrayList<>(oidpMap.keySet())).andUseStatusEqualTo(1).andOperateIsEqualTo(0)
                .andReturnStatusEqualTo(0).andAllocatStatusEqualTo(0);
        List<DaifaGgoodsTasks> tasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample, FieldUtil.codeFields("df_order_id"));
        List<Long> oidps = new ArrayList<>();
        for (DaifaGgoodsTasks t : tasks) {
            oidps.add(new Long(oidpMap.get(t.getDfOrderId())));
        }
        return oidps;
    }

    @Override
    public void autoRefund(Long refundId, List<String> soids, List<String> soidps) throws DaifaException {
        List<Long> refundableIds=new ArrayList<>();
        for(String soid:soids){
            refundableIds.addAll(tryRefund(soid));
        }
        checked:
        for (String soidp : soidps) {
            for (Long refundableId : refundableIds) {
                if (soidp.equals(refundableId + "")) {
                    continue checked;
                }
            }
            throw new DaifaException("退款失败,可退款数量校验失败");
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

}
