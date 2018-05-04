package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.MyOrderVO;
import com.shigu.seller.vo.DfGoodsVo;
import com.shigu.seller.vo.DfOrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderMapper extends Mapper<ItemOrder> {
    /**
     * 查询售后信息
     * @param userId 必传
     * @param typeList 查询售后状态列表，必须有值，售后值为：2 退货，3 换货
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<MyOrderVO> selectShOrderList(@Param("userId") Long userId, @Param("typeList") List<Integer> typeList, @Param("startIndex") Integer startIndex,@Param("endIndex") Integer endIndex);

    /**
     * 查询订单信息
     * @param userId 必传
     * @param bo 非空
     * @param startIndex
     * @param endIndex
     * @return
     */
    List<MyOrderVO> selectMyOrderList(@Param("userId") Long userId, @Param("bo") OrderBO bo,@Param("startIndex") Integer startIndex,@Param("endIndex") Integer endIndex);

    List<DfOrderVo> getDropShippingOrder(@Param("shopId") Long shopId,@Param("oId") Long oId,@Param("goodsNo") String goodsNo);

    List<DfGoodsVo> getDropShippingGoods(@Param("shopId") Long shopId, @Param("goodsNo") String goodsNo);
}
