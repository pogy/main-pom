package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayXzb;

import java.util.*;
public class PayXzbExample extends SgExample<PayXzbExample.Criteria> {
    public static final Class<PayXzb> beanClass = PayXzb.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn accountId;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn lastModifyTime;
    public static EntityColumn xzbId;
    public static EntityColumn totalMoney;
    public static EntityColumn blockMoney;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        accountId = listMap.get("accountId");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        lastModifyTime = listMap.get("lastModifyTime");
        xzbId = listMap.get("xzbId");
        totalMoney = listMap.get("totalMoney");
        blockMoney = listMap.get("blockMoney");
        }

    public PayXzbExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayXzbExample.Criteria createCriteriaInternal() {
        return new PayXzbExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayXzbExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public PayXzbExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public PayXzbExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public PayXzbExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public PayXzbExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public PayXzbExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public PayXzbExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public PayXzbExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public PayXzbExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public PayXzbExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public PayXzbExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public PayXzbExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public PayXzbExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public PayXzbExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public PayXzbExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public PayXzbExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public PayXzbExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public PayXzbExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public PayXzbExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public PayXzbExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayXzbExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayXzbExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayXzbExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayXzbExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayXzbExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayXzbExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayXzbExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public PayXzbExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public PayXzbExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public PayXzbExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public PayXzbExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public PayXzbExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public PayXzbExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public PayXzbExample.Criteria andXzbIdIsNull() {
            return isNull(xzbId);
        }

        public PayXzbExample.Criteria andXzbIdIsNotNull() {
            return isNotNull(xzbId);
        }

        public PayXzbExample.Criteria andXzbIdEqualTo(Long value) {
            return equalTo(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdNotEqualTo(Long value) {
            return notEqualTo(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdGreaterThan(Long value) {
            return greaterThan(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdLessThan(Long value) {
            return lessThan(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(xzbId, value);
        }

        public PayXzbExample.Criteria andXzbIdIn(List<Long> values) {
            return in(xzbId, values);
        }

        public PayXzbExample.Criteria andXzbIdNotIn(List<Long> values) {
            return notIn(xzbId, values);
        }

        public PayXzbExample.Criteria andXzbIdBetween(Long value1, Long value2) {
            return between(xzbId, value1, value2);
        }

        public PayXzbExample.Criteria andXzbIdNotBetween(Long value1, Long value2) {
            return notBetween(xzbId, value1, value2);
        }
        public PayXzbExample.Criteria andTotalMoneyIsNull() {
            return isNull(totalMoney);
        }

        public PayXzbExample.Criteria andTotalMoneyIsNotNull() {
            return isNotNull(totalMoney);
        }

        public PayXzbExample.Criteria andTotalMoneyEqualTo(Long value) {
            return equalTo(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyNotEqualTo(Long value) {
            return notEqualTo(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyGreaterThan(Long value) {
            return greaterThan(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyLessThan(Long value) {
            return lessThan(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(totalMoney, value);
        }

        public PayXzbExample.Criteria andTotalMoneyIn(List<Long> values) {
            return in(totalMoney, values);
        }

        public PayXzbExample.Criteria andTotalMoneyNotIn(List<Long> values) {
            return notIn(totalMoney, values);
        }

        public PayXzbExample.Criteria andTotalMoneyBetween(Long value1, Long value2) {
            return between(totalMoney, value1, value2);
        }

        public PayXzbExample.Criteria andTotalMoneyNotBetween(Long value1, Long value2) {
            return notBetween(totalMoney, value1, value2);
        }
        public PayXzbExample.Criteria andBlockMoneyIsNull() {
            return isNull(blockMoney);
        }

        public PayXzbExample.Criteria andBlockMoneyIsNotNull() {
            return isNotNull(blockMoney);
        }

        public PayXzbExample.Criteria andBlockMoneyEqualTo(Long value) {
            return equalTo(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyNotEqualTo(Long value) {
            return notEqualTo(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyGreaterThan(Long value) {
            return greaterThan(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyLessThan(Long value) {
            return lessThan(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(blockMoney, value);
        }

        public PayXzbExample.Criteria andBlockMoneyIn(List<Long> values) {
            return in(blockMoney, values);
        }

        public PayXzbExample.Criteria andBlockMoneyNotIn(List<Long> values) {
            return notIn(blockMoney, values);
        }

        public PayXzbExample.Criteria andBlockMoneyBetween(Long value1, Long value2) {
            return between(blockMoney, value1, value2);
        }

        public PayXzbExample.Criteria andBlockMoneyNotBetween(Long value1, Long value2) {
            return notBetween(blockMoney, value1, value2);
        }
    }
}