package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopSize;

import java.util.*;
public class ShopSizeExample extends SgExample<ShopSizeExample.Criteria> {
    public static final Class<ShopSize> beanClass = ShopSize.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sizeId;
    public static EntityColumn picSize;
    public static EntityColumn shopId;
    public static EntityColumn videoSize;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sizeId = listMap.get("sizeId");
        picSize = listMap.get("picSize");
        shopId = listMap.get("shopId");
        videoSize = listMap.get("videoSize");
        }

    public ShopSizeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopSizeExample.Criteria createCriteriaInternal() {
        return new ShopSizeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopSizeExample.Criteria andSizeIdIsNull() {
            return isNull(sizeId);
        }

        public ShopSizeExample.Criteria andSizeIdIsNotNull() {
            return isNotNull(sizeId);
        }

        public ShopSizeExample.Criteria andSizeIdEqualTo(Long value) {
            return equalTo(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdNotEqualTo(Long value) {
            return notEqualTo(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdGreaterThan(Long value) {
            return greaterThan(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdLessThan(Long value) {
            return lessThan(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sizeId, value);
        }

        public ShopSizeExample.Criteria andSizeIdIn(List<Long> values) {
            return in(sizeId, values);
        }

        public ShopSizeExample.Criteria andSizeIdNotIn(List<Long> values) {
            return notIn(sizeId, values);
        }

        public ShopSizeExample.Criteria andSizeIdBetween(Long value1, Long value2) {
            return between(sizeId, value1, value2);
        }

        public ShopSizeExample.Criteria andSizeIdNotBetween(Long value1, Long value2) {
            return notBetween(sizeId, value1, value2);
        }
        public ShopSizeExample.Criteria andPicSizeIsNull() {
            return isNull(picSize);
        }

        public ShopSizeExample.Criteria andPicSizeIsNotNull() {
            return isNotNull(picSize);
        }

        public ShopSizeExample.Criteria andPicSizeEqualTo(Long value) {
            return equalTo(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeNotEqualTo(Long value) {
            return notEqualTo(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeGreaterThan(Long value) {
            return greaterThan(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeLessThan(Long value) {
            return lessThan(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(picSize, value);
        }

        public ShopSizeExample.Criteria andPicSizeIn(List<Long> values) {
            return in(picSize, values);
        }

        public ShopSizeExample.Criteria andPicSizeNotIn(List<Long> values) {
            return notIn(picSize, values);
        }

        public ShopSizeExample.Criteria andPicSizeBetween(Long value1, Long value2) {
            return between(picSize, value1, value2);
        }

        public ShopSizeExample.Criteria andPicSizeNotBetween(Long value1, Long value2) {
            return notBetween(picSize, value1, value2);
        }
        public ShopSizeExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopSizeExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopSizeExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopSizeExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopSizeExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopSizeExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopSizeExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShopSizeExample.Criteria andVideoSizeIsNull() {
            return isNull(videoSize);
        }

        public ShopSizeExample.Criteria andVideoSizeIsNotNull() {
            return isNotNull(videoSize);
        }

        public ShopSizeExample.Criteria andVideoSizeEqualTo(Long value) {
            return equalTo(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeNotEqualTo(Long value) {
            return notEqualTo(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeGreaterThan(Long value) {
            return greaterThan(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeLessThan(Long value) {
            return lessThan(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(videoSize, value);
        }

        public ShopSizeExample.Criteria andVideoSizeIn(List<Long> values) {
            return in(videoSize, values);
        }

        public ShopSizeExample.Criteria andVideoSizeNotIn(List<Long> values) {
            return notIn(videoSize, values);
        }

        public ShopSizeExample.Criteria andVideoSizeBetween(Long value1, Long value2) {
            return between(videoSize, value1, value2);
        }

        public ShopSizeExample.Criteria andVideoSizeNotBetween(Long value1, Long value2) {
            return notBetween(videoSize, value1, value2);
        }
    }
}