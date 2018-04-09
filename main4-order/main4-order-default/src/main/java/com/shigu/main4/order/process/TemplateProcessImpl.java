package com.shigu.main4.order.process;


import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ExpressRuleExample;
import com.opentae.data.mall.examples.ExpressTemplateExample;
import com.opentae.data.mall.examples.ExpressTemplateProvExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.order.utils.MoneyUtil;
import com.shigu.main4.order.vo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.process.impl
 * @ClassName: TemplateProcessImpl
 * @Author: sy
 * @CreateDate: 2018/4/3 0003 14:39
 */

@Service("templateProcess")
public class TemplateProcessImpl implements TemplateProcess{

    @Autowired
    ExpressTemplateMapper expressTemplateMapper;
    @Autowired
    ExpressRuleMapper expressRuleMapper;
    @Autowired
    ExpressTemplateProvMapper expressTemplateProvMapper;
    @Autowired
    OrderProvMapper orderProvMapper;
    @Autowired
    ExpressCompanyMapper expressCompanyMapper;

    @Override
    public Long addExpressTemplate(){
        ExpressTemplate expressTemplate = new ExpressTemplate();
        expressTemplate.setFree(0);
        expressTemplate.setEnabled(0);
        expressTemplate.setTemplateStatus(1);
        expressTemplateMapper.insertSelective(expressTemplate);
        return expressTemplate.getTId();
    }

    @Override
    public Long addExpressParentRule(Long templateId) {
        ExpressRule expressRule = new ExpressRule();
        expressRule.setIsParentRule(1);
        expressRule.setRuleStatus(1);
        expressRule.setEtId(templateId);
        expressRule.setIsDefault(0);
        expressRuleMapper.insertSelective(expressRule);
        return expressRule.getRId();
    }

    @Override
    public Long addExpressdefaultRule(Long templateId,Integer threshold,String ruleTile) {
        ExpressRuleExample expressRuleExample = new ExpressRuleExample();
        expressRuleExample.createCriteria().andRuleStatusEqualTo(1).andIsDefaultEqualTo(1).andEtIdEqualTo(templateId);
        List<ExpressRule> expressRules = expressRuleMapper.selectByExample(expressRuleExample);
        if (expressRules != null && expressRules.size() > 0){
            for (int i = 0; i <expressRules.size() ; i++) {
                if (expressRules.get(i).getThreshold() == threshold){
                    return null;
                }
            }
        }
        ExpressRule expressRule = new ExpressRule();
        expressRule.setIsDefault(1);
        expressRule.setRuleTile(ruleTile);
        expressRule.setEtId(templateId);
        expressRule.setRuleStatus(1);
        expressRule.setThreshold(threshold);
        expressRuleMapper.insertSelective(expressRule);
        return expressRule.getRId();
    }

    @Override
    public List<ExpressProv> selectProvList() {
        List<OrderProv> orderProvs = orderProvMapper.select(new OrderProv());
        List<ExpressProv> expressProvList = new ArrayList<>();
        ExpressProv expressProv = null;
        for (int i = 0; i <orderProvs.size() ; i++) {
            expressProv = new ExpressProv();
            expressProv.setProvId(orderProvs.get(i).getProvId());
            expressProv.setProvName(orderProvs.get(i).getProvName());
            expressProvList.add(expressProv);
        }
        return expressProvList;
    }

    @Override
    public Integer insertExpressProv(Long templateId, Long parentRuleId, String provIds) {
        String[] provs = provIds.split(",");
        if (provs == null || provs.length <= 0){
            return 0;
        }
        List<ExpressTemplateProv> expressProvList = new ArrayList<>();
        ExpressTemplateProvExample expressTemplateProvExample = new ExpressTemplateProvExample();
        expressTemplateProvExample.createCriteria().andEtpStatusEqualTo(1).andRuleIdEqualTo(parentRuleId);
        List<ExpressTemplateProv> expressTemplateProvs = expressTemplateProvMapper.selectByExample(expressTemplateProvExample);
        ExpressTemplateProv expressProv = null;
        if (expressTemplateProvs != null && expressTemplateProvs.size() > 0) {
                for (int i = 0; i <expressTemplateProvs.size() ; i++) {
                    expressProv = new ExpressTemplateProv();
                    expressProv.setEtpId(expressTemplateProvs.get(i).getEtpId());
                    expressProv.setEtpStatus(-1);
                    expressTemplateProvMapper.updateByPrimaryKeySelective(expressProv);
                }
            }
        for (int i = 0; i < provs.length; i++) {
             OrderProv orderProv = new OrderProv();
             orderProv.setProvId(Long.valueOf(provs[i]));
             expressProv = new ExpressTemplateProv();
             expressProv.setProvId(Long.valueOf(provs[i]));
             expressProv.setProvName(orderProvMapper.selectByPrimaryKey(orderProv).getProvName());
             expressProv.setRuleId(parentRuleId);
             expressProv.setEtId(templateId);
             expressProv.setEtpStatus(1);
             expressProvList.add(expressProv);
         }
        return expressTemplateProvMapper.insertListNoId(expressProvList);
    }

