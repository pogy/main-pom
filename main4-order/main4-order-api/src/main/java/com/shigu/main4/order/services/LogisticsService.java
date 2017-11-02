package com.shigu.main4.order.services;

import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsShipVo;
import com.shigu.main4.order.vo.OtherCostVO;
import com.shigu.main4.order.vo.PostVO;

import java.util.List;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public interface LogisticsService {

    /**
     * 根据退款编号 查询物流信息
     * @param refundId 售后编号
     * @return 快递信息
     */
    LogisticsShipVo logisticsInfo(Long refundId);

    /**
     * 根据发件单位取物流规则
     * @param senderId
     * @param provId
     * @return
     */
    List<BournRuleInfoVO> selRulesByProvId(Long senderId,Long provId) throws LogisticsRuleException;

    /**
     * 获取快递公司信息
     * @param provId    省份id
     * @param senderId  发货方式id
     * @return
     */
    List<PostVO> getPostListByProvId (Long provId, Long senderId) throws LogisticsRuleException;

    /**
     * 计费
     * @param provId 省份ID
     * @param goodsNumber 商品数
     * @param weight 重量,克为单位
     * @return
     */
    Long calculate(Long provId, Long companyId, Integer goodsNumber, Long weight,Long senderId) throws LogisticsRuleException;

}
