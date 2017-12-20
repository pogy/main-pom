package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActiveDrawPem;

import java.util.*;
public class ActiveDrawPemExample extends SgExample<ActiveDrawPemExample.Criteria> {
    public static final Class<ActiveDrawPem> beanClass = ActiveDrawPem.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn startTime;
    public static EntityColumn term;
    public static EntityColumn id;
    public static EntityColumn info;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        startTime = listMap.get("startTime");
        term = listMap.get("term");
        id = listMap.get("id");
        info = listMap.get("info");
        }

    public ActiveDrawPemExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActiveDrawPemExample.Criteria createCriteriaInternal() {
        return new ActiveDrawPemExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ActiveDrawPemExample.Criteria andStartTimeIsNull() {
            return isNull(startTime);
        }

        public ActiveDrawPemExample.Criteria andStartTimeIsNotNull() {
            return isNotNull(startTime);
        }

        public ActiveDrawPemExample.Criteria andStartTimeEqualTo(Date value) {
            return equalTo(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotEqualTo(Date value) {
            return notEqualTo(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeGreaterThan(Date value) {
            return greaterThan(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeLessThan(Date value) {
            return lessThan(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startTime, value);
        }

        public ActiveDrawPemExample.Criteria andStartTimeIn(List<Date> values) {
            return in(startTime, values);
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotIn(List<Date> values) {
            return notIn(startTime, values);
        }

        public ActiveDrawPemExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            return between(startTime, value1, value2);
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            return notBetween(startTime, value1, value2);
        }
        public ActiveDrawPemExample.Criteria andTermIsNull() {
            return isNull(term);
        }

        public ActiveDrawPemExample.Criteria andTermIsNotNull() {
            return isNotNull(term);
        }

        public ActiveDrawPemExample.Criteria andTermEqualTo(Integer value) {
            return equalTo(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermNotEqualTo(Integer value) {
            return notEqualTo(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermGreaterThan(Integer value) {
            return greaterThan(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermLessThan(Integer value) {
            return lessThan(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(term, value);
        }

        public ActiveDrawPemExample.Criteria andTermIn(List<Integer> values) {
            return in(term, values);
        }

        public ActiveDrawPemExample.Criteria andTermNotIn(List<Integer> values) {
            return notIn(term, values);
        }

        public ActiveDrawPemExample.Criteria andTermBetween(Integer value1, Integer value2) {
            return between(term, value1, value2);
        }

        public ActiveDrawPemExample.Criteria andTermNotBetween(Integer value1, Integer value2) {
            return notBetween(term, value1, value2);
        }
        public ActiveDrawPemExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ActiveDrawPemExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ActiveDrawPemExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ActiveDrawPemExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ActiveDrawPemExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ActiveDrawPemExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ActiveDrawPemExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ActiveDrawPemExample.Criteria andInfoIsNull() {
            return isNull(info);
        }

        public ActiveDrawPemExample.Criteria andInfoIsNotNull() {
            return isNotNull(info);
        }

        public ActiveDrawPemExample.Criteria andInfoEqualTo(String value) {
            return equalTo(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoNotEqualTo(String value) {
            return notEqualTo(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoGreaterThan(String value) {
            return greaterThan(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoLessThan(String value) {
            return lessThan(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoLike(String value) {
            return like(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoNotLike(String value) {
            return notLike(info, value);
        }

        public ActiveDrawPemExample.Criteria andInfoIn(List<String> values) {
            return in(info, values);
        }

        public ActiveDrawPemExample.Criteria andInfoNotIn(List<String> values) {
            return notIn(info, values);
        }

        public ActiveDrawPemExample.Criteria andInfoBetween(String value1, String value2) {
            return between(info, value1, value2);
        }

        public ActiveDrawPemExample.Criteria andInfoNotBetween(String value1, String value2) {
            return notBetween(info, value1, value2);
        }
    }
}
