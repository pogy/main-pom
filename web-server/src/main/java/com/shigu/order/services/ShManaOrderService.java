package com.shigu.order.services;

import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderLogisticsExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.order.bo.ShManaOrderBo;
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
        ItemOrderExample orderExample = new ItemOrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId).andOrderStatusBetween(3, 4);
        ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
        ItemOrderRefundExample.Criteria criteria = refundExample.createCriteria();
        if (bo.getShStatus() != null) {
            criteria.andTypeEqualTo(bo.getShStatus() + 1);
        } else {
            criteria.andTypeBetween(2, 3);
        }
        return myOrderService.selectMyOrderPager(bo.getPage(), bo.getSize(), orderExample, new ItemOrderSubExample(), new ItemOrderLogisticsExample(), refundExample, true,null,null);
    }
}
