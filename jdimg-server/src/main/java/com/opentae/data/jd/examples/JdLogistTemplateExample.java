package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdLogistTemplate;

import java.util.*;

public class JdLogistTemplateExample extends SgExample<JdLogistTemplateExample.Criteria> {
    public static final Class<JdLogistTemplate> beanClass = JdLogistTemplate.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn jdUid;
    public static EntityColumn isFree;
    public static EntityColumn gmtModify;
    public static EntityColumn templateIndex;
    public static EntityColumn templateName;
    public static EntityColumn ruleType;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn templateId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        jdUid = listMap.get("jdUid");
        isFree = listMap.get("isFree");
        gmtModify = listMap.get("gmtModify");
        templateIndex = listMap.get("templateIndex");
        templateName = listMap.get("templateName");
        ruleType = listMap.get("ruleType");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        templateId = listMap.get("templateId");
        }

    public JdLogistTemplateExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public Criteria andIsFreeIsNull() {
            return isNull(isFree);
        }

        public Criteria andIsFreeIsNotNull() {
            return isNotNull(isFree);
        }

        public Criteria andIsFreeEqualTo(Integer value) {
            return equalTo(isFree, value);
        }

        public Criteria andIsFreeNotEqualTo(Integer value) {
            return notEqualTo(isFree, value);
        }

        public Criteria andIsFreeGreaterThan(Integer value) {
            return greaterThan(isFree, value);
        }

        public Criteria andIsFreeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isFree, value);
        }

        public Criteria andIsFreeLessThan(Integer value) {
            return lessThan(isFree, value);
        }

        public Criteria andIsFreeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isFree, value);
        }

        public Criteria andIsFreeIn(List<Integer> values) {
            return in(isFree, values);
        }

        public Criteria andIsFreeNotIn(List<Integer> values) {
            return notIn(isFree, values);
        }

        public Criteria andIsFreeBetween(Integer value1, Integer value2) {
            return between(isFree, value1, value2);
        }

        public Criteria andIsFreeNotBetween(Integer value1, Integer value2) {
            return notBetween(isFree, value1, value2);
        }
        public Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public Criteria andTemplateIndexIsNull() {
            return isNull(templateIndex);
        }

        public Criteria andTemplateIndexIsNotNull() {
            return isNotNull(templateIndex);
        }

        public Criteria andTemplateIndexEqualTo(Integer value) {
            return equalTo(templateIndex, value);
        }

        public Criteria andTemplateIndexNotEqualTo(Integer value) {
            return notEqualTo(templateIndex, value);
        }

        public Criteria andTemplateIndexGreaterThan(Integer value) {
            return greaterThan(templateIndex, value);
        }

        public Criteria andTemplateIndexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(templateIndex, value);
        }

        public Criteria andTemplateIndexLessThan(Integer value) {
            return lessThan(templateIndex, value);
        }

        public Criteria andTemplateIndexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(templateIndex, value);
        }

        public Criteria andTemplateIndexIn(List<Integer> values) {
            return in(templateIndex, values);
        }

        public Criteria andTemplateIndexNotIn(List<Integer> values) {
            return notIn(templateIndex, values);
        }

        public Criteria andTemplateIndexBetween(Integer value1, Integer value2) {
            return between(templateIndex, value1, value2);
        }

        public Criteria andTemplateIndexNotBetween(Integer value1, Integer value2) {
            return notBetween(templateIndex, value1, value2);
        }
        public Criteria andTemplateNameIsNull() {
            return isNull(templateName);
        }

        public Criteria andTemplateNameIsNotNull() {
            return isNotNull(templateName);
        }

        public Criteria andTemplateNameEqualTo(String value) {
            return equalTo(templateName, value);
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            return notEqualTo(templateName, value);
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            return greaterThan(templateName, value);
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(templateName, value);
        }

        public Criteria andTemplateNameLessThan(String value) {
            return lessThan(templateName, value);
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(templateName, value);
        }

        public Criteria andTemplateNameLike(String value) {
            return like(templateName, value);
        }

        public Criteria andTemplateNameNotLike(String value) {
            return notLike(templateName, value);
        }

        public Criteria andTemplateNameIn(List<String> values) {
            return in(templateName, values);
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            return notIn(templateName, values);
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            return between(templateName, value1, value2);
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            return notBetween(templateName, value1, value2);
        }
        public Criteria andRuleTypeIsNull() {
            return isNull(ruleType);
        }

        public Criteria andRuleTypeIsNotNull() {
            return isNotNull(ruleType);
        }

        public Criteria andRuleTypeEqualTo(Integer value) {
            return equalTo(ruleType, value);
        }

        public Criteria andRuleTypeNotEqualTo(Integer value) {
            return notEqualTo(ruleType, value);
        }

        public Criteria andRuleTypeGreaterThan(Integer value) {
            return greaterThan(ruleType, value);
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(ruleType, value);
        }

        public Criteria andRuleTypeLessThan(Integer value) {
            return lessThan(ruleType, value);
        }

        public Criteria andRuleTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(ruleType, value);
        }

        public Criteria andRuleTypeIn(List<Integer> values) {
            return in(ruleType, values);
        }

        public Criteria andRuleTypeNotIn(List<Integer> values) {
            return notIn(ruleType, values);
        }

        public Criteria andRuleTypeBetween(Integer value1, Integer value2) {
            return between(ruleType, value1, value2);
        }

        public Criteria andRuleTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(ruleType, value1, value2);
        }
        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
    }
}