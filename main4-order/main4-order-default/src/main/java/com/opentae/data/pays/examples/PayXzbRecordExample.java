package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayXzbRecord;

import java.util.*;
public class PayXzbRecordExample extends SgExample<PayXzbRecordExample.Criteria> {
    public static final Class<PayXzbRecord> beanClass = PayXzbRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn xzbRecordId;
    public static EntityColumn accountId;
    public static EntityColumn comments;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn toMoney;
    public static EntityColumn fromMoney;
    public static EntityColumn payId;
    public static EntityColumn type;
    public static EntityColumn rechargeId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        xzbRecordId = listMap.get("xzbRecordId");
        accountId = listMap.get("accountId");
        comments = listMap.get("comments");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        toMoney = listMap.get("toMoney");
        fromMoney = listMap.get("fromMoney");
        payId = listMap.get("payId");
        type = listMap.get("type");
        rechargeId = listMap.get("rechargeId");
        }

    public PayXzbRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayXzbRecordExample.Criteria createCriteriaInternal() {
        return new PayXzbRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdIsNull() {
            return isNull(xzbRecordId);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdIsNotNull() {
            return isNotNull(xzbRecordId);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdEqualTo(Long value) {
            return equalTo(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdNotEqualTo(Long value) {
            return notEqualTo(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdGreaterThan(Long value) {
            return greaterThan(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdLessThan(Long value) {
            return lessThan(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(xzbRecordId, value);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdIn(List<Long> values) {
            return in(xzbRecordId, values);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdNotIn(List<Long> values) {
            return notIn(xzbRecordId, values);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdBetween(Long value1, Long value2) {
            return between(xzbRecordId, value1, value2);
        }

        public PayXzbRecordExample.Criteria andXzbRecordIdNotBetween(Long value1, Long value2) {
            return notBetween(xzbRecordId, value1, value2);
        }
        public PayXzbRecordExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public PayXzbRecordExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public PayXzbRecordExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public PayXzbRecordExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public PayXzbRecordExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public PayXzbRecordExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public PayXzbRecordExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public PayXzbRecordExample.Criteria andCommentsIsNull() {
            return isNull(comments);
        }

        public PayXzbRecordExample.Criteria andCommentsIsNotNull() {
            return isNotNull(comments);
        }

        public PayXzbRecordExample.Criteria andCommentsEqualTo(String value) {
            return equalTo(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsNotEqualTo(String value) {
            return notEqualTo(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsGreaterThan(String value) {
            return greaterThan(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsLessThan(String value) {
            return lessThan(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsLike(String value) {
            return like(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsNotLike(String value) {
            return notLike(comments, value);
        }

        public PayXzbRecordExample.Criteria andCommentsIn(List<String> values) {
            return in(comments, values);
        }

        public PayXzbRecordExample.Criteria andCommentsNotIn(List<String> values) {
            return notIn(comments, values);
        }

        public PayXzbRecordExample.Criteria andCommentsBetween(String value1, String value2) {
            return between(comments, value1, value2);
        }

        public PayXzbRecordExample.Criteria andCommentsNotBetween(String value1, String value2) {
            return notBetween(comments, value1, value2);
        }
        public PayXzbRecordExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public PayXzbRecordExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public PayXzbRecordExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public PayXzbRecordExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public PayXzbRecordExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public PayXzbRecordExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public PayXzbRecordExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public PayXzbRecordExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayXzbRecordExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayXzbRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayXzbRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayXzbRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayXzbRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayXzbRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayXzbRecordExample.Criteria andToMoneyIsNull() {
            return isNull(toMoney);
        }

        public PayXzbRecordExample.Criteria andToMoneyIsNotNull() {
            return isNotNull(toMoney);
        }

        public PayXzbRecordExample.Criteria andToMoneyEqualTo(Long value) {
            return equalTo(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyNotEqualTo(Long value) {
            return notEqualTo(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyGreaterThan(Long value) {
            return greaterThan(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyLessThan(Long value) {
            return lessThan(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(toMoney, value);
        }

        public PayXzbRecordExample.Criteria andToMoneyIn(List<Long> values) {
            return in(toMoney, values);
        }

        public PayXzbRecordExample.Criteria andToMoneyNotIn(List<Long> values) {
            return notIn(toMoney, values);
        }

        public PayXzbRecordExample.Criteria andToMoneyBetween(Long value1, Long value2) {
            return between(toMoney, value1, value2);
        }

        public PayXzbRecordExample.Criteria andToMoneyNotBetween(Long value1, Long value2) {
            return notBetween(toMoney, value1, value2);
        }
        public PayXzbRecordExample.Criteria andFromMoneyIsNull() {
            return isNull(fromMoney);
        }

        public PayXzbRecordExample.Criteria andFromMoneyIsNotNull() {
            return isNotNull(fromMoney);
        }

        public PayXzbRecordExample.Criteria andFromMoneyEqualTo(Long value) {
            return equalTo(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyNotEqualTo(Long value) {
            return notEqualTo(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyGreaterThan(Long value) {
            return greaterThan(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyLessThan(Long value) {
            return lessThan(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromMoney, value);
        }

        public PayXzbRecordExample.Criteria andFromMoneyIn(List<Long> values) {
            return in(fromMoney, values);
        }

        public PayXzbRecordExample.Criteria andFromMoneyNotIn(List<Long> values) {
            return notIn(fromMoney, values);
        }

        public PayXzbRecordExample.Criteria andFromMoneyBetween(Long value1, Long value2) {
            return between(fromMoney, value1, value2);
        }

        public PayXzbRecordExample.Criteria andFromMoneyNotBetween(Long value1, Long value2) {
            return notBetween(fromMoney, value1, value2);
        }
        public PayXzbRecordExample.Criteria andPayIdIsNull() {
            return isNull(payId);
        }

        public PayXzbRecordExample.Criteria andPayIdIsNotNull() {
            return isNotNull(payId);
        }

        public PayXzbRecordExample.Criteria andPayIdEqualTo(Long value) {
            return equalTo(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdNotEqualTo(Long value) {
            return notEqualTo(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdGreaterThan(Long value) {
            return greaterThan(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdLessThan(Long value) {
            return lessThan(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payId, value);
        }

        public PayXzbRecordExample.Criteria andPayIdIn(List<Long> values) {
            return in(payId, values);
        }

        public PayXzbRecordExample.Criteria andPayIdNotIn(List<Long> values) {
            return notIn(payId, values);
        }

        public PayXzbRecordExample.Criteria andPayIdBetween(Long value1, Long value2) {
            return between(payId, value1, value2);
        }

        public PayXzbRecordExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            return notBetween(payId, value1, value2);
        }
        public PayXzbRecordExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public PayXzbRecordExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public PayXzbRecordExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public PayXzbRecordExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public PayXzbRecordExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public PayXzbRecordExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public PayXzbRecordExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public PayXzbRecordExample.Criteria andRechargeIdIsNull() {
            return isNull(rechargeId);
        }

        public PayXzbRecordExample.Criteria andRechargeIdIsNotNull() {
            return isNotNull(rechargeId);
        }

        public PayXzbRecordExample.Criteria andRechargeIdEqualTo(Long value) {
            return equalTo(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdNotEqualTo(Long value) {
            return notEqualTo(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdGreaterThan(Long value) {
            return greaterThan(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdLessThan(Long value) {
            return lessThan(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rechargeId, value);
        }

        public PayXzbRecordExample.Criteria andRechargeIdIn(List<Long> values) {
            return in(rechargeId, values);
        }

        public PayXzbRecordExample.Criteria andRechargeIdNotIn(List<Long> values) {
            return notIn(rechargeId, values);
        }

        public PayXzbRecordExample.Criteria andRechargeIdBetween(Long value1, Long value2) {
            return between(rechargeId, value1, value2);
        }

        public PayXzbRecordExample.Criteria andRechargeIdNotBetween(Long value1, Long value2) {
            return notBetween(rechargeId, value1, value2);
        }
    }
}