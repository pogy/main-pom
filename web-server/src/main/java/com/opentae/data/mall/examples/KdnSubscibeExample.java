package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.KdnSubscibe;

import java.util.*;
public class KdnSubscibeExample extends SgExample<KdnSubscibeExample.Criteria> {
    public static final Class<KdnSubscibe> beanClass = KdnSubscibe.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtUpdate;
    public static EntityColumn callBack;
    public static EntityColumn id;
    public static EntityColumn oid;
    public static EntityColumn gmtCreate;
    public static EntityColumn logisticState;
    public static EntityColumn logisticCode;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtUpdate = listMap.get("gmtUpdate");
        callBack = listMap.get("callBack");
        id = listMap.get("id");
        oid = listMap.get("oid");
        gmtCreate = listMap.get("gmtCreate");
        logisticState = listMap.get("logisticState");
        logisticCode = listMap.get("logisticCode");
        }

    public KdnSubscibeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected KdnSubscibeExample.Criteria createCriteriaInternal() {
        return new KdnSubscibeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateIsNull() {
            return isNull(gmtUpdate);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateIsNotNull() {
            return isNotNull(gmtUpdate);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateEqualTo(Date value) {
            return equalTo(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateNotEqualTo(Date value) {
            return notEqualTo(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateGreaterThan(Date value) {
            return greaterThan(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateLessThan(Date value) {
            return lessThan(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtUpdate, value);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateIn(List<Date> values) {
            return in(gmtUpdate, values);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateNotIn(List<Date> values) {
            return notIn(gmtUpdate, values);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateBetween(Date value1, Date value2) {
            return between(gmtUpdate, value1, value2);
        }

        public KdnSubscibeExample.Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            return notBetween(gmtUpdate, value1, value2);
        }
        public KdnSubscibeExample.Criteria andCallBackIsNull() {
            return isNull(callBack);
        }

        public KdnSubscibeExample.Criteria andCallBackIsNotNull() {
            return isNotNull(callBack);
        }

        public KdnSubscibeExample.Criteria andCallBackEqualTo(String value) {
            return equalTo(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackNotEqualTo(String value) {
            return notEqualTo(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackGreaterThan(String value) {
            return greaterThan(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackLessThan(String value) {
            return lessThan(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackLike(String value) {
            return like(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackNotLike(String value) {
            return notLike(callBack, value);
        }

        public KdnSubscibeExample.Criteria andCallBackIn(List<String> values) {
            return in(callBack, values);
        }

        public KdnSubscibeExample.Criteria andCallBackNotIn(List<String> values) {
            return notIn(callBack, values);
        }

        public KdnSubscibeExample.Criteria andCallBackBetween(String value1, String value2) {
            return between(callBack, value1, value2);
        }

        public KdnSubscibeExample.Criteria andCallBackNotBetween(String value1, String value2) {
            return notBetween(callBack, value1, value2);
        }
        public KdnSubscibeExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public KdnSubscibeExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public KdnSubscibeExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public KdnSubscibeExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public KdnSubscibeExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public KdnSubscibeExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public KdnSubscibeExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public KdnSubscibeExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public KdnSubscibeExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public KdnSubscibeExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public KdnSubscibeExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public KdnSubscibeExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public KdnSubscibeExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public KdnSubscibeExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public KdnSubscibeExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public KdnSubscibeExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public KdnSubscibeExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public KdnSubscibeExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public KdnSubscibeExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public KdnSubscibeExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public KdnSubscibeExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public KdnSubscibeExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public KdnSubscibeExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public KdnSubscibeExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public KdnSubscibeExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public KdnSubscibeExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public KdnSubscibeExample.Criteria andLogisticStateIsNull() {
            return isNull(logisticState);
        }

        public KdnSubscibeExample.Criteria andLogisticStateIsNotNull() {
            return isNotNull(logisticState);
        }

        public KdnSubscibeExample.Criteria andLogisticStateEqualTo(Integer value) {
            return equalTo(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateNotEqualTo(Integer value) {
            return notEqualTo(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateGreaterThan(Integer value) {
            return greaterThan(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateLessThan(Integer value) {
            return lessThan(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(logisticState, value);
        }

        public KdnSubscibeExample.Criteria andLogisticStateIn(List<Integer> values) {
            return in(logisticState, values);
        }

        public KdnSubscibeExample.Criteria andLogisticStateNotIn(List<Integer> values) {
            return notIn(logisticState, values);
        }

        public KdnSubscibeExample.Criteria andLogisticStateBetween(Integer value1, Integer value2) {
            return between(logisticState, value1, value2);
        }

        public KdnSubscibeExample.Criteria andLogisticStateNotBetween(Integer value1, Integer value2) {
            return notBetween(logisticState, value1, value2);
        }
        public KdnSubscibeExample.Criteria andLogisticCodeIsNull() {
            return isNull(logisticCode);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeIsNotNull() {
            return isNotNull(logisticCode);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeEqualTo(String value) {
            return equalTo(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeNotEqualTo(String value) {
            return notEqualTo(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeGreaterThan(String value) {
            return greaterThan(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeLessThan(String value) {
            return lessThan(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeLike(String value) {
            return like(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeNotLike(String value) {
            return notLike(logisticCode, value);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeIn(List<String> values) {
            return in(logisticCode, values);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeNotIn(List<String> values) {
            return notIn(logisticCode, values);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeBetween(String value1, String value2) {
            return between(logisticCode, value1, value2);
        }

        public KdnSubscibeExample.Criteria andLogisticCodeNotBetween(String value1, String value2) {
            return notBetween(logisticCode, value1, value2);
        }
    }
}