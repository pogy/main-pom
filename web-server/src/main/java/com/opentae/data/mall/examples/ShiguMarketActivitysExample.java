package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguMarketActivitys;

import java.util.*;
public class ShiguMarketActivitysExample extends SgExample<ShiguMarketActivitysExample.Criteria> {
    public static final Class<ShiguMarketActivitys> beanClass = ShiguMarketActivitys.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn maName;
    public static EntityColumn maBackground;
    public static EntityColumn maStatus;
    public static EntityColumn maPic;
    public static EntityColumn maId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        maName = listMap.get("maName");
        maBackground = listMap.get("maBackground");
        maStatus = listMap.get("maStatus");
        maPic = listMap.get("maPic");
        maId = listMap.get("maId");
        }

    public ShiguMarketActivitysExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguMarketActivitysExample.Criteria createCriteriaInternal() {
        return new ShiguMarketActivitysExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameIsNull() {
            return isNull(maName);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameIsNotNull() {
            return isNotNull(maName);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameEqualTo(String value) {
            return equalTo(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameNotEqualTo(String value) {
            return notEqualTo(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameGreaterThan(String value) {
            return greaterThan(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameLessThan(String value) {
            return lessThan(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameLike(String value) {
            return like(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameNotLike(String value) {
            return notLike(maName, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameIn(List<String> values) {
            return in(maName, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameNotIn(List<String> values) {
            return notIn(maName, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameBetween(String value1, String value2) {
            return between(maName, value1, value2);
        }

        public ShiguMarketActivitysExample.Criteria andMaNameNotBetween(String value1, String value2) {
            return notBetween(maName, value1, value2);
        }
        public ShiguMarketActivitysExample.Criteria andMaBackgroundIsNull() {
            return isNull(maBackground);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundIsNotNull() {
            return isNotNull(maBackground);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundEqualTo(String value) {
            return equalTo(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundNotEqualTo(String value) {
            return notEqualTo(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundGreaterThan(String value) {
            return greaterThan(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundLessThan(String value) {
            return lessThan(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundLike(String value) {
            return like(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundNotLike(String value) {
            return notLike(maBackground, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundIn(List<String> values) {
            return in(maBackground, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundNotIn(List<String> values) {
            return notIn(maBackground, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundBetween(String value1, String value2) {
            return between(maBackground, value1, value2);
        }

        public ShiguMarketActivitysExample.Criteria andMaBackgroundNotBetween(String value1, String value2) {
            return notBetween(maBackground, value1, value2);
        }
        public ShiguMarketActivitysExample.Criteria andMaStatusIsNull() {
            return isNull(maStatus);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusIsNotNull() {
            return isNotNull(maStatus);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusEqualTo(Integer value) {
            return equalTo(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusNotEqualTo(Integer value) {
            return notEqualTo(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusGreaterThan(Integer value) {
            return greaterThan(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusLessThan(Integer value) {
            return lessThan(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(maStatus, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusIn(List<Integer> values) {
            return in(maStatus, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusNotIn(List<Integer> values) {
            return notIn(maStatus, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusBetween(Integer value1, Integer value2) {
            return between(maStatus, value1, value2);
        }

        public ShiguMarketActivitysExample.Criteria andMaStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(maStatus, value1, value2);
        }
        public ShiguMarketActivitysExample.Criteria andMaPicIsNull() {
            return isNull(maPic);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicIsNotNull() {
            return isNotNull(maPic);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicEqualTo(String value) {
            return equalTo(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicNotEqualTo(String value) {
            return notEqualTo(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicGreaterThan(String value) {
            return greaterThan(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicLessThan(String value) {
            return lessThan(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicLike(String value) {
            return like(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicNotLike(String value) {
            return notLike(maPic, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicIn(List<String> values) {
            return in(maPic, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicNotIn(List<String> values) {
            return notIn(maPic, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicBetween(String value1, String value2) {
            return between(maPic, value1, value2);
        }

        public ShiguMarketActivitysExample.Criteria andMaPicNotBetween(String value1, String value2) {
            return notBetween(maPic, value1, value2);
        }
        public ShiguMarketActivitysExample.Criteria andMaIdIsNull() {
            return isNull(maId);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdIsNotNull() {
            return isNotNull(maId);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdEqualTo(Long value) {
            return equalTo(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdNotEqualTo(Long value) {
            return notEqualTo(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdGreaterThan(Long value) {
            return greaterThan(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdLessThan(Long value) {
            return lessThan(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(maId, value);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdIn(List<Long> values) {
            return in(maId, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdNotIn(List<Long> values) {
            return notIn(maId, values);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdBetween(Long value1, Long value2) {
            return between(maId, value1, value2);
        }

        public ShiguMarketActivitysExample.Criteria andMaIdNotBetween(Long value1, Long value2) {
            return notBetween(maId, value1, value2);
        }
    }
}