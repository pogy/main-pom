package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DataDictionaryValue;

import java.util.*;
public class DataDictionaryValueExample extends SgExample<DataDictionaryValueExample.Criteria> {
    public static final Class<DataDictionaryValue> beanClass = DataDictionaryValue.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn ddvId;
    public static EntityColumn ddId;
    public static EntityColumn dataDictionaryValue;
    public static EntityColumn dataDictionaryValueRemark;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        ddvId = listMap.get("ddvId");
        ddId = listMap.get("ddId");
        dataDictionaryValue = listMap.get("dataDictionaryValue");
        dataDictionaryValueRemark = listMap.get("dataDictionaryValueRemark");
    }

    public DataDictionaryValueExample() {
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

        public Criteria andDdvIdIsNull() {
            return isNull(ddvId);
        }

        public Criteria andDdvIdIsNotNull() {
            return isNotNull(ddvId);
        }

        public Criteria andDdvIdEqualTo(Long value) {
            return equalTo(ddvId, value);
        }

        public Criteria andDdvIdNotEqualTo(Long value) {
            return notEqualTo(ddvId, value);
        }

        public Criteria andDdvIdGreaterThan(Long value) {
            return greaterThan(ddvId, value);
        }

        public Criteria andDdvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ddvId, value);
        }

        public Criteria andDdvIdLessThan(Long value) {
            return lessThan(ddvId, value);
        }

        public Criteria andDdvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ddvId, value);
        }

        public Criteria andDdvIdIn(List<Long> values) {
            return in(ddvId, values);
        }

        public Criteria andDdvIdNotIn(List<Long> values) {
            return notIn(ddvId, values);
        }

        public Criteria andDdvIdBetween(Long value1, Long value2) {
            return between(ddvId, value1, value2);
        }

        public Criteria andDdvIdNotBetween(Long value1, Long value2) {
            return notBetween(ddvId, value1, value2);
        }
        public Criteria andDdIdIsNull() {
            return isNull(ddId);
        }

        public Criteria andDdIdIsNotNull() {
            return isNotNull(ddId);
        }

        public Criteria andDdIdEqualTo(Long value) {
            return equalTo(ddId, value);
        }

        public Criteria andDdIdNotEqualTo(Long value) {
            return notEqualTo(ddId, value);
        }

        public Criteria andDdIdGreaterThan(Long value) {
            return greaterThan(ddId, value);
        }

        public Criteria andDdIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ddId, value);
        }

        public Criteria andDdIdLessThan(Long value) {
            return lessThan(ddId, value);
        }

        public Criteria andDdIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ddId, value);
        }

        public Criteria andDdIdIn(List<Long> values) {
            return in(ddId, values);
        }

        public Criteria andDdIdNotIn(List<Long> values) {
            return notIn(ddId, values);
        }

        public Criteria andDdIdBetween(Long value1, Long value2) {
            return between(ddId, value1, value2);
        }

        public Criteria andDdIdNotBetween(Long value1, Long value2) {
            return notBetween(ddId, value1, value2);
        }
        public Criteria andDataDictionaryValueIsNull() {
            return isNull(dataDictionaryValue);
        }

        public Criteria andDataDictionaryValueIsNotNull() {
            return isNotNull(dataDictionaryValue);
        }

        public Criteria andDataDictionaryValueEqualTo(String value) {
            return equalTo(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueNotEqualTo(String value) {
            return notEqualTo(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueGreaterThan(String value) {
            return greaterThan(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueLessThan(String value) {
            return lessThan(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueLike(String value) {
            return like(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueNotLike(String value) {
            return notLike(dataDictionaryValue, value);
        }

        public Criteria andDataDictionaryValueIn(List<String> values) {
            return in(dataDictionaryValue, values);
        }

        public Criteria andDataDictionaryValueNotIn(List<String> values) {
            return notIn(dataDictionaryValue, values);
        }

        public Criteria andDataDictionaryValueBetween(String value1, String value2) {
            return between(dataDictionaryValue, value1, value2);
        }

        public Criteria andDataDictionaryValueNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryValue, value1, value2);
        }
        public Criteria andDataDictionaryValueRemarkIsNull() {
            return isNull(dataDictionaryValueRemark);
        }

        public Criteria andDataDictionaryValueRemarkIsNotNull() {
            return isNotNull(dataDictionaryValueRemark);
        }

        public Criteria andDataDictionaryValueRemarkEqualTo(String value) {
            return equalTo(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkNotEqualTo(String value) {
            return notEqualTo(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkGreaterThan(String value) {
            return greaterThan(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkLessThan(String value) {
            return lessThan(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkLike(String value) {
            return like(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkNotLike(String value) {
            return notLike(dataDictionaryValueRemark, value);
        }

        public Criteria andDataDictionaryValueRemarkIn(List<String> values) {
            return in(dataDictionaryValueRemark, values);
        }

        public Criteria andDataDictionaryValueRemarkNotIn(List<String> values) {
            return notIn(dataDictionaryValueRemark, values);
        }

        public Criteria andDataDictionaryValueRemarkBetween(String value1, String value2) {
            return between(dataDictionaryValueRemark, value1, value2);
        }

        public Criteria andDataDictionaryValueRemarkNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryValueRemark, value1, value2);
        }
    }
}
