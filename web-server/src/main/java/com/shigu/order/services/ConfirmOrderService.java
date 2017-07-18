package com.shigu.order.services;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.OrderCity;
import com.opentae.data.mall.beans.OrderProv;
import com.opentae.data.mall.beans.OrderTown;
import com.opentae.data.mall.interfaces.OrderCityMapper;
import com.opentae.data.mall.interfaces.OrderProvMapper;
import com.opentae.data.mall.interfaces.OrderTownMapper;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.ItemOrderSender;
import com.opentae.data.mall.interfaces.ExpressCompanyMapper;
import com.opentae.data.mall.interfaces.ItemOrderSenderMapper;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.LogisticsBO;
import com.shigu.main4.order.bo.PackageBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.order.exceptions.ItemCartNumOutOfBoundsException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.order.vo.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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


    /**
     * 订单确认提交
     * @param bo
     */
    @Transactional(rollbackFor = Exception.class)
    public Long submit(ConfirmBO bo) throws JsonErrException {
        if (bo == null || Strings.isNullOrEmpty(bo.getCode())) {
            throw new JsonErrException("传入信息不完整");
        }
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code,OrderSubmitVo.class);
        if (orderSubmitVo == null || orderSubmitVo.getProducts().size() == 0) {
            throw new JsonErrException("没有找到产品信息");
        }
        ItemOrderBO itemOrderBO  = generateItemOrderBO(bo, orderSubmitVo);
        Long oid = itemOrderService.createOrder(itemOrderBO);
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
        LogisticsBO logisticsBO = new LogisticsBO();
        logisticsBO.setCompanyId(bo.getCourierId());
        logisticsBO.setAddressId(bo.getAddressId());
        itemOrderBO.setLogistics(logisticsBO);
        //订单子订单信息，将ConfirmBo中 ConfirmSubOrderBO#id与OrderSubmitVo中CartVO#cartId对应，存入ItemOrderBO#subOrders中
        List<SubItemOrderBO> subOrders = Lists.newArrayList();
        Map<Long, CartVO> productsMap = BeanMapper.list2Map(orderSubmitVo.getProducts(),"cartId", Long.class);
        List<ConfirmOrderBO> confirmOrderBOS = bo.getOrders();
        for (ConfirmOrderBO confirmOrderBO: confirmOrderBOS) {
            List<ConfirmSubOrderBO> confirmSubOrderBOS = confirmOrderBO.getChildOrders();
            for (ConfirmSubOrderBO confirmSubOrderBO: confirmSubOrderBOS) {
                int num = confirmSubOrderBO.getNum();
                if (num <= 0) {
                    continue;
                }
                SubItemOrderBO subOrder = new SubItemOrderBO();
                subOrder.setMark(confirmOrderBO.getRemark());
                subOrder.setNum(num);
                subOrder.setProductVO(productsMap.get(Long.parseLong(confirmSubOrderBO.getId())));
                subOrders.add(subOrder);
            }
        }
        itemOrderBO.setSubOrders(subOrders);
        itemOrderBO.setTitle(itemOrderBO.getSubOrders().get(0).getProductVO().getTitle());
        itemOrderBO.setWebSite(itemOrderBO.getSubOrders().get(0).getProductVO().getWebSite());
        itemOrderBO.setMark(bo.getOrders().get(0).getRemark());

        itemOrderBO.setServiceIds(BeanMapper.getFieldList(orderConstantService.selServices(bo.getSenderId()), "id", Long.class));

        //TODO:订单包材信息
        int size = BeanMapper.groupBy(orderSubmitVo.getProducts(), "shopId", Long.class).size();
        List<Long> packagesIds = BeanMapper.getFieldList(orderConstantService.selMetarials(bo.getSenderId()), "id", Long.class);
        List<PackageBO> packageBOS = Lists.newArrayList();
        for (Long packagesId : packagesIds) {
            PackageBO packageBO = new PackageBO();
            packageBOS.add(packageBO);
            packageBO.setMetarialId(packagesId);
            packageBO.setNum(size);
        }
        itemOrderBO.setPackages(packageBOS);
        return itemOrderBO;
    }

    /**
     * 根据订单对象信息移除购物车中的记录
     * @param itemOrderBO
     */
    private void rmCartProductByOrder(ItemOrderBO itemOrderBO) throws JsonErrException {
        //根据用户获取购物车对象
        Cart cart = SpringBeanFactory.getBean(ItemCartImpl.class, itemOrderBO.getUserId());
        for (SubItemOrderBO subItemOrderBO: itemOrderBO.getSubOrders()) {
            ItemProductVO productVO = subItemOrderBO.getProductVO();
            try {
                cart.rmProductByNum(productVO.getPid(), productVO.getSelectiveSku().getSkuId(), subItemOrderBO.getNum());
            } catch (ItemCartNumOutOfBoundsException e) {
                throw new JsonErrException(e.getMessage());
            }
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
     * 快递公司拼音到字映射
     */
    public Map<String, String> postNameMapper() {
        Map<String, String> postNameMap = new HashMap<>();
        List<ExpressCompany> select = expressCompanyMapper.select(new ExpressCompany());
        for (ExpressCompany company : select) {
            postNameMap.put(company.getEnName(), company.getExpressName());
        }
        return postNameMap;
    }

    /**
     * 服务规则包装，待完善
     * @param orders 订单商品信息
     * @param senderId 发货机构
     * @return 服务对应表
     */
    public List<ServiceRuleVO> serviceRulePack(List<CartOrderVO> orders, Long senderId) {
        List<ServiceVO> serviceRulers = orderConstantService.selServices(senderId);//服务费规则
        List<ServiceRuleVO> serviceRuleVOS = new ArrayList<>(orders.size());
        for (CartOrderVO orderVO : orders) {
            ServiceRuleVO ruleVO = new ServiceRuleVO();
            serviceRuleVOS.add(ruleVO);
            ruleVO.setOrderId(orderVO.getShopId());
            ruleVO.setSenderId(senderId);
            ruleVO.setServices(new ArrayList<ServiceInfoVO>());
            for (ServiceVO serviceRuler : serviceRulers) {
                ServiceInfoVO infoVO = new ServiceInfoVO();
                infoVO.setText(serviceRuler.getName());
                infoVO.setPrice(serviceRuler.getPrice() * .01);
                ruleVO.getServices().add(infoVO);
            }
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
        BuyerAddressVO vo = redisIO.get("tmp_buyer_address_" + addressId, BuyerAddressVO.class);
        return vo;
    }
}
