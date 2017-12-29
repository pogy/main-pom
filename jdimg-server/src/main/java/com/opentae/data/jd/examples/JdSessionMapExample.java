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

        public JdSessionMapExample.Criteria andExpiresInEqualTo(Integer value) {
            return equalTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInNotEqualTo(Integer value) {
            return notEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInGreaterThan(Integer value) {
            return greaterThan(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInLessThan(Integer value) {
            return lessThan(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public JdSessionMapExample.Criteria andExpiresInIn(List<Integer> values) {
            return in(expiresIn, values);
        }

        public JdSessionMapExample.Criteria andExpiresInNotIn(List<Integer> values) {
            return notIn(expiresIn, values);
        }

        public JdSessionMapExample.Criteria andExpiresInBetween(Integer value1, Integer value2) {
            return between(expiresIn, value1, value2);
        }

        public JdSessionMapExample.Criteria andExpiresInNotBetween(Integer value1, Integer value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public JdSessionMapExample.Criteria andJdUserNickIsNull() {
            return isNull(jdUserNick);
        }

        public JdSessionMapExample.Criteria andJdUserNickIsNotNull() {
            return isNotNull(jdUserNick);
        }

        public JdSessionMapExample.Criteria andJdUserNickEqualTo(String value) {
            return equalTo(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickNotEqualTo(String value) {
            return notEqualTo(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickGreaterThan(String value) {
            return greaterThan(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickLessThan(String value) {
            return lessThan(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickLike(String value) {
            return like(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickNotLike(String value) {
            return notLike(jdUserNick, value);
        }

        public JdSessionMapExample.Criteria andJdUserNickIn(List<String> values) {
            return in(jdUserNick, values);
        }

        public JdSessionMapExample.Criteria andJdUserNickNotIn(List<String> values) {
            return notIn(jdUserNick, values);
        }

        public JdSessionMapExample.Criteria andJdUserNickBetween(String value1, String value2) {
            return between(jdUserNick, value1, value2);
        }

        public JdSessionMapExample.Criteria andJdUserNickNotBetween(String value1, String value2) {
            return notBetween(jdUserNick, value1, value2);
        }
        public JdSessionMapExample.Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public JdSessionMapExample.Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public JdSessionMapExample.Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public JdSessionMapExample.Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public JdSessionMapExample.Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public JdSessionMapExample.Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public JdSessionMapExample.Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public JdSessionMapExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public JdSessionMapExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public JdSessionMapExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public JdSessionMapExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public JdSessionMapExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public JdSessionMapExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public JdSessionMapExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public JdSessionMapExample.Criteria andAuthTimeIsNull() {
            return isNull(authTime);
        }

        public JdSessionMapExample.Criteria andAuthTimeIsNotNull() {
            return isNotNull(authTime);
        }

        public JdSessionMapExample.Criteria andAuthTimeEqualTo(Date value) {
            return equalTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotEqualTo(Date value) {
            return notEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeGreaterThan(Date value) {
            return greaterThan(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeLessThan(Date value) {
            return lessThan(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(authTime, value);
        }

        public JdSessionMapExample.Criteria andAuthTimeIn(List<Date> values) {
            return in(authTime, values);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotIn(List<Date> values) {
            return notIn(authTime, values);
        }

        public JdSessionMapExample.Criteria andAuthTimeBetween(Date value1, Date value2) {
            return between(authTime, value1, value2);
        }

        public JdSessionMapExample.Criteria andAuthTimeNotBetween(Date value1, Date value2) {
            return notBetween(authTime, value1, value2);
        }
        public JdSessionMapExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public JdSessionMapExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public JdSessionMapExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public JdSessionMapExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public JdSessionMapExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public JdSessionMapExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public JdSessionMapExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public JdSessionMapExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public JdSessionMapExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public JdSessionMapExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public JdSessionMapExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public JdSessionMapExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
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
        public JdSessionMapExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public JdSessionMapExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public JdSessionMapExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public JdSessionMapExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public JdSessionMapExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public JdSessionMapExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public JdSessionMapExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
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