package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaStock;

import java.util.*;

public class DaifaStockExample extends SgExample<DaifaStockExample.Criteria> {
    public static final Class<DaifaStock> beanClass = DaifaStock.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dfTradeId;
    public static EntityColumn sellerId;
    public static EntityColumn startInTime;
    public static EntityColumn stockRemark;
    public static EntityColumn stockId;
    public static EntityColumn dfOrderId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfTradeId = listMap.get("dfTradeId");
        sellerId = listMap.get("sellerId");
        startInTime = listMap.get("startInTime");
        stockRemark = listMap.get("stockRemark");
        stockId = listMap.get("stockId");
        dfOrderId = listMap.get("dfOrderId");
        }

    public DaifaStockExample() {
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

        public Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public Criteria andStartInTimeIsNull() {
            return isNull(startInTime);
        }

        public Criteria andStartInTimeIsNotNull() {
            return isNotNull(startInTime);
        }

        public Criteria andStartInTimeEqualTo(Date value) {
            return equalTo(startInTime, value);
        }

        public Criteria andStartInTimeNotEqualTo(Date value) {
            return notEqualTo(startInTime, value);
        }

        public Criteria andStartInTimeGreaterThan(Date value) {
            return greaterThan(startInTime, value);
        }

        public Criteria andStartInTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startInTime, value);
        }

        public Criteria andStartInTimeLessThan(Date value) {
            return lessThan(startInTime, value);
        }

        public Criteria andStartInTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startInTime, value);
        }

        public Criteria andStartInTimeIn(List<Date> values) {
            return in(startInTime, values);
        }

        public Criteria andStartInTimeNotIn(List<Date> values) {
            return notIn(startInTime, values);
        }

        public Criteria andStartInTimeBetween(Date value1, Date value2) {
            return between(startInTime, value1, value2);
        }

        public Criteria andStartInTimeNotBetween(Date value1, Date value2) {
            return notBetween(startInTime, value1, value2);
        }
        public Criteria andStockRemarkIsNull() {
            return isNull(stockRemark);
        }

        public Criteria andStockRemarkIsNotNull() {
            return isNotNull(stockRemark);
        }

        public Criteria andStockRemarkEqualTo(String value) {
            return equalTo(stockRemark, value);
        }

        public Criteria andStockRemarkNotEqualTo(String value) {
            return notEqualTo(stockRemark, value);
        }

        public Criteria andStockRemarkGreaterThan(String value) {
            return greaterThan(stockRemark, value);
        }

        public Criteria andStockRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockRemark, value);
        }

        public Criteria andStockRemarkLessThan(String value) {
            return lessThan(stockRemark, value);
        }

        public Criteria andStockRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockRemark, value);
        }

        public Criteria andStockRemarkLike(String value) {
            return like(stockRemark, value);
        }

        public Criteria andStockRemarkNotLike(String value) {
            return notLike(stockRemark, value);
        }

        public Criteria andStockRemarkIn(List<String> values) {
            return in(stockRemark, values);
        }

        public Criteria andStockRemarkNotIn(List<String> values) {
            return notIn(stockRemark, values);
        }

        public Criteria andStockRemarkBetween(String value1, String value2) {
            return between(stockRemark, value1, value2);
        }

        public Criteria andStockRemarkNotBetween(String value1, String value2) {
            return notBetween(stockRemark, value1, value2);
        }
        public Criteria andStockIdIsNull() {
            return isNull(stockId);
        }

        public Criteria andStockIdIsNotNull() {
            return isNotNull(stockId);
        }

        public Criteria andStockIdEqualTo(Long value) {
            return equalTo(stockId, value);
        }

        public Criteria andStockIdNotEqualTo(Long value) {
            return notEqualTo(stockId, value);
        }

        public Criteria andStockIdGreaterThan(Long value) {
            return greaterThan(stockId, value);
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockId, value);
        }

        public Criteria andStockIdLessThan(Long value) {
            return lessThan(stockId, value);
        }

        public Criteria andStockIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockId, value);
        }

        public Criteria andStockIdIn(List<Long> values) {
            return in(stockId, values);
        }

        public Criteria andStockIdNotIn(List<Long> values) {
            return notIn(stockId, values);
        }

        public Criteria andStockIdBetween(Long value1, Long value2) {
            return between(stockId, value1, value2);
        }

        public Criteria andStockIdNotBetween(Long value1, Long value2) {
            return notBetween(stockId, value1, value2);
        }
        public Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
    }
}