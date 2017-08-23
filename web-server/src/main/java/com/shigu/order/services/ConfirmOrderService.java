package com.shigu.order.services;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.LogisticsBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.process.ItemCartProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.vo.*;
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


    /**
     * 订单确认提交
     * @param bo
     */
    @Transactional(rollbackFor = Exception.class)
    public Long confirmOrders(ConfirmBO bo) throws JsonErrException {
        if (bo == null || Strings.isNullOrEmpty(bo.getCode())) {
            throw new JsonErrException("传入信息不完整");
        }
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code,OrderSubmitVo.class);
        if (orderSubmitVo == null || orderSubmitVo.getProducts().size() == 0) {
            throw new JsonErrException("没有找到产品信息");
        }
        ItemOrderBO itemOrderBO  = generateItemOrderBO(bo, orderSubmitVo);
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
     * @param bo
     * @param orderSubmitVo
     */
    private ItemOrderBO generateItemOrderBO(ConfirmBO bo, OrderSubmitVo orderSubmitVo) {
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
        Map<Long, CartVO> productsMap = BeanMapper.list2Map(orderSubmitVo.getProducts(),"cartId", Long.class);
        List<ConfirmOrderBO> confirmOrderBOS = bo.getOrders();
        String webSite = null;
        for (ConfirmOrderBO confirmOrderBO: confirmOrderBOS) {
            List<ConfirmSubOrderBO> confirmSubOrderBOS = confirmOrderBO.getChildOrders();
            for (ConfirmSubOrderBO confirmSubOrderBO: confirmSubOrderBOS) {
                int num = confirmSubOrderBO.getNum();
                if (num <= 0) {
                    continue;
                }
                SubItemOrderBO subOrder = new SubItemOrderBO();
                subOrder.setMark(confirmOrderBO.getRemark());
                ItemProductVO productVO=productsMap.get(Long.parseLong(confirmSubOrderBO.getId()));
                subOrder.setNum(num);
                subOrder.setPid(productVO.getPid());
                subOrder.setTitle(productVO.getTitle());
                subOrder.setSkuId(productVO.getSelectiveSku().getSkuId());
                subOrder.setWeight(productVO.getWeight());
                subOrders.add(subOrder);
                if (webSite == null) {
                    webSite=productVO.getWebSite();
                }
            }
        }
        itemOrderBO.setSubOrders(subOrders);
        SubItemOrderBO  subItemOrderBO= subOrders.get(0);
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
     * @param itemOrderBO
     */
    private void rmCartProductByOrder(ItemOrderBO itemOrderBO) throws JsonErrException {
        //根据用户获取购物车对象
        for (SubItemOrderBO subItemOrderBO: itemOrderBO.getSubOrders()) {
            itemCartProcess.rmProductByNum(itemOrderBO.getUserId(), subItemOrderBO.getPid(), subItemOrderBO.getSkuId(), subItemOrderBO.getNum());
        }
    }

    /**
     * 某用户收藏地址列表
     * @param userId 用户id
     * @return 收藏
     */
    public List<CollListVO> collListByUser(Long userId) {
        List<BuyerAddressVO> collList =  itemOrderService.selBuyerAddress(userId);//收藏的地址数据
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
     * @param orders 订单商品信息
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
        OrderTown town = orderTownMapper.selectByPrimaryKey(townId);
        return town.getTownName();
    }

    /**
     * 临时保存地址，用于确认订单不收藏地址这种情况
     * @param buyerAddressVO
     */
    public String saveTmpBuyerAddress(BuyerAddressVO buyerAddressVO) {
        String addressId = UUID.randomUUID().toString().replace("-","");
        redisIO.putTemp("tmp_buyer_address_" + addressId, buyerAddressVO, 200);
        return addressId;
    }

    /**
     * 获取临时保存地址，用于确认订单不收藏地址这种情况
     * @param addressId
     */
    public BuyerAddressVO selTmpBuyerAddress(String addressId) {
        return redisIO.get("tmp_buyer_address_" + addressId, BuyerAddressVO.class);
    }

    public List<PostRuleVO> selPostRules(Long senderId, Long provId) throws JsonErrException {
        List<PostRuleVO> vos = new ArrayList<>();
        Map<Long, ExpressCompany> expressCompanyMap = Collections.emptyMap();
        try {
            List<BournRuleInfoVO> rules = logisticsService.selRulesByProvId(senderId,provId);
            List<Long> companyIds = BeanMapper.getFieldList(rules, "companyId", Long.class);
            if (!companyIds.isEmpty()) {
                ExpressCompanyExample companyExample = new ExpressCompanyExample();
                companyExample.createCriteria().andExpressCompanyIdIn(companyIds);
                expressCompanyMap = BeanMapper.list2Map(expressCompanyMapper.selectByExample(companyExample), "expressCompanyId", Long.class);
            }
            for (BournRuleInfoVO rule : rules) {
                PostRuleVO postRuleVO = BeanMapper.map(rule, PostRuleVO.class);
                vos.add(postRuleVO);
                ExpressCompany expressCompany = expressCompanyMap.get(rule.getCompanyId());
                if (expressCompany != null) {
                    postRuleVO.setName(expressCompany.getEnName());
                    postRuleVO.setText(expressCompany.getExpressName());
                }
            }
        } catch (LogisticsRuleException e) {
            throw new JsonErrException(e.getMessage());
        }
        return vos;
    }
}
