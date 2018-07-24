package com.shigu.order.orderQuery;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.examples.ItemOrderServiceExample;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.order.vo.AfterSaleVO;
import com.shigu.order.vo.AfterSalingVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.order.vo.SubMyOrderVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类名：OrderQuery
 * 类路径：com.shigu.order.orderQuery.OrderQuery
 * 创建者：王浩翔
 * 创建时间：2017-09-28 14:17
 * 项目：main-pom
 * 描述：订单|售后查询，具体查询在子类实现
 */
public abstract class OrderQuery {
    protected abstract ItemOrderServiceMapper getItemOrderServiceMapper();
    protected abstract ItemOrderRefundMapper getItemOrderRefundMapper();
    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;
    /**
     * 获取订单记录数量
     * @return
     */
    protected abstract int selectCount();

    /**
     * 获取订单信息
     * @param number
     * @param size
     * @return
     */
    protected abstract List<MyOrderVO> selectOrderList(Integer number, Integer size);

    public ShiguPager<MyOrderVO> selectMyOrderPager(Integer number, Integer size) {
        ShiguPager<MyOrderVO> pager = new ShiguPager<>();
        pager.setNumber(number);
        int orderCount = selectCount();
        pager.calPages(orderCount,size);
        if (orderCount>0) {
            List<MyOrderVO> myOrderVOS = selectOrderList(number, size);
            if (myOrderVOS.size()>0) {
                packageMyOrderVO(myOrderVOS);
//                //set已拿货数量
//                myOrderVOS.forEach(myOrderVO -> {
//                    myOrderVO.getChildOrders().forEach(subMyOrderVO ->{
//                        ItemOrderSubExample itemOrderSubExample = new ItemOrderSubExample();
//                        itemOrderSubExample.createCriteria().andSoidEqualTo(subMyOrderVO.getChildOrderId());
//                        List<ItemOrderSub> itemOrderSubs = itemOrderSubMapper.selectByExample(itemOrderSubExample);
//                        ItemOrderSub itemOrderSub = itemOrderSubs.get(0);
//                        subMyOrderVO.setHaveTakeGoodsNum(itemOrderSub.getInStok());
//                        //System.out.println(itemOrderSub.getInStok());
//                    });
//                });
            }
            pager.setContent(myOrderVOS);
        }
        return pager;
    }

