package com.shigu.main4.order.services.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.model.SubOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.*;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Service
public class OrderListServiceImpl implements OrderListService {


    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderLogisticsMapper itemOrderLogisticsMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * ====================================================================================
     * @方法名：myOrder
     * @功能： 我的订单
     * @param: bo查询条件  bo一定要有所有订单，待付款，已付款，配货中，交易完成，交易关闭的标记
     * @return: 返回订单列表
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public List<ShowOrderVO> myOrder(OrderBO bo, Long userId) throws ParseException {
        List<Long> orderIds = selOrderIdsByBO(bo,userId);
        List<ShowOrderVO> showOrderVOS = Lists.newArrayList();
        for (Long orderId:orderIds) {
            ShowOrderVO vo = BeanMapper.map(selectMyorder(orderId), ShowOrderVO.class);
            vo.setChildOrders(selectSubList(orderId));
            //todo:ShowOrderDetailVO缺少部分信息
            showOrderVOS.add(vo);
        }
        return showOrderVOS;
    }

    /**
     * ====================================================================================
     * @方法名：分页数据
     * @功能： selectCountMyOrder
     * @param: bo查询条件，userId用户ID
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    public ShiguPager<ShowOrderVO> selectCountMyOrder(OrderBO bo, Long userId) throws ParseException {
        ShiguPager<ShowOrderVO> pager = new ShiguPager<>();
        pager.setContent(myOrder(bo,userId));
        pager.setNumber(bo.getPage());
        pager.calPages(selCountByBo(bo,userId),bo.getPageSize());
        return pager;
    }

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
        ItemOrderExample example = new ItemOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andOrderStatusLessThan(5);
        List<Long> oids = itemOrderMapper.selShOidsByUserId(userId,shStatus==null?null:shStatus.shStatus,startRow,pageSize);
        if (oids.size()>0) {
            ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
            ItemOrderRefundExample.Criteria criteria = refundExample.createCriteria().andOidIn(oids);
            if (shStatus != null) {
                switch (shStatus) {
                    case CHANGE:
                        criteria.andTypeEqualTo(4);
                        break;
                    case REFUND:
                        criteria.andTypeBetween(1,3);
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
            SubItemOrder subOrderModel = SpringBeanFactory.getBean(SubItemOrder.class, o.getSoid());
            for (RefundTypeEnum refundType:RefundTypeEnum.values()) {
                RefundVO refundVO = subOrderModel.refundInfos(refundType);
                if (refundVO != null) {
                    switch (refundType) {
                        case ONLY_REFUND:
                            vo.setTkNum(refundVO.getNumber());
                            vo.setPreSaleRefundId(refundVO.getRefundId());
                            vo.setShState(RefundStateEnum.ENT_REFUND.equals(refundVO.getRefundState())?AfterSaleStatusEnum.REFUND_ENT:AfterSaleStatusEnum.HANDLE);
                            break;
                        case GOODS_REFUND:
                            vo.setShTkNum(refundVO.getNumber());
                            vo.setAfterSaleRefundId(refundVO.getRefundId());
                            vo.setShState(RefundStateEnum.ENT_REFUND.equals(refundVO.getRefundState())?AfterSaleStatusEnum.REFUND_ENT:AfterSaleStatusEnum.DISPOSE_FERUND);
                            break;
                        case GOODS_CHANGE:
                            vo.setShTkNum(refundVO.getNumber());
                            vo.setAfterSaleRefundId(refundVO.getRefundId());
                            vo.setShState(RefundStateEnum.ENT_REFUND.equals(refundVO.getRefundState())?AfterSaleStatusEnum.CHANGE_ENT:AfterSaleStatusEnum.DISPOSE_CHANGE);
                            break;
                    }
                    vo.setRefundNum(vo.getRefundNum() + refundVO.getNumber());
                }
            }
            if (vo.getShState() == null) {
                vo.setShState(AfterSaleStatusEnum.NOT_AFTER_SALE);
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
        vo.setOrderTotalPrice(PriceConvertUtils.priceToString(vo.getOrderTotalPriceLong()));
        List<LogisticsVO> logisticsVOs = orderModel.selLogisticses();
        if (logisticsVOs.size()>0) {
            vo.setExpressPriceLong(logisticsVOs.get(0).getMoney());
            vo.setExpressPrice(PriceConvertUtils.priceToString(vo.getExpressPriceLong()));
        }
        long childOrdersPrice = 0;
        for (SubItemOrderVO subItemOrderVO: subOrdersInfo) {
            childOrdersPrice += subItemOrderVO.getNum()*subItemOrderVO.getProduct().getPrice();
        }
        vo.setChildOrdersPriceLong(childOrdersPrice);
        vo.setChildOrdersPrice(PriceConvertUtils.priceToString(childOrdersPrice));
        long servicePrice = 0;
        for (OrderServiceVO orderServiceVO:orderModel.selServices()) {
            servicePrice += orderServiceVO.getMoney();
        }
        vo.setServicePriceLong(servicePrice);
        vo.setServicePrice(PriceConvertUtils.priceToString(servicePrice));
        return vo;
    }



    /**
     * 根据bo查询orderIds
     * @param bo
     * @param userId
     * @return
     * @throws ParseException 输入日期格式错误
     */
    private List<Long> selOrderIdsByBO(OrderBO bo, Long userId) throws ParseException {
        if (bo == null) {
            bo = new OrderBO();
        }
        bo.setPageSize(bo.getPageSize() == null?10:bo.getPageSize());
        int startRow = bo.getPage() == null ? 1 : (bo.getPage() - 1) * bo.getPageSize();
        return itemOrderMapper.selOidsByBo(userId, bo.getOrderId(), bo.getStatus() == null ? null : Integer.valueOf(bo.getStatus()),
                bo.getSt()==null?null:simpleDateFormat.parse(bo.getSt() + " 00:00:00"), bo.getEt()==null?null:simpleDateFormat.parse(bo.getEt() + " 23:59:59"),
                bo.getGoodsNo(), bo.getReceiver(), bo.getTelePhone(), startRow, bo.getPageSize());
    }

    /**
     * 根据bo获取记录总数
     * @param bo
     * @param userId
     * @return
     * @throws ParseException 输入日期格式错误
     */
    private int selCountByBo(OrderBO bo, Long userId) throws ParseException {
        if (bo == null) {
            bo = new OrderBO();
        }
        return itemOrderMapper.selOidsCountByBo(userId, bo.getOrderId(), bo.getStatus() == null ? null : Integer.valueOf(bo.getStatus()),
                bo.getSt()==null?null:simpleDateFormat.parse(bo.getSt() + " 00:00:00"), bo.getEt()==null?null:simpleDateFormat.parse(bo.getEt() + " 23:59:59"),
                bo.getGoodsNo(), bo.getReceiver(), bo.getTelePhone());
    }

}
