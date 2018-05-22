package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrder;
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
    int addRefundMoney(@Param("oid") Long oid, @Param("money") Long money);

    List<Long> getOidListByOrderStatus(@Param("userId") Long userId, @Param("createTime") Date createTime);
    List<Long> getRidListByOrderStatus(@Param("userId") Long userId,@Param("createTime") Date createTime);
}
