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

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
    }

    /**
     * 根据发货机构id构造
     * @param senderId 发货机构id
     * @param placeholder 占位参数，无意义
     */
    public LogisticsTemplateImpl(Long senderId, String placeholder) {
        this.senderId = senderId;
    }

    @PostConstruct
    public void init() throws LogisticsRuleException {
        if (this.templateId != null) {
            this.senderId = templateInfo().getSenderId();
        } else if (senderId != null){
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
                senderId = -1L;
            } else {
                logisticsTemplate = logisticsTemplates.get(0);
                templateId = logisticsTemplate.getTemplateId();
            }
        } else {
            throw new LogisticsRuleException("处始化失败，入参 templateId,senderId 为Null");
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
     * 1. 当 provId 和 companyId 皆不为 Null 时，该方法返回 指定省份的快递公司的所有邮费计算规则
     * 2. 当 provId 和 companyId 皆为 Null 时，该方法返回 本 template 所有邮费计算规则
     *
     * @param provId    省份id  3.当此参数为Null时，方法将返回指定 companyId 的所有省份规则
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
            supportRules.addAll(logisticsTemplateProvMapper.selectByExample(provExample).stream().map(LogisticsTemplateProv::getRuleId).collect(Collectors.toList()));
        } else {// 省份id为NULL 则构建省份-规则映射信息
            LogisticsTemplateProv prov = new LogisticsTemplateProv();
            prov.setTemplateId(templateId);
            ruleProvMap = logisticsTemplateProvMapper.select(prov).stream().collect(Collectors.toMap(LogisticsTemplateProv::getRuleId, r -> r));
        }
        if (companyId != null) {
            LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
            companyExample.createCriteria().andCompanyIdEqualTo(companyId).andTemplateIdEqualTo(templateId);
            List<Long> companyRulesIds = logisticsTemplateCompanyMapper.selectByExample(companyExample).stream().map(LogisticsTemplateCompany::getRuleId).collect(Collectors.toList());
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
                infoVO.setCompanyId(company.getCompanyId());
            } else {
                infoVO.setCompanyId(companyId);
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
        LogisticsTemplateRuleExample ruleExample = new LogisticsTemplateRuleExample();
        LogisticsTemplateRuleExample.Criteria criteria = ruleExample.createCriteria().andTemplateIdEqualTo(templateId);
        if (!rulesIds.isEmpty()) {
            criteria.andRuleIdIn(rulesIds);
        }
        ruleExample.or().andImDefaultEqualTo(true);
        return logisticsTemplateRuleMapper.selectByExample(ruleExample).stream().map(templateRule -> {
            BournRuleInfoVO infoVO = new BournRuleInfoVO();
            infoVO.setRuleId(templateRule.getRuleId());
            infoVO.setStartPrice(templateRule.getFirstFee());
            infoVO.setStartWeight(templateRule.getFirstUnit());
            infoVO.setAddPrice(templateRule.getPerFee());
            infoVO.setAddWeight(templateRule.getPerUnit());
            infoVO.setImDefault(templateRule.getImDefault());
            infoVO.setType(templateRule.getType());
            return infoVO;
        }).collect(Collectors.toList());
    }

    @Override
    public LogisticsTemplateVO templateInfo() {
        return BeanMapper.map(logisticsTemplateMapper.selectByPrimaryKey(templateId), LogisticsTemplateVO.class);
    }


    /**
     * 按省份查快递公司
     *
     * @param provId 省份id
     * @return 快递公司列表
     */
    @Override
    public List<LogisticsCompanyVO> provCompanys(Long provId) {
        List<LogisticsCompanyVO> voList = new ArrayList<>();
        LogisticsTemplateProvExample provExample = new LogisticsTemplateProvExample();
        provExample.createCriteria().andTemplateIdEqualTo(templateId).andProvIdEqualTo(provId);
        List<LogisticsTemplateProv> logisticsTemplateProvs = logisticsTemplateProvMapper.selectFieldsByExample(provExample, FieldUtil.codeFields("tp_id,rule_id"));

        List<Long> ruleIds = logisticsTemplateProvs.stream().map(LogisticsTemplateProv::getRuleId).collect(Collectors.toList());

        LogisticsTemplateRuleExample logisticsTemplateRuleExample = new LogisticsTemplateRuleExample();
        logisticsTemplateRuleExample.createCriteria().andImDefaultEqualTo(true);
        List<LogisticsTemplateRule> logisticsTemplateRules = logisticsTemplateRuleMapper.selectFieldsByExample(logisticsTemplateRuleExample, "rule_id");
        List<Long> ruleIdsDefault = logisticsTemplateRules.stream().map(LogisticsTemplateRule::getRuleId).collect(Collectors.toList());
        ruleIds.addAll(ruleIdsDefault);
        LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId).andRuleIdIn(ruleIds);
        List<LogisticsTemplateCompany> companies = logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("tc_id,company_id"));
        if (!companies.isEmpty()) {

            List<Long> companyIds = BeanMapper.getFieldList(companies, "companyId", Long.class);
            ExpressCompanyExample expressCompanyExample = new ExpressCompanyExample();
            expressCompanyExample.createCriteria().andExpressCompanyIdIn(companyIds);
            List<ExpressCompany> expressCompanies = expressCompanyMapper.selectFieldsByExample(expressCompanyExample, FieldUtil.codeFields("express_company_id,express_name"));

            for (ExpressCompany e : expressCompanies) {
                LogisticsCompanyVO vo = new LogisticsCompanyVO();
                vo.setName(e.getExpressName());
                vo.setId(e.getExpressCompanyId());
                voList.add(vo);
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
