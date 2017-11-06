package com.shigu.order.services;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.LogisticsBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.model.Order;
import com.shigu.main4.order.process.ItemCartProcess;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.*;
import com.shigu.order.vo.ServiceInfoVO;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 确认订单
 * Created by zhaohongbo on 17/6/20.
 */
@Service("confirmOrderService")
public class ConfirmOrderService {

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private OrderProvMapper orderProvMapper;

    @Autowired
    private OrderCityMapper orderCityMapper;

    @Autowired
    private OrderTownMapper orderTownMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    @Autowired
    private OrderConstantService orderConstantService;

    @Autowired
    private ItemOrderSenderMapper itemOrderSenderMapper;

    @Autowired
    private ItemCartProcess itemCartProcess;

    @Autowired
    private LogisticsService logisticsService;

    @Autowired
    private ItemProductProcess itemProductProcess;

    /**
     * 订单确认提交
     *
     * @param bo
     */
    @Transactional(rollbackFor = Exception.class)
    public Long confirmOrders(ConfirmBO bo, Long userId) throws JsonErrException {
        if (bo == null || Strings.isNullOrEmpty(bo.getCode())) {
            throw new JsonErrException("传入信息不完整");
        }
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code, OrderSubmitVo.class);
        if (orderSubmitVo == null || orderSubmitVo.getProducts().size() == 0) {
            throw new JsonErrException("没有找到产品信息");
        }
        ItemOrderBO itemOrderBO = generateItemOrderBO(bo, orderSubmitVo);
        if (!userId.equals(itemOrderBO.getUserId())) {
            throw new JsonErrException("只能操作本用户下的订单");
        }
        Long oid;
        try {
            oid = itemOrderService.createOrder(itemOrderBO);
        } catch (OrderException e) {
            throw new JsonErrException(e.getMessage());
        }
        rmCartProductByOrder(itemOrderBO);
        redisIO.del(code);
        return oid;
    }

    /**
     * 将提交订单时的数据封装为ItemOrderBO对象，参数传入时数据需要在调用处预先进行过验证
     *
     * @param bo
     * @param orderSubmitVo
     */
    private ItemOrderBO generateItemOrderBO(ConfirmBO bo, OrderSubmitVo orderSubmitVo) throws JsonErrException {
        ItemOrderBO itemOrderBO = new ItemOrderBO();
        itemOrderBO.setUserId(orderSubmitVo.getUserId());
        itemOrderBO.setSenderId(bo.getSenderId());

        // 设置物流信息
        LogisticsBO logisticsBO = new LogisticsBO();
        logisticsBO.setCompanyId(bo.getCourierId());
        logisticsBO.setAddressId(bo.getAddressId());
        itemOrderBO.setLogistics(logisticsBO);
        itemOrderBO.setOuterId(orderSubmitVo.getOuterOrderNo());

        //订单子订单信息，将ConfirmBo中 ConfirmSubOrderBO#id与OrderSubmitVo中CartVO#cartId对应，存入ItemOrderBO#subOrders中
        List<SubItemOrderBO> subOrders = Lists.newArrayList();
        Map<Long, CartVO> productsMap = BeanMapper.list2Map(orderSubmitVo.getProducts(), "cartId", Long.class);
        List<ConfirmOrderBO> confirmOrderBOS = bo.getOrders();
        String webSite = null;
        for (ConfirmOrderBO confirmOrderBO : confirmOrderBOS) {
            List<ConfirmSubOrderBO> confirmSubOrderBOS = confirmOrderBO.getChildOrders();
            //按店分子单信息
            Long marketId = null;
            Long floorId = null;
            Long shopId = null;
            List<Long> shopGoodsIds = Lists.newArrayList();
            for (ConfirmSubOrderBO confirmSubOrderBO : confirmSubOrderBOS) {
                int num = confirmSubOrderBO.getNum();
                if (num <= 0) {
                    continue;
                }
                SubItemOrderBO subOrder = new SubItemOrderBO();
                subOrder.setMark(confirmOrderBO.getRemark());
                ItemProductVO productVO = productsMap.get(Long.parseLong(confirmSubOrderBO.getId()));
                subOrder.setNum(num);
                subOrder.setPid(productVO.getPid());
                subOrder.setTitle(productVO.getTitle());
                subOrder.setSkuId(productVO.getSelectiveSku().getSkuId());
                subOrder.setWeight(productVO.getWeight());
                subOrders.add(subOrder);
                shopGoodsIds.add(productVO.getGoodsId());
                if (webSite == null) {
                    webSite = productVO.getWebSite();
                }
                if (marketId == null) {
                    marketId = productVO.getMarketId();
                }
                if (floorId == null) {
                    floorId = productVO.getFloorId();
                }
                if (shopId == null) {
                    shopId = productVO.getShopId();
                }
            }
            if (shopGoodsIds.size() > 0) {
                if (!itemProductProcess.listGoodsCanSale(marketId, floorId, shopId, shopGoodsIds, webSite)) {
                    throw new JsonErrException("订单中含有不可售商品，请检查订单");
                }
            }
        }
        itemOrderBO.setSubOrders(subOrders);
        SubItemOrderBO subItemOrderBO = subOrders.get(0);
        String title = subItemOrderBO.getTitle();
        if (subOrders.size() > 1) {
            title = title.length() > 10 ? title.substring(0, 10) : title;
            title += "...等多件";
        }
        itemOrderBO.setTitle(title);
        itemOrderBO.setWebSite(webSite);
        itemOrderBO.setMark(subItemOrderBO.getMark());

        return itemOrderBO;
    }

    /**
     * 根据订单对象信息移除购物车中的记录
     *
     * @param itemOrderBO
     */
    private void rmCartProductByOrder(ItemOrderBO itemOrderBO) throws JsonErrException {
        //根据用户获取购物车对象
        for (SubItemOrderBO subItemOrderBO : itemOrderBO.getSubOrders()) {
            itemCartProcess.rmProductByNum(itemOrderBO.getUserId(), subItemOrderBO.getPid(), subItemOrderBO.getSkuId(), subItemOrderBO.getNum());
        }
    }

    /**
     * 某用户收藏地址列表
     *
     * @param userId 用户id
     * @return 收藏
     */
    public List<CollListVO> collListByUser(Long userId) {
        List<BuyerAddressVO> collList = itemOrderService.selBuyerAddress(userId);//收藏的地址数据
        List<CollListVO> collListVOS = new ArrayList<>(collList.size());
        for (BuyerAddressVO buyerAddressVO : collList) {
            CollListVO vo = new CollListVO();
            collListVOS.add(vo);
            vo.setId(buyerAddressVO.getAddressId());
            vo.setAddress(buyerAddressVO.getProvince() + " " + buyerAddressVO.getCity() + " " + buyerAddressVO.getTown() + " " + buyerAddressVO.getAddress());
            vo.setName(buyerAddressVO.getName());
            vo.setPhone(buyerAddressVO.getTelephone());
        }
        return collListVOS;
    }

    /**
     * 服务规则包装，待完善
     *
     * @param orders   订单商品信息
     * @param senderId 发货机构
     * @return 服务对应表
     */
    public List<ServiceRuleVO> serviceRulePack(List<CartOrderVO> orders, Long senderId) {
        ItemOrderSender sender = itemOrderSenderMapper.selectByPrimaryKey(senderId);
        boolean isDaifa = sender.getType() == 1;

        Map<Long, Long> shopMarketMap = Collections.emptyMap();
        if (isDaifa) {
            List<Long> shopIds = orders.stream().map(CartOrderVO::getShopId).distinct().collect(Collectors.toList());
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andShopIdIn(shopIds);
            shopMarketMap = shiguShopMapper.selectByExample(shopExample).stream().collect(Collectors.toMap(ShiguShop::getShopId, ShiguShop::getMarketId));
        }

//        List<MetarialVO> metarialVOS = orderConstantService.selMetarials(senderId);
        List<ServiceRuleVO> serviceRuleVOS = new ArrayList<>(orders.size());
        for (CartOrderVO orderVO : orders) {
            ServiceRuleVO ruleVO = new ServiceRuleVO();
            serviceRuleVOS.add(ruleVO);
            ruleVO.setOrderId(orderVO.getShopId());
            ruleVO.setSenderId(senderId);
            ruleVO.setServices(new ArrayList<>());

            if (isDaifa) {
                ServiceVO serviceRuler = orderConstantService.selDfService(senderId, shopMarketMap.get(orderVO.getShopId()));
                ServiceInfoVO infoVO = new ServiceInfoVO();
                infoVO.setText("代发费");
                infoVO.setPrice(serviceRuler.getPrice() * .01);
                ruleVO.getServices().add(infoVO);
            }

//            for (MetarialVO metarialVO : metarialVOS) {TODO: 包材不计算
//                ServiceInfoVO infoVO = new ServiceInfoVO();
//                infoVO.setText(metarialVO.getName());
//                infoVO.setPrice(metarialVO.getPrice() * .01);
//                ruleVO.getServices().add(infoVO);
//            }
        }
        return serviceRuleVOS;
    }

    public List<SenderInfoVO> senderListDefault(Long senderId) {
        List<SenderInfoVO> infoVOS = new ArrayList<>();
        for (ItemOrderSender sender : itemOrderSenderMapper.select(new ItemOrderSender())) {
            SenderInfoVO info = new SenderInfoVO();
            info.setId(sender.getSenderId().toString());
            info.setText(sender.getSenderName());
            info.setChecked(Objects.equals(sender.getSenderId(), senderId));
            infoVOS.add(info);
        }
        return infoVOS;
    }

    public String selProvById(Long provId) {
        OrderProv prov = orderProvMapper.selectByPrimaryKey(provId);
        return prov.getProvName();
    }

    public String selCityById(Long cityId) {
        OrderCity city = orderCityMapper.selectByPrimaryKey(cityId);
        return city.getCityName();
    }

    public String selTownById(Long townId) {
        if (townId == null) {
            return null;
        }
        OrderTown town = orderTownMapper.selectByPrimaryKey(townId);
        return town.getTownName();
    }

    /**
     * 临时保存地址，用于确认订单不收藏地址这种情况
     *
     * @param buyerAddressVO
     */
    public String saveTmpBuyerAddress(BuyerAddressVO buyerAddressVO) {
        String addressId = UUID.randomUUID().toString().replace("-", "");
        redisIO.putTemp("tmp_buyer_address_" + addressId, buyerAddressVO, 200);
        return addressId;
    }

    /**
     * 获取临时保存地址，用于确认订单不收藏地址这种情况
     *
     * @param addressId
     */
    public BuyerAddressVO selTmpBuyerAddress(String addressId) {
        return redisIO.get("tmp_buyer_address_" + addressId, BuyerAddressVO.class);
    }

    /**
     * 获取快递公司信息
     *
     * @param provId   省份id
     * @param senderId 发货方式id
     * @return
     */
    public List<PostVO> getPostListByProvId(String provId, String senderId) throws LogisticsRuleException {
        return logisticsService.getPostListByProvId(new Long(provId), new Long(senderId));
    }

    /**
     * 获取快递与服务费信息
     *
     * @param postName
     * @param provId
     * @param eachShopNum 每家店铺的商品数量 如{店铺id:商品数量，店铺id:商品数量，}
     * @param totalWeight
     * @return
     */
    public OtherCostVO getOtherCost(String postName, String provId, String eachShopNum, Long totalWeight, String senderId) throws JsonErrException, LogisticsRuleException {
        ItemOrderSender sender = itemOrderSenderMapper.selectByPrimaryKey(senderId);
        boolean isDaifa = sender.getType() == 1;

        JSONObject shopSumJson = JSONObject.fromObject(eachShopNum);
        Integer goodsNumber = shopSumJson.values()
                .stream().mapToInt(value -> Integer.parseInt(value.toString())).sum();
        List<Long> shopIds = new ArrayList<>();
        Iterator iterator = shopSumJson.keys();
        while (iterator.hasNext()) {
            shopIds.add(Long.parseLong(iterator.next().toString()));
        }

        Map<Long, Long> shopMarketMap = Collections.emptyMap();
        if (isDaifa) {
            ShiguShopExample shopExample = new ShiguShopExample();
            shopExample.createCriteria().andShopIdIn(shopIds);
            shopMarketMap = shiguShopMapper.selectByExample(shopExample).stream().collect(Collectors.toMap(ShiguShop::getShopId, ShiguShop::getMarketId));
        }

        ExpressCompany expressCompany = new ExpressCompany();
        expressCompany.setRemark2(postName);
        expressCompany = expressCompanyMapper.selectOne(expressCompany);
        if (expressCompany == null) {
            throw new JsonErrException("未查询到快递信息");
        }

        Long postPrice = logisticsService.calculate(new Long(provId), expressCompany.getExpressCompanyId(), goodsNumber, totalWeight, new Long(senderId));
        postPrice = MoneyUtil.StringToLong(String.valueOf(postPrice));

        OtherCostVO otherCostVO = new OtherCostVO();
        otherCostVO.setPostPrice(postPrice);//元转分
        List<ServiceInfosTextVO> serviceInfosText = new ArrayList<>();
        if (isDaifa) {
            ServiceInfosTextVO infoVO = new ServiceInfosTextVO();
            infoVO.setText("代发费");
            Long totalCost = 0L;
            for (Long shopId : shopIds) {
                ServiceVO serviceRuler = orderConstantService.selDfService(Long.parseLong(senderId), shopMarketMap.get(shopId));
                totalCost += serviceRuler.getPrice() * Integer.parseInt(String.valueOf(shopSumJson.get(shopId.toString())));
            }
            infoVO.setCost(MoneyUtil.dealPrice(totalCost));//元
            serviceInfosText.add(infoVO);

            //此处总服务费用 == 代发费
            otherCostVO.setServicePrice(totalCost);//总服务费分
        }
        otherCostVO.setServiceInfosText(serviceInfosText);
        return otherCostVO;
    }

    public ConfirmTbBatchOrderVO confirmTbBatchOrder(List<OrderSubmitVo> tbTrades, Long senderId) {
        int orderNum = tbTrades.size();
        int goodsNum = 0;
        long serviceTotalPrice = 0L;
        long goodsTotalPrice = 0L;

        Map<Long, Integer> marketNumMap = new HashMap<>();
        for (OrderSubmitVo t : tbTrades) {
            for (CartVO cart : t.getProducts()) {
                goodsTotalPrice += cart.getPrice();
                goodsNum += cart.getNum();
                Integer marketNum = marketNumMap.get(cart.getMarketId());
                if (marketNum == null) {
                    marketNum = 0;
                }
                marketNum += cart.getNum();
                marketNumMap.put(cart.getMarketId(), marketNum);
            }
        }
        for (Long marketId : marketNumMap.keySet()) {
            ServiceVO serviceRuler = orderConstantService.selDfService(senderId, marketId);
            serviceTotalPrice += marketNumMap.get(marketId) * serviceRuler.getPrice();
        }
        ConfirmTbBatchOrderVO vo = new ConfirmTbBatchOrderVO();
        vo.setGoodsNum(goodsNum);
        vo.setGoodsTotalPrice(MoneyUtil.dealPrice(goodsTotalPrice));
        vo.setOrderNum(orderNum);
        vo.setServiceTotalPrice(MoneyUtil.dealPrice(serviceTotalPrice));
        return vo;
    }

    public Long confirmTbBatchOrderPostFee(List<OrderSubmitVo> tbTrades, Long senderId, Long companyId) throws LogisticsRuleException {
        long postPrice=0L;
        for (OrderSubmitVo t : tbTrades) {
            BuyerAddressVO buyerAddress = redisIO.get("tmp_buyer_address_" + t.getTbOrderAddressInfo().getAddressId(), BuyerAddressVO.class);
            postPrice += logisticsService.calculate(buyerAddress.getProvId(), companyId,
                    t.getProducts().stream().mapToInt(CartVO::getNum).sum(),
                    null, senderId);

        }
        return postPrice;
    }
}
