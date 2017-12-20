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
    public static EntityColumn w1ExpiresIn;
    public static EntityColumn session;
    public static EntityColumn remark;
    public static EntityColumn secret;
    public static EntityColumn nick;
    public static EntityColumn subTaobaoUserNick;
    public static EntityColumn expiresIn;
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
        w1ExpiresIn = listMap.get("w1ExpiresIn");
        session = listMap.get("session");
        remark = listMap.get("remark");
        secret = listMap.get("secret");
        nick = listMap.get("nick");
        subTaobaoUserNick = listMap.get("subTaobaoUserNick");
        expiresIn = listMap.get("expiresIn");
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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andW1ExpiresInIsNull() {
            return isNull(w1ExpiresIn);
        }

        public Criteria andW1ExpiresInIsNotNull() {
            return isNotNull(w1ExpiresIn);
        }

        public Criteria andW1ExpiresInEqualTo(Long value) {
            return equalTo(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInNotEqualTo(Long value) {
            return notEqualTo(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInGreaterThan(Long value) {
            return greaterThan(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInLessThan(Long value) {
            return lessThan(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(w1ExpiresIn, value);
        }

        public Criteria andW1ExpiresInIn(List<Long> values) {
            return in(w1ExpiresIn, values);
        }

        public Criteria andW1ExpiresInNotIn(List<Long> values) {
            return notIn(w1ExpiresIn, values);
        }

        public Criteria andW1ExpiresInBetween(Long value1, Long value2) {
            return between(w1ExpiresIn, value1, value2);
        }

        public Criteria andW1ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(w1ExpiresIn, value1, value2);
        }
        public Criteria andSessionIsNull() {
            return isNull(session);
        }

        public Criteria andSessionIsNotNull() {
            return isNotNull(session);
        }

        public Criteria andSessionEqualTo(String value) {
            return equalTo(session, value);
        }

        public Criteria andSessionNotEqualTo(String value) {
            return notEqualTo(session, value);
        }

        public Criteria andSessionGreaterThan(String value) {
            return greaterThan(session, value);
        }

        public Criteria andSessionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(session, value);
        }

        public Criteria andSessionLessThan(String value) {
            return lessThan(session, value);
        }

        public Criteria andSessionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(session, value);
        }

        public Criteria andSessionLike(String value) {
            return like(session, value);
        }

        public Criteria andSessionNotLike(String value) {
            return notLike(session, value);
        }

        public Criteria andSessionIn(List<String> values) {
            return in(session, values);
        }

        public Criteria andSessionNotIn(List<String> values) {
            return notIn(session, values);
        }

        public Criteria andSessionBetween(String value1, String value2) {
            return between(session, value1, value2);
        }

        public Criteria andSessionNotBetween(String value1, String value2) {
            return notBetween(session, value1, value2);
        }
        public Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public Criteria andSecretIsNull() {
            return isNull(secret);
        }

        public Criteria andSecretIsNotNull() {
            return isNotNull(secret);
        }

        public Criteria andSecretEqualTo(String value) {
            return equalTo(secret, value);
        }

        public Criteria andSecretNotEqualTo(String value) {
            return notEqualTo(secret, value);
        }

        public Criteria andSecretGreaterThan(String value) {
            return greaterThan(secret, value);
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(secret, value);
        }

        public Criteria andSecretLessThan(String value) {
            return lessThan(secret, value);
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(secret, value);
        }

        public Criteria andSecretLike(String value) {
            return like(secret, value);
        }

        public Criteria andSecretNotLike(String value) {
            return notLike(secret, value);
        }

        public Criteria andSecretIn(List<String> values) {
            return in(secret, values);
        }

        public Criteria andSecretNotIn(List<String> values) {
            return notIn(secret, values);
        }

        public Criteria andSecretBetween(String value1, String value2) {
            return between(secret, value1, value2);
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            return notBetween(secret, value1, value2);
        }
        public Criteria andNickIsNull() {
            return isNull(nick);
        }

        public Criteria andNickIsNotNull() {
            return isNotNull(nick);
        }

        public Criteria andNickEqualTo(String value) {
            return equalTo(nick, value);
        }

        public Criteria andNickNotEqualTo(String value) {
            return notEqualTo(nick, value);
        }

        public Criteria andNickGreaterThan(String value) {
            return greaterThan(nick, value);
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nick, value);
        }

        public Criteria andNickLessThan(String value) {
            return lessThan(nick, value);
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nick, value);
        }

        public Criteria andNickLike(String value) {
            return like(nick, value);
        }

        public Criteria andNickNotLike(String value) {
            return notLike(nick, value);
        }

        public Criteria andNickIn(List<String> values) {
            return in(nick, values);
        }

        public Criteria andNickNotIn(List<String> values) {
            return notIn(nick, values);
        }

        public Criteria andNickBetween(String value1, String value2) {
            return between(nick, value1, value2);
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            return notBetween(nick, value1, value2);
        }
        public Criteria andSubTaobaoUserNickIsNull() {
            return isNull(subTaobaoUserNick);
        }

        public Criteria andSubTaobaoUserNickIsNotNull() {
            return isNotNull(subTaobaoUserNick);
        }

        public Criteria andSubTaobaoUserNickEqualTo(String value) {
            return equalTo(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickGreaterThan(String value) {
            return greaterThan(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickLessThan(String value) {
            return lessThan(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickLike(String value) {
            return like(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickNotLike(String value) {
            return notLike(subTaobaoUserNick, value);
        }

        public Criteria andSubTaobaoUserNickIn(List<String> values) {
            return in(subTaobaoUserNick, values);
        }

        public Criteria andSubTaobaoUserNickNotIn(List<String> values) {
            return notIn(subTaobaoUserNick, values);
        }

        public Criteria andSubTaobaoUserNickBetween(String value1, String value2) {
            return between(subTaobaoUserNick, value1, value2);
        }

        public Criteria andSubTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(subTaobaoUserNick, value1, value2);
        }
        public Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public Criteria andExpiresInEqualTo(Long value) {
            return equalTo(expiresIn, value);
        }

        public Criteria andExpiresInNotEqualTo(Long value) {
            return notEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInGreaterThan(Long value) {
            return greaterThan(expiresIn, value);
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInLessThan(Long value) {
            return lessThan(expiresIn, value);
        }

        public Criteria andExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInIn(List<Long> values) {
            return in(expiresIn, values);
        }

        public Criteria andExpiresInNotIn(List<Long> values) {
            return notIn(expiresIn, values);
        }

        public Criteria andExpiresInBetween(Long value1, Long value2) {
            return between(expiresIn, value1, value2);
        }

        public Criteria andExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public Criteria andTsmIdIsNull() {
            return isNull(tsmId);
        }

        public Criteria andTsmIdIsNotNull() {
            return isNotNull(tsmId);
        }

        public Criteria andTsmIdEqualTo(Long value) {
            return equalTo(tsmId, value);
        }

        public Criteria andTsmIdNotEqualTo(Long value) {
            return notEqualTo(tsmId, value);
        }

        public Criteria andTsmIdGreaterThan(Long value) {
            return greaterThan(tsmId, value);
        }

        public Criteria andTsmIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tsmId, value);
        }

        public Criteria andTsmIdLessThan(Long value) {
            return lessThan(tsmId, value);
        }

        public Criteria andTsmIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tsmId, value);
        }

        public Criteria andTsmIdIn(List<Long> values) {
            return in(tsmId, values);
        }

        public Criteria andTsmIdNotIn(List<Long> values) {
            return notIn(tsmId, values);
        }

        public Criteria andTsmIdBetween(Long value1, Long value2) {
            return between(tsmId, value1, value2);
        }

        public Criteria andTsmIdNotBetween(Long value1, Long value2) {
            return notBetween(tsmId, value1, value2);
        }
        public Criteria andR2ExpiresInIsNull() {
            return isNull(r2ExpiresIn);
        }

        public Criteria andR2ExpiresInIsNotNull() {
            return isNotNull(r2ExpiresIn);
        }

        public Criteria andR2ExpiresInEqualTo(Long value) {
            return equalTo(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInNotEqualTo(Long value) {
            return notEqualTo(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInGreaterThan(Long value) {
            return greaterThan(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInLessThan(Long value) {
            return lessThan(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(r2ExpiresIn, value);
        }

        public Criteria andR2ExpiresInIn(List<Long> values) {
            return in(r2ExpiresIn, values);
        }

        public Criteria andR2ExpiresInNotIn(List<Long> values) {
            return notIn(r2ExpiresIn, values);
        }

        public Criteria andR2ExpiresInBetween(Long value1, Long value2) {
            return between(r2ExpiresIn, value1, value2);
        }

        public Criteria andR2ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(r2ExpiresIn, value1, value2);
        }
        public Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public Criteria andW2ExpiresInIsNull() {
            return isNull(w2ExpiresIn);
        }

        public Criteria andW2ExpiresInIsNotNull() {
            return isNotNull(w2ExpiresIn);
        }

        public Criteria andW2ExpiresInEqualTo(Long value) {
            return equalTo(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInNotEqualTo(Long value) {
            return notEqualTo(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInGreaterThan(Long value) {
            return greaterThan(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInLessThan(Long value) {
            return lessThan(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(w2ExpiresIn, value);
        }

        public Criteria andW2ExpiresInIn(List<Long> values) {
            return in(w2ExpiresIn, values);
        }

        public Criteria andW2ExpiresInNotIn(List<Long> values) {
            return notIn(w2ExpiresIn, values);
        }

        public Criteria andW2ExpiresInBetween(Long value1, Long value2) {
            return between(w2ExpiresIn, value1, value2);
        }

        public Criteria andW2ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(w2ExpiresIn, value1, value2);
        }
        public Criteria andFreshTimeIsNull() {
            return isNull(freshTime);
        }

        public Criteria andFreshTimeIsNotNull() {
            return isNotNull(freshTime);
        }

        public Criteria andFreshTimeEqualTo(Date value) {
            return equalTo(freshTime, value);
        }

        public Criteria andFreshTimeNotEqualTo(Date value) {
            return notEqualTo(freshTime, value);
        }

        public Criteria andFreshTimeGreaterThan(Date value) {
            return greaterThan(freshTime, value);
        }

        public Criteria andFreshTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(freshTime, value);
        }

        public Criteria andFreshTimeLessThan(Date value) {
            return lessThan(freshTime, value);
        }

        public Criteria andFreshTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(freshTime, value);
        }

        public Criteria andFreshTimeIn(List<Date> values) {
            return in(freshTime, values);
        }

        public Criteria andFreshTimeNotIn(List<Date> values) {
            return notIn(freshTime, values);
        }

        public Criteria andFreshTimeBetween(Date value1, Date value2) {
            return between(freshTime, value1, value2);
        }

        public Criteria andFreshTimeNotBetween(Date value1, Date value2) {
            return notBetween(freshTime, value1, value2);
        }
        public Criteria andReExpiresInIsNull() {
            return isNull(reExpiresIn);
        }

        public Criteria andReExpiresInIsNotNull() {
            return isNotNull(reExpiresIn);
        }

        public Criteria andReExpiresInEqualTo(Long value) {
            return equalTo(reExpiresIn, value);
        }

        public Criteria andReExpiresInNotEqualTo(Long value) {
            return notEqualTo(reExpiresIn, value);
        }

        public Criteria andReExpiresInGreaterThan(Long value) {
            return greaterThan(reExpiresIn, value);
        }

        public Criteria andReExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(reExpiresIn, value);
        }

        public Criteria andReExpiresInLessThan(Long value) {
            return lessThan(reExpiresIn, value);
        }

        public Criteria andReExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(reExpiresIn, value);
        }

        public Criteria andReExpiresInIn(List<Long> values) {
            return in(reExpiresIn, values);
        }

        public Criteria andReExpiresInNotIn(List<Long> values) {
            return notIn(reExpiresIn, values);
        }

        public Criteria andReExpiresInBetween(Long value1, Long value2) {
            return between(reExpiresIn, value1, value2);
        }

        public Criteria andReExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(reExpiresIn, value1, value2);
        }
        public Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public Criteria andR1ExpiresInIsNull() {
            return isNull(r1ExpiresIn);
        }

        public Criteria andR1ExpiresInIsNotNull() {
            return isNotNull(r1ExpiresIn);
        }

        public Criteria andR1ExpiresInEqualTo(Long value) {
            return equalTo(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInNotEqualTo(Long value) {
            return notEqualTo(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInGreaterThan(Long value) {
            return greaterThan(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInLessThan(Long value) {
            return lessThan(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(r1ExpiresIn, value);
        }

        public Criteria andR1ExpiresInIn(List<Long> values) {
            return in(r1ExpiresIn, values);
        }

        public Criteria andR1ExpiresInNotIn(List<Long> values) {
            return notIn(r1ExpiresIn, values);
        }

        public Criteria andR1ExpiresInBetween(Long value1, Long value2) {
            return between(r1ExpiresIn, value1, value2);
        }

        public Criteria andR1ExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(r1ExpiresIn, value1, value2);
        }
        public Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public Criteria andAppkeyIsNull() {
            return isNull(appkey);
        }

        public Criteria andAppkeyIsNotNull() {
            return isNotNull(appkey);
        }

        public Criteria andAppkeyEqualTo(String value) {
            return equalTo(appkey, value);
        }

        public Criteria andAppkeyNotEqualTo(String value) {
            return notEqualTo(appkey, value);
        }

        public Criteria andAppkeyGreaterThan(String value) {
            return greaterThan(appkey, value);
        }

        public Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(appkey, value);
        }

        public Criteria andAppkeyLessThan(String value) {
            return lessThan(appkey, value);
        }

        public Criteria andAppkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(appkey, value);
        }

        public Criteria andAppkeyLike(String value) {
            return like(appkey, value);
        }

        public Criteria andAppkeyNotLike(String value) {
            return notLike(appkey, value);
        }

        public Criteria andAppkeyIn(List<String> values) {
            return in(appkey, values);
        }

        public Criteria andAppkeyNotIn(List<String> values) {
            return notIn(appkey, values);
        }

        public Criteria andAppkeyBetween(String value1, String value2) {
            return between(appkey, value1, value2);
        }

        public Criteria andAppkeyNotBetween(String value1, String value2) {
            return notBetween(appkey, value1, value2);
        }
        public Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public Criteria andTokenTypeIsNull() {
            return isNull(tokenType);
        }

        public Criteria andTokenTypeIsNotNull() {
            return isNotNull(tokenType);
        }

        public Criteria andTokenTypeEqualTo(String value) {
            return equalTo(tokenType, value);
        }

        public Criteria andTokenTypeNotEqualTo(String value) {
            return notEqualTo(tokenType, value);
        }

        public Criteria andTokenTypeGreaterThan(String value) {
            return greaterThan(tokenType, value);
        }

        public Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tokenType, value);
        }

        public Criteria andTokenTypeLessThan(String value) {
            return lessThan(tokenType, value);
        }

        public Criteria andTokenTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tokenType, value);
        }

        public Criteria andTokenTypeLike(String value) {
            return like(tokenType, value);
        }

        public Criteria andTokenTypeNotLike(String value) {
            return notLike(tokenType, value);
        }

        public Criteria andTokenTypeIn(List<String> values) {
            return in(tokenType, values);
        }

        public Criteria andTokenTypeNotIn(List<String> values) {
            return notIn(tokenType, values);
        }

        public Criteria andTokenTypeBetween(String value1, String value2) {
            return between(tokenType, value1, value2);
        }

        public Criteria andTokenTypeNotBetween(String value1, String value2) {
            return notBetween(tokenType, value1, value2);
        }
        public Criteria andSubTaobaoUserIdIsNull() {
            return isNull(subTaobaoUserId);
        }

        public Criteria andSubTaobaoUserIdIsNotNull() {
            return isNotNull(subTaobaoUserId);
        }

        public Criteria andSubTaobaoUserIdEqualTo(Long value) {
            return equalTo(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdNotEqualTo(Long value) {
            return notEqualTo(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdGreaterThan(Long value) {
            return greaterThan(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdLessThan(Long value) {
            return lessThan(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subTaobaoUserId, value);
        }

        public Criteria andSubTaobaoUserIdIn(List<Long> values) {
            return in(subTaobaoUserId, values);
        }

        public Criteria andSubTaobaoUserIdNotIn(List<Long> values) {
            return notIn(subTaobaoUserId, values);
        }

        public Criteria andSubTaobaoUserIdBetween(Long value1, Long value2) {
            return between(subTaobaoUserId, value1, value2);
        }

        public Criteria andSubTaobaoUserIdNotBetween(Long value1, Long value2) {
            return notBetween(subTaobaoUserId, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public Criteria andRefreshTokenIsNull() {
            return isNull(refreshToken);
        }

        public Criteria andRefreshTokenIsNotNull() {
            return isNotNull(refreshToken);
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            return equalTo(refreshToken, value);
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            return notEqualTo(refreshToken, value);
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            return greaterThan(refreshToken, value);
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refreshToken, value);
        }

        public Criteria andRefreshTokenLessThan(String value) {
            return lessThan(refreshToken, value);
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refreshToken, value);
        }

        public Criteria andRefreshTokenLike(String value) {
            return like(refreshToken, value);
        }

        public Criteria andRefreshTokenNotLike(String value) {
            return notLike(refreshToken, value);
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            return in(refreshToken, values);
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            return notIn(refreshToken, values);
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            return between(refreshToken, value1, value2);
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            return notBetween(refreshToken, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}