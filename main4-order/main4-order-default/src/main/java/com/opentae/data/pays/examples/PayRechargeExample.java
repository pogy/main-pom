package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayRecharge;

import java.util.*;
public class PayRechargeExample extends SgExample<PayRechargeExample.Criteria> {
    public static final Class<PayRecharge> beanClass = PayRecharge.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn accountId;
    public static EntityColumn alipayNo;
    public static EntityColumn createTime;
    public static EntityColumn price;
    public static EntityColumn volumePrice;
    public static EntityColumn chargeMethod;
    public static EntityColumn volumeIds;
    public static EntityColumn type;
    public static EntityColumn rechargeId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        accountId = listMap.get("accountId");
        alipayNo = listMap.get("alipayNo");
        createTime = listMap.get("createTime");
        price = listMap.get("price");
        volumePrice = listMap.get("volumePrice");
        chargeMethod = listMap.get("chargeMethod");
        volumeIds = listMap.get("volumeIds");
        type = listMap.get("type");
        rechargeId = listMap.get("rechargeId");
        status = listMap.get("status");
        }

    public PayRechargeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayRechargeExample.Criteria createCriteriaInternal() {
        return new PayRechargeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayRechargeExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public PayRechargeExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public PayRechargeExample.Criteria andAccountIdEqualTo(String value) {
            return equalTo(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdNotEqualTo(String value) {
            return notEqualTo(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdGreaterThan(String value) {
            return greaterThan(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdLessThan(String value) {
            return lessThan(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdLike(String value) {
            return like(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdNotLike(String value) {
            return notLike(accountId, value);
        }

        public PayRechargeExample.Criteria andAccountIdIn(List<String> values) {
            return in(accountId, values);
        }

        public PayRechargeExample.Criteria andAccountIdNotIn(List<String> values) {
            return notIn(accountId, values);
        }

        public PayRechargeExample.Criteria andAccountIdBetween(String value1, String value2) {
            return between(accountId, value1, value2);
        }

        public PayRechargeExample.Criteria andAccountIdNotBetween(String value1, String value2) {
            return notBetween(accountId, value1, value2);
        }
        public PayRechargeExample.Criteria andAlipayNoIsNull() {
            return isNull(alipayNo);
        }

        public PayRechargeExample.Criteria andAlipayNoIsNotNull() {
            return isNotNull(alipayNo);
        }

        public PayRechargeExample.Criteria andAlipayNoEqualTo(String value) {
            return equalTo(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoNotEqualTo(String value) {
            return notEqualTo(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoGreaterThan(String value) {
            return greaterThan(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoLessThan(String value) {
            return lessThan(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoLike(String value) {
            return like(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoNotLike(String value) {
            return notLike(alipayNo, value);
        }

        public PayRechargeExample.Criteria andAlipayNoIn(List<String> values) {
            return in(alipayNo, values);
        }

        public PayRechargeExample.Criteria andAlipayNoNotIn(List<String> values) {
            return notIn(alipayNo, values);
        }

        public PayRechargeExample.Criteria andAlipayNoBetween(String value1, String value2) {
            return between(alipayNo, value1, value2);
        }

        public PayRechargeExample.Criteria andAlipayNoNotBetween(String value1, String value2) {
            return notBetween(alipayNo, value1, value2);
        }
        public PayRechargeExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayRechargeExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayRechargeExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayRechargeExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayRechargeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayRechargeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayRechargeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayRechargeExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public PayRechargeExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public PayRechargeExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public PayRechargeExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public PayRechargeExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public PayRechargeExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public PayRechargeExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public PayRechargeExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public PayRechargeExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public PayRechargeExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public PayRechargeExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public PayRechargeExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public PayRechargeExample.Criteria andVolumePriceIsNull() {
            return isNull(volumePrice);
        }

        public PayRechargeExample.Criteria andVolumePriceIsNotNull() {
            return isNotNull(volumePrice);
        }

        public PayRechargeExample.Criteria andVolumePriceEqualTo(Long value) {
            return equalTo(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceNotEqualTo(Long value) {
            return notEqualTo(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceGreaterThan(Long value) {
            return greaterThan(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceLessThan(Long value) {
            return lessThan(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(volumePrice, value);
        }

        public PayRechargeExample.Criteria andVolumePriceIn(List<Long> values) {
            return in(volumePrice, values);
        }

        public PayRechargeExample.Criteria andVolumePriceNotIn(List<Long> values) {
            return notIn(volumePrice, values);
        }

        public PayRechargeExample.Criteria andVolumePriceBetween(Long value1, Long value2) {
            return between(volumePrice, value1, value2);
        }

        public PayRechargeExample.Criteria andVolumePriceNotBetween(Long value1, Long value2) {
            return notBetween(volumePrice, value1, value2);
        }
        public PayRechargeExample.Criteria andChargeMethodIsNull() {
            return isNull(chargeMethod);
        }

        public PayRechargeExample.Criteria andChargeMethodIsNotNull() {
            return isNotNull(chargeMethod);
        }

        public PayRechargeExample.Criteria andChargeMethodEqualTo(String value) {
            return equalTo(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodNotEqualTo(String value) {
            return notEqualTo(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodGreaterThan(String value) {
            return greaterThan(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodLessThan(String value) {
            return lessThan(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodLike(String value) {
            return like(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodNotLike(String value) {
            return notLike(chargeMethod, value);
        }

        public PayRechargeExample.Criteria andChargeMethodIn(List<String> values) {
            return in(chargeMethod, values);
        }

        public PayRechargeExample.Criteria andChargeMethodNotIn(List<String> values) {
            return notIn(chargeMethod, values);
        }

        public PayRechargeExample.Criteria andChargeMethodBetween(String value1, String value2) {
            return between(chargeMethod, value1, value2);
        }

        public PayRechargeExample.Criteria andChargeMethodNotBetween(String value1, String value2) {
            return notBetween(chargeMethod, value1, value2);
        }
        public PayRechargeExample.Criteria andVolumeIdsIsNull() {
            return isNull(volumeIds);
        }

        public PayRechargeExample.Criteria andVolumeIdsIsNotNull() {
            return isNotNull(volumeIds);
        }

        public PayRechargeExample.Criteria andVolumeIdsEqualTo(String value) {
            return equalTo(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsNotEqualTo(String value) {
            return notEqualTo(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsGreaterThan(String value) {
            return greaterThan(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsLessThan(String value) {
            return lessThan(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsLike(String value) {
            return like(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsNotLike(String value) {
            return notLike(volumeIds, value);
        }

        public PayRechargeExample.Criteria andVolumeIdsIn(List<String> values) {
            return in(volumeIds, values);
        }

        public PayRechargeExample.Criteria andVolumeIdsNotIn(List<String> values) {
            return notIn(volumeIds, values);
        }

        public PayRechargeExample.Criteria andVolumeIdsBetween(String value1, String value2) {
            return between(volumeIds, value1, value2);
        }

        public PayRechargeExample.Criteria andVolumeIdsNotBetween(String value1, String value2) {
            return notBetween(volumeIds, value1, value2);
        }
        public PayRechargeExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public PayRechargeExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public PayRechargeExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public PayRechargeExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public PayRechargeExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public PayRechargeExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public PayRechargeExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public PayRechargeExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public PayRechargeExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public PayRechargeExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public PayRechargeExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public PayRechargeExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public PayRechargeExample.Criteria andRechargeIdIsNull() {
            return isNull(rechargeId);
        }

        public PayRechargeExample.Criteria andRechargeIdIsNotNull() {
            return isNotNull(rechargeId);
        }

        public PayRechargeExample.Criteria andRechargeIdEqualTo(Long value) {
            return equalTo(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdNotEqualTo(Long value) {
            return notEqualTo(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdGreaterThan(Long value) {
            return greaterThan(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdLessThan(Long value) {
            return lessThan(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rechargeId, value);
        }

        public PayRechargeExample.Criteria andRechargeIdIn(List<Long> values) {
            return in(rechargeId, values);
        }

        public PayRechargeExample.Criteria andRechargeIdNotIn(List<Long> values) {
            return notIn(rechargeId, values);
        }

        public PayRechargeExample.Criteria andRechargeIdBetween(Long value1, Long value2) {
            return between(rechargeId, value1, value2);
        }

        public PayRechargeExample.Criteria andRechargeIdNotBetween(Long value1, Long value2) {
            return notBetween(rechargeId, value1, value2);
        }
        public PayRechargeExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public PayRechargeExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public PayRechargeExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public PayRechargeExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public PayRechargeExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public PayRechargeExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public PayRechargeExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public PayRechargeExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public PayRechargeExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public PayRechargeExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public PayRechargeExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public PayRechargeExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}