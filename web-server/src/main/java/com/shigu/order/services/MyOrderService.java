package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.OrderVO;
import com.shigu.main4.order.servicevo.SubOrderInfoVO;
import com.shigu.main4.order.utils.PriceConvertUtils;
import com.shigu.tools.DateParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<OrderVO> myOrder(OrderBO bo, Long userId) {
        List<OrderVO> list=orderListService.myOrder (bo,userId);
        if(list.size ()>0){
            for(int i=0;i<list.size ();i++){

                list.get (i).setTradePay (PriceConvertUtils.priceToString (list.get(i).getTradePayLong ()));
                list.get(i).setServerPay (PriceConvertUtils.priceToString (list.get(i).getServerPayLong ()));
                list.get (i).setRefundFee (PriceConvertUtils.priceToString (list.get(i).getRefundFeeLong ()));
                list.get (i).setPostPay (PriceConvertUtils.priceToString (list.get(i).getPostPayLong ()));
                list.get (i).setPayedFee (PriceConvertUtils.priceToString (list.get(i).getPayedFeeLong ()));
                List<SubOrderInfoVO> sublist=list.get (i).getChildOrders ();
                List<SubOrderInfoVO> sublist1=new ArrayList<> ();
                for(SubOrderInfoVO subVo: list.get (i).getChildOrders ()){
                        subVo.setPrice (PriceConvertUtils.priceToString(subVo.getPriceLong ()));
                    sublist1.add (subVo);
                }
                list.get (i).setChildOrders (sublist1);
                //日期
                list.get (i).setTradeTime (DateParseUtil.parseDate ("YYYY-MM-dd HH:mm:ss",list.get (i).getTradeTimed ()));

            }
        }


       return  list;

    }

    public ShiguPager<OrderVO> selectCountMyOrder(OrderBO bo, Long userId){
        return orderListService.selectCountMyOrder (bo,userId);
    }

    public int removeOrder(Long orderId){
       return orderListService.removeOrder (orderId);
    }
    public int cancelOrder(Long orderId){
        return orderListService.cancelOrder (orderId);
    }
}
