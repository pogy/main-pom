package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;
import com.opentae.data.mall.beans.LogisticsTemplateRule;
import com.opentae.data.mall.examples.LogisticsTemplateCompanyExample;
import com.opentae.data.mall.examples.LogisticsTemplateProvExample;
import com.opentae.data.mall.examples.LogisticsTemplateRuleExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.vo.BournRuleInfoVO;
import com.shigu.main4.order.vo.RuleInfoVO;
import com.shigu.main4.order.vo.LogisticsTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
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

    @Autowired
    private MultipleMapper multipleMapper;

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


    @Override
    public LogisticsTemplateVO templateInfo() {
        return BeanMapper.map(logisticsTemplateMapper.selectByPrimaryKey(templateId), LogisticsTemplateVO.class);
    }

    @Override
    public List<BournRuleInfoVO> rulesByProv(Long provId) throws LogisticsRuleException {
        //查出本模板的所有物流
        LogisticsTemplateCompanyExample companyExample=new LogisticsTemplateCompanyExample();
        companyExample.createCriteria().andTemplateIdEqualTo(templateId);
        companyExample.setDistinct(true);
        List<LogisticsTemplateCompany> companies=logisticsTemplateCompanyMapper.selectFieldsByExample(companyExample, FieldUtil.codeFields("company_id"));
        List<Long> companyIds=companies.stream().map(LogisticsTemplateCompany::getCompanyId).collect(Collectors.toList());

        //查出省份对应的规则
        companyExample.clear();
        LogisticsTemplateProvExample provExample=new LogisticsTemplateProvExample();
        LogisticsTemplateRuleExample ruleExample=new LogisticsTemplateRuleExample();
        MultipleExample multipleExample= MultipleExampleBuilder.from(ruleExample)
                .innerJoin(companyExample).on(ruleExample.createCriteria().equalTo(LogisticsTemplateRuleExample.ruleId,LogisticsTemplateCompanyExample.ruleId))
                .innerJoin(provExample).on(companyExample.createCriteria().equalTo(LogisticsTemplateCompanyExample.ruleId,LogisticsTemplateProvExample.ruleId))
                .where(provExample.createCriteria().andProvIdEqualTo(provId).andTemplateIdEqualTo(templateId),companyExample.createCriteria()
                        .andTemplateIdEqualTo(templateId),ruleExample.createCriteria().andImDefaultEqualTo(false)).build();
        List<BournRuleInfoVO> rules=BeanMapper.mapList(multipleMapper.selectFieldsByMultipleExample(multipleExample,RuleInfoVO.class),BournRuleInfoVO.class);
        for(BournRuleInfoVO vo:rules){
            companyIds.remove(vo.getCompanyId());
        }
        //如果有遗漏
        if(companyIds.size()>0){
            //查出默认规则
            BournRuleInfoVO defaultRule=defaultRule();
            defaultRule.setProvId(provId);
            for(Long companyId:companyIds){
                BournRuleInfoVO comRule=BeanMapper.map(defaultRule,BournRuleInfoVO.class);
                comRule.setCompanyId(companyId);
                rules.add(comRule);
            }
        }
        return rules;
    }

    @Override
    public BournRuleInfoVO rule(Long provId, Long companyId) throws LogisticsRuleException {
        if(provId==null||companyId==null){
            throw new LogisticsRuleException("省份ID与物流公司ID是必要参数");
        }
        //先查出满足条件的规则，如果没有，取默认规则
        LogisticsTemplateCompanyExample companyExample=new LogisticsTemplateCompanyExample();
        LogisticsTemplateProvExample provExample=new LogisticsTemplateProvExample();
        LogisticsTemplateRuleExample ruleExample=new LogisticsTemplateRuleExample();
        MultipleExample multipleExample= MultipleExampleBuilder.from(ruleExample)
                .innerJoin(companyExample).on(ruleExample.createCriteria().equalTo(LogisticsTemplateRuleExample.ruleId,LogisticsTemplateCompanyExample.ruleId))
                .innerJoin(provExample).on(provExample.createCriteria().equalTo(LogisticsTemplateProvExample.ruleId, LogisticsTemplateCompanyExample.ruleId))
                .where(provExample.createCriteria().andProvIdEqualTo(provId).andTemplateIdEqualTo(templateId),companyExample.createCriteria()
                        .andCompanyIdEqualTo(companyId).andTemplateIdEqualTo(templateId),ruleExample.createCriteria().andImDefaultEqualTo(false)).build();
        List<RuleInfoVO> rules=multipleMapper.selectFieldsByMultipleExample(multipleExample,RuleInfoVO.class);
        if (rules.size()>0) {
            return BeanMapper.map(rules.get(0),BournRuleInfoVO.class);
        }
        //取不到对应的，要拿默认规则
        BournRuleInfoVO rule=defaultRule();
        rule.setCompanyId(companyId);
        rule.setProvId(provId);
        return rule;
    }

    /**
     * 查出默认模板
     * @return
     * @throws LogisticsRuleException
     */
    private BournRuleInfoVO defaultRule() throws LogisticsRuleException {
        LogisticsTemplateRuleExample ruleExample=new LogisticsTemplateRuleExample();
        ruleExample.createCriteria().andTemplateIdEqualTo(templateId).andImDefaultEqualTo(true);
        List<LogisticsTemplateRule> defaultRules=logisticsTemplateRuleMapper.selectByExample(ruleExample);
        if (defaultRules.size()>0) {
            BournRuleInfoVO rule=new BournRuleInfoVO();
            LogisticsTemplateRule defaultRule=defaultRules.get(0);
            rule.setAddPrice(defaultRule.getPerFee());
            rule.setAddWeight(defaultRule.getPerUnit());
            rule.setImDefault(defaultRule.getImDefault());
            rule.setRuleId(defaultRule.getRuleId());
            rule.setStartPrice(defaultRule.getFirstFee());
            rule.setStartWeight(defaultRule.getFirstUnit());
            rule.setType(defaultRule.getType());
            return rule;
        }
        throw new LogisticsRuleException("物流规则出错");
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
        BournRuleInfoVO vo = rule(provId, companyId);
        if (vo == null) {
            throw new LogisticsRuleException(String.format("无默认快递规则; provId[%d],companyId[%d]", provId, companyId));
        }
        Long unit = vo.getType() == 1 ? goodsNumber.longValue() : vo.getType() == 2 ? weight : 0; // 计费单元
        Long add = vo.getAddWeight() == 0 ? 0L  // Double数除以0会发生奇怪的事情、比如取到极值，比如取到 NaN
                : ((Double) (Math.ceil((unit - vo.getStartWeight()) * 1.0 / vo.getAddWeight()) * vo.getAddPrice())).longValue();

        return vo.getStartPrice() + (add > 0 ? add : 0);
    }
}
