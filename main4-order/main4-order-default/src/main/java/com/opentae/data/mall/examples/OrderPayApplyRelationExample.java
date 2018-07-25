package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderPayApplyRelation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class OrderPayApplyRelationExample extends SgExample<OrderPayApplyRelationExample.Criteria> {
    public static final Class<OrderPayApplyRelation> beanClass = OrderPayApplyRelation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn applyId;
    public static EntityColumn relationId;
    public static EntityColumn oid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        applyId = listMap.get("applyId");
        relationId = listMap.get("relationId");
        oid = listMap.get("oid");
        }

    public OrderPayApplyRelationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderPayApplyRelationExample.Criteria createCriteriaInternal() {
        return new OrderPayApplyRelationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdIsNull() {
            return isNull(applyId);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdIsNotNull() {
            return isNotNull(applyId);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdEqualTo(Long value) {
            return equalTo(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdNotEqualTo(Long value) {
            return notEqualTo(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdGreaterThan(Long value) {
            return greaterThan(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdLessThan(Long value) {
            return lessThan(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(applyId, value);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdIn(List<Long> values) {
            return in(applyId, values);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdNotIn(List<Long> values) {
            return notIn(applyId, values);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            return between(applyId, value1, value2);
        }

        public OrderPayApplyRelationExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(applyId, value1, value2);
        }
        public OrderPayApplyRelationExample.Criteria andRelationIdIsNull() {
            return isNull(relationId);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdIsNotNull() {
            return isNotNull(relationId);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdEqualTo(Long value) {
            return equalTo(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdNotEqualTo(Long value) {
            return notEqualTo(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdGreaterThan(Long value) {
            return greaterThan(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdLessThan(Long value) {
            return lessThan(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(relationId, value);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdIn(List<Long> values) {
            return in(relationId, values);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdNotIn(List<Long> values) {
            return notIn(relationId, values);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdBetween(Long value1, Long value2) {
            return between(relationId, value1, value2);
        }

        public OrderPayApplyRelationExample.Criteria andRelationIdNotBetween(Long value1, Long value2) {
            return notBetween(relationId, value1, value2);
        }
        public OrderPayApplyRelationExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public OrderPayApplyRelationExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public OrderPayApplyRelationExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public OrderPayApplyRelationExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public OrderPayApplyRelationExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public OrderPayApplyRelationExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public OrderPayApplyRelationExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
    }
}