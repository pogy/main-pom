package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderStatusRecord;

import java.util.*;
public class OrderStatusRecordExample extends SgExample<OrderStatusRecordExample.Criteria> {
    public static final Class<OrderStatusRecord> beanClass = OrderStatusRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn statusId;
    public static EntityColumn createTime;
    public static EntityColumn oid;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        statusId = listMap.get("statusId");
        createTime = listMap.get("createTime");
        oid = listMap.get("oid");
        status = listMap.get("status");
        }

    public OrderStatusRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderStatusRecordExample.Criteria createCriteriaInternal() {
        return new OrderStatusRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderStatusRecordExample.Criteria andStatusIdIsNull() {
            return isNull(statusId);
        }

        public OrderStatusRecordExample.Criteria andStatusIdIsNotNull() {
            return isNotNull(statusId);
        }

        public OrderStatusRecordExample.Criteria andStatusIdEqualTo(Long value) {
            return equalTo(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotEqualTo(Long value) {
            return notEqualTo(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdGreaterThan(Long value) {
            return greaterThan(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdLessThan(Long value) {
            return lessThan(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(statusId, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIdIn(List<Long> values) {
            return in(statusId, values);
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotIn(List<Long> values) {
            return notIn(statusId, values);
        }

        public OrderStatusRecordExample.Criteria andStatusIdBetween(Long value1, Long value2) {
            return between(statusId, value1, value2);
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotBetween(Long value1, Long value2) {
            return notBetween(statusId, value1, value2);
        }
        public OrderStatusRecordExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public OrderStatusRecordExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public OrderStatusRecordExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public OrderStatusRecordExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public OrderStatusRecordExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public OrderStatusRecordExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public OrderStatusRecordExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public OrderStatusRecordExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public OrderStatusRecordExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public OrderStatusRecordExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public OrderStatusRecordExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public OrderStatusRecordExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public OrderStatusRecordExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public OrderStatusRecordExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public OrderStatusRecordExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}
