package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.OrderDetailTotalVO;
import com.shigu.main4.order.servicevo.OrderDetailVO;
import com.shigu.main4.order.servicevo.ShowOrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    private ItemOrderMapper itemOrderMapper;


    public List<ShowOrderVO> myOrder(OrderBO bo, Long userId) {
        List<ShowOrderVO> list = orderListService.myOrder(bo, userId);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                list.get(i).setTradePay(PriceConvertUtils.priceToString(list.get(i).getTradePayLong()));
                list.get(i).setServerPay(PriceConvertUtils.priceToString(list.get(i).getServerPayLong()));
                list.get(i).setRefundFee(PriceConvertUtils.priceToString(list.get(i).getRefundFeeLong()));
                list.get(i).setPostPay(PriceConvertUtils.priceToString(list.get(i).getPostPayLong()));
                list.get(i).setPayedFee(PriceConvertUtils.priceToString(list.get(i).getPayedFeeLong()));
                List<SubOrderInfoVO> sublist = list.get(i).getChildOrders();
                List<SubOrderInfoVO> sublist1 = new ArrayList<>();
                for (SubOrderInfoVO subVo : list.get(i).getChildOrders()) {
                    subVo.setPrice(PriceConvertUtils.priceToString(subVo.getPriceLong()));
                    subVo.setSubOrderStatus(subVo.getSubStatusenum().status);
                    sublist1.add(subVo);
                }
                list.get(i).setChildOrders(sublist1);
                //日期
                list.get(i).setTradeTime(DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", list.get(i).getTradeTimed()));

            }
        }

        return list;

    }


    public ShiguPager<ShowOrderVO> selectCountMyOrder(OrderBO bo, Long userId) {

        return orderListService.selectCountMyOrder(bo, userId);
    }

    public boolean orderFlag(Long orderId, Long userId) {
        boolean flag = false;
        ItemOrder iorder = itemOrderMapper.selectByPrimaryKey(orderId);

        if (iorder != null && !userId.equals(iorder.getUserId())) {
            flag = true;
        }

        return flag;
    }


    public int removeOrder(Long orderId) {
        return orderListService.removeOrder(orderId);
    }

    public int cancelOrder(Long orderId) {
        return orderListService.cancelOrder(orderId);
    }


    public OrderDetailVO orderDetail(Long orderId) throws Main4Exception, ParseException {
        ShowOrderVO orderVO = orderListService.selectMyorder(orderId);
        OrderAddrInfoVO addrVo = orderListService.selectOrderAddrInfo(orderId);
        OrderDetailExpressVO expressVO = orderListService.selectExpress(orderId);

        List<SubOrderInfoVO> list = orderListService.selectSubList(orderId);
        List<SubOrderInfoVO> list1 = new ArrayList<>();
        for (SubOrderInfoVO subVo : list) {
            subVo.setPrice(PriceConvertUtils.priceToString(subVo.getPriceLong()));
            subVo.setSubOrderStatus(subVo.getSubStatusenum().status);
            list1.add(subVo);
        }
        OrderDetailVO vo = new OrderDetailVO();
        vo.setChildOrders(list1);

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
        if (orderVO.getTradeTimed() != null) {
            vo.setOrderDealTime(DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getTradeTimed()));
        }
        vo.setOrderStateNum(orderVO.getMainState().longValue());
        String[] orderStateText = {"提交订单", "买家付款", "商品配货", "交易完成"};
        vo.setOrderStateText(orderStateText);
        //

        String[] orderStatusTIme = new String[4];
        if (orderVO.getOrderCreateTimed() != null) {
            orderStatusTIme[0] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getOrderCreateTimed());

        }
        if (vo.getOrderDealTime() != null) {
            orderStatusTIme[1] = vo.getOrderDealTime();
        }
        if (orderVO.getDistributionDated() != null) {
            orderStatusTIme[2] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getDistributionDated());
        }
        if (orderVO.getFinishTimed() != null) {
            orderStatusTIme[3] = DateParseUtil.parseDate("YYYY-MM-dd HH:mm:ss", orderVO.getFinishTimed());
        }

        vo.setOrderStateTime(orderStatusTIme);
        return vo;
    }
}
