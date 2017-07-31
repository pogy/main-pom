package com.shigu.main4.order.services.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderLogisticsExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.ItemOrderLogisticsMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
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
    public List<ShowOrderVO> myOrder(OrderBO bo, Long userId) {

        List<ShowOrderVO> list = new ArrayList<>();
        ShowOrderVO ovo = new ShowOrderVO();

        for (int i = 0; i < 20; i++) {
            ovo.setMainState(MainOrderStatusEnum.statusOf(1));
            String oidString = "201707200034" + i;
            Long orderId = new Long(oidString);
            ovo.setOrderId(orderId);
            ovo.setPostPrice(500L);
            ovo.setServerPrice(100L);
            if ((i / 2) == 1) {
                ovo.setIsTbOrder(false);
            } else {
                ovo.setIsTbOrder(true);
            }
            ovo.setOrderPrice(2800L);
            ovo.setPayTime(new Date());
            ovo.setWebSite("hz");
            List<SubOrderInfoVO> listsub = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                SubOrderInfoVO svo = new SubOrderInfoVO();
                int p = i * 10 + k + 1;
                svo.setOrderId(new Long(p));
                svo.setSubOrderId(orderId+k);
                switch (k) {
                    case 0: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i4/270913282/TB2LQlAXB7c61BjSZFIXXcZmVXa-270913282.jpg");
                        svo.setColor("白");
                        svo.setSize("L");
                        svo.setGoodsId(9522391L);
                        svo.setGoodsNo("A241 S5-P65");
                        svo.setNum(3);
                        svo.setPrice(6500L);
                        svo.setShTkNum(1);
                        svo.setTkNum(1);
                        svo.setTkState(RefundStateEnum.APPLY_REFUND);
                        svo.setShTkNum(1);
                        svo.setShState(AfterSaleStatusEnum.REFUND_ENT);
                        svo.setTitle("A241 S5-P65 2016秋冬毛线衫男装港风高领毛衣男纯色翻领毛衣");
                        break;
                    }
                    case 1: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i3/138989925/TB2rAD4XRAkyKJjy0FeXXadhpXa_!!138989925.jpg");
                        svo.setColor("蓝");
                        svo.setSize("XL");
                        svo.setGoodsId(20915911L);
                        svo.setGoodsNo("A242/WX82/P165");
                        svo.setNum(3);
                        svo.setPrice(6500L);
                        svo.setShTkNum(1);
                        svo.setTkNum(1);
                        svo.setTkState(RefundStateEnum.APPLY_REFUND);
                        svo.setShTkNum(1);
                        svo.setShState(AfterSaleStatusEnum.REFUND_ENT);
                        svo.setTitle("修身滚边设计男士帅气一粒扣西装 WX82/P165白");
                        break;
                    }
                    default: {
                        svo.setImgsrc("https://img.alicdn.com/bao/uploaded/i3/2744642519/TB2H_0CX2AkyKJjy0FfXXaxhpXa_!!2744642519.jpg");
                        svo.setColor("红");
                        svo.setSize("XXL");
                        svo.setGoodsId(20918332L);
                        svo.setGoodsNo("F088");
                        svo.setNum(5);
                        svo.setPrice(6500L);
                        svo.setShTkNum(1);
                        svo.setTkNum(1);
                        svo.setTkState(RefundStateEnum.BUYER_NOREPRICE);
                        svo.setShTkNum(1);
                        svo.setShState(AfterSaleStatusEnum.DISPOSE_FERUND);
                        svo.setTitle("【品质原创质检F088】秋装男夹克男风衣男外套男大码男P110控148");
                        break;
                    }
                }
                listsub.add(svo);


            }
            ovo.setChildOrders(listsub);
            list.add(ovo);
        }
        return list;
    }

    @Override
    public ShiguPager selectCountMyOrder(OrderBO bo, Long userId) {
        ShiguPager pager = new ShiguPager();
        //totalCount+","+size+","+number;
        pager.setTotalCount(15);
        pager.setNumber(12);
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
        Integer endRow = page * pageSize;
        ShiguPager<ShowOrderVO> pager = new ShiguPager<>();
        List<ShowOrderVO> showVOS = Lists.newArrayList();
        int totalCount = 0;
        ItemOrderExample example = new ItemOrderExample();
        example.createCriteria().andUserIdEqualTo(userId).andOrderStatusLessThan(5);
        List<Long> oids = itemOrderMapper.selectByExample(example).stream().map(com.opentae.data.mall.beans.ItemOrder::getOid).collect(Collectors.toList());
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
            totalCount = itemOrderRefundMapper.countByExample(refundExample);
            refundExample.setStartIndex(startRow);
            refundExample.setEndIndex(endRow);
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
                        childOrders.remove(subOrderInfoVO);
                    }
                }
                showVOS.add(showOrderVO);
            }
        }
        pager.setNumber(page);
        pager.calPages(totalCount,pageSize);
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
    //todo: com.shigu.main4.order.model.Order#remove方法
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
    //todo: com.shigu.main4.order.model.Order#closed方法
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

    @Override
    public ShowOrderDetailVO selectMyorder(Long orderId) {
        ShowOrderDetailVO vo = new ShowOrderDetailVO();
        vo.setOrderCreateTimed(new Date());//创建时间
        vo.setPayTime(new Date());//付款时间
        vo.setSendTime(new Date());//发货时间
        vo.setFinishTimed(new Date());//完成时间
        vo.setMainState(MainOrderStatusEnum.statusOf(1));
        vo.setOrderId(orderId);
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
            vo.setPrice(PriceConvertUtils.priceToString(subOrderInfo.getPrice()));
            if (refund != null) {
                vo.setRefundId(refund.getRefundId());
                vo.setRefundNum(refund.getNumber());
                vo.setTkNum(refund.getNumber());
                vo.setTkState(RefundStateEnum.statusOf(refund.getStatus()));
                //vo.setShTkNum();
                //vo.setShState();
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
        vo.setOrderTotalPriceLong(itemOrderVO.getTotalFee());
        vo.setOrderTotalPrice(PriceConvertUtils.priceToString(vo.getOrderTotalPriceLong()));
        List<LogisticsVO> logisticsVOs = orderModel.selLogisticses();
        if (logisticsVOs.size()>0) {
            vo.setExpressPriceLong(logisticsVOs.get(0).getMoney());
            vo.setExpressPrice(PriceConvertUtils.priceToString(vo.getExpressPriceLong()));
        }
        long childOrdersPrice = 0;
        for (SubItemOrderVO subItemOrderVO:orderModel.subOrdersInfo()) {
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
        //需要对item_order_logistics表进行查询
        boolean searchFromOrderLogistics = bo.getReceiver() != null || bo.getTelePhone() != null;
        //需要对item_order_sub表进行查询
        boolean searchFromItemOrderSub = bo.getGoodsNo() != null;
        Integer startIndex = (bo.getPage() - 1) * bo.getPageSize();
        Integer endIndex = bo.getPage() * bo.getPageSize();
        ItemOrderExample itemOrderExample = getItemOrderExampleByBO(bo, userId);
        if (!searchFromOrderLogistics || !searchFromItemOrderSub) {
            itemOrderExample.setStartIndex(startIndex);
            itemOrderExample.setEndIndex(endIndex);
        }
        List<Long> oids = BeanMapper.getFieldList(itemOrderMapper.selectByExample(itemOrderExample), "oid", Long.class);

        if (oids.size()>0 && (searchFromOrderLogistics)) {
            ItemOrderLogisticsExample itemOrderLogisticsExample = getItemOrderLogisticsExampleByBO(bo, oids);
            if (!searchFromItemOrderSub) {
                itemOrderLogisticsExample.setStartIndex(startIndex);
                itemOrderLogisticsExample.setEndIndex(endIndex);
            }
            oids = BeanMapper.getFieldList(itemOrderLogisticsMapper.selectByExample(itemOrderLogisticsExample),"oid",Long.class);
        }
        if (oids.size()>0 && searchFromItemOrderSub) {
            ItemOrderSubExample itemOrderSubExample = getItemOrderSubExample(bo,oids);
            itemOrderSubExample.setStartIndex(startIndex);
            itemOrderSubExample.setEndIndex(endIndex);
            oids = BeanMapper.getFieldList(itemOrderSubMapper.selectByExample(itemOrderSubExample),"oid",Long.class);
        }
        return oids;
    }

    /**
     * 根据bo获取记录总数
     * @param bo
     * @param userId
     * @return
     * @throws ParseException 输入日期格式错误
     */
    private int selCountByBo(OrderBO bo, Long userId) throws ParseException {
        boolean searchFromOrderLogistics = bo.getReceiver() != null || bo.getTelePhone() != null;
        boolean searchFromItemOrderSub = bo.getGoodsNo() != null;
        ItemOrderExample itemOrederExample = getItemOrderExampleByBO(bo, userId);
        if (!searchFromOrderLogistics && !searchFromItemOrderSub) {
            return itemOrderMapper.countByExample(itemOrederExample);
        }
        List<Long> oids = BeanMapper.getFieldList(itemOrderMapper.selectByExample(itemOrederExample), "oid", Long.class);
        if (oids.size() == 0) {
            return 0;
        }
        ItemOrderLogisticsExample itemOrderLogisticsExample = getItemOrderLogisticsExampleByBO(bo, oids);
        if (!searchFromItemOrderSub) {
            return itemOrderLogisticsMapper.countByExample(itemOrderLogisticsExample);
        }
        oids = BeanMapper.getFieldList(itemOrderLogisticsMapper.selectByExample(itemOrderLogisticsExample),"oid",Long.class);
        return oids.size() > 0? itemOrderSubMapper.countByExample(getItemOrderSubExample(bo,oids)): 0;
    }

    /**
     * 根据bo获取从item_order查询时的example,分页在调用处处理
     * @param bo
     * @param userId
     * @return
     * @throws ParseException 输入日期格式错误
     */
    private ItemOrderExample getItemOrderExampleByBO(OrderBO bo, Long userId) throws ParseException {
        ItemOrderExample itemOrderExample = new ItemOrderExample();
        ItemOrderExample.Criteria criteria = itemOrderExample.createCriteria().andUserIdEqualTo(userId);
        if (bo.getStatus() != null) {
            criteria.andOrderStatusEqualTo(Integer.valueOf(bo.getStatus()));
        }
        if (bo.getOrderId() != null) {
            criteria.andOidEqualTo(bo.getOrderId());
        }
        if (bo.getSt() != null) {
            criteria.andCreateTimeGreaterThanOrEqualTo(simpleDateFormat.parse(bo.getSt()));
        }
        if (bo.getEt() != null) {
            criteria.andCreateTimeLessThanOrEqualTo(simpleDateFormat.parse(bo.getEt()));
        }
        return itemOrderExample;
    }

    private ItemOrderLogisticsExample getItemOrderLogisticsExampleByBO(OrderBO bo, List<Long> oids) {
        ItemOrderLogisticsExample itemOrderLogisticsExample = new ItemOrderLogisticsExample();
        ItemOrderLogisticsExample.Criteria criteria = itemOrderLogisticsExample.createCriteria();
        if (bo.getReceiver() != null) {
            criteria.andNameEqualTo(bo.getReceiver());
        }
        if (bo.getTelePhone() != null) {
            criteria.andTelephoneEqualTo(bo.getTelePhone());
        }
        if (oids.size()>0) {
            criteria.andOidIn(oids);
        } else {
            // oids为空
            criteria.andIdEqualTo(-1L);
        }
        return itemOrderLogisticsExample;
    }



    private ItemOrderSubExample getItemOrderSubExample(OrderBO bo, List<Long> oids) {
        ItemOrderSubExample itemOrderSubExample = new ItemOrderSubExample();
        ItemOrderSubExample.Criteria criteria = itemOrderSubExample.createCriteria().andGoodsNoEqualTo(bo.getGoodsNo());
        if (oids.size()>0) {
            criteria.andOidIn(oids);
        } else {
            // oids为空
            criteria.andSoidEqualTo(-1L);
        }
        return itemOrderSubExample;
    }
}
