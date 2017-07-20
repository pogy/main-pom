package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;
import com.opentae.data.mall.beans.LogisticsTemplateProv;
import com.opentae.data.mall.beans.LogisticsTemplateRule;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateProvExample;
import com.opentae.data.mall.examples.LogisticsTemplateRuleExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 快递模板
 * Created by bugzy on 2017/7/19 0019.
 */
@Service("logisticsTemplate")
@Scope("prototype")
public class LogisticsTemplateImpl implements LogisticsTemplate {
    public LogisticsTemplateImpl(Long templateId) {
        this.templateId = templateId;
    }

    private Long templateId;


    @Autowired
    private LogisticsTemplateMapper logisticsTemplateMapper;

    @Autowired
    private LogisticsTemplateProvMapper logisticsTemplateProvMapper;

    @Autowired
    private LogisticsTemplateCompanyMapper logisticsTemplateCompanyMapper;

    @Autowired
    private LogisticsTemplateRuleMapper logisticsTemplateRuleMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;


    /**
     * 查快递规则
     *
     * @param provId
     * @param companyId
     * @return
     */
    @Override
    public List<BournRuleInfoVO> rules(Long provId, Long companyId) {
        LogisticsTemplateProvExample provExample = new LogisticsTemplateProvExample();
        provExample.createCriteria().andProvIdEqualTo(provId).andTemplateIdEqualTo(templateId);
        List<Long> supportRules = BeanMapper.getFieldList(logisticsTemplateProvMapper.selectByExample(provExample), "ruleId", Long.class);

        LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andCompanyIdEqualTo(companyId).andTemplateIdEqualTo(templateId);
        supportRules.retainAll(BeanMapper.getFieldList(logisticsTemplateCompanyMapper.selectByExample(companyExample), "ruleId", Long.class));

        List<BournRuleInfoVO> ruleInfo = new ArrayList<>(supportRules.size());
        if (!supportRules.isEmpty()) {
            LogisticsTemplateRuleExample ruleExample = new LogisticsTemplateRuleExample();
            ruleExample.createCriteria().andRuleIdIn(supportRules);
            for (LogisticsTemplateRule templateRule : logisticsTemplateRuleMapper.selectByExample(ruleExample)) {
                BournRuleInfoVO infoVO = new BournRuleInfoVO();
                ruleInfo.add(infoVO);
                infoVO.setStartPrice(templateRule.getFirstFee());
                infoVO.setStartWeight(templateRule.getFirstUnit());
                infoVO.setAddPrice(templateRule.getPerFee());
                infoVO.setAddWeight(templateRule.getPerUnit());
                infoVO.setImDefault(templateRule.getImDefault());
                infoVO.setType(templateRule.getType());
                infoVO.setComponyId(companyId);
                infoVO.setProvId(provId);
            }
        }
        return ruleInfo;
    }


    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    @Override
    public LogisticsTemplateVO templateInfo() {
        return BeanMapper.map(logisticsTemplateMapper.selectByPrimaryKey(templateId), LogisticsTemplateVO.class);
    }


    /**
     * 按省份查快递公司
     *
     * @param provId
     * @return
     */
    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {
        List<LogisticsCompanyVO> voList = new ArrayList<>();
        LogisticsTemplateProvExample provExample = new LogisticsTemplateProvExample();
        provExample.createCriteria().andTemplateIdEqualTo(templateId).andProvIdEqualTo(provId);
        List<LogisticsTemplateProv> logisticsTemplateProvs = logisticsTemplateProvMapper.selectFieldsByExample(provExample, FieldUtil.codeFields("tp_id,rule_id"));
        List<Long> ruleIds = null;
        if (logisticsTemplateProvs.size() > 0) {
            ruleIds = BeanMapper.getFieldList(logisticsTemplateProvs, "ruleId", Long.class);
        }else {
            ruleIds = new ArrayList<>();
        }
        LogisticsTemplateRuleExample logisticsTemplateRuleExample = new LogisticsTemplateRuleExample();
        logisticsTemplateRuleExample.createCriteria().andImDefaultEqualTo(true);
        List<LogisticsTemplateRule> logisticsTemplateRules = logisticsTemplateRuleMapper.selectFieldsByExample(logisticsTemplateRuleExample, "rule_id");
        List<Long> ruleIdsDefault = BeanMapper.getFieldList(logisticsTemplateRules, "ruleId", Long.class);
        ruleIds.addAll(ruleIdsDefault);
        LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companies = logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("tc_id,company_id"));
        if (companies.size() > 0) {

            List<Long> companyIds = BeanMapper.getFieldList(companies, "companyId", Long.class);
            ExpressCompanyExample expressCompanyExample = new ExpressCompanyExample();
            expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
            List<ExpressCompany> expressCompanies = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, FieldUtil.codeFields("express_company_id,express_name"));
            if (expressCompanies.size() > 0) {

                List<String> expressNames = BeanMapper.getFieldList(expressCompanies, "expressName", String.class);

                for (String e : expressNames) {
                    LogisticsCompanyVO vo = new LogisticsCompanyVO();
                    vo.setName(e);
                    voList.add(vo);
                }

            }
        }
        return voList;
    }

    /**
     * 计费
     * @param provId 省份ID
     * @param goodsNumber 商品数
     * @param weight 重量,克为单位
     * @return
     */
    @Override
    public Long calculate(Long provId, Long companyId, Integer goodsNumber, Long weight) throws LogisticsRuleException {
        // 包邮？
        LogisticsTemplateVO logisticsTemplateVO = templateInfo();
        if (logisticsTemplateVO.getFree()) {
            return 0L;
        }

        // 算钱
        List<BournRuleInfoVO> rules = rules(provId, companyId);
        BournRuleInfoVO vo = null;
        if (rules.size() == 1) {
            vo = rules.get(0);
        } else {
            for (BournRuleInfoVO rule : rules) {
                if (!rule.getImDefault()) {
                    vo = rule;
                    break;
                }
            }
        }
        if (vo == null) {
            throw new LogisticsRuleException(String.format("无默认快递规则; provId[%d],companyId[%d]", provId, companyId));
        }
        Long unit = vo.getType() == 1 ? goodsNumber.longValue() : vo.getType() == 2 ? weight : 0; // 计费单元
        Long add = vo.getAddWeight() == 0 ? 0L  // Double数除以0会发生奇怪的事情、比如取到极值，比如取到 NaN
                : ((Double)((unit - vo.getStartWeight()) * (vo.getAddPrice() * 1.0 / vo.getAddWeight()))).longValue();

        return vo.getStartPrice() + (add > 0 ? add : 0);
    }
}
