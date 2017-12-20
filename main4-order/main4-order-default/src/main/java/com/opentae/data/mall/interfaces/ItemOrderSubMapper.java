package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrderSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 
 * Created by exampleCreater.
 */
@MyBatisRepository("tae_mall_itemOrderSubMapper")
@Scope("singleton")
@Lazy(true)
public interface ItemOrderSubMapper extends Mapper<ItemOrderSub> {
    /**
     * 更新子订单中的退款额
     * @param soid
     * @param money
     * @return
     */
    int addRefundMoney(@Param("soid") Long soid, @Param("money") Long money);
}
