package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.KdnTraceInfo;

import java.util.*;
public class KdnTraceInfoExample extends SgExample<KdnTraceInfoExample.Criteria> {
    public static final Class<KdnTraceInfo> beanClass = KdnTraceInfo.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn acceptTime;
    public static EntityColumn remark;
    public static EntityColumn id;
    public static EntityColumn acceptStation;
    public static EntityColumn logisticCode;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        acceptTime = listMap.get("acceptTime");
        remark = listMap.get("remark");
        id = listMap.get("id");
        acceptStation = listMap.get("acceptStation");
        logisticCode = listMap.get("logisticCode");
        }

    public KdnTraceInfoExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected KdnTraceInfoExample.Criteria createCriteriaInternal() {
        return new KdnTraceInfoExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeIsNull() {
            return isNull(acceptTime);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeIsNotNull() {
            return isNotNull(acceptTime);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeEqualTo(Date value) {
            return equalTo(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeNotEqualTo(Date value) {
            return notEqualTo(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeGreaterThan(Date value) {
            return greaterThan(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeLessThan(Date value) {
            return lessThan(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(acceptTime, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeIn(List<Date> values) {
            return in(acceptTime, values);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeNotIn(List<Date> values) {
            return notIn(acceptTime, values);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeBetween(Date value1, Date value2) {
            return between(acceptTime, value1, value2);
        }

        public KdnTraceInfoExample.Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            return notBetween(acceptTime, value1, value2);
        }
        public KdnTraceInfoExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public KdnTraceInfoExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public KdnTraceInfoExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public KdnTraceInfoExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public KdnTraceInfoExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public KdnTraceInfoExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public KdnTraceInfoExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public KdnTraceInfoExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public KdnTraceInfoExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public KdnTraceInfoExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public KdnTraceInfoExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public KdnTraceInfoExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public KdnTraceInfoExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public KdnTraceInfoExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public KdnTraceInfoExample.Criteria andAcceptStationIsNull() {
            return isNull(acceptStation);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationIsNotNull() {
            return isNotNull(acceptStation);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationEqualTo(String value) {
            return equalTo(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationNotEqualTo(String value) {
            return notEqualTo(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationGreaterThan(String value) {
            return greaterThan(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationLessThan(String value) {
            return lessThan(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationLike(String value) {
            return like(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationNotLike(String value) {
            return notLike(acceptStation, value);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationIn(List<String> values) {
            return in(acceptStation, values);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationNotIn(List<String> values) {
            return notIn(acceptStation, values);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationBetween(String value1, String value2) {
            return between(acceptStation, value1, value2);
        }

        public KdnTraceInfoExample.Criteria andAcceptStationNotBetween(String value1, String value2) {
            return notBetween(acceptStation, value1, value2);
        }
        public KdnTraceInfoExample.Criteria andLogisticCodeIsNull() {
            return isNull(logisticCode);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeIsNotNull() {
            return isNotNull(logisticCode);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeEqualTo(String value) {
            return equalTo(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeNotEqualTo(String value) {
            return notEqualTo(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeGreaterThan(String value) {
            return greaterThan(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeLessThan(String value) {
            return lessThan(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeLike(String value) {
            return like(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeNotLike(String value) {
            return notLike(logisticCode, value);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeIn(List<String> values) {
            return in(logisticCode, values);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeNotIn(List<String> values) {
            return notIn(logisticCode, values);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeBetween(String value1, String value2) {
            return between(logisticCode, value1, value2);
        }

        public KdnTraceInfoExample.Criteria andLogisticCodeNotBetween(String value1, String value2) {
            return notBetween(logisticCode, value1, value2);
        }
    }
}