    @Override
    public Integer deleteParentRule(Long parentRuleId) {
        ExpressTemplateProvExample expressTemplateProvExample = new ExpressTemplateProvExample();
        expressTemplateProvExample.createCriteria().andRuleIdEqualTo(parentRuleId).andEtpStatusEqualTo(1);
        List<ExpressTemplateProv> expressTemplateProvList = expressTemplateProvMapper.selectByExample(expressTemplateProvExample);
        int b;
        if (expressTemplateProvList != null && expressTemplateProvList.size()>0) {
            ExpressTemplateProv prov = null;
            for (int i = 0; i < expressTemplateProvList.size(); i++) {
                prov = expressTemplateProvList.get(i);
                prov.setEtpStatus(-1);
                b = expressTemplateProvMapper.updateByPrimaryKeySelective(prov);
                if (b <=0 ){
                    return 0;
                }
            }
        }
        ExpressRuleExample expressRuleExample = new ExpressRuleExample();
        expressRuleExample.createCriteria().andParentRuleIdEqualTo(parentRuleId).andRuleStatusEqualTo(1);
        List<ExpressRule> expressRules = expressRuleMapper.selectByExample(expressRuleExample);
        if (expressRules != null && expressRules.size() >0){
            ExpressRule expressRule = null;
            for (int i = 0; i <expressRules.size() ; i++) {
                expressRule = expressRules.get(i);
                expressRule.setRuleStatus(-1);
                b = expressRuleMapper.updateByPrimaryKeySelective(expressRule);
                if (b <=0 ){
                    return 0;
                }
            }
        }
        ExpressRule expressRule = new ExpressRule();
        expressRule.setRId(parentRuleId);
        expressRule.setRuleStatus(-1);
        b = expressRuleMapper.updateByPrimaryKeySelective(expressRule);
        if(b <= 0){
            return 0;
        }
        return 1;
    }

