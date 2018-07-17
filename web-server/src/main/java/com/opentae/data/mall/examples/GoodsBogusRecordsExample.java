package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsBogusRecords;

import java.util.*;

public class GoodsBogusRecordsExample extends SgExample<GoodsBogusRecordsExample.Criteria> {
    public static final Class<GoodsBogusRecords> beanClass = GoodsBogusRecords.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn brId;
    public static EntityColumn goodsId;
    public static EntityColumn time;
    public static EntityColumn day;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        brId = listMap.get("brId");
        goodsId = listMap.get("goodsId");
        time = listMap.get("time");
        day = listMap.get("day");
        }

    public GoodsBogusRecordsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsBogusRecordsExample.Criteria createCriteriaInternal() {
        return new GoodsBogusRecordsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdIsNull() {
            return isNull(brId);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdIsNotNull() {
            return isNotNull(brId);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdEqualTo(Long value) {
            return equalTo(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdNotEqualTo(Long value) {
            return notEqualTo(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdGreaterThan(Long value) {
            return greaterThan(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdLessThan(Long value) {
            return lessThan(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(brId, value);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdIn(List<Long> values) {
            return in(brId, values);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdNotIn(List<Long> values) {
            return notIn(brId, values);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdBetween(Long value1, Long value2) {
            return between(brId, value1, value2);
        }

        public GoodsBogusRecordsExample.Criteria andBrIdNotBetween(Long value1, Long value2) {
            return notBetween(brId, value1, value2);
        }
        public GoodsBogusRecordsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsBogusRecordsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsBogusRecordsExample.Criteria andTimeIsNull() {
            return isNull(time);
        }

        public GoodsBogusRecordsExample.Criteria andTimeIsNotNull() {
            return isNotNull(time);
        }

        public GoodsBogusRecordsExample.Criteria andTimeEqualTo(Date value) {
            return equalTo(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeNotEqualTo(Date value) {
            return notEqualTo(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeGreaterThan(Date value) {
            return greaterThan(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeLessThan(Date value) {
            return lessThan(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(time, value);
        }

        public GoodsBogusRecordsExample.Criteria andTimeIn(List<Date> values) {
            return in(time, values);
        }

        public GoodsBogusRecordsExample.Criteria andTimeNotIn(List<Date> values) {
            return notIn(time, values);
        }

        public GoodsBogusRecordsExample.Criteria andTimeBetween(Date value1, Date value2) {
            return between(time, value1, value2);
        }

        public GoodsBogusRecordsExample.Criteria andTimeNotBetween(Date value1, Date value2) {
            return notBetween(time, value1, value2);
        }
        public GoodsBogusRecordsExample.Criteria andDayIsNull() {
            return isNull(day);
        }

        public GoodsBogusRecordsExample.Criteria andDayIsNotNull() {
            return isNotNull(day);
        }

        public GoodsBogusRecordsExample.Criteria andDayEqualTo(String value) {
            return equalTo(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayNotEqualTo(String value) {
            return notEqualTo(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayGreaterThan(String value) {
            return greaterThan(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayLessThan(String value) {
            return lessThan(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayLike(String value) {
            return like(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayNotLike(String value) {
            return notLike(day, value);
        }

        public GoodsBogusRecordsExample.Criteria andDayIn(List<String> values) {
            return in(day, values);
        }

        public GoodsBogusRecordsExample.Criteria andDayNotIn(List<String> values) {
            return notIn(day, values);
        }

        public GoodsBogusRecordsExample.Criteria andDayBetween(String value1, String value2) {
            return between(day, value1, value2);
        }

        public GoodsBogusRecordsExample.Criteria andDayNotBetween(String value1, String value2) {
            return notBetween(day, value1, value2);
        }
    }
}