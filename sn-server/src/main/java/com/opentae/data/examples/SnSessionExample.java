package com.opentae.data.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.beans.SnSession;

import java.util.*;
public class SnSessionExample extends SgExample<SnSessionExample.Criteria> {
    public static final Class<SnSession> beanClass = SnSession.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn expiresIn;
    public static EntityColumn gmtModif;
    public static EntityColumn module;
    public static EntityColumn custnum;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn accessToken;
    public static EntityColumn userName;
    public static EntityColumn tokenType;
    public static EntityColumn refreshToken;
    public static EntityColumn vendorCode;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        expiresIn = listMap.get("expiresIn");
        gmtModif = listMap.get("gmtModif");
        module = listMap.get("module");
        custnum = listMap.get("custnum");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        accessToken = listMap.get("accessToken");
        userName = listMap.get("userName");
        tokenType = listMap.get("tokenType");
        refreshToken = listMap.get("refreshToken");
        vendorCode = listMap.get("vendorCode");
        }

    public SnSessionExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SnSessionExample.Criteria createCriteriaInternal() {
        return new SnSessionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SnSessionExample.Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public SnSessionExample.Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public SnSessionExample.Criteria andExpiresInEqualTo(Integer value) {
            return equalTo(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInNotEqualTo(Integer value) {
            return notEqualTo(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInGreaterThan(Integer value) {
            return greaterThan(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInLessThan(Integer value) {
            return lessThan(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public SnSessionExample.Criteria andExpiresInIn(List<Integer> values) {
            return in(expiresIn, values);
        }

        public SnSessionExample.Criteria andExpiresInNotIn(List<Integer> values) {
            return notIn(expiresIn, values);
        }

        public SnSessionExample.Criteria andExpiresInBetween(Integer value1, Integer value2) {
            return between(expiresIn, value1, value2);
        }

        public SnSessionExample.Criteria andExpiresInNotBetween(Integer value1, Integer value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public SnSessionExample.Criteria andGmtModifIsNull() {
            return isNull(gmtModif);
        }

        public SnSessionExample.Criteria andGmtModifIsNotNull() {
            return isNotNull(gmtModif);
        }

        public SnSessionExample.Criteria andGmtModifEqualTo(Date value) {
            return equalTo(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifNotEqualTo(Date value) {
            return notEqualTo(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifGreaterThan(Date value) {
            return greaterThan(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifLessThan(Date value) {
            return lessThan(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModif, value);
        }

        public SnSessionExample.Criteria andGmtModifIn(List<Date> values) {
            return in(gmtModif, values);
        }

        public SnSessionExample.Criteria andGmtModifNotIn(List<Date> values) {
            return notIn(gmtModif, values);
        }

        public SnSessionExample.Criteria andGmtModifBetween(Date value1, Date value2) {
            return between(gmtModif, value1, value2);
        }

        public SnSessionExample.Criteria andGmtModifNotBetween(Date value1, Date value2) {
            return notBetween(gmtModif, value1, value2);
        }
        public SnSessionExample.Criteria andModuleIsNull() {
            return isNull(module);
        }

        public SnSessionExample.Criteria andModuleIsNotNull() {
            return isNotNull(module);
        }

        public SnSessionExample.Criteria andModuleEqualTo(Integer value) {
            return equalTo(module, value);
        }

        public SnSessionExample.Criteria andModuleNotEqualTo(Integer value) {
            return notEqualTo(module, value);
        }

        public SnSessionExample.Criteria andModuleGreaterThan(Integer value) {
            return greaterThan(module, value);
        }

        public SnSessionExample.Criteria andModuleGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(module, value);
        }

        public SnSessionExample.Criteria andModuleLessThan(Integer value) {
            return lessThan(module, value);
        }

        public SnSessionExample.Criteria andModuleLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(module, value);
        }

        public SnSessionExample.Criteria andModuleIn(List<Integer> values) {
            return in(module, values);
        }

        public SnSessionExample.Criteria andModuleNotIn(List<Integer> values) {
            return notIn(module, values);
        }

        public SnSessionExample.Criteria andModuleBetween(Integer value1, Integer value2) {
            return between(module, value1, value2);
        }

        public SnSessionExample.Criteria andModuleNotBetween(Integer value1, Integer value2) {
            return notBetween(module, value1, value2);
        }
        public SnSessionExample.Criteria andCustnumIsNull() {
            return isNull(custnum);
        }

        public SnSessionExample.Criteria andCustnumIsNotNull() {
            return isNotNull(custnum);
        }

        public SnSessionExample.Criteria andCustnumEqualTo(Long value) {
            return equalTo(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumNotEqualTo(Long value) {
            return notEqualTo(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumGreaterThan(Long value) {
            return greaterThan(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumLessThan(Long value) {
            return lessThan(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(custnum, value);
        }

        public SnSessionExample.Criteria andCustnumIn(List<Long> values) {
            return in(custnum, values);
        }

        public SnSessionExample.Criteria andCustnumNotIn(List<Long> values) {
            return notIn(custnum, values);
        }

        public SnSessionExample.Criteria andCustnumBetween(Long value1, Long value2) {
            return between(custnum, value1, value2);
        }

        public SnSessionExample.Criteria andCustnumNotBetween(Long value1, Long value2) {
            return notBetween(custnum, value1, value2);
        }
        public SnSessionExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public SnSessionExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public SnSessionExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public SnSessionExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public SnSessionExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public SnSessionExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public SnSessionExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public SnSessionExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public SnSessionExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public SnSessionExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public SnSessionExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public SnSessionExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public SnSessionExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public SnSessionExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public SnSessionExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public SnSessionExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public SnSessionExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public SnSessionExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public SnSessionExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public SnSessionExample.Criteria andAccessTokenIsNull() {
            return isNull(accessToken);
        }

        public SnSessionExample.Criteria andAccessTokenIsNotNull() {
            return isNotNull(accessToken);
        }

        public SnSessionExample.Criteria andAccessTokenEqualTo(String value) {
            return equalTo(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenNotEqualTo(String value) {
            return notEqualTo(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenGreaterThan(String value) {
            return greaterThan(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenLessThan(String value) {
            return lessThan(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenLike(String value) {
            return like(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenNotLike(String value) {
            return notLike(accessToken, value);
        }

        public SnSessionExample.Criteria andAccessTokenIn(List<String> values) {
            return in(accessToken, values);
        }

        public SnSessionExample.Criteria andAccessTokenNotIn(List<String> values) {
            return notIn(accessToken, values);
        }

        public SnSessionExample.Criteria andAccessTokenBetween(String value1, String value2) {
            return between(accessToken, value1, value2);
        }

        public SnSessionExample.Criteria andAccessTokenNotBetween(String value1, String value2) {
            return notBetween(accessToken, value1, value2);
        }
        public SnSessionExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public SnSessionExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public SnSessionExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public SnSessionExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public SnSessionExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public SnSessionExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public SnSessionExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public SnSessionExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public SnSessionExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public SnSessionExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public SnSessionExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public SnSessionExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public SnSessionExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public SnSessionExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public SnSessionExample.Criteria andTokenTypeIsNull() {
            return isNull(tokenType);
        }

        public SnSessionExample.Criteria andTokenTypeIsNotNull() {
            return isNotNull(tokenType);
        }

        public SnSessionExample.Criteria andTokenTypeEqualTo(String value) {
            return equalTo(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeNotEqualTo(String value) {
            return notEqualTo(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeGreaterThan(String value) {
            return greaterThan(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeLessThan(String value) {
            return lessThan(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeLike(String value) {
            return like(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeNotLike(String value) {
            return notLike(tokenType, value);
        }

        public SnSessionExample.Criteria andTokenTypeIn(List<String> values) {
            return in(tokenType, values);
        }

        public SnSessionExample.Criteria andTokenTypeNotIn(List<String> values) {
            return notIn(tokenType, values);
        }

        public SnSessionExample.Criteria andTokenTypeBetween(String value1, String value2) {
            return between(tokenType, value1, value2);
        }

        public SnSessionExample.Criteria andTokenTypeNotBetween(String value1, String value2) {
            return notBetween(tokenType, value1, value2);
        }
        public SnSessionExample.Criteria andRefreshTokenIsNull() {
            return isNull(refreshToken);
        }

        public SnSessionExample.Criteria andRefreshTokenIsNotNull() {
            return isNotNull(refreshToken);
        }

        public SnSessionExample.Criteria andRefreshTokenEqualTo(String value) {
            return equalTo(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenNotEqualTo(String value) {
            return notEqualTo(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenGreaterThan(String value) {
            return greaterThan(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenLessThan(String value) {
            return lessThan(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenLike(String value) {
            return like(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenNotLike(String value) {
            return notLike(refreshToken, value);
        }

        public SnSessionExample.Criteria andRefreshTokenIn(List<String> values) {
            return in(refreshToken, values);
        }

        public SnSessionExample.Criteria andRefreshTokenNotIn(List<String> values) {
            return notIn(refreshToken, values);
        }

        public SnSessionExample.Criteria andRefreshTokenBetween(String value1, String value2) {
            return between(refreshToken, value1, value2);
        }

        public SnSessionExample.Criteria andRefreshTokenNotBetween(String value1, String value2) {
            return notBetween(refreshToken, value1, value2);
        }
        public SnSessionExample.Criteria andVendorCodeIsNull() {
            return isNull(vendorCode);
        }

        public SnSessionExample.Criteria andVendorCodeIsNotNull() {
            return isNotNull(vendorCode);
        }

        public SnSessionExample.Criteria andVendorCodeEqualTo(String value) {
            return equalTo(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeNotEqualTo(String value) {
            return notEqualTo(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeGreaterThan(String value) {
            return greaterThan(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeLessThan(String value) {
            return lessThan(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeLike(String value) {
            return like(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeNotLike(String value) {
            return notLike(vendorCode, value);
        }

        public SnSessionExample.Criteria andVendorCodeIn(List<String> values) {
            return in(vendorCode, values);
        }

        public SnSessionExample.Criteria andVendorCodeNotIn(List<String> values) {
            return notIn(vendorCode, values);
        }

        public SnSessionExample.Criteria andVendorCodeBetween(String value1, String value2) {
            return between(vendorCode, value1, value2);
        }

        public SnSessionExample.Criteria andVendorCodeNotBetween(String value1, String value2) {
            return notBetween(vendorCode, value1, value2);
        }
    }
}