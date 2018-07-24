package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopVideoTime;

import java.util.*;
public class ShopVideoTimeExample extends SgExample<ShopVideoTimeExample.Criteria> {
    public static final Class<ShopVideoTime> beanClass = ShopVideoTime.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn shopId;
    public static EntityColumn id;
    public static EntityColumn video;
    public static EntityColumn time;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        shopId = listMap.get("shopId");
        id = listMap.get("id");
        video = listMap.get("video");
        time = listMap.get("time");
        }

    public ShopVideoTimeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopVideoTimeExample.Criteria createCriteriaInternal() {
        return new ShopVideoTimeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopVideoTimeExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopVideoTimeExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopVideoTimeExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopVideoTimeExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopVideoTimeExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopVideoTimeExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopVideoTimeExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShopVideoTimeExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShopVideoTimeExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShopVideoTimeExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShopVideoTimeExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShopVideoTimeExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShopVideoTimeExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShopVideoTimeExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShopVideoTimeExample.Criteria andVideoIsNull() {
            return isNull(video);
        }

        public ShopVideoTimeExample.Criteria andVideoIsNotNull() {
            return isNotNull(video);
        }

        public ShopVideoTimeExample.Criteria andVideoEqualTo(String value) {
            return equalTo(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoNotEqualTo(String value) {
            return notEqualTo(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoGreaterThan(String value) {
            return greaterThan(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoLessThan(String value) {
            return lessThan(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoLike(String value) {
            return like(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoNotLike(String value) {
            return notLike(video, value);
        }

        public ShopVideoTimeExample.Criteria andVideoIn(List<String> values) {
            return in(video, values);
        }

        public ShopVideoTimeExample.Criteria andVideoNotIn(List<String> values) {
            return notIn(video, values);
        }

        public ShopVideoTimeExample.Criteria andVideoBetween(String value1, String value2) {
            return between(video, value1, value2);
        }

        public ShopVideoTimeExample.Criteria andVideoNotBetween(String value1, String value2) {
            return notBetween(video, value1, value2);
        }
        public ShopVideoTimeExample.Criteria andTimeIsNull() {
            return isNull(time);
        }

        public ShopVideoTimeExample.Criteria andTimeIsNotNull() {
            return isNotNull(time);
        }

        public ShopVideoTimeExample.Criteria andTimeEqualTo(String value) {
            return equalTo(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeNotEqualTo(String value) {
            return notEqualTo(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeGreaterThan(String value) {
            return greaterThan(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeLessThan(String value) {
            return lessThan(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeLike(String value) {
            return like(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeNotLike(String value) {
            return notLike(time, value);
        }

        public ShopVideoTimeExample.Criteria andTimeIn(List<String> values) {
            return in(time, values);
        }

        public ShopVideoTimeExample.Criteria andTimeNotIn(List<String> values) {
            return notIn(time, values);
        }

        public ShopVideoTimeExample.Criteria andTimeBetween(String value1, String value2) {
            return between(time, value1, value2);
        }

        public ShopVideoTimeExample.Criteria andTimeNotBetween(String value1, String value2) {
            return notBetween(time, value1, value2);
        }
    }
}