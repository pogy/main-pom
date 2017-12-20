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
    protected DataDictionaryValueExample.Criteria createCriteriaInternal() {
        return new DataDictionaryValueExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DataDictionaryValueExample.Criteria andDdvIdIsNull() {
            return isNull(ddvId);
        }

        public DataDictionaryValueExample.Criteria andDdvIdIsNotNull() {
            return isNotNull(ddvId);
        }

        public DataDictionaryValueExample.Criteria andDdvIdEqualTo(Long value) {
            return equalTo(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdNotEqualTo(Long value) {
            return notEqualTo(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdGreaterThan(Long value) {
            return greaterThan(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdLessThan(Long value) {
            return lessThan(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ddvId, value);
        }

        public DataDictionaryValueExample.Criteria andDdvIdIn(List<Long> values) {
            return in(ddvId, values);
        }

        public DataDictionaryValueExample.Criteria andDdvIdNotIn(List<Long> values) {
            return notIn(ddvId, values);
        }

        public DataDictionaryValueExample.Criteria andDdvIdBetween(Long value1, Long value2) {
            return between(ddvId, value1, value2);
        }

        public DataDictionaryValueExample.Criteria andDdvIdNotBetween(Long value1, Long value2) {
            return notBetween(ddvId, value1, value2);
        }
        public DataDictionaryValueExample.Criteria andDdIdIsNull() {
            return isNull(ddId);
        }

        public DataDictionaryValueExample.Criteria andDdIdIsNotNull() {
            return isNotNull(ddId);
        }

        public DataDictionaryValueExample.Criteria andDdIdEqualTo(Long value) {
            return equalTo(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdNotEqualTo(Long value) {
            return notEqualTo(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdGreaterThan(Long value) {
            return greaterThan(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdLessThan(Long value) {
            return lessThan(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ddId, value);
        }

        public DataDictionaryValueExample.Criteria andDdIdIn(List<Long> values) {
            return in(ddId, values);
        }

        public DataDictionaryValueExample.Criteria andDdIdNotIn(List<Long> values) {
            return notIn(ddId, values);
        }

        public DataDictionaryValueExample.Criteria andDdIdBetween(Long value1, Long value2) {
            return between(ddId, value1, value2);
        }

        public DataDictionaryValueExample.Criteria andDdIdNotBetween(Long value1, Long value2) {
            return notBetween(ddId, value1, value2);
        }
        public DataDictionaryValueExample.Criteria andDataDictionaryValueIsNull() {
            return isNull(dataDictionaryValue);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueIsNotNull() {
            return isNotNull(dataDictionaryValue);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueEqualTo(String value) {
            return equalTo(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueNotEqualTo(String value) {
            return notEqualTo(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueGreaterThan(String value) {
            return greaterThan(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueLessThan(String value) {
            return lessThan(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueLike(String value) {
            return like(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueNotLike(String value) {
            return notLike(dataDictionaryValue, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueIn(List<String> values) {
            return in(dataDictionaryValue, values);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueNotIn(List<String> values) {
            return notIn(dataDictionaryValue, values);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueBetween(String value1, String value2) {
            return between(dataDictionaryValue, value1, value2);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryValue, value1, value2);
        }
        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkIsNull() {
            return isNull(dataDictionaryValueRemark);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkIsNotNull() {
            return isNotNull(dataDictionaryValueRemark);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkEqualTo(String value) {
            return equalTo(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkNotEqualTo(String value) {
            return notEqualTo(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkGreaterThan(String value) {
            return greaterThan(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkLessThan(String value) {
            return lessThan(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkLike(String value) {
            return like(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkNotLike(String value) {
            return notLike(dataDictionaryValueRemark, value);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkIn(List<String> values) {
            return in(dataDictionaryValueRemark, values);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkNotIn(List<String> values) {
            return notIn(dataDictionaryValueRemark, values);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkBetween(String value1, String value2) {
            return between(dataDictionaryValueRemark, value1, value2);
        }

        public DataDictionaryValueExample.Criteria andDataDictionaryValueRemarkNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryValueRemark, value1, value2);
        }
    }
}
