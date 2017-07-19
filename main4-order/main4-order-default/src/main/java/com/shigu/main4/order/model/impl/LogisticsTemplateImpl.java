package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;

import java.util.List;

/**
 * Created by zhaohongbo on 17/7/19.
 */
public class LogisticsTemplateImpl implements LogisticsTemplate{

    private Long templateId;


    @Override
    public LogisticsTemplateVO templateInfo() {
        return null;
    }

    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {
        return null;
    }

    @Override
    public List<BournRuleInfoVO> rules(Long provId, Long companyId) {
        return null;
    }

    @Override
    public Long calculate(Long provId, Integer goodsNumber, Long weight) {
        return null;
    }
}
