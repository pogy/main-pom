package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;
import com.opentae.data.mall.beans.LogisticsTemplateProv;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateProvExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private LogisticsTemplateProvMapper logisticsTemplateProvMapper;

    @Autowired
    private LogisticsTemplateCompanyMapper logisticsTemplateCompanyMapper;

    @Autowired
    private LogisticsTemplateRuleMapper logisticsTemplateRuleMapper;




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
        logisticsTemplateProvMapper.selectByExample(provExample);
        return null;
    }


    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    @Autowired
    private LogisticsTemplateCompanyMapper companyMapper;
    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;
    @Autowired
    private LogisticsTemplateProvMapper provMapper;
    @Override
    public LogisticsTemplateVO templateInfo() {
        return null;
    }

    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {

        LogisticsTemplateProvExample provExample=new LogisticsTemplateProvExample();
        provExample.createCriteria().andTemplateIdEqualTo(templateId).andProvIdEqualTo(provId);
        List<LogisticsTemplateProv> ruleId = provMapper.selectFieldsByExample(provExample, "rule_id");
        List<Long> ruleIds=new ArrayList<>();
        for (LogisticsTemplateProv p:ruleId){
            ruleIds.add(p.getRuleId());
        }
        LogisticsTemplateCompanyExample companyExample=new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companyId = companyMapper.selectFieldsByExample(companyExample, "company_id");
        List<Long>companyIds=new ArrayList<>();
        for (LogisticsTemplateCompany c:companyId){
            companyIds.add(c.getCompanyId());
        }
        ExpressCompanyExample expressCompanyExample=new ExpressCompanyExample();
        expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
        List<ExpressCompany> expressName = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, "express_name");
        List<LogisticsCompanyVO> voList=new ArrayList<>();
        for (ExpressCompany e:expressName){
            LogisticsCompanyVO vo=new LogisticsCompanyVO();
            vo.setName(e.getExpressName());
            voList.add(vo);
        }
        return voList;
    }



    @Override
    public Long calculate(Long provId, Integer goodsNumber, Long weight) {
        return null;
    }

    public LogisticsTemplateImpl(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTemplateId() {
        return templateId;
    }
}
