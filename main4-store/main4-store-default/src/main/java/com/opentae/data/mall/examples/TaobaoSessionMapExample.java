package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoSessionMap;

import java.util.*;
public class TaobaoSessionMapExample extends SgExample<TaobaoSessionMapExample.Criteria> {
    public static final Class<TaobaoSessionMap> beanClass = TaobaoSessionMap.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn session;
    public static EntityColumn w1ExpiresIn;
    public static EntityColumn remark;
    public static EntityColumn secret;
    public static EntityColumn nick;
    public static EntityColumn expiresIn;
    public static EntityColumn subTaobaoUserNick;
    public static EntityColumn tsmId;
    public static EntityColumn r2ExpiresIn;
    public static EntityColumn shopId;
    public static EntityColumn w2ExpiresIn;
    public static EntityColumn freshTime;
    public static EntityColumn reExpiresIn;
    public static EntityColumn userId;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn r1ExpiresIn;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn appkey;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn tokenType;
    public static EntityColumn subTaobaoUserId;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn refreshToken;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        session = listMap.get("session");
        w1ExpiresIn = listMap.get("w1ExpiresIn");
        remark = listMap.get("remark");
        secret = listMap.get("secret");
        nick = listMap.get("nick");
        expiresIn = listMap.get("expiresIn");
        subTaobaoUserNick = listMap.get("subTaobaoUserNick");
        tsmId = listMap.get("tsmId");
        r2ExpiresIn = listMap.get("r2ExpiresIn");
        shopId = listMap.get("shopId");
        w2ExpiresIn = listMap.get("w2ExpiresIn");
        freshTime = listMap.get("freshTime");
        reExpiresIn = listMap.get("reExpiresIn");
        userId = listMap.get("userId");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        r1ExpiresIn = listMap.get("r1ExpiresIn");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        appkey = listMap.get("appkey");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        tokenType = listMap.get("tokenType");
        subTaobaoUserId = listMap.get("subTaobaoUserId");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        refreshToken = listMap.get("refreshToken");
        remark2 = listMap.get("remark2");
        }

    public TaobaoSessionMapExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TaobaoSessionMapExample.Criteria createCriteriaInternal() {
        return new TaobaoSessionMapExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TaobaoSessionMapExample.Criteria andSessionIsNull() {
            return isNull(session);
        }

        public TaobaoSessionMapExample.Criteria andSessionIsNotNull() {
            return isNotNull(session);
        }

        public TaobaoSessionMapExample.Criteria andSessionEqualTo(String value) {
            return equalTo(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionNotEqualTo(String value) {
            return notEqualTo(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionGreaterThan(String value) {
            return greaterThan(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionLessThan(String value) {
            return lessThan(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionLike(String value) {
            return like(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionNotLike(String value) {
            return notLike(session, value);
        }

        public TaobaoSessionMapExample.Criteria andSessionIn(List<String> values) {
            return in(session, values);
        }

        public TaobaoSessionMapExample.Criteria andSessionNotIn(List<String> values) {
            return notIn(session, values);
        }

        public TaobaoSessionMapExample.Criteria andSessionBetween(String value1, String value2) {
            return between(session, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andSessionNotBetween(String value1, String value2) {
            return notBetween(session, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andW1ExpiresInIsNull() {
            return isNull(w1ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInIsNotNull() {
            return isNotNull(w1ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInEqualTo(Long value) {
            return equalTo(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotEqualTo(Long value) {
            return notEqualTo(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInGreaterThan(Long value) {
            return greaterThan(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInLessThan(Long value) {
            return lessThan(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(w1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInIn(List<Long> values) {
            return in(w1ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotIn(List<Long> values) {
            return notIn(w1ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInBetween(Long value1, Long value2) {
            return between(w1ExpiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(w1ExpiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public TaobaoSessionMapExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public TaobaoSessionMapExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public TaobaoSessionMapExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public TaobaoSessionMapExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andSecretIsNull() {
            return isNull(secret);
        }

        public TaobaoSessionMapExample.Criteria andSecretIsNotNull() {
            return isNotNull(secret);
        }

        public TaobaoSessionMapExample.Criteria andSecretEqualTo(String value) {
            return equalTo(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretNotEqualTo(String value) {
            return notEqualTo(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretGreaterThan(String value) {
            return greaterThan(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretLessThan(String value) {
            return lessThan(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretLike(String value) {
            return like(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretNotLike(String value) {
            return notLike(secret, value);
        }

        public TaobaoSessionMapExample.Criteria andSecretIn(List<String> values) {
            return in(secret, values);
        }

        public TaobaoSessionMapExample.Criteria andSecretNotIn(List<String> values) {
            return notIn(secret, values);
        }

        public TaobaoSessionMapExample.Criteria andSecretBetween(String value1, String value2) {
            return between(secret, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andSecretNotBetween(String value1, String value2) {
            return notBetween(secret, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andNickIsNull() {
            return isNull(nick);
        }

        public TaobaoSessionMapExample.Criteria andNickIsNotNull() {
            return isNotNull(nick);
        }

        public TaobaoSessionMapExample.Criteria andNickEqualTo(String value) {
            return equalTo(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickNotEqualTo(String value) {
            return notEqualTo(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickGreaterThan(String value) {
            return greaterThan(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickLessThan(String value) {
            return lessThan(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickLike(String value) {
            return like(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickNotLike(String value) {
            return notLike(nick, value);
        }

        public TaobaoSessionMapExample.Criteria andNickIn(List<String> values) {
            return in(nick, values);
        }

        public TaobaoSessionMapExample.Criteria andNickNotIn(List<String> values) {
            return notIn(nick, values);
        }

        public TaobaoSessionMapExample.Criteria andNickBetween(String value1, String value2) {
            return between(nick, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andNickNotBetween(String value1, String value2) {
            return notBetween(nick, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInEqualTo(Long value) {
            return equalTo(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotEqualTo(Long value) {
            return notEqualTo(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInGreaterThan(Long value) {
            return greaterThan(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInLessThan(Long value) {
            return lessThan(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInIn(List<Long> values) {
            return in(expiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotIn(List<Long> values) {
            return notIn(expiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInBetween(Long value1, Long value2) {
            return between(expiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIsNull() {
            return isNull(subTaobaoUserNick);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIsNotNull() {
            return isNotNull(subTaobaoUserNick);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickEqualTo(String value) {
            return equalTo(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickGreaterThan(String value) {
            return greaterThan(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLessThan(String value) {
            return lessThan(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLike(String value) {
            return like(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotLike(String value) {
            return notLike(subTaobaoUserNick, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIn(List<String> values) {
            return in(subTaobaoUserNick, values);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotIn(List<String> values) {
            return notIn(subTaobaoUserNick, values);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickBetween(String value1, String value2) {
            return between(subTaobaoUserNick, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(subTaobaoUserNick, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andTsmIdIsNull() {
            return isNull(tsmId);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdIsNotNull() {
            return isNotNull(tsmId);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdEqualTo(Long value) {
            return equalTo(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotEqualTo(Long value) {
            return notEqualTo(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdGreaterThan(Long value) {
            return greaterThan(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdLessThan(Long value) {
            return lessThan(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tsmId, value);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdIn(List<Long> values) {
            return in(tsmId, values);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotIn(List<Long> values) {
            return notIn(tsmId, values);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdBetween(Long value1, Long value2) {
            return between(tsmId, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotBetween(Long value1, Long value2) {
            return notBetween(tsmId, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andR2ExpiresInIsNull() {
            return isNull(r2ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInIsNotNull() {
            return isNotNull(r2ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInEqualTo(Long value) {
            return equalTo(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotEqualTo(Long value) {
            return notEqualTo(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInGreaterThan(Long value) {
            return greaterThan(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInLessThan(Long value) {
            return lessThan(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(r2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInIn(List<Long> values) {
            return in(r2ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotIn(List<Long> values) {
            return notIn(r2ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInBetween(Long value1, Long value2) {
            return between(r2ExpiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(r2ExpiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public TaobaoSessionMapExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public TaobaoSessionMapExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public TaobaoSessionMapExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public TaobaoSessionMapExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andW2ExpiresInIsNull() {
            return isNull(w2ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInIsNotNull() {
            return isNotNull(w2ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInEqualTo(Long value) {
            return equalTo(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotEqualTo(Long value) {
            return notEqualTo(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInGreaterThan(Long value) {
            return greaterThan(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInLessThan(Long value) {
            return lessThan(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(w2ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInIn(List<Long> values) {
            return in(w2ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotIn(List<Long> values) {
            return notIn(w2ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInBetween(Long value1, Long value2) {
            return between(w2ExpiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(w2ExpiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andFreshTimeIsNull() {
            return isNull(freshTime);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeIsNotNull() {
            return isNotNull(freshTime);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeEqualTo(Date value) {
            return equalTo(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotEqualTo(Date value) {
            return notEqualTo(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeGreaterThan(Date value) {
            return greaterThan(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeLessThan(Date value) {
            return lessThan(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(freshTime, value);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeIn(List<Date> values) {
            return in(freshTime, values);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotIn(List<Date> values) {
            return notIn(freshTime, values);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeBetween(Date value1, Date value2) {
            return between(freshTime, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotBetween(Date value1, Date value2) {
            return notBetween(freshTime, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andReExpiresInIsNull() {
            return isNull(reExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInIsNotNull() {
            return isNotNull(reExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInEqualTo(Long value) {
            return equalTo(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotEqualTo(Long value) {
            return notEqualTo(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInGreaterThan(Long value) {
            return greaterThan(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInLessThan(Long value) {
            return lessThan(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(reExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInIn(List<Long> values) {
            return in(reExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotIn(List<Long> values) {
            return notIn(reExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInBetween(Long value1, Long value2) {
            return between(reExpiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(reExpiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public TaobaoSessionMapExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public TaobaoSessionMapExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public TaobaoSessionMapExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public TaobaoSessionMapExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public TaobaoSessionMapExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public TaobaoSessionMapExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public TaobaoSessionMapExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public TaobaoSessionMapExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andR1ExpiresInIsNull() {
            return isNull(r1ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInIsNotNull() {
            return isNotNull(r1ExpiresIn);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInEqualTo(Long value) {
            return equalTo(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotEqualTo(Long value) {
            return notEqualTo(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInGreaterThan(Long value) {
            return greaterThan(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInLessThan(Long value) {
            return lessThan(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(r1ExpiresIn, value);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInIn(List<Long> values) {
            return in(r1ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotIn(List<Long> values) {
            return notIn(r1ExpiresIn, values);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInBetween(Long value1, Long value2) {
            return between(r1ExpiresIn, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(r1ExpiresIn, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public TaobaoSessionMapExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public TaobaoSessionMapExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoSessionMapExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoSessionMapExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoSessionMapExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoSessionMapExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andAppkeyIsNull() {
            return isNull(appkey);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyIsNotNull() {
            return isNotNull(appkey);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyEqualTo(String value) {
            return equalTo(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotEqualTo(String value) {
            return notEqualTo(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyGreaterThan(String value) {
            return greaterThan(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLessThan(String value) {
            return lessThan(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLike(String value) {
            return like(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotLike(String value) {
            return notLike(appkey, value);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyIn(List<String> values) {
            return in(appkey, values);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotIn(List<String> values) {
            return notIn(appkey, values);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyBetween(String value1, String value2) {
            return between(appkey, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotBetween(String value1, String value2) {
            return notBetween(appkey, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public TaobaoSessionMapExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public TaobaoSessionMapExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public TaobaoSessionMapExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public TaobaoSessionMapExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andTokenTypeIsNull() {
            return isNull(tokenType);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeIsNotNull() {
            return isNotNull(tokenType);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeEqualTo(String value) {
            return equalTo(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotEqualTo(String value) {
            return notEqualTo(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeGreaterThan(String value) {
            return greaterThan(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLessThan(String value) {
            return lessThan(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLike(String value) {
            return like(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotLike(String value) {
            return notLike(tokenType, value);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeIn(List<String> values) {
            return in(tokenType, values);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotIn(List<String> values) {
            return notIn(tokenType, values);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeBetween(String value1, String value2) {
            return between(tokenType, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotBetween(String value1, String value2) {
            return notBetween(tokenType, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIsNull() {
            return isNull(subTaobaoUserId);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIsNotNull() {
            return isNotNull(subTaobaoUserId);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdEqualTo(Long value) {
            return equalTo(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotEqualTo(Long value) {
            return notEqualTo(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdGreaterThan(Long value) {
            return greaterThan(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdLessThan(Long value) {
            return lessThan(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subTaobaoUserId, value);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIn(List<Long> values) {
            return in(subTaobaoUserId, values);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotIn(List<Long> values) {
            return notIn(subTaobaoUserId, values);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdBetween(Long value1, Long value2) {
            return between(subTaobaoUserId, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotBetween(Long value1, Long value2) {
            return notBetween(subTaobaoUserId, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoSessionMapExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoSessionMapExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoSessionMapExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoSessionMapExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRefreshTokenIsNull() {
            return isNull(refreshToken);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenIsNotNull() {
            return isNotNull(refreshToken);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenEqualTo(String value) {
            return equalTo(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotEqualTo(String value) {
            return notEqualTo(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenGreaterThan(String value) {
            return greaterThan(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLessThan(String value) {
            return lessThan(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLike(String value) {
            return like(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotLike(String value) {
            return notLike(refreshToken, value);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenIn(List<String> values) {
            return in(refreshToken, values);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotIn(List<String> values) {
            return notIn(refreshToken, values);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenBetween(String value1, String value2) {
            return between(refreshToken, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotBetween(String value1, String value2) {
            return notBetween(refreshToken, value1, value2);
        }
        public TaobaoSessionMapExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoSessionMapExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoSessionMapExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TaobaoSessionMapExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TaobaoSessionMapExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
