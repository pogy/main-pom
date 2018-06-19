package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemProductSku;

import java.util.*;
public class ItemProductSkuExample extends SgExample<ItemProductSkuExample.Criteria> {
    public static final Class<ItemProductSku> beanClass = ItemProductSku.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn color;
    public static EntityColumn size;
    public static EntityColumn price;
    public static EntityColumn pid;
    public static EntityColumn skuId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        color = listMap.get("color");
        size = listMap.get("size");
        price = listMap.get("price");
        pid = listMap.get("pid");
        skuId = listMap.get("skuId");
        }

    public ItemProductSkuExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemProductSkuExample.Criteria createCriteriaInternal() {
        return new ItemProductSkuExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemProductSkuExample.Criteria andColorIsNull() {
            return isNull(color);
        }

        public ItemProductSkuExample.Criteria andColorIsNotNull() {
            return isNotNull(color);
        }

        public ItemProductSkuExample.Criteria andColorEqualTo(String value) {
            return equalTo(color, value);
        }

        public ItemProductSkuExample.Criteria andColorNotEqualTo(String value) {
            return notEqualTo(color, value);
        }

        public ItemProductSkuExample.Criteria andColorGreaterThan(String value) {
            return greaterThan(color, value);
        }

        public ItemProductSkuExample.Criteria andColorGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(color, value);
        }

        public ItemProductSkuExample.Criteria andColorLessThan(String value) {
            return lessThan(color, value);
        }

        public ItemProductSkuExample.Criteria andColorLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(color, value);
        }

        public ItemProductSkuExample.Criteria andColorLike(String value) {
            return like(color, value);
        }

        public ItemProductSkuExample.Criteria andColorNotLike(String value) {
            return notLike(color, value);
        }

        public ItemProductSkuExample.Criteria andColorIn(List<String> values) {
            return in(color, values);
        }

        public ItemProductSkuExample.Criteria andColorNotIn(List<String> values) {
            return notIn(color, values);
        }

        public ItemProductSkuExample.Criteria andColorBetween(String value1, String value2) {
            return between(color, value1, value2);
        }

        public ItemProductSkuExample.Criteria andColorNotBetween(String value1, String value2) {
            return notBetween(color, value1, value2);
        }
        public ItemProductSkuExample.Criteria andSizeIsNull() {
            return isNull(size);
        }

        public ItemProductSkuExample.Criteria andSizeIsNotNull() {
            return isNotNull(size);
        }

        public ItemProductSkuExample.Criteria andSizeEqualTo(String value) {
            return equalTo(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeNotEqualTo(String value) {
            return notEqualTo(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeGreaterThan(String value) {
            return greaterThan(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeLessThan(String value) {
            return lessThan(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeLike(String value) {
            return like(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeNotLike(String value) {
            return notLike(size, value);
        }

        public ItemProductSkuExample.Criteria andSizeIn(List<String> values) {
            return in(size, values);
        }

        public ItemProductSkuExample.Criteria andSizeNotIn(List<String> values) {
            return notIn(size, values);
        }

        public ItemProductSkuExample.Criteria andSizeBetween(String value1, String value2) {
            return between(size, value1, value2);
        }

        public ItemProductSkuExample.Criteria andSizeNotBetween(String value1, String value2) {
            return notBetween(size, value1, value2);
        }
        public ItemProductSkuExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public ItemProductSkuExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public ItemProductSkuExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public ItemProductSkuExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public ItemProductSkuExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public ItemProductSkuExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public ItemProductSkuExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public ItemProductSkuExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ItemProductSkuExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ItemProductSkuExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ItemProductSkuExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public ItemProductSkuExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public ItemProductSkuExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public ItemProductSkuExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public ItemProductSkuExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public ItemProductSkuExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public ItemProductSkuExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public ItemProductSkuExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public ItemProductSkuExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public ItemProductSkuExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public ItemProductSkuExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
    }
}