    @Override
    public Integer EditExpressTemplate(String expressTemplate) {
        JSONObject jsonObject = JSONObject.fromObject(expressTemplate);
        Map<String,Class> map = new HashMap<>();
        map.put("freightList",defaultRule.class);
        map.put("groupList",RuleGroupVo.class);
        map.put("costFeeList",CostFeeRuleVo.class);
        ExpressTemplateSaveVo expressTemplateSaveVo = (ExpressTemplateSaveVo) JSONObject.toBean(jsonObject,ExpressTemplateSaveVo.class,map);
        ExpressTemplate template = new ExpressTemplate();
        template.setTId(expressTemplateSaveVo.getTempId());
        template.setExpressCompanyId(expressTemplateSaveVo.getCourierId());
        ExpressCompany expressCompany = new ExpressCompany();
        expressCompany.setExpressCompanyId(expressTemplateSaveVo.getCourierId());
        String ExpressCompanyName = expressCompanyMapper.selectByPrimaryKey(expressCompany).getExpressName();
        template.setTemplateTitle(ExpressCompanyName);
        if (expressTemplateSaveVo.isInitiateIs() == true){
            template.setEnabled(1);
        }else {
            template.setEnabled(0);
        }
        int b = expressTemplateMapper.updateByPrimaryKeySelective(template);
        if (b <= 0){
            return b;
        }
        ExpressRule expressRule = null;
        List<ExpressRule> expressRuleList = new ArrayList<>();
        //默认运费规则
        if (expressTemplateSaveVo.getFreightList() != null && expressTemplateSaveVo.getFreightList().size() > 0 ) {
            for (int i = 0; i < expressTemplateSaveVo.getFreightList().size(); i++) {
                expressRule = new ExpressRule();
                expressRule.setRId(expressTemplateSaveVo.getFreightList().get(i).getFreightId());
                expressRule.setThresholdFree(MoneyUtil.moneyToCent(expressTemplateSaveVo.getFreightList().get(i).getCostFee()));
                expressRuleMapper.updateByPrimaryKeySelective(expressRule);
            }
        }
        if (expressTemplateSaveVo.getGroupList() != null && expressTemplateSaveVo.getGroupList().size() > 0){
            //运费子规则插入
            for (int i = 0; i < expressTemplateSaveVo.getGroupList().size(); i++) {
                List<CostFeeRuleVo> costFeeRuleVoList = expressTemplateSaveVo.getGroupList().get(i).getCostFeeList();
                if (costFeeRuleVoList != null && costFeeRuleVoList.size() > 0){
                    for (int j = 0; j < costFeeRuleVoList.size(); j++) {
                        expressRule = new ExpressRule();
                        expressRule.setRId(costFeeRuleVoList.get(j).getFreightChildId());
                        expressRule.setThreshold(costFeeRuleVoList.get(j).getThreshold());
                        expressRule.setThresholdFree(MoneyUtil.moneyToCent(costFeeRuleVoList.get(j).getCostFee()));
                        expressRule.setParentRuleId(expressTemplateSaveVo.getGroupList().get(i).getGroupId());
                        expressRule.setEtId(expressTemplateSaveVo.getTempId());
                        expressRule.setRuleType(0);
                        expressRule.setRuleStatus(1);
                        expressRule.setIsParentRule(2);
                        expressRule.setIsDefault(2);
                        if (expressRule.getRId() == null){
                            expressRuleList.add(expressRule);
                        }else {
                            b = expressRuleMapper.updateByPrimaryKeySelective(expressRule);
                                 if (b <= 0){
                                     return b;
                                 }
                            }
                    }
                }
            }
        }
        if (expressRuleList == null || expressRuleList.size() <= 0){
            return 1;
        }
        b = expressRuleMapper.insertListNoId(expressRuleList);
        return b;
    }

    @Override
    public Integer saveExpressTemplate(String expressTemplate) {
        JSONObject jsonObject = JSONObject.fromObject(expressTemplate);
        Map<String,Class> map = new HashMap<>();
        map.put("freightList",defaultRule.class);
        map.put("groupList",RuleGroupVo.class);
        map.put("costFeeList",CostFeeRuleVo.class);
        ExpressTemplateSaveVo expressTemplateSaveVo = (ExpressTemplateSaveVo) JSONObject.toBean(jsonObject,ExpressTemplateSaveVo.class,map);
        ExpressTemplate template = new ExpressTemplate();
        template.setTId(expressTemplateSaveVo.getTempId());
        template.setExpressCompanyId(expressTemplateSaveVo.getCourierId());
        ExpressCompany expressCompany = new ExpressCompany();
        expressCompany.setExpressCompanyId(expressTemplateSaveVo.getCourierId());
        String ExpressCompanyName = expressCompanyMapper.selectByPrimaryKey(expressCompany).getExpressName();
        template.setTemplateTitle(ExpressCompanyName);
        if (expressTemplateSaveVo.isInitiateIs() == true){
            template.setEnabled(1);
        }else {
            template.setEnabled(0);
        }
        int b = expressTemplateMapper.updateByPrimaryKeySelective(template);
        if (b <= 0){
            return 0;
        }
        List<ExpressRule> expressRuleList = new ArrayList<>();
        ExpressRule expressRule = null;
        //默认运费规则
        if (expressTemplateSaveVo.getFreightList() != null && expressTemplateSaveVo.getFreightList().size() > 0 ) {
            for (int i = 0; i < expressTemplateSaveVo.getFreightList().size(); i++) {
                expressRule = new ExpressRule();
                expressRule.setRId(expressTemplateSaveVo.getFreightList().get(i).getFreightId());
                expressRule.setThresholdFree(MoneyUtil.moneyToCent(expressTemplateSaveVo.getFreightList().get(i).getCostFee()));
                expressRuleMapper.updateByPrimaryKeySelective(expressRule);
            }
        }
        if (expressTemplateSaveVo.getGroupList() != null && expressTemplateSaveVo.getGroupList().size() > 0){
            //运费子规则修改
            for (int i = 0; i < expressTemplateSaveVo.getGroupList().size(); i++) {
                List<CostFeeRuleVo> costFeeRuleVoList = expressTemplateSaveVo.getGroupList().get(i).getCostFeeList();
                if (costFeeRuleVoList != null && costFeeRuleVoList.size() > 0){
                    for (int j = 0; j < costFeeRuleVoList.size(); j++) {
                        expressRule = new ExpressRule();
                        expressRule.setThreshold(costFeeRuleVoList.get(j).getThreshold());
                        expressRule.setThresholdFree(MoneyUtil.moneyToCent(costFeeRuleVoList.get(j).getCostFee()));
                        expressRule.setParentRuleId(expressTemplateSaveVo.getGroupList().get(i).getGroupId());
                        expressRule.setEtId(expressTemplateSaveVo.getTempId());
                        expressRule.setRuleType(0);
                        expressRule.setRuleStatus(1);
                        expressRule.setIsParentRule(2);
                        expressRule.setIsDefault(2);
                        expressRuleList.add(expressRule);
                    }
                }
            }
        }
        if (expressRuleList.size() <= 0){
            return 1;
        }
        b = expressRuleMapper.insertListNoId(expressRuleList);
        if (b <=0){
            return 0;
        }
        return b;
    }

