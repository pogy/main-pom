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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andDaifaSellerIdIsNull() {
            return isNull(daifaSellerId);
        }

        public Criteria andDaifaSellerIdIsNotNull() {
            return isNotNull(daifaSellerId);
        }

        public Criteria andDaifaSellerIdEqualTo(Long value) {
            return equalTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdNotEqualTo(Long value) {
            return notEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdGreaterThan(Long value) {
            return greaterThan(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdLessThan(Long value) {
            return lessThan(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaSellerId, value);
        }

        public Criteria andDaifaSellerIdIn(List<Long> values) {
            return in(daifaSellerId, values);
        }

        public Criteria andDaifaSellerIdNotIn(List<Long> values) {
            return notIn(daifaSellerId, values);
        }

        public Criteria andDaifaSellerIdBetween(Long value1, Long value2) {
            return between(daifaSellerId, value1, value2);
        }

        public Criteria andDaifaSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaSellerId, value1, value2);
        }
        public Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public Criteria andReturnFeeIsNull() {
            return isNull(returnFee);
        }

        public Criteria andReturnFeeIsNotNull() {
            return isNotNull(returnFee);
        }

        public Criteria andReturnFeeEqualTo(String value) {
            return equalTo(returnFee, value);
        }

        public Criteria andReturnFeeNotEqualTo(String value) {
            return notEqualTo(returnFee, value);
        }

        public Criteria andReturnFeeGreaterThan(String value) {
            return greaterThan(returnFee, value);
        }

        public Criteria andReturnFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(returnFee, value);
        }

        public Criteria andReturnFeeLessThan(String value) {
            return lessThan(returnFee, value);
        }

        public Criteria andReturnFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(returnFee, value);
        }

        public Criteria andReturnFeeLike(String value) {
            return like(returnFee, value);
        }

        public Criteria andReturnFeeNotLike(String value) {
            return notLike(returnFee, value);
        }

        public Criteria andReturnFeeIn(List<String> values) {
            return in(returnFee, values);
        }

        public Criteria andReturnFeeNotIn(List<String> values) {
            return notIn(returnFee, values);
        }

        public Criteria andReturnFeeBetween(String value1, String value2) {
            return between(returnFee, value1, value2);
        }

        public Criteria andReturnFeeNotBetween(String value1, String value2) {
            return notBetween(returnFee, value1, value2);
        }
        public Criteria andReturnIdIsNull() {
            return isNull(returnId);
        }

        public Criteria andReturnIdIsNotNull() {
            return isNotNull(returnId);
        }

        public Criteria andReturnIdEqualTo(Long value) {
            return equalTo(returnId, value);
        }

        public Criteria andReturnIdNotEqualTo(Long value) {
            return notEqualTo(returnId, value);
        }

        public Criteria andReturnIdGreaterThan(Long value) {
            return greaterThan(returnId, value);
        }

        public Criteria andReturnIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(returnId, value);
        }

        public Criteria andReturnIdLessThan(Long value) {
            return lessThan(returnId, value);
        }

        public Criteria andReturnIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(returnId, value);
        }

        public Criteria andReturnIdIn(List<Long> values) {
            return in(returnId, values);
        }

        public Criteria andReturnIdNotIn(List<Long> values) {
            return notIn(returnId, values);
        }

        public Criteria andReturnIdBetween(Long value1, Long value2) {
            return between(returnId, value1, value2);
        }

        public Criteria andReturnIdNotBetween(Long value1, Long value2) {
            return notBetween(returnId, value1, value2);
        }
        public Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
    }
}