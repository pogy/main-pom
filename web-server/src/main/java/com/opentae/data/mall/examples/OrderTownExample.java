package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderTown;

import java.util.*;
public class OrderTownExample extends SgExample<OrderTownExample.Criteria> {
    public static final Class<OrderTown> beanClass = OrderTown.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn townName;
    public static EntityColumn townId;
    public static EntityColumn cityId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        townName = listMap.get("townName");
        townId = listMap.get("townId");
        cityId = listMap.get("cityId");
        }

    public OrderTownExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderTownExample.Criteria createCriteriaInternal() {
        return new OrderTownExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderTownExample.Criteria andTownNameIsNull() {
            return isNull(townName);
        }

        public OrderTownExample.Criteria andTownNameIsNotNull() {
            return isNotNull(townName);
        }

        public OrderTownExample.Criteria andTownNameEqualTo(String value) {
            return equalTo(townName, value);
        }

        public OrderTownExample.Criteria andTownNameNotEqualTo(String value) {
            return notEqualTo(townName, value);
        }

        public OrderTownExample.Criteria andTownNameGreaterThan(String value) {
            return greaterThan(townName, value);
        }

        public OrderTownExample.Criteria andTownNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(townName, value);
        }

        public OrderTownExample.Criteria andTownNameLessThan(String value) {
            return lessThan(townName, value);
        }

        public OrderTownExample.Criteria andTownNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(townName, value);
        }

        public OrderTownExample.Criteria andTownNameLike(String value) {
            return like(townName, value);
        }

        public OrderTownExample.Criteria andTownNameNotLike(String value) {
            return notLike(townName, value);
        }

        public OrderTownExample.Criteria andTownNameIn(List<String> values) {
            return in(townName, values);
        }

        public OrderTownExample.Criteria andTownNameNotIn(List<String> values) {
            return notIn(townName, values);
        }

        public OrderTownExample.Criteria andTownNameBetween(String value1, String value2) {
            return between(townName, value1, value2);
        }

        public OrderTownExample.Criteria andTownNameNotBetween(String value1, String value2) {
            return notBetween(townName, value1, value2);
        }
        public OrderTownExample.Criteria andTownIdIsNull() {
            return isNull(townId);
        }

        public OrderTownExample.Criteria andTownIdIsNotNull() {
            return isNotNull(townId);
        }

        public OrderTownExample.Criteria andTownIdEqualTo(Long value) {
            return equalTo(townId, value);
        }

        public OrderTownExample.Criteria andTownIdNotEqualTo(Long value) {
            return notEqualTo(townId, value);
        }

        public OrderTownExample.Criteria andTownIdGreaterThan(Long value) {
            return greaterThan(townId, value);
        }

        public OrderTownExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(townId, value);
        }

        public OrderTownExample.Criteria andTownIdLessThan(Long value) {
            return lessThan(townId, value);
        }

        public OrderTownExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(townId, value);
        }

        public OrderTownExample.Criteria andTownIdIn(List<Long> values) {
            return in(townId, values);
        }

        public OrderTownExample.Criteria andTownIdNotIn(List<Long> values) {
            return notIn(townId, values);
        }

        public OrderTownExample.Criteria andTownIdBetween(Long value1, Long value2) {
            return between(townId, value1, value2);
        }

        public OrderTownExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            return notBetween(townId, value1, value2);
        }
        public OrderTownExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public OrderTownExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public OrderTownExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public OrderTownExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public OrderTownExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public OrderTownExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public OrderTownExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
    }
}