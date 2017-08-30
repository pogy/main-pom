package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemCidWeight;

import java.util.*;
public class ItemCidWeightExample extends SgExample<ItemCidWeightExample.Criteria> {
    public static final Class<ItemCidWeight> beanClass = ItemCidWeight.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn cwId;
    public static EntityColumn weight;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        cwId = listMap.get("cwId");
        weight = listMap.get("weight");
        cid = listMap.get("cid");
        }

    public ItemCidWeightExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemCidWeightExample.Criteria createCriteriaInternal() {
        return new ItemCidWeightExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemCidWeightExample.Criteria andCwIdIsNull() {
            return isNull(cwId);
        }

        public ItemCidWeightExample.Criteria andCwIdIsNotNull() {
            return isNotNull(cwId);
        }

        public ItemCidWeightExample.Criteria andCwIdEqualTo(Long value) {
            return equalTo(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdNotEqualTo(Long value) {
            return notEqualTo(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdGreaterThan(Long value) {
            return greaterThan(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdLessThan(Long value) {
            return lessThan(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cwId, value);
        }

        public ItemCidWeightExample.Criteria andCwIdIn(List<Long> values) {
            return in(cwId, values);
        }

        public ItemCidWeightExample.Criteria andCwIdNotIn(List<Long> values) {
            return notIn(cwId, values);
        }

        public ItemCidWeightExample.Criteria andCwIdBetween(Long value1, Long value2) {
            return between(cwId, value1, value2);
        }

        public ItemCidWeightExample.Criteria andCwIdNotBetween(Long value1, Long value2) {
            return notBetween(cwId, value1, value2);
        }
        public ItemCidWeightExample.Criteria andWeightIsNull() {
            return isNull(weight);
        }

        public ItemCidWeightExample.Criteria andWeightIsNotNull() {
            return isNotNull(weight);
        }

        public ItemCidWeightExample.Criteria andWeightEqualTo(Long value) {
            return equalTo(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightNotEqualTo(Long value) {
            return notEqualTo(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightGreaterThan(Long value) {
            return greaterThan(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightLessThan(Long value) {
            return lessThan(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(weight, value);
        }

        public ItemCidWeightExample.Criteria andWeightIn(List<Long> values) {
            return in(weight, values);
        }

        public ItemCidWeightExample.Criteria andWeightNotIn(List<Long> values) {
            return notIn(weight, values);
        }

        public ItemCidWeightExample.Criteria andWeightBetween(Long value1, Long value2) {
            return between(weight, value1, value2);
        }

        public ItemCidWeightExample.Criteria andWeightNotBetween(Long value1, Long value2) {
            return notBetween(weight, value1, value2);
        }
        public ItemCidWeightExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ItemCidWeightExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ItemCidWeightExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ItemCidWeightExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ItemCidWeightExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ItemCidWeightExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ItemCidWeightExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}
