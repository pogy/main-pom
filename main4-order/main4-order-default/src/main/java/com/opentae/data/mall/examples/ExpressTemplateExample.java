package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ExpressTemplate;

import java.util.*;
public class ExpressTemplateExample extends SgExample<ExpressTemplateExample.Criteria> {
    public static final Class<ExpressTemplate> beanClass = ExpressTemplate.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn templateStatus;
    public static EntityColumn fromTownId;
    public static EntityColumn fromCityId;
    public static EntityColumn fromProvId;
    public static EntityColumn templateTitle;
    public static EntityColumn attribute;
    public static EntityColumn expressCompanyId;
    public static EntityColumn free;
    public static EntityColumn tId;
    public static EntityColumn enabled;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        templateStatus = listMap.get("templateStatus");
        fromTownId = listMap.get("fromTownId");
        fromCityId = listMap.get("fromCityId");
        fromProvId = listMap.get("fromProvId");
        templateTitle = listMap.get("templateTitle");
        attribute = listMap.get("attribute");
        expressCompanyId = listMap.get("expressCompanyId");
        free = listMap.get("free");
        tId = listMap.get("tId");
        enabled = listMap.get("enabled");
        }

    public ExpressTemplateExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ExpressTemplateExample.Criteria createCriteriaInternal() {
        return new ExpressTemplateExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusIsNull() {
            return isNull(templateStatus);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusIsNotNull() {
            return isNotNull(templateStatus);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusEqualTo(Integer value) {
            return equalTo(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusNotEqualTo(Integer value) {
            return notEqualTo(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusGreaterThan(Integer value) {
            return greaterThan(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusLessThan(Integer value) {
            return lessThan(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(templateStatus, value);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusIn(List<Integer> values) {
            return in(templateStatus, values);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusNotIn(List<Integer> values) {
            return notIn(templateStatus, values);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusBetween(Integer value1, Integer value2) {
            return between(templateStatus, value1, value2);
        }

        public ExpressTemplateExample.Criteria andTemplateStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(templateStatus, value1, value2);
        }
        public ExpressTemplateExample.Criteria andFromTownIdIsNull() {
            return isNull(fromTownId);
        }

        public ExpressTemplateExample.Criteria andFromTownIdIsNotNull() {
            return isNotNull(fromTownId);
        }

        public ExpressTemplateExample.Criteria andFromTownIdEqualTo(Long value) {
            return equalTo(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdNotEqualTo(Long value) {
            return notEqualTo(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdGreaterThan(Long value) {
            return greaterThan(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdLessThan(Long value) {
            return lessThan(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromTownId, value);
        }

        public ExpressTemplateExample.Criteria andFromTownIdIn(List<Long> values) {
            return in(fromTownId, values);
        }

        public ExpressTemplateExample.Criteria andFromTownIdNotIn(List<Long> values) {
            return notIn(fromTownId, values);
        }

        public ExpressTemplateExample.Criteria andFromTownIdBetween(Long value1, Long value2) {
            return between(fromTownId, value1, value2);
        }

        public ExpressTemplateExample.Criteria andFromTownIdNotBetween(Long value1, Long value2) {
            return notBetween(fromTownId, value1, value2);
        }
        public ExpressTemplateExample.Criteria andFromCityIdIsNull() {
            return isNull(fromCityId);
        }

        public ExpressTemplateExample.Criteria andFromCityIdIsNotNull() {
            return isNotNull(fromCityId);
        }

        public ExpressTemplateExample.Criteria andFromCityIdEqualTo(Long value) {
            return equalTo(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdNotEqualTo(Long value) {
            return notEqualTo(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdGreaterThan(Long value) {
            return greaterThan(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdLessThan(Long value) {
            return lessThan(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromCityId, value);
        }

        public ExpressTemplateExample.Criteria andFromCityIdIn(List<Long> values) {
            return in(fromCityId, values);
        }

        public ExpressTemplateExample.Criteria andFromCityIdNotIn(List<Long> values) {
            return notIn(fromCityId, values);
        }

        public ExpressTemplateExample.Criteria andFromCityIdBetween(Long value1, Long value2) {
            return between(fromCityId, value1, value2);
        }

        public ExpressTemplateExample.Criteria andFromCityIdNotBetween(Long value1, Long value2) {
            return notBetween(fromCityId, value1, value2);
        }
        public ExpressTemplateExample.Criteria andFromProvIdIsNull() {
            return isNull(fromProvId);
        }

        public ExpressTemplateExample.Criteria andFromProvIdIsNotNull() {
            return isNotNull(fromProvId);
        }

        public ExpressTemplateExample.Criteria andFromProvIdEqualTo(Long value) {
            return equalTo(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdNotEqualTo(Long value) {
            return notEqualTo(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdGreaterThan(Long value) {
            return greaterThan(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdLessThan(Long value) {
            return lessThan(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromProvId, value);
        }

        public ExpressTemplateExample.Criteria andFromProvIdIn(List<Long> values) {
            return in(fromProvId, values);
        }

        public ExpressTemplateExample.Criteria andFromProvIdNotIn(List<Long> values) {
            return notIn(fromProvId, values);
        }

        public ExpressTemplateExample.Criteria andFromProvIdBetween(Long value1, Long value2) {
            return between(fromProvId, value1, value2);
        }

        public ExpressTemplateExample.Criteria andFromProvIdNotBetween(Long value1, Long value2) {
            return notBetween(fromProvId, value1, value2);
        }
        public ExpressTemplateExample.Criteria andTemplateTitleIsNull() {
            return isNull(templateTitle);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleIsNotNull() {
            return isNotNull(templateTitle);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleEqualTo(String value) {
            return equalTo(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleNotEqualTo(String value) {
            return notEqualTo(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleGreaterThan(String value) {
            return greaterThan(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleLessThan(String value) {
            return lessThan(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleLike(String value) {
            return like(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleNotLike(String value) {
            return notLike(templateTitle, value);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleIn(List<String> values) {
            return in(templateTitle, values);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleNotIn(List<String> values) {
            return notIn(templateTitle, values);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleBetween(String value1, String value2) {
            return between(templateTitle, value1, value2);
        }

        public ExpressTemplateExample.Criteria andTemplateTitleNotBetween(String value1, String value2) {
            return notBetween(templateTitle, value1, value2);
        }
        public ExpressTemplateExample.Criteria andAttributeIsNull() {
            return isNull(attribute);
        }

        public ExpressTemplateExample.Criteria andAttributeIsNotNull() {
            return isNotNull(attribute);
        }

        public ExpressTemplateExample.Criteria andAttributeEqualTo(String value) {
            return equalTo(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeNotEqualTo(String value) {
            return notEqualTo(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeGreaterThan(String value) {
            return greaterThan(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeLessThan(String value) {
            return lessThan(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeLike(String value) {
            return like(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeNotLike(String value) {
            return notLike(attribute, value);
        }

        public ExpressTemplateExample.Criteria andAttributeIn(List<String> values) {
            return in(attribute, values);
        }

        public ExpressTemplateExample.Criteria andAttributeNotIn(List<String> values) {
            return notIn(attribute, values);
        }

        public ExpressTemplateExample.Criteria andAttributeBetween(String value1, String value2) {
            return between(attribute, value1, value2);
        }

        public ExpressTemplateExample.Criteria andAttributeNotBetween(String value1, String value2) {
            return notBetween(attribute, value1, value2);
        }
        public ExpressTemplateExample.Criteria andExpressCompanyIdIsNull() {
            return isNull(expressCompanyId);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdIsNotNull() {
            return isNotNull(expressCompanyId);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdEqualTo(Long value) {
            return equalTo(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdNotEqualTo(Long value) {
            return notEqualTo(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdGreaterThan(Long value) {
            return greaterThan(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdLessThan(Long value) {
            return lessThan(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressCompanyId, value);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdIn(List<Long> values) {
            return in(expressCompanyId, values);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdNotIn(List<Long> values) {
            return notIn(expressCompanyId, values);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdBetween(Long value1, Long value2) {
            return between(expressCompanyId, value1, value2);
        }

        public ExpressTemplateExample.Criteria andExpressCompanyIdNotBetween(Long value1, Long value2) {
            return notBetween(expressCompanyId, value1, value2);
        }
        public ExpressTemplateExample.Criteria andFreeIsNull() {
            return isNull(free);
        }

        public ExpressTemplateExample.Criteria andFreeIsNotNull() {
            return isNotNull(free);
        }

        public ExpressTemplateExample.Criteria andFreeEqualTo(Integer value) {
            return equalTo(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeNotEqualTo(Integer value) {
            return notEqualTo(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeGreaterThan(Integer value) {
            return greaterThan(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeLessThan(Integer value) {
            return lessThan(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(free, value);
        }

        public ExpressTemplateExample.Criteria andFreeIn(List<Integer> values) {
            return in(free, values);
        }

        public ExpressTemplateExample.Criteria andFreeNotIn(List<Integer> values) {
            return notIn(free, values);
        }

        public ExpressTemplateExample.Criteria andFreeBetween(Integer value1, Integer value2) {
            return between(free, value1, value2);
        }

        public ExpressTemplateExample.Criteria andFreeNotBetween(Integer value1, Integer value2) {
            return notBetween(free, value1, value2);
        }
        public ExpressTemplateExample.Criteria andTIdIsNull() {
            return isNull(tId);
        }

        public ExpressTemplateExample.Criteria andTIdIsNotNull() {
            return isNotNull(tId);
        }

        public ExpressTemplateExample.Criteria andTIdEqualTo(Long value) {
            return equalTo(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdNotEqualTo(Long value) {
            return notEqualTo(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdGreaterThan(Long value) {
            return greaterThan(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdLessThan(Long value) {
            return lessThan(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tId, value);
        }

        public ExpressTemplateExample.Criteria andTIdIn(List<Long> values) {
            return in(tId, values);
        }

        public ExpressTemplateExample.Criteria andTIdNotIn(List<Long> values) {
            return notIn(tId, values);
        }

        public ExpressTemplateExample.Criteria andTIdBetween(Long value1, Long value2) {
            return between(tId, value1, value2);
        }

        public ExpressTemplateExample.Criteria andTIdNotBetween(Long value1, Long value2) {
            return notBetween(tId, value1, value2);
        }
        public ExpressTemplateExample.Criteria andEnabledIsNull() {
            return isNull(enabled);
        }

        public ExpressTemplateExample.Criteria andEnabledIsNotNull() {
            return isNotNull(enabled);
        }

        public ExpressTemplateExample.Criteria andEnabledEqualTo(Integer value) {
            return equalTo(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledNotEqualTo(Integer value) {
            return notEqualTo(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledGreaterThan(Integer value) {
            return greaterThan(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledLessThan(Integer value) {
            return lessThan(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(enabled, value);
        }

        public ExpressTemplateExample.Criteria andEnabledIn(List<Integer> values) {
            return in(enabled, values);
        }

        public ExpressTemplateExample.Criteria andEnabledNotIn(List<Integer> values) {
            return notIn(enabled, values);
        }

        public ExpressTemplateExample.Criteria andEnabledBetween(Integer value1, Integer value2) {
            return between(enabled, value1, value2);
        }

        public ExpressTemplateExample.Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            return notBetween(enabled, value1, value2);
        }
    }
}