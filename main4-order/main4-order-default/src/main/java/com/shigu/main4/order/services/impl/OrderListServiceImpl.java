package com.shigu.main4.order.services.impl;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.ExpressInfoVO;
import com.shigu.main4.order.servicevo.ExpressLogVO;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.ShowOrderDetailVO;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.zfenums.MainOrderStatusEnum;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
@Service("orderListService")
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private ItemOrderService itemOrderService;

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
     * @方法名：selectExpress
     * @功能： 查询订单的快递信息
     * @param:
     * @return:
     * @exception:
     * ====================================================================================
     *
     */
    @Override
    @Cacheable(value = "expressLogCache",key = "#orderId")
    public OrderDetailExpressVO selectExpress (Long orderId) throws Main4Exception, ParseException {
        OrderDetailExpressVO vo=new OrderDetailExpressVO();
        ExpressInfoVO expressInfoVO = itemOrderService.expressInfo(orderId);
        if (expressInfoVO != null) {
            String expressId = expressInfoVO.getExpressId();
            vo.setName(expressInfoVO.getExpressName());
            vo.setId(expressId);
            ItemOrder orderModel = SpringBeanFactory.getBean(ItemOrder.class, orderId);
            List<OrderDetailExpressDetailVO> detailVOS = new ArrayList<>();
            if (orderModel.selLogisticses().size()>0) {
                List<ExpressLogVO> expressLogVOS = itemOrderService.expressLog(orderModel.selLogisticses().get(0).getId());
                for(ExpressLogVO expressLogVO:expressLogVOS){
                    OrderDetailExpressDetailVO dvo=null;
                    for(OrderDetailExpressDetailVO d:detailVOS){
                        if(d.getDate().equals(expressLogVO.getLogDate())){
                            dvo=d;
                            break;
                        }
                    }
                    if(dvo==null){
                        dvo=new OrderDetailExpressDetailVO();
                        dvo.setDetailList(new ArrayList<>());
                        dvo.setDate(expressLogVO.getLogDate());
                        dvo.setOrderId(orderId);
                        dvo.setId(expressId);
                        dvo.setWeek(expressLogVO.getLogWeek());
                        detailVOS.add(dvo);
                    }
                    ExpressDetailTimeAndDescVO timeAndDescVO = new ExpressDetailTimeAndDescVO();
                    timeAndDescVO.setTime(expressLogVO.getLogTime());
                    timeAndDescVO.setDesc(expressLogVO.getLogDesc());
                    dvo.getDetailList().add(timeAndDescVO);
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
        ItemOrder itemOrder = SpringBeanFactory.getBean(ItemOrder.class, orderId);
        ItemOrderVO itemOrderVO = itemOrder.orderInfo();
        vo.setOrderId(orderId);
        vo.setOrderCreateTimed(itemOrderVO.getCreateTime());
        vo.setMainState(MainOrderStatusEnum.statusOf(itemOrderVO.getOrderStatus().status));

        OrderDetailTotalVO totalVO=new OrderDetailTotalVO();
        List<SubItemOrderVO> subOrdersInfo = itemOrder.subOrdersInfo();
        totalVO.setOrderTotalPriceLong(itemOrderVO.getTotalFee());
        totalVO.setOrderTotalPrice(String.format("%.2f", totalVO.getOrderTotalPriceLong() * .01));
        List<LogisticsVO> logisticsVOs = itemOrder.selLogisticses();
        if (logisticsVOs.size()>0) {
            totalVO.setExpressPriceLong(logisticsVOs.get(0).getMoney());
            totalVO.setExpressPrice(String.format("%.2f", totalVO.getExpressPriceLong() * .01));
        }
        totalVO.setChildOrdersPriceLong(subOrdersInfo.stream().mapToLong(i -> i.getNum() * i.getProduct().getPrice()).sum());
        totalVO.setChildOrdersPrice(String.format("%.2f", totalVO.getChildOrdersPriceLong() * .01));
        totalVO.setServicePriceLong(itemOrder.selServices().stream().mapToLong(OrderServiceVO::getMoney).sum());
        totalVO.setServicePrice(String.format("%.2f", totalVO.getServicePriceLong() * .01));
        vo.setTotalVO(totalVO);

        vo.setFinishTimed(itemOrderVO.getFinishTime());
        vo.setPayTime(itemOrderVO.getPayTime());
        vo.setSendTime(itemOrderVO.getSendTime());
        vo.setIsTbOrder(itemOrderVO.getType().type == 2);
        return vo;
    }
}
