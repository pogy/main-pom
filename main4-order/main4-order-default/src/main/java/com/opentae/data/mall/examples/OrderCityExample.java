package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderCity;

import java.util.*;
public class OrderCityExample extends SgExample<OrderCityExample.Criteria> {
    public static final Class<OrderCity> beanClass = OrderCity.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn cityName;
    public static EntityColumn cityId;
    public static EntityColumn provId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        cityName = listMap.get("cityName");
        cityId = listMap.get("cityId");
        provId = listMap.get("provId");
        }

    public OrderCityExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderCityExample.Criteria createCriteriaInternal() {
        return new OrderCityExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderCityExample.Criteria andCityNameIsNull() {
            return isNull(cityName);
        }

        public OrderCityExample.Criteria andCityNameIsNotNull() {
            return isNotNull(cityName);
        }

        public OrderCityExample.Criteria andCityNameEqualTo(String value) {
            return equalTo(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameNotEqualTo(String value) {
            return notEqualTo(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameGreaterThan(String value) {
            return greaterThan(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameLessThan(String value) {
            return lessThan(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameLike(String value) {
            return like(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameNotLike(String value) {
            return notLike(cityName, value);
        }

        public OrderCityExample.Criteria andCityNameIn(List<String> values) {
            return in(cityName, values);
        }

        public OrderCityExample.Criteria andCityNameNotIn(List<String> values) {
            return notIn(cityName, values);
        }

        public OrderCityExample.Criteria andCityNameBetween(String value1, String value2) {
            return between(cityName, value1, value2);
        }

        public OrderCityExample.Criteria andCityNameNotBetween(String value1, String value2) {
            return notBetween(cityName, value1, value2);
        }
        public OrderCityExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public OrderCityExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public OrderCityExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public OrderCityExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public OrderCityExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public OrderCityExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public OrderCityExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public OrderCityExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public OrderCityExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public OrderCityExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public OrderCityExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public OrderCityExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public OrderCityExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public OrderCityExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public OrderCityExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public OrderCityExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public OrderCityExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public OrderCityExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public OrderCityExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
    }
}
