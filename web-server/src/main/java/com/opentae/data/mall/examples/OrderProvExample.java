package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderProv;

import java.util.*;
public class OrderProvExample extends SgExample<OrderProvExample.Criteria> {
    public static final Class<OrderProv> beanClass = OrderProv.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn provName;
    public static EntityColumn provId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        provName = listMap.get("provName");
        provId = listMap.get("provId");
        }

    public OrderProvExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderProvExample.Criteria createCriteriaInternal() {
        return new OrderProvExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderProvExample.Criteria andProvNameIsNull() {
            return isNull(provName);
        }

        public OrderProvExample.Criteria andProvNameIsNotNull() {
            return isNotNull(provName);
        }

        public OrderProvExample.Criteria andProvNameEqualTo(String value) {
            return equalTo(provName, value);
        }

        public OrderProvExample.Criteria andProvNameNotEqualTo(String value) {
            return notEqualTo(provName, value);
        }

        public OrderProvExample.Criteria andProvNameGreaterThan(String value) {
            return greaterThan(provName, value);
        }

        public OrderProvExample.Criteria andProvNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(provName, value);
        }

        public OrderProvExample.Criteria andProvNameLessThan(String value) {
            return lessThan(provName, value);
        }

        public OrderProvExample.Criteria andProvNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(provName, value);
        }

        public OrderProvExample.Criteria andProvNameLike(String value) {
            return like(provName, value);
        }

        public OrderProvExample.Criteria andProvNameNotLike(String value) {
            return notLike(provName, value);
        }

        public OrderProvExample.Criteria andProvNameIn(List<String> values) {
            return in(provName, values);
        }

        public OrderProvExample.Criteria andProvNameNotIn(List<String> values) {
            return notIn(provName, values);
        }

        public OrderProvExample.Criteria andProvNameBetween(String value1, String value2) {
            return between(provName, value1, value2);
        }

        public OrderProvExample.Criteria andProvNameNotBetween(String value1, String value2) {
            return notBetween(provName, value1, value2);
        }
        public OrderProvExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public OrderProvExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public OrderProvExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public OrderProvExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public OrderProvExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public OrderProvExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public OrderProvExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public OrderProvExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public OrderProvExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public OrderProvExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public OrderProvExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public OrderProvExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
    }
}