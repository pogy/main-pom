package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SpreadTerm;

import java.util.*;
public class SpreadTermExample extends SgExample<SpreadTermExample.Criteria> {
    public static final Class<SpreadTerm> beanClass = SpreadTerm.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn termId;
    public static EntityColumn manOrWoman;
    public static EntityColumn startTime;
    public static EntityColumn endTime;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        termId = listMap.get("termId");
        manOrWoman = listMap.get("manOrWoman");
        startTime = listMap.get("startTime");
        endTime = listMap.get("endTime");
        type = listMap.get("type");
        }

    public SpreadTermExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SpreadTermExample.Criteria createCriteriaInternal() {
        return new SpreadTermExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SpreadTermExample.Criteria andTermIdIsNull() {
            return isNull(termId);
        }

        public SpreadTermExample.Criteria andTermIdIsNotNull() {
            return isNotNull(termId);
        }

        public SpreadTermExample.Criteria andTermIdEqualTo(Long value) {
            return equalTo(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdNotEqualTo(Long value) {
            return notEqualTo(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdGreaterThan(Long value) {
            return greaterThan(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdLessThan(Long value) {
            return lessThan(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(termId, value);
        }

        public SpreadTermExample.Criteria andTermIdIn(List<Long> values) {
            return in(termId, values);
        }

        public SpreadTermExample.Criteria andTermIdNotIn(List<Long> values) {
            return notIn(termId, values);
        }

        public SpreadTermExample.Criteria andTermIdBetween(Long value1, Long value2) {
            return between(termId, value1, value2);
        }

        public SpreadTermExample.Criteria andTermIdNotBetween(Long value1, Long value2) {
            return notBetween(termId, value1, value2);
        }
        public SpreadTermExample.Criteria andManOrWomanIsNull() {
            return isNull(manOrWoman);
        }

        public SpreadTermExample.Criteria andManOrWomanIsNotNull() {
            return isNotNull(manOrWoman);
        }

        public SpreadTermExample.Criteria andManOrWomanEqualTo(String value) {
            return equalTo(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanNotEqualTo(String value) {
            return notEqualTo(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanGreaterThan(String value) {
            return greaterThan(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanLessThan(String value) {
            return lessThan(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanLike(String value) {
            return like(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanNotLike(String value) {
            return notLike(manOrWoman, value);
        }

        public SpreadTermExample.Criteria andManOrWomanIn(List<String> values) {
            return in(manOrWoman, values);
        }

        public SpreadTermExample.Criteria andManOrWomanNotIn(List<String> values) {
            return notIn(manOrWoman, values);
        }

        public SpreadTermExample.Criteria andManOrWomanBetween(String value1, String value2) {
            return between(manOrWoman, value1, value2);
        }

        public SpreadTermExample.Criteria andManOrWomanNotBetween(String value1, String value2) {
            return notBetween(manOrWoman, value1, value2);
        }
        public SpreadTermExample.Criteria andStartTimeIsNull() {
            return isNull(startTime);
        }

        public SpreadTermExample.Criteria andStartTimeIsNotNull() {
            return isNotNull(startTime);
        }

        public SpreadTermExample.Criteria andStartTimeEqualTo(Date value) {
            return equalTo(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeNotEqualTo(Date value) {
            return notEqualTo(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeGreaterThan(Date value) {
            return greaterThan(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeLessThan(Date value) {
            return lessThan(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startTime, value);
        }

        public SpreadTermExample.Criteria andStartTimeIn(List<Date> values) {
            return in(startTime, values);
        }

        public SpreadTermExample.Criteria andStartTimeNotIn(List<Date> values) {
            return notIn(startTime, values);
        }

        public SpreadTermExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            return between(startTime, value1, value2);
        }

        public SpreadTermExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            return notBetween(startTime, value1, value2);
        }
        public SpreadTermExample.Criteria andEndTimeIsNull() {
            return isNull(endTime);
        }

        public SpreadTermExample.Criteria andEndTimeIsNotNull() {
            return isNotNull(endTime);
        }

        public SpreadTermExample.Criteria andEndTimeEqualTo(Date value) {
            return equalTo(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeNotEqualTo(Date value) {
            return notEqualTo(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeGreaterThan(Date value) {
            return greaterThan(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeLessThan(Date value) {
            return lessThan(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endTime, value);
        }

        public SpreadTermExample.Criteria andEndTimeIn(List<Date> values) {
            return in(endTime, values);
        }

        public SpreadTermExample.Criteria andEndTimeNotIn(List<Date> values) {
            return notIn(endTime, values);
        }

        public SpreadTermExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            return between(endTime, value1, value2);
        }

        public SpreadTermExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            return notBetween(endTime, value1, value2);
        }
        public SpreadTermExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public SpreadTermExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public SpreadTermExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public SpreadTermExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public SpreadTermExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public SpreadTermExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public SpreadTermExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public SpreadTermExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public SpreadTermExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public SpreadTermExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public SpreadTermExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public SpreadTermExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}