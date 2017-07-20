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

    private Long templateId;

    public Long getTemplateId() {
        return templateId;
    }

    public LogisticsTemplateImpl(Long templateId) {
        this.templateId = templateId;
    }

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
                infoVO.setComponyId(companyId);
                infoVO.setProvId(provId);
            }
        }
        return ruleInfo;
    }

    @Override
    public LogisticsTemplateVO templateInfo() {
        return null;
    }


    /**
     * 按省份查快递公司
     * @param provId
     * @return
     */
    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {

        LogisticsTemplateProvExample provExample=new LogisticsTemplateProvExample();
        provExample.createCriteria().andTemplateIdEqualTo(templateId).andProvIdEqualTo(provId);
        List<LogisticsTemplateProv> logisticsTemplateProvs = logisticsTemplateProvMapper.selectFieldsByExample(provExample, FieldUtil.codeFields("tp_id,rule_id"));
        if (logisticsTemplateProvs.size()<=0){
            return null;
        }
        List<Long> ruleIds = BeanMapper.getFieldList(logisticsTemplateProvs, "ruleId", Long.class);
        LogisticsTemplateCompanyExample companyExample=new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companies = logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("tc_id,company_id"));
        if (companies.size()<=0){
            return null;
        }
        List<Long> companyIds = BeanMapper.getFieldList(companies, "companyId", Long.class);
        ExpressCompanyExample expressCompanyExample=new ExpressCompanyExample();
        expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
        List<ExpressCompany> expressCompanies = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, FieldUtil.codeFields("express_company_id,express_name"));
        if (expressCompanies.size()<=0){
            return null;
        }
        List<String> expressNames = BeanMapper.getFieldList(expressCompanies, "expressName", String.class);
        List<LogisticsCompanyVO> voList=new ArrayList<>();
        for (String e:expressNames){
            LogisticsCompanyVO vo=new LogisticsCompanyVO();
            vo.setName(e);
            voList.add(vo);
        }
        return voList;
    }



    @Override
    public Long calculate(Long provId, Integer goodsNumber, Long weight) {
        return null;
    }
}