    /**
     * 订单列表信息填充
     *
     * @param myOrderVOS
     */
    public void packageMyOrderVO(List<MyOrderVO> myOrderVOS) {

        for (MyOrderVO myOrderVO : myOrderVOS) {
            myOrderVO.setTradeTime(myOrderVO.getTradeTime().replace(".0",""));

        }
        List<Integer> types = Arrays.asList(2, 3);
        List<Long> soids = myOrderVOS.stream().flatMap(myOrderVO -> myOrderVO.getChildOrders().stream())
                .map(SubMyOrderVO::getChildOrderId).collect(Collectors.toList());//子单单号集合
        if (soids != null && !soids.isEmpty()) {
            ItemOrderRefundExample itemOrderRefundExample = new ItemOrderRefundExample();
            itemOrderRefundExample.createCriteria().andSoidIn(soids).andTypeIn(types);
            List<ItemOrderRefund> afters = getItemOrderRefundMapper().selectByExample(itemOrderRefundExample);
            Map<Long, ItemOrderRefund> afterGroup = BeanMapper.list2Map(afters, "refundId", Long.class);
            myOrderVOS.forEach(myOrderVO -> {//主单
                myOrderVO.getChildOrders().forEach(subMyOrderVO -> {//子单
                    ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subMyOrderVO.getChildOrderId());
                    subMyOrderVO.setHaveTakeGoodsNum(itemOrderSub.getInStok());
                    if(myOrderVO.getPayTime()!=null){
                        try {
                            String fd= DateUtil.dateToString(myOrderVO.getPayTime(),DateUtil.patternB);
                            int day=new Integer(fd);
                            if(day>=20180110&&day<=20180224){
                                subMyOrderVO.setRestoreSaleAfterServiceIs(true);
                            }
                        } catch (Exception ignored) {
                        }
                    }
                    subMyOrderVO.getAfterSales().forEach(afterSaleVO -> {
                        afterSaleVO.setNewAfterSaleInfoIs(false);
                        if (types.contains(afterSaleVO.getType())) {
                            List<AfterSalingVO> afterSaling = new ArrayList<>();
                            ItemOrderRefund refund = afterGroup.get(afterSaleVO.getRefundId());
                            if (refund != null) {
                                afterSaleVO.setRefuseReason(refund.getFailMsg());
                                AfterSalingVO asa = new AfterSalingVO();
                                switch (refund.getRefundSubInfo()) {
                                    case 0:
                                    case 1:
                                    case 2: {
                                        asa.setType(refund.getRefundSubInfo());
                                        afterSaling.add(asa);
                                        break;
                                    }
                                    case 4: {
                                        asa.setType(5);
                                        afterSaling.add(asa);
                                        break;
                                    }
                                    case 3: {
                                        int number = refund.getType()==5?refund.getFailNumber():refund.getNumber();
                                        int failNumber = refund.getType()==5?refund.getFailNumber()-refund.getNumber():refund.getFailNumber();
                                        if (number - failNumber > 0&& refund.getStatus()>6) {
                                            asa.setType(4);
                                            asa.setOpeAfterSaleNum(refund.getNumber() - refund.getFailNumber());
                                            afterSaling.add(asa);
                                        }
                                        if (failNumber > 0) {
                                            asa=new AfterSalingVO();
                                            asa.setType(3);
                                            asa.setOpeAfterSaleNum(refund.getFailNumber());
                                            afterSaling.add(asa);
                                        }
                                        break;
                                    }
                                }
                                afterSaleVO.setNewAfterSaleInfoIs(!refund.getUserShow());
                            }
                            afterSaleVO.setAfterSaling(afterSaling);
                        }
                    });
                });
            });
        }

        List<Long> orderIds = myOrderVOS.stream().map(MyOrderVO::getOrderId).collect(Collectors.toList());
        // 查询计算服务费信息， 按主单聚合服务费总数, Long 分 -> String 元
        ItemOrderServiceExample orderServiceExample = new ItemOrderServiceExample();
        orderServiceExample.createCriteria().andOidIn(orderIds);
        Map<Long, String> orderServiceMoneyMap = getItemOrderServiceMapper().selectByExample(orderServiceExample).stream()
                .collect(Collectors.groupingBy(com.opentae.data.mall.beans.ItemOrderService::getOid)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.format("%.2f", entry.getValue().stream().mapToLong(com.opentae.data.mall.beans.ItemOrderService::getMoney).sum() * .01)));
        myOrderVOS.stream()
                .peek(o -> o.setServerPay(orderServiceMoneyMap.get(o.getOrderId())))
                .map(MyOrderVO::getChildOrders).flatMap(List::stream).forEach(subMyOrderVO -> {
            if (subMyOrderVO.getStockoutNum() == null || subMyOrderVO.getStockoutNum() == 0) {
                subMyOrderVO.setStockoutNum(null);
            }
            List<AfterSaleVO> afterSales = subMyOrderVO.getAfterSales();
            if (afterSales != null && !afterSales.isEmpty()) {
                //未发货退货数量
                subMyOrderVO.setRefundCount(afterSales.stream().filter(a -> a.getType() == 1 || a.getType() == 4 || a.getType() == 5).mapToInt(AfterSaleVO::getAfterSaleNum).sum());
                //根据是否有已发货后售后状态决定售后显示
                subMyOrderVO.setHasAfter(afterSales.stream().filter(a -> a.getType() == 2 || a.getType() == 3).count() > 0);
            }
        });
    }
}
