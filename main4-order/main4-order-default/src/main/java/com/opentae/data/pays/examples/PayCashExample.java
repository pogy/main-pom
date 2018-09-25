package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayCash;

import java.util.*;
public class PayCashExample extends SgExample<PayCashExample.Criteria> {
    public static final Class<PayCash> beanClass = PayCash.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn payCashId;
    public static EntityColumn cashRemark;
    public static EntityColumn extraIncomePoundage;
    public static EntityColumn cashType;
    public static EntityColumn cashTotalApply;
    public static EntityColumn poundageToUser;
    public static EntityColumn payCashTime;
    public static EntityColumn cashTime;
    public static EntityColumn accountId;
    public static EntityColumn poundageSet;
    public static EntityColumn cashId;
    public static EntityColumn cashMoney;
    public static EntityColumn cashStatus;
    public static EntityColumn alipayNo;
    public static EntityColumn alipayMoney;
    public static EntityColumn madeTime;
    public static EntityColumn alipayUserName;
    public static EntityColumn cashModifyTime;
    public static EntityColumn xzUserId;
    public static EntityColumn alipayUserId;
    public static EntityColumn errReason;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        payCashId = listMap.get("payCashId");
        cashRemark = listMap.get("cashRemark");
        extraIncomePoundage = listMap.get("extraIncomePoundage");
        cashType = listMap.get("cashType");
        cashTotalApply = listMap.get("cashTotalApply");
        poundageToUser = listMap.get("poundageToUser");
        payCashTime = listMap.get("payCashTime");
        cashTime = listMap.get("cashTime");
        accountId = listMap.get("accountId");
        poundageSet = listMap.get("poundageSet");
        cashId = listMap.get("cashId");
        cashMoney = listMap.get("cashMoney");
        cashStatus = listMap.get("cashStatus");
        alipayNo = listMap.get("alipayNo");
        alipayMoney = listMap.get("alipayMoney");
        madeTime = listMap.get("madeTime");
        alipayUserName = listMap.get("alipayUserName");
        cashModifyTime = listMap.get("cashModifyTime");
        xzUserId = listMap.get("xzUserId");
        alipayUserId = listMap.get("alipayUserId");
        errReason = listMap.get("errReason");
        }

    public PayCashExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayCashExample.Criteria createCriteriaInternal() {
        return new PayCashExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayCashExample.Criteria andPayCashIdIsNull() {
            return isNull(payCashId);
        }

        public PayCashExample.Criteria andPayCashIdIsNotNull() {
            return isNotNull(payCashId);
        }

        public PayCashExample.Criteria andPayCashIdEqualTo(Long value) {
            return equalTo(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdNotEqualTo(Long value) {
            return notEqualTo(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdGreaterThan(Long value) {
            return greaterThan(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdLessThan(Long value) {
            return lessThan(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payCashId, value);
        }

        public PayCashExample.Criteria andPayCashIdIn(List<Long> values) {
            return in(payCashId, values);
        }

        public PayCashExample.Criteria andPayCashIdNotIn(List<Long> values) {
            return notIn(payCashId, values);
        }

        public PayCashExample.Criteria andPayCashIdBetween(Long value1, Long value2) {
            return between(payCashId, value1, value2);
        }

        public PayCashExample.Criteria andPayCashIdNotBetween(Long value1, Long value2) {
            return notBetween(payCashId, value1, value2);
        }
        public PayCashExample.Criteria andCashRemarkIsNull() {
            return isNull(cashRemark);
        }

        public PayCashExample.Criteria andCashRemarkIsNotNull() {
            return isNotNull(cashRemark);
        }

        public PayCashExample.Criteria andCashRemarkEqualTo(String value) {
            return equalTo(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkNotEqualTo(String value) {
            return notEqualTo(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkGreaterThan(String value) {
            return greaterThan(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkLessThan(String value) {
            return lessThan(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkLike(String value) {
            return like(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkNotLike(String value) {
            return notLike(cashRemark, value);
        }

        public PayCashExample.Criteria andCashRemarkIn(List<String> values) {
            return in(cashRemark, values);
        }

        public PayCashExample.Criteria andCashRemarkNotIn(List<String> values) {
            return notIn(cashRemark, values);
        }

        public PayCashExample.Criteria andCashRemarkBetween(String value1, String value2) {
            return between(cashRemark, value1, value2);
        }

        public PayCashExample.Criteria andCashRemarkNotBetween(String value1, String value2) {
            return notBetween(cashRemark, value1, value2);
        }
        public PayCashExample.Criteria andExtraIncomePoundageIsNull() {
            return isNull(extraIncomePoundage);
        }

        public PayCashExample.Criteria andExtraIncomePoundageIsNotNull() {
            return isNotNull(extraIncomePoundage);
        }

        public PayCashExample.Criteria andExtraIncomePoundageEqualTo(String value) {
            return equalTo(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageNotEqualTo(String value) {
            return notEqualTo(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageGreaterThan(String value) {
            return greaterThan(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageLessThan(String value) {
            return lessThan(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageLike(String value) {
            return like(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageNotLike(String value) {
            return notLike(extraIncomePoundage, value);
        }

        public PayCashExample.Criteria andExtraIncomePoundageIn(List<String> values) {
            return in(extraIncomePoundage, values);
        }

        public PayCashExample.Criteria andExtraIncomePoundageNotIn(List<String> values) {
            return notIn(extraIncomePoundage, values);
        }

        public PayCashExample.Criteria andExtraIncomePoundageBetween(String value1, String value2) {
            return between(extraIncomePoundage, value1, value2);
        }

        public PayCashExample.Criteria andExtraIncomePoundageNotBetween(String value1, String value2) {
            return notBetween(extraIncomePoundage, value1, value2);
        }
        public PayCashExample.Criteria andCashTypeIsNull() {
            return isNull(cashType);
        }

        public PayCashExample.Criteria andCashTypeIsNotNull() {
            return isNotNull(cashType);
        }

        public PayCashExample.Criteria andCashTypeEqualTo(String value) {
            return equalTo(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeNotEqualTo(String value) {
            return notEqualTo(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeGreaterThan(String value) {
            return greaterThan(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeLessThan(String value) {
            return lessThan(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeLike(String value) {
            return like(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeNotLike(String value) {
            return notLike(cashType, value);
        }

        public PayCashExample.Criteria andCashTypeIn(List<String> values) {
            return in(cashType, values);
        }

        public PayCashExample.Criteria andCashTypeNotIn(List<String> values) {
            return notIn(cashType, values);
        }

        public PayCashExample.Criteria andCashTypeBetween(String value1, String value2) {
            return between(cashType, value1, value2);
        }

        public PayCashExample.Criteria andCashTypeNotBetween(String value1, String value2) {
            return notBetween(cashType, value1, value2);
        }
        public PayCashExample.Criteria andCashTotalApplyIsNull() {
            return isNull(cashTotalApply);
        }

        public PayCashExample.Criteria andCashTotalApplyIsNotNull() {
            return isNotNull(cashTotalApply);
        }

        public PayCashExample.Criteria andCashTotalApplyEqualTo(Long value) {
            return equalTo(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyNotEqualTo(Long value) {
            return notEqualTo(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyGreaterThan(Long value) {
            return greaterThan(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyLessThan(Long value) {
            return lessThan(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cashTotalApply, value);
        }

        public PayCashExample.Criteria andCashTotalApplyIn(List<Long> values) {
            return in(cashTotalApply, values);
        }

        public PayCashExample.Criteria andCashTotalApplyNotIn(List<Long> values) {
            return notIn(cashTotalApply, values);
        }

        public PayCashExample.Criteria andCashTotalApplyBetween(Long value1, Long value2) {
            return between(cashTotalApply, value1, value2);
        }

        public PayCashExample.Criteria andCashTotalApplyNotBetween(Long value1, Long value2) {
            return notBetween(cashTotalApply, value1, value2);
        }
        public PayCashExample.Criteria andPoundageToUserIsNull() {
            return isNull(poundageToUser);
        }

        public PayCashExample.Criteria andPoundageToUserIsNotNull() {
            return isNotNull(poundageToUser);
        }

        public PayCashExample.Criteria andPoundageToUserEqualTo(Long value) {
            return equalTo(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserNotEqualTo(Long value) {
            return notEqualTo(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserGreaterThan(Long value) {
            return greaterThan(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserLessThan(Long value) {
            return lessThan(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(poundageToUser, value);
        }

        public PayCashExample.Criteria andPoundageToUserIn(List<Long> values) {
            return in(poundageToUser, values);
        }

        public PayCashExample.Criteria andPoundageToUserNotIn(List<Long> values) {
            return notIn(poundageToUser, values);
        }

        public PayCashExample.Criteria andPoundageToUserBetween(Long value1, Long value2) {
            return between(poundageToUser, value1, value2);
        }

        public PayCashExample.Criteria andPoundageToUserNotBetween(Long value1, Long value2) {
            return notBetween(poundageToUser, value1, value2);
        }
        public PayCashExample.Criteria andPayCashTimeIsNull() {
            return isNull(payCashTime);
        }

        public PayCashExample.Criteria andPayCashTimeIsNotNull() {
            return isNotNull(payCashTime);
        }

        public PayCashExample.Criteria andPayCashTimeEqualTo(Date value) {
            return equalTo(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeNotEqualTo(Date value) {
            return notEqualTo(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeGreaterThan(Date value) {
            return greaterThan(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeLessThan(Date value) {
            return lessThan(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payCashTime, value);
        }

        public PayCashExample.Criteria andPayCashTimeIn(List<Date> values) {
            return in(payCashTime, values);
        }

        public PayCashExample.Criteria andPayCashTimeNotIn(List<Date> values) {
            return notIn(payCashTime, values);
        }

        public PayCashExample.Criteria andPayCashTimeBetween(Date value1, Date value2) {
            return between(payCashTime, value1, value2);
        }

        public PayCashExample.Criteria andPayCashTimeNotBetween(Date value1, Date value2) {
            return notBetween(payCashTime, value1, value2);
        }
        public PayCashExample.Criteria andCashTimeIsNull() {
            return isNull(cashTime);
        }

        public PayCashExample.Criteria andCashTimeIsNotNull() {
            return isNotNull(cashTime);
        }

        public PayCashExample.Criteria andCashTimeEqualTo(Date value) {
            return equalTo(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeNotEqualTo(Date value) {
            return notEqualTo(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeGreaterThan(Date value) {
            return greaterThan(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeLessThan(Date value) {
            return lessThan(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(cashTime, value);
        }

        public PayCashExample.Criteria andCashTimeIn(List<Date> values) {
            return in(cashTime, values);
        }

        public PayCashExample.Criteria andCashTimeNotIn(List<Date> values) {
            return notIn(cashTime, values);
        }

        public PayCashExample.Criteria andCashTimeBetween(Date value1, Date value2) {
            return between(cashTime, value1, value2);
        }

        public PayCashExample.Criteria andCashTimeNotBetween(Date value1, Date value2) {
            return notBetween(cashTime, value1, value2);
        }
        public PayCashExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public PayCashExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public PayCashExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public PayCashExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public PayCashExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public PayCashExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public PayCashExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public PayCashExample.Criteria andPoundageSetIsNull() {
            return isNull(poundageSet);
        }

        public PayCashExample.Criteria andPoundageSetIsNotNull() {
            return isNotNull(poundageSet);
        }

        public PayCashExample.Criteria andPoundageSetEqualTo(String value) {
            return equalTo(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetNotEqualTo(String value) {
            return notEqualTo(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetGreaterThan(String value) {
            return greaterThan(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetLessThan(String value) {
            return lessThan(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetLike(String value) {
            return like(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetNotLike(String value) {
            return notLike(poundageSet, value);
        }

        public PayCashExample.Criteria andPoundageSetIn(List<String> values) {
            return in(poundageSet, values);
        }

        public PayCashExample.Criteria andPoundageSetNotIn(List<String> values) {
            return notIn(poundageSet, values);
        }

        public PayCashExample.Criteria andPoundageSetBetween(String value1, String value2) {
            return between(poundageSet, value1, value2);
        }

        public PayCashExample.Criteria andPoundageSetNotBetween(String value1, String value2) {
            return notBetween(poundageSet, value1, value2);
        }
        public PayCashExample.Criteria andCashIdIsNull() {
            return isNull(cashId);
        }

        public PayCashExample.Criteria andCashIdIsNotNull() {
            return isNotNull(cashId);
        }

        public PayCashExample.Criteria andCashIdEqualTo(Long value) {
            return equalTo(cashId, value);
        }

        public PayCashExample.Criteria andCashIdNotEqualTo(Long value) {
            return notEqualTo(cashId, value);
        }

        public PayCashExample.Criteria andCashIdGreaterThan(Long value) {
            return greaterThan(cashId, value);
        }

        public PayCashExample.Criteria andCashIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cashId, value);
        }

        public PayCashExample.Criteria andCashIdLessThan(Long value) {
            return lessThan(cashId, value);
        }

        public PayCashExample.Criteria andCashIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cashId, value);
        }

        public PayCashExample.Criteria andCashIdIn(List<Long> values) {
            return in(cashId, values);
        }

        public PayCashExample.Criteria andCashIdNotIn(List<Long> values) {
            return notIn(cashId, values);
        }

        public PayCashExample.Criteria andCashIdBetween(Long value1, Long value2) {
            return between(cashId, value1, value2);
        }

        public PayCashExample.Criteria andCashIdNotBetween(Long value1, Long value2) {
            return notBetween(cashId, value1, value2);
        }
        public PayCashExample.Criteria andCashMoneyIsNull() {
            return isNull(cashMoney);
        }

        public PayCashExample.Criteria andCashMoneyIsNotNull() {
            return isNotNull(cashMoney);
        }

        public PayCashExample.Criteria andCashMoneyEqualTo(Long value) {
            return equalTo(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyNotEqualTo(Long value) {
            return notEqualTo(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyGreaterThan(Long value) {
            return greaterThan(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyLessThan(Long value) {
            return lessThan(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cashMoney, value);
        }

        public PayCashExample.Criteria andCashMoneyIn(List<Long> values) {
            return in(cashMoney, values);
        }

        public PayCashExample.Criteria andCashMoneyNotIn(List<Long> values) {
            return notIn(cashMoney, values);
        }

        public PayCashExample.Criteria andCashMoneyBetween(Long value1, Long value2) {
            return between(cashMoney, value1, value2);
        }

        public PayCashExample.Criteria andCashMoneyNotBetween(Long value1, Long value2) {
            return notBetween(cashMoney, value1, value2);
        }
        public PayCashExample.Criteria andCashStatusIsNull() {
            return isNull(cashStatus);
        }

        public PayCashExample.Criteria andCashStatusIsNotNull() {
            return isNotNull(cashStatus);
        }

        public PayCashExample.Criteria andCashStatusEqualTo(String value) {
            return equalTo(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusNotEqualTo(String value) {
            return notEqualTo(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusGreaterThan(String value) {
            return greaterThan(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusLessThan(String value) {
            return lessThan(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusLike(String value) {
            return like(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusNotLike(String value) {
            return notLike(cashStatus, value);
        }

        public PayCashExample.Criteria andCashStatusIn(List<String> values) {
            return in(cashStatus, values);
        }

        public PayCashExample.Criteria andCashStatusNotIn(List<String> values) {
            return notIn(cashStatus, values);
        }

        public PayCashExample.Criteria andCashStatusBetween(String value1, String value2) {
            return between(cashStatus, value1, value2);
        }

        public PayCashExample.Criteria andCashStatusNotBetween(String value1, String value2) {
            return notBetween(cashStatus, value1, value2);
        }
        public PayCashExample.Criteria andAlipayNoIsNull() {
            return isNull(alipayNo);
        }

        public PayCashExample.Criteria andAlipayNoIsNotNull() {
            return isNotNull(alipayNo);
        }

        public PayCashExample.Criteria andAlipayNoEqualTo(String value) {
            return equalTo(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoNotEqualTo(String value) {
            return notEqualTo(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoGreaterThan(String value) {
            return greaterThan(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoLessThan(String value) {
            return lessThan(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoLike(String value) {
            return like(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoNotLike(String value) {
            return notLike(alipayNo, value);
        }

        public PayCashExample.Criteria andAlipayNoIn(List<String> values) {
            return in(alipayNo, values);
        }

        public PayCashExample.Criteria andAlipayNoNotIn(List<String> values) {
            return notIn(alipayNo, values);
        }

        public PayCashExample.Criteria andAlipayNoBetween(String value1, String value2) {
            return between(alipayNo, value1, value2);
        }

        public PayCashExample.Criteria andAlipayNoNotBetween(String value1, String value2) {
            return notBetween(alipayNo, value1, value2);
        }
        public PayCashExample.Criteria andAlipayMoneyIsNull() {
            return isNull(alipayMoney);
        }

        public PayCashExample.Criteria andAlipayMoneyIsNotNull() {
            return isNotNull(alipayMoney);
        }

        public PayCashExample.Criteria andAlipayMoneyEqualTo(String value) {
            return equalTo(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyNotEqualTo(String value) {
            return notEqualTo(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyGreaterThan(String value) {
            return greaterThan(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyLessThan(String value) {
            return lessThan(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyLike(String value) {
            return like(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyNotLike(String value) {
            return notLike(alipayMoney, value);
        }

        public PayCashExample.Criteria andAlipayMoneyIn(List<String> values) {
            return in(alipayMoney, values);
        }

        public PayCashExample.Criteria andAlipayMoneyNotIn(List<String> values) {
            return notIn(alipayMoney, values);
        }

        public PayCashExample.Criteria andAlipayMoneyBetween(String value1, String value2) {
            return between(alipayMoney, value1, value2);
        }

        public PayCashExample.Criteria andAlipayMoneyNotBetween(String value1, String value2) {
            return notBetween(alipayMoney, value1, value2);
        }
        public PayCashExample.Criteria andMadeTimeIsNull() {
            return isNull(madeTime);
        }

        public PayCashExample.Criteria andMadeTimeIsNotNull() {
            return isNotNull(madeTime);
        }

        public PayCashExample.Criteria andMadeTimeEqualTo(Date value) {
            return equalTo(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeNotEqualTo(Date value) {
            return notEqualTo(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeGreaterThan(Date value) {
            return greaterThan(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeLessThan(Date value) {
            return lessThan(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(madeTime, value);
        }

        public PayCashExample.Criteria andMadeTimeIn(List<Date> values) {
            return in(madeTime, values);
        }

        public PayCashExample.Criteria andMadeTimeNotIn(List<Date> values) {
            return notIn(madeTime, values);
        }

        public PayCashExample.Criteria andMadeTimeBetween(Date value1, Date value2) {
            return between(madeTime, value1, value2);
        }

        public PayCashExample.Criteria andMadeTimeNotBetween(Date value1, Date value2) {
            return notBetween(madeTime, value1, value2);
        }
        public PayCashExample.Criteria andAlipayUserNameIsNull() {
            return isNull(alipayUserName);
        }

        public PayCashExample.Criteria andAlipayUserNameIsNotNull() {
            return isNotNull(alipayUserName);
        }

        public PayCashExample.Criteria andAlipayUserNameEqualTo(String value) {
            return equalTo(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameNotEqualTo(String value) {
            return notEqualTo(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameGreaterThan(String value) {
            return greaterThan(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameLessThan(String value) {
            return lessThan(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameLike(String value) {
            return like(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameNotLike(String value) {
            return notLike(alipayUserName, value);
        }

        public PayCashExample.Criteria andAlipayUserNameIn(List<String> values) {
            return in(alipayUserName, values);
        }

        public PayCashExample.Criteria andAlipayUserNameNotIn(List<String> values) {
            return notIn(alipayUserName, values);
        }

        public PayCashExample.Criteria andAlipayUserNameBetween(String value1, String value2) {
            return between(alipayUserName, value1, value2);
        }

        public PayCashExample.Criteria andAlipayUserNameNotBetween(String value1, String value2) {
            return notBetween(alipayUserName, value1, value2);
        }
        public PayCashExample.Criteria andCashModifyTimeIsNull() {
            return isNull(cashModifyTime);
        }

        public PayCashExample.Criteria andCashModifyTimeIsNotNull() {
            return isNotNull(cashModifyTime);
        }

        public PayCashExample.Criteria andCashModifyTimeEqualTo(Date value) {
            return equalTo(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeNotEqualTo(Date value) {
            return notEqualTo(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeGreaterThan(Date value) {
            return greaterThan(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeLessThan(Date value) {
            return lessThan(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(cashModifyTime, value);
        }

        public PayCashExample.Criteria andCashModifyTimeIn(List<Date> values) {
            return in(cashModifyTime, values);
        }

        public PayCashExample.Criteria andCashModifyTimeNotIn(List<Date> values) {
            return notIn(cashModifyTime, values);
        }

        public PayCashExample.Criteria andCashModifyTimeBetween(Date value1, Date value2) {
            return between(cashModifyTime, value1, value2);
        }

        public PayCashExample.Criteria andCashModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(cashModifyTime, value1, value2);
        }
        public PayCashExample.Criteria andXzUserIdIsNull() {
            return isNull(xzUserId);
        }

        public PayCashExample.Criteria andXzUserIdIsNotNull() {
            return isNotNull(xzUserId);
        }

        public PayCashExample.Criteria andXzUserIdEqualTo(Long value) {
            return equalTo(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdNotEqualTo(Long value) {
            return notEqualTo(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdGreaterThan(Long value) {
            return greaterThan(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdLessThan(Long value) {
            return lessThan(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(xzUserId, value);
        }

        public PayCashExample.Criteria andXzUserIdIn(List<Long> values) {
            return in(xzUserId, values);
        }

        public PayCashExample.Criteria andXzUserIdNotIn(List<Long> values) {
            return notIn(xzUserId, values);
        }

        public PayCashExample.Criteria andXzUserIdBetween(Long value1, Long value2) {
            return between(xzUserId, value1, value2);
        }

        public PayCashExample.Criteria andXzUserIdNotBetween(Long value1, Long value2) {
            return notBetween(xzUserId, value1, value2);
        }
        public PayCashExample.Criteria andAlipayUserIdIsNull() {
            return isNull(alipayUserId);
        }

        public PayCashExample.Criteria andAlipayUserIdIsNotNull() {
            return isNotNull(alipayUserId);
        }

        public PayCashExample.Criteria andAlipayUserIdEqualTo(String value) {
            return equalTo(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdNotEqualTo(String value) {
            return notEqualTo(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdGreaterThan(String value) {
            return greaterThan(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdLessThan(String value) {
            return lessThan(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdLike(String value) {
            return like(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdNotLike(String value) {
            return notLike(alipayUserId, value);
        }

        public PayCashExample.Criteria andAlipayUserIdIn(List<String> values) {
            return in(alipayUserId, values);
        }

        public PayCashExample.Criteria andAlipayUserIdNotIn(List<String> values) {
            return notIn(alipayUserId, values);
        }

        public PayCashExample.Criteria andAlipayUserIdBetween(String value1, String value2) {
            return between(alipayUserId, value1, value2);
        }

        public PayCashExample.Criteria andAlipayUserIdNotBetween(String value1, String value2) {
            return notBetween(alipayUserId, value1, value2);
        }
        public PayCashExample.Criteria andErrReasonIsNull() {
            return isNull(errReason);
        }

        public PayCashExample.Criteria andErrReasonIsNotNull() {
            return isNotNull(errReason);
        }

        public PayCashExample.Criteria andErrReasonEqualTo(String value) {
            return equalTo(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonNotEqualTo(String value) {
            return notEqualTo(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonGreaterThan(String value) {
            return greaterThan(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonLessThan(String value) {
            return lessThan(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonLike(String value) {
            return like(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonNotLike(String value) {
            return notLike(errReason, value);
        }

        public PayCashExample.Criteria andErrReasonIn(List<String> values) {
            return in(errReason, values);
        }

        public PayCashExample.Criteria andErrReasonNotIn(List<String> values) {
            return notIn(errReason, values);
        }

        public PayCashExample.Criteria andErrReasonBetween(String value1, String value2) {
            return between(errReason, value1, value2);
        }

        public PayCashExample.Criteria andErrReasonNotBetween(String value1, String value2) {
            return notBetween(errReason, value1, value2);
        }
    }
}