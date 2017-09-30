package com.shigu.order.orderQuery;

import com.google.common.collect.Lists;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.examples.ItemOrderRefundExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderServiceMapper;
import com.shigu.order.vo.MyOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类名：QueryByShManaOrder
 * 类路径：com.shigu.order.orderQuery.QueryByShManaOrder
 * 创建者：王浩翔
 * 创建时间：2017-09-28 14:21
 * 项目：main-pom
 * 描述：售后查询 userId必传
 */
@Component
@Scope("prototype")
public class QueryByShManaOrder extends OrderQuery {
    Long userId;
    Integer shStatus;
    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Autowired
    private ItemOrderServiceMapper itemOrderServiceMapper;
    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;
    @Autowired
    private MultipleMapper tae_mall_multipleMapper;

    public QueryByShManaOrder(Long userId, Integer shStatus) {
        this.userId = userId;
        this.shStatus = shStatus;
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
        ItemOrderRefundExample refundExample = new ItemOrderRefundExample();
        ItemOrderExample itemOrderExample = new ItemOrderExample();
        itemOrderExample.createCriteria().andUserIdEqualTo(userId).andDisenableEqualTo(false);
        //查询售后只查询已发货的，typeList一定有值
        List<Integer> typeList = getTypeList();
        refundExample.createCriteria().andRefundIdIsNotNull().andTypeIn(typeList);
        MultipleExample multipleExample = MultipleExampleBuilder.from(itemOrderExample)
                .innerJoin(refundExample).on(itemOrderExample.createCriteria().equalTo(ItemOrderExample.oid, ItemOrderRefundExample.oid))
                .build();
        multipleExample.setDistinctCount(ItemOrderExample.oid);
        return tae_mall_multipleMapper.countByMultipleExample(multipleExample);
    }

    @Override
    public List<MyOrderVO> selectOrderList(Integer number, Integer size) {
        return itemOrderMapper.selectShOrderList(userId, getTypeList(), (number - 1) * size, size);
    }

    /**
     * 根据分类查询条件返回对应状态表
     *
     * @return 不进行区分返回null
     */
    private List<Integer> getTypeList() {
        if (shStatus != null) {
            if (shStatus == 1) {
                return Lists.newArrayList(2);
            }
            if (shStatus == 2) {
                return Lists.newArrayList(3);
            }
        }
        return Lists.newArrayList(2,3);
    }
}
