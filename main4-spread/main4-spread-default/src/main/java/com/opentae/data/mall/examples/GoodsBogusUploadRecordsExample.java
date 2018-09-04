package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsBogusUploadRecords;

import java.util.*;

public class GoodsBogusUploadRecordsExample extends SgExample<GoodsBogusUploadRecordsExample.Criteria> {
    public static final Class<GoodsBogusUploadRecords> beanClass = GoodsBogusUploadRecords.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn brId;
    public static EntityColumn goodsId;
    public static EntityColumn time;
    public static EntityColumn type;
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
        type = listMap.get("type");
        day = listMap.get("day");
        }

    public GoodsBogusUploadRecordsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andBrIdIsNull() {
            return isNull(brId);
        }

        public Criteria andBrIdIsNotNull() {
            return isNotNull(brId);
        }

        public Criteria andBrIdEqualTo(Long value) {
            return equalTo(brId, value);
        }

        public Criteria andBrIdNotEqualTo(Long value) {
            return notEqualTo(brId, value);
        }

        public Criteria andBrIdGreaterThan(Long value) {
            return greaterThan(brId, value);
        }

        public Criteria andBrIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(brId, value);
        }

        public Criteria andBrIdLessThan(Long value) {
            return lessThan(brId, value);
        }

        public Criteria andBrIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(brId, value);
        }

        public Criteria andBrIdIn(List<Long> values) {
            return in(brId, values);
        }

        public Criteria andBrIdNotIn(List<Long> values) {
            return notIn(brId, values);
        }

        public Criteria andBrIdBetween(Long value1, Long value2) {
            return between(brId, value1, value2);
        }

        public Criteria andBrIdNotBetween(Long value1, Long value2) {
            return notBetween(brId, value1, value2);
        }
        public Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public Criteria andTimeIsNull() {
            return isNull(time);
        }

        public Criteria andTimeIsNotNull() {
            return isNotNull(time);
        }

        public Criteria andTimeEqualTo(Date value) {
            return equalTo(time, value);
        }

        public Criteria andTimeNotEqualTo(Date value) {
            return notEqualTo(time, value);
        }

        public Criteria andTimeGreaterThan(Date value) {
            return greaterThan(time, value);
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(time, value);
        }

        public Criteria andTimeLessThan(Date value) {
            return lessThan(time, value);
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(time, value);
        }

        public Criteria andTimeIn(List<Date> values) {
            return in(time, values);
        }

        public Criteria andTimeNotIn(List<Date> values) {
            return notIn(time, values);
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            return between(time, value1, value2);
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            return notBetween(time, value1, value2);
        }
        public Criteria andTypeIsNull() {
            return isNull(type);
        }

        public Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public Criteria andDayIsNull() {
            return isNull(day);
        }

        public Criteria andDayIsNotNull() {
            return isNotNull(day);
        }

        public Criteria andDayEqualTo(String value) {
            return equalTo(day, value);
        }

        public Criteria andDayNotEqualTo(String value) {
            return notEqualTo(day, value);
        }

        public Criteria andDayGreaterThan(String value) {
            return greaterThan(day, value);
        }

        public Criteria andDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(day, value);
        }

        public Criteria andDayLessThan(String value) {
            return lessThan(day, value);
        }

        public Criteria andDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(day, value);
        }

        public Criteria andDayLike(String value) {
            return like(day, value);
        }

        public Criteria andDayNotLike(String value) {
            return notLike(day, value);
        }

        public Criteria andDayIn(List<String> values) {
            return in(day, values);
        }

        public Criteria andDayNotIn(List<String> values) {
            return notIn(day, values);
        }

        public Criteria andDayBetween(String value1, String value2) {
            return between(day, value1, value2);
        }

        public Criteria andDayNotBetween(String value1, String value2) {
            return notBetween(day, value1, value2);
        }
    }
}