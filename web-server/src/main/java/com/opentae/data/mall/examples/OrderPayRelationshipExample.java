package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderPayRelationship;

import java.util.*;
public class OrderPayRelationshipExample extends SgExample<OrderPayRelationshipExample.Criteria> {
    public static final Class<OrderPayRelationship> beanClass = OrderPayRelationship.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn oid;
    public static EntityColumn payId;
    public static EntityColumn rid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        oid = listMap.get("oid");
        payId = listMap.get("payId");
        rid = listMap.get("rid");
        }

    public OrderPayRelationshipExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderPayRelationshipExample.Criteria createCriteriaInternal() {
        return new OrderPayRelationshipExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderPayRelationshipExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public OrderPayRelationshipExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public OrderPayRelationshipExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public OrderPayRelationshipExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public OrderPayRelationshipExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public OrderPayRelationshipExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public OrderPayRelationshipExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public OrderPayRelationshipExample.Criteria andPayIdIsNull() {
            return isNull(payId);
        }

        public OrderPayRelationshipExample.Criteria andPayIdIsNotNull() {
            return isNotNull(payId);
        }

        public OrderPayRelationshipExample.Criteria andPayIdEqualTo(Long value) {
            return equalTo(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotEqualTo(Long value) {
            return notEqualTo(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdGreaterThan(Long value) {
            return greaterThan(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdLessThan(Long value) {
            return lessThan(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payId, value);
        }

        public OrderPayRelationshipExample.Criteria andPayIdIn(List<Long> values) {
            return in(payId, values);
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotIn(List<Long> values) {
            return notIn(payId, values);
        }

        public OrderPayRelationshipExample.Criteria andPayIdBetween(Long value1, Long value2) {
            return between(payId, value1, value2);
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            return notBetween(payId, value1, value2);
        }
        public OrderPayRelationshipExample.Criteria andRidIsNull() {
            return isNull(rid);
        }

        public OrderPayRelationshipExample.Criteria andRidIsNotNull() {
            return isNotNull(rid);
        }

        public OrderPayRelationshipExample.Criteria andRidEqualTo(Long value) {
            return equalTo(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidNotEqualTo(Long value) {
            return notEqualTo(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidGreaterThan(Long value) {
            return greaterThan(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidLessThan(Long value) {
            return lessThan(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rid, value);
        }

        public OrderPayRelationshipExample.Criteria andRidIn(List<Long> values) {
            return in(rid, values);
        }

        public OrderPayRelationshipExample.Criteria andRidNotIn(List<Long> values) {
            return notIn(rid, values);
        }

        public OrderPayRelationshipExample.Criteria andRidBetween(Long value1, Long value2) {
            return between(rid, value1, value2);
        }

        public OrderPayRelationshipExample.Criteria andRidNotBetween(Long value1, Long value2) {
            return notBetween(rid, value1, value2);
        }
    }
}