package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguOrderCashback;

import java.util.*;
public class ShiguOrderCashbackExample extends SgExample<ShiguOrderCashbackExample.Criteria> {
    public static final Class<ShiguOrderCashback> beanClass = ShiguOrderCashback.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn oId;
    public static EntityColumn endTime;
    public static EntityColumn cId;
    public static EntityColumn cashback;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        oId = listMap.get("oId");
        endTime = listMap.get("endTime");
        cId = listMap.get("cId");
        cashback = listMap.get("cashback");
        }

    public ShiguOrderCashbackExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguOrderCashbackExample.Criteria createCriteriaInternal() {
        return new ShiguOrderCashbackExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguOrderCashbackExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguOrderCashbackExample.Criteria andOIdIsNull() {
            return isNull(oId);
        }

        public ShiguOrderCashbackExample.Criteria andOIdIsNotNull() {
            return isNotNull(oId);
        }

        public ShiguOrderCashbackExample.Criteria andOIdEqualTo(Long value) {
            return equalTo(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdNotEqualTo(Long value) {
            return notEqualTo(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdGreaterThan(Long value) {
            return greaterThan(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdLessThan(Long value) {
            return lessThan(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oId, value);
        }

        public ShiguOrderCashbackExample.Criteria andOIdIn(List<Long> values) {
            return in(oId, values);
        }

        public ShiguOrderCashbackExample.Criteria andOIdNotIn(List<Long> values) {
            return notIn(oId, values);
        }

        public ShiguOrderCashbackExample.Criteria andOIdBetween(Long value1, Long value2) {
            return between(oId, value1, value2);
        }

        public ShiguOrderCashbackExample.Criteria andOIdNotBetween(Long value1, Long value2) {
            return notBetween(oId, value1, value2);
        }
        public ShiguOrderCashbackExample.Criteria andEndTimeIsNull() {
            return isNull(endTime);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeIsNotNull() {
            return isNotNull(endTime);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeEqualTo(Date value) {
            return equalTo(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeNotEqualTo(Date value) {
            return notEqualTo(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeGreaterThan(Date value) {
            return greaterThan(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeLessThan(Date value) {
            return lessThan(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endTime, value);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeIn(List<Date> values) {
            return in(endTime, values);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeNotIn(List<Date> values) {
            return notIn(endTime, values);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            return between(endTime, value1, value2);
        }

        public ShiguOrderCashbackExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            return notBetween(endTime, value1, value2);
        }
        public ShiguOrderCashbackExample.Criteria andCIdIsNull() {
            return isNull(cId);
        }

        public ShiguOrderCashbackExample.Criteria andCIdIsNotNull() {
            return isNotNull(cId);
        }

        public ShiguOrderCashbackExample.Criteria andCIdEqualTo(Long value) {
            return equalTo(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdNotEqualTo(Long value) {
            return notEqualTo(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdGreaterThan(Long value) {
            return greaterThan(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdLessThan(Long value) {
            return lessThan(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cId, value);
        }

        public ShiguOrderCashbackExample.Criteria andCIdIn(List<Long> values) {
            return in(cId, values);
        }

        public ShiguOrderCashbackExample.Criteria andCIdNotIn(List<Long> values) {
            return notIn(cId, values);
        }

        public ShiguOrderCashbackExample.Criteria andCIdBetween(Long value1, Long value2) {
            return between(cId, value1, value2);
        }

        public ShiguOrderCashbackExample.Criteria andCIdNotBetween(Long value1, Long value2) {
            return notBetween(cId, value1, value2);
        }
        public ShiguOrderCashbackExample.Criteria andCashbackIsNull() {
            return isNull(cashback);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackIsNotNull() {
            return isNotNull(cashback);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackEqualTo(Long value) {
            return equalTo(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackNotEqualTo(Long value) {
            return notEqualTo(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackGreaterThan(Long value) {
            return greaterThan(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackLessThan(Long value) {
            return lessThan(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cashback, value);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackIn(List<Long> values) {
            return in(cashback, values);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackNotIn(List<Long> values) {
            return notIn(cashback, values);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackBetween(Long value1, Long value2) {
            return between(cashback, value1, value2);
        }

        public ShiguOrderCashbackExample.Criteria andCashbackNotBetween(Long value1, Long value2) {
            return notBetween(cashback, value1, value2);
        }
    }
}