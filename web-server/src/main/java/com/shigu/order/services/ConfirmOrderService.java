package com.shigu.order.services;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.ItemOrderSenderExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.LogisticsBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.process.ItemCartProcess;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmMoreTbBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.vo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    static Map<String,Long> webSender=new HashMap<>();
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

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;
    @Autowired
    NewShowForCdnService newShowForCdnService;

    private static String ORDER_EXPRESS_ADDRESS = "order_express_address";

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


    public void isAddress(String addressId) throws JsonErrException {
        if (addressId == null || Strings.isNullOrEmpty(addressId)){
            throw new JsonErrException("地址为空");
        }
        try {
            Long aid = Long.valueOf(addressId);
            BuyerAddress buyerAddress = buyerAddressMapper.selectByPrimaryKey(aid);
            if (buyerAddress != null){
                return;
            }
        } catch (NumberFormatException e) {
            BuyerAddressVO buyerAddressVO = redisIO.get("tmp_buyer_address_" + addressId, BuyerAddressVO.class);
            if (buyerAddressVO == null) {
                throw new JsonErrException("下单失败，未查询到收货地址");
            }
//            String provs = redisIO.get(ORDER_EXPRESS_ADDRESS,String.class);
//            List<ProvVo> provVoList = com.alibaba.fastjson.JSONArray.parseArray(provs, ProvVo.class);
//            if (provVoList == null || provVoList.size()<=0)
//                throw new JsonErrException("请刷新页面重试");
//            int b = 0;
//            for (ProvVo provVo : provVoList) {
//                if (provVo.getProvId().equals(buyerAddressVO.getProvId()))
//                    b++;
//                List<CityVo> cityVos = provVo.getCitys();
//                for (CityVo cityVo : cityVos) {
//                    if (cityVo.getCityId().equals(buyerAddressVO.getCityId()))
//                        b++;
//                    List<TownVo> townVos = cityVo.getCountys();
//                    if (buyerAddressVO.getTownId()!=null && townVos!= null){
//                        for (TownVo townVo : townVos) {
//                            if (townVo.getCountyId().equals(buyerAddressVO.getTownId()))
//                                b++;
//                        }
//                    }
//                }
//            }
//            if (buyerAddressVO.getTownId() != null){
//                if (b!=3)
//                    throw new JsonErrException("地址错误请刷新页面重试");
//            }else {
//                if (b!=2){
//                    throw  new JsonErrException("地址错误请刷新页面重试");
//                }
//            }
            ProvinceVO provVo = orderConstantService.selProvByPid(buyerAddressVO.getProvId());
            if (provVo==null){
                throw new JsonErrException("省地址错误请检查");
            }
            CityVO cityVO = orderConstantService.selCityByCid(buyerAddressVO.getCityId());
            if (cityVO==null){
                throw new JsonErrException("市地址错误请检查");
            }
            if (buyerAddressVO.getTownId()!=null){
                TownVO townVO = orderConstantService.selTownByTid(buyerAddressVO.getTownId());
                if (townVO==null){
                    throw new JsonErrException("区域地址错误请检查");
                }
            }
        }
        return;
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

        // 设置物流信息
        LogisticsBO logisticsBO = new LogisticsBO();
        logisticsBO.setCompanyId(bo.getCourierId().toString());
        logisticsBO.setAddressId(bo.getAddressId());
        itemOrderBO.setLogistics(logisticsBO);
        itemOrderBO.setOuterId(orderSubmitVo.getOuterOrderNo());

        //订单子订单信息，将ConfirmBo中 ConfirmSubOrderBO#id与OrderSubmitVo中CartVO#cartId对应，存入ItemOrderBO#subOrders中
        List<SubItemOrderBO> subOrders = Lists.newArrayList();
        Map<Long, CartVO> productsMap = BeanMapper.list2Map(orderSubmitVo.getProducts(), "cartId", Long.class);
        List<ConfirmOrderBO> confirmOrderBOS = bo.getOrders();
        String webSite = null;
        Map<Long,NewCdnItem> longNewCdnItemMap=new HashMap<>();
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
                NewCdnItem cdnItem = longNewCdnItemMap.get(productVO.getGoodsId());
                if(cdnItem==null){
                    cdnItem=newShowForCdnService.selItemById(productVO.getGoodsId(), productVO.getWebSite());
                    longNewCdnItemMap.put(productVO.getGoodsId(),cdnItem);
                }
                if(cdnItem==null){
                    throw new JsonErrException("存在无效商品");
                }else{
                    boolean err=true;
                    List<SingleSkuVO> singleSkus = cdnItem.getSingleSkus();
                    for(SingleSkuVO singleSkuVO:singleSkus){
                        String color = singleSkuVO.getThisColor();
                        String size = singleSkuVO.getThisSize();
                        Integer stockNum=singleSkuVO.getStatus()==0?0:singleSkuVO.getStockNum();
                        if(color.equals(productVO.getSelectiveSku().getColor())&&size.equals(productVO.getSelectiveSku().getSize())){
                            if(stockNum==0){
                                throw new JsonErrException("存在无效商品");
                            }
                            err=false;
                            break;
                        }
                    }
                    if(err){
                        throw new JsonErrException("存在无效商品");
                    }
                }
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
        itemOrderBO.setSenderId(this.selSendIdByItemId(webSite));



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
            vo.setAddress(buyerAddressVO.getProvince() + " " + buyerAddressVO.getCity() + " " +(buyerAddressVO.getTown()==null?"":buyerAddressVO.getTown())+ " " + buyerAddressVO.getAddress());
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
            List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);
            shopMarketMap = shiguShops.stream().collect(Collectors.toMap(ShiguShop::getShopId, ShiguShop::getMarketId));
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
            info.setChecked(Objects.equals(sender.getSenderId(), senderId)?"":null);
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
     * @param companyId
     * @param provId
     * @param eachShopNum 每家店铺的商品数量 如{店铺id:商品数量，店铺id:商品数量，}
     * @param totalWeight
     * @return
     */
    public OtherCostVO getOtherCost(Long companyId, String provId, String eachShopNum, Long totalWeight, String senderId, Long userId) throws JsonErrException, LogisticsRuleException {
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

//        ExpressCompany expressCompany = new ExpressCompany();
//        expressCompany.setRemark2(postName);
//        expressCompany = expressCompanyMapper.selectOne(expressCompany);
//        if (expressCompany == null) {
//            throw new JsonErrException("未查询到快递信息");
//        }
        Boolean discounts = false;
        Long postPrice = logisticsService.calculate(userId, new Long(provId), companyId, goodsNumber, totalWeight, new Long(senderId), discounts);
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

    /**
     * 淘宝批量下单获取整合信息
     *
     * @param tbTrades
     * @param senderId
     * @return
     */
    public ConfirmTbBatchOrderVO confirmTbBatchOrder(List<OrderSubmitVo> tbTrades, Long senderId) {
        int orderNum = tbTrades.size();
        int goodsNum = 0;
        long serviceTotalPrice = 0L;
        long goodsTotalPrice = 0L;

        Map<Long, Integer> marketNumMap = new HashMap<>();
        for (OrderSubmitVo t : tbTrades) {
            for (CartVO cart : t.getProducts()) {
                goodsTotalPrice += cart.getPrice() * cart.getNum();
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

    /**
     * 淘宝批量下单获取快递费
     *
     * @param tbTrades
     * @param senderId
     * @param postId
     * @return
     * @throws LogisticsRuleException
     */
    public Long confirmTbBatchOrderPostFee(List<OrderSubmitVo> tbTrades, Long senderId, Long postId, Long userId) throws LogisticsRuleException {
        long postPrice = 0L;
        Boolean discounts = false;
        for (OrderSubmitVo t : tbTrades) {
            BuyerAddressVO buyerAddress = redisIO.get("tmp_buyer_address_" + t.getTbOrderAddressInfo().getAddressId(), BuyerAddressVO.class);
            postPrice += logisticsService.calculate(userId, buyerAddress.getProvId(), postId,
                    t.getProducts().stream().mapToInt(CartVO::getNum).sum(),
                    null, senderId, discounts);
            discounts = false;
        }
        return postPrice;
    }

    /**
     * 淘宝批量下单确认提交
     *
     * @param bo
     */
    @Transactional(rollbackFor = Exception.class)
    public String confirmTbBatchOrders(ConfirmMoreTbBO bo, Long userId, List<OrderSubmitVo> tbTrades) throws JsonErrException {
        String code = bo.getIdCode();
        List<ItemOrderBO> items = new ArrayList<>();
        Set<String> webs=new HashSet<>();
        for (OrderSubmitVo orderSubmitVo : tbTrades) {
            ConfirmBO b = new ConfirmBO();
            b.setAddressId(orderSubmitVo.getTbOrderAddressInfo().getAddressId());
            b.setCourierId(bo.getPostId());
            b.setOrders(orderSubmitVo.getProducts().stream().collect(Collectors.groupingBy(CartVO::getShopId))
                    .entrySet().stream().map(longListEntry -> {
                        ConfirmOrderBO c = new ConfirmOrderBO();
                        c.setOrderId(longListEntry.getKey().toString());
                        c.setShopId(longListEntry.getKey());
                        c.setChildOrders(longListEntry.getValue().stream().map(cartVO -> {
                            ConfirmSubOrderBO cn = new ConfirmSubOrderBO();
                            cn.setId(cartVO.getCartId().toString());
                            cn.setNum(cartVO.getNum());
                            webs.add(cartVO.getWebSite());
                            return cn;
                        }).collect(Collectors.toList()));
                        return c;
                    }).collect(Collectors.toList()));
            if(webs.size()>1||!webs.contains("hz")){
                throw new JsonErrException("批量下单暂时只支持杭州站商品");
            }
            ItemOrderBO itemOrderBO = generateItemOrderBO(b, orderSubmitVo);
            if (!userId.equals(itemOrderBO.getUserId())) {
                throw new JsonErrException("只能操作本用户下的订单");
            }
            items.add(itemOrderBO);
        }
        ;
        List<Long> oids;
        try {
            oids = itemOrderService.createOrders(items);
        } catch (Exception e) {
            e.printStackTrace();
            throw new JsonErrException(e.getMessage());
        }
        redisIO.del(code);
        String uuid = UUIDGenerator.getUUID();
        redisIO.putTemp(uuid, oids, 600);
        return uuid;
    }

    public String getArea() {
        List<OrderProv> orderProvs = orderProvMapper.select(new OrderProv());
        if (orderProvs == null || orderProvs.size() <= 0) {
            return "";
        }
        List<ProvVo> provVoList = new ArrayList<>();
        for (OrderProv orderProv : orderProvs) {
            ProvVo provVo = new ProvVo();
            provVo.setProvId(orderProv.getProvId());
            provVo.setProvText(orderProv.getProvName());
            provVo.setCitys(new ArrayList<CityVo>());
            provVoList.add(provVo);
            OrderCity orderCity = new OrderCity();
            orderCity.setProvId(orderProv.getProvId());
            List<OrderCity> orderCitys = orderCityMapper.select(orderCity);
            if (orderCitys != null || orderCitys.size() > 0) {
                for (OrderCity city : orderCitys) {
                    CityVo cityVo = new CityVo();
                    cityVo.setCityId(city.getCityId());
                    cityVo.setCityText(city.getCityName());
                    cityVo.setCountys(new ArrayList<TownVo>());
                    provVo.getCitys().add(cityVo);
                    OrderTown orderTown = new OrderTown();
                    orderTown.setCityId(city.getCityId());
                    List<OrderTown> orderTowns = orderTownMapper.select(orderTown);
                    if (orderTowns != null || orderTowns.size() > 0) {
                        for (OrderTown town : orderTowns) {
                            TownVo townVo = new TownVo();
                            townVo.setCountyId(town.getTownId());
                            townVo.setCountyText(town.getTownName());
                            cityVo.getCountys().add(townVo);
                        }
                    }
                }
            }
        }
        String date = JSONArray.fromObject(provVoList).toString();
        redisIO.put(ORDER_EXPRESS_ADDRESS, date);
        return date;
    }


    public Long selSendIdByItemId(String webSite){
        Long senderId = webSender.get(webSite);
        if(senderId==null){
            ItemOrderSenderExample itemOrderSenderExample=new ItemOrderSenderExample();
            itemOrderSenderExample.createCriteria().andWebSiteEqualTo(webSite);
            List<ItemOrderSender> s=itemOrderSenderMapper.selectByExample(itemOrderSenderExample);
            if(s.size()==0){
                return selSendIdByItemId("hz");
            }
            senderId=s.get(0).getSenderId();
            webSender.put(webSite,senderId);
        }
        return senderId;
    }

}
