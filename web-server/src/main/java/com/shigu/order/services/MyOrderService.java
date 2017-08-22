package com.shigu.order.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.ShowOrderDetailVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.order.zfenums.RefundTypeEnum;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.*;
import com.shigu.tools.DateParseUtil;
import com.shigu.zf.utils.PriceConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @类编号
 * @类名称：MyOrderService
 * @文件路径：com.shigu.order.services.MyOrderService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/20 10:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class MyOrderService {
    @Autowired
    OrderListService orderListService;

    @Autowired
    ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private OrderManageProcess orderManageProcess;

    @Autowired
    private MultipleMapper multipleMapper;


    public ShiguPager<MyOrderVO> selectMyOrderPager(OrderBO bo, Long userId) throws ParseException {
        ShiguPager<MyOrderVO> pager = new ShiguPager<>();
        pager.setNumber(bo.getPage());
        ItemOrderExample orderExample = new ItemOrderExample();
        orderExample.setStartIndex((bo.getPage() - 1) * bo.getPageSize());
        orderExample.setEndIndex(bo.getPageSize());
        orderExample.setOrderByClause("item_order.create_time DESC");
        ItemOrderExample.Criteria orderCriteria = orderExample.createCriteria().andUserIdEqualTo(userId);

        if (bo.getOrderId() != null) {
            orderCriteria.andOidEqualTo(bo.getOrderId());
        }

        if (bo.getStatus() != null) {
            orderCriteria.andOrderStatusEqualTo(bo.getStatus());
        }

        if (bo.getSt() != null) {
            orderCriteria.andCreateTimeGreaterThanOrEqualTo(bo.getSt());
        }

        if (bo.getEt() != null) {
            orderCriteria.andCreateTimeLessThanOrEqualTo(bo.getEt());
        }

        ItemOrderSubExample subExample = new ItemOrderSubExample();
        ItemOrderSubExample.Criteria subExampleCriteria = subExample.createCriteria();
        if (StringUtils.isNotEmpty(bo.getGoodsNo())) {
            subExampleCriteria.andGoodsNoLike("%" + bo.getGoodsNo() + "%");
        }

        ItemOrderLogisticsExample logisticsExample = new ItemOrderLogisticsExample();
        ItemOrderLogisticsExample.Criteria logisticsExampleCriteria = logisticsExample.createCriteria();

        if (StringUtils.isNotEmpty(bo.getReceiver())) {
            logisticsExampleCriteria.andNameEqualTo(bo.getReceiver());
        }

        if (StringUtils.isNotEmpty(bo.getTelePhone())) {
            logisticsExampleCriteria.andTelephoneEqualTo(bo.getTelePhone());
        }

        MultipleExample multipleExample = MultipleExampleBuilder.from(orderExample)
                .innerJoin(subExample).on(subExample.createCriteria().equalTo(ItemOrderSubExample.oid, ItemOrderExample.oid))
                .leftJoin(logisticsExample).on(logisticsExample.createCriteria().equalTo(ItemOrderLogisticsExample.oid, ItemOrderExample.oid))
                .build();

        multipleExample.setDistinctCount(ItemOrderExample.oid);
        multipleExample.setOrderByClause("item_order.create_time DESC");
        int orderCount = multipleMapper.countByMultipleExample(multipleExample);

        if (orderCount > 0) {
            pager.calPages(orderCount, bo.getPageSize());
            pager.setContent(multipleMapper.selectFieldsByMultipleExample(multipleExample, MyOrderVO.class));
            List<Long> orderIds = pager.getContent().stream().map(MyOrderVO::getOrderId).collect(Collectors.toList());

            ItemOrderServiceExample orderServiceExample = new ItemOrderServiceExample();
            orderServiceExample.createCriteria().andOidIn(orderIds);
            Map<Long, List<com.opentae.data.mall.beans.ItemOrderService>> orderServiceMap
                    = itemOrderServiceMapper.selectByExample(orderServiceExample).stream().collect(Collectors.groupingBy(com.opentae.data.mall.beans.ItemOrderService::getOid));

            ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
            refundExample.createCriteria().andOidIn(orderIds);
            Map<Long, List<ItemOrderRefund>> refundMap
                    = itemOrderRefundMapper.selectByExample(refundExample).stream().collect(Collectors.groupingBy(ItemOrderRefund::getSoid));

            for (MyOrderVO myOrderVO : pager.getContent()) {
                List<SubMyOrderVO> childOrders = myOrderVO.getChildOrders();

                List<com.opentae.data.mall.beans.ItemOrderService> services = orderServiceMap.get(myOrderVO.getOrderId());
                if (services != null) {
                    int number = childOrders.stream().mapToInt(SubMyOrderVO::getNum).sum();
                    myOrderVO.setServerPay(String.format("%.2f", services.stream().mapToLong(s -> s.getMoney() * number).sum() * .01));
                }

                for (SubMyOrderVO subMyOrderVO : childOrders) {
                    List<ItemOrderRefund> itemOrderRefunds = refundMap.get(subMyOrderVO.getChildOrderId());
                    if (itemOrderRefunds != null) {
                        Map<Integer, ItemOrderRefund> typeGroup = itemOrderRefunds.stream().collect(Collectors.toMap(ItemOrderRefund::getType, r -> r));

                        for (Map.Entry<Integer, ItemOrderRefund> entry : typeGroup.entrySet()) {
                            RefundTypeEnum refundType = RefundTypeEnum.typeOf(entry.getKey());
                            switch (refundType) {
//                                case SYSTEM_REFUND:case ONLY_REFUND:
//                                    refundType == RefundTypeEnum.ONLY_REFUND
//                                    subMyOrderVO.setSqRefundId(r.getRefundId());
//                                    subMyOrderVO.setTkNum(r.getNumber());
//                                    subMyOrderVO.setTkState(RefundStateEnum.statusOf(r.getStatus()) == RefundStateEnum.ENT_REFUND ? 1 : 0);
//                                    subMyOrderVO.setBefore(entry.getValue().stream().map(r -> {
//                                        SendBeforeOrderRefundVO refundVO = new SendBeforeOrderRefundVO();
//                                        return refundVO;
//                                    }).collect(Collectors.toList()));
//                                    break;
//                                case GOODS_REFUND: case GOODS_CHANGE:
//                                    subMyOrderVO.setAfter(entry.getValue().stream().map(r -> {
//                                        SendedOrderRefundVO refundVO = new SendedOrderRefundVO();
//                                        refundVO.setShRefundId(r.getRefundId());
//                                        refundVO.setShTkNum(r.getNumber());
//                                        RefundStateEnum refundStateEnum = RefundStateEnum.statusOf(r.getStatus());
//                                        refundVO.setShState(RefundStateEnum.ENT_REFUND == refundStateEnum ? 2 : RefundStateEnum.NOT_REFUND == refundStateEnum ? 6 : 4);
//                                        if (refundType == RefundTypeEnum.GOODS_CHANGE) {
//                                            refundVO.setShState(refundVO.getShState() + 1);
//                                        }
//                                        return refundVO;
//                                    }).collect(Collectors.toList()));
                                    break;
                            }
                        }
                    }
                }
            }
        }
        return pager;
    }

    public boolean orderBelongTo(Long orderId, Long userId) {
        ItemOrder iorder = itemOrderMapper.selectByPrimaryKey(orderId);
        return iorder != null && userId.equals(iorder.getUserId());
    }

    public int removeOrder(Long orderId) {
        return orderListService.removeOrder(orderId);
    }

    public int cancelOrder(Long orderId) {
        return orderListService.cancelOrder(orderId);
    }

    public OrderDetailExpressVO expressDetail(Long orderId) throws Main4Exception, ParseException {
        return orderListService.selectExpress(orderId);
    }

    public OrderAddrInfoVO expressAddrInfo(Long orderId) {
        return orderListService.selectOrderAddrInfo(orderId);
    }

    public ExpressInfoVO expressInfo(Long orderId) throws Main4Exception {
        return itemOrderService.expressInfo(orderId);
    }

    public MyOrderDetailVO orderDetail(Long orderId) throws Main4Exception, ParseException {
        ShowOrderDetailVO orderVO = orderListService.selectMyorder(orderId);
        OrderAddrInfoVO addrVo = orderListService.selectOrderAddrInfo(orderId);
        OrderDetailExpressVO expressVO = orderListService.selectExpress(orderId);

        List<SubOrderInfoVO> list = orderListService.selectSubList(orderId);
        List<SubMyOrderVO> subs = toSubMyOrderVO(list);
        MyOrderDetailVO vo = new MyOrderDetailVO();
        vo.setChildOrders(subs);

        OrderDetailTotalVO totalVO = orderListService.selectTotal(orderId);

        vo.setExpress(expressVO);
        vo.setOrderAddrInfo(addrVo);
        vo.setTotal(totalVO);
        if (orderVO.getOrderCreateTimed() != null) {
            vo.setOrderCreateTime(orderVO.getOrderCreateTimed().getTime());
        }
        vo.setOrderId(orderId);
        if (orderVO.getPayTime() != null) {
            vo.setOrderDealTime(DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getPayTime()));
        }
        vo.setOrderStateNum(orderVO.getMainState().status);
        String[] orderStateText = {"提交订单", "买家付款", "商品发货", "交易完成"};
        vo.setOrderStateText(orderStateText);
        //

        String[] orderStatusTIme = new String[4];
        if (orderVO.getOrderCreateTimed() != null) {
            orderStatusTIme[0] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getOrderCreateTimed());

        }
        if (vo.getOrderDealTime() != null) {
            orderStatusTIme[1] = vo.getOrderDealTime();
        }
        if (orderVO.getSendTime() != null) {
            orderStatusTIme[2] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getSendTime());
        }
        if (orderVO.getFinishTimed() != null) {
            orderStatusTIme[3] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getFinishTimed());
        }

        vo.setOrderStateTime(orderStatusTIme);
        return vo;
    }

    public static List<SubMyOrderVO> toSubMyOrderVO(List<SubOrderInfoVO> list) {
        return list.stream().map(so -> {
            SubMyOrderVO sub = BeanMapper.map(so, SubMyOrderVO.class);
            sub.setChildOrderId(so.getSubOrderId());
            sub.setPrice(PriceConvertUtils.priceToString(so.getPrice()));
            sub.setSqRefundId(so.getPreSaleRefundId());
            sub.setShRefundId(so.getAfterSaleRefundId());
            return sub;
        }).collect(Collectors.toList());
    }


    public boolean testRefund(Long subId) {
        ItemOrderSub sub = itemOrderSubMapper.selectByPrimaryKey(subId);
        return sub != null && orderManageProcess.tryRefund(subId.toString()).size() == sub.getNum();
//        return true;
    }
}
