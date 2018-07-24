package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.LogisticsTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class LogisticsTemplateExample extends SgExample<LogisticsTemplateExample.Criteria> {
    public static final Class<LogisticsTemplate> beanClass = LogisticsTemplate.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn senderId;
    public static EntityColumn fromTownId;
    public static EntityColumn fromCityId;
    public static EntityColumn fromProvId;
    public static EntityColumn templateId;
    public static EntityColumn title;
    public static EntityColumn free;
    public static EntityColumn enabled;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        senderId = listMap.get("senderId");
        fromTownId = listMap.get("fromTownId");
        fromCityId = listMap.get("fromCityId");
        fromProvId = listMap.get("fromProvId");
        templateId = listMap.get("templateId");
        title = listMap.get("title");
        free = listMap.get("free");
        enabled = listMap.get("enabled");
        }

    public LogisticsTemplateExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected LogisticsTemplateExample.Criteria createCriteriaInternal() {
        return new LogisticsTemplateExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public LogisticsTemplateExample.Criteria andSenderIdIsNull() {
            return isNull(senderId);
        }

        public LogisticsTemplateExample.Criteria andSenderIdIsNotNull() {
            return isNotNull(senderId);
        }

        public LogisticsTemplateExample.Criteria andSenderIdEqualTo(Long value) {
            return equalTo(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotEqualTo(Long value) {
            return notEqualTo(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdGreaterThan(Long value) {
            return greaterThan(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdLessThan(Long value) {
            return lessThan(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(senderId, value);
        }

        public LogisticsTemplateExample.Criteria andSenderIdIn(List<Long> values) {
            return in(senderId, values);
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotIn(List<Long> values) {
            return notIn(senderId, values);
        }

        public LogisticsTemplateExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            return between(senderId, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            return notBetween(senderId, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andFromTownIdIsNull() {
            return isNull(fromTownId);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdIsNotNull() {
            return isNotNull(fromTownId);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdEqualTo(Long value) {
            return equalTo(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotEqualTo(Long value) {
            return notEqualTo(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdGreaterThan(Long value) {
            return greaterThan(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdLessThan(Long value) {
            return lessThan(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromTownId, value);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdIn(List<Long> values) {
            return in(fromTownId, values);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotIn(List<Long> values) {
            return notIn(fromTownId, values);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdBetween(Long value1, Long value2) {
            return between(fromTownId, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotBetween(Long value1, Long value2) {
            return notBetween(fromTownId, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andFromCityIdIsNull() {
            return isNull(fromCityId);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdIsNotNull() {
            return isNotNull(fromCityId);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdEqualTo(Long value) {
            return equalTo(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotEqualTo(Long value) {
            return notEqualTo(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdGreaterThan(Long value) {
            return greaterThan(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdLessThan(Long value) {
            return lessThan(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromCityId, value);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdIn(List<Long> values) {
            return in(fromCityId, values);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotIn(List<Long> values) {
            return notIn(fromCityId, values);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdBetween(Long value1, Long value2) {
            return between(fromCityId, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotBetween(Long value1, Long value2) {
            return notBetween(fromCityId, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andFromProvIdIsNull() {
            return isNull(fromProvId);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdIsNotNull() {
            return isNotNull(fromProvId);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdEqualTo(Long value) {
            return equalTo(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotEqualTo(Long value) {
            return notEqualTo(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdGreaterThan(Long value) {
            return greaterThan(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdLessThan(Long value) {
            return lessThan(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromProvId, value);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdIn(List<Long> values) {
            return in(fromProvId, values);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotIn(List<Long> values) {
            return notIn(fromProvId, values);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdBetween(Long value1, Long value2) {
            return between(fromProvId, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotBetween(Long value1, Long value2) {
            return notBetween(fromProvId, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdEqualTo(Long value) {
            return equalTo(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotEqualTo(Long value) {
            return notEqualTo(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdGreaterThan(Long value) {
            return greaterThan(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdLessThan(Long value) {
            return lessThan(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdIn(List<Long> values) {
            return in(templateId, values);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotIn(List<Long> values) {
            return notIn(templateId, values);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            return between(templateId, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(templateId, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public LogisticsTemplateExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public LogisticsTemplateExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public LogisticsTemplateExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public LogisticsTemplateExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public LogisticsTemplateExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andFreeIsNull() {
            return isNull(free);
        }

        public LogisticsTemplateExample.Criteria andFreeIsNotNull() {
            return isNotNull(free);
        }

        public LogisticsTemplateExample.Criteria andFreeEqualTo(Boolean value) {
            return equalTo(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeNotEqualTo(Boolean value) {
            return notEqualTo(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeGreaterThan(Boolean value) {
            return greaterThan(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeLessThan(Boolean value) {
            return lessThan(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(free, value);
        }

        public LogisticsTemplateExample.Criteria andFreeIn(List<Boolean> values) {
            return in(free, values);
        }

        public LogisticsTemplateExample.Criteria andFreeNotIn(List<Boolean> values) {
            return notIn(free, values);
        }

        public LogisticsTemplateExample.Criteria andFreeBetween(Boolean value1, Boolean value2) {
            return between(free, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andFreeNotBetween(Boolean value1, Boolean value2) {
            return notBetween(free, value1, value2);
        }
        public LogisticsTemplateExample.Criteria andEnabledIsNull() {
            return isNull(enabled);
        }

        public LogisticsTemplateExample.Criteria andEnabledIsNotNull() {
            return isNotNull(enabled);
        }

        public LogisticsTemplateExample.Criteria andEnabledEqualTo(Boolean value) {
            return equalTo(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledNotEqualTo(Boolean value) {
            return notEqualTo(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledGreaterThan(Boolean value) {
            return greaterThan(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledLessThan(Boolean value) {
            return lessThan(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(enabled, value);
        }

        public LogisticsTemplateExample.Criteria andEnabledIn(List<Boolean> values) {
            return in(enabled, values);
        }

        public LogisticsTemplateExample.Criteria andEnabledNotIn(List<Boolean> values) {
            return notIn(enabled, values);
        }

        public LogisticsTemplateExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            return between(enabled, value1, value2);
        }

        public LogisticsTemplateExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(enabled, value1, value2);
        }
    }
}
