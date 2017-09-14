package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrder;
import com.shigu.order.bo.OrderBO;
import com.shigu.order.vo.MyOrderVO;
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

    List<MyOrderVO> selectMyOrderList(@Param("userId") Long userId, @Param("bo")OrderBO bo,@Param("startIndex") Integer startIndex,@Param("endIndex") Integer endIndex);
}
