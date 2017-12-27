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
    public static EntityColumn templateName;
    public static EntityColumn ruleType;
    public static EntityColumn index;
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
        templateName = listMap.get("templateName");
        ruleType = listMap.get("ruleType");
        index = listMap.get("index");
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
    protected JdLogistTemplateExample.Criteria createCriteriaInternal() {
        return new JdLogistTemplateExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdLogistTemplateExample.Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public JdLogistTemplateExample.Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public JdLogistTemplateExample.Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public JdLogistTemplateExample.Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public JdLogistTemplateExample.Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public JdLogistTemplateExample.Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andIsFreeIsNull() {
            return isNull(isFree);
        }

        public JdLogistTemplateExample.Criteria andIsFreeIsNotNull() {
            return isNotNull(isFree);
        }

        public JdLogistTemplateExample.Criteria andIsFreeEqualTo(Integer value) {
            return equalTo(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeNotEqualTo(Integer value) {
            return notEqualTo(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeGreaterThan(Integer value) {
            return greaterThan(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeLessThan(Integer value) {
            return lessThan(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isFree, value);
        }

        public JdLogistTemplateExample.Criteria andIsFreeIn(List<Integer> values) {
            return in(isFree, values);
        }

        public JdLogistTemplateExample.Criteria andIsFreeNotIn(List<Integer> values) {
            return notIn(isFree, values);
        }

        public JdLogistTemplateExample.Criteria andIsFreeBetween(Integer value1, Integer value2) {
            return between(isFree, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andIsFreeNotBetween(Integer value1, Integer value2) {
            return notBetween(isFree, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andTemplateNameIsNull() {
            return isNull(templateName);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameIsNotNull() {
            return isNotNull(templateName);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameEqualTo(String value) {
            return equalTo(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameNotEqualTo(String value) {
            return notEqualTo(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameGreaterThan(String value) {
            return greaterThan(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameLessThan(String value) {
            return lessThan(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameLike(String value) {
            return like(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameNotLike(String value) {
            return notLike(templateName, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameIn(List<String> values) {
            return in(templateName, values);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameNotIn(List<String> values) {
            return notIn(templateName, values);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameBetween(String value1, String value2) {
            return between(templateName, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andTemplateNameNotBetween(String value1, String value2) {
            return notBetween(templateName, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andRuleTypeIsNull() {
            return isNull(ruleType);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeIsNotNull() {
            return isNotNull(ruleType);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeEqualTo(Integer value) {
            return equalTo(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeNotEqualTo(Integer value) {
            return notEqualTo(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeGreaterThan(Integer value) {
            return greaterThan(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeLessThan(Integer value) {
            return lessThan(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(ruleType, value);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeIn(List<Integer> values) {
            return in(ruleType, values);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeNotIn(List<Integer> values) {
            return notIn(ruleType, values);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeBetween(Integer value1, Integer value2) {
            return between(ruleType, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andRuleTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(ruleType, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andIndexIsNull() {
            return isNull(index);
        }

        public JdLogistTemplateExample.Criteria andIndexIsNotNull() {
            return isNotNull(index);
        }

        public JdLogistTemplateExample.Criteria andIndexEqualTo(Integer value) {
            return equalTo(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexNotEqualTo(Integer value) {
            return notEqualTo(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexGreaterThan(Integer value) {
            return greaterThan(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexLessThan(Integer value) {
            return lessThan(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(index, value);
        }

        public JdLogistTemplateExample.Criteria andIndexIn(List<Integer> values) {
            return in(index, values);
        }

        public JdLogistTemplateExample.Criteria andIndexNotIn(List<Integer> values) {
            return notIn(index, values);
        }

        public JdLogistTemplateExample.Criteria andIndexBetween(Integer value1, Integer value2) {
            return between(index, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andIndexNotBetween(Integer value1, Integer value2) {
            return notBetween(index, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public JdLogistTemplateExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public JdLogistTemplateExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public JdLogistTemplateExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public JdLogistTemplateExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public JdLogistTemplateExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public JdLogistTemplateExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public JdLogistTemplateExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
    }
}