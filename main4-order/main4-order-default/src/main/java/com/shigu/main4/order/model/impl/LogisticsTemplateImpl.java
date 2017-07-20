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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 快递模板
 * Created by bugzy on 2017/7/19 0019.
 */
@Component("logisticsTemplate")
@Scope("prototype")
public class LogisticsTemplateImpl implements LogisticsTemplate {

    private Long templateId;

    private static Long defaultTemplateId;

    private Long senderId;

    public LogisticsTemplateImpl(Long templateId) {
        this.templateId = templateId;
        this.senderId = templateInfo().getSenderId();
    }

    /**
     * 根据发货机构id构造
     * @param senderId 发货机构id
     * @param placeholder 占位参数，无意义
     */
    public LogisticsTemplateImpl(Long senderId, String placeholder) {
        this.senderId = senderId;
        com.opentae.data.mall.beans.LogisticsTemplate logisticsTemplate = new com.opentae.data.mall.beans.LogisticsTemplate();
        logisticsTemplate.setSenderId(senderId);
        logisticsTemplate.setEnabled(true);
        List<com.opentae.data.mall.beans.LogisticsTemplate> logisticsTemplates = logisticsTemplateMapper.select(logisticsTemplate);
        if (logisticsTemplates.isEmpty()) { // 没有所选发货机构则采用 系统默认运费模板
            if (defaultTemplateId == null) {
                logisticsTemplate.setSenderId(-1L);
                logisticsTemplate = logisticsTemplateMapper.selectOne(logisticsTemplate);
                defaultTemplateId = logisticsTemplate.getTemplateId();
            }
            templateId = defaultTemplateId;
            this.senderId = -1L;
        } else {
            logisticsTemplate = logisticsTemplates.get(0);
            templateId = logisticsTemplate.getTemplateId();
        }
    }

    public Long getTemplateId() {
        return templateId;
    }