    @Override
    public Integer deleteExpressdefaultRule(Long templateId, Integer number) {

        ExpressRuleExample expressRuleExample = new ExpressRuleExample();
        expressRuleExample.createCriteria().andRuleStatusEqualTo(1).andThresholdEqualTo(number).andEtIdEqualTo(templateId);
        List<ExpressRule> expressRules = expressRuleMapper.selectByExample(expressRuleExample);
        if (expressRules != null && expressRules.size() >0){
            ExpressRule expressRule = null;
            for (int i = 0; i <expressRules.size() ; i++) {
                expressRule = new ExpressRule();
                expressRule.setRId(expressRules.get(i).getRId());
                expressRule.setRuleStatus(-1);
                int b = expressRuleMapper.updateByPrimaryKeySelective(expressRule);
                if (b <= 0){
                    return null;
                }
            }
        }
        return 1;
    }

    @Override
    public List<ExpressCompanyVo> selectExpressCompany() {
        List<ExpressCompany> expressCompanies = expressCompanyMapper.select(new ExpressCompany());
        List<ExpressCompanyVo> expressCompanyVoList = new ArrayList<>();
        ExpressCompanyVo expressCompanyVo = null;
        if (expressCompanies == null || expressCompanies.size() <=0){
            return null;
        }
        for (int i = 0; i < expressCompanies.size(); i++) {
            expressCompanyVo = new ExpressCompanyVo();
            expressCompanyVo.setCourierId(expressCompanies.get(i).getExpressCompanyId());
            expressCompanyVo.setCourierName(expressCompanies.get(i).getExpressName());
            expressCompanyVoList.add(expressCompanyVo);
        }
        return expressCompanyVoList;
    }

    @Override
    public Integer templateEnabled(Long templateId, Boolean b) {
        ExpressTemplate expressTemplate = new ExpressTemplate();
        expressTemplate.setTId(templateId);
        if (b){
            expressTemplate.setEnabled(1);
        }else {
            expressTemplate.setEnabled(0);
        }
        return expressTemplateMapper.updateByPrimaryKeySelective(expressTemplate);
    }

