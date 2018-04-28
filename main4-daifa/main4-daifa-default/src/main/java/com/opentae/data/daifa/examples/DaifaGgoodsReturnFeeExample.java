package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoodsReturnFee;

import java.util.*;
public class DaifaGgoodsReturnFeeExample extends SgExample<DaifaGgoodsReturnFeeExample.Criteria> {
    public static final Class<DaifaGgoodsReturnFee> beanClass = DaifaGgoodsReturnFee.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn daifaSellerId;
    public static EntityColumn daifaWorkerId;
    public static EntityColumn createTime;
    public static EntityColumn phone;
    public static EntityColumn returnFee;
    public static EntityColumn returnId;
    public static EntityColumn createDate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        daifaSellerId = listMap.get("daifaSellerId");
        daifaWorkerId = listMap.get("daifaWorkerId");
        createTime = listMap.get("createTime");
        phone = listMap.get("phone");
        returnFee = listMap.get("returnFee");
        returnId = listMap.get("returnId");
        createDate = listMap.get("createDate");
        }

    public DaifaGgoodsReturnFeeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsReturnFeeExample.Criteria createCriteriaInternal() {
        return new DaifaGgoodsReturnFeeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdIsNull() {
            return isNull(daifaSellerId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdIsNotNull() {
            return isNotNull(daifaSellerId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdEqualTo(Long value) {
            return equalTo(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdNotEqualTo(Long value) {
            return notEqualTo(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdGreaterThan(Long value) {
            return greaterThan(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdLessThan(Long value) {
            return lessThan(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaSellerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdIn(List<Long> values) {
            return in(daifaSellerId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdNotIn(List<Long> values) {
            return notIn(daifaSellerId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdBetween(Long value1, Long value2) {
            return between(daifaSellerId, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaSellerId, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeIsNull() {
            return isNull(returnFee);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeIsNotNull() {
            return isNotNull(returnFee);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeEqualTo(String value) {
            return equalTo(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeNotEqualTo(String value) {
            return notEqualTo(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeGreaterThan(String value) {
            return greaterThan(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeLessThan(String value) {
            return lessThan(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeLike(String value) {
            return like(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeNotLike(String value) {
            return notLike(returnFee, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeIn(List<String> values) {
            return in(returnFee, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeNotIn(List<String> values) {
            return notIn(returnFee, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeBetween(String value1, String value2) {
            return between(returnFee, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnFeeNotBetween(String value1, String value2) {
            return notBetween(returnFee, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdIsNull() {
            return isNull(returnId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdIsNotNull() {
            return isNotNull(returnId);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdEqualTo(Long value) {
            return equalTo(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdNotEqualTo(Long value) {
            return notEqualTo(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdGreaterThan(Long value) {
            return greaterThan(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdLessThan(Long value) {
            return lessThan(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(returnId, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdIn(List<Long> values) {
            return in(returnId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdNotIn(List<Long> values) {
            return notIn(returnId, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdBetween(Long value1, Long value2) {
            return between(returnId, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andReturnIdNotBetween(Long value1, Long value2) {
            return notBetween(returnId, value1, value2);
        }
        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaGgoodsReturnFeeExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
    }
}