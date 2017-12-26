package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdSessionMap;

import java.util.*;
public class JdSessionMapExample extends SgExample<JdSessionMapExample.Criteria> {
    public static final Class<JdSessionMap> beanClass = JdSessionMap.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn expiresIn;
    public static EntityColumn uid;
    public static EntityColumn tokenId;
    public static EntityColumn createTime;
    public static EntityColumn userNick;
    public static EntityColumn lastModifyTime;
    public static EntityColumn appKey;
    public static EntityColumn authTime;
    public static EntityColumn accessToken;
    public static EntityColumn refreshToken;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        expiresIn = listMap.get("expiresIn");
        uid = listMap.get("uid");
        tokenId = listMap.get("tokenId");
        createTime = listMap.get("createTime");
        userNick = listMap.get("userNick");
        lastModifyTime = listMap.get("lastModifyTime");
        appKey = listMap.get("appKey");
        authTime = listMap.get("authTime");
        accessToken = listMap.get("accessToken");
        refreshToken = listMap.get("refreshToken");
        }

    public JdSessionMapExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected JdSessionMapExample.Criteria createCriteriaInternal() {
        return new JdSessionMapExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdSessionMapExample.Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public JdSessionMapExample.Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public JdSessionMapExample.Criteria andExpiresInEqualTo(Long value) {
            return equalTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInNotEqualTo(Long value) {
            return notEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInGreaterThan(Long value) {
            return greaterThan(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInLessThan(Long value) {
            return lessThan(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInIn(List<Long> values) {
            return in(expiresIn, values);
        }

        public JdSessionMapExample.Criteria andExpiresInNotIn(List<Long> values) {
            return notIn(expiresIn, values);
        }

        public JdSessionMapExample.Criteria andExpiresInBetween(Long value1, Long value2) {
            return between(expiresIn, value1, value2);
        }

        public JdSessionMapExample.Criteria andExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public JdSessionMapExample.Criteria andUidIsNull() {
            return isNull(uid);
        }

        public JdSessionMapExample.Criteria andUidIsNotNull() {
            return isNotNull(uid);
        }

        public JdSessionMapExample.Criteria andUidEqualTo(Long value) {
            return equalTo(uid, value);
        }

        public JdSessionMapExample.Criteria andUidNotEqualTo(Long value) {
            return notEqualTo(uid, value);
        }

        public JdSessionMapExample.Criteria andUidGreaterThan(Long value) {
            return greaterThan(uid, value);
        }

        public JdSessionMapExample.Criteria andUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(uid, value);
        }

        public JdSessionMapExample.Criteria andUidLessThan(Long value) {
            return lessThan(uid, value);
        }

        public JdSessionMapExample.Criteria andUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(uid, value);
        }

        public JdSessionMapExample.Criteria andUidIn(List<Long> values) {
            return in(uid, values);
        }

        public JdSessionMapExample.Criteria andUidNotIn(List<Long> values) {
            return notIn(uid, values);
        }

        public JdSessionMapExample.Criteria andUidBetween(Long value1, Long value2) {
            return between(uid, value1, value2);
        }

        public JdSessionMapExample.Criteria andUidNotBetween(Long value1, Long value2) {
            return notBetween(uid, value1, value2);
        }
        public JdSessionMapExample.Criteria andTokenIdIsNull() {
            return isNull(tokenId);
        }

        public JdSessionMapExample.Criteria andTokenIdIsNotNull() {
            return isNotNull(tokenId);
        }

        public JdSessionMapExample.Criteria andTokenIdEqualTo(Long value) {
            return equalTo(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdNotEqualTo(Long value) {
            return notEqualTo(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdGreaterThan(Long value) {
            return greaterThan(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdLessThan(Long value) {
            return lessThan(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tokenId, value);
        }

        public JdSessionMapExample.Criteria andTokenIdIn(List<Long> values) {
            return in(tokenId, values);
        }

        public JdSessionMapExample.Criteria andTokenIdNotIn(List<Long> values) {
            return notIn(tokenId, values);
        }

        public JdSessionMapExample.Criteria andTokenIdBetween(Long value1, Long value2) {
            return between(tokenId, value1, value2);
        }

        public JdSessionMapExample.Criteria andTokenIdNotBetween(Long value1, Long value2) {
            return notBetween(tokenId, value1, value2);
        }
        public JdSessionMapExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public JdSessionMapExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public JdSessionMapExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public JdSessionMapExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public JdSessionMapExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public JdSessionMapExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public JdSessionMapExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public JdSessionMapExample.Criteria andUserNickIsNull() {
            return isNull(userNick);
        }

        public JdSessionMapExample.Criteria andUserNickIsNotNull() {
            return isNotNull(userNick);
        }

        public JdSessionMapExample.Criteria andUserNickEqualTo(String value) {
            return equalTo(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickNotEqualTo(String value) {
            return notEqualTo(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickGreaterThan(String value) {
            return greaterThan(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickLessThan(String value) {
            return lessThan(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickLike(String value) {
            return like(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickNotLike(String value) {
            return notLike(userNick, value);
        }

        public JdSessionMapExample.Criteria andUserNickIn(List<String> values) {
            return in(userNick, values);
        }

        public JdSessionMapExample.Criteria andUserNickNotIn(List<String> values) {
            return notIn(userNick, values);
        }

        public JdSessionMapExample.Criteria andUserNickBetween(String value1, String value2) {
            return between(userNick, value1, value2);
        }

        public JdSessionMapExample.Criteria andUserNickNotBetween(String value1, String value2) {
            return notBetween(userNick, value1, value2);
        }
        public JdSessionMapExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public JdSessionMapExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public JdSessionMapExample.Criteria andAppKeyIsNull() {
            return isNull(appKey);
        }

        public JdSessionMapExample.Criteria andAppKeyIsNotNull() {
            return isNotNull(appKey);
        }

        public JdSessionMapExample.Criteria andAppKeyEqualTo(String value) {
            return equalTo(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyNotEqualTo(String value) {
            return notEqualTo(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyGreaterThan(String value) {
            return greaterThan(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyLessThan(String value) {
            return lessThan(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyLike(String value) {
            return like(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyNotLike(String value) {
            return notLike(appKey, value);
        }

        public JdSessionMapExample.Criteria andAppKeyIn(List<String> values) {
            return in(appKey, values);
        }

        public JdSessionMapExample.Criteria andAppKeyNotIn(List<String> values) {
            return notIn(appKey, values);
        }

        public JdSessionMapExample.Criteria andAppKeyBetween(String value1, String value2) {
            return between(appKey, value1, value2);
        }

        public JdSessionMapExample.Criteria andAppKeyNotBetween(String value1, String value2) {
            return notBetween(appKey, value1, value2);
        }
        public JdSessionMapExample.Criteria andAuthTimeIsNull() {
            return isNull(authTime);
        }

        public JdSessionMapExample.Criteria andAuthTimeIsNotNull() {
            return isNotNull(authTime);
        }

        public JdSessionMapExample.Criteria andAuthTimeEqualTo(Long value) {
            return equalTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotEqualTo(Long value) {
            return notEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeGreaterThan(Long value) {
            return greaterThan(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeLessThan(Long value) {
            return lessThan(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeIn(List<Long> values) {
            return in(authTime, values);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotIn(List<Long> values) {
            return notIn(authTime, values);
        }

        public JdSessionMapExample.Criteria andAuthTimeBetween(Long value1, Long value2) {
            return between(authTime, value1, value2);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotBetween(Long value1, Long value2) {
            return notBetween(authTime, value1, value2);
        }
        public JdSessionMapExample.Criteria andAccessTokenIsNull() {
            return isNull(accessToken);
        }

        public JdSessionMapExample.Criteria andAccessTokenIsNotNull() {
            return isNotNull(accessToken);
        }

        public JdSessionMapExample.Criteria andAccessTokenEqualTo(String value) {
            return equalTo(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenNotEqualTo(String value) {
            return notEqualTo(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenGreaterThan(String value) {
            return greaterThan(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenLessThan(String value) {
            return lessThan(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenLike(String value) {
            return like(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenNotLike(String value) {
            return notLike(accessToken, value);
        }

        public JdSessionMapExample.Criteria andAccessTokenIn(List<String> values) {
            return in(accessToken, values);
        }

        public JdSessionMapExample.Criteria andAccessTokenNotIn(List<String> values) {
            return notIn(accessToken, values);
        }

        public JdSessionMapExample.Criteria andAccessTokenBetween(String value1, String value2) {
            return between(accessToken, value1, value2);
        }

        public JdSessionMapExample.Criteria andAccessTokenNotBetween(String value1, String value2) {
            return notBetween(accessToken, value1, value2);
        }
        public JdSessionMapExample.Criteria andRefreshTokenIsNull() {
            return isNull(refreshToken);
        }

        public JdSessionMapExample.Criteria andRefreshTokenIsNotNull() {
            return isNotNull(refreshToken);
        }

        public JdSessionMapExample.Criteria andRefreshTokenEqualTo(String value) {
            return equalTo(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenNotEqualTo(String value) {
            return notEqualTo(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenGreaterThan(String value) {
            return greaterThan(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenLessThan(String value) {
            return lessThan(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenLike(String value) {
            return like(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenNotLike(String value) {
            return notLike(refreshToken, value);
        }

        public JdSessionMapExample.Criteria andRefreshTokenIn(List<String> values) {
            return in(refreshToken, values);
        }

        public JdSessionMapExample.Criteria andRefreshTokenNotIn(List<String> values) {
            return notIn(refreshToken, values);
        }

        public JdSessionMapExample.Criteria andRefreshTokenBetween(String value1, String value2) {
            return between(refreshToken, value1, value2);
        }

        public JdSessionMapExample.Criteria andRefreshTokenNotBetween(String value1, String value2) {
            return notBetween(refreshToken, value1, value2);
        }
    }
}