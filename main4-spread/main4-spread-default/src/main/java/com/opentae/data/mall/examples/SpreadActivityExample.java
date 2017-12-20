package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SpreadActivity;

import java.util.*;
public class SpreadActivityExample extends SgExample<SpreadActivityExample.Criteria> {
    public static final Class<SpreadActivity> beanClass = SpreadActivity.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn activityId;
    public static EntityColumn termId;
    public static EntityColumn activityKey;
    public static EntityColumn price;
    public static EntityColumn context;
    public static EntityColumn description;
    public static EntityColumn sort;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        activityId = listMap.get("activityId");
        termId = listMap.get("termId");
        activityKey = listMap.get("activityKey");
        price = listMap.get("price");
        context = listMap.get("context");
        description = listMap.get("description");
        sort = listMap.get("sort");
        type = listMap.get("type");
        }

    public SpreadActivityExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SpreadActivityExample.Criteria createCriteriaInternal() {
        return new SpreadActivityExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SpreadActivityExample.Criteria andActivityIdIsNull() {
            return isNull(activityId);
        }

        public SpreadActivityExample.Criteria andActivityIdIsNotNull() {
            return isNotNull(activityId);
        }

        public SpreadActivityExample.Criteria andActivityIdEqualTo(Long value) {
            return equalTo(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdNotEqualTo(Long value) {
            return notEqualTo(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdGreaterThan(Long value) {
            return greaterThan(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdLessThan(Long value) {
            return lessThan(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activityId, value);
        }

        public SpreadActivityExample.Criteria andActivityIdIn(List<Long> values) {
            return in(activityId, values);
        }

        public SpreadActivityExample.Criteria andActivityIdNotIn(List<Long> values) {
            return notIn(activityId, values);
        }

        public SpreadActivityExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            return between(activityId, value1, value2);
        }

        public SpreadActivityExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            return notBetween(activityId, value1, value2);
        }
        public SpreadActivityExample.Criteria andTermIdIsNull() {
            return isNull(termId);
        }

        public SpreadActivityExample.Criteria andTermIdIsNotNull() {
            return isNotNull(termId);
        }

        public SpreadActivityExample.Criteria andTermIdEqualTo(Long value) {
            return equalTo(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdNotEqualTo(Long value) {
            return notEqualTo(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdGreaterThan(Long value) {
            return greaterThan(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdLessThan(Long value) {
            return lessThan(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(termId, value);
        }

        public SpreadActivityExample.Criteria andTermIdIn(List<Long> values) {
            return in(termId, values);
        }

        public SpreadActivityExample.Criteria andTermIdNotIn(List<Long> values) {
            return notIn(termId, values);
        }

        public SpreadActivityExample.Criteria andTermIdBetween(Long value1, Long value2) {
            return between(termId, value1, value2);
        }

        public SpreadActivityExample.Criteria andTermIdNotBetween(Long value1, Long value2) {
            return notBetween(termId, value1, value2);
        }
        public SpreadActivityExample.Criteria andActivityKeyIsNull() {
            return isNull(activityKey);
        }

        public SpreadActivityExample.Criteria andActivityKeyIsNotNull() {
            return isNotNull(activityKey);
        }

        public SpreadActivityExample.Criteria andActivityKeyEqualTo(String value) {
            return equalTo(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyNotEqualTo(String value) {
            return notEqualTo(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyGreaterThan(String value) {
            return greaterThan(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyLessThan(String value) {
            return lessThan(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyLike(String value) {
            return like(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyNotLike(String value) {
            return notLike(activityKey, value);
        }

        public SpreadActivityExample.Criteria andActivityKeyIn(List<String> values) {
            return in(activityKey, values);
        }

        public SpreadActivityExample.Criteria andActivityKeyNotIn(List<String> values) {
            return notIn(activityKey, values);
        }

        public SpreadActivityExample.Criteria andActivityKeyBetween(String value1, String value2) {
            return between(activityKey, value1, value2);
        }

        public SpreadActivityExample.Criteria andActivityKeyNotBetween(String value1, String value2) {
            return notBetween(activityKey, value1, value2);
        }
        public SpreadActivityExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public SpreadActivityExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public SpreadActivityExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public SpreadActivityExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public SpreadActivityExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public SpreadActivityExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public SpreadActivityExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public SpreadActivityExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public SpreadActivityExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public SpreadActivityExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public SpreadActivityExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public SpreadActivityExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public SpreadActivityExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public SpreadActivityExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public SpreadActivityExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public SpreadActivityExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public SpreadActivityExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public SpreadActivityExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public SpreadActivityExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public SpreadActivityExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public SpreadActivityExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public SpreadActivityExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public SpreadActivityExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public SpreadActivityExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public SpreadActivityExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public SpreadActivityExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public SpreadActivityExample.Criteria andDescriptionIsNull() {
            return isNull(description);
        }

        public SpreadActivityExample.Criteria andDescriptionIsNotNull() {
            return isNotNull(description);
        }

        public SpreadActivityExample.Criteria andDescriptionEqualTo(String value) {
            return equalTo(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionNotEqualTo(String value) {
            return notEqualTo(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionGreaterThan(String value) {
            return greaterThan(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionLessThan(String value) {
            return lessThan(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionLike(String value) {
            return like(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionNotLike(String value) {
            return notLike(description, value);
        }

        public SpreadActivityExample.Criteria andDescriptionIn(List<String> values) {
            return in(description, values);
        }

        public SpreadActivityExample.Criteria andDescriptionNotIn(List<String> values) {
            return notIn(description, values);
        }

        public SpreadActivityExample.Criteria andDescriptionBetween(String value1, String value2) {
            return between(description, value1, value2);
        }

        public SpreadActivityExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            return notBetween(description, value1, value2);
        }
        public SpreadActivityExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public SpreadActivityExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public SpreadActivityExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public SpreadActivityExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public SpreadActivityExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public SpreadActivityExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public SpreadActivityExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public SpreadActivityExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public SpreadActivityExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public SpreadActivityExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public SpreadActivityExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public SpreadActivityExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public SpreadActivityExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public SpreadActivityExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public SpreadActivityExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public SpreadActivityExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public SpreadActivityExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public SpreadActivityExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public SpreadActivityExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public SpreadActivityExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public SpreadActivityExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public SpreadActivityExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public SpreadActivityExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public SpreadActivityExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}
