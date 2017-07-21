package com.shigu.order.services;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ItemCartMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.model.impl.ItemCartImpl;
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

import java.util.*;

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

    public Map<Long, ShiguShop> selShopIn(List<Long> shopIds) {
        if (shopIds == null || shopIds.isEmpty()) {
            return new HashMap<>();
        }
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopIdIn(shopIds);
        return BeanMapper.list2Map(shiguShopMapper.selectByExample(shiguShopExample), "shopId", Long.class);
    }

    /**
     * 进货车页面
     *
     * @param userId 用户ID
     * @return 页面数据
     */
    public CartPageVO selMyCart(Long userId) {
        ItemCartImpl itemCart = SpringBeanFactory.getBean(ItemCartImpl.class, userId);
        CartPageVO vo = packCartProductVo(itemCart.listProduct());
        vo.setGoodsCount(itemCart.productNumbers());
        return vo;
    }

    /**\
     * 包装进货车商品对象
     * @param vos 进货车商品源信息
     */
    public CartPageVO packCartProductVo(List<CartVO> vos) {
        CartPageVO vo = new CartPageVO();
        Map<Long, List<CartVO>> groupByShop = BeanMapper.groupBy(vos, "shopId", Long.class);
        vo.setOrders(new ArrayList<CartOrderVO>(groupByShop.size()));
        if (!groupByShop.isEmpty()) {
            Map<Long, ShiguShop> shopMap = selShopIn(new ArrayList<>(groupByShop.keySet()));

            for (Map.Entry<Long, List<CartVO>> entry : groupByShop.entrySet()) {
                CartOrderVO orderVO = new CartOrderVO();
                vo.getOrders().add(orderVO);
                Long shopId = entry.getKey();
                orderVO.setOrderId(shopId);
                orderVO.setShopId(shopId);
                ShiguShop shiguShop = shopMap.get(shopId);
                if (shiguShop != null) {
                    orderVO.setImQq(shiguShop.getImQq());
                    orderVO.setImWw(shiguShop.getImAliww());
                    orderVO.setWebSite(shiguShop.getWebSite());
                    orderVO.setStoreNum(shiguShop.getShopNum());
                    orderVO.setMarketName(shiguShop.getParentMarketName());
                }
                List<CartVO> productVOS = entry.getValue();
                orderVO.setChildOrders(new ArrayList<CartChildOrderVO>(productVOS.size()));
                for (CartVO productVO : productVOS) {
                    CartChildOrderVO childOrderVO = new CartChildOrderVO();
                    orderVO.getChildOrders().add(childOrderVO);
                    childOrderVO.setWeight(productVO.getWeight());
                    childOrderVO.setChildOrderId(productVO.getCartId());
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
     *
     * @param userId
     * @param cid 进货车产品ID cartId
     * @param num 商品数量
     */
    public void modCartOrderNum(Long userId, Long cid, Integer num) throws JsonErrException {
        if (num == null || num <= 0) {
            throw new JsonErrException("数量异常");
        }
        if (cid == null) {
            throw new JsonErrException("进货车商品编号缺失");
        }
        try {
            getCartByUser(userId).modifyProductNumber(cid, num);
        } catch (CartException e) {
            throw new JsonErrException(e.getMessage());
        }
    }


    /**
     * 多选提交订单
     *
     * @param cids 产品ID列表
     */
    public String submitOrders(List<Long> cids, Long userId) throws JsonErrException {
        if (cids.isEmpty()) {
            throw new JsonErrException("请选择商品");
        }
        List<CartVO> cartVOS = getCartByUser(userId).listProduct();
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

    /**
     * 删除进货车一件产品
     *
     * @param userId
     * @param cid cartId
     */
    public void removeChildOrder(Long userId, Long cid) {
        if (null == cid) {
            return;
        }
        getCartByUser(userId).rmProduct(cid);
    }

    private ItemCartImpl getCartByUser(Long userId) {
        return SpringBeanFactory.getBean(ItemCartImpl.class, userId);
    }

    /**
     * 批量删除购物车产品
     *
     * @param userId
     * @param cids 产品ID列表
     */
    public void removeAllOrders(Long userId, List<Long> cids) {
        if (cids != null) {
            for (Long cid : cids) {
                getCartByUser(userId).rmProduct(cid);
            }
        }
    }

    /**
     * 修改进货车产品sku
     *
     * @param userId
     * @param cid   产品ID cartId
     * @param color 颜色
     * @param size  尺码
     */
    public void editChildOrderSKu(Long userId, Long cid, String color, String size) throws JsonErrException {
        try {
            getCartByUser(userId).modifyProductSku(cid, color, size);
        } catch (CartException e) {
            throw new JsonErrException(e.getMessage());
        }
    }
}