    public Long getSenderId() {
        return senderId;
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
     *      1. 当 provId 和 companyId 皆不为 Null 时，该方法返回 指定省份的快递公司的所有邮费计算规则
     *      2. 当 provId 和 companyId 皆为 Null 时，该方法返回 本 template 所有邮费计算规则
     *
     * @param provId 省份id  3.当此参数为Null时，方法将返回指定 companyId 的所有省份规则
     * @param companyId 公司id  4.当此参数为Null时，方法将返回指定 provId 的所有公司规则
     * @return 规则列表
     */
    @Override
    public List<BournRuleInfoVO> rules(Long provId, Long companyId) throws LogisticsRuleException {
        List<Long> supportRules = new ArrayList<>();// 规则id列表
        Map<Long, LogisticsTemplateProv> ruleProvMap = Collections.emptyMap();// 规则 - 省份映射
        Map<Long, LogisticsTemplateCompany> ruleCompanyMap = Collections.emptyMap();// 规则 - 公司映射

        if (provId != null) {
            LogisticsTemplateProvExample provExample = new LogisticsTemplateProvExample();
            provExample.createCriteria().andProvIdEqualTo(provId).andTemplateIdEqualTo(templateId);
            supportRules.addAll(BeanMapper.getFieldList(logisticsTemplateProvMapper.selectByExample(provExample), "ruleId", Long.class));
        } else {// 省份id为NULL 则构建省份-规则映射信息
            LogisticsTemplateProv prov = new LogisticsTemplateProv();
            prov.setTemplateId(templateId);
            ruleProvMap = BeanMapper.list2Map(logisticsTemplateProvMapper.select(prov), "ruleId", Long.class);
        }
        if (companyId != null) {
            LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
            companyExample.createCriteria().andCompanyIdEqualTo(companyId).andTemplateIdEqualTo(templateId);
            List<Long> companyRulesIds = BeanMapper.getFieldList(logisticsTemplateCompanyMapper.selectByExample(companyExample), "ruleId", Long.class);
            if (provId == null) {
                supportRules.addAll(companyRulesIds);
            } else {// 当指定了省份、快递公司后，取规则交集就是该快递公司在该省份的运费计算规则
                supportRules.retainAll(companyRulesIds);
            }
        } else {// 快递公司id为null，则构建快递公司-规则映射信息
            LogisticsTemplateCompany company = new LogisticsTemplateCompany();
            company.setTemplateId(templateId);
            ruleCompanyMap = BeanMapper.list2Map(logisticsTemplateCompanyMapper.select(company), "ruleId", Long.class);
        }

        // 根据规则id集合查询运费规则并包装返回值，公司省份id预留给下一步处理。
        //  其中  supportRules 可能为空，这标志着 省id和公司id全部为null，将返回该 template 下所有规则；如果某项id不为null，这标志
        //  着快递规则设置存在漏洞(或传参错误)，应当检查数据，所有依赖此方法的逻辑将收到异常而不能继续向下执行
        if ((provId != null || companyId != null) && supportRules.isEmpty()) {
            throw new LogisticsRuleException(String.format("运费规则数据异常! prov[%d] 或 company[%d] 下没有有效的运费规则", provId, companyId));
        }
        List<BournRuleInfoVO> bournRuleInfoVOS = rulesIn(supportRules);

        for (BournRuleInfoVO infoVO : bournRuleInfoVOS) {
            LogisticsTemplateCompany company;
            if (companyId == null && (company = ruleCompanyMap.get(infoVO.getRuleId())) != null) {
                infoVO.setComponyId(company.getCompanyId());
            } else {
                infoVO.setComponyId(companyId);
            }
            LogisticsTemplateProv prov;
            if (provId == null && (prov = ruleProvMap.get(infoVO.getRuleId())) != null) {
                infoVO.setProvId(prov.getProvId());
            } else {
                infoVO.setProvId(provId);
            }
        }
        return bournRuleInfoVOS;
    }

    private List<BournRuleInfoVO> rulesIn(List<Long> rulesIds) {
        List<BournRuleInfoVO> ruleInfo = new ArrayList<>();
        LogisticsTemplateRuleExample ruleExample = new LogisticsTemplateRuleExample();
        LogisticsTemplateRuleExample.Criteria criteria = ruleExample.createCriteria().andTemplateIdEqualTo(templateId);
        if (!rulesIds.isEmpty()) {
            criteria.andRuleIdIn(rulesIds);
        }
        for (LogisticsTemplateRule templateRule : logisticsTemplateRuleMapper.selectByExample(ruleExample)) {
            BournRuleInfoVO infoVO = new BournRuleInfoVO();
            ruleInfo.add(infoVO);
            infoVO.setRuleId(templateRule.getRuleId());
            infoVO.setStartPrice(templateRule.getFirstFee());
            infoVO.setStartWeight(templateRule.getFirstUnit());
            infoVO.setAddPrice(templateRule.getPerFee());
            infoVO.setAddWeight(templateRule.getPerUnit());
            infoVO.setImDefault(templateRule.getImDefault());
            infoVO.setType(templateRule.getType());
        }
        return ruleInfo;
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

        /////////////TODO: 1. ruleIds 依然有 empty 的机会，导致 sql in 查询失败 2.BeanMapper.getFieldList 方法默认会返回空 ArrayList, 此种处理多此一举
        List<Long> ruleIds = null;
        if (logisticsTemplateProvs.size() > 0) {
            ruleIds = BeanMapper.getFieldList(logisticsTemplateProvs, "ruleId", Long.class);
        }else {
            ruleIds = new ArrayList<>();
        }
        ////////////

        LogisticsTemplateRuleExample logisticsTemplateRuleExample = new LogisticsTemplateRuleExample();
        logisticsTemplateRuleExample.createCriteria().andImDefaultEqualTo(true);
        List<LogisticsTemplateRule> logisticsTemplateRules = logisticsTemplateRuleMapper.selectFieldsByExample(logisticsTemplateRuleExample, "rule_id");
        List<Long> ruleIdsDefault = BeanMapper.getFieldList(logisticsTemplateRules, "ruleId", Long.class);
        ruleIds.addAll(ruleIdsDefault);//TODO: 从业务上讲 ruleIds 经过此行不可能会空，所以 in 查询没机会失败，不需要做 isEmpty 判断。但是ruleIds 以上处理依然多余
        LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companies = logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("tc_id,company_id"));
        if (companies.size() > 0) {

            List<Long> companyIds = BeanMapper.getFieldList(companies, "companyId", Long.class);
            ExpressCompanyExample expressCompanyExample = new ExpressCompanyExample();
            expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
            List<ExpressCompany> expressCompanies = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, FieldUtil.codeFields("express_company_id,express_name"));
            if (expressCompanies.size() > 0) {// TODO: 多余的判断

                List<String> expressNames = BeanMapper.getFieldList(expressCompanies, "expressName", String.class);

                for (String e : expressNames) {
                    LogisticsCompanyVO vo = new LogisticsCompanyVO();
                    vo.setName(e);
                    voList.add(vo);
                }

            }
>>>>>>>>> Temporary merge branch 2
        }
        return voList;
    }


    @Override
    public Long calculate(Long provId, Integer goodsNumber, Long weight) {
        return null;
    }
}
