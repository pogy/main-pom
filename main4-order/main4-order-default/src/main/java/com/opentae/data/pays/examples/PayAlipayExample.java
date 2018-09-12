package com.opentae.data.pays.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.pays.beans.PayAlipay;

import java.util.*;
public class PayAlipayExample extends SgExample<PayAlipayExample.Criteria> {
    public static final Class<PayAlipay> beanClass = PayAlipay.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn price;
    public static EntityColumn lastModifyTime;
    public static EntityColumn ownerUserId;
    public static EntityColumn dangerous;
    public static EntityColumn paId;
    public static EntityColumn alipayUserName;
    public static EntityColumn tbNick;
    public static EntityColumn needAuth;
    public static EntityColumn tempPrice;
    public static EntityColumn alipayUserId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        price = listMap.get("price");
        lastModifyTime = listMap.get("lastModifyTime");
        ownerUserId = listMap.get("ownerUserId");
        dangerous = listMap.get("dangerous");
        paId = listMap.get("paId");
        alipayUserName = listMap.get("alipayUserName");
        tbNick = listMap.get("tbNick");
        needAuth = listMap.get("needAuth");
        tempPrice = listMap.get("tempPrice");
        alipayUserId = listMap.get("alipayUserId");
        }

    public PayAlipayExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PayAlipayExample.Criteria createCriteriaInternal() {
        return new PayAlipayExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PayAlipayExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public PayAlipayExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public PayAlipayExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public PayAlipayExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public PayAlipayExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public PayAlipayExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public PayAlipayExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public PayAlipayExample.Criteria andPriceIsNull() {
            return isNull(price);
        }

        public PayAlipayExample.Criteria andPriceIsNotNull() {
            return isNotNull(price);
        }

        public PayAlipayExample.Criteria andPriceEqualTo(Long value) {
            return equalTo(price, value);
        }

        public PayAlipayExample.Criteria andPriceNotEqualTo(Long value) {
            return notEqualTo(price, value);
        }

        public PayAlipayExample.Criteria andPriceGreaterThan(Long value) {
            return greaterThan(price, value);
        }

        public PayAlipayExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(price, value);
        }

        public PayAlipayExample.Criteria andPriceLessThan(Long value) {
            return lessThan(price, value);
        }

        public PayAlipayExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(price, value);
        }

        public PayAlipayExample.Criteria andPriceIn(List<Long> values) {
            return in(price, values);
        }

        public PayAlipayExample.Criteria andPriceNotIn(List<Long> values) {
            return notIn(price, values);
        }

        public PayAlipayExample.Criteria andPriceBetween(Long value1, Long value2) {
            return between(price, value1, value2);
        }

        public PayAlipayExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            return notBetween(price, value1, value2);
        }
        public PayAlipayExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public PayAlipayExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public PayAlipayExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public PayAlipayExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public PayAlipayExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public PayAlipayExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public PayAlipayExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public PayAlipayExample.Criteria andOwnerUserIdIsNull() {
            return isNull(ownerUserId);
        }

        public PayAlipayExample.Criteria andOwnerUserIdIsNotNull() {
            return isNotNull(ownerUserId);
        }

        public PayAlipayExample.Criteria andOwnerUserIdEqualTo(String value) {
            return equalTo(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdNotEqualTo(String value) {
            return notEqualTo(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdGreaterThan(String value) {
            return greaterThan(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdLessThan(String value) {
            return lessThan(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdLike(String value) {
            return like(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdNotLike(String value) {
            return notLike(ownerUserId, value);
        }

        public PayAlipayExample.Criteria andOwnerUserIdIn(List<String> values) {
            return in(ownerUserId, values);
        }

        public PayAlipayExample.Criteria andOwnerUserIdNotIn(List<String> values) {
            return notIn(ownerUserId, values);
        }

        public PayAlipayExample.Criteria andOwnerUserIdBetween(String value1, String value2) {
            return between(ownerUserId, value1, value2);
        }

        public PayAlipayExample.Criteria andOwnerUserIdNotBetween(String value1, String value2) {
            return notBetween(ownerUserId, value1, value2);
        }
        public PayAlipayExample.Criteria andDangerousIsNull() {
            return isNull(dangerous);
        }

        public PayAlipayExample.Criteria andDangerousIsNotNull() {
            return isNotNull(dangerous);
        }

        public PayAlipayExample.Criteria andDangerousEqualTo(Integer value) {
            return equalTo(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousNotEqualTo(Integer value) {
            return notEqualTo(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousGreaterThan(Integer value) {
            return greaterThan(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousLessThan(Integer value) {
            return lessThan(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(dangerous, value);
        }

        public PayAlipayExample.Criteria andDangerousIn(List<Integer> values) {
            return in(dangerous, values);
        }

        public PayAlipayExample.Criteria andDangerousNotIn(List<Integer> values) {
            return notIn(dangerous, values);
        }

        public PayAlipayExample.Criteria andDangerousBetween(Integer value1, Integer value2) {
            return between(dangerous, value1, value2);
        }

        public PayAlipayExample.Criteria andDangerousNotBetween(Integer value1, Integer value2) {
            return notBetween(dangerous, value1, value2);
        }
        public PayAlipayExample.Criteria andPaIdIsNull() {
            return isNull(paId);
        }

        public PayAlipayExample.Criteria andPaIdIsNotNull() {
            return isNotNull(paId);
        }

        public PayAlipayExample.Criteria andPaIdEqualTo(Long value) {
            return equalTo(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdNotEqualTo(Long value) {
            return notEqualTo(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdGreaterThan(Long value) {
            return greaterThan(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdLessThan(Long value) {
            return lessThan(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(paId, value);
        }

        public PayAlipayExample.Criteria andPaIdIn(List<Long> values) {
            return in(paId, values);
        }

        public PayAlipayExample.Criteria andPaIdNotIn(List<Long> values) {
            return notIn(paId, values);
        }

        public PayAlipayExample.Criteria andPaIdBetween(Long value1, Long value2) {
            return between(paId, value1, value2);
        }

        public PayAlipayExample.Criteria andPaIdNotBetween(Long value1, Long value2) {
            return notBetween(paId, value1, value2);
        }
        public PayAlipayExample.Criteria andAlipayUserNameIsNull() {
            return isNull(alipayUserName);
        }

        public PayAlipayExample.Criteria andAlipayUserNameIsNotNull() {
            return isNotNull(alipayUserName);
        }

        public PayAlipayExample.Criteria andAlipayUserNameEqualTo(String value) {
            return equalTo(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameNotEqualTo(String value) {
            return notEqualTo(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameGreaterThan(String value) {
            return greaterThan(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameLessThan(String value) {
            return lessThan(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameLike(String value) {
            return like(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameNotLike(String value) {
            return notLike(alipayUserName, value);
        }

        public PayAlipayExample.Criteria andAlipayUserNameIn(List<String> values) {
            return in(alipayUserName, values);
        }

        public PayAlipayExample.Criteria andAlipayUserNameNotIn(List<String> values) {
            return notIn(alipayUserName, values);
        }

        public PayAlipayExample.Criteria andAlipayUserNameBetween(String value1, String value2) {
            return between(alipayUserName, value1, value2);
        }

        public PayAlipayExample.Criteria andAlipayUserNameNotBetween(String value1, String value2) {
            return notBetween(alipayUserName, value1, value2);
        }
        public PayAlipayExample.Criteria andTbNickIsNull() {
            return isNull(tbNick);
        }

        public PayAlipayExample.Criteria andTbNickIsNotNull() {
            return isNotNull(tbNick);
        }

        public PayAlipayExample.Criteria andTbNickEqualTo(String value) {
            return equalTo(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickNotEqualTo(String value) {
            return notEqualTo(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickGreaterThan(String value) {
            return greaterThan(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickLessThan(String value) {
            return lessThan(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickLike(String value) {
            return like(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickNotLike(String value) {
            return notLike(tbNick, value);
        }

        public PayAlipayExample.Criteria andTbNickIn(List<String> values) {
            return in(tbNick, values);
        }

        public PayAlipayExample.Criteria andTbNickNotIn(List<String> values) {
            return notIn(tbNick, values);
        }

        public PayAlipayExample.Criteria andTbNickBetween(String value1, String value2) {
            return between(tbNick, value1, value2);
        }

        public PayAlipayExample.Criteria andTbNickNotBetween(String value1, String value2) {
            return notBetween(tbNick, value1, value2);
        }
        public PayAlipayExample.Criteria andNeedAuthIsNull() {
            return isNull(needAuth);
        }

        public PayAlipayExample.Criteria andNeedAuthIsNotNull() {
            return isNotNull(needAuth);
        }

        public PayAlipayExample.Criteria andNeedAuthEqualTo(Integer value) {
            return equalTo(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthNotEqualTo(Integer value) {
            return notEqualTo(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthGreaterThan(Integer value) {
            return greaterThan(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthLessThan(Integer value) {
            return lessThan(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(needAuth, value);
        }

        public PayAlipayExample.Criteria andNeedAuthIn(List<Integer> values) {
            return in(needAuth, values);
        }

        public PayAlipayExample.Criteria andNeedAuthNotIn(List<Integer> values) {
            return notIn(needAuth, values);
        }

        public PayAlipayExample.Criteria andNeedAuthBetween(Integer value1, Integer value2) {
            return between(needAuth, value1, value2);
        }

        public PayAlipayExample.Criteria andNeedAuthNotBetween(Integer value1, Integer value2) {
            return notBetween(needAuth, value1, value2);
        }
        public PayAlipayExample.Criteria andTempPriceIsNull() {
            return isNull(tempPrice);
        }

        public PayAlipayExample.Criteria andTempPriceIsNotNull() {
            return isNotNull(tempPrice);
        }

        public PayAlipayExample.Criteria andTempPriceEqualTo(Long value) {
            return equalTo(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceNotEqualTo(Long value) {
            return notEqualTo(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceGreaterThan(Long value) {
            return greaterThan(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceLessThan(Long value) {
            return lessThan(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tempPrice, value);
        }

        public PayAlipayExample.Criteria andTempPriceIn(List<Long> values) {
            return in(tempPrice, values);
        }

        public PayAlipayExample.Criteria andTempPriceNotIn(List<Long> values) {
            return notIn(tempPrice, values);
        }

        public PayAlipayExample.Criteria andTempPriceBetween(Long value1, Long value2) {
            return between(tempPrice, value1, value2);
        }

        public PayAlipayExample.Criteria andTempPriceNotBetween(Long value1, Long value2) {
            return notBetween(tempPrice, value1, value2);
        }
        public PayAlipayExample.Criteria andAlipayUserIdIsNull() {
            return isNull(alipayUserId);
        }

        public PayAlipayExample.Criteria andAlipayUserIdIsNotNull() {
            return isNotNull(alipayUserId);
        }

        public PayAlipayExample.Criteria andAlipayUserIdEqualTo(String value) {
            return equalTo(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdNotEqualTo(String value) {
            return notEqualTo(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdGreaterThan(String value) {
            return greaterThan(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdLessThan(String value) {
            return lessThan(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdLike(String value) {
            return like(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdNotLike(String value) {
            return notLike(alipayUserId, value);
        }

        public PayAlipayExample.Criteria andAlipayUserIdIn(List<String> values) {
            return in(alipayUserId, values);
        }

        public PayAlipayExample.Criteria andAlipayUserIdNotIn(List<String> values) {
            return notIn(alipayUserId, values);
        }

        public PayAlipayExample.Criteria andAlipayUserIdBetween(String value1, String value2) {
            return between(alipayUserId, value1, value2);
        }

        public PayAlipayExample.Criteria andAlipayUserIdNotBetween(String value1, String value2) {
            return notBetween(alipayUserId, value1, value2);
        }
    }
}