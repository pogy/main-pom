package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaStockRecord;

import java.util.*;

public class DaifaStockRecordExample extends SgExample<DaifaStockRecordExample.Criteria> {
    public static final Class<DaifaStockRecord> beanClass = DaifaStockRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn inTime;
    public static EntityColumn piCode;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn daifaWorker;
    public static EntityColumn inOutType;
    public static EntityColumn stockId;
    public static EntityColumn outTime;
    public static EntityColumn stockRecordId;
    public static EntityColumn returnTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        inTime = listMap.get("inTime");
        piCode = listMap.get("piCode");
        daifaWorkerId = listMap.get("daifaWorkerId");
        daifaWorker = listMap.get("daifaWorker");
        inOutType = listMap.get("inOutType");
        stockId = listMap.get("stockId");
        outTime = listMap.get("outTime");
        stockRecordId = listMap.get("stockRecordId");
        returnTime = listMap.get("returnTime");
        }

    public DaifaStockRecordExample() {
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

        public Criteria andInTimeIsNull() {
            return isNull(inTime);
        }

        public Criteria andInTimeIsNotNull() {
            return isNotNull(inTime);
        }

        public Criteria andInTimeEqualTo(Date value) {
            return equalTo(inTime, value);
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            return notEqualTo(inTime, value);
        }

        public Criteria andInTimeGreaterThan(Date value) {
            return greaterThan(inTime, value);
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(inTime, value);
        }

        public Criteria andInTimeLessThan(Date value) {
            return lessThan(inTime, value);
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(inTime, value);
        }

        public Criteria andInTimeIn(List<Date> values) {
            return in(inTime, values);
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            return notIn(inTime, values);
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            return between(inTime, value1, value2);
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            return notBetween(inTime, value1, value2);
        }
        public Criteria andPiCodeIsNull() {
            return isNull(piCode);
        }

        public Criteria andPiCodeIsNotNull() {
            return isNotNull(piCode);
        }

        public Criteria andPiCodeEqualTo(String value) {
            return equalTo(piCode, value);
        }

        public Criteria andPiCodeNotEqualTo(String value) {
            return notEqualTo(piCode, value);
        }

        public Criteria andPiCodeGreaterThan(String value) {
            return greaterThan(piCode, value);
        }

        public Criteria andPiCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piCode, value);
        }

        public Criteria andPiCodeLessThan(String value) {
            return lessThan(piCode, value);
        }

        public Criteria andPiCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piCode, value);
        }

        public Criteria andPiCodeLike(String value) {
            return like(piCode, value);
        }

        public Criteria andPiCodeNotLike(String value) {
            return notLike(piCode, value);
        }

        public Criteria andPiCodeIn(List<String> values) {
            return in(piCode, values);
        }

        public Criteria andPiCodeNotIn(List<String> values) {
            return notIn(piCode, values);
        }

        public Criteria andPiCodeBetween(String value1, String value2) {
            return between(piCode, value1, value2);
        }

        public Criteria andPiCodeNotBetween(String value1, String value2) {
            return notBetween(piCode, value1, value2);
        }
        public Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public Criteria andInOutTypeIsNull() {
            return isNull(inOutType);
        }

        public Criteria andInOutTypeIsNotNull() {
            return isNotNull(inOutType);
        }

        public Criteria andInOutTypeEqualTo(Integer value) {
            return equalTo(inOutType, value);
        }

        public Criteria andInOutTypeNotEqualTo(Integer value) {
            return notEqualTo(inOutType, value);
        }

        public Criteria andInOutTypeGreaterThan(Integer value) {
            return greaterThan(inOutType, value);
        }

        public Criteria andInOutTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inOutType, value);
        }

        public Criteria andInOutTypeLessThan(Integer value) {
            return lessThan(inOutType, value);
        }

        public Criteria andInOutTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inOutType, value);
        }

        public Criteria andInOutTypeIn(List<Integer> values) {
            return in(inOutType, values);
        }

        public Criteria andInOutTypeNotIn(List<Integer> values) {
            return notIn(inOutType, values);
        }

        public Criteria andInOutTypeBetween(Integer value1, Integer value2) {
            return between(inOutType, value1, value2);
        }

        public Criteria andInOutTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(inOutType, value1, value2);
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
        public Criteria andOutTimeIsNull() {
            return isNull(outTime);
        }

        public Criteria andOutTimeIsNotNull() {
            return isNotNull(outTime);
        }

        public Criteria andOutTimeEqualTo(Date value) {
            return equalTo(outTime, value);
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            return notEqualTo(outTime, value);
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            return greaterThan(outTime, value);
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(outTime, value);
        }

        public Criteria andOutTimeLessThan(Date value) {
            return lessThan(outTime, value);
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(outTime, value);
        }

        public Criteria andOutTimeIn(List<Date> values) {
            return in(outTime, values);
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            return notIn(outTime, values);
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            return between(outTime, value1, value2);
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            return notBetween(outTime, value1, value2);
        }
        public Criteria andStockRecordIdIsNull() {
            return isNull(stockRecordId);
        }

        public Criteria andStockRecordIdIsNotNull() {
            return isNotNull(stockRecordId);
        }

        public Criteria andStockRecordIdEqualTo(Long value) {
            return equalTo(stockRecordId, value);
        }

        public Criteria andStockRecordIdNotEqualTo(Long value) {
            return notEqualTo(stockRecordId, value);
        }

        public Criteria andStockRecordIdGreaterThan(Long value) {
            return greaterThan(stockRecordId, value);
        }

        public Criteria andStockRecordIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockRecordId, value);
        }

        public Criteria andStockRecordIdLessThan(Long value) {
            return lessThan(stockRecordId, value);
        }

        public Criteria andStockRecordIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockRecordId, value);
        }

        public Criteria andStockRecordIdIn(List<Long> values) {
            return in(stockRecordId, values);
        }

        public Criteria andStockRecordIdNotIn(List<Long> values) {
            return notIn(stockRecordId, values);
        }

        public Criteria andStockRecordIdBetween(Long value1, Long value2) {
            return between(stockRecordId, value1, value2);
        }

        public Criteria andStockRecordIdNotBetween(Long value1, Long value2) {
            return notBetween(stockRecordId, value1, value2);
        }
        public Criteria andReturnTimeIsNull() {
            return isNull(returnTime);
        }

        public Criteria andReturnTimeIsNotNull() {
            return isNotNull(returnTime);
        }

        public Criteria andReturnTimeEqualTo(Date value) {
            return equalTo(returnTime, value);
        }

        public Criteria andReturnTimeNotEqualTo(Date value) {
            return notEqualTo(returnTime, value);
        }

        public Criteria andReturnTimeGreaterThan(Date value) {
            return greaterThan(returnTime, value);
        }

        public Criteria andReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnTime, value);
        }

        public Criteria andReturnTimeLessThan(Date value) {
            return lessThan(returnTime, value);
        }

        public Criteria andReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnTime, value);
        }

        public Criteria andReturnTimeIn(List<Date> values) {
            return in(returnTime, values);
        }

        public Criteria andReturnTimeNotIn(List<Date> values) {
            return notIn(returnTime, values);
        }

        public Criteria andReturnTimeBetween(Date value1, Date value2) {
            return between(returnTime, value1, value2);
        }

        public Criteria andReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnTime, value1, value2);
        }
    }
}