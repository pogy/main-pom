package com.shigu.main4.order.model;

import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;

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
     * 查快递规则
     * @param provId
     * @return
     */
    List<BournRuleInfoVO> rulesByProv(Long provId) throws LogisticsRuleException;

    /**
     * 取有效的物流规则
     * @param provId
     * @param companyId
     * @return
     * @throws LogisticsRuleException
     */
    BournRuleInfoVO rule(Long provId,Long companyId) throws LogisticsRuleException;

    /**
     * 计费
     * @param provId 省份ID
     * @param goodsNumber 商品数
     * @param weight 重量,克为单位
     * @return
     */
    Long calculate(Long provId,Long companyId,Integer goodsNumber,Long weight) throws LogisticsRuleException;
}
