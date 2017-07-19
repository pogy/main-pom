package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;
import com.opentae.data.mall.beans.LogisticsTemplateProv;
import com.opentae.data.mall.examples.ExpressCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateProvExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
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

    public LogisticsTemplateImpl(Long templateId) {
        this.templateId = templateId;
    }

    private Long templateId;




    @Autowired
    private LogisticsTemplateCompanyMapper logisticsTemplateCompanyMapper;
    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;
    @Autowired
    private LogisticsTemplateProvMapper logisticsTemplateProvMapper;




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
        List<Long> ruleIds = BeanMapper.getFieldList(logisticsTemplateProvs, "ruleId", Long.class);
        LogisticsTemplateCompanyExample companyExample=new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companies = logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("tc_id,company_id"));
        List<Long> companyIds = BeanMapper.getFieldList(companies, "companyId", Long.class);
        ExpressCompanyExample expressCompanyExample=new ExpressCompanyExample();
        expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
        List<ExpressCompany> expressCompanies = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, FieldUtil.codeFields("express_company_id,express_name"));
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



    public Long getTemplateId() {
        return templateId;
    }
}
