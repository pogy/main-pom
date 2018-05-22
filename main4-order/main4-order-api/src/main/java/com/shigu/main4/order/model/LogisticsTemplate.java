package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.vo.*;

import java.util.List;

/**
 * 物流模板接口
 * Created by zhaohongbo on 17/7/19.
 */
public interface LogisticsTemplate {
    /**
     * 查询物流模板信息
     * @return
     */
    LogisticsTemplateVO templateInfo();

    /**
     * 取有效的物流规则
     * @param provId
     * @param companyId
     * @return
     * @throws LogisticsRuleException
     */
    List<BournRuleInfoVO> rule(Long provId,Long companyId) throws LogisticsRuleException;

    /**
     * 计费
     * @param provId 省份ID
     * @param goodsNumber 商品数
     * @param weight 重量,克为单位
     * @return
     */
    @Deprecated
    Long calculate(Long provId,Long companyId,Integer goodsNumber,Long weight) throws LogisticsRuleException;

    Long calculate(Long userId,Long oid,Long provId,Long companyId,Integer goodsNumber,Long weight,Boolean discounts) throws LogisticsRuleException;
    /**
     * 获取快递公司信息
     * @param provId    省份id
     * @param senderId  发货方式id
     * @return
     */
    List<PostVO> getPostListByProvId (Long provId, Long senderId) throws LogisticsRuleException;

    /**
     * 默认快递信息
     * @return
     * @throws LogisticsRuleException
     */
    List<PostVO> defaultPost() throws LogisticsRuleException;

}
