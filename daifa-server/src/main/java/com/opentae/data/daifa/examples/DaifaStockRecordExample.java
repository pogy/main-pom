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
    protected DaifaStockRecordExample.Criteria createCriteriaInternal() {
        return new DaifaStockRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaStockRecordExample.Criteria andInTimeIsNull() {
            return isNull(inTime);
        }

        public DaifaStockRecordExample.Criteria andInTimeIsNotNull() {
            return isNotNull(inTime);
        }

        public DaifaStockRecordExample.Criteria andInTimeEqualTo(Date value) {
            return equalTo(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeNotEqualTo(Date value) {
            return notEqualTo(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeGreaterThan(Date value) {
            return greaterThan(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeLessThan(Date value) {
            return lessThan(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(inTime, value);
        }

        public DaifaStockRecordExample.Criteria andInTimeIn(List<Date> values) {
            return in(inTime, values);
        }

        public DaifaStockRecordExample.Criteria andInTimeNotIn(List<Date> values) {
            return notIn(inTime, values);
        }

        public DaifaStockRecordExample.Criteria andInTimeBetween(Date value1, Date value2) {
            return between(inTime, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andInTimeNotBetween(Date value1, Date value2) {
            return notBetween(inTime, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andPiCodeIsNull() {
            return isNull(piCode);
        }

        public DaifaStockRecordExample.Criteria andPiCodeIsNotNull() {
            return isNotNull(piCode);
        }

        public DaifaStockRecordExample.Criteria andPiCodeEqualTo(String value) {
            return equalTo(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeNotEqualTo(String value) {
            return notEqualTo(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeGreaterThan(String value) {
            return greaterThan(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeLessThan(String value) {
            return lessThan(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeLike(String value) {
            return like(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeNotLike(String value) {
            return notLike(piCode, value);
        }

        public DaifaStockRecordExample.Criteria andPiCodeIn(List<String> values) {
            return in(piCode, values);
        }

        public DaifaStockRecordExample.Criteria andPiCodeNotIn(List<String> values) {
            return notIn(piCode, values);
        }

        public DaifaStockRecordExample.Criteria andPiCodeBetween(String value1, String value2) {
            return between(piCode, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andPiCodeNotBetween(String value1, String value2) {
            return notBetween(piCode, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andDaifaWorkerIsNull() {
            return isNull(daifaWorker);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIsNotNull() {
            return isNotNull(daifaWorker);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerEqualTo(String value) {
            return equalTo(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerNotEqualTo(String value) {
            return notEqualTo(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerGreaterThan(String value) {
            return greaterThan(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerLessThan(String value) {
            return lessThan(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerLike(String value) {
            return like(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerNotLike(String value) {
            return notLike(daifaWorker, value);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerIn(List<String> values) {
            return in(daifaWorker, values);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerNotIn(List<String> values) {
            return notIn(daifaWorker, values);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerBetween(String value1, String value2) {
            return between(daifaWorker, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andDaifaWorkerNotBetween(String value1, String value2) {
            return notBetween(daifaWorker, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andInOutTypeIsNull() {
            return isNull(inOutType);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeIsNotNull() {
            return isNotNull(inOutType);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeEqualTo(Integer value) {
            return equalTo(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeNotEqualTo(Integer value) {
            return notEqualTo(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeGreaterThan(Integer value) {
            return greaterThan(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeLessThan(Integer value) {
            return lessThan(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(inOutType, value);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeIn(List<Integer> values) {
            return in(inOutType, values);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeNotIn(List<Integer> values) {
            return notIn(inOutType, values);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeBetween(Integer value1, Integer value2) {
            return between(inOutType, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andInOutTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(inOutType, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andStockIdIsNull() {
            return isNull(stockId);
        }

        public DaifaStockRecordExample.Criteria andStockIdIsNotNull() {
            return isNotNull(stockId);
        }

        public DaifaStockRecordExample.Criteria andStockIdEqualTo(Long value) {
            return equalTo(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdNotEqualTo(Long value) {
            return notEqualTo(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdGreaterThan(Long value) {
            return greaterThan(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdLessThan(Long value) {
            return lessThan(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockId, value);
        }

        public DaifaStockRecordExample.Criteria andStockIdIn(List<Long> values) {
            return in(stockId, values);
        }

        public DaifaStockRecordExample.Criteria andStockIdNotIn(List<Long> values) {
            return notIn(stockId, values);
        }

        public DaifaStockRecordExample.Criteria andStockIdBetween(Long value1, Long value2) {
            return between(stockId, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andStockIdNotBetween(Long value1, Long value2) {
            return notBetween(stockId, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andOutTimeIsNull() {
            return isNull(outTime);
        }

        public DaifaStockRecordExample.Criteria andOutTimeIsNotNull() {
            return isNotNull(outTime);
        }

        public DaifaStockRecordExample.Criteria andOutTimeEqualTo(Date value) {
            return equalTo(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeNotEqualTo(Date value) {
            return notEqualTo(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeGreaterThan(Date value) {
            return greaterThan(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeLessThan(Date value) {
            return lessThan(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(outTime, value);
        }

        public DaifaStockRecordExample.Criteria andOutTimeIn(List<Date> values) {
            return in(outTime, values);
        }

        public DaifaStockRecordExample.Criteria andOutTimeNotIn(List<Date> values) {
            return notIn(outTime, values);
        }

        public DaifaStockRecordExample.Criteria andOutTimeBetween(Date value1, Date value2) {
            return between(outTime, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andOutTimeNotBetween(Date value1, Date value2) {
            return notBetween(outTime, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andStockRecordIdIsNull() {
            return isNull(stockRecordId);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdIsNotNull() {
            return isNotNull(stockRecordId);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdEqualTo(Long value) {
            return equalTo(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdNotEqualTo(Long value) {
            return notEqualTo(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdGreaterThan(Long value) {
            return greaterThan(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdLessThan(Long value) {
            return lessThan(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(stockRecordId, value);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdIn(List<Long> values) {
            return in(stockRecordId, values);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdNotIn(List<Long> values) {
            return notIn(stockRecordId, values);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdBetween(Long value1, Long value2) {
            return between(stockRecordId, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andStockRecordIdNotBetween(Long value1, Long value2) {
            return notBetween(stockRecordId, value1, value2);
        }
        public DaifaStockRecordExample.Criteria andReturnTimeIsNull() {
            return isNull(returnTime);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeIsNotNull() {
            return isNotNull(returnTime);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeEqualTo(Date value) {
            return equalTo(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeNotEqualTo(Date value) {
            return notEqualTo(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeGreaterThan(Date value) {
            return greaterThan(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeLessThan(Date value) {
            return lessThan(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(returnTime, value);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeIn(List<Date> values) {
            return in(returnTime, values);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeNotIn(List<Date> values) {
            return notIn(returnTime, values);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeBetween(Date value1, Date value2) {
            return between(returnTime, value1, value2);
        }

        public DaifaStockRecordExample.Criteria andReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(returnTime, value1, value2);
        }
    }
}