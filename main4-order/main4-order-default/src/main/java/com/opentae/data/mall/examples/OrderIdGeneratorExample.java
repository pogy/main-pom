package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderIdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class OrderIdGeneratorExample extends SgExample<OrderIdGeneratorExample.Criteria> {
    public static final Class<OrderIdGenerator> beanClass = OrderIdGenerator.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn oid;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        oid = listMap.get("oid");
        type = listMap.get("type");
        }

    public OrderIdGeneratorExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderIdGeneratorExample.Criteria createCriteriaInternal() {
        return new OrderIdGeneratorExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderIdGeneratorExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public OrderIdGeneratorExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public OrderIdGeneratorExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public OrderIdGeneratorExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public OrderIdGeneratorExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public OrderIdGeneratorExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public OrderIdGeneratorExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public OrderIdGeneratorExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public OrderIdGeneratorExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public OrderIdGeneratorExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public OrderIdGeneratorExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public OrderIdGeneratorExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public OrderIdGeneratorExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public OrderIdGeneratorExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}
