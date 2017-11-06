package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ExpressCompany;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;
import com.opentae.data.mall.beans.LogisticsTemplateRule;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.model.LogisticsTemplate;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
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
    public List<BournRuleInfoVO> rule(Long provId, Long companyId) throws LogisticsRuleException {
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
        multipleExample.setDistinct(true);
        List<RuleInfoVO> rules=multipleMapper.selectFieldsByMultipleExample(multipleExample,RuleInfoVO.class);
        List<BournRuleInfoVO> bournRuleInfoVOS = new ArrayList<>();
        if (rules != null && rules.size() > 0) {
            for(RuleInfoVO ruleInfoVO : rules){
                bournRuleInfoVOS.add(BeanMapper.map(ruleInfoVO,BournRuleInfoVO.class));
            }
        }else {
            //取不到对应的，要拿默认规则
            bournRuleInfoVOS = defaultRule();
            for (BournRuleInfoVO bournRuleInfoVO : bournRuleInfoVOS){
                bournRuleInfoVO.setCompanyId(companyId);
                bournRuleInfoVO.setProvId(provId);
            }

        }
        return bournRuleInfoVOS;
    }

    /**
     * 查出默认模板
     * @return
     * @throws LogisticsRuleException
     */
    private List<BournRuleInfoVO> defaultRule() throws LogisticsRuleException {
        //默认模板为可以为梯度模板
        LogisticsTemplateRuleExample ruleExample=new LogisticsTemplateRuleExample();
        ruleExample.createCriteria().andTemplateIdEqualTo(templateId).andImDefaultEqualTo(true);
        List<LogisticsTemplateRule> defaultRules=logisticsTemplateRuleMapper.selectByExample(ruleExample);
        if (defaultRules == null || defaultRules.isEmpty()) {
            throw new LogisticsRuleException("物流规则出错");
        }

        List<BournRuleInfoVO> rules = new ArrayList<>();
        for(LogisticsTemplateRule item : defaultRules){
            BournRuleInfoVO rule=new BournRuleInfoVO();
            rule.setAddPrice(item.getPerFee());
            rule.setAddWeight(item.getPerUnit());
            rule.setImDefault(item.getImDefault());
            rule.setRuleId(item.getRuleId());
            rule.setStartPrice(item.getFirstFee());
            rule.setStartWeight(item.getFirstUnit());
            rule.setType(item.getType());

            rules.add(rule);
        }
       return rules;
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
        List<BournRuleInfoVO> vos = rule(provId, companyId);
        if (vos == null || vos.isEmpty()) {
            throw new LogisticsRuleException(String.format("无默认快递规则; provId[%d],companyId[%d]", provId, companyId));
        }

        //1按件，2按重量
        Long unit = vos.get(0).getType() == 1 ? goodsNumber.longValue() : vos.get(0).getType() == 2 ? weight : 0; // 计费单元
        Collections.sort(vos, new Comparator<BournRuleInfoVO>() {
            @Override
            public int compare(BournRuleInfoVO o1, BournRuleInfoVO o2) {
                return o1.getStartWeight() - o2.getStartWeight();
            }
        });
        BournRuleInfoVO vo = vos.get(0);
        for (BournRuleInfoVO item : vos) {
            if (unit >= item.getStartWeight()){
                vo = item;
            }
        }
        Long add = vo.getAddWeight() == 0 ? 0L  // Double数除以0会发生奇怪的事情、比如取到极值，比如取到 NaN
                : ((Double) (Math.ceil((unit - vo.getStartWeight()) * 1.0 / vo.getAddWeight()) * vo.getAddPrice())).longValue();
        return vo.getStartPrice() + (add > 0 ? add : 0);
    }

    /**
     * 获取快递公司信息
     * @param provId    省份id
     * @param senderId  发货方式id
     * @return
     */
    public List<PostVO> getPostListByProvId(Long provId, Long senderId) throws LogisticsRuleException {
        //根据senderId查找templateId
        //根据templateId provId找到ruleId
        //根据ruleId找到companyId
        //根据comanyId找到快递公司信息
        LogisticsTemplateExample templateExample = new LogisticsTemplateExample();
        LogisticsTemplateCompanyExample companyExample = new LogisticsTemplateCompanyExample();
        LogisticsTemplateProvExample  provExample = new LogisticsTemplateProvExample();
        ExpressCompanyExample expressCompanyExample = new ExpressCompanyExample();
        MultipleExample multipleExample= MultipleExampleBuilder.from(templateExample)
                .innerJoin(provExample).on(templateExample.createCriteria().equalTo(LogisticsTemplateExample.templateId,LogisticsTemplateProvExample.templateId))
                .innerJoin(companyExample)
                    .on(provExample.createCriteria().equalTo(LogisticsTemplateProvExample.templateId,LogisticsTemplateCompanyExample.templateId),
                        provExample.createCriteria().equalTo(LogisticsTemplateProvExample.ruleId,LogisticsTemplateCompanyExample.ruleId),
                        provExample.createCriteria().equalTo(LogisticsTemplateProvExample.templateId,LogisticsTemplateExample.templateId))
                .innerJoin(expressCompanyExample)
                    .on(companyExample.createCriteria().equalTo(LogisticsTemplateCompanyExample.companyId,ExpressCompanyExample.expressCompanyId))
                .where(templateExample.createCriteria().andSenderIdEqualTo(senderId),
                        provExample.createCriteria().andProvIdEqualTo(provId)).build();
        multipleExample.setDistinct(true);
        List<PostInfoVO> postInfoVOS = multipleMapper.selectFieldsByMultipleExample(multipleExample, PostInfoVO.class);
        List<PostVO> postVOS = null;
        if (postInfoVOS != null && !postInfoVOS.isEmpty()) {
            postVOS = BeanMapper.mapList(postInfoVOS, PostVO.class);
        }
        if (postVOS == null) {
            postVOS = new ArrayList<>();
        }
        List<String> postNames = BeanMapper.getFieldList(postVOS,"name",String.class);
        List<PostVO> defaultPostVOS=defaultPost();
        defaultPostVOS.removeIf(postVO -> postNames.contains(postVO.getName()));
        postVOS.addAll(defaultPostVOS);
        return postVOS;
    }

    @Override
    public List<PostVO> defaultPost() throws LogisticsRuleException {
        //添加默认快递
        //根据defaultTemplateId defaultRuleId查询
        List<BournRuleInfoVO> bournRuleInfoVOS = defaultRule();
        List<Long> ruleIds = BeanMapper.getFieldList(bournRuleInfoVOS,"ruleId",Long.class);

        LogisticsTemplateCompanyExample example = new LogisticsTemplateCompanyExample();
        example.createCriteria().andRuleIdIn(ruleIds).andTemplateIdEqualTo(templateId);
        List<LogisticsTemplateCompany> logisticsTemplateCompanies = logisticsTemplateCompanyMapper.selectByExample(example);
        if (logisticsTemplateCompanies == null || logisticsTemplateCompanies.isEmpty()) {
            throw new LogisticsRuleException(String.format("无默认快递信息; senderId[%d]", senderId));
        }
        List<Long> conpanyIds = BeanMapper.getFieldList(logisticsTemplateCompanies,"companyId",Long.class);
        ExpressCompanyExample expressCompanyExample = new ExpressCompanyExample();
        expressCompanyExample.createCriteria().andExpressCompanyIdIn(conpanyIds);
        return expressCompanyMapper.selectByExample(expressCompanyExample)
                .stream().map(expressCompany -> {
                    PostVO postVO = new PostVO();
                    postVO.setName(expressCompany.getRemark2());
                    postVO.setText(expressCompany.getExpressName());
                    return postVO;
                }).collect(Collectors.toList());
    }

}
