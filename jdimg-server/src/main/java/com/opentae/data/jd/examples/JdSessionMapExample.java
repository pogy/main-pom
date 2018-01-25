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
    public static EntityColumn jdUserNick;
    public static EntityColumn jdUid;
    public static EntityColumn gmtModify;
    public static EntityColumn authTime;
    public static EntityColumn id;
    public static EntityColumn accessToken;
    public static EntityColumn gmtCreate;
    public static EntityColumn refreshToken;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        expiresIn = listMap.get("expiresIn");
        jdUserNick = listMap.get("jdUserNick");
        jdUid = listMap.get("jdUid");
        gmtModify = listMap.get("gmtModify");
        authTime = listMap.get("authTime");
        id = listMap.get("id");
        accessToken = listMap.get("accessToken");
        gmtCreate = listMap.get("gmtCreate");
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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public Criteria andExpiresInEqualTo(Integer value) {
            return equalTo(expiresIn, value);
        }

        public Criteria andExpiresInNotEqualTo(Integer value) {
            return notEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInGreaterThan(Integer value) {
            return greaterThan(expiresIn, value);
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInLessThan(Integer value) {
            return lessThan(expiresIn, value);
        }

        public Criteria andExpiresInLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public Criteria andExpiresInIn(List<Integer> values) {
            return in(expiresIn, values);
        }

        public Criteria andExpiresInNotIn(List<Integer> values) {
            return notIn(expiresIn, values);
        }

        public Criteria andExpiresInBetween(Integer value1, Integer value2) {
            return between(expiresIn, value1, value2);
        }

        public Criteria andExpiresInNotBetween(Integer value1, Integer value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public Criteria andJdUserNickIsNull() {
            return isNull(jdUserNick);
        }

        public Criteria andJdUserNickIsNotNull() {
            return isNotNull(jdUserNick);
        }

        public Criteria andJdUserNickEqualTo(String value) {
            return equalTo(jdUserNick, value);
        }

        public Criteria andJdUserNickNotEqualTo(String value) {
            return notEqualTo(jdUserNick, value);
        }

        public Criteria andJdUserNickGreaterThan(String value) {
            return greaterThan(jdUserNick, value);
        }

        public Criteria andJdUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdUserNick, value);
        }

        public Criteria andJdUserNickLessThan(String value) {
            return lessThan(jdUserNick, value);
        }

        public Criteria andJdUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdUserNick, value);
        }

        public Criteria andJdUserNickLike(String value) {
            return like(jdUserNick, value);
        }

        public Criteria andJdUserNickNotLike(String value) {
            return notLike(jdUserNick, value);
        }

        public Criteria andJdUserNickIn(List<String> values) {
            return in(jdUserNick, values);
        }

        public Criteria andJdUserNickNotIn(List<String> values) {
            return notIn(jdUserNick, values);
        }

        public Criteria andJdUserNickBetween(String value1, String value2) {
            return between(jdUserNick, value1, value2);
        }

        public Criteria andJdUserNickNotBetween(String value1, String value2) {
            return notBetween(jdUserNick, value1, value2);
        }
        public Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public Criteria andAuthTimeIsNull() {
            return isNull(authTime);
        }

        public Criteria andAuthTimeIsNotNull() {
            return isNotNull(authTime);
        }

        public Criteria andAuthTimeEqualTo(Date value) {
            return equalTo(authTime, value);
        }

        public Criteria andAuthTimeNotEqualTo(Date value) {
            return notEqualTo(authTime, value);
        }

        public Criteria andAuthTimeGreaterThan(Date value) {
            return greaterThan(authTime, value);
        }

        public Criteria andAuthTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(authTime, value);
        }

        public Criteria andAuthTimeLessThan(Date value) {
            return lessThan(authTime, value);
        }

        public Criteria andAuthTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(authTime, value);
        }

        public Criteria andAuthTimeIn(List<Date> values) {
            return in(authTime, values);
        }

        public Criteria andAuthTimeNotIn(List<Date> values) {
            return notIn(authTime, values);
        }

        public Criteria andAuthTimeBetween(Date value1, Date value2) {
            return between(authTime, value1, value2);
        }

        public Criteria andAuthTimeNotBetween(Date value1, Date value2) {
            return notBetween(authTime, value1, value2);
        }
        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andAccessTokenIsNull() {
            return isNull(accessToken);
        }

        public Criteria andAccessTokenIsNotNull() {
            return isNotNull(accessToken);
        }

        public Criteria andAccessTokenEqualTo(String value) {
            return equalTo(accessToken, value);
        }

        public Criteria andAccessTokenNotEqualTo(String value) {
            return notEqualTo(accessToken, value);
        }

        public Criteria andAccessTokenGreaterThan(String value) {
            return greaterThan(accessToken, value);
        }

        public Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accessToken, value);
        }

        public Criteria andAccessTokenLessThan(String value) {
            return lessThan(accessToken, value);
        }

        public Criteria andAccessTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accessToken, value);
        }

        public Criteria andAccessTokenLike(String value) {
            return like(accessToken, value);
        }

        public Criteria andAccessTokenNotLike(String value) {
            return notLike(accessToken, value);
        }

        public Criteria andAccessTokenIn(List<String> values) {
            return in(accessToken, values);
        }

        public Criteria andAccessTokenNotIn(List<String> values) {
            return notIn(accessToken, values);
        }

        public Criteria andAccessTokenBetween(String value1, String value2) {
            return between(accessToken, value1, value2);
        }

        public Criteria andAccessTokenNotBetween(String value1, String value2) {
            return notBetween(accessToken, value1, value2);
        }
        public Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
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
    }
}