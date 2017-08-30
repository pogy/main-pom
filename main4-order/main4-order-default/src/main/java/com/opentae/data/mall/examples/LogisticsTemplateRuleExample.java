package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.LogisticsTemplateRule;

import java.util.*;
public class LogisticsTemplateRuleExample extends SgExample<LogisticsTemplateRuleExample.Criteria> {
    public static final Class<LogisticsTemplateRule> beanClass = LogisticsTemplateRule.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn perUnit;
    public static EntityColumn imDefault;
    public static EntityColumn firstUnit;
    public static EntityColumn perFee;
    public static EntityColumn ruleId;
    public static EntityColumn type;
    public static EntityColumn templateId;
    public static EntityColumn firstFee;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        perUnit = listMap.get("perUnit");
        imDefault = listMap.get("imDefault");
        firstUnit = listMap.get("firstUnit");
        perFee = listMap.get("perFee");
        ruleId = listMap.get("ruleId");
        type = listMap.get("type");
        templateId = listMap.get("templateId");
        firstFee = listMap.get("firstFee");
        }

    public LogisticsTemplateRuleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected LogisticsTemplateRuleExample.Criteria createCriteriaInternal() {
        return new LogisticsTemplateRuleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitIsNull() {
            return isNull(perUnit);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitIsNotNull() {
            return isNotNull(perUnit);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitEqualTo(Integer value) {
            return equalTo(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotEqualTo(Integer value) {
            return notEqualTo(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitGreaterThan(Integer value) {
            return greaterThan(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitLessThan(Integer value) {
            return lessThan(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(perUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitIn(List<Integer> values) {
            return in(perUnit, values);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotIn(List<Integer> values) {
            return notIn(perUnit, values);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitBetween(Integer value1, Integer value2) {
            return between(perUnit, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotBetween(Integer value1, Integer value2) {
            return notBetween(perUnit, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andImDefaultIsNull() {
            return isNull(imDefault);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultIsNotNull() {
            return isNotNull(imDefault);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultEqualTo(Boolean value) {
            return equalTo(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotEqualTo(Boolean value) {
            return notEqualTo(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultGreaterThan(Boolean value) {
            return greaterThan(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultLessThan(Boolean value) {
            return lessThan(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(imDefault, value);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultIn(List<Boolean> values) {
            return in(imDefault, values);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotIn(List<Boolean> values) {
            return notIn(imDefault, values);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultBetween(Boolean value1, Boolean value2) {
            return between(imDefault, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotBetween(Boolean value1, Boolean value2) {
            return notBetween(imDefault, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andFirstUnitIsNull() {
            return isNull(firstUnit);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitIsNotNull() {
            return isNotNull(firstUnit);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitEqualTo(Integer value) {
            return equalTo(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotEqualTo(Integer value) {
            return notEqualTo(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitGreaterThan(Integer value) {
            return greaterThan(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitLessThan(Integer value) {
            return lessThan(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(firstUnit, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitIn(List<Integer> values) {
            return in(firstUnit, values);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotIn(List<Integer> values) {
            return notIn(firstUnit, values);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitBetween(Integer value1, Integer value2) {
            return between(firstUnit, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotBetween(Integer value1, Integer value2) {
            return notBetween(firstUnit, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andPerFeeIsNull() {
            return isNull(perFee);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeIsNotNull() {
            return isNotNull(perFee);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeEqualTo(Long value) {
            return equalTo(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotEqualTo(Long value) {
            return notEqualTo(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeGreaterThan(Long value) {
            return greaterThan(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeLessThan(Long value) {
            return lessThan(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(perFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeIn(List<Long> values) {
            return in(perFee, values);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotIn(List<Long> values) {
            return notIn(perFee, values);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeBetween(Long value1, Long value2) {
            return between(perFee, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotBetween(Long value1, Long value2) {
            return notBetween(perFee, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
        public LogisticsTemplateRuleExample.Criteria andFirstFeeIsNull() {
            return isNull(firstFee);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeIsNotNull() {
            return isNotNull(firstFee);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeEqualTo(Long value) {
            return equalTo(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotEqualTo(Long value) {
            return notEqualTo(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeGreaterThan(Long value) {
            return greaterThan(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeLessThan(Long value) {
            return lessThan(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(firstFee, value);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeIn(List<Long> values) {
            return in(firstFee, values);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotIn(List<Long> values) {
            return notIn(firstFee, values);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeBetween(Long value1, Long value2) {
            return between(firstFee, value1, value2);
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotBetween(Long value1, Long value2) {
            return notBetween(firstFee, value1, value2);
        }
    }
}
