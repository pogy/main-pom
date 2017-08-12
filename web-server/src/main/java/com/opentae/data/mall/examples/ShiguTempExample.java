package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguTemp;

import java.util.*;
public class ShiguTempExample extends SgExample<ShiguTempExample.Criteria> {
    public static final Class<ShiguTemp> beanClass = ShiguTemp.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn key1;
    public static EntityColumn key2;
    public static EntityColumn flag;
    public static EntityColumn key3;
    public static EntityColumn id;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        key1 = listMap.get("key1");
        key2 = listMap.get("key2");
        flag = listMap.get("flag");
        key3 = listMap.get("key3");
        id = listMap.get("id");
        }

    public ShiguTempExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguTempExample.Criteria createCriteriaInternal() {
        return new ShiguTempExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguTempExample.Criteria andKey1IsNull() {
            return isNull(key1);
        }

        public ShiguTempExample.Criteria andKey1IsNotNull() {
            return isNotNull(key1);
        }

        public ShiguTempExample.Criteria andKey1EqualTo(String value) {
            return equalTo(key1, value);
        }

        public ShiguTempExample.Criteria andKey1NotEqualTo(String value) {
            return notEqualTo(key1, value);
        }

        public ShiguTempExample.Criteria andKey1GreaterThan(String value) {
            return greaterThan(key1, value);
        }

        public ShiguTempExample.Criteria andKey1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(key1, value);
        }

        public ShiguTempExample.Criteria andKey1LessThan(String value) {
            return lessThan(key1, value);
        }

        public ShiguTempExample.Criteria andKey1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(key1, value);
        }

        public ShiguTempExample.Criteria andKey1Like(String value) {
            return like(key1, value);
        }

        public ShiguTempExample.Criteria andKey1NotLike(String value) {
            return notLike(key1, value);
        }

        public ShiguTempExample.Criteria andKey1In(List<String> values) {
            return in(key1, values);
        }

        public ShiguTempExample.Criteria andKey1NotIn(List<String> values) {
            return notIn(key1, values);
        }

        public ShiguTempExample.Criteria andKey1Between(String value1, String value2) {
            return between(key1, value1, value2);
        }

        public ShiguTempExample.Criteria andKey1NotBetween(String value1, String value2) {
            return notBetween(key1, value1, value2);
        }
        public ShiguTempExample.Criteria andKey2IsNull() {
            return isNull(key2);
        }

        public ShiguTempExample.Criteria andKey2IsNotNull() {
            return isNotNull(key2);
        }

        public ShiguTempExample.Criteria andKey2EqualTo(String value) {
            return equalTo(key2, value);
        }

        public ShiguTempExample.Criteria andKey2NotEqualTo(String value) {
            return notEqualTo(key2, value);
        }

        public ShiguTempExample.Criteria andKey2GreaterThan(String value) {
            return greaterThan(key2, value);
        }

        public ShiguTempExample.Criteria andKey2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(key2, value);
        }

        public ShiguTempExample.Criteria andKey2LessThan(String value) {
            return lessThan(key2, value);
        }

        public ShiguTempExample.Criteria andKey2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(key2, value);
        }

        public ShiguTempExample.Criteria andKey2Like(String value) {
            return like(key2, value);
        }

        public ShiguTempExample.Criteria andKey2NotLike(String value) {
            return notLike(key2, value);
        }

        public ShiguTempExample.Criteria andKey2In(List<String> values) {
            return in(key2, values);
        }

        public ShiguTempExample.Criteria andKey2NotIn(List<String> values) {
            return notIn(key2, values);
        }

        public ShiguTempExample.Criteria andKey2Between(String value1, String value2) {
            return between(key2, value1, value2);
        }

        public ShiguTempExample.Criteria andKey2NotBetween(String value1, String value2) {
            return notBetween(key2, value1, value2);
        }
        public ShiguTempExample.Criteria andFlagIsNull() {
            return isNull(flag);
        }

        public ShiguTempExample.Criteria andFlagIsNotNull() {
            return isNotNull(flag);
        }

        public ShiguTempExample.Criteria andFlagEqualTo(String value) {
            return equalTo(flag, value);
        }

        public ShiguTempExample.Criteria andFlagNotEqualTo(String value) {
            return notEqualTo(flag, value);
        }

        public ShiguTempExample.Criteria andFlagGreaterThan(String value) {
            return greaterThan(flag, value);
        }

        public ShiguTempExample.Criteria andFlagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(flag, value);
        }

        public ShiguTempExample.Criteria andFlagLessThan(String value) {
            return lessThan(flag, value);
        }

        public ShiguTempExample.Criteria andFlagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(flag, value);
        }

        public ShiguTempExample.Criteria andFlagLike(String value) {
            return like(flag, value);
        }

        public ShiguTempExample.Criteria andFlagNotLike(String value) {
            return notLike(flag, value);
        }

        public ShiguTempExample.Criteria andFlagIn(List<String> values) {
            return in(flag, values);
        }

        public ShiguTempExample.Criteria andFlagNotIn(List<String> values) {
            return notIn(flag, values);
        }

        public ShiguTempExample.Criteria andFlagBetween(String value1, String value2) {
            return between(flag, value1, value2);
        }

        public ShiguTempExample.Criteria andFlagNotBetween(String value1, String value2) {
            return notBetween(flag, value1, value2);
        }
        public ShiguTempExample.Criteria andKey3IsNull() {
            return isNull(key3);
        }

        public ShiguTempExample.Criteria andKey3IsNotNull() {
            return isNotNull(key3);
        }

        public ShiguTempExample.Criteria andKey3EqualTo(String value) {
            return equalTo(key3, value);
        }

        public ShiguTempExample.Criteria andKey3NotEqualTo(String value) {
            return notEqualTo(key3, value);
        }

        public ShiguTempExample.Criteria andKey3GreaterThan(String value) {
            return greaterThan(key3, value);
        }

        public ShiguTempExample.Criteria andKey3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(key3, value);
        }

        public ShiguTempExample.Criteria andKey3LessThan(String value) {
            return lessThan(key3, value);
        }

        public ShiguTempExample.Criteria andKey3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(key3, value);
        }

        public ShiguTempExample.Criteria andKey3Like(String value) {
            return like(key3, value);
        }

        public ShiguTempExample.Criteria andKey3NotLike(String value) {
            return notLike(key3, value);
        }

        public ShiguTempExample.Criteria andKey3In(List<String> values) {
            return in(key3, values);
        }

        public ShiguTempExample.Criteria andKey3NotIn(List<String> values) {
            return notIn(key3, values);
        }

        public ShiguTempExample.Criteria andKey3Between(String value1, String value2) {
            return between(key3, value1, value2);
        }

        public ShiguTempExample.Criteria andKey3NotBetween(String value1, String value2) {
            return notBetween(key3, value1, value2);
        }
        public ShiguTempExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguTempExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguTempExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguTempExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguTempExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguTempExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguTempExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguTempExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguTempExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguTempExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguTempExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguTempExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
    }
}