    @Override
    public List<ShowTempVo> selectTemplateAll() {
        ExpressTemplateExample expressTemplateExample = new ExpressTemplateExample();
        expressTemplateExample.createCriteria().andTemplateStatusEqualTo(1);
        List<ExpressTemplate> expressTemplateList = expressTemplateMapper.selectByExample(expressTemplateExample);
        List<ShowTempVo> showTempVoList = new ArrayList<>();
        ShowTempVo showTempVo = null;
        if (expressTemplateList == null || expressTemplateList.size() <=0){
            return null;
        }

        for (int i = 0; i <expressTemplateList.size() ; i++) {
            showTempVo = new ShowTempVo();
            showTempVo.setTempId(expressTemplateList.get(i).getTId());
            showTempVo.setCourierId(expressTemplateList.get(i).getExpressCompanyId());
            showTempVo.setCourierName(expressTemplateList.get(i).getTemplateTitle());
            if (expressTemplateList.get(i).getEnabled() ==1){
                showTempVo.setInitiateIs(true);
            }else {
                showTempVo.setInitiateIs(null);
            }
            List<CourierRuleVo> courierRuleVoList = new ArrayList<>();
            CourierRuleVo courierRuleVo = null;
            ExpressRuleExample ruleExample = new ExpressRuleExample();
            ruleExample.createCriteria().andEtIdEqualTo(expressTemplateList.get(i).getTId()).andIsParentRuleEqualTo(1).andRuleStatusEqualTo(1);
            List<ExpressRule> expressRuleList = expressRuleMapper.selectByExample(ruleExample);
            if (expressRuleList != null && expressRuleList.size() > 0 ){
                for (int j = 0; j <expressRuleList.size() ; j++) {
                    ExpressTemplateProvExample expressTemplateProvExample = new ExpressTemplateProvExample();
                    expressTemplateProvExample.createCriteria().andEtIdEqualTo(expressTemplateList.get(i).getTId()).andRuleIdEqualTo(expressRuleList.get(j).getRId()).andEtpStatusEqualTo(1);
                    List<ExpressTemplateProv> expressTemplateProvList = expressTemplateProvMapper.selectByExample(expressTemplateProvExample);
                    StringBuffer provs = new StringBuffer();
                    if (expressTemplateProvList.size() > 0) {
                        for (int k = 0; k < expressTemplateProvList.size(); k++) {
                            provs.append(expressTemplateProvList.get(k).getProvName()+",");
                        }
                    }
                    courierRuleVo = new CourierRuleVo();
                    List<CourierShowVo> courierShowVoList = new ArrayList<>();
                    CourierShowVo courierShowVo = null;
                    if (provs != null && provs.length() > 0) {
                        provs.deleteCharAt(provs.length() - 1);
                    }
                    courierRuleVo.setProvs(provs.toString());
                    ExpressRuleExample expressRuleExample = new ExpressRuleExample();
                    expressRuleExample.createCriteria().andRuleStatusEqualTo(1).andParentRuleIdEqualTo(expressRuleList.get(j).getRId());
                    List<ExpressRule> ruleList = expressRuleMapper.selectByExample(expressRuleExample);
                    ExpressRuleExample expressRuleExample1 = new ExpressRuleExample();
                    expressRuleExample1.createCriteria().andRuleStatusEqualTo(1).andEtIdEqualTo(expressTemplateList.get(i).getTId()).andIsDefaultEqualTo(1);
                    List<ExpressRule> defaultRuleList = expressRuleMapper.selectByExample(expressRuleExample1);
                    if (ruleList.size() > 0){
                        for (int k = 0; k < ruleList.size(); k++) {
                            for (int l = 0; l <defaultRuleList.size() ; l++) {
                                if (ruleList.get(k).getThreshold() == defaultRuleList.get(l).getThreshold()){
                                    courierShowVo = new CourierShowVo();
                                    courierShowVo.setText(defaultRuleList.get(l).getRuleTile());
                                    courierShowVo.setFreight(MoneyUtil.moneyToDollar(ruleList.get(k).getThresholdFree()));
                                }
                            }
                            courierShowVoList.add(courierShowVo);
                        }
                    }
                    courierRuleVo.setFreightList(courierShowVoList);
                    courierRuleVoList.add(courierRuleVo);
                }
            }
            showTempVo.setProvsListByTemp(courierRuleVoList);
            showTempVoList.add(showTempVo);
        }
        return showTempVoList;
    }

