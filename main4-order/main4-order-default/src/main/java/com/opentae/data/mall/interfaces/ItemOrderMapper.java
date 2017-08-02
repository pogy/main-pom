package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderMapper extends Mapper<ItemOrder> {

    List<Long> selShOidsByUserId(@Param("userId") Long userId, @Param("shStatus") Integer shStatus, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    int selShOrderCount(@Param("userId") Long userId, @Param("shStatus") Integer shStatus);

    List<Long> selOidsByBo(@Param("userId") Long userId, @Param("orderId") Long orderId, @Param("status") Integer status, @Param("st") Date st, @Param("et") Date et,
                           @Param("goodsNo") String goodsNo, @Param("receiver") String receiver, @Param("telephone") String telephone, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    int selOidsCountByBo(@Param("userId") Long userId, @Param("orderId") Long orderId, @Param("status") Integer status, @Param("st") Date st, @Param("et") Date et,
                         @Param("goodsNo") String goodsNo, @Param("receiver") String receiver, @Param("telephone") String telephone);
}
