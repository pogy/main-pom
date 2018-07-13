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
    protected GoodsBogusUploadRecordsExample.Criteria createCriteriaInternal() {
        return new GoodsBogusUploadRecordsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdIsNull() {
            return isNull(brId);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdIsNotNull() {
            return isNotNull(brId);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdEqualTo(Long value) {
            return equalTo(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdNotEqualTo(Long value) {
            return notEqualTo(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdGreaterThan(Long value) {
            return greaterThan(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdLessThan(Long value) {
            return lessThan(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(brId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdIn(List<Long> values) {
            return in(brId, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdNotIn(List<Long> values) {
            return notIn(brId, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdBetween(Long value1, Long value2) {
            return between(brId, value1, value2);
        }

        public GoodsBogusUploadRecordsExample.Criteria andBrIdNotBetween(Long value1, Long value2) {
            return notBetween(brId, value1, value2);
        }
        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsBogusUploadRecordsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsBogusUploadRecordsExample.Criteria andTimeIsNull() {
            return isNull(time);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeIsNotNull() {
            return isNotNull(time);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeEqualTo(Date value) {
            return equalTo(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeNotEqualTo(Date value) {
            return notEqualTo(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeGreaterThan(Date value) {
            return greaterThan(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeLessThan(Date value) {
            return lessThan(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(time, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeIn(List<Date> values) {
            return in(time, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeNotIn(List<Date> values) {
            return notIn(time, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeBetween(Date value1, Date value2) {
            return between(time, value1, value2);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTimeNotBetween(Date value1, Date value2) {
            return notBetween(time, value1, value2);
        }
        public GoodsBogusUploadRecordsExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public GoodsBogusUploadRecordsExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public GoodsBogusUploadRecordsExample.Criteria andDayIsNull() {
            return isNull(day);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayIsNotNull() {
            return isNotNull(day);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayEqualTo(String value) {
            return equalTo(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayNotEqualTo(String value) {
            return notEqualTo(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayGreaterThan(String value) {
            return greaterThan(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayLessThan(String value) {
            return lessThan(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayLike(String value) {
            return like(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayNotLike(String value) {
            return notLike(day, value);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayIn(List<String> values) {
            return in(day, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayNotIn(List<String> values) {
            return notIn(day, values);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayBetween(String value1, String value2) {
            return between(day, value1, value2);
        }

        public GoodsBogusUploadRecordsExample.Criteria andDayNotBetween(String value1, String value2) {
            return notBetween(day, value1, value2);
        }
    }
}