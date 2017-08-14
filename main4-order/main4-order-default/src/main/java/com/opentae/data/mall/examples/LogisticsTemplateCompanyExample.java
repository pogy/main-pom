package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.LogisticsTemplateCompany;

import java.util.*;
public class LogisticsTemplateCompanyExample extends SgExample<LogisticsTemplateCompanyExample.Criteria> {
    public static final Class<LogisticsTemplateCompany> beanClass = LogisticsTemplateCompany.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn companyId;
    public static EntityColumn tcId;
    public static EntityColumn ruleId;
    public static EntityColumn templateId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        companyId = listMap.get("companyId");
        tcId = listMap.get("tcId");
        ruleId = listMap.get("ruleId");
        templateId = listMap.get("templateId");
        }

    public LogisticsTemplateCompanyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected LogisticsTemplateCompanyExample.Criteria createCriteriaInternal() {
        return new LogisticsTemplateCompanyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIsNull() {
            return isNull(companyId);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIsNotNull() {
            return isNotNull(companyId);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdEqualTo(Long value) {
            return equalTo(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotEqualTo(Long value) {
            return notEqualTo(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdGreaterThan(Long value) {
            return greaterThan(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdLessThan(Long value) {
            return lessThan(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(companyId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIn(List<Long> values) {
            return in(companyId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotIn(List<Long> values) {
            return notIn(companyId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdBetween(Long value1, Long value2) {
            return between(companyId, value1, value2);
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            return notBetween(companyId, value1, value2);
        }
        public LogisticsTemplateCompanyExample.Criteria andTcIdIsNull() {
            return isNull(tcId);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdIsNotNull() {
            return isNotNull(tcId);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdEqualTo(Long value) {
            return equalTo(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotEqualTo(Long value) {
            return notEqualTo(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdGreaterThan(Long value) {
            return greaterThan(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdLessThan(Long value) {
            return lessThan(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tcId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdIn(List<Long> values) {
            return in(tcId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotIn(List<Long> values) {
            return notIn(tcId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdBetween(Long value1, Long value2) {
            return between(tcId, value1, value2);
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotBetween(Long value1, Long value2) {
            return notBetween(tcId, value1, value2);
        }
        public LogisticsTemplateCompanyExample.Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
    }
}
