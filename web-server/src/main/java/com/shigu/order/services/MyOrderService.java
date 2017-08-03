package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.*;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.main4.order.vo.OrderAddrInfoVO;
import com.shigu.main4.order.vo.OrderDetailExpressVO;
import com.shigu.order.vo.MyOrderDetailVO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.order.vo.SubMyOrderVO;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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

    public ShiguPager<MyOrderVO> selectMyOrderPager(OrderBO bo, Long userId) throws ParseException {
        ShiguPager<MyOrderVO> pager = new ShiguPager<>();
        ShiguPager<ShowOrderVO> myOrder = orderListService.selectCountMyOrder(bo, userId);
        pager.setNumber(myOrder.getNumber());
        pager.calPages(myOrder.getTotalCount(), bo.getPageSize());
        pager.setContent(myOrder.getContent().stream().map(show -> {
            MyOrderVO vo = new MyOrderVO();
            vo.setIsTbOrder(show.getIsTbOrder());
            vo.setMainState(show.getMainState().status);
            vo.setOrderId(show.getOrderId());
            vo.setPostPay(PriceConvertUtils.priceToString(show.getPostPrice()));
            vo.setServerPay(PriceConvertUtils.priceToString(show.getServerPrice()));
            if (show.getPostPrice() == null) {
                show.setPostPrice(0L);
            }
            if (show.getServerPrice() == null) {
                show.setServerPrice(0L);
            }
            if (show.getOrderPrice() == null) {
                show.setOrderPrice(0L);
            }
            vo.setTradePay(PriceConvertUtils.priceToString(show.getServerPrice() + show.getOrderPrice() + show.getPostPrice()));
            vo.setTradeTime(DateUtil.dateToString(show.getPayTime(), DateUtil.patternD));
            vo.setWebSite(show.getWebSite());
            List<SubMyOrderVO> subs = toSubMyOrderVO(show.getChildOrders());
            vo.setChildOrders(subs);
            return vo;
        }).collect(Collectors.toList()));
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
        List<SubMyOrderVO> subs = new ArrayList<>();
        for (SubOrderInfoVO so : list) {
            SubMyOrderVO sub = new SubMyOrderVO();
            sub.setChildOrderId(so.getSubOrderId());
            sub.setColor(so.getColor());
            sub.setGoodsId(so.getGoodsId());
            sub.setGoodsNo(so.getGoodsNo());
            sub.setImgsrc(so.getImgsrc());
            sub.setNum(so.getNum());
            sub.setPrice(PriceConvertUtils.priceToString(so.getPrice()));
            sub.setSqRefundId(so.getPreSaleRefundId());
            sub.setShRefundId(so.getAfterSaleRefundId());
            sub.setShState(so.getShState().afterSaleStatus);
            sub.setShTkNum(so.getShTkNum());
            sub.setSize(so.getSize());
            sub.setTitle(so.getTitle());
            sub.setTkNum(so.getTkNum());
            if (so.getTkState() != null) {
                switch (so.getTkState().refundStatus) {
                    case 0:
                    case 1: {
                        sub.setTkState(1);
                        break;
                    }
                    case 2: {
                        sub.setTkState(2);
                        break;
                    }
                    default: {
                        sub.setTkState(3);
                    }
                }
            } else {
                sub.setTkState(0);
            }
            subs.add(sub);
        }
        return subs;
    }

}
