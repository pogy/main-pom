package com.shigu.order.services;

import com.opentae.data.mall.beans.ItemCart;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ItemCartExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.services.impl.ItemOrderServiceImpl;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.OrderSubmitType;
import com.shigu.order.vo.CartChildOrderVO;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.CartPageVO;
import com.shigu.order.vo.OrderSubmitVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 进货车服务
 * Created by bugzy on 2017/6/20 0020.
 */
@Service
public class CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ItemCartMapper itemCartMapper;

    @Autowired
    private ShowForCdnService showForCdnService;

    @Autowired
    private RedisIO redisIO;
    /**
     * 进货车页面
     * @param userId 用户ID
     * @return 页面数据
     */
    public CartPageVO selMyCart(Long userId) {
        ItemCartImpl itemCart = SpringBeanFactory.getBean(ItemCartImpl.class, userId);
        CartPageVO vo = new CartPageVO();
        vo.setGoodsCount(itemCart.productNumbers());

        Map<Long, List<CartVO>> groupByShop = BeanMapper.groupBy(itemCart.listProduct(), "shopId", Long.class);
        if (!groupByShop.isEmpty()) {
            vo.setOrders(new ArrayList<CartOrderVO>(groupByShop.size()));

            ShiguShopExample shiguShopExample = new ShiguShopExample();
            shiguShopExample.createCriteria().andShopIdIn(new ArrayList<>(groupByShop.keySet()));
            Map<Long, ShiguShop> shopMap =
                    BeanMapper.list2Map(shiguShopMapper.selectByExample(shiguShopExample), "shopId", Long.class);

            for (Map.Entry<Long, List<CartVO>> entry : groupByShop.entrySet()) {
                CartOrderVO orderVO = new CartOrderVO();
                vo.getOrders().add(orderVO);

                ShiguShop shiguShop = shopMap.get(entry.getKey());
                orderVO.setId(entry.getKey());
                orderVO.setImQq(shiguShop.getImQq());
                orderVO.setImWw(shiguShop.getImAliww());
                orderVO.setWebSite(shiguShop.getWebSite());
                orderVO.setStoreNum(shiguShop.getShopNum());
                orderVO.setMarketName(shiguShop.getParentMarketName());
                List<CartVO> productVOS = entry.getValue();
                orderVO.setChildOrders(new ArrayList<CartChildOrderVO>(productVOS.size()));
                for (CartVO productVO : productVOS) {
                    CartChildOrderVO childOrderVO = new CartChildOrderVO();
                    orderVO.getChildOrders().add(childOrderVO);
                    childOrderVO.setId(productVO.getCartId());
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

    /**
     * 修改进货车内产品数量
     * @param cid 进货车产品ID cartId
     * @param num 商品数量
     */
    public void modCartOrderNum(Long cid, Integer num) throws JsonErrException {
        if (num==null || num<=0) {
            throw new JsonErrException("数量异常");
        }
        if(cid==null) {
            throw new JsonErrException("进货车商品编号缺失");
        }
        ItemCartExample itemCartExample = new ItemCartExample();
        itemCartExample.createCriteria().andCartIdEqualTo(cid);
        ItemCart itemCart = new ItemCart();
        itemCart.setNum(num);
        itemCartMapper.updateByExampleSelective(itemCart,itemCartExample);
    }

    /**
     * 修改进货车产品sku
     * @param cid 产品ID cartId
     * @param color 颜色
     * @param size 尺码
     */
    public void editChildOrderSKu(Long cid, String color, String size) {

    }

    /**
     * 删除进货车一件产品
     * @param cid cartId
     */
    public void removeChildOrder(Long cid) {

    }

    /**
     * 批量删除购物车产品
     * @param cids 产品ID列表
     */
    public void removeAllOrders(List<Long> cids) {

    }

    /**
     * 多选提交订单
     * @param cids 产品ID列表
     */
    public String submitOrders(List<Long> cids, Long userId) throws JsonErrException {
        if (cids.isEmpty()) {
            throw new JsonErrException("请选择商品");
        }
        List<CartVO> cartVOS = SpringBeanFactory.getBean(ItemCartImpl.class, userId).listProduct();
        for (Iterator<CartVO> iterator = cartVOS.iterator(); iterator.hasNext(); ) {
            CartVO cartVO = iterator.next();
            if (!cids.contains(cartVO.getCartId())) {
                iterator.remove();
            }
        }

        String uuid = UUIDGenerator.getUUID();

        OrderSubmitVo submitVo = new OrderSubmitVo();
        submitVo.setUserId(userId);
        submitVo.setSubmitType(OrderSubmitType.CART);
        submitVo.setProducts(cartVOS);
        redisIO.putTemp(uuid, submitVo, 600);
        return uuid;
    }
}
