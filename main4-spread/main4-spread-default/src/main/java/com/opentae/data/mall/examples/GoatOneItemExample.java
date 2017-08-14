package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoatOneItem;

import java.util.*;
public class GoatOneItemExample extends SgExample<GoatOneItemExample.Criteria> {
    public static final Class<GoatOneItem> beanClass = GoatOneItem.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn disEnabled;
    public static EntityColumn recommon;
    public static EntityColumn goatId;
    public static EntityColumn sort;
    public static EntityColumn localId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        disEnabled = listMap.get("disEnabled");
        recommon = listMap.get("recommon");
        goatId = listMap.get("goatId");
        sort = listMap.get("sort");
        localId = listMap.get("localId");
        }

    public GoatOneItemExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoatOneItemExample.Criteria createCriteriaInternal() {
        return new GoatOneItemExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoatOneItemExample.Criteria andDisEnabledIsNull() {
            return isNull(disEnabled);
        }

        public GoatOneItemExample.Criteria andDisEnabledIsNotNull() {
            return isNotNull(disEnabled);
        }

        public GoatOneItemExample.Criteria andDisEnabledEqualTo(Boolean value) {
            return equalTo(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            return notEqualTo(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            return greaterThan(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledLessThan(Boolean value) {
            return lessThan(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(disEnabled, value);
        }

        public GoatOneItemExample.Criteria andDisEnabledIn(List<Boolean> values) {
            return in(disEnabled, values);
        }

        public GoatOneItemExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            return notIn(disEnabled, values);
        }

        public GoatOneItemExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            return between(disEnabled, value1, value2);
        }

        public GoatOneItemExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(disEnabled, value1, value2);
        }
        public GoatOneItemExample.Criteria andRecommonIsNull() {
            return isNull(recommon);
        }

        public GoatOneItemExample.Criteria andRecommonIsNotNull() {
            return isNotNull(recommon);
        }

        public GoatOneItemExample.Criteria andRecommonEqualTo(String value) {
            return equalTo(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonNotEqualTo(String value) {
            return notEqualTo(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonGreaterThan(String value) {
            return greaterThan(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonLessThan(String value) {
            return lessThan(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonLike(String value) {
            return like(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonNotLike(String value) {
            return notLike(recommon, value);
        }

        public GoatOneItemExample.Criteria andRecommonIn(List<String> values) {
            return in(recommon, values);
        }

        public GoatOneItemExample.Criteria andRecommonNotIn(List<String> values) {
            return notIn(recommon, values);
        }

        public GoatOneItemExample.Criteria andRecommonBetween(String value1, String value2) {
            return between(recommon, value1, value2);
        }

        public GoatOneItemExample.Criteria andRecommonNotBetween(String value1, String value2) {
            return notBetween(recommon, value1, value2);
        }
        public GoatOneItemExample.Criteria andGoatIdIsNull() {
            return isNull(goatId);
        }

        public GoatOneItemExample.Criteria andGoatIdIsNotNull() {
            return isNotNull(goatId);
        }

        public GoatOneItemExample.Criteria andGoatIdEqualTo(Long value) {
            return equalTo(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdNotEqualTo(Long value) {
            return notEqualTo(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdGreaterThan(Long value) {
            return greaterThan(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdLessThan(Long value) {
            return lessThan(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goatId, value);
        }

        public GoatOneItemExample.Criteria andGoatIdIn(List<Long> values) {
            return in(goatId, values);
        }

        public GoatOneItemExample.Criteria andGoatIdNotIn(List<Long> values) {
            return notIn(goatId, values);
        }

        public GoatOneItemExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            return between(goatId, value1, value2);
        }

        public GoatOneItemExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            return notBetween(goatId, value1, value2);
        }
        public GoatOneItemExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public GoatOneItemExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public GoatOneItemExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public GoatOneItemExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public GoatOneItemExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public GoatOneItemExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public GoatOneItemExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public GoatOneItemExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public GoatOneItemExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public GoatOneItemExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public GoatOneItemExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public GoatOneItemExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public GoatOneItemExample.Criteria andLocalIdIsNull() {
            return isNull(localId);
        }

        public GoatOneItemExample.Criteria andLocalIdIsNotNull() {
            return isNotNull(localId);
        }

        public GoatOneItemExample.Criteria andLocalIdEqualTo(Long value) {
            return equalTo(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdNotEqualTo(Long value) {
            return notEqualTo(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdGreaterThan(Long value) {
            return greaterThan(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdLessThan(Long value) {
            return lessThan(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(localId, value);
        }

        public GoatOneItemExample.Criteria andLocalIdIn(List<Long> values) {
            return in(localId, values);
        }

        public GoatOneItemExample.Criteria andLocalIdNotIn(List<Long> values) {
            return notIn(localId, values);
        }

        public GoatOneItemExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            return between(localId, value1, value2);
        }

        public GoatOneItemExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            return notBetween(localId, value1, value2);
        }
    }
}
