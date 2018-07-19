package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemVoucher;

import java.util.*;
public class ItemVoucherExample extends SgExample<ItemVoucherExample.Criteria> {
    public static final Class<ItemVoucher> beanClass = ItemVoucher.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn voucherState;
    public static EntityColumn usedTime;
    public static EntityColumn expireTime;
    public static EntityColumn createTime;
    public static EntityColumn voucherId;
    public static EntityColumn voucherAmount;
    public static EntityColumn voucherTag;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        voucherState = listMap.get("voucherState");
        usedTime = listMap.get("usedTime");
        expireTime = listMap.get("expireTime");
        createTime = listMap.get("createTime");
        voucherId = listMap.get("voucherId");
        voucherAmount = listMap.get("voucherAmount");
        voucherTag = listMap.get("voucherTag");
        userId = listMap.get("userId");
        }

    public ItemVoucherExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemVoucherExample.Criteria createCriteriaInternal() {
        return new ItemVoucherExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemVoucherExample.Criteria andVoucherStateIsNull() {
            return isNull(voucherState);
        }

        public ItemVoucherExample.Criteria andVoucherStateIsNotNull() {
            return isNotNull(voucherState);
        }

        public ItemVoucherExample.Criteria andVoucherStateEqualTo(Integer value) {
            return equalTo(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateNotEqualTo(Integer value) {
            return notEqualTo(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateGreaterThan(Integer value) {
            return greaterThan(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateLessThan(Integer value) {
            return lessThan(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(voucherState, value);
        }

        public ItemVoucherExample.Criteria andVoucherStateIn(List<Integer> values) {
            return in(voucherState, values);
        }

        public ItemVoucherExample.Criteria andVoucherStateNotIn(List<Integer> values) {
            return notIn(voucherState, values);
        }

        public ItemVoucherExample.Criteria andVoucherStateBetween(Integer value1, Integer value2) {
            return between(voucherState, value1, value2);
        }

        public ItemVoucherExample.Criteria andVoucherStateNotBetween(Integer value1, Integer value2) {
            return notBetween(voucherState, value1, value2);
        }
        public ItemVoucherExample.Criteria andUsedTimeIsNull() {
            return isNull(usedTime);
        }

        public ItemVoucherExample.Criteria andUsedTimeIsNotNull() {
            return isNotNull(usedTime);
        }

        public ItemVoucherExample.Criteria andUsedTimeEqualTo(Date value) {
            return equalTo(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeNotEqualTo(Date value) {
            return notEqualTo(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeGreaterThan(Date value) {
            return greaterThan(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeLessThan(Date value) {
            return lessThan(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(usedTime, value);
        }

        public ItemVoucherExample.Criteria andUsedTimeIn(List<Date> values) {
            return in(usedTime, values);
        }

        public ItemVoucherExample.Criteria andUsedTimeNotIn(List<Date> values) {
            return notIn(usedTime, values);
        }

        public ItemVoucherExample.Criteria andUsedTimeBetween(Date value1, Date value2) {
            return between(usedTime, value1, value2);
        }

        public ItemVoucherExample.Criteria andUsedTimeNotBetween(Date value1, Date value2) {
            return notBetween(usedTime, value1, value2);
        }
        public ItemVoucherExample.Criteria andExpireTimeIsNull() {
            return isNull(expireTime);
        }

        public ItemVoucherExample.Criteria andExpireTimeIsNotNull() {
            return isNotNull(expireTime);
        }

        public ItemVoucherExample.Criteria andExpireTimeEqualTo(Date value) {
            return equalTo(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeNotEqualTo(Date value) {
            return notEqualTo(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeGreaterThan(Date value) {
            return greaterThan(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeLessThan(Date value) {
            return lessThan(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(expireTime, value);
        }

        public ItemVoucherExample.Criteria andExpireTimeIn(List<Date> values) {
            return in(expireTime, values);
        }

        public ItemVoucherExample.Criteria andExpireTimeNotIn(List<Date> values) {
            return notIn(expireTime, values);
        }

        public ItemVoucherExample.Criteria andExpireTimeBetween(Date value1, Date value2) {
            return between(expireTime, value1, value2);
        }

        public ItemVoucherExample.Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            return notBetween(expireTime, value1, value2);
        }
        public ItemVoucherExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ItemVoucherExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ItemVoucherExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ItemVoucherExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ItemVoucherExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ItemVoucherExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ItemVoucherExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ItemVoucherExample.Criteria andVoucherIdIsNull() {
            return isNull(voucherId);
        }

        public ItemVoucherExample.Criteria andVoucherIdIsNotNull() {
            return isNotNull(voucherId);
        }

        public ItemVoucherExample.Criteria andVoucherIdEqualTo(Long value) {
            return equalTo(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdNotEqualTo(Long value) {
            return notEqualTo(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdGreaterThan(Long value) {
            return greaterThan(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdLessThan(Long value) {
            return lessThan(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(voucherId, value);
        }

        public ItemVoucherExample.Criteria andVoucherIdIn(List<Long> values) {
            return in(voucherId, values);
        }

        public ItemVoucherExample.Criteria andVoucherIdNotIn(List<Long> values) {
            return notIn(voucherId, values);
        }

        public ItemVoucherExample.Criteria andVoucherIdBetween(Long value1, Long value2) {
            return between(voucherId, value1, value2);
        }

        public ItemVoucherExample.Criteria andVoucherIdNotBetween(Long value1, Long value2) {
            return notBetween(voucherId, value1, value2);
        }
        public ItemVoucherExample.Criteria andVoucherAmountIsNull() {
            return isNull(voucherAmount);
        }

        public ItemVoucherExample.Criteria andVoucherAmountIsNotNull() {
            return isNotNull(voucherAmount);
        }

        public ItemVoucherExample.Criteria andVoucherAmountEqualTo(Long value) {
            return equalTo(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountNotEqualTo(Long value) {
            return notEqualTo(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountGreaterThan(Long value) {
            return greaterThan(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountLessThan(Long value) {
            return lessThan(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(voucherAmount, value);
        }

        public ItemVoucherExample.Criteria andVoucherAmountIn(List<Long> values) {
            return in(voucherAmount, values);
        }

        public ItemVoucherExample.Criteria andVoucherAmountNotIn(List<Long> values) {
            return notIn(voucherAmount, values);
        }

        public ItemVoucherExample.Criteria andVoucherAmountBetween(Long value1, Long value2) {
            return between(voucherAmount, value1, value2);
        }

        public ItemVoucherExample.Criteria andVoucherAmountNotBetween(Long value1, Long value2) {
            return notBetween(voucherAmount, value1, value2);
        }
        public ItemVoucherExample.Criteria andVoucherTagIsNull() {
            return isNull(voucherTag);
        }

        public ItemVoucherExample.Criteria andVoucherTagIsNotNull() {
            return isNotNull(voucherTag);
        }

        public ItemVoucherExample.Criteria andVoucherTagEqualTo(String value) {
            return equalTo(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagNotEqualTo(String value) {
            return notEqualTo(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagGreaterThan(String value) {
            return greaterThan(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagLessThan(String value) {
            return lessThan(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagLike(String value) {
            return like(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagNotLike(String value) {
            return notLike(voucherTag, value);
        }

        public ItemVoucherExample.Criteria andVoucherTagIn(List<String> values) {
            return in(voucherTag, values);
        }

        public ItemVoucherExample.Criteria andVoucherTagNotIn(List<String> values) {
            return notIn(voucherTag, values);
        }

        public ItemVoucherExample.Criteria andVoucherTagBetween(String value1, String value2) {
            return between(voucherTag, value1, value2);
        }

        public ItemVoucherExample.Criteria andVoucherTagNotBetween(String value1, String value2) {
            return notBetween(voucherTag, value1, value2);
        }
        public ItemVoucherExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ItemVoucherExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ItemVoucherExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ItemVoucherExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ItemVoucherExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ItemVoucherExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ItemVoucherExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}