package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.interfaces.LogisticsTemplateMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递模板
 * Created by bugzy on 2017/7/19 0019.
 */
@Service("logisticsTemplate")
@Scope("prototype")
public class LogisticsTemplateImpl implements LogisticsTemplate {

    private Long templateId;

    @Autowired
    private LogisticsTemplateMapper logisticsTemplateMapper;

    @Override
    public LogisticsTemplateVO templateInfo() {
        return BeanMapper.map(logisticsTemplateMapper.selectByPrimaryKey(templateId),LogisticsTemplateVO.class);
    }

    /**
     * 按省份查快递公司
     *
     * @param provId
     * @return
     */
    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {
        return null;
    }

    /**
     * 查快递规则
     *
     * @param provId
     * @param companyId
     * @return
     */
    @Override
    public List<BournRuleInfoVO> rules(Long provId, Long companyId) {
        return null;
    }

    /**
     * 计费
     *
     * @param provId      省份ID
     * @param goodsNumber 商品数
     * @param weight      重量,克为单位
     * @return
     */
    @Override
    public Long calculate(Long provId, Integer goodsNumber, Long weight) {
        return null;
    }
}
