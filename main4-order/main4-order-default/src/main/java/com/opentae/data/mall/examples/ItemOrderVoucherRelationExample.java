package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderVoucherRelation;

import java.util.*;
public class ItemOrderVoucherRelationExample extends SgExample<ItemOrderVoucherRelationExample.Criteria> {
    public static final Class<ItemOrderVoucherRelation> beanClass = ItemOrderVoucherRelation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn voucherOrderRelationId;
    public static EntityColumn voucherStatus;
    public static EntityColumn orderId;
    public static EntityColumn voucherId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        voucherOrderRelationId = listMap.get("voucherOrderRelationId");
        voucherStatus = listMap.get("voucherStatus");
        orderId = listMap.get("orderId");
        voucherId = listMap.get("voucherId");
        }

    public ItemOrderVoucherRelationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderVoucherRelationExample.Criteria createCriteriaInternal() {
        return new ItemOrderVoucherRelationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdIsNull() {
            return isNull(voucherOrderRelationId);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdIsNotNull() {
            return isNotNull(voucherOrderRelationId);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdEqualTo(Long value) {
            return equalTo(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdNotEqualTo(Long value) {
            return notEqualTo(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdGreaterThan(Long value) {
            return greaterThan(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdLessThan(Long value) {
            return lessThan(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(voucherOrderRelationId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdIn(List<Long> values) {
            return in(voucherOrderRelationId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdNotIn(List<Long> values) {
            return notIn(voucherOrderRelationId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdBetween(Long value1, Long value2) {
            return between(voucherOrderRelationId, value1, value2);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherOrderRelationIdNotBetween(Long value1, Long value2) {
            return notBetween(voucherOrderRelationId, value1, value2);
        }
        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusIsNull() {
            return isNull(voucherStatus);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusIsNotNull() {
            return isNotNull(voucherStatus);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusEqualTo(Integer value) {
            return equalTo(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusNotEqualTo(Integer value) {
            return notEqualTo(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusGreaterThan(Integer value) {
            return greaterThan(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusLessThan(Integer value) {
            return lessThan(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(voucherStatus, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusIn(List<Integer> values) {
            return in(voucherStatus, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusNotIn(List<Integer> values) {
            return notIn(voucherStatus, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusBetween(Integer value1, Integer value2) {
            return between(voucherStatus, value1, value2);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(voucherStatus, value1, value2);
        }
        public ItemOrderVoucherRelationExample.Criteria andOrderIdIsNull() {
            return isNull(orderId);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdIsNotNull() {
            return isNotNull(orderId);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdEqualTo(Long value) {
            return equalTo(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdNotEqualTo(Long value) {
            return notEqualTo(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdGreaterThan(Long value) {
            return greaterThan(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdLessThan(Long value) {
            return lessThan(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(orderId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdIn(List<Long> values) {
            return in(orderId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdNotIn(List<Long> values) {
            return notIn(orderId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdBetween(Long value1, Long value2) {
            return between(orderId, value1, value2);
        }

        public ItemOrderVoucherRelationExample.Criteria andOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(orderId, value1, value2);
        }
        public ItemOrderVoucherRelationExample.Criteria andVoucherIdIsNull() {
            return isNull(voucherId);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdIsNotNull() {
            return isNotNull(voucherId);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdEqualTo(Long value) {
            return equalTo(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdNotEqualTo(Long value) {
            return notEqualTo(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdGreaterThan(Long value) {
            return greaterThan(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdLessThan(Long value) {
            return lessThan(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(voucherId, value);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdIn(List<Long> values) {
            return in(voucherId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdNotIn(List<Long> values) {
            return notIn(voucherId, values);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdBetween(Long value1, Long value2) {
            return between(voucherId, value1, value2);
        }

        public ItemOrderVoucherRelationExample.Criteria andVoucherIdNotBetween(Long value1, Long value2) {
            return notBetween(voucherId, value1, value2);
        }
    }
}