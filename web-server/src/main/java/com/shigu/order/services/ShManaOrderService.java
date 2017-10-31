package com.shigu.order.services;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.bo.ShManaOrderBo;
import com.shigu.order.orderQuery.OrderQuery;
import com.shigu.order.orderQuery.QueryByShManaOrder;
import com.shigu.order.vo.MyOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zf on 2017/7/24.
 */
@Service("tae_shManaOrderService")
public class ShManaOrderService {

    @Autowired
    MyOrderService myOrderService;

    public ShiguPager<MyOrderVO> selectShList(ShManaOrderBo bo, Long userId) {
        if (bo.getPage() == null) {
            bo.setPage(1);
        }
        //OrderBO orderBO = new OrderBO();
        //return myOrderService.selectMyOrderPager(bo.getPage(), bo.getSize(), true,userId,orderBO,bo.getShStatus());
        OrderQuery query = SpringBeanFactory.getBean(QueryByShManaOrder.class, userId, bo.getShStatus());
        return query.selectMyOrderPager(bo.getPage(),bo.getSize());
    }
}
