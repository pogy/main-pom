package com.shigu.order.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.ItemOrderLogistics;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.OrderNotFindException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.order.exceptions.TbSendException;
import com.shigu.main4.order.process.ItemOrderProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ShowOrderDetailVO;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.AfterSaleVO;
import com.shigu.order.vo.MyOrderDetailVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.tools.DateParseUtil;
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
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;

    @Autowired
    private OrderManageProcess orderManageProcess;
    @Autowired
    private ItemOrderProcess itemOrderProcess;
    @Autowired
    private MultipleMapper multipleMapper;


    public ShiguPager<MyOrderVO> selectMyOrderPager(OrderBO bo, Long userId) throws ParseException {
        return selectMyOrderPager(bo.getPage(), bo.getPageSize(), false,userId,bo,null);
    }

    public ShiguPager<MyOrderVO> selectMyOrderPager(Integer number, Integer size, boolean onlyRefund,Long userId,OrderBO bo,Integer shStatus) {
        ShiguPager<MyOrderVO> pager = new ShiguPager<>();
        pager.setNumber(number);
        int orderCount = itemOrderMapper.countMyOrderList(userId,bo,onlyRefund,shStatus);
        if (orderCount > 0) {
            List<MyOrderVO> myOrderVOS;
            // 查询数据
            pager.calPages(orderCount, size);
            //从订单来查,用mapper
            int startIndex = (number - 1) * size;
            myOrderVOS = itemOrderMapper.selectMyOrderList(userId,bo,startIndex,size,onlyRefund,shStatus);
            pager.setContent(myOrderVOS);
            packageMyOrderVO(pager.getContent());
        }
        return pager;
    }

    /**
     * 订单列表信息填充
     * @param myOrderVOList
     */
    public void packageMyOrderVO(List<MyOrderVO> myOrderVOList) {
        List<Long> orderIds = myOrderVOList.stream().map(MyOrderVO::getOrderId).collect(Collectors.toList());

        // 查询计算服务费信息， 按主单聚合服务费总数, Long 分 -> String 元
        ItemOrderServiceExample orderServiceExample = new ItemOrderServiceExample();
        orderServiceExample.createCriteria().andOidIn(orderIds);
        Map<Long, String> orderServiceMoneyMap = itemOrderServiceMapper.selectByExample(orderServiceExample).stream()
                .collect(Collectors.groupingBy(com.opentae.data.mall.beans.ItemOrderService::getOid)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.format("%.2f", entry.getValue().stream().mapToLong(com.opentae.data.mall.beans.ItemOrderService::getMoney).sum() * .01)));

        myOrderVOList.stream()
                .peek(o -> o.setServerPay(orderServiceMoneyMap.get(o.getOrderId())))
                .map(MyOrderVO::getChildOrders).flatMap(List::stream).forEach(subMyOrderVO -> {
            if (subMyOrderVO.getStockoutNum() == null || subMyOrderVO.getStockoutNum() == 0) {
                subMyOrderVO.setStockoutNum(null);
            }
            List<AfterSaleVO> afterSales = subMyOrderVO.getAfterSales();
            if (afterSales != null && !afterSales.isEmpty()) {
                subMyOrderVO.setRefundCount(afterSales.stream().filter(a -> a.getType() == 1 || a.getType() == 4).mapToInt(AfterSaleVO::getAfterSaleNum).sum());
                subMyOrderVO.setHasAfter(afterSales.stream().filter(a -> a.getType() == 2 || a.getType() == 3).count() > 0);
            }
        });
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
        ItemOrderLogistics t = new ItemOrderLogistics();
        t.setOid(orderId);
        List<ItemOrderLogistics> select = itemOrderLogisticsMapper.select(t);
        if (!select.isEmpty()) {
            ItemOrderLogistics logistics = select.get(0);
            OrderAddrInfoVO vo = new OrderAddrInfoVO();
            vo.setOrderId(orderId);
            vo.setAddress(logistics.getAddress());
            vo.setName(logistics.getName());
            vo.setPhone(logistics.getTelephone());
            return vo;
        }
        return null;
    }

    public ExpressInfoVO expressInfo(Long orderId) throws Main4Exception {
        return itemOrderService.expressInfo(orderId);
    }

    public MyOrderDetailVO orderDetail(Long orderId) throws Main4Exception, ParseException {
        MyOrderDetailVO vo = new MyOrderDetailVO();
        ShowOrderDetailVO orderVO = orderListService.selectMyorder(orderId);
        OrderBO orderBO = new OrderBO();
        orderBO.setOrderId(orderId);
        ShiguPager<MyOrderVO> pager = selectMyOrderPager(1, 1, false,null,orderBO,null);
        vo.setChildOrders(pager.getContent().get(0).getChildOrders());
        vo.setExpress(orderListService.selectExpress(orderId));
        vo.setOrderAddrInfo(expressAddrInfo(orderId));

        vo.setTotal(orderVO.getTotalVO());
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

    public boolean testRefund(Long subId) throws OrderNotFindException {
        ItemOrderSub sub = itemOrderSubMapper.selectByPrimaryKey(subId);
        return sub != null && orderManageProcess.tryRefund(subId.toString()).size() > 0;
    }

    public void tbSend(Long userId,Long oid) throws Main4Exception {
        ItemOrder o=itemOrderMapper.selectByPrimaryKey(oid);
        if(o==null){
            //订单不存在
            throw new Main4Exception("订单不存在");
        }
        if(o.getUserId().longValue()!=userId){
            //不是该用户的订单
            throw new Main4Exception("不是该用户的订单");
        }
        try {
            itemOrderProcess.tbSend(oid);
        } catch (TbSendException e) {
            throw new Main4Exception(e.getMessage());
        }
    }
}
