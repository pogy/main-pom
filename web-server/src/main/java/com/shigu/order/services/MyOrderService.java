package com.shigu.order.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.order.bo.OrderBO;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.order.vo.MyOrderDetailVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.order.vo.SubMyOrderVO;
import com.shigu.tools.DateParseUtil;
import com.shigu.zf.utils.PriceConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
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

        ItemOrderServiceExample serviceExample = new ItemOrderServiceExample();
        ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
        ItemOrderRefundExample changeRefundExample = new ItemOrderRefundExample();

        MultipleExample multipleExample = MultipleExampleBuilder.from(orderExample)
                .innerJoin(subExample).on(subExample.createCriteria().equalTo(ItemOrderSubExample.oid, ItemOrderExample.oid))
                .leftJoin(logisticsExample).on(logisticsExample.createCriteria().equalTo(ItemOrderLogisticsExample.oid, ItemOrderExample.oid))
                .leftJoin(serviceExample).on(serviceExample.createCriteria().equalTo(ItemOrderServiceExample.oid, ItemOrderExample.oid))
                .leftJoin(refundExample).on(refundExample.createCriteria().equalTo(ItemOrderRefundExample.oid,ItemOrderExample.oid).equalTo(ItemOrderRefundExample.soid,ItemOrderSubExample.soid).andTypeEqualTo(1))
                .leftJoin(changeRefundExample).on(changeRefundExample.createCriteria().equalTo(changeRefundExample.getColumn(ItemOrderRefundExample.oid), ItemOrderExample.oid).equalTo(changeRefundExample.getColumn(ItemOrderRefundExample.soid), ItemOrderSubExample.soid).andTypeNotEqualTo(1))
                .build();

        multipleExample.setDistinctCount(ItemOrderExample.oid);
        multipleExample.setOrderByClause("item_order.create_time DESC");
        int orderCount = multipleMapper.countByMultipleExample(multipleExample);

        if (orderCount > 0) {
            pager.calPages(orderCount, bo.getPageSize());
            pager.setContent(multipleMapper.selectFieldsByMultipleExample(multipleExample, MyOrderVO.class));
            for (MyOrderVO myOrderVO : pager.getContent()) {
                String serverPay = myOrderVO.getServerPay();
                if (serverPay != null) {
                    double serviceFee = Double.valueOf(serverPay) * myOrderVO.getChildOrders().stream().mapToInt(SubMyOrderVO::getNum).sum();
                    myOrderVO.setServerPay(String.format("%.2f", serviceFee));
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
        totalVO.setServicePrice(PriceConvertUtils.priceToString(totalVO.getServicePriceLong()));
        totalVO.setOrderTotalPrice(PriceConvertUtils.priceToString(totalVO.getOrderTotalPriceLong()));
        totalVO.setExpressPrice(PriceConvertUtils.priceToString(totalVO.getExpressPriceLong()));
        totalVO.setChildOrdersPrice(PriceConvertUtils.priceToString(totalVO.getChildOrdersPriceLong()));


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
