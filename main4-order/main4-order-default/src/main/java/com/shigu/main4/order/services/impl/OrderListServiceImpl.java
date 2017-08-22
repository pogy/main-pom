package com.shigu.main4.order.services.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.MainOrderStatusEnum;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.order.zfenums.RefundTypeEnum;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @类编号
 * @类名称：OrderListServiceImpl
 * @文件路径：com.shigu.main4.order.services.impl.OrderListServiceImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/20 11:08
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("orderListService")
public class OrderListServiceImpl implements OrderListService {


    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    /**
     *
     * 查询售后列表
     * @param shStatus
     * @param page
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public ShiguPager<ShowOrderVO> selectCountShManaOrder(ShStatusEnum shStatus, Integer page, Integer pageSize, Long userId) throws ParseException {
        Integer startRow = (page - 1) * pageSize;
        ShiguPager<ShowOrderVO> pager = new ShiguPager<>();
        List<ShowOrderVO> showVOS = Lists.newArrayList();
        List<Long> oids = itemOrderMapper.selShOidsByUserId(userId,shStatus==null?null:shStatus.shStatus,startRow,pageSize);
        if (oids.size()>0) {
            ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
            ItemOrderRefundExample.Criteria criteria = refundExample.createCriteria().andOidIn(oids);
            if (shStatus != null) {
                switch (shStatus) {
                    case CHANGE:
                        criteria.andTypeEqualTo(3);
                        break;
                    case REFUND:
                        criteria.andTypeBetween(1,2);
                        break;
                }
            }
            List<ItemOrderRefund> itemOrderRefunds = itemOrderRefundMapper.selectByExample(refundExample);
            Set<Long> soids = itemOrderRefunds.stream().map(ItemOrderRefund::getSoid).collect(Collectors.toSet());
            for (Long aLong : itemOrderRefunds.stream().map(ItemOrderRefund::getOid).collect(Collectors.toSet())) {
                ShowOrderVO showOrderVO = BeanMapper.map(selectMyorder(aLong),ShowOrderVO.class);
                showOrderVO.setChildOrders(selectSubList(aLong));
                List<SubOrderInfoVO> childOrders = showOrderVO.getChildOrders();
                Iterator<SubOrderInfoVO> iterator = childOrders.iterator();
                while (iterator.hasNext()) {
                    SubOrderInfoVO subOrderInfoVO = iterator.next();
                    if (!soids.contains(subOrderInfoVO.getSubOrderId())) {
                        if (shStatus!=null) {
                            iterator.remove();
                        }
                    }
                }
                showVOS.add(showOrderVO);
            }
        }
        pager.setNumber(page);
        pager.calPages(itemOrderMapper.selShOrderCount(userId,shStatus==null?null:shStatus.shStatus),pageSize);
        pager.setContent(showVOS);
        return pager;
    }

    /**
     * ====================================================================================
     * @方法名：removeOrder
     * @功能： 删除订单
     * @param: orderId 订单ID
     * @return: 如果大于0就删除成功
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int removeOrder(Long orderId) {
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        orderModel.remove();
        return 1;
    }

    /**
     * ====================================================================================
     * @方法名：取消订单
     * @功能：
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public int cancelOrder(Long orderId) {
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        orderModel.closed();
        return 1;
    }

    /**
     * ====================================================================================
     * @方法名：selectOrderAddrInfo
     * @功能： 查询订单地址信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public OrderAddrInfoVO selectOrderAddrInfo (Long orderId) {
        OrderAddrInfoVO addrvo = null;
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        List<LogisticsVO> logisticsVOS = orderModel.selLogisticses();
        if (logisticsVOS.size()>0) {
            addrvo = BeanMapper.map(logisticsVOS.get(0),OrderAddrInfoVO.class);
            addrvo.setPhone(logisticsVOS.get(0).getTelephone());
            addrvo.setOrderId(orderId);
        }
        return addrvo;
    }

    /**
     * ====================================================================================
     * @方法名：selectExpress
     * @功能： 查询订单的快递信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public OrderDetailExpressVO selectExpress (Long orderId) throws Main4Exception, ParseException {
        OrderDetailExpressVO vo=new OrderDetailExpressVO();
        ExpressInfoVO expressInfoVO = itemOrderService.expressInfo(orderId);
        if (expressInfoVO != null) {
            String expressId = expressInfoVO.getExpressId();
            vo.setName(expressInfoVO.getExpressName());
            vo.setId(expressId);
            ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
            List<OrderDetailExpressDetailVO> detailVOS = null;
            if (orderModel.selLogisticses().size()>0) {
                List<ExpressLogVO> expressLogVOS = itemOrderService.expressLog(orderModel.selLogisticses().get(0).getId());
                Map<String, List<ExpressLogVO>> dateExpressMap = expressLogVOS.stream().collect(Collectors.groupingBy(ExpressLogVO::getLogDate));
                detailVOS = dateExpressMap.keySet().stream().map(date -> {
                    OrderDetailExpressDetailVO detailVO = new OrderDetailExpressDetailVO();
                    detailVO.setOrderId(orderId);
                    detailVO.setId(expressId);
                    detailVO.setDate(date);
                    detailVO.setWeek(dateExpressMap.get(date).get(0).getLogWeek());
                    detailVO.setDetailList(dateExpressMap.get(date).stream().map(log -> {
                        ExpressDetailTimeAndDescVO timeAndDescVO = new ExpressDetailTimeAndDescVO();
                        timeAndDescVO.setTime(log.getLogTime());
                        timeAndDescVO.setDesc(log.getLogDesc());
                        return timeAndDescVO;
                    }).collect(Collectors.toList()));
                    return detailVO;
                }).collect(Collectors.toList());

            }
            vo.setDetail(detailVOS==null?new ArrayList<>():detailVOS);
        }
        return vo;
    }

    /**
     * ====================================================================================
     * @方法名：selectMyorder
     * @功能： 查询主订单的信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public ShowOrderDetailVO selectMyorder(Long orderId) {
        ShowOrderDetailVO vo = new ShowOrderDetailVO();
        ItemOrderVO itemOrderVO = SpringBeanFactory.getBean(ItemOrder.class, orderId).orderInfo();
        OrderDetailTotalVO orderDetailTotalVO = selectTotal(orderId);
        vo.setOrderId(orderId);
        vo.setOrderCreateTimed(itemOrderVO.getCreateTime());
        vo.setMainState(MainOrderStatusEnum.statusOf(itemOrderVO.getOrderStatus().status));
        vo.setPostPrice(orderDetailTotalVO.getExpressPriceLong());
        vo.setOrderPrice(orderDetailTotalVO.getChildOrdersPriceLong());
        vo.setServerPrice(orderDetailTotalVO.getServicePriceLong());
        vo.setFinishTimed(itemOrderVO.getFinishTime());
        vo.setIsTbOrder(!(itemOrderVO.getOuterId() == null || itemOrderVO.getOuterId().isEmpty()));
        vo.setPayTime(itemOrderVO.getCreateTime());
        vo.setSendTime(vo.getOrderCreateTimed());
        vo.setIsTbOrder(itemOrderVO.getType().type == 2);
        return vo;
    }

    /**
     * ====================================================================================
     * @方法名：selectSubList
     * @功能： 根据主单id查询出子单列表
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public List<SubOrderInfoVO> selectSubList (Long orderId) {
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        List<SubItemOrderVO> subItemOrderVOS = orderModel.subOrdersInfo();
        return subItemOrderVOS.stream().map(o->{
            SubOrderInfoVO vo = BeanMapper.map(o,SubOrderInfoVO.class);
            ItemProductVO product = o.getProduct();
            vo.setOrderId(o.getOid());
            vo.setSubOrderId(o.getSoid());
            vo.setImgsrc(product.getPicUrl());
            vo.setTitle(product.getTitle());
            vo.setRefundNum(0);
            vo.setTkNum(0);
            vo.setShTkNum(0);
            vo.setPrice(product.getPrice());
            SubItemOrder subOrderModel = SpringBeanFactory.getBean(SubItemOrder.class, o.getSoid());
            for (RefundTypeEnum refundType:RefundTypeEnum.values()) {
                RefundVO refundVO = subOrderModel.refundInfos(refundType);
                if (refundVO != null) {
                    switch (refundType) {
                        case ONLY_REFUND:
                            vo.setTkNum(refundVO.getNumber());
                            vo.setPreSaleRefundId(refundVO.getRefundId());
                            vo.setTkState(refundVO.getRefundState() == RefundStateEnum.ENT_REFUND ? 1 : 0);//退款只有成功或无
                            break;
                        case GOODS_REFUND:
                            vo.setShTkNum(refundVO.getNumber());
                            vo.setAfterSaleRefundId(refundVO.getRefundId());
                            vo.setShState(RefundStateEnum.ENT_REFUND == refundVO.getRefundState() ? 2 : RefundStateEnum.NOT_REFUND == refundVO.getRefundState() ? 6 : 4);
                            break;
                        case GOODS_CHANGE:
                            vo.setShTkNum(refundVO.getNumber());
                            vo.setAfterSaleRefundId(refundVO.getRefundId());
                            vo.setShState(RefundStateEnum.ENT_REFUND == refundVO.getRefundState() ? 3 : RefundStateEnum.NOT_REFUND == refundVO.getRefundState() ? 7 : 5);
                            break;
                    }
                    vo.setRefundNum(vo.getRefundNum() + refundVO.getNumber());
                }
            }
            if (vo.getShState() == null) {
                vo.setShState(0);
            }
            if (vo.getTkState() == null) {
                vo.setTkState(0);
            }
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * ====================================================================================
     * @方法名：selectTotal
     * @功能： 根据主单查询总数
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public OrderDetailTotalVO selectTotal (Long orderId) {
        OrderDetailTotalVO vo=new OrderDetailTotalVO();
        ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        ItemOrderVO itemOrderVO = orderModel.orderInfo();
        List<SubItemOrderVO> subOrdersInfo = orderModel.subOrdersInfo();
        vo.setOrderTotalPriceLong(itemOrderVO.getTotalFee());
        vo.setOrderTotalPrice(String.format("%.2f", vo.getOrderTotalPriceLong() * .01));
        List<LogisticsVO> logisticsVOs = orderModel.selLogisticses();
        if (logisticsVOs.size()>0) {
            vo.setExpressPriceLong(logisticsVOs.get(0).getMoney());
            vo.setExpressPrice(String.format("%.2f", vo.getExpressPriceLong() * .01));
        }
        vo.setChildOrdersPriceLong(subOrdersInfo.stream().mapToLong(i -> i.getNum() * i.getProduct().getPrice()).sum());
        vo.setChildOrdersPrice(String.format("%.2f", vo.getChildOrdersPriceLong() * .01));
        int sumNumber = subOrdersInfo.stream().mapToInt(SubItemOrderVO::getNum).sum();
        vo.setServicePriceLong(orderModel.selServices().stream().mapToLong(s -> s.getMoney() * sumNumber).sum());
        vo.setServicePrice(String.format("%.2f", vo.getServicePriceLong() * .01));
        return vo;
    }

}
