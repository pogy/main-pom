package com.shigu.main4.order.services.impl;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.OrderBO;
import com.shigu.main4.order.services.OrderListService;
import com.shigu.main4.order.servicevo.OrderVO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override public List<OrderVO> myOrder (OrderBO bo,Long userId) {
        return null;
    }

    @Override public ShiguPager<OrderVO> selectCountMyOrder (OrderBO bo, Long userId) {
        return null;
    }


    @Override public int removeOrder (Long tbid) {
        return 0;
    }
}
