package com.shigu.order.services;

import com.google.common.collect.Lists;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.ItemOrderBO;
import com.shigu.main4.order.bo.LogisticsBO;
import com.shigu.main4.order.bo.PackageBO;
import com.shigu.main4.order.bo.SubItemOrderBO;
import com.shigu.main4.order.exceptions.ItemCartNumOutOfBoundsException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.model.impl.ItemCartImpl;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmOrderBO;
import com.shigu.order.bo.ConfirmSubOrderBO;
import com.shigu.order.vo.OrderSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 订单确认提交
     * @param bo
     */
    @Transactional(rollbackFor = Exception.class)
    public Long submit(ConfirmBO bo) throws Main4Exception {
        if (bo == null || bo.getOrders() == null || bo.getOrders().size() == 0 || bo.getCode() == null || bo.getSenderId() == null || bo.getAddressId() == null || bo.getCourierId() == null) {
            throw new Main4Exception("传入信息不完整");
        }
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code,OrderSubmitVo.class);
        if (orderSubmitVo == null || orderSubmitVo.getProducts().size() == 0) {
            throw new Main4Exception("没有找到产品信息");
        }
        ItemOrderBO itemOrderBO = generateItemOrderBO(bo, orderSubmitVo);
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
                SubItemOrderBO subOrder = new SubItemOrderBO();
                subOrder.setMark(confirmOrderBO.getRemark());
                subOrder.setNum(confirmSubOrderBO.getNum());
                subOrder.setProductVO(productsMap.get(Long.parseLong(confirmSubOrderBO.getId())));
                subOrders.add(subOrder);
            }
        }
        itemOrderBO.setSubOrders(subOrders);
        itemOrderBO.setTitle(itemOrderBO.getSubOrders().get(0).getProductVO().getTitle());
        itemOrderBO.setWebSite(itemOrderBO.getSubOrders().get(0).getProductVO().getWebSite());
        //TODO:订单mark信息
        itemOrderBO.setMark(bo.getOrders().get(0).getRemark());
        //TODO:订单服务信息，接口实现后添加
        itemOrderBO.setServiceIds(new ArrayList<Long>(0));
        //TODO:订单包材信息
        itemOrderBO.setPackages(new ArrayList<PackageBO>(0));
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
}