    @Override
    public editExpressTemplate selectEditTemplate(Long templateId) {
        ExpressTemplateExample expressTemplateExample = new ExpressTemplateExample();
        expressTemplateExample.createCriteria().andTemplateStatusEqualTo(1).andTIdEqualTo(templateId);
        List<ExpressTemplate> expressTemplateList = expressTemplateMapper.selectByExample(expressTemplateExample);
        if (expressTemplateList.size() <= 0){
            return null;
        }
        ExpressTemplate expressTemplate = expressTemplateList.get(0);
        Long courierId = expressTemplate.getExpressCompanyId();
        Boolean initiateIs = null;
        if (expressTemplate.getEnabled() == 1){
            initiateIs = true;
        }else {
            initiateIs = null;
        }
        ExpressRuleExample expressRuleExample = new ExpressRuleExample();
        expressRuleExample.createCriteria().andEtIdEqualTo(templateId).andRuleStatusEqualTo(1).andIsDefaultEqualTo(1);
        List<ExpressRule> defaultRules = expressRuleMapper.selectByExample(expressRuleExample);
        List<editDefaultRuleVo> editDefaultRuleVos = new ArrayList<>();
        editDefaultRuleVo defaultRuleVo = null;
       if (defaultRules.size() > 0){
           for (int i = 0; i <defaultRules.size() ; i++) {
               defaultRuleVo = new editDefaultRuleVo();
               defaultRuleVo.setFreightId(defaultRules.get(i).getRId());
               defaultRuleVo.setText(defaultRules.get(i).getRuleTile());
               defaultRuleVo.setCostFee(MoneyUtil.moneyToDollar(defaultRules.get(i).getThresholdFree()));
               defaultRuleVo.setThreshold(defaultRules.get(i).getThreshold());
               editDefaultRuleVos.add(defaultRuleVo);
           }
       }
        ExpressRuleExample ruleExample = new ExpressRuleExample();
        ruleExample.createCriteria().andEtIdEqualTo(templateId).andIsParentRuleEqualTo(1).andRuleStatusEqualTo(1);
        List<ExpressRule> expressRuleList = expressRuleMapper.selectByExample(ruleExample);
        ParentRuleGroup parentRuleGroup = null;
        List<ParentRuleGroup> parentRuleGroups = new ArrayList<>();
        if (expressRuleList.size() > 0){
            for (int i = 0; i <expressRuleList.size() ; i++) {
                ExpressTemplateProvExample expressTemplateProvExample = new ExpressTemplateProvExample();
                expressTemplateProvExample.createCriteria().andEtIdEqualTo(templateId).andRuleIdEqualTo(expressRuleList.get(i).getRId()).andEtpStatusEqualTo(1);
                List<ExpressTemplateProv> expressTemplateProvList = expressTemplateProvMapper.selectByExample(expressTemplateProvExample);
                StringBuffer provs = new StringBuffer();
                StringBuffer provIds = new StringBuffer();
                if (expressTemplateProvList.size() > 0) {
                    for (int j = 0; j < expressTemplateProvList.size(); j++) {
                        provIds.append(expressTemplateProvList.get(j).getProvId()+",");
                        provs.append(expressTemplateProvList.get(j).getProvName()+",");
                    }
                }
                parentRuleGroup = new ParentRuleGroup();
                parentRuleGroup.setGroupId(expressRuleList.get(i).getRId());
                parentRuleGroup.setProvIds(provIds.deleteCharAt(provIds.length()-1).toString());
                parentRuleGroup.setProvs(provs.deleteCharAt(provs.length()-1).toString());

                ExpressRuleExample rExample = new ExpressRuleExample();
                rExample.createCriteria().andParentRuleIdEqualTo(expressRuleList.get(i).getRId()).andRuleStatusEqualTo(1);
                List<ExpressRule> expressRules = expressRuleMapper.selectByExample(rExample);
                List<CostFeeRuleVo> costFeeRuleVoList = new ArrayList<>();
                CostFeeRuleVo costFeeRuleVo = null;
                if (expressRules.size() > 0){
                    for (int j = 0; j < expressRules.size(); j++) {
                        costFeeRuleVo = new CostFeeRuleVo();
                        costFeeRuleVo.setFreightChildId(expressRules.get(j).getRId());
                        costFeeRuleVo.setCostFee(MoneyUtil.moneyToDollar(expressRules.get(j).getThresholdFree()));
                        costFeeRuleVo.setThreshold(expressRules.get(j).getThreshold());
                        costFeeRuleVoList.add(costFeeRuleVo);
                    }
                }
                parentRuleGroup.setCostFeeList(costFeeRuleVoList);
                parentRuleGroups.add(parentRuleGroup);
            }
        }
        editExpressTemplate template = new editExpressTemplate();
        template.setCourierId(courierId);
        template.setInitiateIs(initiateIs);
        template.setEditDefaultRuleVos(editDefaultRuleVos);
        template.setParentRuleGroups(parentRuleGroups);
        return template;
    }


}
