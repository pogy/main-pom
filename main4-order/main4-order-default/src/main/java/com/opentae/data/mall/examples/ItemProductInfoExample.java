package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemProductInfo;

import java.util.*;
public class ItemProductInfoExample extends SgExample<ItemProductInfoExample.Criteria> {
    public static final Class<ItemProductInfo> beanClass = ItemProductInfo.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn pid;
    public static EntityColumn skuId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        pid = listMap.get("pid");
        skuId = listMap.get("skuId");
        }

    public ItemProductInfoExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemProductInfoExample.Criteria createCriteriaInternal() {
        return new ItemProductInfoExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemProductInfoExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ItemProductInfoExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ItemProductInfoExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ItemProductInfoExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public ItemProductInfoExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public ItemProductInfoExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public ItemProductInfoExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public ItemProductInfoExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public ItemProductInfoExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public ItemProductInfoExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public ItemProductInfoExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public ItemProductInfoExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public ItemProductInfoExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public ItemProductInfoExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
    }
}
