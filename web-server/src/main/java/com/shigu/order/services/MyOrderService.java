package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

       return  orderListService.myOrder (bo,userId);

    }

    public ShiguPager<OrderVO> selectCountMyOrder(OrderBO bo, Long userId){
        return orderListService.selectCountMyOrder (bo,userId);
    }

    public int removeOrder(Long orderId){
       return orderListService.removeOrder (orderId);
    }
}
