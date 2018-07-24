package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ExpressTemplateProv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ExpressTemplateProvExample extends SgExample<ExpressTemplateProvExample.Criteria> {
    public static final Class<ExpressTemplateProv> beanClass = ExpressTemplateProv.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn provName;
    public static EntityColumn etId;
    public static EntityColumn etpStatus;
    public static EntityColumn etpId;
    public static EntityColumn ruleId;
    public static EntityColumn provId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        provName = listMap.get("provName");
        etId = listMap.get("etId");
        etpStatus = listMap.get("etpStatus");
        etpId = listMap.get("etpId");
        ruleId = listMap.get("ruleId");
        provId = listMap.get("provId");
        }

    public ExpressTemplateProvExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ExpressTemplateProvExample.Criteria createCriteriaInternal() {
        return new ExpressTemplateProvExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ExpressTemplateProvExample.Criteria andProvNameIsNull() {
            return isNull(provName);
        }

        public ExpressTemplateProvExample.Criteria andProvNameIsNotNull() {
            return isNotNull(provName);
        }

        public ExpressTemplateProvExample.Criteria andProvNameEqualTo(String value) {
            return equalTo(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameNotEqualTo(String value) {
            return notEqualTo(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameGreaterThan(String value) {
            return greaterThan(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameLessThan(String value) {
            return lessThan(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameLike(String value) {
            return like(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameNotLike(String value) {
            return notLike(provName, value);
        }

        public ExpressTemplateProvExample.Criteria andProvNameIn(List<String> values) {
            return in(provName, values);
        }

        public ExpressTemplateProvExample.Criteria andProvNameNotIn(List<String> values) {
            return notIn(provName, values);
        }

        public ExpressTemplateProvExample.Criteria andProvNameBetween(String value1, String value2) {
            return between(provName, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andProvNameNotBetween(String value1, String value2) {
            return notBetween(provName, value1, value2);
        }
        public ExpressTemplateProvExample.Criteria andEtIdIsNull() {
            return isNull(etId);
        }

        public ExpressTemplateProvExample.Criteria andEtIdIsNotNull() {
            return isNotNull(etId);
        }

        public ExpressTemplateProvExample.Criteria andEtIdEqualTo(Long value) {
            return equalTo(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdNotEqualTo(Long value) {
            return notEqualTo(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdGreaterThan(Long value) {
            return greaterThan(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdLessThan(Long value) {
            return lessThan(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(etId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtIdIn(List<Long> values) {
            return in(etId, values);
        }

        public ExpressTemplateProvExample.Criteria andEtIdNotIn(List<Long> values) {
            return notIn(etId, values);
        }

        public ExpressTemplateProvExample.Criteria andEtIdBetween(Long value1, Long value2) {
            return between(etId, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andEtIdNotBetween(Long value1, Long value2) {
            return notBetween(etId, value1, value2);
        }
        public ExpressTemplateProvExample.Criteria andEtpStatusIsNull() {
            return isNull(etpStatus);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusIsNotNull() {
            return isNotNull(etpStatus);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusEqualTo(Integer value) {
            return equalTo(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusNotEqualTo(Integer value) {
            return notEqualTo(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusGreaterThan(Integer value) {
            return greaterThan(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusLessThan(Integer value) {
            return lessThan(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(etpStatus, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusIn(List<Integer> values) {
            return in(etpStatus, values);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusNotIn(List<Integer> values) {
            return notIn(etpStatus, values);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusBetween(Integer value1, Integer value2) {
            return between(etpStatus, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andEtpStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(etpStatus, value1, value2);
        }
        public ExpressTemplateProvExample.Criteria andEtpIdIsNull() {
            return isNull(etpId);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdIsNotNull() {
            return isNotNull(etpId);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdEqualTo(Long value) {
            return equalTo(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdNotEqualTo(Long value) {
            return notEqualTo(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdGreaterThan(Long value) {
            return greaterThan(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdLessThan(Long value) {
            return lessThan(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(etpId, value);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdIn(List<Long> values) {
            return in(etpId, values);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdNotIn(List<Long> values) {
            return notIn(etpId, values);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdBetween(Long value1, Long value2) {
            return between(etpId, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andEtpIdNotBetween(Long value1, Long value2) {
            return notBetween(etpId, value1, value2);
        }
        public ExpressTemplateProvExample.Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public ExpressTemplateProvExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public ExpressTemplateProvExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public ExpressTemplateProvExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public ExpressTemplateProvExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public ExpressTemplateProvExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public ExpressTemplateProvExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public ExpressTemplateProvExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
    }
}