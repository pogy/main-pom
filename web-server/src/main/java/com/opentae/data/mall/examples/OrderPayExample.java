package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderPay;

import java.util.*;
public class OrderPayExample extends SgExample<OrderPayExample.Criteria> {
    public static final Class<OrderPay> beanClass = OrderPay.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn applyId;
    public static EntityColumn outerPid;
    public static EntityColumn outerPuser;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn refundMoney;
    public static EntityColumn payId;
    public static EntityColumn payFor;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        applyId = listMap.get("applyId");
        outerPid = listMap.get("outerPid");
        outerPuser = listMap.get("outerPuser");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        refundMoney = listMap.get("refundMoney");
        payId = listMap.get("payId");
        payFor = listMap.get("payFor");
        type = listMap.get("type");
        }

    public OrderPayExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderPayExample.Criteria createCriteriaInternal() {
        return new OrderPayExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderPayExample.Criteria andApplyIdIsNull() {
            return isNull(applyId);
        }

        public OrderPayExample.Criteria andApplyIdIsNotNull() {
            return isNotNull(applyId);
        }

        public OrderPayExample.Criteria andApplyIdEqualTo(Long value) {
            return equalTo(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdNotEqualTo(Long value) {
            return notEqualTo(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdGreaterThan(Long value) {
            return greaterThan(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdLessThan(Long value) {
            return lessThan(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(applyId, value);
        }

        public OrderPayExample.Criteria andApplyIdIn(List<Long> values) {
            return in(applyId, values);
        }

        public OrderPayExample.Criteria andApplyIdNotIn(List<Long> values) {
            return notIn(applyId, values);
        }

        public OrderPayExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            return between(applyId, value1, value2);
        }

        public OrderPayExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(applyId, value1, value2);
        }
        public OrderPayExample.Criteria andOuterPidIsNull() {
            return isNull(outerPid);
        }

        public OrderPayExample.Criteria andOuterPidIsNotNull() {
            return isNotNull(outerPid);
        }

        public OrderPayExample.Criteria andOuterPidEqualTo(String value) {
            return equalTo(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidNotEqualTo(String value) {
            return notEqualTo(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidGreaterThan(String value) {
            return greaterThan(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidLessThan(String value) {
            return lessThan(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidLike(String value) {
            return like(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidNotLike(String value) {
            return notLike(outerPid, value);
        }

        public OrderPayExample.Criteria andOuterPidIn(List<String> values) {
            return in(outerPid, values);
        }

        public OrderPayExample.Criteria andOuterPidNotIn(List<String> values) {
            return notIn(outerPid, values);
        }

        public OrderPayExample.Criteria andOuterPidBetween(String value1, String value2) {
            return between(outerPid, value1, value2);
        }

        public OrderPayExample.Criteria andOuterPidNotBetween(String value1, String value2) {
            return notBetween(outerPid, value1, value2);
        }
        public OrderPayExample.Criteria andOuterPuserIsNull() {
            return isNull(outerPuser);
        }

        public OrderPayExample.Criteria andOuterPuserIsNotNull() {
            return isNotNull(outerPuser);
        }

        public OrderPayExample.Criteria andOuterPuserEqualTo(String value) {
            return equalTo(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserNotEqualTo(String value) {
            return notEqualTo(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserGreaterThan(String value) {
            return greaterThan(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserLessThan(String value) {
            return lessThan(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserLike(String value) {
            return like(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserNotLike(String value) {
            return notLike(outerPuser, value);
        }

        public OrderPayExample.Criteria andOuterPuserIn(List<String> values) {
            return in(outerPuser, values);
        }

        public OrderPayExample.Criteria andOuterPuserNotIn(List<String> values) {
            return notIn(outerPuser, values);
        }

        public OrderPayExample.Criteria andOuterPuserBetween(String value1, String value2) {
            return between(outerPuser, value1, value2);
        }

        public OrderPayExample.Criteria andOuterPuserNotBetween(String value1, String value2) {
            return notBetween(outerPuser, value1, value2);
        }
        public OrderPayExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public OrderPayExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public OrderPayExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public OrderPayExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public OrderPayExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public OrderPayExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public OrderPayExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public OrderPayExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public OrderPayExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public OrderPayExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public OrderPayExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public OrderPayExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public OrderPayExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public OrderPayExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public OrderPayExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public OrderPayExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public OrderPayExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public OrderPayExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public OrderPayExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public OrderPayExample.Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public OrderPayExample.Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public OrderPayExample.Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public OrderPayExample.Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public OrderPayExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public OrderPayExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public OrderPayExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public OrderPayExample.Criteria andPayIdIsNull() {
            return isNull(payId);
        }

        public OrderPayExample.Criteria andPayIdIsNotNull() {
            return isNotNull(payId);
        }

        public OrderPayExample.Criteria andPayIdEqualTo(Long value) {
            return equalTo(payId, value);
        }

        public OrderPayExample.Criteria andPayIdNotEqualTo(Long value) {
            return notEqualTo(payId, value);
        }

        public OrderPayExample.Criteria andPayIdGreaterThan(Long value) {
            return greaterThan(payId, value);
        }

        public OrderPayExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(payId, value);
        }

        public OrderPayExample.Criteria andPayIdLessThan(Long value) {
            return lessThan(payId, value);
        }

        public OrderPayExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(payId, value);
        }

        public OrderPayExample.Criteria andPayIdIn(List<Long> values) {
            return in(payId, values);
        }

        public OrderPayExample.Criteria andPayIdNotIn(List<Long> values) {
            return notIn(payId, values);
        }

        public OrderPayExample.Criteria andPayIdBetween(Long value1, Long value2) {
            return between(payId, value1, value2);
        }

        public OrderPayExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            return notBetween(payId, value1, value2);
        }
        public OrderPayExample.Criteria andPayForIsNull() {
            return isNull(payFor);
        }

        public OrderPayExample.Criteria andPayForIsNotNull() {
            return isNotNull(payFor);
        }

        public OrderPayExample.Criteria andPayForEqualTo(Integer value) {
            return equalTo(payFor, value);
        }

        public OrderPayExample.Criteria andPayForNotEqualTo(Integer value) {
            return notEqualTo(payFor, value);
        }

        public OrderPayExample.Criteria andPayForGreaterThan(Integer value) {
            return greaterThan(payFor, value);
        }

        public OrderPayExample.Criteria andPayForGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(payFor, value);
        }

        public OrderPayExample.Criteria andPayForLessThan(Integer value) {
            return lessThan(payFor, value);
        }

        public OrderPayExample.Criteria andPayForLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(payFor, value);
        }

        public OrderPayExample.Criteria andPayForIn(List<Integer> values) {
            return in(payFor, values);
        }

        public OrderPayExample.Criteria andPayForNotIn(List<Integer> values) {
            return notIn(payFor, values);
        }

        public OrderPayExample.Criteria andPayForBetween(Integer value1, Integer value2) {
            return between(payFor, value1, value2);
        }

        public OrderPayExample.Criteria andPayForNotBetween(Integer value1, Integer value2) {
            return notBetween(payFor, value1, value2);
        }
        public OrderPayExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public OrderPayExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public OrderPayExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public OrderPayExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public OrderPayExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public OrderPayExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public OrderPayExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public OrderPayExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public OrderPayExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public OrderPayExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public OrderPayExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public OrderPayExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}