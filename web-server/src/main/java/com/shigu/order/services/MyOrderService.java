package com.shigu.order.services;

import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.*;
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
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.orderQuery.OrderQuery;
import com.shigu.order.orderQuery.QueryByOrder;
import com.shigu.order.vo.MyOrderDetailVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.tools.DateParseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
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
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private OrderManageProcess orderManageProcess;
    @Autowired
    private ItemOrderProcess itemOrderProcess;
    @Autowired
    private MultipleMapper multipleMapper;
    @Autowired
    OrderProvMapper orderProvMapper;
    @Autowired
    OrderCityMapper orderCityMapper;
    @Autowired
    OrderTownMapper orderTownMapper;


    public ShiguPager<MyOrderVO> selectMyOrderPager(OrderBO bo, Long userId) {
        //return selectMyOrderPager(bo.getPage(), bo.getPageSize(), false, userId, bo, null);
        OrderQuery orderQuery = SpringBeanFactory.getBean(QueryByOrder.class,userId, bo);
        return orderQuery.selectMyOrderPager(bo.getPage(),bo.getPageSize());
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
            String address="";
            OrderProv prov=orderProvMapper.selectByPrimaryKey(logistics.getProvId());
            OrderCity city=orderCityMapper.selectByPrimaryKey(logistics.getCityId());
            address+=prov.getProvName()+" "+city.getCityName()+" ";
            if(logistics.getTownId()!=null){
                OrderTown town=orderTownMapper.selectByPrimaryKey(logistics.getTownId());
                if(town!=null){
                    address+=town.getTownName()+" ";
                }
            }
            address+=logistics.getAddress();
            OrderAddrInfoVO vo = new OrderAddrInfoVO();
            vo.setOrderId(orderId);
            vo.setAddress(address);
            vo.setName(logistics.getName());
            vo.setPhone(logistics.getTelephone());
            return vo;
        }
        return null;
    }

    public ExpressInfoVO expressInfo(Long orderId) throws Main4Exception {
        return itemOrderService.expressInfo(orderId);
    }

    public MyOrderDetailVO orderDetail(Long orderId,Long userId) throws Main4Exception, ParseException {
        MyOrderDetailVO vo = new MyOrderDetailVO();
        ShowOrderDetailVO orderVO = orderListService.selectMyorder(orderId);
        OrderBO orderBO = new OrderBO();
        orderBO.setOrderId(orderId);
        //ShiguPager<MyOrderVO> pager = selectMyOrderPager(1, 1, false, null, orderBO, null);
        ShiguPager<MyOrderVO> pager = SpringBeanFactory.getBean(QueryByOrder.class,userId, orderBO).selectMyOrderPager(1, 1);
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

    public void tbSend(Long userId, Long oid) throws Main4Exception {
        ItemOrder o = itemOrderMapper.selectByPrimaryKey(oid);
        if (o == null) {
            //订单不存在
            throw new Main4Exception("订单不存在");
        }
        if (o.getUserId().longValue() != userId) {
            //不是该用户的订单
            throw new Main4Exception("不是该用户的订单");
        }
        try {
            itemOrderProcess.tbSend(oid);
        } catch (TbSendException e) {
            throw new Main4Exception(e.getMessage());
        }
    }

    public void moreTbSend(Long userId,List<Long> oids) throws Main4Exception {
        ItemOrderExample itemOrderExample=new ItemOrderExample();
        itemOrderExample.createCriteria().andOidIn(oids);
        List<ItemOrder> os=itemOrderMapper.selectByExample(itemOrderExample);
        List<Long> orderIds=os.stream().filter(Objects::nonNull).filter(itemOrder -> Objects.equals(itemOrder.getUserId(), userId)&&!itemOrder.getTbSend()
            && !StringUtils.isEmpty(itemOrder.getOuterId())
        )
                .map(ItemOrder::getOid).collect(Collectors.toList());
        if(orderIds.size()==0){
            throw new Main4Exception("选择的订单中未找到可发货的淘宝订单");
        }
        StringBuilder oidStrs= new StringBuilder();
        for(Long oid:orderIds){
            try {
                itemOrderProcess.tbSend(oid);
            } catch (TbSendException e) {
                if (oidStrs.length() > 0) {
                    oidStrs.append(",");
                }
                oidStrs.append(oid);
            }
        }
        if(oidStrs.length()>0){
            throw new Main4Exception("部分订单标记失败,请单个订单操作");
        }
    }

}
