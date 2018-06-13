package com.opentae.data.mall.interfaces;

import com.opentae.core.mybatis.config.MyBatisRepository;
import com.opentae.core.mybatis.mapper.Mapper;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.shigu.main4.order.vo.OrderSubMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.List;

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

    /**
     * 查询主订单下所有的子单商品价格
     * @param oid
     * @return
     */
    List<OrderSubMoney> selectOrderSubByOid(@Param("oid") Long oid);

    /**
     * 查询主订单下所有的退款价格
     * @param oid
     * @return
     */
    Long selectRefundByOid(@Param("oid") Long oid);

    Long selectUserIdByOid(@Param("oid") Long oid);
}
