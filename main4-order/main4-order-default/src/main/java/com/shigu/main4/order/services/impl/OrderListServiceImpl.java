package com.shigu.main4.order.services.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.SubOrderInfos;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.AfterSaleStatusEnum;
import com.shigu.main4.order.zfenums.MainOrderStatusEnum;
import com.shigu.main4.order.zfenums.RefundStateEnum;
import com.shigu.main4.order.zfenums.ShStatusEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
        ShiguPager<ShowOrderVO> pager = new ShiguPager<ShowOrderVO>();
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
            List<OrderDetailExpressDetailVO> detailVOS = Lists.newArrayList();
            if (orderModel.selLogisticses().size()>0) {
                for (ExpressLogVO expressLogVO:itemOrderService.expressLog(orderModel.selLogisticses().get(0).getId())){
                    OrderDetailExpressDetailVO detailVO = new OrderDetailExpressDetailVO();
                    detailVO.setId(expressId);
                    detailVO.setOrderId(orderId);
                    detailVO.setDate(expressLogVO.getLogDate());
                    detailVO.setTime(expressLogVO.getLogTime());
                    detailVO.setDesc(expressLogVO.getLogDesc());
                    detailVOS.add(detailVO);
                }
            }
            vo.setDetail(detailVOS);
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
        vo.setTbOrder(!(itemOrderVO.getOuterId() == null || itemOrderVO.getOuterId().isEmpty()));
        vo.setPayTime(itemOrderVO.getCreateTime());
        vo.setSendTime(vo.getOrderCreateTimed());
        //vo.setTradeTimed(itemOrderVO.getCreateTime());
        //vo.setTradeTime(simpleDateFormat.format(itemOrderVO.getCreateTime()));
        //vo.setOrderCreateTime(simpleDateFormat.format(itemOrderVO.getCreateTime()));
        //vo.setTradePayLong(orderDetailTotalVO.getOrderTotalPriceLong());
        //vo.setTradePay(orderDetailTotalVO.getOrderTotalPrice());
        //vo.setIsTbOrder(itemOrderVO.getType().type == 2);
        //vo.setWebSite(itemOrderVO.getWebSite());
        //vo.setType(itemOrderVO.getType());
        //vo.setPayedFee(PriceConvertUtils.priceToString(itemOrderVO.getPayedFee()));
        //vo.setPayedFeeLong(itemOrderVO.getPayedFee());
        //vo.setTitle(itemOrderVO.getTitle());
        //vo.setRefundFeeLong(itemOrderVO.getRefundFee());
        //vo.setRefundFee(PriceConvertUtils.priceToString(itemOrderVO.getRefundFee()));
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
        List<SubOrderInfos> subOrderInfos = itemOrderSubMapper.selSubOrderAndRefundInfos(orderId);
        List<SubOrderInfoVO> subOrderInfoVOS = Lists.newArrayList();
        subOrderInfos.forEach(subOrderInfo->{
            SubOrderInfoVO vo = BeanMapper.map(subOrderInfo, SubOrderInfoVO.class);
            ItemOrderRefund refund = subOrderInfo.getItemOrderRefund();
            vo.setOrderId(subOrderInfo.getOid());
            vo.setSubOrderId(subOrderInfo.getSoid());
            vo.setImgsrc(subOrderInfo.getPicUrl());
            //vo.setPrice(PriceConvertUtils.priceToString(subOrderInfo.getPrice()));
            //售后默认信息
            vo.setShState(AfterSaleStatusEnum.NOT_AFTER_SALE);
            vo.setShTkNum(0);
            vo.setTkNum(0);
            vo.setRefundNum(0);
            vo.setTkState(RefundStateEnum.APPLY_REFUND);
            if (refund != null) {
                vo.setRefundId(refund.getRefundId());
                vo.setRefundNum(refund.getNumber());
                if (refund.getType() == 2 || refund.getType() == 3) {
                    vo.setShTkNum(refund.getNumber());
                }
                if (refund.getType() == 1) {
                    vo.setTkNum(refund.getNumber());
                }
                vo.setTkState(RefundStateEnum.statusOf(refund.getStatus()));
                if (refund.getStatus() == 2) {
                    if (refund.getType() == 2 || refund.getType() == 3 ) {
                        vo.setShState(AfterSaleStatusEnum.REFUND_ENT);
                    }
                    if (refund.getType() == 4) {
                        vo.setShState(AfterSaleStatusEnum.CHANGE_ENT);
                    }
                } else {
                    if (refund.getType() == 2 || refund.getType() == 3) {
                        vo.setShState(AfterSaleStatusEnum.DISPOSE_FERUND);
                    }
                    if (refund.getType() == 4) {
                        vo.setShState(AfterSaleStatusEnum.DISPOSE_CHANGE);
                    }
                }
            }
            subOrderInfoVOS.add(vo);
        });
        return subOrderInfoVOS;
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
