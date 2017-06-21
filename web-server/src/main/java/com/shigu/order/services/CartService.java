package com.shigu.order.services;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.vo.CartChildOrderVO;
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

    @Autowired
    private ShowForCdnService showForCdnService;
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
                CartOrderVO orderVO = new CartOrderVO();
                vo.getOrders().add(orderVO);

                ShiguShop shiguShop = shopMap.get(entry.getKey());
                orderVO.setId(entry.getKey());
                orderVO.setImQq(shiguShop.getImQq());
                orderVO.setImWw(shiguShop.getImAliww());
                orderVO.setWebSite(shiguShop.getWebSite());
                orderVO.setStoreNum(shiguShop.getShopNum());
                orderVO.setMarketName(shiguShop.getParentMarketName());
                List<ItemProductVO> productVOS = entry.getValue();
                orderVO.setChildOrders(new ArrayList<CartChildOrderVO>(productVOS.size()));
                for (ItemProductVO productVO : productVOS) {
                    CartChildOrderVO childOrderVO = new CartChildOrderVO();
                    orderVO.getChildOrders().add(childOrderVO);
                    childOrderVO.setGoodsid(productVO.getGoodsId());
                    childOrderVO.setImgsrc(productVO.getPicUrl());
                    childOrderVO.setTitle(productVO.getTitle());
                    childOrderVO.setPrice(productVO.getPrice().doubleValue() / 100);
                    childOrderVO.setNum(productVO.getNum());
                    ItemSkuVO selectiveSku = productVO.getSelectiveSku();
                    childOrderVO.setColor(selectiveSku.getColor());
                    childOrderVO.setSize(selectiveSku.getSize());
                    CdnItem cdnItem = showForCdnService.selItemById(productVO.getGoodsId(), productVO.getWebSite());
                    if (cdnItem == null) {
                        childOrderVO.setDisabled(true);
                    } else {
                        childOrderVO.setGoodsNo(cdnItem.getHuohao());
                        childOrderVO.setColors(BeanMapper.getFieldList(cdnItem.getColors(), "value", String.class));
                        childOrderVO.setSizes(BeanMapper.getFieldList(cdnItem.getSizes(), "value", String.class));
                    }
                }
            }
        }
        return vo;
    }
}
