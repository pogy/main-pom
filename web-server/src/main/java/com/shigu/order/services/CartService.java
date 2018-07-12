package com.shigu.order.services;

import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.ShiguMarketExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguMarketMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.process.ItemCartProcess;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.OrderSubmitType;
import com.shigu.order.bo.AddCartPropBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.vo.CartChildOrderVO;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.CartPageVO;
import com.shigu.order.vo.OrderSubmitVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShowForCdnService showForCdnService;

    @Autowired
    private ItemCartProcess itemCartProcess;

    @Autowired
    private ItemProductProcess itemProductProcess;

    @Autowired
    private RedisIO redisIO;

    public Map<Long, ShiguShop> selShopIn(List<Long> shopIds) {
        if (shopIds == null || shopIds.isEmpty()) {
            return Collections.emptyMap();
        }
        ShiguShopExample shiguShopExample = new ShiguShopExample();
        shiguShopExample.createCriteria().andShopIdIn(shopIds);

        Map<Long, ShiguShop> shopMap = shiguShopMapper.selectByExample(shiguShopExample).stream().collect(Collectors.toMap(ShiguShop::getShopId, s -> s));

        List<Long> markets = shopMap.values().stream().map(ShiguShop::getMarketId).collect(Collectors.toList());
        if (!markets.isEmpty()) {
            ShiguMarketExample marketExample = new ShiguMarketExample();
            marketExample.createCriteria().andMarketIdIn(markets);
            Map<Long, ShiguMarket> marketMap = shiguMarketMapper.selectByExample(marketExample).stream().collect(Collectors.toMap(ShiguMarket::getMarketId, m -> m));
            shopMap.values().forEach(shop -> shop.setParentMarketName(marketMap.get(shop.getMarketId()).getMarketName()));
        }
        return shopMap;
    }

    /**
     * 进货车页面
     *
     * @param userId 用户ID
     * @return 页面数据
     */
    public CartPageVO selMyCart(Long userId) throws OrderException {
        CartPageVO vo = packCartProductVo(itemCartProcess.someOneCart(userId));
//        vo.setGoodsCount(itemCartProcess.productNumbers(userId));
        return vo;
    }

    /**\
     * 包装进货车商品对象
     * @param vos 进货车商品源信息
     */
    public CartPageVO packCartProductVo(List<CartVO> vos) throws OrderException {
        CartPageVO vo = new CartPageVO();
        Map<Long, List<CartVO>> groupByShop = vos.stream().collect(Collectors.groupingBy(CartVO::getShopId));
        vo.setOrders(new ArrayList<>(groupByShop.size()));
        int num=0;
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
                orderVO.setChildOrders(new ArrayList<>(productVOS.size()));
                for (CartVO productVO : productVOS) {
                    CartChildOrderVO childOrderVO = new CartChildOrderVO();
                    orderVO.getChildOrders().add(childOrderVO);
                    childOrderVO.setLastModify(productVO.getLastModify());
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
                        orderVO.setWebSite(productVO.getWebSite());
                    } else {
                        childOrderVO.setGoodsNo(cdnItem.getHuohao());
                        childOrderVO.setColors(BeanMapper.getFieldList(cdnItem.getColors(), "value", String.class));
                        childOrderVO.setSizes(BeanMapper.getFieldList(cdnItem.getSizes(), "value", String.class));
                        num+=productVO.getNum();
                        orderVO.setWebSite(cdnItem.getWebSite());
                    }
                }
                Collections.sort(orderVO.getChildOrders());
                Collections.reverse(orderVO.getChildOrders());
                orderVO.setLastModify(Collections.max(orderVO.getChildOrders()).getLastModify());
            }
            Collections.sort(vo.getOrders());
            Collections.reverse(vo.getOrders());
        }
        vo.setGoodsCount(num);
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
            itemCartProcess.modProductNumber(userId, cid, num);
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
        List<CartVO> cartVOS = itemCartProcess.someOneCart(userId);
        cartVOS.removeIf(cartVO -> !cids.contains(cartVO.getCartId()));
        Set<String> webs=cartVOS.stream().map(CartVO::getWebSite).collect(Collectors.toSet());
        if(webs.size()>1){
            throw new JsonErrException("单次只能结算单个分站的订单");
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
        itemCartProcess.rmProduct(userId, cid);
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
                itemCartProcess.rmProduct(userId, cid);
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
            itemCartProcess.modifyProductSku(userId, cid, color, size);
        } catch (CartException e) {
            throw new JsonErrException(e.getMessage());
        }
    }


    /**
     * 新增进货车
     * @param userId
     * @param goodsId
     * @param skus
     */
    public void addCartOrder(Long userId, Long goodsId, List<AddCartPropBO> skus){
        for(AddCartPropBO sku:skus){
            itemCartProcess.addProduct(
                    userId,
                    itemProductProcess.generateProduct(goodsId, sku.getColor(), sku.getSize()),
                    sku.getCount()
            );
        }
    }
}
