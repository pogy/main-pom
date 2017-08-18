package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SubOrderSoidps;

import java.util.*;
public class SubOrderSoidpsExample extends SgExample<SubOrderSoidpsExample.Criteria> {
    public static final Class<SubOrderSoidps> beanClass = SubOrderSoidps.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn soid;
    public static EntityColumn soidpId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        soid = listMap.get("soid");
        soidpId = listMap.get("soidpId");
        }

    public SubOrderSoidpsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SubOrderSoidpsExample.Criteria createCriteriaInternal() {
        return new SubOrderSoidpsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SubOrderSoidpsExample.Criteria andSoidIsNull() {
            return isNull(soid);
        }

        public SubOrderSoidpsExample.Criteria andSoidIsNotNull() {
            return isNotNull(soid);
        }

        public SubOrderSoidpsExample.Criteria andSoidEqualTo(Long value) {
            return equalTo(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidNotEqualTo(Long value) {
            return notEqualTo(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidGreaterThan(Long value) {
            return greaterThan(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidLessThan(Long value) {
            return lessThan(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soid, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidIn(List<Long> values) {
            return in(soid, values);
        }

        public SubOrderSoidpsExample.Criteria andSoidNotIn(List<Long> values) {
            return notIn(soid, values);
        }

        public SubOrderSoidpsExample.Criteria andSoidBetween(Long value1, Long value2) {
            return between(soid, value1, value2);
        }

        public SubOrderSoidpsExample.Criteria andSoidNotBetween(Long value1, Long value2) {
            return notBetween(soid, value1, value2);
        }
        public SubOrderSoidpsExample.Criteria andSoidpIdIsNull() {
            return isNull(soidpId);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdIsNotNull() {
            return isNotNull(soidpId);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdEqualTo(Long value) {
            return equalTo(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdNotEqualTo(Long value) {
            return notEqualTo(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdGreaterThan(Long value) {
            return greaterThan(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdLessThan(Long value) {
            return lessThan(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soidpId, value);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdIn(List<Long> values) {
            return in(soidpId, values);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdNotIn(List<Long> values) {
            return notIn(soidpId, values);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdBetween(Long value1, Long value2) {
            return between(soidpId, value1, value2);
        }

        public SubOrderSoidpsExample.Criteria andSoidpIdNotBetween(Long value1, Long value2) {
            return notBetween(soidpId, value1, value2);
        }
    }
}