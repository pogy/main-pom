package com.shigu.order.services;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.CartPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 进货车服务
 * Created by bugzy on 2017/6/20 0020.
 */
@Service
public class CartService {

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    /**
     * 进货车页面
     * @param userId 用户ID
     * @return 页面数据
     */
    public CartPageVO selMyCart(Long userId) {
        ItemCartImpl itemCart = SpringBeanFactory.getBean(ItemCartImpl.class, userId);
        CartPageVO vo = new CartPageVO();
        vo.setGoodsCount(itemCart.productNumbers());

        Map<Long, List<ItemProductVO>> groupByShop = BeanMapper.groupBy(itemCart.listProduct(), "shopId", Long.class);
        if (!groupByShop.isEmpty()) {
            vo.setOrders(new ArrayList<CartOrderVO>(groupByShop.size()));

            ShiguShopExample shiguShopExample = new ShiguShopExample();
            shiguShopExample.createCriteria().andShopIdIn(new ArrayList<>(groupByShop.keySet()));
            Map<Long, ShiguShop> shopMap =
                    BeanMapper.list2Map(shiguShopMapper.selectByExample(shiguShopExample), "shopId", Long.class);
            for (Map.Entry<Long, List<ItemProductVO>> entry : groupByShop.entrySet()) {
                ShiguShop shiguShop = shopMap.get(entry.getKey());

                List<ItemProductVO> value = entry.getValue();
                ItemProductVO itemProductVO = value.get(0);
                CartOrderVO orderVO = new CartOrderVO();
                vo.getOrders().add(orderVO);
                orderVO.setId(itemProductVO.getPid());
                orderVO.setImQq(shiguShop.getImQq());
                orderVO.setImWw(shiguShop.getImAliww());
                orderVO.setWebSite(shiguShop.getWebSite());
                orderVO.setStoreNum(shiguShop.getShopNum());
                orderVO.setMarketName(shiguShop.getParentMarketName());
            }
        }
        return vo;
    }
}
