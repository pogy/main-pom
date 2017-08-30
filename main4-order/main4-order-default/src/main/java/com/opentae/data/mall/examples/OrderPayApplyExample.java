package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderPayApply;

import java.util.*;
public class OrderPayApplyExample extends SgExample<OrderPayApplyExample.Criteria> {
    public static final Class<OrderPayApply> beanClass = OrderPayApply.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn applyId;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn oid;
    public static EntityColumn payFor;
    public static EntityColumn type;
    public static EntityColumn userId;
    public static EntityColumn payLink;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        applyId = listMap.get("applyId");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        oid = listMap.get("oid");
        payFor = listMap.get("payFor");
        type = listMap.get("type");
        userId = listMap.get("userId");
        payLink = listMap.get("payLink");
        }

    public OrderPayApplyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderPayApplyExample.Criteria createCriteriaInternal() {
        return new OrderPayApplyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderPayApplyExample.Criteria andApplyIdIsNull() {
            return isNull(applyId);
        }

        public OrderPayApplyExample.Criteria andApplyIdIsNotNull() {
            return isNotNull(applyId);
        }

        public OrderPayApplyExample.Criteria andApplyIdEqualTo(Long value) {
            return equalTo(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdNotEqualTo(Long value) {
            return notEqualTo(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdGreaterThan(Long value) {
            return greaterThan(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdLessThan(Long value) {
            return lessThan(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(applyId, value);
        }

        public OrderPayApplyExample.Criteria andApplyIdIn(List<Long> values) {
            return in(applyId, values);
        }

        public OrderPayApplyExample.Criteria andApplyIdNotIn(List<Long> values) {
            return notIn(applyId, values);
        }

        public OrderPayApplyExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            return between(applyId, value1, value2);
        }

        public OrderPayApplyExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(applyId, value1, value2);
        }
        public OrderPayApplyExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public OrderPayApplyExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public OrderPayApplyExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public OrderPayApplyExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public OrderPayApplyExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public OrderPayApplyExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public OrderPayApplyExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public OrderPayApplyExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public OrderPayApplyExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public OrderPayApplyExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public OrderPayApplyExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public OrderPayApplyExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public OrderPayApplyExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public OrderPayApplyExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public OrderPayApplyExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public OrderPayApplyExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public OrderPayApplyExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public OrderPayApplyExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public OrderPayApplyExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public OrderPayApplyExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public OrderPayApplyExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public OrderPayApplyExample.Criteria andPayForIsNull() {
            return isNull(payFor);
        }

        public OrderPayApplyExample.Criteria andPayForIsNotNull() {
            return isNotNull(payFor);
        }

        public OrderPayApplyExample.Criteria andPayForEqualTo(Integer value) {
            return equalTo(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForNotEqualTo(Integer value) {
            return notEqualTo(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForGreaterThan(Integer value) {
            return greaterThan(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForLessThan(Integer value) {
            return lessThan(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(payFor, value);
        }

        public OrderPayApplyExample.Criteria andPayForIn(List<Integer> values) {
            return in(payFor, values);
        }

        public OrderPayApplyExample.Criteria andPayForNotIn(List<Integer> values) {
            return notIn(payFor, values);
        }

        public OrderPayApplyExample.Criteria andPayForBetween(Integer value1, Integer value2) {
            return between(payFor, value1, value2);
        }

        public OrderPayApplyExample.Criteria andPayForNotBetween(Integer value1, Integer value2) {
            return notBetween(payFor, value1, value2);
        }
        public OrderPayApplyExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public OrderPayApplyExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public OrderPayApplyExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public OrderPayApplyExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public OrderPayApplyExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public OrderPayApplyExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public OrderPayApplyExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public OrderPayApplyExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public OrderPayApplyExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public OrderPayApplyExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public OrderPayApplyExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public OrderPayApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public OrderPayApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public OrderPayApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public OrderPayApplyExample.Criteria andPayLinkIsNull() {
            return isNull(payLink);
        }

        public OrderPayApplyExample.Criteria andPayLinkIsNotNull() {
            return isNotNull(payLink);
        }

        public OrderPayApplyExample.Criteria andPayLinkEqualTo(String value) {
            return equalTo(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkNotEqualTo(String value) {
            return notEqualTo(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkGreaterThan(String value) {
            return greaterThan(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkLessThan(String value) {
            return lessThan(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkLike(String value) {
            return like(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkNotLike(String value) {
            return notLike(payLink, value);
        }

        public OrderPayApplyExample.Criteria andPayLinkIn(List<String> values) {
            return in(payLink, values);
        }

        public OrderPayApplyExample.Criteria andPayLinkNotIn(List<String> values) {
            return notIn(payLink, values);
        }

        public OrderPayApplyExample.Criteria andPayLinkBetween(String value1, String value2) {
            return between(payLink, value1, value2);
        }

        public OrderPayApplyExample.Criteria andPayLinkNotBetween(String value1, String value2) {
            return notBetween(payLink, value1, value2);
        }
    }
}