package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.LogisticsTemplateProv;

import java.util.*;
public class LogisticsTemplateProvExample extends SgExample<LogisticsTemplateProvExample.Criteria> {
    public static final Class<LogisticsTemplateProv> beanClass = LogisticsTemplateProv.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn tpId;
    public static EntityColumn ruleId;
    public static EntityColumn templateId;
    public static EntityColumn provId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        tpId = listMap.get("tpId");
        ruleId = listMap.get("ruleId");
        templateId = listMap.get("templateId");
        provId = listMap.get("provId");
        }

    public LogisticsTemplateProvExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected LogisticsTemplateProvExample.Criteria createCriteriaInternal() {
        return new LogisticsTemplateProvExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdIsNull() {
            return isNull(tpId);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdIsNotNull() {
            return isNotNull(tpId);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdEqualTo(Long value) {
            return equalTo(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotEqualTo(Long value) {
            return notEqualTo(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdGreaterThan(Long value) {
            return greaterThan(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdLessThan(Long value) {
            return lessThan(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tpId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdIn(List<Long> values) {
            return in(tpId, values);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotIn(List<Long> values) {
            return notIn(tpId, values);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdBetween(Long value1, Long value2) {
            return between(tpId, value1, value2);
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotBetween(Long value1, Long value2) {
            return notBetween(tpId, value1, value2);
        }
        public LogisticsTemplateProvExample.Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public LogisticsTemplateProvExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
        public LogisticsTemplateProvExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
    }
}
