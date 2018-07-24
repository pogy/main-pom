package com.shigu.order.orderQuery;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderLogisticsExample;
import com.opentae.data.mall.examples.ItemOrderSubExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.MyOrderVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 类名：QueryByOrder
 * 类路径：com.shigu.order.orderQuery.QueryByOrder
 * 创建者：王浩翔
 * 创建时间：2017-09-28 14:19
 * 项目：main-pom
 * 描述：订单查询 userId必传,bo非空
 */
@Component
@Scope("prototype")
public class QueryByOrder extends OrderQuery {
    Long userId;
    OrderBO bo;

    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;
    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Autowired
    private MultipleMapper tae_mall_multipleMapper;

    QueryByOrder(Long userId, OrderBO bo) {
        this.userId = userId;
        this.bo = bo;
    }

    @Override
    protected ItemOrderServiceMapper getItemOrderServiceMapper() {
        return itemOrderServiceMapper;
    }

    @Override
    protected ItemOrderRefundMapper getItemOrderRefundMapper() {
        return itemOrderRefundMapper;
    }

    @Override
    public int selectCount() {
        ItemOrderExample itemOrderExample = new ItemOrderExample();
        ItemOrderSubExample itemOrderSubExample = new ItemOrderSubExample();
        ItemOrderLogisticsExample itemOrderLogisticsExample = new ItemOrderLogisticsExample();
        //订单查询条件
        ItemOrderExample.Criteria orderCriteria = itemOrderExample.createCriteria().andUserIdEqualTo(userId).andDisenableEqualTo(false);
        if (bo.getStatus() != null) {
            orderCriteria.andOrderStatusEqualTo(bo.getStatus());
        }
        if (bo.getSt() != null) {
            Date st = DateUtil.stringToDate(bo.getSt(), DateUtil.patternA);
            orderCriteria.andCreateTimeGreaterThanOrEqualTo(st);
        }
        if (bo.getEt() != null) {
            Date et = DateUtil.stringToDate(String.format("%s 23:59:59", bo.getEt()), DateUtil.patternD);
            orderCriteria.andCreateTimeLessThan(et);
        }
        if (bo.getOrderId() != null) {
            orderCriteria.andOidEqualTo(bo.getOrderId());
        }
        if (bo.getOrderType() != null) {
            if (bo.getOrderType() == 1) {
                orderCriteria.andTypeEqualTo(2);
            } else {
                orderCriteria.andTypeNotEqualTo(2);
            }
        }
        if (StringUtils.isNotBlank(bo.getGoodsNo())) {
            itemOrderSubExample.createCriteria().andGoodsNoLike('%'+bo.getGoodsNo()+'%');
        }
        ItemOrderLogisticsExample.Criteria logisticCriteria = itemOrderLogisticsExample.createCriteria();
        if (StringUtils.isNotBlank(bo.getTelePhone())) {
            logisticCriteria.andTelephoneEqualTo(bo.getTelePhone());
        }
        if (StringUtils.isNotBlank(bo.getReceiver())) {
            logisticCriteria.andNameEqualTo(bo.getReceiver());
        }
        MultipleExample multipleExample = MultipleExampleBuilder.from(itemOrderExample)
                .innerJoin(itemOrderLogisticsExample).on(itemOrderExample.createCriteria().equalTo(ItemOrderExample.oid, ItemOrderLogisticsExample.oid))
                .innerJoin(itemOrderSubExample).on(itemOrderExample.createCriteria().equalTo(ItemOrderExample.oid, ItemOrderSubExample.oid))
                .build();
        multipleExample.setDistinctCount(ItemOrderExample.oid);
        return tae_mall_multipleMapper.countByMultipleExample(multipleExample);
    }

    @Override
    public List<MyOrderVO> selectOrderList(Integer number, Integer size) {
        return itemOrderMapper.selectMyOrderList(userId,bo,(number-1)*size,size);
    }
}
