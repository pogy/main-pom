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
    protected DaifaStockExample.Criteria createCriteriaInternal() {
        return new DaifaStockExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaStockExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaStockExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaStockExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaStockExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaStockExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaStockExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaStockExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaStockExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaStockExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaStockExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaStockExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaStockExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaStockExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaStockExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaStockExample.Criteria andStartInTimeIsNull() {
            return isNull(startInTime);
        }

        public DaifaStockExample.Criteria andStartInTimeIsNotNull() {
            return isNotNull(startInTime);
        }

        public DaifaStockExample.Criteria andStartInTimeEqualTo(Date value) {
            return equalTo(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeNotEqualTo(Date value) {
            return notEqualTo(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeGreaterThan(Date value) {
            return greaterThan(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeLessThan(Date value) {
            return lessThan(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startInTime, value);
        }

        public DaifaStockExample.Criteria andStartInTimeIn(List<Date> values) {
            return in(startInTime, values);
        }

        public DaifaStockExample.Criteria andStartInTimeNotIn(List<Date> values) {
            return notIn(startInTime, values);
        }

        public DaifaStockExample.Criteria andStartInTimeBetween(Date value1, Date value2) {
            return between(startInTime, value1, value2);
        }

        public DaifaStockExample.Criteria andStartInTimeNotBetween(Date value1, Date value2) {
            return notBetween(startInTime, value1, value2);
        }
        public DaifaStockExample.Criteria andStockRemarkIsNull() {
            return isNull(stockRemark);
        }

        public DaifaStockExample.Criteria andStockRemarkIsNotNull() {
            return isNotNull(stockRemark);
        }

        public DaifaStockExample.Criteria andStockRemarkEqualTo(String value) {
            return equalTo(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkNotEqualTo(String value) {
            return notEqualTo(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkGreaterThan(String value) {
            return greaterThan(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkLessThan(String value) {
            return lessThan(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkLike(String value) {
            return like(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkNotLike(String value) {
            return notLike(stockRemark, value);
        }

        public DaifaStockExample.Criteria andStockRemarkIn(List<String> values) {
            return in(stockRemark, values);
        }

        public DaifaStockExample.Criteria andStockRemarkNotIn(List<String> values) {
            return notIn(stockRemark, values);
        }

        public DaifaStockExample.Criteria andStockRemarkBetween(String value1, String value2) {
            return between(stockRemark, value1, value2);
        }

        public DaifaStockExample.Criteria andStockRemarkNotBetween(String value1, String value2) {
            return notBetween(stockRemark, value1, value2);
        }
        public DaifaStockExample.Criteria andStockIdIsNull() {
            return isNull(stockId);
        }

        public DaifaStockExample.Criteria andStockIdIsNotNull() {
            return isNotNull(stockId);
        }

        public DaifaStockExample.Criteria andStockIdEqualTo(Long value) {
            return equalTo(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdNotEqualTo(Long value) {
            return notEqualTo(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdGreaterThan(Long value) {
            return greaterThan(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdLessThan(Long value) {
            return lessThan(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockId, value);
        }

        public DaifaStockExample.Criteria andStockIdIn(List<Long> values) {
            return in(stockId, values);
        }

        public DaifaStockExample.Criteria andStockIdNotIn(List<Long> values) {
            return notIn(stockId, values);
        }

        public DaifaStockExample.Criteria andStockIdBetween(Long value1, Long value2) {
            return between(stockId, value1, value2);
        }

        public DaifaStockExample.Criteria andStockIdNotBetween(Long value1, Long value2) {
            return notBetween(stockId, value1, value2);
        }
        public DaifaStockExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaStockExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaStockExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaStockExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaStockExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaStockExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaStockExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
    }
}